package com.conquestrefabricated.content.items.item;

import com.conquestrefabricated.content.blocks.block.decor.Scaffolding;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.network.message.MessageType;
import net.minecraft.network.packet.s2c.play.GameMessageS2CPacket;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableTextContent;
import net.minecraft.util.Formatting;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

public class ScaffoldingItem extends net.minecraft.item.ScaffoldingItem {

    private Block blockIn;

    public ScaffoldingItem(Block blockIn, Settings builder) {
        super(blockIn, builder);
        this.blockIn = blockIn;
    }

    @Override
    public ItemPlacementContext getPlacementContext(ItemPlacementContext context) {
        BlockPos blockpos = context.getBlockPos();
        World world = context.getWorld();
        BlockState blockstate = world.getBlockState(blockpos);
        Block block = this.getBlock();
        if (blockstate.getBlock() != block) {
            return Scaffolding.getDistance1(world, blockpos) == 7 ? null : context;
        } else {
            Direction direction;
            if (context.shouldCancelInteraction()) {
                direction = context.hitsInsideBlock() ? context.getSide().getOpposite() : context.getSide();
            } else {
                direction = context.getSide() == Direction.UP ? context.getPlayerFacing() : Direction.UP;
            }

            int i = 0;
            BlockPos.Mutable blockposMutable = blockpos.mutableCopy().move(direction);

            while(i < 7) {
                if (!world.isClient && !world.isInBuildLimit(blockposMutable)) {
                    PlayerEntity playerentity = context.getPlayer();
                    int j = world.getHeight();
                    if (playerentity instanceof ServerPlayerEntity && blockposMutable.getY() >= j) {
                        GameMessageS2CPacket schatpacket = new GameMessageS2CPacket((Text.translatable("build.tooHigh", j)).formatted(Formatting.RED), false);
                        ((ServerPlayerEntity)playerentity).networkHandler.sendPacket(schatpacket);
                    }
                    break;
                }

                blockstate = world.getBlockState(blockposMutable);
                if (blockstate.getBlock() != this.getBlock()) {
                    if (blockstate.canReplace(context)) {
                        return ItemPlacementContext.offset(context, blockposMutable, direction);
                    }
                    break;
                }

                blockposMutable.move(direction);
                if (direction.getAxis().isHorizontal()) {
                    ++i;
                }
            }

            return null;
        }
    }
}
