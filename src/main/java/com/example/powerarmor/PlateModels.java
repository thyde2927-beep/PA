package com.example.powerarmor;

import net.minecraft.client.model.ModelData;
import net.minecraft.client.model.ModelPartBuilder;
import net.minecraft.client.model.ModelPartData;
import net.minecraft.client.model.ModelTransform;
import net.minecraft.client.model.TexturedModelData;

/** GENERATED: 3D armor plates for each suit. */
public class PlateModels {
    public static TexturedModelData create(int suitIndex) {
        return switch (suitIndex) {
            case 0 -> mark1();
            case 1 -> mark2();
            default -> mark3();
        };
    }

    private static TexturedModelData mark1() {
        ModelData data = new ModelData();
        ModelPartData root = data.getRoot();
        root.addChild("helmet_extra", ModelPartBuilder.create()
                .uv(0, 0).cuboid(-0.5f, -10f, -4.5f, 1f, 2f, 9f)
                .uv(20, 0).cuboid(-5.7f, -6f, -2.5f, 1f, 4f, 5f)
                .uv(32, 0).cuboid(4.7f, -6f, -2.5f, 1f, 4f, 5f)
                .uv(44, 0).cuboid(-3f, -7.5f, -5.7f, 6f, 5f, 1f)
                .uv(0, 11).cuboid(-2.5f, -6.5f, -6.0f, 5f, 1f, 1f),
                ModelTransform.pivot(0.0f, 0.0f, 0.0f));
        root.addChild("chest_extra", ModelPartBuilder.create()
                .uv(12, 11).cuboid(-3f, 1.5f, -4.0f, 6f, 6f, 1f)
                .uv(26, 11).cuboid(-1.5f, 3f, -4.4f, 3f, 3f, 1f)
                .uv(34, 11).cuboid(-3f, 1f, 3f, 6f, 8f, 2f),
                ModelTransform.pivot(0.0f, 0.0f, 0.0f));
        root.addChild("shoulder_r", ModelPartBuilder.create()
                .uv(0, 21).cuboid(-5.5f, -4f, -3.5f, 5f, 2f, 7f)
                .uv(24, 21).cuboid(-5.5f, -2f, -3.5f, 5f, 1f, 7f),
                ModelTransform.pivot(0.0f, 0.0f, 0.0f));
        root.addChild("shoulder_l", ModelPartBuilder.create()
                .uv(0, 30).cuboid(0.5f, -4f, -3.5f, 5f, 2f, 7f)
                .uv(24, 30).cuboid(0.5f, -2f, -3.5f, 5f, 1f, 7f),
                ModelTransform.pivot(0.0f, 0.0f, 0.0f));
        root.addChild("thigh_extra", ModelPartBuilder.create()
                .uv(48, 30).cuboid(-2.5f, 0.5f, -3.2f, 5f, 5f, 1f)
                .uv(0, 39).cuboid(-2f, 5.5f, -3.6f, 4f, 2f, 1f),
                ModelTransform.pivot(0.0f, 0.0f, 0.0f));
        root.addChild("boot_extra", ModelPartBuilder.create()
                .uv(10, 39).cuboid(-2.5f, 9.5f, -4.5f, 5f, 3f, 2f)
                .uv(24, 39).cuboid(-1f, 10f, 3f, 2f, 2f, 1f),
                ModelTransform.pivot(0.0f, 0.0f, 0.0f));
        return TexturedModelData.of(data, 64, 64);
    }

