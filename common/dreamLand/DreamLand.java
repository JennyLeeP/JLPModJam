package dreamLand;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.DimensionManager;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import dreamLand.blocks.BlockDreamLand;
import dreamLand.blocks.BlockPortalDreamLand;
import dreamLand.world.BiomeGenDreamLand;
import dreamLand.world.DreamLandWorldProvider;

@Mod(modid = DreamLand.modid, name = "DreamLand", version = DreamLand.VERSION)
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class DreamLand {

	public static final String VERSION = "1.0";
	public static final String modid = "DreamLand";
	
	@Instance("DreamLand")
	public static DreamLand instance;

	@SidedProxy(clientSide = "dreamLand.ClientProxy", serverSide = "dreamLand.CommonProxy")
	public static CommonProxy proxy;
	
	public static Block portalObsidian;
	public static Block dreamStone;
	public static Block dreamQuartz;
	public static Block dreamDirt;
	
	public static BlockPortalDreamLand portal;
	public static Item itemlighter;
	
	public static int dimensionID = 21;
	public static BiomeGenBase dreamIsland;
	
	static boolean enableDreamDimension;

	


	@PreInit
	public void preInit(FMLPreInitializationEvent evt) {
		Configuration config = new Configuration(
				evt.getSuggestedConfigurationFile());
		config.load();
		// General
		enableDreamDimension = config.get("general", "enableDreamDimension", true).getBoolean(true);	
		
		int itemLighterId = config.getItem("itemLighter", 32278).getInt(32278);
		int DreamLandPortalID = config.getBlock("blockPortal", 4000).getInt(4000);
		int PortalObsidianID = config.getBlock("portalObsidian", 4001).getInt(4001);
		int DreamStoneID = config.getBlock("dreamStone", 4002).getInt(4002);
		int DreamQuartzID = config.getBlock("dreamQuartz", 4003).getInt(4003);
		int DreamDirtID = config.getBlock("dreamDirt", 4004).getInt(4004);
		config.save();
		
		portal = (BlockPortalDreamLand) new BlockPortalDreamLand(DreamLandPortalID).setUnlocalizedName("portal");
		
		portalObsidian = new BlockDreamLand(PortalObsidianID).setUnlocalizedName("portalObsidian").setHardness(2.0F);
		dreamStone = new BlockDreamLand(DreamStoneID).setUnlocalizedName("dreamStone").setUnlocalizedName("dreamStone").setHardness(2.0F);
		dreamQuartz = new BlockDreamLand(DreamQuartzID).setUnlocalizedName("dreamQuartz").setUnlocalizedName("dreamQuartz").setHardness(2.0F);
		dreamDirt = new BlockDreamLand(DreamDirtID).setUnlocalizedName("dreamDirt").setUnlocalizedName("dreamDirt").setHardness(2.0F);
		itemlighter = new ItemLighter(itemLighterId - 256).setUnlocalizedName("itemLighter");
		
		dreamIsland = (new BiomeGenDreamLand(100)).setBiomeName("DreamLand").setTemperatureRainfall(2.0F, 0.0F);
	}
	

	@Init
	public void init(FMLInitializationEvent evt) {
		
		GameRegistry.registerBlock(portalObsidian, "Obsidiatal");
		GameRegistry.registerBlock(portal, "DreamLand_Portal");
		GameRegistry.registerBlock(dreamStone, "Dream_Stone");
		GameRegistry.registerBlock(dreamQuartz, "Dream_Quartz");
		GameRegistry.registerBlock(dreamDirt, "Dream_Dirt");
		
		GameRegistry.registerItem(itemlighter, "Boom Stick");
		
		
		LanguageRegistry.addName(portal, "Portal");
		LanguageRegistry.addName(portalObsidian, "ShadowStone");
		LanguageRegistry.addName(dreamStone, "SoldjerStone");
		LanguageRegistry.addName(dreamQuartz, "Surrealite");
		LanguageRegistry.addName(dreamDirt, "Chaotic Earth");
		
		LanguageRegistry.addName(itemlighter, "Boom Stick");

		GameRegistry.addRecipe(new ItemStack(portalObsidian), new Object[] {"XXX", "XOX", "XXX", 'X', Block.obsidian, 'O', Block.blockDiamond});
		GameRegistry.addRecipe(new ItemStack(itemlighter), new Object[] {"  X", " X ", "X  ", 'X', Item.emerald });
		
		DimensionManager.registerProviderType(DreamLand.dimensionID, DreamLandWorldProvider.class, true);
		DimensionManager.registerDimension(DreamLand.dimensionID, DreamLand.dimensionID);
		
		
	}

	@PostInit
	public void postInit(FMLPostInitializationEvent evt) {
		//TODO stuff

	}
}
