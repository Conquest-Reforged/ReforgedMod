package com.conquestreforged.client.gui.dependency.screen;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.gui.widget.list.ExtendedList;

public class ListWidget extends ExtendedList<ListWidget.Entry> {

    private final int width;
    private final int paddingTop;

    public ListWidget(Screen parent, int width, int top, int padding, int bottom) {
        super(parent.getMinecraft(), width, parent.height, top, bottom, 24);
        this.width = width;
        this.paddingTop = padding;
    }

    public void add(Button button) {
        super.addEntry(new Entry(button));
    }

    @Override
    public int getRowWidth() {
        return width;
    }

    @Override
    protected int getScrollbarPosition() {
        return getLeft() + getRowWidth();
    }

    private int getMinWidth() {
        int width = 0;
        for (Entry entry : children()) {
            int w = Minecraft.getInstance().fontRenderer.getStringWidth(entry.button.getMessage());
            width = Math.max(width, w);
        }
        return width + 32;
    }

    public class Entry extends ExtendedList.AbstractListEntry<Entry> {

        private final Button button;

        public Entry(Button button) {
            this.button = button;
        }

        @Override
        public void render(int entryIdx, int top, int left, int entryWidth, int entryHeight, int mouseX, int mouseY, boolean p_194999_5_, float partialTicks) {
            int buttonWidth = Math.min(getMinWidth(), entryWidth - 2);
            int paddingLeft = (entryWidth - buttonWidth) / 2;
            int dx = (left - ListWidget.this.getLeft());

            button.x = left + paddingLeft - dx;
            button.y = top + paddingTop;
            button.setWidth(buttonWidth);
            button.setHeight(20);
            button.render(mouseX, mouseY, partialTicks);
        }
    }
}
