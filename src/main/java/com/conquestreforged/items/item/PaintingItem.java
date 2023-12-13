package com.conquestreforged.items.item;

import com.conquestreforged.api.painting.Painting;
import com.conquestreforged.api.painting.art.Art;
import com.conquestreforged.entities.painting.ModPainting;
import com.conquestreforged.entities.painting.PaintingFactory;
import com.conquestreforged.entities.painting.art.ArtType;
import com.conquestreforged.entities.painting.art.ModArt;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.decoration.HangingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

import java.util.function.Function;

/**
 * @author dags <dags@dags.me>
 */
public class PaintingItem extends Item implements com.conquestreforged.api.painting.PaintingHolder {

    private final String name;
    private final Function<String, Art<?>> art;
    private final Function<String, Painting> type;
    private final PaintingFactory<? extends HangingEntity> factory;

    public PaintingItem(String name, Function<String, Painting> type, Function<String, Art<?>> art, PaintingFactory<? extends HangingEntity> factory) {
        super(new Item.Properties());
        this.name = name;
        this.art = art;
        this.type = type;
        this.factory = factory;
        setRegistryName("conquest", name);
    }

    @Override
    public void fillItemCategory(CreativeModeTab group, NonNullList<ItemStack> items) {
        if (name.equals("painting")) {
            if (getItemCategory() == group || group == CreativeModeTab.TAB_SEARCH) {
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
    public Component getName(ItemStack stack) {
        CompoundTag painting = stack.getTag();
        if (painting == null) {
            return super.getName(stack);
        }

        CompoundTag data = painting.getCompound(Art.DATA_TAG);
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

        return new TextComponent(displayName);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        return super.use(world, player, hand);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Player player = context.getPlayer();
        if (player == null) {
            return InteractionResult.FAIL;
        }

        Level world = context.getLevel();
        InteractionHand hand = context.getHand();
        Direction side = context.getClickedFace();
        if (player.getPose() == Pose.CROUCHING) {
            use(world, player, hand);
            return InteractionResult.FAIL;
        }

        ItemStack stack = player.getItemInHand(hand);
        CompoundTag data = stack.getTag();
        if (data == null) {
            return InteractionResult.FAIL;
        }

        CompoundTag paint = data.getCompound(Art.DATA_TAG);
        String paintType = paint.getString(Art.TYPE_TAG);
        String paintArt = paint.getString(Art.ART_TAG);
        if (paintType.isEmpty() || paintArt.isEmpty()) {
            return InteractionResult.FAIL;
        }

        if (side != Direction.DOWN && side != Direction.UP) {
            BlockPos pos = context.getClickedPos().m_142300_(side);
            HangingEntity painting = factory.create(world, pos, side, paintType, paintArt);
            if (painting == null) {
                return InteractionResult.FAIL;
            }

            if (!world.isClientSide) {
                world.addFreshEntity(painting);
                painting.playPlacementSound();
            }

            stack.shrink(1);

            return InteractionResult.SUCCESS;
        }
        return InteractionResult.FAIL;
    }

    @Override
    public Art<?> getArt(ItemStack stack) {
        if (stack.getTag() != null) {
            String artName = stack.getTag().getCompound(Art.DATA_TAG).getString(Art.ART_TAG);
            return art.apply(artName);
        }
        return null;
    }

    @Override
    public Painting getType(ItemStack stack) {
        if (stack.getTag() != null) {
            String typeName = stack.getTag().getCompound(Art.DATA_TAG).getString(Art.TYPE_TAG);
            return type.apply(typeName);
        }
        return null;
    }
}
