package com.github.ollime.ferretmod.client;

import com.github.ollime.ferretmod.entity.ModEntities;
import com.github.ollime.ferretmod.entity.client.FerretModel;
import com.github.ollime.ferretmod.entity.client.FerretRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;

public class FerretModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityModelLayerRegistry.registerModelLayer(FerretModel.FERRET, FerretModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.FERRET, FerretRenderer::new);
    }
}
