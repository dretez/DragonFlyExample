package useless.dfexample;

import net.fabricmc.api.ModInitializer;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.material.Material;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import turniplabs.halplibe.helper.BlockBuilder;
import turniplabs.halplibe.helper.EntityHelper;
import useless.dfexample.entity.EntityTest;
import useless.dfexample.entity.EntityTestModel;
import useless.dfexample.entity.RenderTest;
import useless.dragonfly.block.BlockModel;
import useless.dragonfly.helper.ModelHelper;
import useless.dragonfly.model.block.BlockModelDragonFly;


public class DFExampleMod implements ModInitializer {
    public static final String MOD_ID = "dfexample";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static final Block testBlock = new BlockBuilder(MOD_ID)
		.setBlockModel(new BlockModelDragonFly(ModelHelper.getOrCreateBlockModel(MOD_ID, "TestBlock.json")))
		.setTextures(3,1)
		.build(new BlockModel("testblock", 1000, Material.dirt, ModelHelper.getOrCreateBlockModel(MOD_ID, "TestBlock.json")));
	public static final Block testBlock2 = new BlockBuilder(MOD_ID)
		.setBlockModel(new BlockModelDragonFly(ModelHelper.getOrCreateBlockModel(MOD_ID, "TestBlock2.json")))
		.setTextures(13,13)
		.build(new BlockModel("testblock2", 1001, Material.dirt, ModelHelper.getOrCreateBlockModel(MOD_ID, "TestBlock2.json")));
	public static final Block testBlock3 = new BlockBuilder(MOD_ID)
		.setBlockModel(new BlockModelDragonFly(ModelHelper.getOrCreateBlockModel(MOD_ID, "TestBlock3.json")))
		.setTextures(4,0)
		.build(new BlockModel("testblock3", 1002, Material.dirt, ModelHelper.getOrCreateBlockModel(MOD_ID, "TestBlock3.json")));
	public static final Block testBlock4 = new BlockBuilder(MOD_ID)
		.setBlockModel(new BlockModelDragonFly(ModelHelper.getOrCreateBlockModel(MOD_ID, "dragon_egg.json")))
		.setTextures(5,2)
		.build(new BlockModel("testblock4", 1003, Material.dirt, ModelHelper.getOrCreateBlockModel(MOD_ID, "dragon_egg.json")));
	public static final Block testBlock5 = new BlockBuilder(MOD_ID)
		.setBlockModel(new BlockModelDragonFly(ModelHelper.getOrCreateBlockModel(MOD_ID, "beacon.json")))
		.setTextures(1,3)
		.build(new BlockModel("testblock5", 1004, Material.dirt, ModelHelper.getOrCreateBlockModel(MOD_ID, "beacon.json")));
	public static final Block testBlock6 = new BlockBuilder(MOD_ID)
		.setBlockModel(new BlockModelDragonFly(ModelHelper.getOrCreateBlockModel(MOD_ID, "directionPyramid.json")))
		.setTextures(1,3)
		.build(new BlockModel("testblock6", 1005, Material.dirt, ModelHelper.getOrCreateBlockModel(MOD_ID, "directionPyramid.json")));
	public static final Block testBlock7 = new BlockBuilder(MOD_ID)
		.setBlockModel(new BlockModelDragonFly(ModelHelper.getOrCreateBlockModel(MOD_ID, "stool.json")))
		.setTextures(1,3)
		.build(new BlockModel("testblock7", 1006, Material.dirt, ModelHelper.getOrCreateBlockModel(MOD_ID, "stool.json")));

    @Override
    public void onInitialize() {
        LOGGER.info("DFExampleMod initialized.");
		//TEST Entity
		EntityHelper.createEntity(EntityTest.class, new RenderTest(ModelHelper.getOrCreateEntityModel(MOD_ID, "entity/test.json", EntityTestModel.class), 0.5F), 2000, "test");
    }
}
