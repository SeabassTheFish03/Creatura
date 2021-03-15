package io.github.seabassthefish03.forgottencreatures;

import io.github.seabassthefish03.forgottencreatures.client.render.entity.WendigoRenderer;
import io.github.seabassthefish03.forgottencreatures.core.init.EntityTypeInit;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {
	
	public void clientInit() {
		RenderingRegistry.registerEntityRenderingHandler(EntityTypeInit.WENDIGO.get(), (erm) -> new WendigoRenderer(erm));
	}
}
