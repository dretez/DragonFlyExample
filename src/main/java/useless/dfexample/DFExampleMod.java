package useless.dfexample;

import net.minecraft.client.render.block.color.BlockColorWater;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockStairs;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.block.tag.BlockTags;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import turniplabs.halplibe.helper.BlockBuilder;
import turniplabs.halplibe.helper.EntityHelper;
import turniplabs.halplibe.util.ClientStartEntrypoint;
import turniplabs.halplibe.util.GameStartEntrypoint;
import useless.dfexample.block.BlockBookshelf;
import useless.dfexample.block.BlockModel;
import useless.dfexample.block.metastates.BookshelfMetaState;
import useless.dfexample.block.metastates.BrewingMetaState;
import useless.dfexample.block.metastates.FenceMetaState;
import useless.dfexample.block.metastates.StairsMetaStateInterpreter;
import useless.dfexample.entity.EntityTest;
import useless.dfexample.entity.EntityTestModel;
import useless.dfexample.entity.RenderTest;
import useless.dfexample.testentity.Warden.EntityWarden;
import useless.dfexample.testentity.Warden.WardenModel;
import useless.dfexample.testentity.Warden.WardenRenderer;
import useless.dragonfly.helper.ModelHelper;
import useless.dragonfly.model.block.BlockModelDragonFly;


public class DFExampleMod implements ClientStartEntrypoint, GameStartEntrypoint {
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
	public static final Block stairs = new BlockBuilder(MOD_ID)
		.setBlockModel(new BlockModelDragonFly(ModelHelper.getOrCreateBlockModel(MOD_ID, "block/stairs.json"),
			ModelHelper.getOrCreateBlockState(MOD_ID, "test_stairs.json"), new StairsMetaStateInterpreter(), true))
		.build(new BlockStairs(Block.dirt,1008)).withLitInteriorSurface(true);
	public static final Block brewing = new BlockBuilder(MOD_ID)
		.setBlockModel(new BlockModelDragonFly(ModelHelper.getOrCreateBlockModel(MOD_ID, "block/brewing/brewing_stand.json"),
			ModelHelper.getOrCreateBlockState(MOD_ID, "brewing_stand.json"), new BrewingMetaState(), true))
		.build(new BlockModel("exampleBrewingStand", 1009, Material.dirt, ModelHelper.getOrCreateBlockModel(MOD_ID, "block/brewing/brewing_stand.json")));
	public static final Block fence = new BlockBuilder(MOD_ID)
		.setBlockModel(new BlockModelDragonFly(ModelHelper.getOrCreateBlockModel(MOD_ID, "block/fence/birch_fence_inventory.json"),
			ModelHelper.getOrCreateBlockState(MOD_ID, "test_fence.json"), new FenceMetaState(), true))
		.build(new BlockModel("exampleFence", 1010, Material.dirt, ModelHelper.getOrCreateBlockModel(MOD_ID, "block/fence/birch_fence_inventory.json"))).withTags(BlockTags.FENCES_CONNECT);
	public static final Block bookshelf = new BlockBuilder(MOD_ID)
		.setBlockModel(new BlockModelDragonFly(ModelHelper.getOrCreateBlockModel(MOD_ID, "block/bookshelf/chiseled_bookshelf_inventory.json"),
			ModelHelper.getOrCreateBlockState(MOD_ID, "chiseled_bookshelf.json"), new BookshelfMetaState(), true))
		.build(new BlockBookshelf("exampleBookshelf", 1011, Material.dirt));

	@Override
	public void beforeClientStart() {
		//TEST Entity
		EntityHelper.Client.assignEntityRenderer(EntityTest.class, new RenderTest(ModelHelper.getOrCreateEntityModel(MOD_ID, "entity/test.json", EntityTestModel.class), 0.5F));
		EntityHelper.Client.assignEntityRenderer(EntityWarden.class, new WardenRenderer(ModelHelper.getOrCreateEntityModel(MOD_ID, "entity/warden.json", WardenModel.class), 0.5f));
	}

	@Override
	public void afterClientStart() {

	}

	@Override
	public void beforeGameStart() {
		//TEST Entity
		EntityHelper.Core.createEntity(EntityTest.class, 2000, "test");
		EntityHelper.Core.createEntity(EntityWarden.class, 1002, "warden");
		LOGGER.info("DFExampleMod initialized.");
	}

	@Override
	public void afterGameStart() {

	}
}
