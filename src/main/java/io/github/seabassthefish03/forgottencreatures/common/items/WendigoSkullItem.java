package io.github.seabassthefish03.forgottencreatures.common.items;

import io.github.seabassthefish03.forgottencreatures.ForgottenCreatures;
import io.github.seabassthefish03.forgottencreatures.client.model.armor.WendigoSkullModel;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class WendigoSkullItem extends ArmorItem {
	@SuppressWarnings("unused")
	private static final int[] MAX_DAMAGE_ARRAY = new int[] {13, 15, 16, 11};
	
	public static class Material implements IArmorMaterial {
		@Override
        public int getDurability(EquipmentSlotType slot) {
            return -1;
        }

        @Override
        public int getDamageReductionAmount(EquipmentSlotType slot) {
            return 1;
        }

        @Override
        public int getEnchantability() {
            return -1;
        }

        @Override
        public SoundEvent getSoundEvent() {
            return SoundEvents.ENTITY_SKELETON_AMBIENT;
        }

        @Override
        public Ingredient getRepairMaterial() {
            return null;
        }

        @Override
        public String getName() {
            return ForgottenCreatures.MODID + ":wendigo_skull";
        }

        @Override
        public float getToughness() {
            return 0;
        }

        @Override
        public float getKnockbackResistance() {
            return 0;
        }

        public static final Material INSTANCE = new Material();
	}

	public WendigoSkullItem(Properties builderIn) {
        super(Material.INSTANCE, EquipmentSlotType.HEAD, builderIn);
    }
	
	WendigoSkullModel model = null;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@OnlyIn(Dist.CLIENT)
	@Override
	public WendigoSkullModel getArmorModel(LivingEntity entity, ItemStack stack, EquipmentSlotType slot,
			BipedModel defaultModel) {
		if (model == null)
			model = new WendigoSkullModel();
		return model;
	}

	@OnlyIn(Dist.CLIENT)
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
		return ForgottenCreatures.MODID + ":textures/entities/armor/skull.png";
	}
}
