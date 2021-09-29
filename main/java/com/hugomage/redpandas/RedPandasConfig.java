package com.hugomage.redpandas;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import org.apache.commons.lang3.tuple.Pair;

@Mod.EventBusSubscriber(modid = RedPandas.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class RedPandasConfig {
    public static int RedPandaSpawnWeight;
    public static int GibbonSpawnWeight;
    public static int KoalaSpawnWeight;


    @SubscribeEvent
    public static void configLoad(ModConfig.ModConfigEvent event) {
        try {
            ForgeConfigSpec spec = event.getConfig().getSpec();
            if (spec == Common.SPEC) Common.reload();
        }
        catch (Throwable e) {
              }
    }


    public static class Common {
        public static final Common INSTANCE;
        public static final ForgeConfigSpec SPEC;

        static {
            Pair<Common, ForgeConfigSpec> pair = new ForgeConfigSpec.Builder().configure(Common::new);
            INSTANCE = pair.getLeft();
            SPEC = pair.getRight();
        }


        public final ForgeConfigSpec.IntValue RedPandaSpawnWeight;
        public final ForgeConfigSpec.IntValue GibbonSpawnWeight;
        public final ForgeConfigSpec.IntValue KoalaSpawnWeight;

        Common(ForgeConfigSpec.Builder builder) {

            builder.push("Jungle Critters Spawn Weight");
            RedPandaSpawnWeight = builder.comment("Spawn weight of Red Panda").defineInRange("redpanda_spawn_weight", 30, 1, 1000);
            GibbonSpawnWeight = builder.comment("Spawn weight of Siamang Gibbon").defineInRange("siamang_gibbon_spawn_weight", 30, 1, 1000);
            builder.pop();
            builder.push("Savannah Critters Spawn Weight");
            KoalaSpawnWeight = builder.comment("Spawn weight of Koala").defineInRange("koala_spawn_weight", 30, 1, 1000);
            builder.pop();


        }

        public static void reload() {
            RedPandasConfig.RedPandaSpawnWeight = INSTANCE.RedPandaSpawnWeight.get();
            RedPandasConfig.GibbonSpawnWeight = INSTANCE.GibbonSpawnWeight.get();
            RedPandasConfig.KoalaSpawnWeight = INSTANCE.KoalaSpawnWeight.get();
        }
    }

}
