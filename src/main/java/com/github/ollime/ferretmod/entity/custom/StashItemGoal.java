package com.github.ollime.ferretmod.entity.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.pathing.Path;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.FoxEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;

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
        return !item.isEmpty();
    }

    @Override
    public void start() {
        ItemStack item = FerretEntity.getEquippedItem((FerretEntity) mob);
    }

    @Override
    public void tick() {
        ItemStack item = FerretEntity.getEquippedItem((FerretEntity) mob);

        if (item == null) {
            this.stop();
        } else {
            mob.dropItem(item.getItem());
            mob.equipStack(EquipmentSlot.MAINHAND, ItemStack.EMPTY);
            this.stop(); // End the goal after dropping
        }
    }

    @Override
    public void stop() {
        this.itemExists = false;
    }
}
