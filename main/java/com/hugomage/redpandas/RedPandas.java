package com.hugomage.redpandas;

import com.hugomage.redpandas.entity.*;
import com.hugomage.redpandas.init.ModEntityTypes;
import com.hugomage.redpandas.util.ClientEventBusSubscriber;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.world.gen.Heightmap;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.pattern.AbstractStyleNameConverter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("eighthpscritters")
public class RedPandas
{
    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "eighthpscritters";
    public static final List<Runnable> CALLBACKS = new ArrayList<>();
    private static final String ID = "eighthpscritters";
    public RedPandas() {
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        // Register the enqueueIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        // Register the processIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
        // Register the doClientStuff method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::registerClient);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::registerCommon);
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
        com.hugomage.redpandas.init.ModEntityTypes.ENTITY_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus());
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, RedPandasConfig.Common.SPEC);
        com.hugomage.redpandas.util.RegistryHandler.init();
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        // some preinit code
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }
    private void registerClient(FMLClientSetupEvent event) {
        ClientEventBusSubscriber.init();
        CALLBACKS.forEach(Runnable::run);
        CALLBACKS.clear();
    }

    private void enqueueIMC(final InterModEnqueueEvent event)
    {
        // some example code to dispatch IMC to another mod
        InterModComms.sendTo("examplemod", "helloworld", () -> { LOGGER.info("Hello world from the MDK"); return "Hello world";});
    }
    private void registerCommon(FMLCommonSetupEvent event) {
        registerEntityAttributes();
        EntitySpawnPlacementRegistry.register(ModEntityTypes.REDPANDA.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING, AnimalEntity::checkAnimalSpawnRules);
        EntitySpawnPlacementRegistry.register(ModEntityTypes.KOALA.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING, AnimalEntity::checkAnimalSpawnRules);
        EntitySpawnPlacementRegistry.register(ModEntityTypes.GIBBON.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING, AnimalEntity::checkAnimalSpawnRules);
        EntitySpawnPlacementRegistry.register(ModEntityTypes.ANT.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING, AnimalEntity::checkAnimalSpawnRules);
        EntitySpawnPlacementRegistry.register(ModEntityTypes.CARACAL.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING, AnimalEntity::checkAnimalSpawnRules);
        EntitySpawnPlacementRegistry.register(ModEntityTypes.GILAMONSTER.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING, AnimalEntity::checkAnimalSpawnRules);
        EntitySpawnPlacementRegistry.register(ModEntityTypes.OPOSSUM.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING, AnimalEntity::checkAnimalSpawnRules);

    }
    private void registerEntityAttributes() {

    }
    private void processIMC(final InterModProcessEvent event)
    {
        DeferredWorkQueue.runLater(() -> {
            GlobalEntityTypeAttributes.put(ModEntityTypes.REDPANDA.get(), RedPandaEntity.setCustomAttributes().build());
            GlobalEntityTypeAttributes.put(ModEntityTypes.GIBBON.get(), GibbonEntity.setCustomAttributes().build());
            GlobalEntityTypeAttributes.put(ModEntityTypes.KOALA.get(), KoalaEntity.setCustomAttributes().build());
            GlobalEntityTypeAttributes.put(ModEntityTypes.ANT.get(), AntEntity.setCustomAttributes().build());
            GlobalEntityTypeAttributes.put(ModEntityTypes.CARACAL.get(), CaracalEntity.setCustomAttributes().build());
            GlobalEntityTypeAttributes.put(ModEntityTypes.GILAMONSTER.get(), GilaMonsterEntity.setCustomAttributes().build());
            GlobalEntityTypeAttributes.put(ModEntityTypes.OPOSSUM.get(), OpossumEntity.setCustomAttributes().build());


            // spawning




        });


        // some example code to receive and process InterModComms from other mods
        LOGGER.info("Got IMC {}", event.getIMCStream().
                map(m->m.getMessageSupplier().get()).
                collect(Collectors.toList()));
    }
    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
        // do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
            // register a new block here
            LOGGER.info("HELLO from Register Block");
        }
    }
}
