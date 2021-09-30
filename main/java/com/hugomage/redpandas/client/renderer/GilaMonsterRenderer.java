package com.hugomage.redpandas.client.renderer;



import com.hugomage.redpandas.RedPandas;
import com.hugomage.redpandas.client.model.AntModel;
import com.hugomage.redpandas.client.model.GilaMonsterModel;
import com.hugomage.redpandas.entity.AntEntity;
import com.hugomage.redpandas.entity.GilaMonsterEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class GilaMonsterRenderer extends MobRenderer<GilaMonsterEntity, GilaMonsterModel<GilaMonsterEntity>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(RedPandas.MOD_ID, "textures/entity/gila_monster.png");



    public GilaMonsterRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new GilaMonsterModel<>(), 0.2F);
    }

    @Override
    public ResourceLocation getTextureLocation(GilaMonsterEntity entity) {
        return entity.isBaby() ? TEXTURE : TEXTURE;
    }


}

