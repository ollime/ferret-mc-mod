package com.github.ollime.ferretmod.entity.custom;

import com.github.ollime.ferretmod.entity.ModEntities;
import net.minecraft.entity.AnimationState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class FerretEntity extends AnimalEntity {
    public final AnimationState IdleAnimationState = new AnimationState();
    private int IdleAnimationTimeout = 0;

    public FerretEntity(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));

        this.goalSelector.add(1, new AnimalMateGoal(this, 1.150D));
        this.goalSelector.add(2, new TemptGoal(this, 1.250D, Ingredient.ofItems(Items.CHICKEN), false));

        this.goalSelector.add(3, new FollowParentGoal(this, 1.10D));
        this.goalSelector.add(4, new WanderAroundFarGoal(this, 1.00D));
        this.goalSelector.add(5, new LookAtEntityGoal(this, PlayerEntity.class, 4.0F));
        this.goalSelector.add(6, new LookAroundGoal(this));
    }

    public static DefaultAttributeContainer.Builder createAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 10)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.35)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 20);
    }

    private void setupAnimationStates() {
        if (this.IdleAnimationTimeout <= 0) {
            this.IdleAnimationTimeout = 40; // 2 second long animation = 40 ticks
            this.IdleAnimationState.start(this.age);
        }
        else {
            --this.IdleAnimationTimeout;
        }
    }

    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return stack.isOf(Items.CHICKEN);
    }

    @Override
    public @Nullable PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return ModEntities.FERRET.create(world);
    }
}
