package com.github.ollime.ferretmod.entity.custom;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.ai.FuzzyTargeting;
import net.minecraft.entity.ai.goal.WanderAroundGoal;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Vec3d;
import org.jetbrains.annotations.Nullable;

public class StashItemGoal extends WanderAroundGoal {
    private final MobEntity mob;
    private double targetX;
    private double targetY;
    private double targetZ;

    public StashItemGoal(MobEntity mob) {
        super((PathAwareEntity) mob, 1.0F);
        this.mob = mob;
    }

    @Override
    public boolean canStart() {
        ItemStack item = FerretEntity.getEquippedItem((FerretEntity) mob);
        Vec3d vec3d = this.getWanderTarget();
        if (!item.isEmpty()) {
            if (vec3d == null) {
                return false;
            } else {
                this.targetX = vec3d.x;
                this.targetY = vec3d.y;
                this.targetZ = vec3d.z;
                return true;
            }
        }
        else {
            return false;
        }
    }

    @Override
    public void start() {
        this.mob.getNavigation().startMovingTo(this.targetX, this.targetY, this.targetZ, this.speed);
    }

    @Override
    public void stop() {
        ItemStack item = FerretEntity.getEquippedItem((FerretEntity) mob);

        // drop current item
        mob.dropItem(item.getItem());
        mob.equipStack(EquipmentSlot.MAINHAND, ItemStack.EMPTY);
        this.mob.getNavigation().stop();

        super.stop();
    }

    @Nullable
    @Override
    protected Vec3d getWanderTarget() {
        if (this.mob.isInsideWaterOrBubbleColumn()) {
            Vec3d vec3d = FuzzyTargeting.find((PathAwareEntity) this.mob, 40, 7);
            return vec3d == null ? super.getWanderTarget() : vec3d;
        } else {
            return FuzzyTargeting.find((PathAwareEntity) this.mob, 40, 7);
        }
    }
}
