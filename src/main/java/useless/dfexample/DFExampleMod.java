package useless.dfexample;

import net.fabricmc.api.ModInitializer;
import net.minecraft.client.render.block.color.BlockColorWater;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.material.Material;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import turniplabs.halplibe.helper.BlockBuilder;
import turniplabs.halplibe.helper.EntityHelper;
import useless.dfexample.entity.EntityTest;
import useless.dfexample.entity.EntityTestModel;
import useless.dfexample.entity.RenderTest;
import useless.dragonfly.debug.block.BlockModel;
import useless.dragonfly.helper.ModelHelper;
import useless.dragonfly.model.block.BlockModelDragonFly;


public class DFExampleMod implements ModInitializer {
    public static final String MOD_ID = "dfexample";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static final Block testBlock = new BlockBuilder(MOD_ID)
		.setBlockModel(new BlockModelDragonFly(ModelHelper.getOrCreateBlockModel(MOD_ID, "block/TestBlock.json")))
		.build(new BlockModel("testblock", 1000, Material.dirt, ModelHelper.getOrCreateBlockModel(MOD_ID, "block/TestBlock.json")));
	public static final Block testBlock2 = new BlockBuilder(MOD_ID)
		.setBlockModel(new BlockModelDragonFly(ModelHelper.getOrCreateBlockModel(MOD_ID, "block/TestBlock2.json")))
		.build(new BlockModel("testblock2", 1001, Material.dirt, ModelHelper.getOrCreateBlockModel(MOD_ID, "block/TestBlock2.json")));
	public static final Block testBlock3 = new BlockBuilder(MOD_ID)
		.setBlockModel(new BlockModelDragonFly(ModelHelper.getOrCreateBlockModel(MOD_ID, "block/TestBlock3.json")))
		.build(new BlockModel("testblock3", 1002, Material.dirt, ModelHelper.getOrCreateBlockModel(MOD_ID, "block/TestBlock3.json")));
	public static final Block modernDragonEgg = new BlockBuilder(MOD_ID)
		.setBlockModel(new BlockModelDragonFly(ModelHelper.getOrCreateBlockModel(MOD_ID, "block/dragon_egg.json")))
		.build(new BlockModel("exampleDragon", 1003, Material.dirt, ModelHelper.getOrCreateBlockModel(MOD_ID, "block/dragon_egg.json")));
	public static final Block modernBeacon = new BlockBuilder(MOD_ID)
		.setBlockModel(new BlockModelDragonFly(ModelHelper.getOrCreateBlockModel(MOD_ID, "block/beacon.json")))
		.build(new BlockModel("exampleBeacon", 1004, Material.dirt, ModelHelper.getOrCreateBlockModel(MOD_ID, "block/beacon.json")));
	public static final Block sideTest = new BlockBuilder(MOD_ID)
		.setBlockModel(new BlockModelDragonFly(ModelHelper.getOrCreateBlockModel(MOD_ID, "block/directionPyramid.json")))
		.build(new BlockModel("exampleSides", 1005, Material.dirt, ModelHelper.getOrCreateBlockModel(MOD_ID, "block/directionPyramid.json")));
	public static final Block btaStool = new BlockBuilder(MOD_ID)
		.setBlockModel(new BlockModelDragonFly(ModelHelper.getOrCreateBlockModel(MOD_ID, "block/stool.json")))
		.build(new BlockModel("exampleStool", 1006, Material.dirt, ModelHelper.getOrCreateBlockModel(MOD_ID, "block/stool.json")));
	public static final Block cauldron = new BlockBuilder(MOD_ID)
		.setBlockModel(new BlockModelDragonFly(ModelHelper.getOrCreateBlockModel(MOD_ID, "block/water_cauldron_full.json")))
		.setBlockColor(new BlockColorWater())
		.build(new BlockModel("exampleCauldron", 1007, Material.metal, ModelHelper.getOrCreateBlockModel(MOD_ID, "block/water_cauldron_full.json")));
    @Override
    public void onInitialize() {
        LOGGER.info("DFExampleMod initialized.");
		//TEST Entity
		EntityHelper.createEntity(EntityTest.class, new RenderTest(ModelHelper.getOrCreateEntityModel(MOD_ID, "entity/test.json", EntityTestModel.class), 0.5F), 2000, "test");
    }
}
