package useless.dfexample;

import net.minecraft.client.render.block.color.BlockColorCustom;
import net.minecraft.client.render.colorizer.Colorizers;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockStairs;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.block.tag.BlockTags;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.useless.dragonfly.helper.ModelHelper;
import org.useless.dragonfly.model.block.DFBlockModelBuilder;
import turniplabs.halplibe.helper.BlockBuilder;
import turniplabs.halplibe.helper.EntityHelper;
import turniplabs.halplibe.util.GameStartEntrypoint;
import useless.dfexample.block.BlockBookshelf;
import useless.dfexample.block.ExampleBlockModel;
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


public class DFExampleMod implements GameStartEntrypoint {
    public static final String MOD_ID = "dfexample";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static final Block testBlock = new BlockBuilder(MOD_ID)
		.setBlockModel(
			block -> new DFBlockModelBuilder(MOD_ID)
				.setBlockModel("block/TestBlock.json")
				.build(block))
		.build(new ExampleBlockModel("testblock", 2000, Material.dirt));
	public static final Block testBlock2 = new BlockBuilder(MOD_ID)
		.setBlockModel(
			block -> new DFBlockModelBuilder(MOD_ID)
				.setBlockModel("block/TestBlock2.json")
				.build(block))
		.build(new ExampleBlockModel("testblock2", 2001, Material.dirt));
	public static final Block testBlock3 = new BlockBuilder(MOD_ID)
		.setBlockModel(
			block -> new DFBlockModelBuilder(MOD_ID)
				.setBlockModel("block/TestBlock3.json")
				.build(block))
		.build(new ExampleBlockModel("testblock3", 2002, Material.dirt));
	public static final Block modernDragonEgg = new BlockBuilder(MOD_ID)
		.setBlockModel(
			block -> new DFBlockModelBuilder(MOD_ID)
				.setBlockModel("block/dragon_egg.json")
				.build(block))
		.build(new ExampleBlockModel("exampleDragon", 2003, Material.dirt));
	public static final Block modernBeacon = new BlockBuilder(MOD_ID)
		.setBlockModel(
			block -> new DFBlockModelBuilder(MOD_ID)
				.setBlockModel("block/beacon.json")
				.build(block))
		.build(new ExampleBlockModel("exampleBeacon", 2004, Material.dirt));
	public static final Block sideTest = new BlockBuilder(MOD_ID)
		.setBlockModel(
			block -> new DFBlockModelBuilder(MOD_ID)
				.setBlockModel("block/directionPyramid.json")
				.build(block))
		.build(new ExampleBlockModel("exampleSides", 2005, Material.dirt));
	public static final Block btaStool = new BlockBuilder(MOD_ID)
		.setBlockModel(
			block -> new DFBlockModelBuilder(MOD_ID)
				.setBlockModel("block/stool.json")
				.build(block))
		.build(new ExampleBlockModel("exampleStool", 2006, Material.dirt));
	public static final Block cauldron = new BlockBuilder(MOD_ID)
		.setBlockModel(
			block -> new DFBlockModelBuilder(MOD_ID)
				.setBlockModel("block/water_cauldron_full.json")
				.build(block))
		.setBlockColor(new BlockColorCustom(Colorizers.water))
		.build(new ExampleBlockModel("exampleCauldron", 2007, Material.metal));
	public static final Block stairs = new BlockBuilder(MOD_ID)
		.setBlockModel(
			block -> new DFBlockModelBuilder(MOD_ID)
				.setBlockModel("block/stairs.json")
				.setBlockState("test_stairs.json")
				.setMetaStateInterpreter(new StairsMetaStateInterpreter())
				.build(block))
		.build(new BlockStairs(Block.dirt,2008)).withLitInteriorSurface(true);
	public static final Block brewing = new BlockBuilder(MOD_ID)
		.setBlockModel(
			block -> new DFBlockModelBuilder(MOD_ID)
				.setBlockModel("block/brewing/brewing_stand.json")
				.setBlockState("brewing_stand.json")
				.setMetaStateInterpreter(new BrewingMetaState())
				.build(block))
		.build(new ExampleBlockModel("exampleBrewingStand", 2009, Material.dirt));
	public static final Block fence = new BlockBuilder(MOD_ID)
		.setBlockModel(
			block -> new DFBlockModelBuilder(MOD_ID)
				.setBlockModel("block/fence/birch_fence_inventory.json")
				.setBlockState("test_fence.json")
				.setMetaStateInterpreter(new FenceMetaState())
				.build(block))
		.build(new ExampleBlockModel("exampleFence", 2010, Material.dirt)).withTags(BlockTags.FENCES_CONNECT);
	public static final Block bookshelf = new BlockBuilder(MOD_ID)
		.setBlockModel(
			block -> new DFBlockModelBuilder(MOD_ID)
				.setBlockModel("block/bookshelf/chiseled_bookshelf_inventory.json")
				.setBlockState("chiseled_bookshelf.json")
				.setMetaStateInterpreter(new BookshelfMetaState())
				.build(block))
		.build(new BlockBookshelf("exampleBookshelf", 2011, Material.dirt));

	@Override
	public void beforeGameStart() {
		//TEST Entity
		EntityHelper.createEntity(EntityTest.class, 2000, "test", () -> new RenderTest(ModelHelper.getOrCreateEntityModel(MOD_ID, "entity/test.json", EntityTestModel.class), 0.5f));
		EntityHelper.createEntity(EntityWarden.class, 1002, "warden", () -> new WardenRenderer(ModelHelper.getOrCreateEntityModel(MOD_ID, "entity/warden.json", WardenModel.class), 0.5f));
		LOGGER.info("DFExampleMod initialized.");
	}

	@Override
	public void afterGameStart() {

	}
}
