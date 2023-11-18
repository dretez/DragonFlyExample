package useless.dfexample.entity;

import net.minecraft.client.render.entity.LivingRenderer;
import net.minecraft.client.render.model.ModelBase;

public class RenderTest extends LivingRenderer<EntityTest> {
	public RenderTest(ModelBase modelbase, float shadowSize) {
		super(modelbase, shadowSize);
	}
}
