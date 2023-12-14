package com.conquestreforged.client.bind;

import com.conquestreforged.core.client.input.BindEvent;
import com.conquestreforged.core.client.input.BindListener;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.HitResult;
import org.lwjgl.glfw.GLFW;

public class DebugBindListener implements BindListener {

    @Override
    public void onPress(BindEvent event) {
        if (!event.inGame || !event.player.isPresent()) {
            return;
        }

        HitResult result = Minecraft.getInstance().hitResult;
        if (result == null) {
            return;
        }

        BlockPos pos = new BlockPos((int) result.getLocation().x, (int) result.getLocation().y, (int) result.getLocation().z);
        String state = toString(event.player.get().level().getBlockState(pos));
        long window = Minecraft.getInstance().getWindow().getWindow();
        event.player.get().sendSystemMessage(Component.literal("Copied BlockInfo to clipboard!"));
        GLFW.glfwSetClipboardString(window, '`' + state + '`');
    }

    private static String toString(BlockState state) {
        StringBuilder sb = new StringBuilder(128);
        sb.append(BuiltInRegistries.BLOCK.getId(state.getBlock()));
        int len = sb.length();
        for (Property<?> p : state.getProperties()) {
            if (sb.length() == len) {
                sb.append('[');
            } else {
                sb.append(',');
            }
            sb.append(p.getName()).append('=').append(state.getValue(p));
        }
        if (sb.length() > len) {
            sb.append(']');
        }
        sb.append('@').append(state.getBlock().getClass().getSimpleName());
        return sb.toString();
    }
}
