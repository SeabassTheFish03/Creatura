package io.github.seabassthefish03.forgottencreatures.client.render.entity;

import io.github.seabassthefish03.forgottencreatures.ForgottenCreatures;
import io.github.seabassthefish03.forgottencreatures.client.model.WendigoModel;
import io.github.seabassthefish03.forgottencreatures.common.entities.Wendigo;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class WendigoRender extends MobRenderer<Wendigo, WendigoModel<Wendigo>>{
	
	protected static final ResourceLocation TEXTURE = new ResourceLocation(ForgottenCreatures.MODID,
			"textures/entities/wendigo.png");
	
	public WendigoRender(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new WendigoModel<Wendigo>(), 0.5F);
	}
	
	@Override
	public ResourceLocation getEntityTexture(Wendigo wendigo) {
		return TEXTURE;
	}
}
