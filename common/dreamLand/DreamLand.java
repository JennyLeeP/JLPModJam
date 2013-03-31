package dreamLand;



import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.EnumHelper;
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
	
	static EnumArmorMaterial armorPravlon = EnumHelper.addArmorMaterial("PhantomIron", 29, new int[] { 2, 7, 5, 3 }, 9);
	static EnumToolMaterial toolPhantomIron = EnumHelper.addToolMaterial("PhantomIron",
			3, 2000, 12.0F, 9, 25);
	
	public static Block portalObsidian;
	public static Block dreamStone;
	public static Block dreamQuartz;
	public static Block dreamDirt;
	public static Block dreamSand;
	public static Block oreLucidity;
	public static Block oreStarcesium;
	
	public static BlockPortalDreamLand portal;
	
	public static Item itemlighter;
	public static Item itemLucidity;
	public static Item itemSwordPhantomIron;
	
	public static int dimensionID = 21;
	public static BiomeGenBase dreamIsland;
	
	static boolean enableDreamDimension;

	
	//declare new Creative Tab
	public static CreativeTabs tabDreamLand = new DreamLandTabs(CreativeTabs.getNextID(), "tabDreamLand");

	@PreInit
	public void preInit(FMLPreInitializationEvent evt) {
		Configuration config = new Configuration(
				evt.getSuggestedConfigurationFile());
		config.load();
		// General
		enableDreamDimension = config.get("general", "enableDreamDimension", true).getBoolean(true);	
		
		int itemLighterId = config.getItem("itemLighter", 30000).getInt(30000);
		int swordPhantomId = config.getItem("itemSwordPhantomIron", 30001).getInt(30001);
		int itemLucidityID = config.getItem("itemLucidity", 30002).getInt(30002);
		
		int DreamLandPortalID = config.getBlock("blockPortal", 4000).getInt(4000);
		int PortalObsidianID = config.getBlock("portalObsidian", 4001).getInt(4001);
		int DreamStoneID = config.getBlock("dreamStone", 4002).getInt(4002);
		int DreamQuartzID = config.getBlock("dreamQuartz", 4003).getInt(4003);
		int DreamDirtID = config.getBlock("dreamDirt", 4004).getInt(4004);
		int DreamSandID = config.getBlock("dreamSand", 4005).getInt(4005);
		int OreLucidityID = config.getBlock("oreLucidity", 4006).getInt(4006);
		int OreStarCesiumID = config.getBlock("oreStarcesium", 4007).getInt(4007);
		
		config.save();
		//Blocks
		portal = (BlockPortalDreamLand) new BlockPortalDreamLand(DreamLandPortalID).setUnlocalizedName("portal");
		
		portalObsidian = new BlockDreamLand(PortalObsidianID).setUnlocalizedName("portalObsidian").setHardness(2.0F);
		dreamStone = new BlockDreamLand(DreamStoneID).setUnlocalizedName("dreamStone").setHardness(2.0F);
		dreamQuartz = new BlockDreamLand(DreamQuartzID).setUnlocalizedName("dreamQuartz").setHardness(2.0F);
		dreamDirt = new BlockDreamLand(DreamDirtID).setUnlocalizedName("dreamDirt").setHardness(2.0F);
		dreamSand = new BlockDreamLand(DreamSandID).setUnlocalizedName("dreamSand").setHardness(2.0F);
		oreLucidity = new BlockDreamLand(OreLucidityID, itemLucidityID).setUnlocalizedName("oreLucidity").setHardness(2.0F);
		oreStarcesium = new BlockDreamLand(OreStarCesiumID, Item.netherStar.itemID).setUnlocalizedName("oreStarCesium").setHardness(2.0F);
		
		//Items
		itemlighter = new ItemLighter(itemLighterId - 256).setUnlocalizedName("itemLighter");
		itemSwordPhantomIron = new ItemDreamSword(swordPhantomId - 256, toolPhantomIron).setUnlocalizedName("itemSwordPhantomIron");
		itemLucidity = new DreamLandItems(itemLucidityID - 256).setUnlocalizedName("itemLucidity");
		
		
		dreamIsland = (new BiomeGenDreamLand(100)).setBiomeName("DreamLand");
	}
	

	@Init
	public void init(FMLInitializationEvent evt) {
		
		
		
		
		
		
		GameRegistry.registerBlock(portalObsidian, "Obsidiatal");
		GameRegistry.registerBlock(portal, "DreamLand_Portal");
		GameRegistry.registerBlock(dreamStone, "Dream_Stone");
		GameRegistry.registerBlock(dreamQuartz, "Dream_Quartz");
		GameRegistry.registerBlock(dreamDirt, "Dream_Dirt");
		GameRegistry.registerBlock(dreamSand, "Dream_Sand");
		GameRegistry.registerBlock(oreLucidity, "OreLucidity");
		GameRegistry.registerBlock(oreStarcesium, "OreStarCesium");
		
		GameRegistry.registerItem(itemlighter, "Boom Stick");
		GameRegistry.registerItem(itemSwordPhantomIron, "Phantom Sword");
		GameRegistry.registerItem(itemLucidity, "Lucidity");
		
		LanguageRegistry.addName(portal, "Portal");
		LanguageRegistry.addName(portalObsidian, "ShadowStone");
		LanguageRegistry.addName(dreamStone, "SoldjerStone");
		LanguageRegistry.addName(dreamQuartz, "Surrealite");
		LanguageRegistry.addName(dreamDirt, "Chaotic Earth");
		LanguageRegistry.addName(dreamSand, "Dream_Sand");
		LanguageRegistry.addName(oreLucidity, "OreLucidity");
		LanguageRegistry.addName(oreStarcesium, "OreStarCesium");
		
		LanguageRegistry.addName(itemlighter, "Igniter");
		LanguageRegistry.addName(itemSwordPhantomIron, "Phantom Sword");
		LanguageRegistry.addName(itemLucidity, "Lucidity");
		
		// Creative Tab
		LanguageRegistry.instance().addStringLocalization("itemGroup.tabDreamLand", "en_US", "Dreamland");

		GameRegistry.addRecipe(new ItemStack(portalObsidian), new Object[] {"XXX", "XOX", "XXX", 'X', Block.obsidian, 'O', Block.blockDiamond});
		GameRegistry.addRecipe(new ItemStack(itemlighter), new Object[] {"  X", " X ", "X  ", 'X', Item.emerald });
		GameRegistry.addRecipe(new ItemStack(itemSwordPhantomIron), new Object[] {" O ", " O ", " X ", 'X', Item.emerald, 'O', Item.diamond});
		
		DimensionManager.registerProviderType(DreamLand.dimensionID, DreamLandWorldProvider.class, true);
		DimensionManager.registerDimension(DreamLand.dimensionID, DreamLand.dimensionID);
		
		
	}

	@PostInit
	public void postInit(FMLPostInitializationEvent evt) {
		//TODO stuff

	}
}
