package com.github.ollime.ferretmod;

import com.github.ollime.ferretmod.entity.ModEntities;
import com.github.ollime.ferretmod.entity.custom.FerretEntity;
import com.github.ollime.ferretmod.world.gen.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;

public class FerretMod implements ModInitializer {

    public static String MOD_ID = "ferretmod";

    @Override
    public void onInitialize() {

        ModItems.initialize();

        ModEntities.registerModEntities();
        FabricDefaultAttributeRegistry.register(ModEntities.FERRET, FerretEntity.createAttributes());

        ModWorldGeneration.generateModWorldGen();

    }
}
