package com.github.ollime.ferretmod.entity;

import com.github.ollime.ferretmod.FerretMod;
import com.github.ollime.ferretmod.entity.custom.FerretEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final EntityType<FerretEntity> FERRET = Registry.register(
            Registries.ENTITY_TYPE,
            Identifier.of(FerretMod.MOD_ID, "ferret"),
            EntityType.Builder.create(FerretEntity::new, SpawnGroup.CREATURE)
                    .dimensions(1f, 2.5f).build());

    public static void registerModEntities() {

    }
}
