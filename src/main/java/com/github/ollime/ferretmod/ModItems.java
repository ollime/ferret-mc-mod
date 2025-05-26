package com.github.ollime.ferretmod;

import com.github.ollime.ferretmod.entity.ModEntities;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item FERRET_SPAWN_EGG = registerItem("ferret_spawn_egg",
            new SpawnEggItem(ModEntities.FERRET, 0x896a5a, 0x3f2006, new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(FerretMod.MOD_ID, name), item);
    }

    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS).register((itemGroup) -> itemGroup.add(ModItems.FERRET_SPAWN_EGG));
    }
}
