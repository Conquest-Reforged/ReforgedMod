package com.conquestreforged.client.bind;

import com.conquestreforged.core.client.input.BindEvent;
import com.conquestreforged.core.client.input.BindListener;
import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.state.property.Property;
import net.minecraft.text.Text;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import org.lwjgl.glfw.GLFW;

public class DebugBindListener implements BindListener {

    @Override
    public void onPress(BindEvent event) {
        if (!event.inGame || !event.player.isPresent()) {
            return;
        }

        HitResult result = MinecraftClient.getInstance().crosshairTarget;
        if (result == null) {
            return;
        }

        BlockPos pos = new BlockPos(result.getPos());
        String state = toString(event.player.get().world.getBlockState(pos));
        long window = MinecraftClient.getInstance().getWindow().getHandle();
        event.player.get().sendMessage(Text.of("Copied BlockInfo to clipboard!"));
        GLFW.glfwSetClipboardString(window, '`' + state + '`');
    }

    private static String toString(BlockState state) {
        StringBuilder sb = new StringBuilder(128);
        sb.append(Registry.BLOCK.getId(state.getBlock()));
        int len = sb.length();
        for (Property<?> p : state.getProperties()) {
            if (sb.length() == len) {
                sb.append('[');
            } else {
                sb.append(',');
            }
            sb.append(p.getName()).append('=').append(state.get(p));
        }
        if (sb.length() > len) {
            sb.append(']');
        }
        sb.append('@').append(state.getBlock().getClass().getSimpleName());
        return sb.toString();
    }
}
