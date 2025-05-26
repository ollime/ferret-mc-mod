package com.github.ollime.ferretmod.entity.client;

import com.github.ollime.ferretmod.FerretMod;
import com.github.ollime.ferretmod.entity.custom.FerretEntity;

import com.github.ollime.ferretmod.entity.custom.FerretVariant;
import com.google.common.collect.Maps;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.Map;

public class FerretRenderer extends MobEntityRenderer<FerretEntity, FerretModel<FerretEntity>> {
    private static final Map<FerretVariant, Identifier> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(FerretVariant.class), map -> {
                map.put(FerretVariant.CHOCOLATE_STANDARD,
                        Identifier.of(FerretMod.MOD_ID,"textures/entity/ferret/chocolate_standard.png"));
                map.put(FerretVariant.CHOCOLATE_MITTS,
                        Identifier.of(FerretMod.MOD_ID,"textures/entity/ferret/chocolate_mitts.png"));
                map.put(FerretVariant.CHOCOLATE_BIB,
                        Identifier.of(FerretMod.MOD_ID,"textures/entity/ferret/chocolate_bib.png"));
                map.put(FerretVariant.CHOCOLATE_WITH_WHITE,
                        Identifier.of(FerretMod.MOD_ID,"textures/entity/ferret/chocolate_with_white.png"));
                map.put(FerretVariant.BLACK_SABLE,
                        Identifier.of(FerretMod.MOD_ID,"textures/entity/ferret/black_sable.png"));
                map.put(FerretVariant.PANDA,
                        Identifier.of(FerretMod.MOD_ID,"textures/entity/ferret/panda.png"));
                map.put(FerretVariant.WHITE,
                        Identifier.of(FerretMod.MOD_ID,"textures/entity/ferret/white.png"));
                map.put(FerretVariant.SABLE_BLAZE,
                        Identifier.of(FerretMod.MOD_ID,"textures/entity/ferret/sable_blaze.png"));
                map.put(FerretVariant.CHAMPAGNE_POINT,
                        Identifier.of(FerretMod.MOD_ID, "textures/entity/ferret/champagne_point.png"));
            });

    public FerretRenderer(EntityRendererFactory.Context context) {
        super(context, new FerretModel<>(context.getPart(FerretModel.FERRET)), 0.75f);
        this.addFeature(new FerretHeldItemFeatureRenderer(this, context.getHeldItemRenderer()));
    }

    @Override
    public Identifier getTexture(FerretEntity entity) {
//        return Identifier.of("textures/entity/ferret/texture.png");
        return LOCATION_BY_VARIANT.get(entity.getVariant());
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
