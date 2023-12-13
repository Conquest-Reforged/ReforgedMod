package com.conquestreforged.core.block.builder;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.item.CreativeModeTab;

public class VanillaProps {

    public static Props stone() {
        return Props.create(Blocks.STONE).group(CreativeModeTab.TAB_BUILDING_BLOCKS);
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
        return Props.create(Blocks.BRICKS).group(CreativeModeTab.TAB_BUILDING_BLOCKS);
    }

    public static Props planks() {
        return Props.create(Blocks.OAK_PLANKS).group(CreativeModeTab.TAB_BUILDING_BLOCKS);
    }

    //TODO taking props from logs block forces axis prop...recreate log material -- OAK PLANKS PLACEHOLDER
    public static Props logs() {
        return Props.create(Blocks.OAK_PLANKS).group(CreativeModeTab.TAB_BUILDING_BLOCKS);
    }

    public static Props sand() {
        return Props.create(Blocks.SAND).group(CreativeModeTab.TAB_BUILDING_BLOCKS);
    }

    public static Props gravel() {
        return Props.create(Blocks.GRAVEL).group(CreativeModeTab.TAB_BUILDING_BLOCKS);
    }

    public static Props grass() {
        return Props.create(Blocks.GRASS_BLOCK).group(CreativeModeTab.TAB_BUILDING_BLOCKS).grassColor();
    }

    public static Props grassLike() {
        return Props.create((Material.GRASS)).group(CreativeModeTab.TAB_BUILDING_BLOCKS).strength(0.6F, 0.6F).sound(SoundType.GRASS).grassColor();
    }

    public static Props glass() {
        return Props.create(Blocks.GLASS).group(CreativeModeTab.TAB_DECORATIONS);
    }

    public static Props cloth() {
        return Props.create(Blocks.WHITE_WOOL).group(CreativeModeTab.TAB_DECORATIONS);
    }

    public static Props plants() {
        return Props.create(Blocks.GRASS).group(CreativeModeTab.TAB_DECORATIONS).strength(0.0D, 0.0D);
    }

    public static Props earth() {
        return Props.create(Blocks.DIRT).group(CreativeModeTab.TAB_BUILDING_BLOCKS);
    }

    // blocks movement - not sure what is desirable
    public static Props plantLike() {
        return Props.create(Material.WOOL).sound(SoundType.GRASS).group(CreativeModeTab.TAB_BUILDING_BLOCKS);
    }

    public static Props ice() {
        return Props.create(Blocks.PACKED_ICE).group(CreativeModeTab.TAB_BUILDING_BLOCKS);
    }

    public static Props metal() {
        return Props.create(Blocks.IRON_BLOCK).group(CreativeModeTab.TAB_BUILDING_BLOCKS);
    }

    public static Props leaves() {
        return Props.create(Blocks.OAK_LEAVES).group(CreativeModeTab.TAB_BUILDING_BLOCKS);
    }

    public static Props leafLike() {
        return Props.create(Blocks.GRASS).group(CreativeModeTab.TAB_BUILDING_BLOCKS);
    }

    public static Props bamboo() {
        return Props.create(Blocks.BAMBOO).group(CreativeModeTab.TAB_BUILDING_BLOCKS);
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
