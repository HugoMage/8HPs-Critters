package com.hugomage.redpandas.init;



import com.hugomage.redpandas.RedPandas;
import com.hugomage.redpandas.entity.GibbonEntity;
import com.hugomage.redpandas.entity.KoalaEntity;
import com.hugomage.redpandas.entity.RedPandaEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntityTypes {
    public static DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, RedPandas.MOD_ID);

    // Red Panda
    public static final RegistryObject<EntityType<com.hugomage.redpandas.entity.RedPandaEntity>> REDPANDA = ENTITY_TYPES.register("red_panda", ()->
            EntityType.Builder.of(RedPandaEntity::new, EntityClassification.CREATURE)
                    .sized(0.8f,0.9f)
                    .build(new ResourceLocation(RedPandas.MOD_ID, "red_panda").toString()));
    public static final RegistryObject<EntityType<com.hugomage.redpandas.entity.GibbonEntity>> GIBBON = ENTITY_TYPES.register("siamang_gibbon", ()->
            EntityType.Builder.of(GibbonEntity::new, EntityClassification.CREATURE)
                    .sized(0.8f,0.9f)
                    .build(new ResourceLocation(RedPandas.MOD_ID, "siamang_gibbon").toString()));
    public static final RegistryObject<EntityType<com.hugomage.redpandas.entity.KoalaEntity>> KOALA = ENTITY_TYPES.register("koala", ()->
            EntityType.Builder.of(KoalaEntity::new, EntityClassification.CREATURE)
                    .sized(0.8f,0.9f)
                    .build(new ResourceLocation(RedPandas.MOD_ID, "koala").toString()));


}




