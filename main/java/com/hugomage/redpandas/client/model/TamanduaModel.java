package com.hugomage.redpandas.client.model;


import com.hugomage.redpandas.entity.KoalaEntity;
import com.hugomage.redpandas.entity.TamanduaEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class TamanduaModel<T extends TamanduaEntity> extends EntityModel<T>  {
    private final ModelRenderer Body;
    private final ModelRenderer FrontRightLeg;
    private final ModelRenderer head;
    private final ModelRenderer LeftEar;
    private final ModelRenderer snoot;
    private final ModelRenderer RightEar;
    private final ModelRenderer tailbase;
    private final ModelRenderer Tailtip;
    private final ModelRenderer BackLeftLeg;
    private final ModelRenderer BackRightLeg;
    private final ModelRenderer FrontLeftLeg;


    public TamanduaModel() {
        texWidth = 64;
        texHeight = 64;

        Body = new ModelRenderer(this);
        Body.setPos(0.0F, 16.0F, 0.0F);
        setRotationAngle(Body, 0.0F, 3.1416F, 0.0F);
        Body.texOffs(0, 0).addBox(-4.0F, -4.0F, -8.0F, 8.0F, 8.0F, 16.0F, 0.0F, false);

        FrontRightLeg = new ModelRenderer(this);
        FrontRightLeg.setPos(3.5F, 0.0F, 5.0F);
        Body.addChild(FrontRightLeg);
        FrontRightLeg.texOffs(14, 44).addBox(-1.5F, 0.0F, -2.0F, 3.0F, 8.0F, 4.0F, 0.0F, false);

        head = new ModelRenderer(this);
        head.setPos(0.0F, -0.2F, 6.0F);
        Body.addChild(head);
        head.texOffs(32, 0).addBox(-2.0F, -2.5F, 0.0F, 4.0F, 5.0F, 6.0F, 0.0F, false);

        LeftEar = new ModelRenderer(this);
        LeftEar.setPos(-0.7F, -2.0F, 2.3F);
        head.addChild(LeftEar);
        LeftEar.texOffs(8, 12).addBox(-3.0F, 0.0F, 0.0F, 3.0F, 2.0F, 1.0F, 0.0F, false);

        snoot = new ModelRenderer(this);
        snoot.setPos(0.0F, 0.5F, 4.6F);
        head.addChild(snoot);
        setRotationAngle(snoot, -0.1564F, 0.0F, 0.0F);
        snoot.texOffs(43, 39).addBox(-1.0F, -1.5F, 0.0F, 2.0F, 3.0F, 5.0F, 0.0F, false);

        RightEar = new ModelRenderer(this);
        RightEar.setPos(0.7F, -2.0F, 2.3F);
        head.addChild(RightEar);
        RightEar.texOffs(0, 12).addBox(0.0F, 0.0F, 0.0F, 3.0F, 2.0F, 1.0F, 0.0F, false);

        tailbase = new ModelRenderer(this);
        tailbase.setPos(0.0F, 0.0F, -6.7F);
        Body.addChild(tailbase);
        tailbase.texOffs(0, 24).addBox(-2.0F, -2.5F, -12.0F, 4.0F, 5.0F, 12.0F, 0.0F, false);

        Tailtip = new ModelRenderer(this);
        Tailtip.setPos(0.0F, 0.0F, -10.7F);
        tailbase.addChild(Tailtip);
        Tailtip.texOffs(22, 31).addBox(-1.5F, -1.5F, -10.0F, 3.0F, 3.0F, 10.0F, 0.0F, false);

        BackLeftLeg = new ModelRenderer(this);
        BackLeftLeg.setPos(-3.5F, 0.0F, -5.0F);
        Body.addChild(BackLeftLeg);
        BackLeftLeg.texOffs(0, 41).addBox(-1.5F, 0.0F, -2.0F, 3.0F, 8.0F, 4.0F, 0.0F, false);

        BackRightLeg = new ModelRenderer(this);
        BackRightLeg.setPos(3.5F, 0.0F, -5.0F);
        Body.addChild(BackRightLeg);
        BackRightLeg.texOffs(38, 24).addBox(-1.5F, 0.0F, -2.0F, 3.0F, 8.0F, 4.0F, 0.0F, false);

        FrontLeftLeg = new ModelRenderer(this);
        FrontLeftLeg.setPos(-3.5F, 0.0F, 5.0F);
        Body.addChild(FrontLeftLeg);
        FrontLeftLeg.texOffs(0, 0).addBox(-1.5F, 0.0F, -2.0F, 3.0F, 8.0F, 4.0F, 0.0F, false);
    }




    @Override
    public void setupAnim (T p_225597_1_, float p_225597_2_, float p_225597_3_, float p_225597_4_, float p_225597_5_, float p_225597_6_) {
        this.head.xRot = p_225597_6_ * ((float)Math.PI / 180F);
        this.head.yRot = p_225597_5_ * ((float)Math.PI / 180F);
        this.FrontLeftLeg.xRot = MathHelper.cos(p_225597_2_ * 0.6662F) * 1.4F * p_225597_3_;
        this.FrontRightLeg.xRot = MathHelper.cos(p_225597_2_ * 0.6662F + (float)Math.PI) * 1.4F * p_225597_3_;
        this.BackLeftLeg.xRot = MathHelper.cos(p_225597_2_ * 0.6662F + (float)Math.PI) * 1.4F * p_225597_3_;
        this.BackRightLeg.xRot = MathHelper.cos(p_225597_2_ * 0.6662F) * 1.4F * p_225597_3_;
    }

    @Override
    public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        Body.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.xRot = x;
        modelRenderer.yRot = y;
        modelRenderer.zRot = z;
    }
}