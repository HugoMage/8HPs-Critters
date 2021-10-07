package com.hugomage.redpandas.client.renderer;



import com.hugomage.redpandas.RedPandas;
import com.hugomage.redpandas.client.model.AntModel;
import com.hugomage.redpandas.client.model.TamanduaModel;
import com.hugomage.redpandas.entity.AntEntity;
import com.hugomage.redpandas.entity.TamanduaEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class TamanduaRenderer extends MobRenderer<TamanduaEntity, TamanduaModel<TamanduaEntity>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(RedPandas.MOD_ID, "textures/entity/tamandua.png");



    public TamanduaRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new TamanduaModel<>(), 0.2F);
    }

    @Override
    public ResourceLocation getTextureLocation(TamanduaEntity entity) {
        return entity.isBaby() ? TEXTURE : TEXTURE;
    }


}

