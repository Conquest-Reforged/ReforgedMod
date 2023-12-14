package com.conquestreforged.core.block.builder;

import com.conquestreforged.core.block.factory.InitializationException;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.DyeColor;

import java.util.function.Consumer;
import java.util.function.ToIntFunction;

/**
 * Basically just a wrapper around Block.Properties
 */
public abstract class BlockProps<T extends BlockProps<T>> {

    /**
     * Used internally to create the Block.Properties builder which requires an instance of either:
     * 1. a Block
     * 2. a Material & MaterialColor
     * 3. just a Material
     */
    private final Block block;
    private final Material material;
    private final MapColor color;

    private DyeColor dyeColor = null;
    private BlockSoundGroup sound = null;
    private ItemGroup group = ItemGroup.SEARCH;
    private ToIntFunction<BlockState> light = null;
    private Float resistance = null;
    private Float hardness = null;
    private Float slipperiness = null;
    private Boolean randomTick = null;
    private Boolean variableOpacity = null;
    private Boolean dynamicBounds = null;
    private Boolean blocksMovement = null;
    private Boolean solid = null;

    protected BlockProps(Block block) {
        this.block = block;
        this.color = null;
        this.material = null;
    }

    protected BlockProps(Material material) {
        this.block = null;
        this.color = null;
        this.material = material;
    }

    protected BlockProps(Material material, MapColor color) {
        this.block = null;
        this.color = color;
        this.material = material;
    }

    protected BlockProps(BlockProps<T> props) {
        this.block = props.block;
        this.material = props.material;
        this.color = props.color;
        this.dyeColor = props.dyeColor;
        this.sound = props.sound;
        this.group = props.group;
        this.light = props.light;
        this.resistance = props.resistance;
        this.hardness = props.hardness;
        this.slipperiness = props.slipperiness;
        this.randomTick = props.randomTick;
        this.variableOpacity = props.variableOpacity;
        this.blocksMovement = props.blocksMovement;
        this.dynamicBounds = props.dynamicBounds;
        this.solid = props.solid;
    }

    public abstract T getProps();

    public T dye(DyeColor color) {
        this.dyeColor = color;
        return getProps();
    }

    public T sound(BlockSoundGroup sound) {
        this.sound = sound;
        return getProps();
    }

    public T light(ToIntFunction<BlockState> light) {
        this.light = light;
        return (T) this;
    }

    public T strength(double hardness, double resistance) {
        this.hardness = (float) hardness;
        this.resistance = (float) resistance;
        return getProps();
    }

    public T slipperiness(double slipperiness) {
        this.slipperiness = (float) slipperiness;
        return getProps();
    }

    public T randomTick(boolean randomTick) {
        this.randomTick = randomTick;
        return getProps();
    }

    public T dynamicBounds(boolean dynamicBounds) {
        this.dynamicBounds = dynamicBounds;
        return getProps();
    }

    public T opacity(boolean variableOpacity) {
        this.variableOpacity = variableOpacity;
        return getProps();
    }

    public T blocking(boolean blocksMovement) {
        this.blocksMovement = blocksMovement;
        return getProps();
    }

    public T solid(boolean solid) {
        this.solid = solid;
        return getProps();
    }

    public T group(ItemGroup group) {
        this.group = group;
        return getProps();
    }

    public ItemGroup group() {
        return group;
    }

    public DyeColor dye() {
        return dyeColor == null ? DyeColor.BLACK : dyeColor;
    }

    public MapColor color() {
        return color == null ? MapColor.BLACK : color;
    }

    public Block.Settings toSettings() throws InitializationException {
        Block.Settings builder = createBuilder();
        applyNonNull(sound, builder::sounds);
        applyNonNull(light, builder::luminance);
        applyNonNull(slipperiness, builder::slipperiness);
        applyNonNull(solid, false, builder::nonOpaque);
        applyNonNull(randomTick, true, builder::ticksRandomly);

        applyNonNull(dynamicBounds, true, builder::dynamicBounds);
        applyNonNull(variableOpacity, true, builder::dynamicBounds);
        applyNonNull(blocksMovement, false, builder::noCollision);
        if (hardness != null && resistance != null) {
            builder.strength(hardness, resistance);
        }
        return builder;
    }


    private Block.Settings createBuilder() throws InitializationException {
        Block.Settings props;

        if (block != null) {
            props = Block.Settings.copy(block);
        } else if (color != null && material != null) {
            props = Block.Settings.of(material, color);
        } else if (material != null) {
            props = Block.Settings.of(material);
        } else {
            throw new InitializationException("Block.Builder requires a Material");
        }

        return props;
    }

    private static <T> void applyNonNull(Boolean value, boolean condition, Runnable runnable) {
        if (value != null && value == condition) {
            runnable.run();
        }
    }

    private static <T> void applyNonNull(T value, Consumer<T> consumer) {
        if (value != null) {
            consumer.accept(value);
        }
    }

    //todo finish this i guess?
    protected abstract <T> void applyNonNull(Integer light, Consumer<T> lightLevel);

}
