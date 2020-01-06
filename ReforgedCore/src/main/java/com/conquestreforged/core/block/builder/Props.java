package com.conquestreforged.core.block.builder;

import com.conquestreforged.core.block.data.BlockTemplate;
import com.conquestreforged.core.block.data.ColorType;
import com.conquestreforged.core.block.factory.BlockFactory;
import com.conquestreforged.core.block.factory.InitializationException;
import com.conquestreforged.core.init.Context;
import com.google.common.base.Preconditions;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.DyeColor;
import net.minecraft.item.ItemGroup;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class Props implements BlockFactory {

    /**
     * Used internally to create the Block.Properties builder which requires an instance of either:
     * 1. a Block
     * 2. a Material & MaterialColor
     * 3. just a Material
     */
    private final Block block;
    private final Material material;
    private final MaterialColor color;

    /**
     * Certain Block constructor methods need a BlockState passing to them, ie a 'parent'.
     * For example, Slabs need the full-block instance passing to them to act as the double-slab variant.
     *
     * In cases where the first Block created with the Factory requires a parent Block/BlockState,
     * the 'parent' must be set manually before calling the register(..) methods.
     *
     * We otherwise assume the first Block created with this Factory is the parent.
     * This Block should therefore NOT require a parent Block or BlockState in it's own constructor.
     */
    private BlockState parent = null;

    private BlockName name = null;
    private DyeColor dyeColor = null;
    private SoundType sound = null;
    private ItemGroup group = ItemGroup.SEARCH;
    private int light = Integer.MAX_VALUE;
    private float resistance = Float.MAX_VALUE;
    private float hardness = Float.MAX_VALUE;
    private float slipperiness = Float.MAX_VALUE;
    private boolean randomTick = false;
    private boolean variableOpacity = false;
    private boolean blocksMovement = true;
    private boolean floats = true;
    private boolean solid = true;

    private ColorType colorType = ColorType.NONE;
    private Textures.Builder textures;
    private Map<String, Object> extradata = Collections.emptyMap();

    private boolean manual = false;

    private Props(Block block) {
        this.block = block;
        this.material = null;
        this.color = null;
    }

    private Props(Material material) {
        this.block = null;
        this.material = material;
        this.color = null;
    }

    private Props(Material material, MaterialColor color) {
        this.block = null;
        this.material = material;
        this.color = color;
    }

    @Override
    public Props getProps() {
        return this;
    }

    @Override
    public BlockName getName() {
        if (name == null) {
            throw new InitializationException("Block name is null");
        }
        return name;
    }

    @Override
    public BlockState getParent() throws InitializationException {
        if (parent == null) {
            throw new InitializationException("Parent state is null");
        }
        return parent;
    }

    public ColorType getColorType() {
        return colorType;
    }

    public DyeColor dye() {
        return dyeColor == null ? DyeColor.BLACK : dyeColor;
    }

    public MaterialColor color() {
        return color == null ? MaterialColor.BLACK : color;
    }

    public Textures textures() {
        if (textures == null || textures.isEmpty()) {
            return Textures.NONE;
        }
        return textures.build();
    }

    public ItemGroup group() {
        return group;
    }

    public boolean isManual() {
        return manual;
    }

    public boolean floats() {
        return floats;
    }

    public boolean hasParent() {
        return parent != null;
    }

    public <T> T get(String key, Class<T> type) {
        Object o = extradata.get(key);
        if (o == null) {
            throw new InitializationException(
                    new NullPointerException(key + ": value is null")
            );
        }
        if (!type.isInstance(o)) {
            throw new InitializationException(
                    new ClassCastException(key + ": expected " + type + " but found " + o.getClass())
            );
        }
        return type.cast(o);
    }

    public Props manual() {
        manual = true;
        return this;
    }

    /**
     * Set the 'parent' (usually the full-block variant) of all subsequent Blocks created by this factory.
     *
     * If not set manually, the first Block instance created by this Factory will be set as the parent. In this case,
     * it's critical that this first Block does not itself require a parent Block/BlockState in it's constructor.
     *
     * @param state The parent BlockState to use
     * @return this Props instance (for chaining calls)
     */
    public Props parent(BlockState state) {
        this.parent = state;
        return this;
    }

    public Props name(String namespace, String plural, String singular) {
        return name(BlockName.of(namespace, plural, singular));
    }

    public Props name(String plural, String singular) {
        return name(Context.getInstance().getNamespace(), plural, singular);
    }

    public Props name(String name) {
        return name(Context.getInstance().getNamespace(), name, name);
    }

    public Props name(BlockName name) {
        this.name = name;
        return this;
    }

    public Props dye(DyeColor color) {
        this.dyeColor = color;
        return this;
    }

    public Props sound(SoundType sound) {
        this.sound = sound;
        return this;
    }

    public Props light(int light) {
        this.light = light;
        return this;
    }

    public Props strength(double hardness, double resistance) {
        this.hardness = (float) hardness;
        this.resistance = (float) resistance;
        return this;
    }

    public Props slipperiness(double slipperiness) {
        this.slipperiness = (float) slipperiness;
        return this;
    }

    public Props randomTick(boolean randomTick) {
        this.randomTick = randomTick;
        return this;
    }

    public Props opacity(boolean variableOpacity) {
        this.variableOpacity = variableOpacity;
        return this;
    }

    public Props blocking(boolean blocksMovement) {
        this.blocksMovement = blocksMovement;
        return this;
    }

    public Props solid(boolean solid) {
        this.solid = solid;
        return this;
    }

    public Props floats(boolean floats) {
        this.floats = floats;
        return this;
    }

    public Props grassColor() {
        colorType = ColorType.GRASS;
        return this;
    }

    public Props foliageColor() {
        colorType = ColorType.FOLIAGE;
        return this;
    }

    public Props waterColor() {
        colorType = ColorType.WATER;
        return this;
    }

    public Props texture(String texture) {
        return texture("*", texture);
    }

    public Props texture(String name, String texture) {
        String namespace = Context.getInstance().getNamespace();
        String path = texture;

        int i = texture.indexOf(':');
        if (i != -1) {
            namespace = texture.substring(0, i);
            path = texture.substring(i + 1);
        }

        int j = path.indexOf('/');
        if (j == -1) {
            path = "block/" + path;
        }

        if (textures == null) {
            textures = Textures.builder();
        }

        textures.add(name, withNamespace(namespace, path));
        return this;
    }

    public Props template(BlockTemplate template) {
        if (template.getRenderLayer().isCutout()) {
            solid(false);
        }
        return this;
    }

    public Props group(ItemGroup group) {
        this.group = group;
        return this;
    }

    public Props with(String key, Object data) {
        if (extradata.isEmpty()) {
            extradata = new HashMap<>();
        }
        extradata.put(key, data);
        return this;
    }

    public Block.Properties toProperties() throws InitializationException {
        Block.Properties builder = createBuilder();
        set(sound, null, builder::sound);
        setInt(light, builder::lightValue);
        setFloat(slipperiness, builder::slipperiness);
        setBool(randomTick, false, builder::tickRandomly);
        setBool(variableOpacity, false, builder::variableOpacity);
        setBool(blocksMovement, true, builder::doesNotBlockMovement);
        set(solid, true, b -> {
            if (!b) {
                // not solid
                builder.func_226896_b_();
            }
        });
        setFloats(resistance, hardness, builder::hardnessAndResistance);
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

    public static Props create(Block block) {
        Preconditions.checkNotNull(block, "Block must not be null");
        return new Props(block);
    }

    public static Props create(BlockState state) {
        Preconditions.checkNotNull(state, "BlockState must not be null");
        return create(state.getBlock());
    }

    public static Props create(Material material) {
        Preconditions.checkNotNull(material, "Material must not be null");
        return new Props(material);
    }

    public static Props create(Material material, MaterialColor color) {
        Preconditions.checkNotNull(material, "Material must not be null");
        Preconditions.checkNotNull(color, "MaterialColor must not be null");
        return new Props(material, color);
    }

    private static <V> void set(V value, V defValue, Consumer<V> consumer) {
        if (value != defValue) {
            consumer.accept(value);
        }
    }

    private static void setInt(int value, Consumer<Integer> consumer) {
        if (value != Integer.MAX_VALUE) {
            consumer.accept(value);
        }
    }

    private static void setFloat(float value, Consumer<Float> consumer) {
        if (value != Float.MAX_VALUE) {
            consumer.accept(value);
        }
    }

    private static void setBool(boolean value, boolean defValue, Runnable runnable) {
        if (value != defValue) {
            runnable.run();
        }
    }

    private static void setFloats(float value1, float value2, BiConsumer<Float, Float> consumer) {
        if (value1 != Float.MAX_VALUE && value2 != Float.MAX_VALUE) {
            consumer.accept(value1, value2);
        }
    }

    private static String withNamespace(String namespace, String name) {
        if (name.indexOf(':') != -1) {
            return name;
        }
        return namespace + ':' + name;
    }
}
