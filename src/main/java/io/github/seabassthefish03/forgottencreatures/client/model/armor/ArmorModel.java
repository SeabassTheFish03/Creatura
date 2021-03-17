package io.github.seabassthefish03.forgottencreatures.client.model.armor;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.inventory.EquipmentSlotType;

@SuppressWarnings("rawtypes")
public class ArmorModel extends BipedModel {
	EquipmentSlotType slot;

	public ModelRenderer copyWithoutBoxes(ModelRenderer box) {
		ModelRenderer newbox = new ModelRenderer(this);
		newbox.setRotationPoint(box.rotationPointX, box.rotationPointY, box.rotationPointZ);
		setRotationAngle(newbox, box.rotateAngleX, box.rotateAngleY, box.rotateAngleZ);
		newbox.mirror = box.mirror;
		newbox.showModel = box.showModel;
		return newbox;
	}

	@SuppressWarnings("unchecked")
	public ArmorModel(EquipmentSlotType slot, int texWidth, int texHeight) {
		super(0, 0, texWidth, texHeight);
		this.slot = slot;

		bipedHead = copyWithoutBoxes(bipedHead);
		bipedBody = copyWithoutBoxes(bipedBody);
		bipedLeftArm = copyWithoutBoxes(bipedLeftArm);
		bipedLeftLeg = copyWithoutBoxes(bipedLeftLeg);
		bipedRightArm = copyWithoutBoxes(bipedRightArm);
		bipedRightLeg = copyWithoutBoxes(bipedRightLeg);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		bipedHeadwear.showModel = false;
		bipedBody.showModel = bipedLeftArm.showModel = bipedRightArm.showModel =
			bipedHead.showModel = bipedLeftLeg.showModel = bipedRightLeg.showModel = false;

		if (slot == EquipmentSlotType.CHEST) {
			bipedBody.showModel = true;
			bipedLeftArm.showModel = true;
			bipedRightArm.showModel = true;
		}

		if (slot == EquipmentSlotType.HEAD) {
			bipedHead.showModel = true;
		}

		if (slot == EquipmentSlotType.FEET) {
			bipedLeftLeg.showModel = true;
			bipedRightLeg.showModel = true;
		}
		super.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
		// TODO Auto-generated method stub
		
	}
}
