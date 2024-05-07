package useless.dfexample.entity;

import net.minecraft.core.entity.monster.EntityHuman;
import net.minecraft.core.world.World;

public class EntityTest extends EntityHuman {
	public EntityTest(World world) {
		super(world);
	}
	public String getEntityTexture() {
		return "/assets/dfexample/textures/entity/zombie_test.png";
	}

	public String getDefaultEntityTexture() {
		return "/assets/dfexample/textures/entity/zombie_test.png";
	}

}
