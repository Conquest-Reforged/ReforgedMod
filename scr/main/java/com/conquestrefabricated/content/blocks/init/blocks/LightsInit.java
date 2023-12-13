package com.conquestrefabricated.content.blocks.init.blocks;

import com.conquestrefabricated.content.blocks.BlockVoxelShapes;
import com.conquestrefabricated.content.blocks.block.decor.Campfire;
import com.conquestrefabricated.content.blocks.block.lights.*;
import com.conquestrefabricated.content.blocks.group.ModGroups;
import com.conquestrefabricated.core.block.builder.VanillaProps;
import com.conquestrefabricated.core.block.factory.TypeList;
import net.minecraft.block.BlockState;

import java.util.function.ToIntFunction;

public class LightsInit {

    private static final int[] lightValues = {5, 10, 14};

    public static void init() {
        VanillaProps.stone()
                .group(ModGroups.LIGHTING)
                .light((state) -> 15)
                .name("campfire")
                .manual()
                .register(TypeList.of(Campfire.class));
        VanillaProps.metal()
                .group(ModGroups.LIGHTING)
                .name("torch_with_grille")
                .light(litBlockEmission(lightValues))
                .manual()
                .blocking(false)
                .register(TypeList.of(Torch.class));
        VanillaProps.metal()
                .group(ModGroups.LIGHTING)
                .name("victorian_lantern")
                .light(litBlockEmission(lightValues))
                .manual()
                .register(TypeList.of(Torch.class));
        VanillaProps.metal()
                .group(ModGroups.LIGHTING)
                .name("hanging_oil_lamp")
                .light(litBlockEmission(lightValues))
                .manual()
                .register(TypeList.of(Torch.class));
        VanillaProps.metal()
                .group(ModGroups.LIGHTING)
                .name("hanging_candle_holder")
                .light(litBlockEmission(lightValues))
                .manual()
                .register(TypeList.of(Torch.class));
        VanillaProps.metal()
                .group(ModGroups.LIGHTING)
                .name("elven_hand_light")
                .light(litBlockEmission(lightValues))
                .manual()
                .register(TypeList.of(Torch.class));
        VanillaProps.metal()
                .group(ModGroups.LIGHTING)
                .name("candle")
                .light(litBlockEmission(lightValues))
                .manual()
                .register(TypeList.of(Torch.class));
        VanillaProps.metal()
                .group(ModGroups.LIGHTING)
                .name("big_lantern")
                .light(litBlockEmission(lightValues))
                .manual()
                .register(TypeList.of(TorchNonDirectional.class));
        VanillaProps.metal()
                .group(ModGroups.LIGHTING)
                .name("candelabra")
                .light(litBlockEmission(lightValues))
                .manual()
                .register(TypeList.of(TorchNonDirectional.class));
        VanillaProps.metal()
                .group(ModGroups.LIGHTING)
                .name("candles")
                .light(litBlockEmission(lightValues))
                .manual()
                .blocking(false)
                .register(TypeList.of(TorchFlat.class));
        VanillaProps.metal()
                .group(ModGroups.LIGHTING)
                .name("chandelier")
                .light(litBlockEmission(lightValues))
                .manual()
                .register(TypeList.of(TorchNonDirectional.class));
        VanillaProps.metal()
                .group(ModGroups.LIGHTING)
                .name("cross_chandelier")
                .light(litBlockEmission(lightValues))
                .manual()
                .register(TypeList.of(TorchNonDirectional.class));
        VanillaProps.metal()
                .group(ModGroups.LIGHTING)
                .name("hand_candle")
                .light(litBlockEmission(lightValues))
                .manual()
                .register(TypeList.of(TorchNonDirectional.class));
        VanillaProps.metal()
                .group(ModGroups.LIGHTING)
                .name("hanging_brazier")
                .light(litBlockEmission(lightValues))
                .manual()
                .register(TypeList.of(Torch.class));
        VanillaProps.metal()
                .group(ModGroups.LIGHTING)
                .name("candle_in_a_lantern")
                .light(litBlockEmission(lightValues))
                .manual()
                .register(TypeList.of(Torch.class));
        VanillaProps.metal()
                .group(ModGroups.LIGHTING)
                .name("ship_lantern")
                .light(litBlockEmission(lightValues))
                .manual()
                .register(TypeList.of(TorchNonDirectional.class));
        VanillaProps.metal()
                .group(ModGroups.LIGHTING)
                .name("small_lantern")
                .light(litBlockEmission(lightValues))
                .manual()
                .register(TypeList.of(TorchNonDirectional.class));
        VanillaProps.plantLike()
                .group(ModGroups.LIGHTING)
                .name("white_paper_lantern")
                .light(litBlockEmission(lightValues))
                .manual()
                .register(TypeList.of(LightSource.class));
        VanillaProps.plantLike()
                .group(ModGroups.LIGHTING)
                .name("yellow_paper_lantern")
                .light(litBlockEmission(lightValues))
                .manual()
                .register(TypeList.of(LightSource.class));
        VanillaProps.plantLike()
                .group(ModGroups.LIGHTING)
                .name("small_red_paper_lantern")
                .light(litBlockEmission(lightValues))
                .manual()
                .register(TypeList.of(LightSource.class));
        VanillaProps.metal()
                .group(ModGroups.LIGHTING)
                .name("brazier")
                .light(litBlockEmission(lightValues))
                .manual()
                .register(TypeList.of(TorchNonDirectional.class));
        VanillaProps.metal()
                .group(ModGroups.LIGHTING)
                .name("oil_lamp")
                .light(litBlockEmission(lightValues))
                .manual()
                .register(TypeList.of(TorchNonDirectional.class));
        VanillaProps.metal()
                .group(ModGroups.LIGHTING)
                .name("chinese_palace_lantern")
                .light(litBlockEmission(lightValues))
                .manual()
                .register(TypeList.of(TorchNonDirectional.class));
        VanillaProps.metal()
                .group(ModGroups.LIGHTING)
                .name("iron_candelabrum_1")
                .light(litBlockEmission(lightValues))
                .manual()
                .with("hitBox", BlockVoxelShapes.cubePartialShape)
                .register(TypeList.of(TorchNonDirectional.class));
        VanillaProps.metal()
                .name("iron_candelabrum_2")
                .family("iron_candelabrum_1")
                .light(litBlockEmission(lightValues))
                .manual()
                .with("hitBox", BlockVoxelShapes.cubePartialShape)
                .register(TypeList.of(TorchNonDirectional.class));
        VanillaProps.metal()
                .name("iron_candelabrum_3")
                .family("iron_candelabrum_1")
                .light(litBlockEmission(lightValues))
                .manual()
                .with("hitBox", BlockVoxelShapes.cubePartialShape)
                .register(TypeList.of(TorchFlat.class));
        VanillaProps.metal()
                .group(ModGroups.LIGHTING)
                .name("golden_candelabrum_1")
                .light(litBlockEmission(lightValues))
                .manual()
                .with("hitBox", BlockVoxelShapes.cubePartialShape)
                .register(TypeList.of(TorchNonDirectional.class));
        VanillaProps.metal()
                .name("golden_candelabrum_2")
                .family("golden_candelabrum_1")
                .light(litBlockEmission(lightValues))
                .manual()
                .with("hitBox", BlockVoxelShapes.cubePartialShape)
                .register(TypeList.of(TorchNonDirectional.class));
        VanillaProps.metal()
                .name("golden_candelabrum_3")
                .family("golden_candelabrum_1")
                .light(litBlockEmission(lightValues))
                .manual()
                .with("hitBox", BlockVoxelShapes.cubePartialShape)
                .register(TypeList.of(TorchFlat.class));
        VanillaProps.metal()
                .group(ModGroups.LIGHTING)
                .name("terracotta_oil_lamp")
                .light(litBlockEmission(lightValues))
                .manual()
                .with("hitBox", BlockVoxelShapes.coverShape)
                .register(TypeList.of(LightSourceToggle5.class));
        VanillaProps.stone()
                .name("invisible_light_low")
                .family("invisible_light")
                .light((state) -> 6)
                .blocking(false)
                .texture("block/5_miscellaneous/invisible")
                .register(TypeList.of(InvisibleLight.class));
        VanillaProps.stone()
                .name("invisible_light_medium")
                .family("invisible_light")
                .light((state) -> 10)
                .blocking(false)
                .texture("block/5_miscellaneous/invisible")
                .register(TypeList.of(InvisibleLight.class));
        VanillaProps.stone()
                .group(ModGroups.UTILITY)
                .name("invisible_light")
                .light((state) -> 14)
                .blocking(false)
                .texture("block/5_miscellaneous/invisible")
                .register(TypeList.of(InvisibleLight.class));
    }

    private static ToIntFunction<BlockState> litBlockEmission(int[] lightLevel) {
        return (state) -> {
            switch (state.get(LightSource.LIGHT_0_3)) {
                case 1:
                    return lightLevel[0];
                case 2:
                    return lightLevel[1];
                case 3:
                    return lightLevel[2];
                default:
                    return 0;
            }
        };
    }

}
