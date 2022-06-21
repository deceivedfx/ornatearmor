package net.deceivedfx.ornatearmor.registry;

/* @author deceivedfx
 * 6/21/2022
 * ornatearmor
 */

import io.wispforest.owo.registration.reflect.ItemRegistryContainer;
import net.deceivedfx.ornatearmor.OrnateArmorMod;
import net.deceivedfx.ornatearmor.item.OrnateArmorItem;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterials;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class OrnateItems implements ItemRegistryContainer {

    public static final ItemGroup ORNATEARMOR = FabricItemGroupBuilder.build(new Identifier(OrnateArmorMod.MOD_ID, "ornatearmor"),
            () -> new ItemStack(OrnateItems.DIAMOND_SCRAP));

    // Ingredients

    // Items
    public static final Item GILDED_INGOT = new Item(new Item.Settings().fireproof().group(ORNATEARMOR));
    public static final Item DIAMOND_SCRAP = new Item(new Item.Settings().group(ORNATEARMOR));

    // Armor
    public static final Item GILDED_HELMET = new OrnateArmorItem(ArmorMaterials.NETHERITE, EquipmentSlot.HEAD, new Item.Settings().fireproof().group(ORNATEARMOR).rarity(Rarity.RARE));
    public static final Item GILDED_CHESTPLATE = new OrnateArmorItem(ArmorMaterials.NETHERITE, EquipmentSlot.CHEST, new Item.Settings().fireproof().group(ORNATEARMOR).rarity(Rarity.RARE));
    public static final Item GILDED_LEGGINGS = new OrnateArmorItem(ArmorMaterials.NETHERITE, EquipmentSlot.LEGS, new Item.Settings().fireproof().group(ORNATEARMOR).rarity(Rarity.RARE));
    public static final Item GILDED_BOOTS = new OrnateArmorItem(ArmorMaterials.NETHERITE, EquipmentSlot.FEET, new Item.Settings().fireproof().group(ORNATEARMOR).rarity(Rarity.RARE));
}
