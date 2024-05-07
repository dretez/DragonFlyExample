package useless.dfexample.entity;

import net.minecraft.core.util.helper.MathHelper;
import org.useless.dragonfly.helper.AnimationHelper;
import org.useless.dragonfly.model.entity.BenchEntityModel;
import org.useless.dragonfly.model.entity.animation.Animation;

import static useless.dfexample.DFExampleMod.MOD_ID;

public class EntityTestModel extends BenchEntityModel {
	public void setRotationAngles(float limbSwing, float limbYaw, float ticksExisted, float headYaw, float headPitch, float scale) {
		// If you need play some animation. you should reset with this
		this.getIndexBones().forEach((s, benchEntityBones) -> benchEntityBones.resetPose());
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

		Animation testAnimation = AnimationHelper.getOrCreateEntityAnimation(MOD_ID, "zombie_test.animation");
		animateWalk(testAnimation.getAnimations().get("test"), limbSwing, limbYaw * 0.5F, 2.0F, 2.5F);
	}
}
