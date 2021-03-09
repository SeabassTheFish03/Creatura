package io.github.seabassthefish03.forgottencreatures.common.entities;

import io.github.seabassthefish03.forgottencreatures.ForgottenCreatures;
import io.github.seabassthefish03.forgottencreatures.client.model.WendigoModel;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class WendigoRenderer extends MobRenderer<Wendigo, WendigoModel>{
	public WendigoRenderer(EntityRendererManager rendererManager, WendigoModel entityModelIn, float shadowSizeIn) {
        super(rendererManager, entityModelIn, shadowSizeIn);
    }

    @Override
    public ResourceLocation getEntityTexture(Wendigo entity) {
        return new ResourceLocation(ForgottenCreatures.MODID, "textures/entities/wendigo.png");
    }
}
