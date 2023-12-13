package com.conquestrefabricated.core.item.group.manager;

import com.conquestrefabricated.core.item.group.ConquestItemGroup;
import com.conquestrefabricated.core.util.log.Log;
import com.google.common.collect.Lists;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.item.ItemGroup;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;

@Environment(EnvType.CLIENT)
public class ItemGroupManager {

    private static final ItemGroupManager instance = new ItemGroupManager();
    private static final List<ItemGroup> fixed = Lists.newArrayList(ItemGroup.SEARCH, ItemGroup.INVENTORY, ItemGroup.HOTBAR);

    static {
        fixed.sort(Comparator.comparing(ItemGroup::getIndex));
    }

    private final Map<Class<?>, Set<ItemGroup>> conquestGroups = new HashMap<>();
    private final Map<GroupType, Set<ItemGroup>> groups = new EnumMap<>(GroupType.class);


    public static void init() {
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
        ItemGroup.GROUPS = new ItemGroup[order.size()];
        for (int i = 0; i < order.size(); i++) {
            ItemGroup group = order.get(i);
            if (group == null) {
                new EmptyGroup();
            } else if (fixed.contains(group) || i == group.getIndex()) {
                ItemGroup.GROUPS[i] = group;
            } else {
                new DelegateGroup(i, group);
            }
        }

        for (int i = 0; i < ItemGroup.GROUPS.length; i++) {
            ItemGroup group = ItemGroup.GROUPS[i];
            if(group == null) {
                continue;
            }
            Log.debug("i:{}; index:{}; name:{}; class:{}", i, group.getIndex(), group.getName(), group.getClass());
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
