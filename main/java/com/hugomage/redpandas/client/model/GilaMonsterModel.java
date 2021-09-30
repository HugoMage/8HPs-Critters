package com.hugomage.redpandas.client.model;


import com.hugomage.redpandas.entity.KoalaEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class GilaMonsterModel<T extends KoalaEntity> extends EntityModel<T>  {
    private final ModelRenderer neck;
    private final ModelRenderer head2;
    private final ModelRenderer right_legs;
    private final ModelRenderer right_leg1;
    private final ModelRenderer right_leg2;
    private final ModelRenderer right_leg3;
    private final ModelRenderer left_legs;
    private final ModelRenderer left_leg1;
    private final ModelRenderer neck_sub_2;
    private final ModelRenderer left_leg2;
    private final ModelRenderer neck_sub_3;
    private final ModelRenderer left_leg3;
    private final ModelRenderer neck_sub_4;

    public GilaMonsterModel() {
        texWidth = 32;
        texHeight = 32;

        neck = new ModelRenderer(this);
        neck.setPos(0.0F, 21.0F, 1.0F);
        neck.texOffs(0, 0).addBox(-2.0F, -0.2F, -1.0F, 3.0F, 3.0F, 4.0F, 0.0F, false);
        neck.texOffs(10, 0).addBox(-2.0F, 0.8F, -3.0F, 3.0F, 2.0F, 2.0F, 0.0F, false);

        head2 = new ModelRenderer(this);
        head2.setPos(0.0F, 0.0F, -3.0F);
        neck.addChild(head2);
        head2.texOffs(0, 7).addBox(-2.0F, -0.2F, -3.0F, 3.0F, 3.0F, 3.0F, 0.0F, false);
        head2.texOffs(9, 7).addBox(-3.0F, -3.2F, -2.0F, 5.0F, 3.0F, 0.0F, 0.0F, false);

        right_legs = new ModelRenderer(this);
        right_legs.setPos(5.0F, 1.0F, 2.0F);
        neck.addChild(right_legs);


        right_leg1 = new ModelRenderer(this);
        right_leg1.setPos(-8.0F, 0.0F, -5.0F);
        right_legs.addChild(right_leg1);
        setRotationAngle(right_leg1, 0.0F, 0.0F, -0.3054F);
        right_leg1.texOffs(13, 4).addBox(-1.0F, 1.8F, 0.0F, 2.0F, 0.0F, 1.0F, 0.0F, false);

        right_leg2 = new ModelRenderer(this);
        right_leg2.setPos(-8.0F, 0.0F, -4.0F);
        right_legs.addChild(right_leg2);
        setRotationAngle(right_leg2, 0.0F, 0.0F, -0.1309F);
        right_leg2.texOffs(13, 4).addBox(-1.0F, 1.8F, 0.0F, 2.0F, 0.0F, 1.0F, 0.0F, false);

        right_leg3 = new ModelRenderer(this);
        right_leg3.setPos(-8.0F, 0.0F, -3.0F);
        right_legs.addChild(right_leg3);
        setRotationAngle(right_leg3, 0.0F, 0.0F, -0.3054F);
        right_leg3.texOffs(13, 4).addBox(-1.0F, 1.8F, 0.0F, 2.0F, 0.0F, 1.0F, 0.0F, false);

        left_legs = new ModelRenderer(this);
        left_legs.setPos(-6.0F, 1.0F, 3.0F);
        neck.addChild(left_legs);


        left_leg1 = new ModelRenderer(this);
        left_leg1.setPos(8.0F, 0.0F, -5.0F);
        left_legs.addChild(left_leg1);


        neck_sub_2 = new ModelRenderer(this);
        neck_sub_2.setPos(0.0F, 0.0F, 0.0F);
        left_leg1.addChild(neck_sub_2);
        setRotationAngle(neck_sub_2, 0.0F, 0.0F, 0.3054F);
        neck_sub_2.texOffs(13, 4).addBox(-1.0F, 1.8F, -1.0F, 2.0F, 0.0F, 1.0F, 0.0F, true);

        left_leg2 = new ModelRenderer(this);
        left_leg2.setPos(8.0F, 0.0F, -4.0F);
        left_legs.addChild(left_leg2);
        setRotationAngle(left_leg2, 0.0F, 0.0F, 0.3054F);


        neck_sub_3 = new ModelRenderer(this);
        neck_sub_3.setPos(0.0F, 0.0F, 0.0F);
        left_leg2.addChild(neck_sub_3);
        setRotationAngle(neck_sub_3, 0.0F, 0.0F, -0.1309F);
        neck_sub_3.texOffs(13, 4).addBox(-1.0F, 1.8F, -1.0F, 2.0F, 0.0F, 1.0F, 0.0F, true);

        left_leg3 = new ModelRenderer(this);
        left_leg3.setPos(8.0F, 0.0F, -3.0F);
        left_legs.addChild(left_leg3);
        setRotationAngle(left_leg3, 0.0F, 0.0F, 0.3054F);


        neck_sub_4 = new ModelRenderer(this);
        neck_sub_4.setPos(0.0F, 0.0F, 0.0F);
        left_leg3.addChild(neck_sub_4);
        neck_sub_4.texOffs(13, 4).addBox(-1.0F, 1.8F, -1.0F, 2.0F, 0.0F, 1.0F, 0.0F, true);
    }




    @Override
    public void setupAnim (T p_225597_1_, float p_225597_2_, float p_225597_3_, float p_225597_4_, float p_225597_5_, float p_225597_6_) {
        this.head2.xRot = p_225597_6_ * ((float)Math.PI / 180F);
        this.head2.yRot = p_225597_5_ * ((float)Math.PI / 180F);
        this.right_leg1.xRot = MathHelper.cos(p_225597_2_ * 0.6662F) * 1.4F * p_225597_3_;
        this.right_leg2.xRot = MathHelper.cos(p_225597_2_ * 0.6662F + (float)Math.PI) * 1.4F * p_225597_3_;
        this.right_leg3.xRot = MathHelper.cos(p_225597_2_ * 0.6662F + (float)Math.PI) * 1.4F * p_225597_3_;
        this.left_leg1.xRot = MathHelper.cos(p_225597_2_ * 0.6662F) * 1.4F * p_225597_3_;
        this.left_leg2.xRot = MathHelper.cos(p_225597_2_ * 0.6662F) * 1.4F * p_225597_3_;
        this.left_leg3.xRot = MathHelper.cos(p_225597_2_ * 0.6662F) * 1.4F * p_225597_3_;
    }

    @Override
    public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
            neck.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.xRot = x;
        modelRenderer.yRot = y;
        modelRenderer.zRot = z;
    }
}