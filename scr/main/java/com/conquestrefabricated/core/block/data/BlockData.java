package com.conquestrefabricated.core.block.data;

import com.conquestrefabricated.core.asset.pack.VirtualResourcepack;
import com.conquestrefabricated.core.block.builder.BlockName;
import com.conquestrefabricated.core.block.builder.Props;
import com.conquestrefabricated.core.block.factory.InitializationException;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.lang.reflect.Constructor;

public class BlockData {

    private final Block block;
    private final Props props;
    private final BlockName blockName;
    private final BlockTemplate template;
    private final Identifier registryName;

    private Item item = null;

    public BlockData(Block block, BlockTemplate template, BlockName blockName, Props props) {
        this.template = template;
        this.registryName = template.getRegistryName(blockName);
        this.blockName = blockName;
        this.block = block;
        this.props = props;
        Registry.register(Registry.BLOCK, this.registryName, this.block);
    }

    public Block getBlock() {
        return block;
    }

    public Item getItem() throws InitializationException {
        if (item == null) {
            Item.Settings properties = new Item.Settings();
            properties.group(props.group());

            try {
                Class<? extends Item> type = ItemTypeCache.getInstance().get(block.getClass());
                Constructor<? extends Item> constructor = type.getConstructor(Block.class, Item.Settings.class);
                item = constructor.newInstance(getBlock(), properties);

                return item;
            } catch (Throwable t) {
                throw new InitializationException(t);
            }
        }
        return item;
    }

    public Props getProps() {
        return props;
    }

    public BlockName getBlockName() {
        return blockName;
    }

    public Identifier getRegistryName() {
        return registryName;
    }

    public void addClientResources(VirtualResourcepack.Builder builder) {
        if (!props.isManual()) {
            template.addClientResources(builder, blockName, props.textures(), registryName);
        }
    }

    public void addServerResources(VirtualResourcepack.Builder builder) {
        if (!props.isManual()) {
            template.addServerResources(builder, blockName, registryName);
        }
    }

    public void addRenders() {
        template.registerRenders(block, props);
    }
}
