package com.hugomage.redpandas.client.renderer;



import com.hugomage.redpandas.RedPandas;
import com.hugomage.redpandas.client.model.RedPandaModel;
import com.hugomage.redpandas.client.model.SiamangGibbonModel;
import com.hugomage.redpandas.entity.GibbonEntity;
import com.hugomage.redpandas.entity.RedPandaEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class GibbonRenderer extends MobRenderer<GibbonEntity, SiamangGibbonModel<GibbonEntity>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(RedPandas.MOD_ID, "textures/entity/siamang_gibbon.png");



    public GibbonRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new SiamangGibbonModel<>(), 0.2F);
    }

    @Override
    public ResourceLocation getTextureLocation(GibbonEntity entity) {
        return entity.isBaby() ? TEXTURE : TEXTURE;
    }


}

