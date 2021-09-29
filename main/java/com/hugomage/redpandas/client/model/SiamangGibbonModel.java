package com.hugomage.redpandas.client.model;


import com.hugomage.redpandas.entity.GibbonEntity;
import com.hugomage.redpandas.entity.RedPandaEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class SiamangGibbonModel<T extends GibbonEntity> extends EntityModel<T>  {
    private final ModelRenderer body;
    private final ModelRenderer head;
    private final ModelRenderer left_arm;
    private final ModelRenderer right_arm;
    private final ModelRenderer left_leg;
    private final ModelRenderer right_leg;

    public SiamangGibbonModel() {
        texWidth = 64;
        texHeight = 64;

        body = new ModelRenderer(this);
        body.setPos(0.0F, 8.0F, 0.0F);
        body.texOffs(0, 10).addBox(-3.0F, 4.0F, -2.0F, 6.0F, 8.0F, 3.0F, 0.0F, false);

        head = new ModelRenderer(this);
        head.setPos(0.0F, 4.0F, 1.0F);
        body.addChild(head);
        head.texOffs(0, 0).addBox(-3.0F, -5.0F, -4.0F, 6.0F, 5.0F, 5.0F, 0.0F, false);
        head.texOffs(28, 15).addBox(-2.0F, -2.0F, -5.0F, 4.0F, 2.0F, 1.0F, 0.0F, false);
        head.texOffs(14, 17).addBox(-2.5F, 0.0F, -6.0F, 5.0F, 4.0F, 4.0F, 0.0F, false);

        left_arm = new ModelRenderer(this);
        left_arm.setPos(4.0F, 6.0F, 0.0F);
        body.addChild(left_arm);
        setRotationAngle(left_arm, 0.0F, 0.0F, -0.0873F);
        left_arm.texOffs(22, 0).addBox(-1.0F, -2.0F, -2.0F, 2.0F, 12.0F, 3.0F, 0.0F, false);

        right_arm = new ModelRenderer(this);
        right_arm.setPos(-4.0F, 6.0F, 0.0F);
        body.addChild(right_arm);
        setRotationAngle(right_arm, 0.0F, 0.0F, 0.0873F);
        right_arm.texOffs(0, 21).addBox(-1.0F, -2.0F, -2.0F, 2.0F, 12.0F, 3.0F, 0.0F, false);

        left_leg = new ModelRenderer(this);
        left_leg.setPos(2.0F, 12.0F, 0.0F);
        body.addChild(left_leg);
        left_leg.texOffs(22, 25).addBox(-2.0F, 0.0F, -2.0F, 3.0F, 4.0F, 3.0F, 0.0F, false);

        right_leg = new ModelRenderer(this);
        right_leg.setPos(-2.0F, 12.0F, 0.0F);
        body.addChild(right_leg);
        right_leg.texOffs(10, 25).addBox(-1.0F, 0.0F, -2.0F, 3.0F, 4.0F, 3.0F, 0.0F, false);
    }


    @Override
    public void setupAnim (T p_225597_1_, float p_225597_2_, float p_225597_3_, float p_225597_4_, float p_225597_5_, float p_225597_6_) {
        this.head.xRot = p_225597_6_ * ((float)Math.PI / 180F);
        this.head.yRot = p_225597_5_ * ((float)Math.PI / 180F);
        this.left_arm.xRot = MathHelper.cos(p_225597_2_ * 0.6662F) * 1.4F * p_225597_3_;
        this.right_arm.xRot = MathHelper.cos(p_225597_2_ * 0.6662F + (float)Math.PI) * 1.4F * p_225597_3_;
        this.left_leg.xRot = MathHelper.cos(p_225597_2_ * 0.6662F + (float)Math.PI) * 1.4F * p_225597_3_;
        this.right_leg.xRot = MathHelper.cos(p_225597_2_ * 0.6662F) * 1.4F * p_225597_3_;
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