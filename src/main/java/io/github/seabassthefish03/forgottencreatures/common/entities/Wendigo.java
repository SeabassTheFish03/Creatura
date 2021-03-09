package io.github.seabassthefish03.forgottencreatures.common.entities;

import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.PanicGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class Wendigo extends MonsterEntity {
	
	private int timer;

	
	public Wendigo(EntityType<Wendigo> type, World worldIn) {
		super(type, worldIn);
		registerGoals();
	}

	@Override
	protected void registerData() {
		super.registerData();
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
		this.goalSelector.addGoal(1, new PanicGoal(this, 1.25D));
		this.goalSelector.addGoal(6, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
		this.goalSelector.addGoal(7, new LookAtGoal(this, PlayerEntity.class, 6.0F));
		this.goalSelector.addGoal(8, new LookRandomlyGoal(this));
	}
	
	public static AttributeModifierMap createAttributes() {
		return MonsterEntity.func_234295_eP_()
	            .createMutableAttribute(Attributes.MAX_HEALTH, 20.0D)
	            .createMutableAttribute(Attributes.MOVEMENT_SPEED, (double)0.2F)
	            .createMutableAttribute(Attributes.ATTACK_DAMAGE, 4.0D)
	            .createMutableAttribute(Attributes.ARMOR, 0.0D)
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

   @OnlyIn(Dist.CLIENT)
   public float getHeadRotationPointY(float p_70894_1_) {
      if (this.timer <= 0) {
         return 0.0F;
      } else if (this.timer >= 4 && this.timer <= 36) {
         return 1.0F;
      } else {
         return this.timer < 4 ? ((float)this.timer - p_70894_1_) / 4.0F : -((float)(this.timer - 40) - p_70894_1_) / 4.0F;
      }
   }

   @OnlyIn(Dist.CLIENT)
   public float getHeadRotationAngleX(float p_70890_1_) {
      if (this.timer > 4 && this.timer <= 36) {
         float f = ((float)(this.timer - 4) - p_70890_1_) / 32.0F;
         return ((float)Math.PI / 5F) + 0.21991149F * MathHelper.sin(f * 28.7F);
      } else {
         return this.timer > 0 ? ((float)Math.PI / 5F) : this.rotationPitch * ((float)Math.PI / 180F);
      }
   }
   
   public void onStruckByLightning(LightningBoltEntity lightningBolt) {
	   this.setGlowing(true);
   }
}
