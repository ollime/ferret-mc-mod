package com.github.ollime.ferretmod.entity.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.FoxEntity;
import net.minecraft.item.ItemStack;

import java.util.List;

public class PickupItemGoal extends Goal {
    private final MobEntity mob;
    private boolean itemExists;

    // TODO: range and sprint speed
    public PickupItemGoal(MobEntity mob) {
        this.mob = mob;
        this.itemExists = true;
    }

    @Override
    public boolean canStart() {
        if (FerretEntity.canEquip((FerretEntity) mob)) {
            if (mob.getRandom().nextFloat() < 0.1) {
                return !mob.getWorld().getEntitiesByClass(ItemEntity.class, mob.getBoundingBox().expand(10), item -> true).isEmpty();
            }
        }
        return false;
    }

    @Override
    public void start() {
        // range to start
        List<ItemEntity> items = mob.getWorld().getEntitiesByClass(ItemEntity.class, mob.getBoundingBox().expand(10.0), item -> true);
        if (!items.isEmpty()) {
            ItemEntity itemToPickup = items.getFirst();
            mob.getNavigation().startMovingTo(itemToPickup, 1.0);
        }
    }

    @Override
    public void tick() {
        // range to take item
        List<ItemEntity> closeItems = mob.getWorld().getEntitiesByClass(ItemEntity.class, mob.getBoundingBox().expand(1.0), item -> true);
        ItemStack itemStack = FerretEntity.getEquippedItem((FerretEntity) mob);

        if (!closeItems.isEmpty() && itemStack.isEmpty()) {
            ItemEntity itemToPickup = closeItems.getFirst();
            FerretEntity.equipStack((FerretEntity) mob, itemToPickup.getStack());
            itemToPickup.remove(Entity.RemovalReason.DISCARDED);
            itemExists = !itemExists;
        }
    }

    @Override
    public void stop() {
        this.itemExists = false;
    }
}
