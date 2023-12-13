package com.conquestreforged.core.data;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.state.IProperty;
import net.minecraftforge.registries.ForgeRegistries;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Comparator;
import java.util.Map;

public class BlockDump {

    public static void run() {
        try (Writer blocks = newWriter("blocks-pls.txt"); Writer states = newWriter("states-pls.txt")) {
            ForgeRegistries.BLOCKS.getValues().stream()
                    .filter(block -> block.getRegistryName().getNamespace().equals("conquest"))
                    .sorted(Comparator.comparing(Block::getRegistryName))
                    .forEach(block -> {
                        try {
                            appendBlock(block, blocks);
                            blocks.append('\n');

                            for (BlockState state : block.getStateContainer().getValidStates()) {
                                appendState(state, states);
                                states.append('\n');
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Writer newWriter(String name) throws IOException {
        return new BufferedWriter(new FileWriter(name));
    }

    private static void appendBlock(Block block, Writer writer) throws IOException {
        if (block.getRegistryName() != null) {
            writer.append(block.getRegistryName().toString());
        }
    }

    private static void appendState(BlockState state, Writer writer) throws IOException {
        appendBlock(state.getBlock(), writer);

        if (!state.getProperties().isEmpty()) {
            writer.append('[');
            boolean first = true;
            for (Map.Entry<IProperty<?>, ?> e : state.getValues().entrySet()) {
                if (!first) {
                    writer.append(',');
                }
                first = false;
                writer.append(e.getKey().getName()).append('=').append(e.getValue().toString());
            }
            writer.append(']');
        }
    }
}
