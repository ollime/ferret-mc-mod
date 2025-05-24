package com.github.ollime.ferretmod.entity.client;

import com.github.ollime.ferretmod.FerretMod;
import com.github.ollime.ferretmod.entity.custom.FerretEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

// Made with Blockbench 4.12.4
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class FerretModel<T extends FerretEntity> extends SinglePartEntityModel<T> {
    public static final EntityModelLayer FERRET = new EntityModelLayer(Identifier.of(FerretMod.MOD_ID, "ferret"), "main");
    private final ModelPart ferret;
    private ModelPart head;

    public FerretModel(ModelPart root) {
        this.ferret = root.getChild("ferret");
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData ferret = modelPartData.addChild("ferret", ModelPartBuilder.create().uv(0, 26).cuboid(0.65F, -6.0F, 0.0F, 2.0F, 6.0F, 2.0F, new Dilation(0.0F))
                .uv(8, 26).cuboid(-1.65F, -6.0F, 0.0F, 2.0F, 6.0F, 2.0F, new Dilation(0.0F))
                .uv(16, 26).cuboid(0.7F, -4.0F, 10.25F, 2.0F, 4.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 28).cuboid(-1.7F, -4.0F, 10.25F, 2.0F, 4.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 8).cuboid(-2.0F, -9.75F, -4.75F, 5.0F, 3.0F, 4.0F, new Dilation(0.0F))
                .uv(32, 28).cuboid(-1.0F, -9.0F, -6.0F, 3.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(16, 32).cuboid(-1.5F, -10.5F, -2.25F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
                .uv(16, 32).cuboid(1.5F, -10.5F, -2.25F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(-0.5F, 24.0F, -4.25F));

        ModelPartData cube_r1 = ferret.addChild("cube_r1", ModelPartBuilder.create().uv(24, 15).cuboid(-2.0F, -1.0F, -1.0F, 3.0F, 2.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(1.0F, -3.0F, 16.25F, -0.1309F, 0.0F, 0.0F));

        ModelPartData cube_r2 = ferret.addChild("cube_r2", ModelPartBuilder.create().uv(24, 22).cuboid(-2.0F, -1.0F, -1.0F, 3.0F, 2.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(1.0F, -4.75F, 13.5F, -0.6981F, 0.0F, 0.0F));

        ModelPartData cube_r3 = ferret.addChild("cube_r3", ModelPartBuilder.create().uv(24, 0).cuboid(-1.0F, -3.0F, -4.0F, 4.0F, 3.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(-0.5F, -4.0F, -1.0F, -0.9163F, 0.0F, 0.0F));

        ModelPartData cube_r4 = ferret.addChild("cube_r4", ModelPartBuilder.create().uv(0, 13).cuboid(-1.0F, -3.0F, -2.0F, 4.0F, 5.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(-0.5F, -5.25F, 7.25F, -0.2618F, 0.0F, 0.0F));

        ModelPartData cube_r5 = ferret.addChild("cube_r5", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -5.0F, -1.0F, 4.0F, 5.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(-0.5F, -2.25F, 1.0F, 0.2618F, 0.0F, 0.0F));
        return TexturedModelData.of(modelData, 64, 64);
    }

    @Override
    public void setAngles(FerretEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.getPart().traverse().forEach(ModelPart::resetTransform);
        this.setHeadAngles(netHeadYaw, headPitch);
    }

    private void setHeadAngles(float headYaw, float headPitch) {
        headYaw = MathHelper.clamp(headYaw, -30.0F, 30.0F);
        headPitch = MathHelper.clamp(headPitch, -25.0F, 45.0F);

        this.head.yaw = headYaw * 0.01745329F;
        this.head.pitch = headPitch * 0.017453292F;
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, int color) {
        ferret.render(matrices, vertexConsumer, light, overlay, color);
    }

    @Override
    public ModelPart getPart() {
        return ferret;
    }
}