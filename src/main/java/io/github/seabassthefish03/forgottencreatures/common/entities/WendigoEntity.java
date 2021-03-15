package io.github.seabassthefish03.forgottencreatures.common.entities;

import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class WendigoEntity extends MonsterEntity implements IAnimatable {
	private static final DataParameter<Boolean> IS_ATTACKING = EntityDataManager.createKey(WendigoEntity.class, DataSerializers.BOOLEAN);
	
	private int timer;

	private AnimationFactory factory = new AnimationFactory(this);
	
	public WendigoEntity(EntityType<WendigoEntity> type, World worldIn) {
		super(type, worldIn);
		registerGoals();
	}
	
	private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
		if (!event.isMoving() && !this.dataManager.get(IS_ATTACKING)) {
			event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.wendigo.idle", true));
			return PlayState.CONTINUE;
		}
		if (event.isMoving() && !this.dataManager.get(IS_ATTACKING)) {
			event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.wendigo.walk", true));
			return PlayState.CONTINUE;
		}
		if (this.dataManager.get(IS_ATTACKING)) {
			event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.wendigo.attack", true));
			return PlayState.CONTINUE;
		}
		return PlayState.STOP;
	}
	
	@Override
	public boolean attackEntityAsMob(Entity entityIn) {
		boolean flag = super.attackEntityAsMob(entityIn);
		if (flag && entityIn instanceof PlayerEntity) {
			float f = this.world.getDifficultyForLocation(this.getPosition()).getAdditionalDifficulty();
			((LivingEntity) entityIn).addPotionEffect(new EffectInstance(Effects.HUNGER, 140 * ((int) f), 2));
			((LivingEntity) entityIn).addPotionEffect(new EffectInstance(Effects.SLOWNESS, 140 * ((int) f), 1));
		}
		return flag;
	}

	@Override
	protected void registerData() {
		super.registerData();
		this.dataManager.register(IS_ATTACKING, false);
	}
	
	@OnlyIn(Dist.CLIENT)
	public boolean isAttacking() {
		return this.dataManager.get(IS_ATTACKING);
	}

	public void setAttacking(boolean attacking) {
		this.dataManager.set(IS_ATTACKING, attacking);
	}

	
	@Override
	public CreatureAttribute getCreatureAttribute() {
		return CreatureAttribute.UNDEAD;
	}
	
	@Override
	public boolean isEntityUndead() {
		return true;
	}
	
	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(0, new SwimGoal(this));
		this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.5D, false));
		this.goalSelector.addGoal(6, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
		this.goalSelector.addGoal(7, new LookAtGoal(this, PlayerEntity.class, 6.0F));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
	}
	
	public static AttributeModifierMap createAttributes() {
		return MonsterEntity.func_234295_eP_()
	            .createMutableAttribute(Attributes.MAX_HEALTH, 40.0D)
	            .createMutableAttribute(Attributes.MOVEMENT_SPEED, (double)0.3F)
	            .createMutableAttribute(Attributes.ATTACK_DAMAGE, 8.0D)
	            .createMutableAttribute(Attributes.ARMOR, 1.0D)
	            .create();
	}
	
	@Override
	public double getAttributeValue(Attribute attribute) {
		return this.getAttributeManager().getAttributeBaseValue(attribute);
	}
	
	@Override
	public double getBaseAttributeValue(Attribute attribute) {
	      return this.getAttributeManager().getAttributeBaseValue(attribute);
	}
	
	@Override
	public void livingTick() {
		if (this.world.isRemote) {
			this.timer = Math.max(0, this.timer - 1);
		}
		super.livingTick();
	}
	
	@OnlyIn(Dist.CLIENT)
	public void handleStatusUpdate(byte id) {
		if (id == 10) {
			this.timer = 40;
		} else {
			super.handleStatusUpdate(id);
		}
	}

	@Override
	protected int getExperiencePoints(PlayerEntity player) {
		return 20;
	}
	
	@Override
	public void registerControllers(AnimationData data) {
		data.addAnimationController(new AnimationController<WendigoEntity>(this, "controller", 0, this::predicate));
	}
	
	@Override
	public AnimationFactory getFactory() {
		return this.factory;
	}
}
