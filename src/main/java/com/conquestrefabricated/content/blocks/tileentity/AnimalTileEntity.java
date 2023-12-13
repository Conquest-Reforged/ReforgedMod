package com.conquestrefabricated.content.blocks.tileentity;

import com.conquestrefabricated.content.blocks.block.decor.Animal;
import com.conquestrefabricated.content.blocks.block.decor.AnimalBird;
import com.conquestrefabricated.content.blocks.init.ParticleRegistrar;
import com.conquestrefabricated.content.blocks.particles.AnimalParticleData;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;


public class AnimalTileEntity extends BlockEntity {

    public AnimalTileEntity(BlockPos pos, BlockState state) {
        super(TileEntityTypes.ANIMAL, pos, state);
    }
/*
    @ObjectHolder("conquest:raven")
    private static Block raven = Dummy.block();
    @ObjectHolder("conquest:hawk")
    private static Block hawk = Dummy.block();
    @ObjectHolder("conquest:bat")
    private static Block bat = Dummy.block();
    @ObjectHolder("conquest:bluejay")
    private static Block bluejay = Dummy.block();
    @ObjectHolder("conquest:duck")
    private static Block duck = Dummy.block();
    @ObjectHolder("conquest:owl")
    private static Block owl = Dummy.block();
    @ObjectHolder("conquest:pigeon")
    private static Block pigeon = Dummy.block();
    @ObjectHolder("conquest:puffin")
    private static Block puffin = Dummy.block();
    @ObjectHolder("conquest:rat")
    private static Block rat = Dummy.block();
    @ObjectHolder("conquest:seagull")
    private static Block seagull = Dummy.block();
    @ObjectHolder("conquest:toad")
    private static Block toad = Dummy.block();
*/
    private static AnimalParticleData[] ravenParticles = {
            new AnimalParticleData(ParticleRegistrar.raven1ParticleType),
            new AnimalParticleData(ParticleRegistrar.raven2ParticleType),
            new AnimalParticleData(ParticleRegistrar.raven3ParticleType),
            new AnimalParticleData(ParticleRegistrar.raven4ParticleType),
            new AnimalParticleData(ParticleRegistrar.ravenFlying1ParticleType),
            new AnimalParticleData(ParticleRegistrar.ravenFlying2ParticleType),
            new AnimalParticleData(ParticleRegistrar.ravenFlying3ParticleType),
            new AnimalParticleData(ParticleRegistrar.ravenFlying4ParticleType)
    };

    private static AnimalParticleData[] hawkParticles = {
            new AnimalParticleData(ParticleRegistrar.hawk1ParticleType),
            new AnimalParticleData(ParticleRegistrar.hawk2ParticleType),
            new AnimalParticleData(ParticleRegistrar.hawk3ParticleType),
            new AnimalParticleData(ParticleRegistrar.hawk4ParticleType),
            new AnimalParticleData(ParticleRegistrar.hawkFlying1ParticleType),
            new AnimalParticleData(ParticleRegistrar.hawkFlying2ParticleType),
            new AnimalParticleData(ParticleRegistrar.hawkFlying3ParticleType),
            new AnimalParticleData(ParticleRegistrar.hawkFlying4ParticleType)
    };

    private static AnimalParticleData[] batParticles = {
            new AnimalParticleData(ParticleRegistrar.bat1ParticleType),
            new AnimalParticleData(ParticleRegistrar.bat2ParticleType),
            new AnimalParticleData(ParticleRegistrar.bat2ParticleType),
            new AnimalParticleData(ParticleRegistrar.bat2ParticleType),
            new AnimalParticleData(ParticleRegistrar.batFlying1ParticleType),
            new AnimalParticleData(ParticleRegistrar.batFlying2ParticleType),
            new AnimalParticleData(ParticleRegistrar.batFlying3ParticleType),
            new AnimalParticleData(ParticleRegistrar.batFlying4ParticleType)
    };

    private static AnimalParticleData[] bluejayParticles = {
            new AnimalParticleData(ParticleRegistrar.bluejay1ParticleType),
            new AnimalParticleData(ParticleRegistrar.bluejay2ParticleType),
            new AnimalParticleData(ParticleRegistrar.bluejay3ParticleType),
            new AnimalParticleData(ParticleRegistrar.bluejay4ParticleType),
            new AnimalParticleData(ParticleRegistrar.bluejayFlying1ParticleType),
            new AnimalParticleData(ParticleRegistrar.bluejayFlying2ParticleType),
            new AnimalParticleData(ParticleRegistrar.bluejayFlying3ParticleType),
            new AnimalParticleData(ParticleRegistrar.bluejayFlying4ParticleType)
    };

