package io.github.seabassthefish03.forgottencreatures.client.model.armor;

import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.inventory.EquipmentSlotType;

public class WendigoSkullModel extends ArmorModel {
	private final ModelRenderer skull;

	public WendigoSkullModel() {
		super(EquipmentSlotType.HEAD, 64, 32);
		textureWidth = 64;
		textureHeight = 32;

		skull = new ModelRenderer(this);
		skull.setRotationPoint(0.0F, -7.0F, 0.0F);
		bipedHead.addChild(skull);
		setRotationAngle(skull, -0.0873F, 0.0F, 0.0F);
		skull.setTextureOffset(0, 0).addBox(-5.0F, -2.0F, -5.0F, 10.0F, 2.0F, 10.0F, 0.0F, false);
		skull.setTextureOffset(0, 12).addBox(-4.0F, -12.0F, -4.0F, 8.0F, 10.0F, 8.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//
	}
}
