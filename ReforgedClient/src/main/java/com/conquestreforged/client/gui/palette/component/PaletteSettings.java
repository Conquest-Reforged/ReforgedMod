package com.conquestreforged.client.gui.palette.component;

import com.conquestreforged.client.gui.render.ColorUtils;
import com.conquestreforged.client.gui.render.Curve;
import com.conquestreforged.core.config.ConfigBuildEvent;
import com.conquestreforged.core.config.section.ConfigSection;
import com.conquestreforged.core.config.section.ConfigSectionSpec;
import com.conquestreforged.core.init.dev.Environment;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.Widget;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.awt.*;

@Mod.EventBusSubscriber(value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class PaletteSettings extends Screen {

    private static final boolean test = false;
    private static ConfigSection config;

    public transient Curve zoomCurve = Curve.SQUARE;

    public float zoomScale = config.getAsFloat("zoom_scale", 1.1);
    public float zoomSpread = config.getAsFloat("zoom_spread", 1);
    public float highlightScale = config.getAsFloat("highlight_scale", 1.1);
    public int highlightColor = ColorUtils.fromHex(config.get("highlight_color"));
    public int hoveredColor = ColorUtils.fromHex(config.get("hovered_color"));
    public int selectedColor = ColorUtils.fromHex(config.get("selected_color"));

    private final Panel left = Panel.left(true);
    private final Panel right = Panel.right(true);

    public PaletteSettings() {
        super(new StringTextComponent("Settings"));
    }

    @Override
    public void init(Minecraft mc, int width, int height) {
        dispose();
        super.init(mc, width, height);
        if (!Environment.isProduction() && test) {
            add(right, new ColorPicker2("Highlight Color", highlightColor, c -> {
                highlightColor = c;
                config.set("highlight_color", ColorUtils.toHex(c));
            }));
            add(right, new ColorPicker2("Hovered Color", hoveredColor, c -> {
                hoveredColor = c;
                config.set("hovered_color", ColorUtils.toHex(c));
            }));
            add(right, new ColorPicker2("Selected Color", selectedColor, c -> {
                selectedColor = c;
                config.set("selected_color", ColorUtils.toHex(c));
            }));
            left.setSize(this, width / 3, height);
            right.setSize(this, width / 3, height);
        }
    }

    @Override
    public void render(int mx, int my, float ticks) {
        left.tick();
        right.tick();
        super.render(mx, my, ticks);
    }

    @Override
    public void removed() {
        dispose();
        config.save();
    }

    @Override
    public void onClose() {
        super.onClose();
        dispose();
        config.save();
    }

    private void dispose() {
        for (Widget widget : buttons) {
            if (widget instanceof ColorPicker) {
                ((ColorPicker) widget).dispose();
            }
        }
    }

    private void add(Panel panel, Widget widget) {
        super.addButton(widget);
        panel.add(widget);
    }

    @SubscribeEvent
    public static void config(ConfigBuildEvent event) {
        try (ConfigSectionSpec spec = event.client("palette")) {
            spec.getBuilder().comment("Controls how large items get when your cursor moves towards them");
            spec.getBuilder().define("zoom_scale", 1.1).next();

            spec.getBuilder().comment("Controls the number of items that are affected by the zoom effect");
            spec.getBuilder().defineInRange("zoom_spread", 1.0, 0, 1.0).next();

            spec.getBuilder().comment("Controls the size of the colored highlight around items");
            spec.getBuilder().defineInRange("highlight_size", 1.1, 1.0, 2.0).next();

            spec.getBuilder().comment("The highlight color around idle items");
            spec.getBuilder().define("highlight_color", ColorUtils.toHex(Color.BLACK)).next();

            spec.getBuilder().comment("The highlight color around the item under your cursor");
            spec.getBuilder().define("hovered_color", ColorUtils.toHex(Color.GRAY)).next();

            spec.getBuilder().comment("The highlight color around the selected/dragged item");
            spec.getBuilder().define("selected_color", ColorUtils.toHex(Color.WHITE)).next();

            PaletteSettings.config = spec.getSection();
        }
    }
}
