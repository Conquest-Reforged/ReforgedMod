package com.conquestreforged.client.gui.dependency.screen;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.gui.widget.list.ExtendedList;

public class ListWidget extends ExtendedList<ListWidget.Entry> {

    private final int width;

    public ListWidget(Screen parent, int width, int top, int bottom) {
        super(parent.getMinecraft(), width, parent.height, top, bottom, 24);
        this.width = width;
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

    public static class Entry extends ExtendedList.AbstractListEntry<Entry> {

        private final Button button;

        public Entry(Button button) {
            this.button = button;
        }

        @Override
        public void render(int entryIdx, int top, int left, int entryWidth, int entryHeight, int mouseX, int mouseY, boolean p_194999_5_, float partialTicks) {
            button.x = left;
            button.y = top;
            button.setWidth(entryWidth - 4);
            button.setHeight(entryHeight);
            button.render(mouseX, mouseY, partialTicks);
        }
    }
}
