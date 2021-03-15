package io.github.seabassthefish03.forgottencreatures.common.items;

import io.github.seabassthefish03.forgottencreatures.ForgottenCreatures;
import net.minecraft.item.Item;

public class WendigoClawItem extends Item{
	public WendigoClawItem(Properties properties) {
		super(properties);
		this.setRegistryName(ForgottenCreatures.MODID, "wendigo_claw");
	}
}