    private static AnimalParticleData[] duckParticles = {
            new AnimalParticleData(ParticleRegistrar.duck1ParticleType),
            new AnimalParticleData(ParticleRegistrar.duck2ParticleType),
            new AnimalParticleData(ParticleRegistrar.duck3ParticleType),
            new AnimalParticleData(ParticleRegistrar.duck4ParticleType),
            new AnimalParticleData(ParticleRegistrar.duckFlying1ParticleType),
            new AnimalParticleData(ParticleRegistrar.duckFlying2ParticleType),
            new AnimalParticleData(ParticleRegistrar.duckFlying3ParticleType),
            new AnimalParticleData(ParticleRegistrar.duckFlying4ParticleType)
    };

    private static AnimalParticleData[] owlParticles = {
            new AnimalParticleData(ParticleRegistrar.owl1ParticleType),
            new AnimalParticleData(ParticleRegistrar.owl2ParticleType),
            new AnimalParticleData(ParticleRegistrar.owl3ParticleType),
            new AnimalParticleData(ParticleRegistrar.owl4ParticleType),
            new AnimalParticleData(ParticleRegistrar.owlFlying1ParticleType),
            new AnimalParticleData(ParticleRegistrar.owlFlying1ParticleType),
            new AnimalParticleData(ParticleRegistrar.owlFlying1ParticleType),
            new AnimalParticleData(ParticleRegistrar.owlFlying1ParticleType)
    };

    private static AnimalParticleData[] pigeonParticles = {
            new AnimalParticleData(ParticleRegistrar.pigeon1ParticleType),
            new AnimalParticleData(ParticleRegistrar.pigeon2ParticleType),
            new AnimalParticleData(ParticleRegistrar.pigeon3ParticleType),
            new AnimalParticleData(ParticleRegistrar.pigeon4ParticleType),
            new AnimalParticleData(ParticleRegistrar.pigeonFlying1ParticleType),
            new AnimalParticleData(ParticleRegistrar.pigeonFlying2ParticleType),
            new AnimalParticleData(ParticleRegistrar.pigeonFlying3ParticleType),
            new AnimalParticleData(ParticleRegistrar.pigeonFlying4ParticleType)
    };

    private static AnimalParticleData[] puffinParticles = {
            new AnimalParticleData(ParticleRegistrar.puffin1ParticleType),
            new AnimalParticleData(ParticleRegistrar.puffin1ParticleType),
            new AnimalParticleData(ParticleRegistrar.puffin1ParticleType),
            new AnimalParticleData(ParticleRegistrar.puffin1ParticleType),
            new AnimalParticleData(ParticleRegistrar.puffinFlying1ParticleType),
            new AnimalParticleData(ParticleRegistrar.puffinFlying1ParticleType),
            new AnimalParticleData(ParticleRegistrar.puffinFlying1ParticleType),
            new AnimalParticleData(ParticleRegistrar.puffinFlying1ParticleType)
    };

    private static AnimalParticleData[] seagullParticles = {
            new AnimalParticleData(ParticleRegistrar.seagull1ParticleType),
            new AnimalParticleData(ParticleRegistrar.seagull2ParticleType),
            new AnimalParticleData(ParticleRegistrar.seagull3ParticleType),
            new AnimalParticleData(ParticleRegistrar.seagull4ParticleType),
            new AnimalParticleData(ParticleRegistrar.seagullFlying1ParticleType),
            new AnimalParticleData(ParticleRegistrar.seagullFlying2ParticleType),
            new AnimalParticleData(ParticleRegistrar.seagullFlying3ParticleType),
            new AnimalParticleData(ParticleRegistrar.seagullFlying4ParticleType)
    };

    private static AnimalParticleData[] ratParticles = {
            new AnimalParticleData(ParticleRegistrar.rat1ParticleType),
            new AnimalParticleData(ParticleRegistrar.rat2ParticleType),
            new AnimalParticleData(ParticleRegistrar.rat3ParticleType),
            new AnimalParticleData(ParticleRegistrar.rat4ParticleType)
    };

    private static AnimalParticleData[] toadParticles = {
            new AnimalParticleData(ParticleRegistrar.toad1ParticleType),
            new AnimalParticleData(ParticleRegistrar.toad2ParticleType),
            new AnimalParticleData(ParticleRegistrar.toad3ParticleType),
            new AnimalParticleData(ParticleRegistrar.toad4ParticleType)
    };

