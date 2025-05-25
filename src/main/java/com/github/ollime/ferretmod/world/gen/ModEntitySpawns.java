package com.github.ollime.ferretmod.world.gen;

import com.github.ollime.ferretmod.entity.ModEntities;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnLocationTypes;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.BiomeKeys;

public class ModEntitySpawns {
    public static void addSpawns() {
        BiomeModifications.addSpawn(
                BiomeSelectors.includeByKey(
                        BiomeKeys.PLAINS,
                        BiomeKeys.FOREST,
                        BiomeKeys.PLAINS,
                        BiomeKeys.FLOWER_FOREST,
                        BiomeKeys.MEADOW,
                        BiomeKeys.SUNFLOWER_PLAINS
                ),
                SpawnGroup.CREATURE,
                ModEntities.FERRET,
                10,
                2,
                5
        );

        SpawnRestriction.register(ModEntities.FERRET, SpawnLocationTypes.ON_GROUND,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalEntity::isValidNaturalSpawn);
    }
}
