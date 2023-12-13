package com.conquestrefabricated.core.block.builder;

import com.conquestrefabricated.core.block.data.BlockTemplate;
import com.conquestrefabricated.core.block.data.ColorType;
import com.conquestrefabricated.core.block.factory.BlockFactory;
import com.conquestrefabricated.core.block.factory.InitializationException;
import com.conquestrefabricated.core.block.factory.TypeList;
import com.conquestrefabricated.core.init.Context;
import com.conquestrefabricated.core.item.family.DeferredFamilyRegistry;
import com.conquestrefabricated.core.item.family.Family;
import com.conquestrefabricated.core.item.family.FamilyFactory;
import com.conquestrefabricated.core.item.family.block.BlockFamily;
import com.conquestrefabricated.core.item.family.block.VariantFamily;
import com.conquestrefabricated.core.util.RenderLayer;
import com.google.common.base.Preconditions;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;

public class Props extends BlockProps<Props> implements BlockFactory {

    /**
     * Certain Block constructor methods need a BlockState passing to them, ie a 'parent'.
     * For example, Slabs need the full-block instance passing to them to act as the double-slab variant.
     * <p>
     * In cases where the first Block created with the Factory requires a parent Block/BlockState,
     * the 'parent' must be set manually before calling the register(..) methods.
     * <p>
     * We otherwise assume the first Block created with this Factory is the parent.
     * This Block should therefore NOT require a parent Block or BlockState in it's own constructor.
     */
    private BlockState parent = null;
    private BlockName name = null;
    private ColorType colorType = ColorType.NONE;
    private RenderLayer renderLayer = RenderLayer.UNDEFINED;
    private Textures.Builder textures;
    private Map<String, Object> extradata = Collections.emptyMap();
    private FamilyFactory<Block> familyFactory = FamilyFactory.of(BlockFamily::new);
    private Identifier family = null;

    private boolean manual = false;

    private Props(Block block) {
        super(block);
    }

    private Props(Material material) {
        super(material);
    }

    private Props(Material material, MapColor color) {
        super(material, color);
    }

    private Props(Props props) {
        super(props);
        this.name = props.name;
        this.manual = props.manual;
        this.parent = props.parent;
        this.textures = props.textures;
        this.colorType = props.colorType;
        this.extradata = props.extradata;
        this.renderLayer = props.renderLayer;
        this.familyFactory = props.familyFactory;
        this.family = props.family;
    }

    @Override
    public Props getProps() {
        return this;
    }

    //something with light?
    @Override
    protected <T> void applyNonNull(Integer light, Consumer<T> lightLevel) {

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

    @Override
    public Family<Block> createFamily(TypeList types) {
        Identifier name = family == null ? parent == null ? null : Registry.BLOCK.getId(parent.getBlock()) : family;
        return familyFactory.create(name, group(), types);
    }

    public Optional<Identifier> getFamily() {
        return Optional.ofNullable(family);
    }

    public ColorType getColorType() {
        return colorType;
    }

    public RenderLayer getRenderLayer() {
        return renderLayer;
    }

    public Textures textures() {
        if (textures == null || textures.isEmpty()) {
            return Textures.NONE;
        }
        return textures.build();
    }

    public boolean isManual() {
        return manual;
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
     * <p>
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

    public Props family(String namespace, String name) {
        this.family = new Identifier(namespace, name);
        this.familyFactory = DeferredFamilyRegistry.BLOCKS;
        return this;
    }

    public Props family(String name) {
        String[] parts = name.split(":");
        if (parts.length == 2) {
            return family(parts[0], parts[1]);
        }
        return family(Context.getInstance().getNamespace(), name);
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

    public Props render(RenderLayer layer) {
        this.renderLayer = layer;
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
        if (getRenderLayer().isCutout() || template.getRenderLayer().isCutout()) {
            Props props = new Props(this);
            props.solid(false);
            return props;
        }
        return this;
    }

    public Props with(String key, Object data) {
        if (extradata.isEmpty()) {
            extradata = new HashMap<>();
        }
        extradata.put(key, data);
        return this;
    }

    public Props variantFamily() {
        familyFactory = FamilyFactory.of(VariantFamily::new);
        return this;
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

    public static Props create(Material material, MapColor color) {
        Preconditions.checkNotNull(material, "Material must not be null");
        Preconditions.checkNotNull(color, "MaterialColor must not be null");
        return new Props(material, color);
    }

    private static String withNamespace(String namespace, String name) {
        if (name.indexOf(':') != -1) {
            return name;
        }
        return namespace + ':' + name;
    }
}
