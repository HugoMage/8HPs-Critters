package com.hugomage.redpandas.client.model;


import com.hugomage.redpandas.entity.GilaMonsterEntity;
import com.hugomage.redpandas.entity.KoalaEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class GilaMonsterModel<T extends GilaMonsterEntity> extends EntityModel<T>  {
    private final ModelRenderer body;
    private final ModelRenderer head;
    private final ModelRenderer back_right_leg;
    private final ModelRenderer front_right_leg;
    private final ModelRenderer back_left_leg;
    private final ModelRenderer front_left_leg;
    private final ModelRenderer tail;


    public GilaMonsterModel() {
        texWidth = 64;
        texHeight = 64;

        body = new ModelRenderer(this);
        body.setPos(0.0F, 21.0F, 0.0F);
        body.texOffs(0, 0).addBox(-4.0F, -2.0F, -5.0F, 8.0F, 4.0F, 10.0F, 0.0F, false);

        head = new ModelRenderer(this);
        head.setPos(0.0F, 0.0F, -5.0F);
        body.addChild(head);
        head.texOffs(20, 14).addBox(-4.0F, -3.0F, -5.0F, 8.0F, 5.0F, 5.0F, 0.0F, false);

        back_right_leg = new ModelRenderer(this);
        back_right_leg.setPos(-4.0F, 1.0F, 3.0F);
        body.addChild(back_right_leg);
        setRotationAngle(back_right_leg, 0.0F, 0.0F, 1.3526F);
        back_right_leg.texOffs(0, 0).addBox(-0.5F, 0.0F, -1.0F, 2.0F, 5.0F, 2.0F, 0.0F, false);

        front_right_leg = new ModelRenderer(this);
        front_right_leg.setPos(-4.0F, 1.0F, -4.0F);
        body.addChild(front_right_leg);
        setRotationAngle(front_right_leg, 0.0F, 0.0F, 1.3526F);
        front_right_leg.texOffs(0, 14).addBox(-0.5F, 0.0F, -1.0F, 2.0F, 5.0F, 2.0F, 0.0F, false);

        back_left_leg = new ModelRenderer(this);
        back_left_leg.setPos(4.0F, 1.0F, 3.0F);
        body.addChild(back_left_leg);
        setRotationAngle(back_left_leg, 0.0F, 0.0F, -1.3526F);
        back_left_leg.texOffs(26, 0).addBox(-1.5F, 0.0F, -1.0F, 2.0F, 5.0F, 2.0F, 0.0F, false);

        front_left_leg = new ModelRenderer(this);
        front_left_leg.setPos(4.0F, 1.0F, -4.0F);
        body.addChild(front_left_leg);
        setRotationAngle(front_left_leg, 0.0F, 0.0F, -1.3526F);
        front_left_leg.texOffs(0, 29).addBox(-1.5F, 0.0F, -1.0F, 2.0F, 5.0F, 2.0F, 0.0F, false);

        tail = new ModelRenderer(this);
        tail.setPos(0.0F, -0.5F, 5.0F);
        body.addChild(tail);
        tail.texOffs(0, 14).addBox(-2.0F, -0.5F, 0.0F, 4.0F, 3.0F, 12.0F, 0.0F, false);
    }





    @Override
    public void setupAnim (T p_225597_1_, float p_225597_2_, float p_225597_3_, float p_225597_4_, float p_225597_5_, float p_225597_6_) {
        this.head.xRot = p_225597_6_ * ((float)Math.PI / 180F);
        this.head.yRot = p_225597_5_ * ((float)Math.PI / 180F);
        this.front_left_leg.xRot = MathHelper.cos(p_225597_2_ * 0.6662F) * 1.4F * p_225597_3_;
        this.front_right_leg.xRot = MathHelper.cos(p_225597_2_ * 0.6662F + (float)Math.PI) * 1.4F * p_225597_3_;
        this.back_left_leg.xRot = MathHelper.cos(p_225597_2_ * 0.6662F + (float)Math.PI) * 1.4F * p_225597_3_;
        this.back_right_leg.xRot = MathHelper.cos(p_225597_2_ * 0.6662F) * 1.4F * p_225597_3_;
    }

    @Override
    public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        body.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.xRot = x;
        modelRenderer.yRot = y;
        modelRenderer.zRot = z;
    }
}