package com.hugomage.redpandas.client.renderer;



import com.hugomage.redpandas.RedPandas;
import com.hugomage.redpandas.client.model.RedPandaModel;
import com.hugomage.redpandas.entity.RedPandaEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3f;

public class RedPandaRenderer extends MobRenderer<com.hugomage.redpandas.entity.RedPandaEntity, RedPandaModel<RedPandaEntity>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(RedPandas.MOD_ID, "textures/entity/red_panda.png");
    protected static final ResourceLocation WHITEFACE = new ResourceLocation(RedPandas.MOD_ID, "textures/entity/red_panda2.png");
    protected static final ResourceLocation ALBINO = new ResourceLocation(RedPandas.MOD_ID, "textures/entity/red_panda_albino.png");
    protected static final ResourceLocation VAKYPANDA = new ResourceLocation(RedPandas.MOD_ID, "textures/entity/red_panda_vaky.png");


    public RedPandaRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new RedPandaModel<>(), 0.2F);
    }

    @Override
    public ResourceLocation getTextureLocation(RedPandaEntity entity) {
        if(entity.getVariant() == 1){
            return WHITEFACE;
        }
        if(entity.getVariant() == 2) {
            return ALBINO;
        }
        return entity.isVaky() ? VAKYPANDA : entity.isBaby() ? TEXTURE : TEXTURE;
    }


}

