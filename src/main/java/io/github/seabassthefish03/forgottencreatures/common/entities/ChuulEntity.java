package io.github.seabassthefish03.forgottencreatures.common.entities;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.World;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class ChuulEntity extends MonsterEntity implements IAnimatable{
	private static final DataParameter<Boolean> IS_ATTACKING = EntityDataManager.createKey(ChuulEntity.class, DataSerializers.BOOLEAN);
	
	private int timer;

	private AnimationFactory factory = new AnimationFactory(this);

	protected ChuulEntity(EntityType<ChuulEntity> type, World worldIn) {
		super(type, worldIn);
		registerGoals();
	}

	@Override
	public void registerControllers(AnimationData data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public AnimationFactory getFactory() {
		// TODO Auto-generated method stub
		return null;
	}

}
