package com.conquestrefabricated.content.items.item;

import com.conquestrefabricated.api.painting.Painting;
import com.conquestrefabricated.api.painting.art.Art;
import com.conquestrefabricated.content.entities.painting.ModPainting;
import com.conquestrefabricated.content.entities.painting.PaintingFactory;
import com.conquestrefabricated.content.entities.painting.art.ArtType;
import com.conquestrefabricated.content.entities.painting.art.ModArt;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.decoration.AbstractDecorationEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.LiteralTextContent;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

import java.util.function.Function;

/**
 * @author dags <dags@dags.me>
 */
public class PaintingItem extends Item implements com.conquestrefabricated.api.painting.PaintingHolder {

    private final String name;
    private final Function<String, Art<?>> art;
    private final Function<String, Painting> type;
    private final PaintingFactory<? extends AbstractDecorationEntity> factory;

    public PaintingItem(String name, Function<String, Painting> type, Function<String, Art<?>> art, PaintingFactory<? extends AbstractDecorationEntity> factory) {
        super(new Item.Settings());
        this.name = name;
        this.art = art;
        this.type = type;
        this.factory = factory;
    }

    @Override
    public void appendStacks(ItemGroup group, DefaultedList<ItemStack> items) {
        if (name.equals("painting")) {
            if (getGroup() == group || group == ItemGroup.SEARCH) {
                Art<?> art = ModArt.of(ArtType.A1x1_0);
                ModPainting.getIds().distinct().sorted().forEach(name -> {
                    ModPainting type = ModPainting.fromName(name);
                    ItemStack stack = type.createStack(art);
                    items.add(stack);
                });
            }
        }
    }

    @Override
    public Text getName(ItemStack stack) {
        NbtCompound painting = stack.getNbt();
        if (painting == null) {
            return super.getName(stack);
        }

        NbtCompound data = painting.getCompound(Art.DATA_TAG);
        String typeName = data.getString(Art.TYPE_TAG);
        String artName = data.getString(Art.ART_TAG);

        ModPainting type = ModPainting.fromId(typeName);
        String displayName = "";//getUnlocalizedName();

        if (type.isPresent()) {
            // mod
            displayName = type.getDisplayName();
            ArtType art = ArtType.fromName(artName);
            if (art != null) {
                displayName = displayName + " " + art.getDisplayName(type.getTranslationKey());
            }
        } else if (!artName.isEmpty()) {
            // vanilla
            displayName = artName;
        }

        return Text.literal(displayName);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        return super.use(world, player, hand);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        PlayerEntity player = context.getPlayer();
        if (player == null) {
            return ActionResult.FAIL;
        }

        World world = context.getWorld();
        Hand hand = context.getHand();
        Direction side = context.getSide();
        if (player.getPose() == EntityPose.CROUCHING) {
            use(world, player, hand);
            return ActionResult.FAIL;
        }

        ItemStack stack = player.getStackInHand(hand);
        NbtCompound data = stack.getNbt();
        if (data == null) {
            return ActionResult.FAIL;
        }

        NbtCompound paint = data.getCompound(Art.DATA_TAG);
        String paintType = paint.getString(Art.TYPE_TAG);
        String paintArt = paint.getString(Art.ART_TAG);
        if (paintType.isEmpty() || paintArt.isEmpty()) {
            return ActionResult.FAIL;
        }

        if (side != Direction.DOWN && side != Direction.UP) {
            BlockPos pos = context.getBlockPos().offset(side);
            AbstractDecorationEntity painting = factory.create(world, pos, side, paintType, paintArt);
            if (painting == null) {
                return ActionResult.FAIL;
            }

            if (!world.isClient) {
                world.spawnEntity(painting);
                painting.onPlace();
            }

            stack.decrement(1);

            return ActionResult.SUCCESS;
        }
        return ActionResult.FAIL;
    }

    @Override
    public Art<?> getArt(ItemStack stack) {
        if (stack.getNbt() != null) {
            String artName = stack.getNbt().getCompound(Art.DATA_TAG).getString(Art.ART_TAG);
            return art.apply(artName);
        }
        return null;
    }

    @Override
    public Painting getType(ItemStack stack) {
        if (stack.getNbt() != null) {
            String typeName = stack.getNbt().getCompound(Art.DATA_TAG).getString(Art.TYPE_TAG);
            return type.apply(typeName);
        }
        return null;
    }
}
