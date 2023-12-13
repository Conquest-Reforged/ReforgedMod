package com.conquestrefabricated.core.block.factory;

import com.conquestrefabricated.core.block.builder.BlockName;
import com.conquestrefabricated.core.block.builder.Props;
import com.conquestrefabricated.core.block.data.BlockData;
import com.conquestrefabricated.core.block.data.BlockDataRegistry;
import com.conquestrefabricated.core.block.data.BlockTemplate;
import com.conquestrefabricated.core.block.data.BlockTemplateCache;
import com.conquestrefabricated.core.item.family.Family;
import com.conquestrefabricated.core.item.family.FamilyRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.registry.Registry;

public interface BlockFactory {

    Props getProps();

    BlockName getName();

    BlockState getParent();

    Family<Block> createFamily(TypeList types);

    default void register(TypeList types) {
        Family<Block> family = createFamily(types);
        for (Class<? extends Block> type : types) {
            BlockType blockType = BlockTypeCache.getInstance().get(type);
            BlockTemplate template = BlockTemplateCache.getInstance().get(type);
            BlockName name = getName();
            Props props = getProps().template(template);
            Block block = blockType.create(props);

            BlockData data = new BlockData(block, template, name, props);
            Registry.register(Registry.ITEM, data.getRegistryName(), data.getItem());
            BlockDataRegistry.getInstance().register(data);
            if (!getProps().hasParent()) {
                getProps().parent(data.getBlock().getDefaultState());
            }
            family.add(data.getBlock());
        }
        FamilyRegistry.BLOCKS.register(family);
    }
}
