package com.example.powerarmor;

import dev.emi.trinkets.api.TrinketsApi;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class PowerArmor implements ModInitializer {
    public static final String MOD_ID = "powerarmor";

    public static final List<Item> ALL_ITEMS = new ArrayList<>();
    private static final Set<UUID> FLIGHT_GRANTED = new HashSet<>();


    // Suit Cores: equip one in the "Suit Core" inventory slot (Trinkets)
    public static final Item MARK_1_CORE = registerCore("mark1_core");
    public static final Item MARK_2_CORE = registerCore("mark2_core");
    public static final Item MARK_3_CORE = registerCore("mark3_core");

    private static Item registerCore(String name) {
        return Registry.register(Registries.ITEM, Identifier.of(MOD_ID, name),
                new Item(new Item.Settings().maxCount(1)));
    }

    // Three suits
    public static final Suit MARK_1 = new Suit("mark1", 2, 5, 6, 2, 1, 0.0f, 0.0f, 25);
    public static final Suit MARK_2 = new Suit("mark2", 3, 6, 8, 3, 2, 1.0f, 0.0f, 33);
    public static final Suit MARK_3 = new Suit("mark3", 3, 8, 10, 3, 3, 3.0f, 0.1f, 40);

    // Custom creative tab
    public static final ItemGroup POWER_ARMOR_TAB = Registry.register(
            Registries.ITEM_GROUP,
            Identifier.of(MOD_ID, "main"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(Registries.ITEM.get(Identifier.of(MOD_ID, "mark3_chestplate"))))
                    .displayName(Text.translatable("itemGroup.powerarmor.main"))
                    .entries((context, entries) -> ALL_ITEMS.forEach(entries::add))
                    .build());

    @Override
    public void onInitialize() {
        MARK_1.registerItems();
        MARK_2.registerItems();
        MARK_3.registerItems();
        ALL_ITEMS.add(MARK_1_CORE);
        ALL_ITEMS.add(MARK_2_CORE);
        ALL_ITEMS.add(MARK_3_CORE);


        ServerTickEvents.END_SERVER_TICK.register(server -> {
            for (ServerPlayerEntity player : server.getPlayerManager().getPlayerList()) {
                tickPlayer(player, server.getTicks());
            }
        });
    }

    private static void tickPlayer(ServerPlayerEntity player, int serverTicks) {
        RegistryEntry<ArmorMaterial> worn = fullSetMaterial(player);
        boolean canFly = worn != null && (worn.equals(MARK_2.material) || worn.equals(MARK_3.material));

        // Flight
        if (!player.isCreative() && !player.isSpectator()) {
            if (canFly) {
                if (!player.getAbilities().allowFlying) {
                    player.getAbilities().allowFlying = true;
                    player.sendAbilitiesUpdate();
                    FLIGHT_GRANTED.add(player.getUuid());
                }
            } else if (FLIGHT_GRANTED.remove(player.getUuid())) {
                player.getAbilities().allowFlying = false;
                player.getAbilities().flying = false;
                player.sendAbilitiesUpdate();
            }
        }

        // Suit bonuses (refreshed every 10 ticks)
        if (worn != null && serverTicks % 10 == 0) {
            if (worn.equals(MARK_1.material)) {
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 40, 0, true, false));
            } else if (worn.equals(MARK_3.material)) {
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 40, 1, true, false));
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 40, 0, true, false));
            }
        }

        // Suit Core slot effects (refreshed every 10 ticks)
        if (serverTicks % 10 == 0) {
            TrinketsApi.getTrinketComponent(player).ifPresent(trinkets -> {
                if (trinkets.isEquipped(MARK_1_CORE)) {
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 240, 0, true, false));
                }
                if (trinkets.isEquipped(MARK_2_CORE)) {
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.WATER_BREATHING, 40, 0, true, false));
                }
                if (trinkets.isEquipped(MARK_3_CORE)) {
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 60, 0, true, false));
                }
            });
        }
    }

    /** Returns the suit material if all four pieces are from the same suit, otherwise null. */
    private static RegistryEntry<ArmorMaterial> fullSetMaterial(ServerPlayerEntity player) {
        RegistryEntry<ArmorMaterial> found = null;
        EquipmentSlot[] slots = {EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET};
        for (EquipmentSlot slot : slots) {
            ItemStack stack = player.getEquippedStack(slot);
            if (!(stack.getItem() instanceof ArmorItem armor)) return null;
            RegistryEntry<ArmorMaterial> mat = armor.getMaterial();
            if (found == null) found = mat;
            else if (!found.equals(mat)) return null;
        }
        return found;
    }

    static Identifier id(String path) {
        return Identifier.of(MOD_ID, path);
    }
}
