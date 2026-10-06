package com.example.powerarmor;

import net.fabricmc.fabric.api.client.rendering.v1.ArmorRenderer;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class SuitArmorRenderer implements ArmorRenderer {
    private final Identifier outerTexture;
    private final Identifier innerTexture;
    private BipedEntityModel<LivingEntity> outer;
    private BipedEntityModel<LivingEntity> inner;

    public SuitArmorRenderer(Identifier outerTexture, Identifier innerTexture) {
        this.outerTexture = outerTexture;
        this.innerTexture = innerTexture;
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumerProvider vertexConsumers, ItemStack stack,
                       LivingEntity entity, EquipmentSlot slot, int light,
                       BipedEntityModel<LivingEntity> contextModel) {
        if (outer == null) {
            var loader = MinecraftClient.getInstance().getEntityModelLoader();
            outer = new BipedEntityModel<>(loader.getModelPart(PowerArmorClient.OUTER));
            inner = new BipedEntityModel<>(loader.getModelPart(PowerArmorClient.INNER));
        }

        boolean legs = slot == EquipmentSlot.LEGS;
        BipedEntityModel<LivingEntity> model = legs ? inner : outer;
        Identifier texture = legs ? innerTexture : outerTexture;

        contextModel.copyBipedStateTo(model);
        model.setVisible(false);
        switch (slot) {
            case HEAD -> model.head.visible = true;
            case CHEST -> {
                model.body.visible = true;
                model.rightArm.visible = true;
                model.leftArm.visible = true;
            }
            case LEGS, FEET -> {
                model.rightLeg.visible = true;
                model.leftLeg.visible = true;
            }
            default -> { }
        }

        VertexConsumer consumer = ItemRenderer.getArmorGlintConsumer(
                vertexConsumers, RenderLayer.getArmorCutoutNoCull(texture), stack.hasGlint());
        model.render(matrices, consumer, light, OverlayTexture.DEFAULT_UV, -1);
    }
}
