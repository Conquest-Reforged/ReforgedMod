package com.conquestreforged.core.block.factory;

import com.conquestreforged.core.block.builder.BlockName;
import com.conquestreforged.core.block.builder.Props;
import com.conquestreforged.core.block.data.BlockData;
import com.conquestreforged.core.block.data.BlockDataRegistry;
import com.conquestreforged.core.block.data.BlockTemplate;
import com.conquestreforged.core.block.data.BlockTemplateCache;
import com.conquestreforged.core.item.family.Family;
import com.conquestreforged.core.item.family.FamilyRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;

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
            BlockDataRegistry.getInstance().register(data);
            if (!getProps().hasParent()) {
                getProps().parent(data.getBlock().getDefaultState());
            }
            family.add(data.getBlock());
        }
        FamilyRegistry.BLOCKS.register(family);
    }
}
