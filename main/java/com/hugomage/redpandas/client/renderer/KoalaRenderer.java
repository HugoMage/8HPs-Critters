package com.hugomage.redpandas.client.renderer;



import com.hugomage.redpandas.RedPandas;
import com.hugomage.redpandas.client.model.KoalaModel;
import com.hugomage.redpandas.client.model.RedPandaModel;
import com.hugomage.redpandas.entity.KoalaEntity;
import com.hugomage.redpandas.entity.RedPandaEntity;
import cpw.mods.modlauncher.api.TypesafeMap;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class KoalaRenderer extends MobRenderer<KoalaEntity, KoalaModel<KoalaEntity>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(RedPandas.MOD_ID, "textures/entity/koala.png");


    public KoalaRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new KoalaModel<>(), 0.2F);
    }

    @Override
    public ResourceLocation getTextureLocation(KoalaEntity entity) {
        return entity.isBaby() ? TEXTURE : TEXTURE;
    }


}

