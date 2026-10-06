package com.example.powerarmor;

import net.minecraft.client.model.Dilation;
import net.minecraft.client.model.ModelData;
import net.minecraft.client.model.ModelPartBuilder;
import net.minecraft.client.model.ModelTransform;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.entity.model.BipedEntityModel;

/** Sculpted 3D armor models. GENERATED layout: extra cuboids are added on top of the normal biped armor shape. */
public class SuitModels {

    public static TexturedModelData outer() {
        ModelData data = BipedEntityModel.getModelData(new Dilation(1.0f), 0.0f);
        data.getRoot().getChild("head").addChild("crest", ModelPartBuilder.create().uv(64, 0).cuboid(-1.0f, -10.0f, -4.0f, 2.0f, 3.0f, 8.0f), ModelTransform.NONE);
        data.getRoot().getChild("head").addChild("chin", ModelPartBuilder.create().uv(85, 0).cuboid(-3.0f, -2.0f, -6.0f, 6.0f, 2.0f, 1.0f), ModelTransform.NONE);
        data.getRoot().getChild("head").addChild("cheek_r", ModelPartBuilder.create().uv(100, 0).cuboid(-6.0f, -6.0f, -2.0f, 1.0f, 4.0f, 4.0f), ModelTransform.NONE);
        data.getRoot().getChild("head").addChild("cheek_l", ModelPartBuilder.create().uv(111, 0).cuboid(5.0f, -6.0f, -2.0f, 1.0f, 4.0f, 4.0f), ModelTransform.NONE);
        data.getRoot().getChild("body").addChild("reactor", ModelPartBuilder.create().uv(64, 12).cuboid(-2.0f, 2.0f, -4.0f, 4.0f, 3.0f, 1.0f), ModelTransform.NONE);
        data.getRoot().getChild("body").addChild("pec_r", ModelPartBuilder.create().uv(75, 12).cuboid(-4.0f, 1.0f, -4.0f, 3.0f, 3.0f, 1.0f), ModelTransform.NONE);
        data.getRoot().getChild("body").addChild("pec_l", ModelPartBuilder.create().uv(84, 12).cuboid(1.0f, 1.0f, -4.0f, 3.0f, 3.0f, 1.0f), ModelTransform.NONE);
        data.getRoot().getChild("body").addChild("back_unit", ModelPartBuilder.create().uv(93, 12).cuboid(-3.0f, 1.0f, 3.0f, 6.0f, 6.0f, 3.0f), ModelTransform.NONE);
        data.getRoot().getChild("right_arm").addChild("pauldron", ModelPartBuilder.create().uv(64, 22).cuboid(-5.0f, -4.0f, -3.0f, 5.0f, 2.0f, 6.0f), ModelTransform.NONE);
        data.getRoot().getChild("left_arm").addChild("pauldron", ModelPartBuilder.create().uv(87, 22).cuboid(-1.0f, -4.0f, -3.0f, 5.0f, 2.0f, 6.0f), ModelTransform.NONE);
        data.getRoot().getChild("right_arm").addChild("cuff", ModelPartBuilder.create().uv(64, 31).cuboid(-4.0f, 6.0f, -3.0f, 6.0f, 3.0f, 6.0f), ModelTransform.NONE);
        data.getRoot().getChild("left_arm").addChild("cuff", ModelPartBuilder.create().uv(89, 31).cuboid(-2.0f, 6.0f, -3.0f, 6.0f, 3.0f, 6.0f), ModelTransform.NONE);
        data.getRoot().getChild("right_arm").addChild("emitter", ModelPartBuilder.create().uv(64, 41).cuboid(-3.0f, 11.0f, -2.0f, 4.0f, 1.0f, 4.0f), ModelTransform.NONE);
        data.getRoot().getChild("left_arm").addChild("emitter", ModelPartBuilder.create().uv(81, 41).cuboid(-1.0f, 11.0f, -2.0f, 4.0f, 1.0f, 4.0f), ModelTransform.NONE);
        data.getRoot().getChild("right_leg").addChild("boot_cuff", ModelPartBuilder.create().uv(98, 41).cuboid(-3.5f, 8.0f, -3.5f, 7.0f, 2.0f, 7.0f), ModelTransform.NONE);
        data.getRoot().getChild("left_leg").addChild("boot_cuff", ModelPartBuilder.create().uv(64, 51).cuboid(-3.5f, 8.0f, -3.5f, 7.0f, 2.0f, 7.0f), ModelTransform.NONE);
        data.getRoot().getChild("right_leg").addChild("boot_toe", ModelPartBuilder.create().uv(93, 51).cuboid(-3.0f, 11.0f, -5.0f, 6.0f, 2.0f, 2.0f), ModelTransform.NONE);
        data.getRoot().getChild("left_leg").addChild("boot_toe", ModelPartBuilder.create().uv(110, 51).cuboid(-3.0f, 11.0f, -5.0f, 6.0f, 2.0f, 2.0f), ModelTransform.NONE);
        return TexturedModelData.of(data, 128, 128);
    }

    public static TexturedModelData inner() {
        ModelData data = BipedEntityModel.getModelData(new Dilation(0.5f), 0.0f);
        data.getRoot().getChild("right_leg").addChild("hip", ModelPartBuilder.create().uv(64, 0).cuboid(-3.0f, -2.0f, -3.0f, 6.0f, 3.0f, 6.0f), ModelTransform.NONE);
        data.getRoot().getChild("left_leg").addChild("hip", ModelPartBuilder.create().uv(89, 0).cuboid(-3.0f, -2.0f, -3.0f, 6.0f, 3.0f, 6.0f), ModelTransform.NONE);
        data.getRoot().getChild("right_leg").addChild("knee", ModelPartBuilder.create().uv(114, 0).cuboid(-2.5f, 4.0f, -3.5f, 5.0f, 3.0f, 1.0f), ModelTransform.NONE);
        data.getRoot().getChild("left_leg").addChild("knee", ModelPartBuilder.create().uv(64, 10).cuboid(-2.5f, 4.0f, -3.5f, 5.0f, 3.0f, 1.0f), ModelTransform.NONE);
        return TexturedModelData.of(data, 128, 128);
    }
}
