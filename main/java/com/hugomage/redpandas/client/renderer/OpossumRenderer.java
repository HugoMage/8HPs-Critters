package com.hugomage.redpandas.client.renderer;



import com.hugomage.redpandas.RedPandas;
import com.hugomage.redpandas.client.model.CaracalModel;
import com.hugomage.redpandas.client.model.OpossumModel;
import com.hugomage.redpandas.entity.CaracalEntity;
import com.hugomage.redpandas.entity.OpossumEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class OpossumRenderer extends MobRenderer<OpossumEntity, OpossumModel<OpossumEntity>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(RedPandas.MOD_ID, "textures/entity/opossum.png");



    public OpossumRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new OpossumModel<>(), 0.2F);
    }

    @Override
    public ResourceLocation getTextureLocation(OpossumEntity entity) {
        return entity.isBaby() ? TEXTURE : TEXTURE;
    }


}

