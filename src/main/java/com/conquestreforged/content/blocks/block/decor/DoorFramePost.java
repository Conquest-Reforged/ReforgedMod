package com.conquestreforged.content.blocks.block.decor;

import com.conquestreforged.core.asset.annotation.Assets;
import com.conquestreforged.core.asset.annotation.Model;
import com.conquestreforged.core.asset.annotation.State;
import com.conquestreforged.core.block.builder.Props;

@Assets(
        state = @State(name = "%s_door_frame_posts", template = "parent_door_frame_posts"),
        item = @Model(name = "item/%s_door_frame_posts", parent = "block/%s_door_frame_single", template = "item/parent_door_frame_posts"),
        block = {
                @Model(name = "block/%s_door_frame_left", template = "block/parent_door_frame_left"),
                @Model(name = "block/%s_door_frame_right", template = "block/parent_door_frame_right"),
                @Model(name = "block/%s_door_frame_single", template = "block/parent_door_frame_single")
        }
)
public class DoorFramePost extends Posts {

    public DoorFramePost(Props props) {
        super(props);
    }
}
