package com.example.powerarmor;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.ArmorRenderer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

public class PowerArmorClient implements ClientModInitializer {
    public static final EntityModelLayer OUTER = new EntityModelLayer(Identifier.of(PowerArmor.MOD_ID, "suit"), "outer");
    public static final EntityModelLayer INNER = new EntityModelLayer(Identifier.of(PowerArmor.MOD_ID, "suit"), "inner");

    @Override
    public void onInitializeClient() {
        EntityModelLayerRegistry.registerModelLayer(OUTER, SuitModels::outer);
        EntityModelLayerRegistry.registerModelLayer(INNER, SuitModels::inner);

        for (String suit : new String[]{"mark1", "mark2", "mark3"}) {
            ArmorRenderer renderer = new SuitArmorRenderer(
                    Identifier.of(PowerArmor.MOD_ID, "textures/armor/" + suit + "_outer.png"),
                    Identifier.of(PowerArmor.MOD_ID, "textures/armor/" + suit + "_inner.png"));
            for (String piece : new String[]{"helmet", "chestplate", "leggings", "boots"}) {
                Item item = Registries.ITEM.get(Identifier.of(PowerArmor.MOD_ID, suit + "_" + piece));
                ArmorRenderer.register(renderer, item);
            }
        }
    }
}
