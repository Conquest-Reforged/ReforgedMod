package com.conquestrefabricated.content.blocks.init;


import com.conquestrefabricated.content.blocks.block.*;
import com.conquestrefabricated.content.blocks.block.arch.ArchSmall;
import com.conquestrefabricated.content.blocks.block.arch.ArchSmallHalf;
import com.conquestrefabricated.content.blocks.block.arch.ArchTwoMeter;
import com.conquestrefabricated.content.blocks.block.arch.ArchTwoMeterHalf;
import com.conquestrefabricated.content.blocks.block.beam.BeamSlabCorner;
import com.conquestrefabricated.content.blocks.block.beam.BeamSlabEighth;
import com.conquestrefabricated.content.blocks.block.beam.BeamSlabLessLayers;
import com.conquestrefabricated.content.blocks.block.beam.BeamSlabQuarter;
import com.conquestrefabricated.content.blocks.block.classical.*;
import com.conquestrefabricated.content.blocks.block.decor.DoorFrameLintels;
import com.conquestrefabricated.content.blocks.block.decor.DoorFramePost;
import com.conquestrefabricated.content.blocks.block.decor.Lintels;
import com.conquestrefabricated.content.blocks.block.decor.Posts;
import com.conquestrefabricated.content.blocks.block.overlay_tinted.TintedOverlayLayer;
import com.conquestrefabricated.content.blocks.block.overlay_tinted.TintedOverlayStairs;
import com.conquestrefabricated.content.blocks.block.overlay_top.inverted.*;
import com.conquestrefabricated.content.blocks.block.overlay_wall.*;
import com.conquestrefabricated.content.blocks.block.topography.Rocks;
import com.conquestrefabricated.content.blocks.block.trees.*;
import com.conquestrefabricated.content.blocks.block.tudor.TudorVerticalCorner;
import com.conquestrefabricated.content.blocks.block.tudor.TudorVerticalQuarter;
import com.conquestrefabricated.content.blocks.block.tudor.TudorVerticalSlab;
import com.conquestrefabricated.content.blocks.block.uniquetexture.PillarUniqueTexture;
import com.conquestrefabricated.content.blocks.block.uniquetexture.WallUniqueTexture;
import com.conquestrefabricated.content.blocks.block.windows.ArrowSlit;
import com.conquestrefabricated.content.blocks.block.windows.WindowSmall;
import com.conquestrefabricated.content.blocks.block.windows.WindowSmallHalf;
import com.conquestrefabricated.content.blocks.init.blocks.*;
import com.conquestrefabricated.core.block.factory.TypeList;

;



public class BlockRegistrar {

    //@SubscribeEvent
    public static void blocks() {
        com.conquestrefabricated.core.util.log.Log.info("Registering blocks");
        init();

        // lilly blocks and scaffolding are registered manually
        LiliesInit.registerBlocks();
        ScaffoldingInit.registerBlocks();
    }

    //@SubscribeEvent
    public static void items() {
        com.conquestrefabricated.core.util.log.Log.info("Registering block items");
        // lilly and scaffolding  items are registered manually
        LiliesInit.registerItems();
        ScaffoldingInit.registerItems();
    }

