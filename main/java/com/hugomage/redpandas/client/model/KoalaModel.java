package com.hugomage.redpandas.client.model;


import com.hugomage.redpandas.entity.KoalaEntity;
import com.hugomage.redpandas.entity.RedPandaEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class KoalaModel<T extends KoalaEntity> extends EntityModel<T>  {
    private final ModelRenderer body;
    private final ModelRenderer rotation;
    private final ModelRenderer rotate_back;
    private final ModelRenderer head2;
    private final ModelRenderer back_left_leg2;
    private final ModelRenderer back_right_leg2;
    private final ModelRenderer front_left_leg2;
    private final ModelRenderer front_right_leg2;

    public KoalaModel() {
        texWidth = 64;
        texHeight = 64;

        body = new ModelRenderer(this);
        body.setPos(0.0F, 6.0F, 6.1F);


        rotation = new ModelRenderer(this);
        rotation.setPos(0.0F, 11.0F, -5.1F);
        body.addChild(rotation);
        setRotationAngle(rotation, 1.5708F, 0.0F, 0.0F);
        rotation.texOffs(0, 0).addBox(-3.0F, -8.0F, -2.9F, 6.0F, 9.0F, 6.0F, 0.0F, false);

        rotate_back = new ModelRenderer(this);
        rotate_back.setPos(0.0F, 0.0F, 0.0F);
        rotation.addChild(rotate_back);
        setRotationAngle(rotate_back, -1.5708F, 0.0F, 0.0F);


        head2 = new ModelRenderer(this);
        head2.setPos(0.0F, -2.0F, -10.0F);
        rotate_back.addChild(head2);
        head2.texOffs(0, 15).addBox(-2.5F, -2.0F, -1.0F, 5.0F, 5.0F, 3.0F, 0.0F, false);
        head2.texOffs(0, 0).addBox(-1.0F, -0.02F, -2.0F, 2.0F, 3.0F, 1.0F, 0.0F, false);
        head2.texOffs(24, 23).addBox(-4.0F, -3.0F, 1.0F, 3.0F, 3.0F, 1.0F, 0.0F, false);
        head2.texOffs(24, 8).addBox(1.0F, -3.0F, 1.0F, 3.0F, 3.0F, 1.0F, 0.0F, false);

        back_left_leg2 = new ModelRenderer(this);
        back_left_leg2.setPos(-1.1F, 1.0F, -3.0F);
        rotate_back.addChild(back_left_leg2);
        back_left_leg2.texOffs(24, 0).addBox(-2.0F, 1.0F, 1.1F, 3.0F, 5.0F, 3.0F, 0.0F, false);

        back_right_leg2 = new ModelRenderer(this);
        back_right_leg2.setPos(1.1F, 1.0F, -3.0F);
        rotate_back.addChild(back_right_leg2);
        back_right_leg2.texOffs(12, 23).addBox(-1.0F, 1.0F, 1.1F, 3.0F, 5.0F, 3.0F, 0.0F, false);

        front_left_leg2 = new ModelRenderer(this);
        front_left_leg2.setPos(-1.2F, -3.0F, -7.0F);
        rotate_back.addChild(front_left_leg2);
        front_left_leg2.texOffs(0, 23).addBox(-2.0F, 5.0F, 0.0F, 3.0F, 5.0F, 3.0F, 0.0F, false);

        front_right_leg2 = new ModelRenderer(this);
        front_right_leg2.setPos(1.2F, -3.0F, -7.0F);
        rotate_back.addChild(front_right_leg2);
        front_right_leg2.texOffs(16, 15).addBox(-1.0F, 5.0F, 0.0F, 3.0F, 5.0F, 3.0F, 0.0F, false);
    }



    @Override
    public void setupAnim (T p_225597_1_, float p_225597_2_, float p_225597_3_, float p_225597_4_, float p_225597_5_, float p_225597_6_) {
        this.head2.xRot = p_225597_6_ * ((float)Math.PI / 180F);
        this.head2.yRot = p_225597_5_ * ((float)Math.PI / 180F);
        this.front_left_leg2.xRot = MathHelper.cos(p_225597_2_ * 0.6662F) * 1.4F * p_225597_3_;
        this.front_right_leg2.xRot = MathHelper.cos(p_225597_2_ * 0.6662F + (float)Math.PI) * 1.4F * p_225597_3_;
        this.back_left_leg2.xRot = MathHelper.cos(p_225597_2_ * 0.6662F + (float)Math.PI) * 1.4F * p_225597_3_;
        this.back_right_leg2.xRot = MathHelper.cos(p_225597_2_ * 0.6662F) * 1.4F * p_225597_3_;
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