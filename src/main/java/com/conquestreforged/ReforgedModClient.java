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
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;


public class ReforgedModClient {

    public static ConfigBuildEvent configBuildEvent;

    @SubscribeEvent
    public static void onInitializeClient(FMLClientSetupEvent event) {

        BlockClientInit.clientBlockEntities();
        ColorHandlersCallback.BLOCK.register(BlockClientInit::items);
        BlockClientInit.blockColors();
        ColorHandlersCallback.BLOCK.register(InitClient::blockColors);
        ColorHandlersCallback.ITEM.register(InitClient::itemColors);
        ItemGroupManager.init();

        ClientSpriteRegistryCallback.event(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE).register((atlasTexture, registry) -> {

            registry.register(new ResourceLocation("conquest", "particle/raven_1"));
            registry.register(new ResourceLocation("conquest", "particle/raven_2"));
            registry.register(new ResourceLocation("conquest", "particle/raven_3"));
            registry.register(new ResourceLocation("conquest", "particle/raven_4"));
            registry.register(new ResourceLocation("conquest", "particle/raven_flying_1"));
            registry.register(new ResourceLocation("conquest", "particle/raven_flying_2"));
            registry.register(new ResourceLocation("conquest", "particle/raven_flying_3"));
            registry.register(new ResourceLocation("conquest", "particle/raven_flying_4"));

            registry.register(new ResourceLocation("conquest", "particle/hawk_1"));
            registry.register(new ResourceLocation("conquest", "particle/hawk_2"));
            registry.register(new ResourceLocation("conquest", "particle/hawk_3"));
            registry.register(new ResourceLocation("conquest", "particle/hawk_4"));
            registry.register(new ResourceLocation("conquest", "particle/hawk_flying_1"));
            registry.register(new ResourceLocation("conquest", "particle/hawk_flying_2"));
            registry.register(new ResourceLocation("conquest", "particle/hawk_flying_3"));
            registry.register(new ResourceLocation("conquest", "particle/hawk_flying_4"));

            registry.register(new ResourceLocation("conquest", "particle/bat_1"));
            registry.register(new ResourceLocation("conquest", "particle/bat_2"));
            registry.register(new ResourceLocation("conquest", "particle/bat_flying_1"));
            registry.register(new ResourceLocation("conquest", "particle/bat_flying_2"));
            registry.register(new ResourceLocation("conquest", "particle/bat_flying_3"));
            registry.register(new ResourceLocation("conquest", "particle/bat_flying_4"));

            registry.register(new ResourceLocation("conquest", "particle/bluejay_1"));
            registry.register(new ResourceLocation("conquest", "particle/bluejay_2"));
            registry.register(new ResourceLocation("conquest", "particle/bluejay_3"));
            registry.register(new ResourceLocation("conquest", "particle/bluejay_4"));
            registry.register(new ResourceLocation("conquest", "particle/bluejay_flying_1"));
            registry.register(new ResourceLocation("conquest", "particle/bluejay_flying_2"));
            registry.register(new ResourceLocation("conquest", "particle/bluejay_flying_3"));
            registry.register(new ResourceLocation("conquest", "particle/bluejay_flying_4"));

            registry.register(new ResourceLocation("conquest", "particle/duck_1"));
            registry.register(new ResourceLocation("conquest", "particle/duck_2"));
            registry.register(new ResourceLocation("conquest", "particle/duck_3"));
            registry.register(new ResourceLocation("conquest", "particle/duck_4"));
            registry.register(new ResourceLocation("conquest", "particle/duck_flying_1"));
            registry.register(new ResourceLocation("conquest", "particle/duck_flying_2"));
            registry.register(new ResourceLocation("conquest", "particle/duck_flying_3"));
            registry.register(new ResourceLocation("conquest", "particle/duck_flying_4"));

            registry.register(new ResourceLocation("conquest", "particle/owl_1"));
            registry.register(new ResourceLocation("conquest", "particle/owl_2"));
            registry.register(new ResourceLocation("conquest", "particle/owl_3"));
            registry.register(new ResourceLocation("conquest", "particle/owl_4"));
            registry.register(new ResourceLocation("conquest", "particle/owl_flying_1"));

            registry.register(new ResourceLocation("conquest", "particle/pigeon_1"));
            registry.register(new ResourceLocation("conquest", "particle/pigeon_2"));
            registry.register(new ResourceLocation("conquest", "particle/pigeon_3"));
            registry.register(new ResourceLocation("conquest", "particle/pigeon_4"));
            registry.register(new ResourceLocation("conquest", "particle/pigeon_flying_1"));
            registry.register(new ResourceLocation("conquest", "particle/pigeon_flying_2"));
            registry.register(new ResourceLocation("conquest", "particle/pigeon_flying_3"));
            registry.register(new ResourceLocation("conquest", "particle/pigeon_flying_4"));


            registry.register(new ResourceLocation("conquest", "particle/puffin_1"));
            registry.register(new ResourceLocation("conquest", "particle/puffin_flying_1"));

            registry.register(new ResourceLocation("conquest", "particle/seagull_1"));
            registry.register(new ResourceLocation("conquest", "particle/seagull_2"));
            registry.register(new ResourceLocation("conquest", "particle/seagull_3"));
            registry.register(new ResourceLocation("conquest", "particle/seagull_4"));
            registry.register(new ResourceLocation("conquest", "particle/seagull_flying_1"));
            registry.register(new ResourceLocation("conquest", "particle/seagull_flying_2"));
            registry.register(new ResourceLocation("conquest", "particle/seagull_flying_3"));
            registry.register(new ResourceLocation("conquest", "particle/seagull_flying_4"));

            registry.register(new ResourceLocation("conquest", "particle/rat_1"));
            registry.register(new ResourceLocation("conquest", "particle/rat_2"));
            registry.register(new ResourceLocation("conquest", "particle/rat_3"));
            registry.register(new ResourceLocation("conquest", "particle/rat_4"));

            registry.register(new ResourceLocation("conquest", "particle/toad_1"));
            registry.register(new ResourceLocation("conquest", "particle/toad_2"));
            registry.register(new ResourceLocation("conquest", "particle/toad_3"));
            registry.register(new ResourceLocation("conquest", "particle/toad_4"));


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
