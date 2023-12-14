package com.conquestreforged.content.blocks.block;

import com.conquestreforged.core.asset.annotation.Assets;
import com.conquestreforged.core.asset.annotation.Model;
import com.conquestreforged.core.asset.annotation.State;
import com.conquestreforged.core.block.properties.Waterloggable;

@Assets(
        state = @State(name = "%s_fence_gate", template = "parent_fence_gate_horizontal"),
        item = @Model(name = "item/%s_fence_gate", parent = "block/%s_fence_gate", template = "item/acacia_fence_gate"),
        block = {
                @Model(name = "block/%s_fence_gate", template = "block/parent_fence_gate_horizontal"),
                @Model(name = "block/%s_fence_gate_open", template = "block/parent_fence_gate_horizontal_open")
        }
)
public class FenceGateHorizontal extends FenceGate implements Waterloggable {
    public FenceGateHorizontal(Settings properties) {
        super(properties);
    }
}