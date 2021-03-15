package io.github.seabassthefish03.forgottencreatures.client.model.entity;

import io.github.seabassthefish03.forgottencreatures.ForgottenCreatures;
import io.github.seabassthefish03.forgottencreatures.common.entities.WendigoEntity;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class ModelWendigo extends AnimatedGeoModel<WendigoEntity>{

	@Override
	public ResourceLocation getAnimationFileLocation(WendigoEntity animatable) {
		return new ResourceLocation(ForgottenCreatures.MODID, "animations/wendigo.animation.json");
	}

	@Override
	public ResourceLocation getModelLocation(WendigoEntity object) {
		return new ResourceLocation(ForgottenCreatures.MODID, "geo/wendigo.geo.json");
	}

	@Override
	public ResourceLocation getTextureLocation(WendigoEntity object) {
		return new ResourceLocation(ForgottenCreatures.MODID, "textures/entities/wendigo.png");
	}

}
