// Made with Blockbench 3.8.2
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports


/*public class custom_model extends EntityModel<Entity> {
	private final ModelRenderer armorHead;
	private final ModelRenderer Skull;
	private final ModelRenderer eyes;
	private final ModelRenderer cube_r1;
	private final ModelRenderer subeyes;
	private final ModelRenderer cube_r2;
	private final ModelRenderer armorBody;
	private final ModelRenderer armorRightArm;
	private final ModelRenderer armorLeftArm;
	private final ModelRenderer armorRightLeg;
	private final ModelRenderer armorRightBoot;
	private final ModelRenderer armorLeftLeg;
	private final ModelRenderer armorLeftBoot;

	public custom_model() {
		textureWidth = 128;
		textureHeight = 128;

		armorHead = new ModelRenderer(this);
		armorHead.setRotationPoint(0.0F, -2.0F, 0.0F);
		bipedHead.addChild(armorHead);
		

		Skull = new ModelRenderer(this);
		Skull.setRotationPoint(0.0F, -5.0F, 4.0F);
		armorHead.addChild(Skull);
		setRotationAngle(Skull, -0.2182F, 0.0F, 0.0F);
		Skull.setTextureOffset(22, 22).addBox(-2.0F, -2.0F, 0.0F, 4.0F, 5.0F, 10.0F, 0.0F, false);
		Skull.setTextureOffset(0, 6).addBox(-2.0F, 3.0F, 9.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
		Skull.setTextureOffset(10, 50).addBox(-2.0F, 3.0F, 1.0F, 1.0F, 1.0F, 8.0F, 0.0F, false);
		Skull.setTextureOffset(0, 49).addBox(1.0F, 3.0F, 1.0F, 1.0F, 1.0F, 8.0F, 0.0F, false);
		Skull.setTextureOffset(0, 0).addBox(-5.0F, -1.0F, -9.0F, 10.0F, 3.0F, 10.0F, 0.0F, false);

		eyes = new ModelRenderer(this);
		eyes.setRotationPoint(1.5F, 0.0F, 0.0F);
		Skull.addChild(eyes);
		setRotationAngle(eyes, 0.0F, -0.1309F, 0.0F);
		eyes.setTextureOffset(48, 29).addBox(0.5F, -1.0F, 0.0F, 1.0F, 3.0F, 8.0F, 0.0F, false);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(0.4779F, 0.5F, 9.9658F);
		eyes.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.0F, 0.2618F, 0.0F);
		cube_r1.setTextureOffset(48, 48).addBox(-2.5F, -1.5F, -10.0F, 1.0F, 3.0F, 8.0F, 0.0F, false);

		subeyes = new ModelRenderer(this);
		subeyes.setRotationPoint(0.4664F, -0.1394F, 3.4218F);
		eyes.addChild(subeyes);
		subeyes.setTextureOffset(0, 13).addBox(0.2145F, -1.0655F, -0.9541F, 1.0F, 3.0F, 3.0F, 0.0F, false);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(-0.2855F, 0.4345F, 7.5459F);
		subeyes.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.0F, 0.3491F, 0.0F);
		cube_r2.setTextureOffset(0, 0).addBox(-1.5F, -1.5F, -8.5F, 1.0F, 3.0F, 3.0F, 0.0F, false);

		armorBody = new ModelRenderer(this);
		armorBody.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedBody.addChild(armorBody);
		

		armorRightArm = new ModelRenderer(this);
		armorRightArm.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedRightArm.addChild(armorRightArm);
		

		armorLeftArm = new ModelRenderer(this);
		armorLeftArm.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedLeftArm.addChild(armorLeftArm);
		

		armorRightLeg = new ModelRenderer(this);
		armorRightLeg.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedRightLeg.addChild(armorRightLeg);
		

		armorRightBoot = new ModelRenderer(this);
		armorRightBoot.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedRightLeg.addChild(armorRightBoot);
		

		armorLeftLeg = new ModelRenderer(this);
		armorLeftLeg.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedLeftLeg.addChild(armorLeftLeg);
		

		armorLeftBoot = new ModelRenderer(this);
		armorLeftBoot.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedLeftLeg.addChild(armorLeftBoot);
		
	}

	@Override
	public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}*/