    /*@Override
    public void tick(Level level, BlockPos blockPos, BlockState state, BlockEntity blockEntity) {
        if (this.level.isClientSide) {
            double xpos = worldPosition.getX() + 0.5;
            double ypos = worldPosition.getY() + 0.5;
            double zpos = worldPosition.getZ() + 0.5;

            switch(this.getBlockState().getBlock().toString()) {
                case "Block{conquest:raven}":
                    checkBlockAddParticle(ravenParticles, xpos, ypos, zpos);
                    break;
                case "Block{conquest:hawk}":
                    checkBlockAddParticle(hawkParticles, xpos, ypos, zpos);
                    break;
                case "Block{conquest:bat}":
                    checkBlockAddParticle(batParticles, xpos, ypos, zpos);
                    break;
                case "Block{conquest:bluejay}":
                    checkBlockAddParticle(bluejayParticles, xpos, ypos, zpos);
                    break;
                case "Block{conquest:duck}":
                    checkBlockAddParticle(duckParticles, xpos, ypos, zpos);
                    break;
                case "Block{conquest:owl}":
                    checkBlockAddParticle(owlParticles, xpos, ypos, zpos);
                    break;
                case "Block{conquest:pigeon}":
                    checkBlockAddParticle(pigeonParticles, xpos, ypos, zpos);
                    break;
                case "Block{conquest:puffin}":
                    checkBlockAddParticle(puffinParticles, xpos, ypos, zpos);
                    break;
                case "Block{conquest:seagull}":
                    checkBlockAddParticle(seagullParticles, xpos, ypos, zpos);
                    break;
                case "Block{conquest:toad}":
                    checkBlockAddParticle(toadParticles, xpos, ypos, zpos);
                    break;
                case "Block{conquest:rat}":
                    checkBlockAddParticle(ratParticles, xpos, ypos, zpos);
                    break;
            }

        }
    }*/

    public static void particleTick (World level, BlockPos blockPos, BlockState state, AnimalTileEntity blockEntity) {
        if (level.isClient) {
            double xpos = blockPos.getX() + 0.5;
            double ypos = blockPos.getY() + 0.5;
            double zpos = blockPos.getZ() + 0.5;

            switch(state.getBlock().toString()) {
                case "Block{conquest:raven}":
                    checkBlockAddParticle(ravenParticles, xpos, ypos, zpos, level, state);
                    break;
                case "Block{conquest:hawk}":
                    checkBlockAddParticle(hawkParticles, xpos, ypos, zpos, level, state);
                    break;
                case "Block{conquest:bat}":
                    checkBlockAddParticle(batParticles, xpos, ypos, zpos, level, state);
                    break;
                case "Block{conquest:bluejay}":
                    checkBlockAddParticle(bluejayParticles, xpos, ypos, zpos, level, state);
                    break;
                case "Block{conquest:duck}":
                    checkBlockAddParticle(duckParticles, xpos, ypos, zpos, level, state);
                    break;
                case "Block{conquest:owl}":
                    checkBlockAddParticle(owlParticles, xpos, ypos, zpos, level, state);
                    break;
                case "Block{conquest:pigeon}":
                    checkBlockAddParticle(pigeonParticles, xpos, ypos, zpos, level, state);
                    break;
                case "Block{conquest:puffin}":
                    checkBlockAddParticle(puffinParticles, xpos, ypos, zpos, level, state);
                    break;
                case "Block{conquest:seagull}":
                    checkBlockAddParticle(seagullParticles, xpos, ypos, zpos, level, state);
                    break;
                case "Block{conquest:toad}":
                    checkBlockAddParticle(toadParticles, xpos, ypos, zpos, level, state);
                    break;
                case "Block{conquest:rat}":
                    checkBlockAddParticle(ratParticles, xpos, ypos, zpos, level, state);
                    break;
            }

        }
    }

    private static void checkBlockAddParticle(AnimalParticleData[] animalParticles, double xpos, double ypos, double zpos, World level, BlockState state) {
        if (state.getBlock() instanceof AnimalBird && state.get(AnimalBird.FLYING)) {
            switch (state.get(Animal.TOGGLE)) {
                case 1:
                    addAnimalParticle(animalParticles[4], xpos, ypos, zpos, level);
                    break;
                case 2:
                    addAnimalParticle(animalParticles[5], xpos, ypos, zpos, level);
                    break;
                case 3:
                    addAnimalParticle(animalParticles[6], xpos, ypos, zpos, level);
                    break;
                case 4:
                    addAnimalParticle(animalParticles[7], xpos, ypos, zpos, level);
                    break;
            }
        } else {
            switch (state.get(Animal.TOGGLE)) {
                case 1:
                    addAnimalParticle(animalParticles[0], xpos, ypos, zpos, level);
                    break;
                case 2:
                    addAnimalParticle(animalParticles[1], xpos, ypos, zpos, level);
                    break;
                case 3:
                    addAnimalParticle(animalParticles[2], xpos, ypos, zpos, level);
                    break;
                case 4:
                    addAnimalParticle(animalParticles[3], xpos, ypos, zpos, level);
                    break;
            }
        }
    }

    private static void addAnimalParticle(AnimalParticleData animal, double xpos, double ypos, double zpos, World level) {
        for (int i = 0; i < 2; i++) {
            level.addParticle(animal, true, xpos, ypos, zpos, 0, 0, 0);
        }
    }
}