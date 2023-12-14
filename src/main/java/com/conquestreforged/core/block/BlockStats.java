package com.conquestreforged.core.block;

import net.minecraft.block.Block;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class BlockStats {

    public final int vanillaBlocks;
    public final int vanillaStates;
    public final int conquestBlocks;
    public final int conquestStates;
    public final int totalBlocks;
    public final int totalStates;

    public BlockStats() {
        int vb = 0, vs = 0, cb = 0, cs = 0, tb = 0, ts = 0;
        for (Block block : Registry.BLOCK) {
            tb++;
            ts += block.getStateManager().getStates().size();

            Identifier name = Registry.BLOCK.getId(block);
            if (name == null) {
                continue;
            }


            if (name.getNamespace().equals("minecraft")) {
                vb++;
                vs += block.getStateManager().getStates().size();
                continue;
            }
            if (name.getNamespace().equals("conquest")) {
                cb++;
                cs += block.getStateManager().getStates().size();
            }
        }
        this.vanillaBlocks = vb;
        this.vanillaStates = vs;
        this.conquestBlocks = cb;
        this.conquestStates = cs;
        this.totalBlocks = tb;
        this.totalStates = ts;
    }
}
