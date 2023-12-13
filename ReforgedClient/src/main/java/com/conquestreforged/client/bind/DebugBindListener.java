package com.conquestreforged.client.bind;

import com.conquestreforged.core.client.input.BindEvent;
import com.conquestreforged.core.client.input.BindListener;
import net.minecraft.block.BlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.state.IProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.text.StringTextComponent;
import org.lwjgl.glfw.GLFW;

public class DebugBindListener implements BindListener {

    @Override
    public void onPress(BindEvent event) {
        if (!event.inGame || !event.player.isPresent()) {
            return;
        }

        RayTraceResult result = Minecraft.getInstance().objectMouseOver;
        if (result == null) {
            return;
        }

        BlockPos pos = new BlockPos(result.getHitVec());
        String state = toString(event.player.get().world.getBlockState(pos));
        long window = Minecraft.getInstance().getMainWindow().getHandle();
        event.player.get().sendMessage(new StringTextComponent("Copied BlockInfo to clipboard!"));
        GLFW.glfwSetClipboardString(window, '`' + state + '`');
    }

    private static String toString(BlockState state) {
        StringBuilder sb = new StringBuilder(128);
        sb.append(state.getBlock().getRegistryName());
        int len = sb.length();
        for (IProperty<?> p : state.getProperties()) {
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
