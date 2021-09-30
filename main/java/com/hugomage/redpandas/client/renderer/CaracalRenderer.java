package com.hugomage.redpandas.client.renderer;



import com.hugomage.redpandas.RedPandas;
import com.hugomage.redpandas.client.model.AntModel;
import com.hugomage.redpandas.client.model.CaracalModel;
import com.hugomage.redpandas.entity.AntEntity;
import com.hugomage.redpandas.entity.CaracalEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class CaracalRenderer extends MobRenderer<CaracalEntity, CaracalModel<CaracalEntity>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(RedPandas.MOD_ID, "textures/entity/caracal.png");



    public CaracalRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new CaracalModel<>(), 0.2F);
    }

    @Override
    public ResourceLocation getTextureLocation(CaracalEntity entity) {
        return entity.isBaby() ? TEXTURE : TEXTURE;
    }


}

