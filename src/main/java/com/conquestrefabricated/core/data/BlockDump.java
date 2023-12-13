package com.conquestrefabricated.core.data;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.state.property.Property;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Comparator;
import java.util.Map;

public class BlockDump {

    public static void run() {
        try (Writer blocks = newWriter("blocks-pls.txt"); Writer states = newWriter("states-pls.txt")) {
            Registry.BLOCK.getIds().stream()
                    .filter(block -> block.getNamespace().equals("conquest"))
                    .sorted(Comparator.comparing(Identifier::toString))
                    .forEach(block -> {
                        try {
                            appendBlock(Registry.BLOCK.get(block), blocks);
                            blocks.append('\n');

                            for (BlockState state : Registry.BLOCK.get(block).getStateManager().getStates()) {
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
        if (Registry.BLOCK.getId(block) != null) {
            writer.append(Registry.BLOCK.getId(block).toString());
        }
    }

    private static void appendState(BlockState state, Writer writer) throws IOException {
        appendBlock(state.getBlock(), writer);

        if (!state.getProperties().isEmpty()) {
            writer.append('[');
            boolean first = true;
            for (Map.Entry<Property<?>, ?> e : state.getEntries().entrySet()) {
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
