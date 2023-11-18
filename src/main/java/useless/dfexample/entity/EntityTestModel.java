package useless.dfexample.entity;

import net.minecraft.core.util.helper.MathHelper;
import useless.dragonfly.model.entity.BenchEntityModel;

public class EntityTestModel extends BenchEntityModel {
	public void setRotationAngles(float limbSwing, float limbYaw, float ticksExisted, float headYaw, float headPitch, float scale) {
		super.setRotationAngles(limbSwing, limbYaw, ticksExisted, headYaw, headPitch, scale);
		if (this.getIndexBones().containsKey("Head")) {
			this.getIndexBones().get("Head")
				.setRotationAngle((float)Math.toRadians((double)headPitch), (float)Math.toRadians((double)headYaw), 0.0F);
		}

		if (this.getIndexBones().containsKey("bone")) {
			this.getIndexBones().get("bone").setRotationAngle(0.0F, ticksExisted, 0.0F);
		}

		if (this.getIndexBones().containsKey("RightArm")) {
			this.getIndexBones().get("RightArm")
				.setRotationAngle(MathHelper.cos(limbSwing * 0.6666667F + (float) Math.PI) * 2.0F * limbYaw * 0.5F, 0.0F, 0.0F);
		}

		if (this.getIndexBones().containsKey("LeftArm")) {
			this.getIndexBones().get("LeftArm")
				.setRotationAngle(MathHelper.cos(limbSwing * 0.6666667F) * 2.0F * limbYaw * 0.5F, 0.0F, 0.0F);
		}

		if (this.getIndexBones().containsKey("RightLeg")) {
			this.getIndexBones().get("RightLeg").setRotationAngle(MathHelper.cos(limbSwing * 0.6666667F) * 1.4F * limbYaw, 0.0F, 0.0F);
		}

		if (this.getIndexBones().containsKey("LeftLeg")) {
			this.getIndexBones().get("LeftLeg")
				.setRotationAngle(MathHelper.cos(limbSwing * 0.6666667F + (float) Math.PI) * 1.4F * limbYaw, 0.0F, 0.0F);
		}
	}
}
