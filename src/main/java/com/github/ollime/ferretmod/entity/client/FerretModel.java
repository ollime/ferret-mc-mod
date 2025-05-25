package com.github.ollime.ferretmod.entity.client;

import com.github.ollime.ferretmod.FerretMod;
import com.github.ollime.ferretmod.entity.custom.FerretEntity;
import com.github.ollime.ferretmod.entity.client.FerretAnimations;
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
    private final ModelPart upper_body;
    private final ModelPart headneck;
    final ModelPart head;
    private final ModelPart neck;
    private final ModelPart right_front_leg;
    private final ModelPart left_front_leg;
    private final ModelPart body_1;
    private final ModelPart lower_body;
    private final ModelPart body_2;
    private final ModelPart right_back_leg;
    private final ModelPart left_back_leg;
    private final ModelPart tail_group;
    private final ModelPart tail_2;
    private final ModelPart tail_1;

    public FerretModel(ModelPart root) {
        this.ferret = root.getChild("ferret");
        this.upper_body = this.ferret.getChild("upper_body");
        this.headneck = this.upper_body.getChild("headneck");
        this.head = this.headneck.getChild("head");
        this.neck = this.headneck.getChild("neck");
        this.right_front_leg = this.upper_body.getChild("right_front_leg");
        this.left_front_leg = this.upper_body.getChild("left_front_leg");
        this.body_1 = this.upper_body.getChild("body_1");
        this.lower_body = this.ferret.getChild("lower_body");
        this.body_2 = this.lower_body.getChild("body_2");
        this.right_back_leg = this.lower_body.getChild("right_back_leg");
        this.left_back_leg = this.lower_body.getChild("left_back_leg");
        this.tail_group = this.lower_body.getChild("tail_group");
        this.tail_2 = this.tail_group.getChild("tail_2");
        this.tail_1 = this.tail_group.getChild("tail_1");
    }

//    public FerretModel(ModelPart root) {
//        this.ferret = root.getChild("ferret");
//    }
    public static TexturedModelData getTexturedModelData() {
            ModelData modelData = new ModelData();
            ModelPartData modelPartData = modelData.getRoot();
            ModelPartData ferret = modelPartData.addChild("ferret", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 19.0F, -2.0F));

            ModelPartData upper_body = ferret.addChild("upper_body", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 1.0F, -2.0F));

            ModelPartData headneck = upper_body.addChild("headneck", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

            ModelPartData head = headneck.addChild("head", ModelPartBuilder.create().uv(32, 28).cuboid(-1.5F, -2.1875F, -5.1875F, 3.0F, 2.0F, 2.0F, new Dilation(0.0F))
                    .uv(16, 32).cuboid(1.0F, -3.6875F, -1.4375F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
                    .uv(16, 32).cuboid(-2.0F, -3.6875F, -1.4375F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
                    .uv(24, 8).cuboid(-2.5F, -2.9375F, -3.9375F, 5.0F, 3.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -2.8125F, -1.0625F));

            ModelPartData neck = headneck.addChild("neck", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

            ModelPartData cube_r1 = neck.addChild("cube_r1", ModelPartBuilder.create().uv(24, 0).cuboid(-2.0F, -1.9242F, -4.6955F, 4.0F, 3.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -0.1032F, 0.0269F, -0.9163F, 0.0F, 0.0F));

            ModelPartData right_front_leg = upper_body.addChild("right_front_leg", ModelPartBuilder.create().uv(8, 26).cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(-1.15F, -2.0F, 0.75F));

            ModelPartData left_front_leg = upper_body.addChild("left_front_leg", ModelPartBuilder.create().uv(0, 26).cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(1.15F, -2.0F, 0.75F));

            ModelPartData body_1 = upper_body.addChild("body_1", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -1.4413F, -0.9993F));

            ModelPartData cube_r2 = body_1.addChild("cube_r2", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -5.0F, -1.0F, 4.0F, 5.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(-1.0F, 3.1913F, 1.7493F, 0.2618F, 0.0F, 0.0F));

            ModelPartData lower_body = ferret.addChild("lower_body", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 1.0F, -2.0F));

            ModelPartData body_2 = lower_body.addChild("body_2", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -2.2153F, 6.0613F));

            ModelPartData cube_r3 = body_2.addChild("cube_r3", ModelPartBuilder.create().uv(0, 13).cuboid(-1.0F, -3.0F, -2.0F, 4.0F, 5.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(-1.0F, 0.9653F, 0.9387F, -0.2618F, 0.0F, 0.0F));

            ModelPartData right_back_leg = lower_body.addChild("right_back_leg", ModelPartBuilder.create().uv(24, 28).cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(-1.2F, 0.0F, 11.0F));

            ModelPartData left_back_leg = lower_body.addChild("left_back_leg", ModelPartBuilder.create().uv(16, 26).cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(1.2F, 0.0F, 11.0F));

            ModelPartData tail_group = lower_body.addChild("tail_group", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -1.0F, 13.0F));

            ModelPartData tail_2 = tail_group.addChild("tail_2", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 2.1958F, 2.4872F));

            ModelPartData cube_r4 = tail_2.addChild("cube_r4", ModelPartBuilder.create().uv(24, 15).cuboid(-1.5F, -1.2611F, -0.5171F, 3.0F, 2.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.1309F, 0.0F, 0.0F));

            ModelPartData tail_1 = tail_group.addChild("tail_1", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

            ModelPartData cube_r5 = tail_1.addChild("cube_r5", ModelPartBuilder.create().uv(24, 22).cuboid(-1.5F, -0.8767F, -0.5912F, 3.0F, 2.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -0.1072F, 0.016F, -0.6981F, 0.0F, 0.0F));
            return TexturedModelData.of(modelData, 64, 64);
    }

    @Override
    public void setAngles(FerretEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.getPart().traverse().forEach(ModelPart::resetTransform);
        this.setHeadAngles(netHeadYaw, headPitch);

        this.animateMovement(FerretAnimations.WALKING, limbSwing, limbSwingAmount, 2f, 2.5f);
        this.updateAnimation(entity.IdleAnimationState, FerretAnimations.WALKING, ageInTicks, 1f);
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