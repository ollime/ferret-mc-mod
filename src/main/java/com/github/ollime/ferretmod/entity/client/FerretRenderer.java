package com.github.ollime.ferretmod.entity.client;

import com.github.ollime.ferretmod.FerretMod;
import com.github.ollime.ferretmod.entity.custom.FerretEntity;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class FerretRenderer extends MobEntityRenderer<FerretEntity, FerretModel<FerretEntity>> {
    public FerretRenderer(EntityRendererFactory.Context context) {
        super(context, new FerretModel<>(context.getPart(FerretModel.FERRET)), 0.75f);
        this.addFeature(new FerretHeldItemFeatureRenderer(this, context.getHeldItemRenderer()));
    }

    @Override
    public Identifier getTexture(FerretEntity entity) {
        return Identifier.of(FerretMod.MOD_ID, "textures/entity/ferret/texture.png");
    }

    @Override
    public void render(FerretEntity livingEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
        if (livingEntity.isBaby()) {
            matrixStack.scale(0.5f, 0.5f, 0.5f);
        }
        else {
            matrixStack.scale(1f, 1f, 1f);
        }

        super.render(livingEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
