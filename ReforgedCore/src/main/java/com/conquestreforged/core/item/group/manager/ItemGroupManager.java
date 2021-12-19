package com.conquestreforged.core.item.group.manager;

import com.conquestreforged.core.item.group.ConquestItemGroup;
import com.conquestreforged.core.util.log.Log;
import com.google.common.collect.Lists;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;

@Mod.EventBusSubscriber(value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ItemGroupManager {

    private static final ItemGroupManager instance = new ItemGroupManager();
    private static final List<CreativeModeTab> fixed = Lists.newArrayList(CreativeModeTab.TAB_SEARCH, CreativeModeTab.TAB_INVENTORY, CreativeModeTab.TAB_HOTBAR);

    static {
        fixed.sort(Comparator.comparing(CreativeModeTab::getId));
    }

    private final Map<Class<?>, Set<CreativeModeTab>> conquestGroups = new HashMap<>();
    private final Map<GroupType, Set<CreativeModeTab>> groups = new EnumMap<>(GroupType.class);

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
        Set<CreativeModeTab> groupList = conquestGroups.getOrDefault(type, Collections.emptySet());
        groups.put(GroupType.CONQUEST, groupList);
    }

    public void setVisibleItemGroups(GroupType... types) {
        List<CreativeModeTab> order = new ArrayList<>();
        for (GroupType type : types) {
            Set<? extends CreativeModeTab> groupList = groups.get(type);
            order.addAll(sorted(groupList));
        }

        order.removeAll(fixed);

        for (CreativeModeTab required : fixed) {
            int index = required.getId();
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

        CreativeModeTab.TABS = new CreativeModeTab[0];
        for (int i = 0; i < order.size(); i++) {
            CreativeModeTab group = order.get(i);
            if (group == null) {
                new EmptyGroup();
            } else if (fixed.contains(group) || i == group.getId()) {
                addGroupSafe(i, group);
            } else {
                new DelegateGroup(group);
            }
        }

        for (int i = 0; i < CreativeModeTab.TABS.length; i++) {
            CreativeModeTab group = CreativeModeTab.TABS[i];
            Log.debug("i:{}; index:{}; name:{}; class:{}", i, group.getId(), group.getRecipeFolderName(), group.getClass());
        }
    }


    private void storeVanillaGroups() {
        Set<CreativeModeTab> groups = this.groups.get(GroupType.VANILLA);
        for (Field field : CreativeModeTab.class.getFields()) {
            if (Modifier.isStatic(field.getModifiers()) && field.getType() == CreativeModeTab.class) {
                try {
                    Object value = field.get(null);
                    CreativeModeTab group = (CreativeModeTab) value;
                    groups.add(group);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void storeModGroups() {
        Set<CreativeModeTab> vanilla = this.groups.get(GroupType.VANILLA);
        Set<CreativeModeTab> other = this.groups.get(GroupType.OTHER);
        for (CreativeModeTab group : CreativeModeTab.TABS) {
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

    private static List<CreativeModeTab> sorted(Collection<? extends CreativeModeTab> groups) {
        List<CreativeModeTab> list = new ArrayList<>(groups);
        list.sort(ItemGroupManager::sort);
        return list;
    }

    private static int sort(CreativeModeTab g1, CreativeModeTab g2) {
        if (g1 instanceof ConquestItemGroup && g2 instanceof ConquestItemGroup) {
            return ((ConquestItemGroup) g1).getOrderIndex() - ((ConquestItemGroup) g2).getOrderIndex();
        }
        return g1.getId() - g2.getId();
    }

    private static synchronized void addGroupSafe(int index, CreativeModeTab newGroup) {
        if (index == -1) {
            index = CreativeModeTab.TABS.length;
        }
        if (index >= CreativeModeTab.TABS.length) {
            CreativeModeTab[] tmp = new CreativeModeTab[index + 1];
            System.arraycopy(CreativeModeTab.TABS, 0, tmp, 0, CreativeModeTab.TABS.length);
            CreativeModeTab.TABS = tmp;
        }
        CreativeModeTab.TABS[index] = newGroup;
    }
}
