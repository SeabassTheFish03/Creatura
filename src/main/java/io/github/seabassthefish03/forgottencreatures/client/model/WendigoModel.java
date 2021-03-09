package io.github.seabassthefish03.forgottencreatures.client.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import io.github.seabassthefish03.forgottencreatures.common.entities.Wendigo;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

// Made with Blockbench 3.7.5
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports


public class WendigoModel extends EntityModel<Wendigo> {
	private final ModelRenderer Body;
	private final ModelRenderer Legs;
	private final ModelRenderer Arms;
	private final ModelRenderer Head;

	public WendigoModel() {
		textureWidth = 32;
		textureHeight = 32;

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, 24.0F, 0.0F);
		

		Legs = new ModelRenderer(this);
		Legs.setRotationPoint(0.0F, 0.0F, 0.0F);
		Body.addChild(Legs);
		Legs.setTextureOffset(0, 16).addBox(3.0F, -7.0F, -3.0F, 3.0F, 7.0F, 1.0F, 0.0F, false);
		Legs.setTextureOffset(12, 12).addBox(-6.0F, -7.0F, -3.0F, 3.0F, 7.0F, 1.0F, 0.0F, false);

		Arms = new ModelRenderer(this);
		Arms.setRotationPoint(0.0F, 0.0F, 0.0F);
		Body.addChild(Arms);
		Arms.setTextureOffset(6, 6).addBox(-5.0F, -16.0F, -3.0F, 2.0F, 9.0F, 1.0F, 0.0F, false);
		Arms.setTextureOffset(0, 6).addBox(3.0F, -16.0F, -3.0F, 2.0F, 9.0F, 1.0F, 0.0F, false);

		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.0F, 0.0F, 0.0F);
		Body.addChild(Head);
		Head.setTextureOffset(0, 0).addBox(-5.0F, -21.0F, -3.0F, 10.0F, 5.0F, 1.0F, 0.0F, false);
	}

	
	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	@Override
	public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn,
			float red, float green, float blue, float alpha) {
		Body.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
	}

	@Override
	public void setRotationAngles(Wendigo entityIn, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
		Body.rotationPointY = 8.0f + 1.5f * MathHelper.sin(ageInTicks / 20.0f * (float)Math.PI);
		Body.rotateAngleX = (float)Math.toRadians(MathHelper.clamp(
			10.0f * (float)entityIn.getMotion().mul(1, 0, 1).length() / 0.3f,
			-10.0f, 10.0f
		));
	}
}