    private static TexturedModelData mark2() {
        ModelData data = new ModelData();
        ModelPartData root = data.getRoot();
        root.addChild("helmet_extra", ModelPartBuilder.create()
                .uv(0, 0).cuboid(-0.5f, -11f, -4.5f, 1f, 3f, 9f)
                .uv(20, 0).cuboid(-5.7f, -6f, -2.5f, 1f, 4f, 5f)
                .uv(32, 0).cuboid(4.7f, -6f, -2.5f, 1f, 4f, 5f)
                .uv(44, 0).cuboid(-3f, -7.5f, -5.7f, 6f, 5f, 1f)
                .uv(0, 12).cuboid(-2.5f, -6.5f, -6.0f, 5f, 1f, 1f),
                ModelTransform.pivot(0.0f, 0.0f, 0.0f));
        root.addChild("chest_extra", ModelPartBuilder.create()
                .uv(12, 12).cuboid(-3f, 1.5f, -4.0f, 6f, 6f, 1f)
                .uv(26, 12).cuboid(-1.5f, 3f, -4.4f, 3f, 3f, 1f)
                .uv(34, 12).cuboid(-3f, 1f, 3f, 6f, 8f, 3f),
                ModelTransform.pivot(0.0f, 0.0f, 0.0f));
        root.addChild("shoulder_r", ModelPartBuilder.create()
                .uv(0, 23).cuboid(-5.5f, -4f, -3.5f, 5f, 3f, 7f)
                .uv(24, 23).cuboid(-5.5f, -1f, -3.5f, 5f, 1f, 7f)
                .uv(48, 23).cuboid(-3.5f, -6f, -1f, 2f, 2f, 2f),
                ModelTransform.pivot(0.0f, 0.0f, 0.0f));
        root.addChild("shoulder_l", ModelPartBuilder.create()
                .uv(0, 33).cuboid(0.5f, -4f, -3.5f, 5f, 3f, 7f)
                .uv(24, 33).cuboid(0.5f, -1f, -3.5f, 5f, 1f, 7f)
                .uv(48, 33).cuboid(2.5f, -6f, -1f, 2f, 2f, 2f),
                ModelTransform.pivot(0.0f, 0.0f, 0.0f));
        root.addChild("thigh_extra", ModelPartBuilder.create()
                .uv(0, 43).cuboid(-2.5f, 0.5f, -3.2f, 5f, 5f, 1f)
                .uv(12, 43).cuboid(-2f, 5.5f, -3.6f, 4f, 2f, 1f),
                ModelTransform.pivot(0.0f, 0.0f, 0.0f));
        root.addChild("boot_extra", ModelPartBuilder.create()
                .uv(22, 43).cuboid(-2.5f, 9.5f, -4.5f, 5f, 3f, 2f)
                .uv(36, 43).cuboid(-1f, 10f, 3f, 2f, 2f, 1f)
                .uv(42, 43).cuboid(-3.6f, 9f, -1f, 1f, 3f, 3f)
                .uv(50, 43).cuboid(2.6f, 9f, -1f, 1f, 3f, 3f),
                ModelTransform.pivot(0.0f, 0.0f, 0.0f));
        return TexturedModelData.of(data, 64, 64);
    }

    private static TexturedModelData mark3() {
        ModelData data = new ModelData();
        ModelPartData root = data.getRoot();
        root.addChild("helmet_extra", ModelPartBuilder.create()
                .uv(0, 0).cuboid(-0.5f, -12f, -4.5f, 1f, 4f, 9f)
                .uv(20, 0).cuboid(-5.7f, -6f, -2.5f, 1f, 4f, 5f)
                .uv(32, 0).cuboid(4.7f, -6f, -2.5f, 1f, 4f, 5f)
                .uv(44, 0).cuboid(-3f, -7.5f, -5.7f, 6f, 5f, 1f)
                .uv(0, 13).cuboid(-2.5f, -6.5f, -6.0f, 5f, 1f, 1f),
                ModelTransform.pivot(0.0f, 0.0f, 0.0f));
        root.addChild("chest_extra", ModelPartBuilder.create()
                .uv(12, 13).cuboid(-3f, 1.5f, -4.0f, 6f, 6f, 1f)
                .uv(26, 13).cuboid(-1.5f, 3f, -4.4f, 3f, 3f, 1f)
                .uv(34, 13).cuboid(-3f, 1f, 3f, 6f, 8f, 4f),
                ModelTransform.pivot(0.0f, 0.0f, 0.0f));
        root.addChild("shoulder_r", ModelPartBuilder.create()
                .uv(0, 25).cuboid(-5.5f, -4f, -3.5f, 5f, 3f, 7f)
                .uv(24, 25).cuboid(-5.5f, -1f, -3.5f, 5f, 1f, 7f)
                .uv(48, 25).cuboid(-3.5f, -7f, -1f, 2f, 3f, 2f),
                ModelTransform.pivot(0.0f, 0.0f, 0.0f));
        root.addChild("shoulder_l", ModelPartBuilder.create()
                .uv(0, 35).cuboid(0.5f, -4f, -3.5f, 5f, 3f, 7f)
                .uv(24, 35).cuboid(0.5f, -1f, -3.5f, 5f, 1f, 7f)
                .uv(48, 35).cuboid(2.5f, -7f, -1f, 2f, 3f, 2f),
                ModelTransform.pivot(0.0f, 0.0f, 0.0f));
        root.addChild("thigh_extra", ModelPartBuilder.create()
                .uv(0, 45).cuboid(-2.5f, 0.5f, -3.2f, 5f, 5f, 1f)
                .uv(12, 45).cuboid(-2f, 5.5f, -3.6f, 4f, 2f, 1f),
                ModelTransform.pivot(0.0f, 0.0f, 0.0f));
        root.addChild("boot_extra", ModelPartBuilder.create()
                .uv(22, 45).cuboid(-2.5f, 9.5f, -4.5f, 5f, 3f, 2f)
                .uv(36, 45).cuboid(-1f, 10f, 3f, 2f, 2f, 1f)
                .uv(42, 45).cuboid(-3.6f, 9f, -1f, 1f, 3f, 3f)
                .uv(50, 45).cuboid(2.6f, 9f, -1f, 1f, 3f, 3f),
                ModelTransform.pivot(0.0f, 0.0f, 0.0f));
        return TexturedModelData.of(data, 64, 64);
    }

}
