package com.example.powerarmor;

import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvents;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Suit {
    public final String name;
    public final RegistryEntry<ArmorMaterial> material;
    private final int durabilityMultiplier;

    public Suit(String name, int boots, int chest, int legs, int helmet, int unused,
                float toughness, float knockbackResistance, int durabilityMultiplier) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;

        Map<ArmorItem.Type, Integer> defense = new EnumMap<>(ArmorItem.Type.class);
        defense.put(ArmorItem.Type.BOOTS, boots);
        defense.put(ArmorItem.Type.LEGGINGS, legs);
        defense.put(ArmorItem.Type.CHESTPLATE, chest);
        defense.put(ArmorItem.Type.HELMET, helmet);
        defense.put(ArmorItem.Type.BODY, chest);

        ArmorMaterial armorMaterial = new ArmorMaterial(
                defense,
                15,
                SoundEvents.ITEM_ARMOR_EQUIP_IRON,
                () -> Ingredient.ofItems(net.minecraft.item.Items.IRON_INGOT),
                List.of(new ArmorMaterial.Layer(PowerArmor.id(name))),
                toughness,
                knockbackResistance);

        this.material = Registry.registerReference(Registries.ARMOR_MATERIAL, PowerArmor.id(name), armorMaterial);
    }

    public void registerItems() {
        register("helmet", ArmorItem.Type.HELMET);
        register("chestplate", ArmorItem.Type.CHESTPLATE);
        register("leggings", ArmorItem.Type.LEGGINGS);
        register("boots", ArmorItem.Type.BOOTS);
    }

    private void register(String piece, ArmorItem.Type type) {
        Item item = Registry.register(
                Registries.ITEM,
                PowerArmor.id(name + "_" + piece),
                new ArmorItem(material, type,
                        new Item.Settings().maxDamage(type.getMaxDamage(durabilityMultiplier))));
        PowerArmor.ALL_ITEMS.add(item);
    }
}