    private static void init() {
        TypeList refinedStoneCobbleBrickShapesVanilla = TypeList.of(ArchSmall.class, ArchSmallHalf.class, ArchTwoMeter.class, ArchTwoMeterHalf.class, ArrowSlit.class, WindowSmall.class, WindowSmallHalf.class, Balustrade.class, Capital.class, Sphere.class, Slab.class, SlabQuarter.class, SlabCorner.class, SlabEighth.class, VerticalSlabCorner.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class, Wall.class, Pillar.class);
        TypeList refinedStoneCobbleBrickShapesVanillaNoWall = TypeList.of(ArchSmall.class, ArchSmallHalf.class, ArchTwoMeter.class, ArchTwoMeterHalf.class, ArrowSlit.class, WindowSmall.class, WindowSmallHalf.class, Balustrade.class, Capital.class, Sphere.class, Slab.class, SlabQuarter.class, SlabCorner.class, SlabEighth.class, VerticalSlabCorner.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class, Pillar.class);
        TypeList refinedStoneCobbleBrickShapesTopOverlay = TypeList.of(TopOverlayInvertedCube.class, ArchSmall.class, ArchSmallHalf.class, ArchTwoMeter.class, ArchTwoMeterHalf.class, TopOverlayInvertedArrowSlit.class, TopOverlayInvertedWindowSmall.class, TopOverlayInvertedWindowSmallHalf.class, TopOverlayInvertedBalustrade.class, TopOverlayInvertedCapital.class, Sphere.class, TopOverlayInvertedSlab.class, TopOverlayInvertedSlabQuarter.class, TopOverlayInvertedSlabCorner.class, TopOverlayInvertedSlabEighth.class, TopOverlayInvertedVerticalSlabCorner.class, TopOverlayInvertedVerticalSlab.class, TopOverlayInvertedVerticalCorner.class, TopOverlayInvertedVerticalQuarter.class, TopOverlayInvertedStairs.class, Wall.class, TopOverlayInvertedPillar.class);
        TypeList refinedStoneCobbleBrickShapes = TypeList.of(Cube.class, ArchSmall.class, ArchSmallHalf.class, ArchTwoMeter.class, ArchTwoMeterHalf.class, ArrowSlit.class, WindowSmall.class, WindowSmallHalf.class, Balustrade.class, Capital.class, Sphere.class, Slab.class, SlabQuarter.class, SlabCorner.class, SlabEighth.class, VerticalSlabCorner.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class, Stairs.class, Wall.class, Pillar.class);

        TypeList roadShapes = TypeList.of(Cube.class, Slab.class, SlabQuarter.class, SlabCorner.class, SlabEighth.class, VerticalSlabCorner.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class, Stairs.class);

        TypeList largeStoneSlabShapes = TypeList.of(Cube.class, ArchSmall.class, ArchSmallHalf.class, ArchTwoMeter.class, ArchTwoMeterHalf.class, ArrowSlit.class, WindowSmall.class, WindowSmallHalf.class, Balustrade.class, Capital.class, Slab.class, SlabQuarter.class, SlabCorner.class, SlabEighth.class, VerticalSlabCorner.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class, Stairs.class, Wall.class, Pillar.class);
        TypeList largeStoneSlabShapesVanilla = TypeList.of(ArchSmall.class, ArchSmallHalf.class, ArchTwoMeter.class, ArchTwoMeterHalf.class, ArrowSlit.class, WindowSmall.class, WindowSmallHalf.class, Balustrade.class, Capital.class, Slab.class, SlabQuarter.class, SlabCorner.class, SlabEighth.class, VerticalSlabCorner.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class, Stairs.class, Wall.class, Pillar.class);
        TypeList largeStoneSlabShapesVanillaNoStairs = TypeList.of(ArchSmall.class, ArchSmallHalf.class, ArchTwoMeter.class, ArchTwoMeterHalf.class, ArrowSlit.class, WindowSmall.class, WindowSmallHalf.class, Balustrade.class, Capital.class, Slab.class, SlabQuarter.class, SlabCorner.class, SlabEighth.class, VerticalSlabCorner.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class, Wall.class, Pillar.class);

        TypeList wallCarvingsDesignsShapes = TypeList.of(Cube.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class, Wall.class, Pillar.class);
        TypeList wallCarvingsDesignsNoWallShapes = TypeList.of(Cube.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class);
        TypeList wallCarvingsDesignsNoWallOverlayShapes = TypeList.of(OverlayCube.class, OverlayVerticalSlab.class, OverlayVerticalCorner.class, OverlayVerticalQuarter.class);
        TypeList wallCarvingsDesignsPillarOverlayShapes = TypeList.of(OverlayCube.class, OverlayVerticalSlab.class, OverlayVerticalCorner.class, OverlayVerticalQuarter.class, OverlayPillar.class);

        TypeList tudorShapes = TypeList.of(Cube.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class);
        TypeList tudorSlashShapes = TypeList.of(Cube.class, TudorVerticalSlab.class, TudorVerticalCorner.class, TudorVerticalQuarter.class);

        TypeList columnShapesVanilla = TypeList.of(VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class, Wall.class, Pillar.class);
        TypeList columnShapes = TypeList.of(Cube.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class, Wall.class, Pillar.class);
        TypeList columnShapes2 = TypeList.of(Cube.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class, WallColumn.class, Pillar.class);
        TypeList columnShapesLog = TypeList.of(Log.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class, WallColumn.class, Pillar.class);
        TypeList columnDoricCapitalShapes = TypeList.of(CubeCapital.class, VerticalSlabCapital.class, VerticalCornerCapital.class, VerticalQuarterCapital.class, PillarCapital.class, WallCapital.class);
        TypeList columnDoricBaseShapes = TypeList.of(CubeBase.class, VerticalSlabBase.class, VerticalCornerBase.class, VerticalQuarterBase.class, PillarBase.class, WallBase.class);

        TypeList plasterShapes = TypeList.of(Cube.class, ArchSmall.class, ArchSmallHalf.class, ArchTwoMeter.class, ArchTwoMeterHalf.class, ArrowSlit.class, WindowSmall.class, WindowSmallHalf.class, Balustrade.class, Capital.class, Sphere.class, SlabLessLayers.class, SlabQuarter.class, SlabCorner.class, SlabEighth.class, VerticalSlabCorner.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class, Stairs.class, Wall.class, Pillar.class);
        TypeList plasterShapesVanilla = TypeList.of(ArchSmall.class, ArchSmallHalf.class, ArchTwoMeter.class, ArchTwoMeterHalf.class, ArrowSlit.class, WindowSmall.class, WindowSmallHalf.class, Balustrade.class, Capital.class, Sphere.class, SlabLessLayers.class, SlabQuarter.class, SlabCorner.class, SlabEighth.class, VerticalSlabCorner.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class, Stairs.class, Wall.class, Pillar.class);

        TypeList floorCeilingPatternShapes = TypeList.of(Cube.class, Slab.class, SlabQuarter.class, SlabCorner.class, SlabEighth.class, VerticalSlabCorner.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class, Stairs.class);
        TypeList floorCeilingPatternShapesVanilla = TypeList.of(Slab.class, SlabQuarter.class, SlabCorner.class, SlabEighth.class, VerticalSlabCorner.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class, Stairs.class);

        TypeList strippedLogShapes = TypeList.of(Log.class, Bark.class, WallUniqueTexture.class, PillarUniqueTexture.class, BeamSlabLessLayers.class, BeamSlabQuarter.class, BeamSlabCorner.class, BeamSlabEighth.class, VerticalSlabCorner.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class, Stairs.class, BeamHorizontal.class, BeamVertical.class, DoorFrameLintels.class, DoorFramePost.class, Lintels.class, Posts.class);
        TypeList strippedLogVanillaShapes = TypeList.of(WallUniqueTexture.class, PillarUniqueTexture.class, BeamSlabLessLayers.class, BeamSlabQuarter.class, BeamSlabCorner.class, BeamSlabEighth.class, VerticalSlabCorner.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class, Stairs.class, BeamHorizontal.class, BeamVertical.class, DoorFrameLintels.class, DoorFramePost.class, Lintels.class, Posts.class);

        TypeList logShapes = TypeList.of(Log.class, Bark.class, BranchLarge.class, Pillar.class, Branch.class, BranchSmall.class, Stump.class, SlabLessLayers.class, SlabQuarter.class, SlabCorner.class, SlabEighth.class, VerticalSlabCorner.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class, Stairs.class);
        TypeList logShapesVanilla = TypeList.of(BranchLarge.class, Pillar.class, Branch.class, BranchSmall.class, Stump.class, SlabLessLayers.class, SlabQuarter.class, SlabCorner.class, SlabEighth.class, VerticalSlabCorner.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class, Stairs.class);

        TypeList planksShapes = TypeList.of(Cube.class, WindowSmall.class, WindowSmallHalf.class, Balustrade.class, Capital.class, Sphere.class, SlabLessLayers.class, SlabQuarter.class, SlabCorner.class, SlabEighth.class, VerticalSlabCorner.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class, Stairs.class, Wall.class, Pillar.class);
        TypeList planksVerticalShapes = TypeList.of(Cube.class, WindowSmall.class, WindowSmallHalf.class, Balustrade.class, Capital.class, Sphere.class, BoardsVertical.class, SlabLessLayers.class, SlabQuarter.class, SlabCorner.class, SlabEighth.class, VerticalSlabCorner.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class, Stairs.class, Wall.class, Pillar.class);
        TypeList planksVerticalCrossFenceShapes = TypeList.of(Cube.class, WindowSmall.class, WindowSmallHalf.class, Balustrade.class, Capital.class, Sphere.class, BoardsVertical.class, SlabLessLayers.class, SlabQuarter.class, SlabCorner.class, SlabEighth.class, VerticalSlabCorner.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class, Stairs.class, Wall.class, Pillar.class, FenceCross.class);
        TypeList planksHorizontalShapes = TypeList.of(Cube.class, WindowSmall.class, WindowSmallHalf.class, Balustrade.class, Capital.class, Sphere.class, BoardsHorizontal.class, SlabLessLayers.class, SlabQuarter.class, SlabCorner.class, SlabEighth.class, VerticalSlabCorner.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class, Stairs.class, Wall.class, Pillar.class);

        TypeList thatchShapes = TypeList.of(Cube.class, Slab.class, SlabQuarter.class, SlabCorner.class, SlabEighth.class, VerticalSlabCorner.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class, Stairs.class);
        TypeList woolShapes = TypeList.of(Slab.class, SlabQuarter.class, SlabCorner.class, SlabEighth.class, VerticalSlabCorner.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class, Stairs.class);
        TypeList clothShapes = TypeList.of(Cube.class, Slab.class, SlabQuarter.class, SlabCorner.class, SlabEighth.class, VerticalSlabCorner.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class, Stairs.class);

        TypeList roughNaturalRockShapes = TypeList.of(Cube.class, Slab.class, SlabQuarter.class, SlabCorner.class, SlabEighth.class, VerticalSlabCorner.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class, Stairs.class);
        TypeList roughNaturalRockShapesRocks = TypeList.of(Cube.class, Slab.class, SlabQuarter.class, SlabCorner.class, SlabEighth.class, VerticalSlabCorner.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class, Stairs.class, Rocks.class);
        TypeList roughNaturalRockShapesVanilla = TypeList.of(Slab.class, SlabQuarter.class, SlabCorner.class, SlabEighth.class, VerticalSlabCorner.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class, Stairs.class);
        TypeList roughNaturalRockShapesRocksVanilla = TypeList.of(Slab.class, SlabQuarter.class, SlabCorner.class, SlabEighth.class, VerticalSlabCorner.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class, Stairs.class, Rocks.class);

        TypeList smoothNaturalRockShapes = TypeList.of(Cube.class, ArrowSlit.class, WindowSmall.class, WindowSmallHalf.class, Balustrade.class, Capital.class, Sphere.class, Slab.class, SlabQuarter.class, SlabCorner.class, SlabEighth.class, VerticalSlabCorner.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class, Stairs.class, Wall.class, Pillar.class);
        TypeList smoothNaturalRockShapesRocks = TypeList.of(Cube.class, ArrowSlit.class, WindowSmall.class, WindowSmallHalf.class, Balustrade.class, Capital.class, Sphere.class, Slab.class, SlabQuarter.class, SlabCorner.class, SlabEighth.class, VerticalSlabCorner.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class, Stairs.class, Wall.class, Pillar.class, Rocks.class);
        TypeList smoothNaturalRockShapesVanillaNoWall = TypeList.of(ArrowSlit.class, WindowSmall.class, WindowSmallHalf.class, Balustrade.class, Capital.class, Sphere.class, Slab.class, SlabQuarter.class, SlabCorner.class, SlabEighth.class, VerticalSlabCorner.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class, Pillar.class, Rocks.class);
        TypeList smoothNaturalRockShapesVanilla = TypeList.of(ArrowSlit.class, WindowSmall.class, WindowSmallHalf.class, Balustrade.class, Capital.class, Sphere.class, Slab.class, SlabQuarter.class, SlabCorner.class, SlabEighth.class, VerticalSlabCorner.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class, Wall.class, Pillar.class, Rocks.class);


        TypeList sandGravelShapes = TypeList.of(Cube.class, Layer.class, Stairs.class);
        TypeList sandGravelShapesVanilla = TypeList.of(Layer.class, Stairs.class);
        TypeList sandGravelShapesOverlay = TypeList.of(TintedOverlayLayer.class, TintedOverlayStairs.class);

        TypeList grassGroundShapes = TypeList.of(Cube.class, Layer.class, Stairs.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class);

        TypeList dirtShapes = TypeList.of(Cube.class, Slab.class, SlabQuarter.class, SlabCorner.class, SlabEighth.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class, Stairs.class);
        TypeList dirtShapesVanilla = TypeList.of(Slab.class, SlabQuarter.class, SlabCorner.class, SlabEighth.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class, Stairs.class);

        TypeList roofTileShapes = TypeList.of(Cube.class, SlabLessLayers.class, SlabQuarter.class, SlabCorner.class, SlabEighth.class, VerticalSlabCorner.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class, Wall.class, Pillar.class, Capital.class, Stairs.class);
        TypeList roofTileShapesVanilla = TypeList.of(SlabLessLayers.class, SlabQuarter.class, SlabCorner.class, SlabEighth.class, VerticalSlabCorner.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class, Wall.class, Pillar.class, Capital.class, Stairs.class);

        RefinedStoneCobbleBrickInit.init(refinedStoneCobbleBrickShapes, refinedStoneCobbleBrickShapesVanilla, refinedStoneCobbleBrickShapesVanillaNoWall, refinedStoneCobbleBrickShapesTopOverlay);
        LargeStoneSlabsInit.init(largeStoneSlabShapes, largeStoneSlabShapesVanilla, largeStoneSlabShapesVanillaNoStairs);
        RoadsInit.init(roadShapes);
        RoofTilesInit.init(roofTileShapes, roofTileShapesVanilla);
        WallDesignsInit.init(wallCarvingsDesignsShapes);
        WallDesignsNoWallInit.init(wallCarvingsDesignsNoWallShapes, wallCarvingsDesignsNoWallOverlayShapes, wallCarvingsDesignsPillarOverlayShapes);
        TudorInit.init(tudorShapes, tudorSlashShapes);
        ColumnsInit.init(columnShapes, columnDoricCapitalShapes, columnDoricBaseShapes, columnShapes2, columnShapesVanilla, columnShapesLog);
        PlasterInit.init(plasterShapes, plasterShapesVanilla);
        FloorCeilingPatternInit.init(floorCeilingPatternShapes, floorCeilingPatternShapesVanilla);
        BeamsInit.init(strippedLogShapes, strippedLogVanillaShapes);
        PlanksInit.init(planksShapes, planksHorizontalShapes, planksVerticalShapes, planksVerticalCrossFenceShapes);
        LogsInit.init(logShapes, logShapesVanilla);
        BranchesInit.init();
        ThatchInit.init(thatchShapes);
        WoolInit.init(woolShapes);
        ClothInit.init(clothShapes);
        MetalInit.init();
        RoughNaturalRockInit.init(roughNaturalRockShapes, roughNaturalRockShapesRocks, roughNaturalRockShapesVanilla, roughNaturalRockShapesRocksVanilla);
        SmoothNaturalRockInit.init(smoothNaturalRockShapes, smoothNaturalRockShapesRocks, smoothNaturalRockShapesVanillaNoWall, smoothNaturalRockShapesVanilla);
        SandGravelInit.init(sandGravelShapes, sandGravelShapesVanilla, sandGravelShapesOverlay);
        GrassGroundInit.init(grassGroundShapes);
        DirtInit.init(dirtShapes, dirtShapesVanilla);
        IrregularBlocksInit.init();
        BlocksNoVariantsInit.init();
        DoorsInit.init();
        GlassInit.init();
        BarrelsInit.init();
        LightsInit.init();
        LeavesInit.init();
        SaplingsInit.init();
        PlantsInit.init();
        CropsInit.init();
        WasteInit.init();
        AirInit.init();
        ArchesInit.init();
    }
}