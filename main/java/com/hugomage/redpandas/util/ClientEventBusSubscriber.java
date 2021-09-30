package com.hugomage.redpandas.util;


import com.hugomage.redpandas.RedPandas;
import com.hugomage.redpandas.client.renderer.*;
import com.hugomage.redpandas.init.ModEntityTypes;
import com.hugomage.redpandas.item.ModSpawnEggItem;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.client.renderer.color.ItemColors;
import net.minecraft.entity.EntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = RedPandas.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {


    public static void init() {
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.REDPANDA.get(), RedPandaRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.KOALA.get(), KoalaRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.GIBBON.get(), GibbonRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.ANT.get(), AntRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.CARACAL.get(), CaracalRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.GILAMONSTER.get(), GilaMonsterRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.OPOSSUM.get(), OpossumRenderer::new);

    }


    @SubscribeEvent
    @OnlyIn(Dist.CLIENT)
    public static void itemColors(ColorHandlerEvent.Item event) {
        ItemColors handler = event.getItemColors();
        IItemColor eggColor = (stack, tintIndex) -> ((ModSpawnEggItem) stack.getItem()).getColor(tintIndex);
        for (ModSpawnEggItem e : ModSpawnEggItem.UNADDED_EGGS) handler.register(eggColor, e);
    }

}
