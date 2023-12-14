package com.conquestreforged.client.gui.painting;

import com.conquestreforged.api.painting.Painting;
import com.conquestreforged.api.painting.art.Art;
import com.conquestreforged.client.gui.PickerScreen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;


public class PaintingScreen<T> extends PickerScreen<Art<T>> {

    private final Painting type;

    public PaintingScreen(ItemStack stack, Painting type, Art<T> art) {
        super("Painting Selector", stack, art, art.getAll());
        this.type = type;
    }

    @Override
    public int getWidth(Art<T> option) {
        return option.width();
    }

    @Override
    public int getHeight(Art<T> option) {
        return option.height();
    }

    @Override
    public String getDisplayName(Art<T> option) {
        return option.getName();
    }



    @Override
    public void render(Art<T> option, MatrixStack matrixStack, int x, int y, int width, int height, float scale) {
        option.getRenderer().render(type, option, matrixStack, x, y, width, height);
    }

    @Override
    public ItemStack createItemStack(ItemStack original, Art<T> value) {
        ItemStack stack = type.createStack(value);
        stack.setCount(original.getCount());
        return stack;
    }
}
