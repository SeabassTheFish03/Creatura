package io.github.seabassthefish03.forgottencreatures.core.init;

import io.github.seabassthefish03.forgottencreatures.ForgottenCreatures;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit {
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ForgottenCreatures.MODID);
	
	static RegistryObject<Item> WENDIGO_CLAW = addItem("wendigo_claw", new Item.Properties().group(ItemGroup.MISC));
	
	static RegistryObject<Item> addItem(String name, Item.Properties properties) {
		Item i = new Item(properties);
        return ITEMS.register(name, () -> i);
	}
}
