package io.github.seabassthefish03.forgottencreatures.core.init;

import io.github.seabassthefish03.forgottencreatures.ForgottenCreatures;
import io.github.seabassthefish03.forgottencreatures.common.entities.WendigoEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class EntityTypeInit {
	
	public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, ForgottenCreatures.MODID);
	
	public static RegistryObject<EntityType<WendigoEntity>> WENDIGO = registerEntity(WendigoEntity::new, "wendigo", EntityClassification.MONSTER, 1.0f, 3.5f, 0xffffff, 0x000000);
	
	static <T extends Entity> RegistryObject<EntityType<T>> registerEntity(EntityType.IFactory<T> factory,
			String name, EntityClassification kind, float width, float height) {
		EntityType<T> type = EntityType.Builder.<T>create(factory, kind)
				.setTrackingRange(64)
				.setUpdateInterval(1)
				.size(width, height)
				.build(new ResourceLocation(ForgottenCreatures.MODID, name).toString());
		return ENTITY_TYPES.register(name, () -> type);
	}
	
	static <T extends Entity> RegistryObject<EntityType<T>> registerEntity(EntityType.IFactory<T> factory,
			String name, EntityClassification kind, float width, float height, int color1, int color2) {
		EntityType<T> type = EntityType.Builder.<T>create(factory, kind)
				.setTrackingRange(64)
				.setUpdateInterval(1)
				.size(width, height)
				.build(new ResourceLocation(ForgottenCreatures.MODID, name).toString());
		ItemInit.ITEMS.register("spawn_" + name.toLowerCase(), () -> new SpawnEggItem(type, color1, color2, new Item.Properties().group(ItemGroup.MISC)));
		return ENTITY_TYPES.register(name, () -> type);
	}
}
