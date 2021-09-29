package com.hugomage.redpandas.world.gen;


import com.hugomage.redpandas.RedPandas;
import com.hugomage.redpandas.RedPandasConfig;
import com.hugomage.redpandas.init.ModEntityTypes;
import net.minecraft.entity.EntityClassification;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = RedPandas.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class CommonEvents {
    @SubscribeEvent(priority = EventPriority.NORMAL)
    public static void registerBiomes(BiomeLoadingEvent event) {
        if (event.getCategory() == Biome.Category.JUNGLE) {
            event.getSpawns().getSpawner(EntityClassification.CREATURE).add(new MobSpawnInfo.Spawners(ModEntityTypes.REDPANDA.get(), RedPandasConfig.Common.INSTANCE.RedPandaSpawnWeight.get(), 1, 3));
            event.getSpawns().getSpawner(EntityClassification.CREATURE).add(new MobSpawnInfo.Spawners(ModEntityTypes.GIBBON.get(), RedPandasConfig.Common.INSTANCE.GibbonSpawnWeight.get(), 1, 3));

        }
        if (event.getCategory() == Biome.Category.SAVANNA) {
            event.getSpawns().getSpawner(EntityClassification.CREATURE).add(new MobSpawnInfo.Spawners(ModEntityTypes.KOALA.get(), RedPandasConfig.Common.INSTANCE.KoalaSpawnWeight.get(), 1, 2));

        }


        if (event.getName() != null) {
            String name = event.getName().getPath();
            if (name.equals("cold_ocean") || event.getName().equals(new ResourceLocation("minecraft", "deep_cold_ocean"))) {
            }





        }

    }
}
