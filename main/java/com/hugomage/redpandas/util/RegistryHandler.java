package com.hugomage.redpandas.util;


import com.hugomage.redpandas.RedPandas;
import com.hugomage.redpandas.init.ModEntityTypes;
import com.hugomage.redpandas.item.ModSpawnEggItem;
import net.minecraft.block.Block;
import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryHandler {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, RedPandas.MOD_ID);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, RedPandas.MOD_ID);


    public static void init() {
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());

    }



    // Items

    // SpawnEgg
    public static final RegistryObject<ModSpawnEggItem> REDPANDA_SPAWN_EGG = ITEMS.register("red_panda_spawn_egg",() -> new ModSpawnEggItem(ModEntityTypes.REDPANDA, 0xc67534, 0x503124, new Item.Properties().tab(ItemGroup.TAB_MATERIALS)));
    public static final RegistryObject<ModSpawnEggItem> GIBBON_SPAWN_EGG = ITEMS.register("siamang_gibbon_spawn_egg",() -> new ModSpawnEggItem(ModEntityTypes.GIBBON, 0xc67534, 0x503124, new Item.Properties().tab(ItemGroup.TAB_MATERIALS)));
    public static final RegistryObject<ModSpawnEggItem> KOALA_SPAWN_EGG = ITEMS.register("koala_spawn_egg",() -> new ModSpawnEggItem(ModEntityTypes.KOALA, 0xc67534, 0x503124, new Item.Properties().tab(ItemGroup.TAB_MATERIALS)));
    // Music Disc


    // Armor

    //tools



    // Blocks

    // Block Items

    public static Item.Properties defaultProperties() {
        return new Item.Properties().tab(ItemGroup.TAB_MATERIALS);
    }
}