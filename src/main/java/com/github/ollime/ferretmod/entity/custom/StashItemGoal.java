package com.github.ollime.ferretmod.entity.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.FoxEntity;
import net.minecraft.item.ItemStack;

import java.util.List;

public class StashItemGoal extends Goal {
    private final MobEntity mob;
    private boolean itemExists;

    public StashItemGoal(MobEntity mob) {
        this.mob = mob;
        this.itemExists = true;
    }

    @Override
    public boolean canStart() {
        // TODO: add chance
        ItemStack item = FerretEntity.getEquippedItem((FerretEntity) mob);
        return item != null;
    }

    @Override
    public void start() {
        // range to start
        ItemStack item = FerretEntity.getEquippedItem((FerretEntity) mob);
        mob.getNavigation().findPathTo(mob, 10);
        mob.dropItem(item.getItem());
    }

    @Override
    public void tick() {
        // range to take item
        List<ItemEntity> closeItems = mob.getWorld().getEntitiesByClass(ItemEntity.class, mob.getBoundingBox().expand(1.0), item -> true);
        ItemStack itemStack = FerretEntity.getEquippedItem((FerretEntity) mob);

        if (!closeItems.isEmpty() && itemStack.isEmpty()) {
            ItemEntity itemToPickup = closeItems.getFirst();
            FerretEntity.equipStack((FerretEntity) mob, itemToPickup.getStack());
//            itemToPickup.remove(Entity.RemovalReason.DISCARDED);
            itemExists = !itemExists;
        }
    }

    @Override
    public void stop() {
        this.itemExists = false;
    }
}
