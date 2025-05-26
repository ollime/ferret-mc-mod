package com.github.ollime.ferretmod.entity.custom;

import com.github.ollime.ferretmod.entity.ModEntities;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.recipe.Ingredient;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Util;
import net.minecraft.world.EntityView;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import net.minecraft.entity.EquipmentSlot;

public class FerretEntity extends TameableEntity {
    private static final TrackedData<Integer> DATA_ID_TYPE_VARIANT =
            DataTracker.registerData(FerretEntity.class, TrackedDataHandlerRegistry.INTEGER);

    public static ItemStack getEquippedItem(FerretEntity mob) {
        return mob.getEquippedStack(EquipmentSlot.MAINHAND);
    }

    public FerretEntity(EntityType<? extends TameableEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new SitGoal(this));
        this.goalSelector.add(2, new AnimalMateGoal(this, 1.150D));
        this.goalSelector.add(4, new TemptGoal(this, 1.250D, Ingredient.ofItems(Items.CHICKEN), false));
        this.goalSelector.add(6, new FollowParentGoal(this, 1.10D));
        this.goalSelector.add(7, new FollowOwnerGoal(this, 1.0, 10.0F, 5.0F));
        this.goalSelector.add(8, new StashItemGoal(this));
        this.goalSelector.add(9, new WanderAroundFarGoal(this, 1.00D));
        this.goalSelector.add(10, new LookAtEntityGoal(this, PlayerEntity.class, 4.0F));
        this.goalSelector.add(11, new LookAroundGoal(this));
        this.goalSelector.add(12, new PickupItemGoal(this));
    }

    public static DefaultAttributeContainer.Builder createAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 10)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.35)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 20);
    }

    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return stack.isOf(Items.CHICKEN);
    }

    @Override
    public @Nullable PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        FerretEntity baby = ModEntities.FERRET.create(world);
        FerretVariant variant = Util.getRandom(FerretVariant.values(), this.random);
        if (baby != null) {
            baby.setVariant(variant);
        }
        return baby;
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_FOX_AMBIENT;
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_FOX_HURT;
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_FOX_DEATH;
    }

    @Override
    public void setTamed(boolean tamed, boolean updateAttributes) {
        super.setTamed(tamed, updateAttributes);
    }

    private void tryTame(PlayerEntity player) {
        if (this.random.nextInt(3) == 0) {
            this.setOwner(player);
            this.getWorld().sendEntityStatus(this, EntityStatuses.ADD_POSITIVE_PLAYER_REACTION_PARTICLES);
        } else {
            this.getWorld().sendEntityStatus(this, EntityStatuses.ADD_NEGATIVE_PLAYER_REACTION_PARTICLES);
        }
    }

    @Override
    public ActionResult interactMob(PlayerEntity player, Hand hand) {
        ItemStack itemStack = player.getStackInHand(hand);
        Item item = itemStack.getItem();
        if (this.isTamed()) {
            if (this.isOwner(player)) {
                if (this.isBreedingItem(itemStack) && this.getHealth() < this.getMaxHealth()) {
                    if (!this.getWorld().isClient()) {
                        this.eat(player, hand, itemStack);
                        FoodComponent foodComponent = itemStack.get(DataComponentTypes.FOOD);
                        this.heal(foodComponent != null ? foodComponent.nutrition() : 1.0F);
                    }

                    return ActionResult.success(this.getWorld().isClient());
                }

                ActionResult actionResult = super.interactMob(player, hand);
                if (!actionResult.isAccepted()) {
                    return ActionResult.success(this.getWorld().isClient());
                }

                return actionResult;
            }
        } else if (this.isBreedingItem(itemStack)) {
            if (!this.getWorld().isClient()) {
                this.eat(player, hand, itemStack);
                this.tryTame(player);
                this.setPersistent();
            }

            return ActionResult.success(this.getWorld().isClient());
        }

        ActionResult actionResult = super.interactMob(player, hand);
        if (actionResult.isAccepted()) {
            this.setPersistent();
        }

        return actionResult;
    }

    @Override
    public boolean canEquip(ItemStack stack) {
        EquipmentSlot equipmentSlot = this.getPreferredEquipmentSlot(stack);
        return this.getEquippedStack(equipmentSlot).isEmpty() && equipmentSlot == EquipmentSlot.MAINHAND && super.canEquip(stack);
    }

    public static boolean canEquip(FerretEntity ferret) {
        if (!ferret.getEquippedStack(EquipmentSlot.MAINHAND).isEmpty()) {
            return false;
        }
        return ferret.getRandom().nextInt(10) == 0;
    }

    public static void equipStack(FerretEntity ferret, ItemStack stack) {
        ferret.equipStack(EquipmentSlot.MAINHAND, stack);
    }

    @Override
    public EntityView method_48926() {
        return super.getWorld();
    }

    @Override
    public @Nullable LivingEntity getOwner() {
        return super.getOwner();
    }

    @Override
    protected void initDataTracker(DataTracker.Builder builder) {
        super.initDataTracker(builder);
        builder.add(DATA_ID_TYPE_VARIANT, 0);
    }

    public FerretVariant getVariant() {
        return FerretVariant.byId(this.getTypeVariant() & 255);
    }

    private int getTypeVariant() {
        return this.dataTracker.get(DATA_ID_TYPE_VARIANT);
    }

    private void setVariant(FerretVariant variant) {
        this.dataTracker.set(DATA_ID_TYPE_VARIANT, variant.getId() & 255);
    }

    @Override
    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        nbt.putInt("Variant", this.getTypeVariant());
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        this.dataTracker.set(DATA_ID_TYPE_VARIANT, nbt.getInt("Variant"));
    }

    @Override
    public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason,
                                 @Nullable EntityData entityData) {
        FerretVariant variant = Util.getRandom(FerretVariant.values(), this.random);
        setVariant(variant);
        return super.initialize(world, difficulty, spawnReason, entityData);
    }
}
