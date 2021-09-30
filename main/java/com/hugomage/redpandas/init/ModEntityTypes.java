package com.hugomage.redpandas.init;



import com.hugomage.redpandas.RedPandas;
import com.hugomage.redpandas.entity.*;
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
    public static final RegistryObject<EntityType<com.hugomage.redpandas.entity.AntEntity>> ANT = ENTITY_TYPES.register("ant", ()->
            EntityType.Builder.of(AntEntity::new, EntityClassification.CREATURE)
                    .sized(0.8f,0.9f)
                    .build(new ResourceLocation(RedPandas.MOD_ID, "ant").toString()));
    public static final RegistryObject<EntityType<com.hugomage.redpandas.entity.CaracalEntity>> CARACAL = ENTITY_TYPES.register("caracal", ()->
            EntityType.Builder.of(CaracalEntity::new, EntityClassification.CREATURE)
                    .sized(0.8f,0.9f)
                    .build(new ResourceLocation(RedPandas.MOD_ID, "caracal").toString()));
    public static final RegistryObject<EntityType<com.hugomage.redpandas.entity.GilaMonsterEntity>> GILAMONSTER = ENTITY_TYPES.register("gila_monster", ()->
            EntityType.Builder.of(GilaMonsterEntity::new, EntityClassification.CREATURE)
                    .sized(0.8f,0.9f)
                    .build(new ResourceLocation(RedPandas.MOD_ID, "gila_monster").toString()));
    public static final RegistryObject<EntityType<com.hugomage.redpandas.entity.OpossumEntity>> OPOSSUM = ENTITY_TYPES.register("opossum", ()->
            EntityType.Builder.of(OpossumEntity::new, EntityClassification.CREATURE)
                    .sized(0.8f,0.9f)
                    .build(new ResourceLocation(RedPandas.MOD_ID, "opossum").toString()));


}




