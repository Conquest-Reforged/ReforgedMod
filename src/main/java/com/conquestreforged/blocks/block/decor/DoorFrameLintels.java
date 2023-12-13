package com.conquestreforged.blocks.block.decor;

import com.conquestreforged.core.asset.annotation.Assets;
import com.conquestreforged.core.asset.annotation.Model;
import com.conquestreforged.core.asset.annotation.State;
import com.conquestreforged.core.block.builder.Props;

@Assets(
        state = @State(name = "%s_door_frame_lintel", template = "parent_door_frame_lintel"),
        item = @Model(name = "item/%s_door_frame_lintel", parent = "block/%s_door_frame_single_top", template = "item/parent_door_frame_lintel"),
        block = {
                @Model(name = "block/%s_door_frame_left_bottom", template = "block/parent_door_frame_left_bottom"),
                @Model(name = "block/%s_door_frame_right_bottom", template = "block/parent_door_frame_right_bottom"),
                @Model(name = "block/%s_door_frame_middle_bottom", template = "block/parent_door_frame_middle_bottom"),
                @Model(name = "block/%s_door_frame_single_bottom", template = "block/parent_door_frame_single_bottom"),
                @Model(name = "block/%s_door_frame_left_top", template = "block/parent_door_frame_left_top"),
                @Model(name = "block/%s_door_frame_right_top", template = "block/parent_door_frame_right_top"),
                @Model(name = "block/%s_door_frame_middle_top", template = "block/parent_door_frame_middle_top"),
                @Model(name = "block/%s_door_frame_single_top", template = "block/parent_door_frame_single_top")
        }
)
public class DoorFrameLintels extends Lintels {

    public DoorFrameLintels(Props props) {
        super(props);
    }
}
