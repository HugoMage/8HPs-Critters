package com.hugomage.redpandas.client.model;


import com.hugomage.redpandas.entity.KoalaEntity;
import com.hugomage.redpandas.entity.OpossumEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class OpossumModel<T extends OpossumEntity> extends EntityModel<T>  {
    private final ModelRenderer body;
    private final ModelRenderer backleftleg;
    private final ModelRenderer backrightleg;
    private final ModelRenderer Head;
    private final ModelRenderer tail;
    private final ModelRenderer bone_r1;
    private final ModelRenderer frontrightleg;
    private final ModelRenderer frontleftleg;

    public OpossumModel() {
        texWidth = 64;
        texHeight = 64;

        body = new ModelRenderer(this);
        body.setPos(3.0F, 20.0F, 3.0F);
        setRotationAngle(body, 0.0F, 1.5708F, 0.0F);
        body.texOffs(0, 0).addBox(-1.0F, -7.0F, -7.0F, 13.0F, 7.0F, 7.0F, 0.0F, false);

        backleftleg = new ModelRenderer(this);
        backleftleg.setPos(2.0F, 20.0F, 2.0F);
        setRotationAngle(backleftleg, 0.0F, 1.5708F, 0.0F);
        backleftleg.texOffs(12, 27).addBox(-2.0F, 0.0F, -1.0F, 4.0F, 4.0F, 2.0F, 0.0F, false);

        backrightleg = new ModelRenderer(this);
        backrightleg.setPos(-3.0F, 20.0F, 2.0F);
        setRotationAngle(backrightleg, 0.0F, 1.5708F, 0.0F);
        backrightleg.texOffs(12, 27).addBox(-2.0F, 0.0F, -1.0F, 4.0F, 4.0F, 2.0F, 0.0F, false);

        Head = new ModelRenderer(this);
        Head.setPos(0.0F, 19.0F, -9.0F);
        setRotationAngle(Head, 0.0F, 1.5708F, 0.0F);
        Head.texOffs(0, 14).addBox(0.0F, -5.0F, -3.5F, 6.0F, 5.0F, 6.0F, 0.0F, false);
        Head.texOffs(0, 2).addBox(2.0F, -7.0F, -3.5F, 0.0F, 2.0F, 2.0F, 0.0F, false);
        Head.texOffs(0, 0).addBox(2.0F, -7.0F, 0.5F, 0.0F, 2.0F, 2.0F, 0.0F, false);
        Head.texOffs(21, 22).addBox(6.0F, -2.0F, -2.0F, 4.0F, 2.0F, 3.0F, 0.0F, false);

        tail = new ModelRenderer(this);
        tail.setPos(-1.0F, 15.0F, 4.0F);


        bone_r1 = new ModelRenderer(this);
        bone_r1.setPos(10.0F, 8.0F, -3.0F);
        tail.addChild(bone_r1);
        setRotationAngle(bone_r1, 0.0F, 1.5708F, 0.0F);
        bone_r1.texOffs(18, 14).addBox(-15.0F, -8.0F, -10.5F, 12.0F, 2.0F, 2.0F, 0.0F, false);

        frontrightleg = new ModelRenderer(this);
        frontrightleg.setPos(-3.0F, 20.0F, -8.0F);
        setRotationAngle(frontrightleg, 0.0F, 1.5708F, 0.0F);
        frontrightleg.texOffs(0, 31).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

        frontleftleg = new ModelRenderer(this);
        frontleftleg.setPos(2.0F, 20.0F, -8.0F);
        setRotationAngle(frontleftleg, 0.0F, 1.5708F, 0.0F);
        frontleftleg.texOffs(0, 31).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);
    }




    @Override
    public void setupAnim (T p_225597_1_, float p_225597_2_, float p_225597_3_, float p_225597_4_, float p_225597_5_, float p_225597_6_) {
        this.Head.xRot = p_225597_6_ * ((float)Math.PI / 180F);
        this.Head.yRot = p_225597_5_ * ((float)Math.PI / 180F);
        this.frontleftleg.xRot = MathHelper.cos(p_225597_2_ * 0.6662F) * 1.4F * p_225597_3_;
        this.frontrightleg.xRot = MathHelper.cos(p_225597_2_ * 0.6662F + (float)Math.PI) * 1.4F * p_225597_3_;
        this.backleftleg.xRot = MathHelper.cos(p_225597_2_ * 0.6662F + (float)Math.PI) * 1.4F * p_225597_3_;
        this.backrightleg.xRot = MathHelper.cos(p_225597_2_ * 0.6662F) * 1.4F * p_225597_3_;
    }

    @Override
    public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        body.render(matrixStack, buffer, packedLight, packedOverlay);
        backleftleg.render(matrixStack, buffer, packedLight, packedOverlay);
        backrightleg.render(matrixStack, buffer, packedLight, packedOverlay);
        Head.render(matrixStack, buffer, packedLight, packedOverlay);
        tail.render(matrixStack, buffer, packedLight, packedOverlay);
        frontrightleg.render(matrixStack, buffer, packedLight, packedOverlay);
        frontleftleg.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.xRot = x;
        modelRenderer.yRot = y;
        modelRenderer.zRot = z;
    }
}