package com.conquestreforged.core.item.group.manager;

import com.conquestreforged.core.item.group.ConquestItemGroup;
import com.conquestreforged.core.util.log.Log;
import com.google.common.collect.Lists;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Mod.EventBusSubscriber(value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ItemGroupManager {

    private static final ItemGroupManager instance = new ItemGroupManager();
    private static final List<ItemGroup> fixed = Lists.newArrayList(ItemGroup.SEARCH, ItemGroup.INVENTORY, ItemGroup.HOTBAR);

    static {
        fixed.sort(Comparator.comparing(ItemGroup::getIndex));
    }

    private final Map<Class<?>, Set<ItemGroup>> conquestGroups = new HashMap<>();
    private final Map<GroupType, Set<ItemGroup>> groups = new EnumMap<>(GroupType.class);

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void init(FMLClientSetupEvent event) {
        instance.storeVanillaGroups();
        instance.storeModGroups();
    }

    private ItemGroupManager() {
        for (GroupType type : GroupType.values()) {
            groups.put(type, new HashSet<>());
        }
    }

    public void register(ConquestItemGroup group) {
        conquestGroups.computeIfAbsent(group.getClass(), k -> new HashSet<>()).add(group);
        groups.put(GroupType.CONQUEST, conquestGroups.get(group.getClass()));
    }

    public void setConquestType(Class<? extends ConquestItemGroup> type) {
        Set<ItemGroup> groupList = conquestGroups.getOrDefault(type, Collections.emptySet());
        groups.put(GroupType.CONQUEST, groupList);
    }

    public void setVisibleItemGroups(GroupType... types) {
        List<ItemGroup> order = new ArrayList<>();
        for (GroupType type : types) {
            Set<? extends ItemGroup> groupList = groups.get(type);
            order.addAll(sorted(groupList));
        }

        order.removeAll(fixed);

        for (ItemGroup required : fixed) {
            int index = required.getIndex();
            if (index < order.size()) {
                order.add(index, required);
            } else if (index == order.size()) {
                order.add(required);
            } else {
                while (order.size() < index) {
                    order.add(null);
                }
                order.set(index, required);
            }
        }

        ItemGroup.GROUPS = new ItemGroup[0];
        for (int i = 0; i < order.size(); i++) {
            ItemGroup group = order.get(i);
            if (group == null) {
                new EmptyGroup();
            } else if (fixed.contains(group) || i == group.getIndex()) {
                addGroupSafe(i, group);
            } else {
                new DelegateGroup(group);
            }
        }

        for (int i = 0; i < ItemGroup.GROUPS.length; i++) {
            ItemGroup group = ItemGroup.GROUPS[i];
            Log.debug("i:{}; index:{}; name:{}; class:{}", i, group.getIndex(), group.getTabLabel(), group.getClass());
        }
    }


    private void storeVanillaGroups() {
        Set<ItemGroup> groups = this.groups.get(GroupType.VANILLA);
        for (Field field : ItemGroup.class.getFields()) {
            if (Modifier.isStatic(field.getModifiers()) && field.getType() == ItemGroup.class) {
                try {
                    Object value = field.get(null);
                    ItemGroup group = (ItemGroup) value;
                    groups.add(group);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void storeModGroups() {
        Set<ItemGroup> vanilla = this.groups.get(GroupType.VANILLA);
        Set<ItemGroup> other = this.groups.get(GroupType.OTHER);
        for (ItemGroup group : ItemGroup.GROUPS) {
            if (vanilla.contains(group)) {
                continue;
            }
            if (group instanceof ConquestItemGroup || group instanceof DelegateGroup) {
                continue;
            }
            other.add(group);
        }
    }

    public static ItemGroupManager getInstance() {
        return instance;
    }

    private static List<ItemGroup> sorted(Collection<? extends ItemGroup> groups) {
        List<ItemGroup> list = new ArrayList<>(groups);
        list.sort(ItemGroupManager::sort);
        return list;
    }

    private static int sort(ItemGroup g1, ItemGroup g2) {
        if (g1 instanceof ConquestItemGroup && g2 instanceof ConquestItemGroup) {
            return ((ConquestItemGroup) g1).getOrderIndex() - ((ConquestItemGroup) g2).getOrderIndex();
        }
        return g1.getIndex() - g2.getIndex();
    }

    private static synchronized void addGroupSafe(int index, ItemGroup newGroup) {
        if (index == -1) {
            index = ItemGroup.GROUPS.length;
        }
        if (index >= ItemGroup.GROUPS.length) {
            ItemGroup[] tmp = new ItemGroup[index + 1];
            System.arraycopy(ItemGroup.GROUPS, 0, tmp, 0, ItemGroup.GROUPS.length);
            ItemGroup.GROUPS = tmp;
        }
        ItemGroup.GROUPS[index] = newGroup;
    }
}
