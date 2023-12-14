package com.conquestreforged;

import com.conquestreforged.client.BindManager;
import com.conquestreforged.client.Secrets;
import com.conquestreforged.client.events.BlockPicker;
import com.conquestreforged.client.gui.palette.PaletteGuiEvents;
import com.conquestreforged.client.gui.palette.component.PaletteSettings;
import com.conquestreforged.client.tutorial.PaletteTutorial;
import com.conquestreforged.client.tutorial.TutorialRenderEvent;
import com.conquestreforged.content.blocks.init.BlockClientInit;
import com.conquestreforged.content.blocks.init.QParticleFactory;
import com.conquestreforged.content.entities.init.EntityClientInit;
import com.conquestreforged.content.items.init.ItemClientInit;
import com.conquestreforged.core.client.input.Bindings;
import com.conquestreforged.core.config.Config;
import com.conquestreforged.core.config.ConfigBuildEvent;
import com.conquestreforged.core.config.ConfigInit;
import com.conquestreforged.core.init.InitClient;
import com.conquestreforged.core.item.group.manager.ItemGroupManager;
import com.conquestreforged.core.util.log.Log;
import io.github.fabricators_of_create.porting_lib.event.client.ColorHandlersCallback;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientLifecycleEvents;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.screen.v1.ScreenEvents;
import net.fabricmc.fabric.api.client.screen.v1.ScreenKeyboardEvents;
import net.fabricmc.fabric.api.event.client.ClientSpriteRegistryCallback;
import net.fabricmc.fabric.api.event.client.player.ClientPickBlockGatherCallback;
import net.fabricmc.fabric.impl.client.screen.ScreenEventFactory;
import net.minecraft.client.gui.screen.ingame.CreativeInventoryScreen;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.PlayerScreenHandler;
import net.minecraft.util.Identifier;


public class ReforgedModClient implements ClientModInitializer {

    public static ConfigBuildEvent configBuildEvent;

