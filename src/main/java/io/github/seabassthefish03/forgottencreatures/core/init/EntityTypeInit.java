package io.github.seabassthefish03.forgottencreatures.core.init;

import java.util.Random;

import io.github.seabassthefish03.forgottencreatures.ForgottenCreatures;
import io.github.seabassthefish03.forgottencreatures.common.entities.Wendigo;
import io.github.seabassthefish03.forgottencreatures.common.entities.WraithEntity;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class EntityTypeInit {
	
	public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, ForgottenCreatures.MODID);
	
	static EntityType<Wendigo> type = EntityType.Builder.<Wendigo>create(Wendigo::new, EntityClassification.MONSTER)
            .setTrackingRange(64)
            .setUpdateInterval(1)
            .size(0.9f, 1.3f)
            .build(new ResourceLocation(ForgottenCreatures.MODID, "wendigo").toString());
	
	static EntityType<WraithEntity> WRAITHTYPE = EntityType.Builder.<WraithEntity>create(WraithEntity::new, EntityClassification.MONSTER)
			.setTrackingRange(64)
			.setUpdateInterval(1)
			.size(0.6f, 1.9f)
			.build(ForgottenCreatures.MODID + ":" + "Wraith");
	
	public static RegistryObject<EntityType<Wendigo>> WENDIGO = ENTITY_TYPES.register("wendigo", () -> type);
	public static RegistryObject<EntityType<WraithEntity>> WRAITH = ENTITY_TYPES.register("wraith", () -> WRAITHTYPE);
	
}
