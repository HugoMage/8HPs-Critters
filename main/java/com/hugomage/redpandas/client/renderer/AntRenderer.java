package com.hugomage.redpandas.client.renderer;



import com.hugomage.redpandas.RedPandas;
import com.hugomage.redpandas.client.model.AntModel;
import com.hugomage.redpandas.client.model.SiamangGibbonModel;
import com.hugomage.redpandas.entity.AntEntity;
import com.hugomage.redpandas.entity.GibbonEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class AntRenderer extends MobRenderer<AntEntity, AntModel<AntEntity>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(RedPandas.MOD_ID, "textures/entity/ant.png");



    public AntRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new AntModel<>(), 0.2F);
    }

    @Override
    public ResourceLocation getTextureLocation(AntEntity entity) {
        return entity.isBaby() ? TEXTURE : TEXTURE;
    }


}