    @Override
    public void onInitializeClient() {

        BlockClientInit.clientBlockEntities();
        ColorHandlersCallback.BLOCK.register(BlockClientInit::items);
        BlockClientInit.blockColors();
        ColorHandlersCallback.BLOCK.register(InitClient::blockColors);
        ColorHandlersCallback.ITEM.register(InitClient::itemColors);
        ItemGroupManager.init();

        ClientSpriteRegistryCallback.event(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE).register((atlasTexture, registry) -> {

            registry.register(new Identifier("conquest", "particle/raven_1"));
            registry.register(new Identifier("conquest", "particle/raven_2"));
            registry.register(new Identifier("conquest", "particle/raven_3"));
            registry.register(new Identifier("conquest", "particle/raven_4"));
            registry.register(new Identifier("conquest", "particle/raven_flying_1"));
            registry.register(new Identifier("conquest", "particle/raven_flying_2"));
            registry.register(new Identifier("conquest", "particle/raven_flying_3"));
            registry.register(new Identifier("conquest", "particle/raven_flying_4"));

            registry.register(new Identifier("conquest", "particle/hawk_1"));
            registry.register(new Identifier("conquest", "particle/hawk_2"));
            registry.register(new Identifier("conquest", "particle/hawk_3"));
            registry.register(new Identifier("conquest", "particle/hawk_4"));
            registry.register(new Identifier("conquest", "particle/hawk_flying_1"));
            registry.register(new Identifier("conquest", "particle/hawk_flying_2"));
            registry.register(new Identifier("conquest", "particle/hawk_flying_3"));
            registry.register(new Identifier("conquest", "particle/hawk_flying_4"));

            registry.register(new Identifier("conquest", "particle/bat_1"));
            registry.register(new Identifier("conquest", "particle/bat_2"));
            registry.register(new Identifier("conquest", "particle/bat_flying_1"));
            registry.register(new Identifier("conquest", "particle/bat_flying_2"));
            registry.register(new Identifier("conquest", "particle/bat_flying_3"));
            registry.register(new Identifier("conquest", "particle/bat_flying_4"));

            registry.register(new Identifier("conquest", "particle/bluejay_1"));
            registry.register(new Identifier("conquest", "particle/bluejay_2"));
            registry.register(new Identifier("conquest", "particle/bluejay_3"));
            registry.register(new Identifier("conquest", "particle/bluejay_4"));
            registry.register(new Identifier("conquest", "particle/bluejay_flying_1"));
            registry.register(new Identifier("conquest", "particle/bluejay_flying_2"));
            registry.register(new Identifier("conquest", "particle/bluejay_flying_3"));
            registry.register(new Identifier("conquest", "particle/bluejay_flying_4"));

            registry.register(new Identifier("conquest", "particle/duck_1"));
            registry.register(new Identifier("conquest", "particle/duck_2"));
            registry.register(new Identifier("conquest", "particle/duck_3"));
            registry.register(new Identifier("conquest", "particle/duck_4"));
            registry.register(new Identifier("conquest", "particle/duck_flying_1"));
            registry.register(new Identifier("conquest", "particle/duck_flying_2"));
            registry.register(new Identifier("conquest", "particle/duck_flying_3"));
            registry.register(new Identifier("conquest", "particle/duck_flying_4"));

            registry.register(new Identifier("conquest", "particle/owl_1"));
            registry.register(new Identifier("conquest", "particle/owl_2"));
            registry.register(new Identifier("conquest", "particle/owl_3"));
            registry.register(new Identifier("conquest", "particle/owl_4"));
            registry.register(new Identifier("conquest", "particle/owl_flying_1"));

            registry.register(new Identifier("conquest", "particle/pigeon_1"));
            registry.register(new Identifier("conquest", "particle/pigeon_2"));
            registry.register(new Identifier("conquest", "particle/pigeon_3"));
            registry.register(new Identifier("conquest", "particle/pigeon_4"));
            registry.register(new Identifier("conquest", "particle/pigeon_flying_1"));
            registry.register(new Identifier("conquest", "particle/pigeon_flying_2"));
            registry.register(new Identifier("conquest", "particle/pigeon_flying_3"));
            registry.register(new Identifier("conquest", "particle/pigeon_flying_4"));


            registry.register(new Identifier("conquest", "particle/puffin_1"));
            registry.register(new Identifier("conquest", "particle/puffin_flying_1"));

            registry.register(new Identifier("conquest", "particle/seagull_1"));
            registry.register(new Identifier("conquest", "particle/seagull_2"));
            registry.register(new Identifier("conquest", "particle/seagull_3"));
            registry.register(new Identifier("conquest", "particle/seagull_4"));
            registry.register(new Identifier("conquest", "particle/seagull_flying_1"));
            registry.register(new Identifier("conquest", "particle/seagull_flying_2"));
            registry.register(new Identifier("conquest", "particle/seagull_flying_3"));
            registry.register(new Identifier("conquest", "particle/seagull_flying_4"));

            registry.register(new Identifier("conquest", "particle/rat_1"));
            registry.register(new Identifier("conquest", "particle/rat_2"));
            registry.register(new Identifier("conquest", "particle/rat_3"));
            registry.register(new Identifier("conquest", "particle/rat_4"));

            registry.register(new Identifier("conquest", "particle/toad_1"));
            registry.register(new Identifier("conquest", "particle/toad_2"));
            registry.register(new Identifier("conquest", "particle/toad_3"));
            registry.register(new Identifier("conquest", "particle/toad_4"));


        });
        QParticleFactory.onParticleFactoryRegistration();

        ClientLifecycleEvents.CLIENT_STARTED.register(ItemClientInit::setup);
        EntityClientInit.setup();

        BlockClientInit.common();

        configBuildEvent = ConfigInit.setup();
        Secrets.config(configBuildEvent);
        PaletteSettings.config(configBuildEvent);
        PaletteTutorial.config(configBuildEvent);
        TutorialRenderEvent.config(configBuildEvent);
        configBuildEvent.forEach((type, builder) -> {
            Config config = new Config(type, builder.build());
            ConfigInit.manager.addConfig(config);
            Log.info(ConfigInit.marker, "Registered config: {}, empty: {}", type, config.getRoot().isEmpty());
        });
        BlockClientInit.client();
        BindManager.init();

        InitClient.init();


        //InitCommon.complete();

        BlockClientInit.complete();


        //InitClient.init();
        ClientTickEvents.START_CLIENT_TICK.register(Bindings::tick);

        ClientPickBlockGatherCallback.EVENT.register((player, result) -> {
            ItemStack stack = BlockPicker.onPick();
            return stack;
        });

        ScreenEvents.BEFORE_INIT.register((client, screen, scaledWidth, scaledHeight) -> {
            if (screen instanceof CreativeInventoryScreen) {
                ScreenKeyboardEvents.beforeKeyPress(screen).register(PaletteGuiEvents::onKeyPress);
            }
        });

        ScreenEventFactory.createAfterKeyPressEvent().register(PaletteGuiEvents::onKeyPress);

        //ScreenEventFactory.createBeforeKeyPressEvent().register(PaletteGuiEvents::onKeyPress);

    }
}
