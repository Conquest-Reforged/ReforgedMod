package com.conquestreforged.core.block.builder;

import com.conquestreforged.core.block.factory.InitializationException;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.DyeColor;
import net.minecraft.item.ItemGroup;

import java.util.function.Consumer;

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
    private final MaterialColor color;
    
    private BlockName name = null;
    private DyeColor dyeColor = null;
    private SoundType sound = null;
    private ItemGroup group = ItemGroup.SEARCH;
    private Integer light = null;
    private Float resistance = null;
    private Float hardness = null;
    private Float slipperiness = null;
    private Boolean randomTick = null;
    private Boolean variableOpacity = null;
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

    protected BlockProps(Material material, MaterialColor color) {
        this.block = null;
        this.color = color;
        this.material = material;
    }

    protected BlockProps(BlockProps<T> props) {
        this.block = props.block;
        this.material = props.material;
        this.color = props.color;
        this.name = props.name;
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
        this.solid = props.solid;
    }
    
    public abstract T getProps();

    public T dye(DyeColor color) {
        this.dyeColor = color;
        return getProps();
    }

    public T sound(SoundType sound) {
        this.sound = sound;
        return getProps();
    }

    public T light(int light) {
        this.light = light;
        return getProps();
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

    public MaterialColor color() {
        return color == null ? MaterialColor.BLACK : color;
    }

    public Block.Properties toProperties() throws InitializationException {
        Block.Properties builder = createBuilder();
        applyNonNull(sound, builder::sound);
        applyNonNull(light, builder::lightValue);
        applyNonNull(slipperiness, builder::slipperiness);
        applyNonNull(solid, false, builder::func_226896_b_);
        applyNonNull(randomTick, true, builder::tickRandomly);
        applyNonNull(variableOpacity, true, builder::variableOpacity);
        applyNonNull(blocksMovement, false, builder::doesNotBlockMovement);
        if (hardness != null && resistance != null) {
            builder.hardnessAndResistance(hardness, resistance);
        }
        return builder;
    }

    private Block.Properties createBuilder() throws InitializationException {
        Block.Properties props;

        if (block != null) {
            props = Block.Properties.from(block);
        } else if (color != null && material != null) {
            props = Block.Properties.create(material, color);
        } else if (material != null) {
            props = Block.Properties.create(material);
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
}
