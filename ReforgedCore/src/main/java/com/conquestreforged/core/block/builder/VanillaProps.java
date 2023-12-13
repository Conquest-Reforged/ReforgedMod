package com.conquestreforged.core.block.builder;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemGroup;

public class VanillaProps {

    public static Props stone() {
        return Props.create(Blocks.STONE).group(ItemGroup.BUILDING_BLOCKS);
    }

    public static Props mosaic() {
        return Props.create(BlockMaterials.ROCK_SPECIAL);
    }

    public static Props wood() {
        return planks();
    }

    public static Props woodLike() {
        return Props.create(BlockMaterials.WOOD_SPECIAL);
    }

    public static Props bricks() {
        return Props.create(Blocks.BRICKS).group(ItemGroup.BUILDING_BLOCKS);
    }

    public static Props planks() {
        return Props.create(Blocks.OAK_PLANKS).group(ItemGroup.BUILDING_BLOCKS);
    }

    public static Props logs() {
        return Props.create(Blocks.OAK_LOG).group(ItemGroup.BUILDING_BLOCKS);
    }

    public static Props sand() {
        return Props.create(Blocks.SAND).group(ItemGroup.BUILDING_BLOCKS);
    }

    public static Props gravel() {
        return Props.create(Blocks.GRAVEL).group(ItemGroup.BUILDING_BLOCKS);
    }

    public static Props grass() {
        return Props.create(Blocks.GRASS_BLOCK).group(ItemGroup.BUILDING_BLOCKS).grassColor();
    }

    public static Props grassLike() {
        return Props.create((Material.ORGANIC)).group(ItemGroup.BUILDING_BLOCKS).strength(0.6F, 0.6F).sound(SoundType.PLANT).grassColor();
    }

    public static Props glass() {
        return Props.create(Blocks.GLASS).group(ItemGroup.DECORATIONS);
    }

    public static Props cloth() {
        return Props.create(Blocks.WHITE_WOOL).group(ItemGroup.DECORATIONS);
    }

    public static Props plants() {
        return Props.create(Blocks.GRASS).group(ItemGroup.DECORATIONS).strength(0.0D, 0.0D);
    }

    public static Props earth() {
        return Props.create(Blocks.DIRT).group(ItemGroup.BUILDING_BLOCKS);
    }

    // blocks movement - not sure what is desirable
    public static Props plantLike() {
        return Props.create(Material.WOOL).sound(SoundType.PLANT).group(ItemGroup.BUILDING_BLOCKS);
    }

    public static Props ice() {
        return Props.create(Blocks.PACKED_ICE).group(ItemGroup.BUILDING_BLOCKS);
    }

    public static Props metal() {
        return Props.create(Blocks.IRON_BLOCK).group(ItemGroup.BUILDING_BLOCKS);
    }

    public static Props leaves() {
        return Props.create(Blocks.OAK_LEAVES).group(ItemGroup.BUILDING_BLOCKS);
    }

    public static Props leafLike() {
        return Props.create(Blocks.GRASS).group(ItemGroup.BUILDING_BLOCKS);
    }

    /**
     * Stone props but uses grass color
     */
    public static Props grassyStone() {
        return stone().grassColor();
    }

    /**
     * Earth props but uses grass color
     */
    public static Props grassyEarth() {
        return earth().grassColor();
    }

    /**
     * Sand props but uses grass color
     */
    public static Props grassySand() {
        return sand().grassColor();
    }

    /**
     * Gravel props but uses grass color
     */
    public static Props grassyGravel() {
        return gravel().grassColor();
    }
}
