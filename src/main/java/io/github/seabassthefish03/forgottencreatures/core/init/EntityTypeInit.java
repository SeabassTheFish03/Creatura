package io.github.seabassthefish03.forgottencreatures.core.init;

import io.github.seabassthefish03.forgottencreatures.ForgottenCreatures;
import io.github.seabassthefish03.forgottencreatures.common.entities.Wendigo;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class EntityTypeInit {
	
	public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, ForgottenCreatures.MODID);
	
	static EntityType<Wendigo> type = EntityType.Builder.<Wendigo>create(Wendigo::new, EntityClassification.MONSTER)
            .setTrackingRange(64)
            .setUpdateInterval(1)
            .size(0.9f, 0.6f)
            .build(new ResourceLocation(ForgottenCreatures.MODID, "wendigo").toString());
	
	public static RegistryObject<EntityType<Wendigo>> WENDIGO = ENTITY_TYPES.register("wendigo", () -> type);
	
}
