package net.deceivedfx.ornatearmor.item;

/* @author deceivedfx
 * 6/21/2022
 * ornatearmor
 */

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;

import java.util.UUID;

public class OrnateArmorItem extends ArmorItem {

    private final EquipmentSlot slot;
    private static final UUID[] MODIFIERS = new UUID[]{UUID.fromString("845DB27C-C624-495F-8C9F-6020A9A58B6B"), UUID.fromString("D8499B04-0E66-4726-AB29-64469D734E0D"), UUID.fromString("9F3D476D-C118-4544-8365-64846904B48E"), UUID.fromString("2AD3F246-FEE1-4E67-B886-69FD380BB150")};
    private final Multimap<EntityAttribute, EntityAttributeModifier> attributeModifiers;

    public OrnateArmorItem(ArmorMaterial material, EquipmentSlot slot, Settings settings) {
        super(material, slot, settings);
        this.slot = slot;
        ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
        UUID uUID = MODIFIERS[slot.getEntitySlotId()];
        builder.put(EntityAttributes.GENERIC_ARMOR, new EntityAttributeModifier(uUID, "Armor modifier", (double)getProtection(), EntityAttributeModifier.Operation.ADDITION));
        builder.put(EntityAttributes.GENERIC_ARMOR_TOUGHNESS, new EntityAttributeModifier(uUID, "Armor toughness", (double)method_26353(), EntityAttributeModifier.Operation.ADDITION));
        builder.put(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, new EntityAttributeModifier(uUID, "Armor knockback resistance", (double)getKnockbackResistance(), EntityAttributeModifier.Operation.ADDITION));
        this.attributeModifiers = builder.build();
    }

    @Override
    public int getEnchantability() {return OrnateMaterials.GILDED.getEnchantability();}

    @Override
    public ArmorMaterial getMaterial() {return OrnateMaterials.GILDED;}

    // TODO make the armor repairable in the future, for now just decorative
    //public boolean canRepair(ItemStack stack, ItemStack ingredient) {return ((OrnateMaterials) stack.getItem()).getMaterial().getRepairIngredient().test(ingredient);}

    @Override
    public Multimap<EntityAttribute, EntityAttributeModifier> getAttributeModifiers(EquipmentSlot slot) {
        if (slot == this.slot) {return this.attributeModifiers;}
        return ImmutableMultimap.of();
    }

    public int getProtection() {return OrnateMaterials.GILDED.getProtectionAmount(this.slot);}

    public float getKnockbackResistance() {return OrnateMaterials.GILDED.getKnockbackResistance();}

    public float method_26353() {return OrnateMaterials.GILDED.getToughness();}
}
