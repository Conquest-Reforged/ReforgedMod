package com.conquestrefabricated.client.tutorial;

import com.conquestrefabricated.client.gui.dependency.Dependency;
import com.conquestrefabricated.client.gui.dependency.DependencyList;
import com.conquestrefabricated.client.gui.dependency.screen.DependencyScreen;
import com.conquestrefabricated.client.gui.intro.IntroScreen;
import com.conquestrefabricated.core.config.ConfigBuildEvent;
import com.conquestrefabricated.core.config.section.ConfigSection;
import com.conquestrefabricated.core.config.section.ConfigSectionSpec;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.TitleScreen;

import java.util.List;

@Environment(EnvType.CLIENT)
public class TutorialRenderEvent {

    private final ConfigSection section;
    private final DependencyList dependencies = DependencyList.load();
    private boolean hasRenderedIntro = false;
    private boolean hasRenderedDependency = false;

    public TutorialRenderEvent(ConfigSection section) {
        this.section = section;
    }


    public static void config(ConfigBuildEvent event) {
        try (ConfigSectionSpec spec = event.client("tutorials")) {
            spec.getBuilder().define("ignore_dependencies", false).next();
            spec.getBuilder().define("ignore_intro", false).next();
            //MinecraftForge.EVENT_BUS.register(new TutorialRenderEvent(spec.getSection()));
        }
    }

   // @SubscribeEvent
    public void render(Screen currentScreen) {
        if (currentScreen instanceof TitleScreen) {
            List<Dependency> missing = dependencies.getMissingDependencies();
            IntroScreen introScreen = new IntroScreen(currentScreen, section);
            DependencyScreen dependencyScreen = new DependencyScreen(currentScreen, section, missing);
            DependencyScreen dependencyScreen2 = new DependencyScreen(introScreen, section, missing);

            if ((section.getOrElse("ignore_dependencies", false) && section.getOrElse("ignore_intro", false))
                    || (missing.isEmpty() && Tutorials.intro)
                    || (Tutorials.dependencies && Tutorials.intro)
            ) {
                //MinecraftForge.EVENT_BUS.unregister(this);
                return;
            }

            if (!Tutorials.intro) {
                if (section.getOrElse("ignore_intro", false)) {
                    if (!missing.isEmpty()) {
                        MinecraftClient.getInstance().setScreen(dependencyScreen);
                    }
                    if (Tutorials.dependencies || missing.isEmpty()) {
                       // MinecraftForge.EVENT_BUS.unregister(this);
                    }
                } else if (section.getOrElse("ignore_dependencies", false) || missing.isEmpty()) {
                    MinecraftClient.getInstance().setScreen(introScreen);
                } else {
                    MinecraftClient.getInstance().setScreen(dependencyScreen2);
                }
            }
        }
    }
}
