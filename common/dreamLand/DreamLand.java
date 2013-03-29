package dreamLand;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
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

@Mod(modid = DreamLand.modid, name = "DreamLand", version = DreamLand.VERSION)
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class DreamLand {

	public static final String VERSION = "1.0";
	public static final String modid = "DreamLand";

	@SidedProxy(clientSide = "dreamLand.ClientProxy", serverSide = "dreamLand.CommonProxy")
	public static CommonProxy proxy;
	
	public static Block portalObsidian;
	public static BlockPortalDreamLand portal;
	public static Item itemlighter;
	
	public static int dimensionID = 21;
	
	
	static boolean enableDreamDimension;

	@Instance("DreamLand")
	public static DreamLand instance;


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
		
		config.save();
		portal = (BlockPortalDreamLand) new BlockPortalDreamLand(DreamLandPortalID).setUnlocalizedName("portal");
		portalObsidian = new BlockDreamLand(PortalObsidianID).setUnlocalizedName("portalObsidian");
		itemlighter = new ItemLighter(itemLighterId - 256).setUnlocalizedName("itemLighter");
	}


	@Init
	public void init(FMLInitializationEvent evt) {
		proxy.registerRenderThings();

		GameRegistry.registerBlock(portalObsidian, "Obsidiatal");
		GameRegistry.registerBlock(portal, "DreamLand_Portal");
		GameRegistry.registerItem(itemlighter, "Boom Stick");
		
		
		LanguageRegistry.addName(portal, "Portal");
		LanguageRegistry.addName(portalObsidian, "Obsidiatal");
		LanguageRegistry.addName(itemlighter, "Boom Stick");

		GameRegistry.addRecipe(new ItemStack(portalObsidian), new Object[] {"XXX", "XOX", "XXX", 'X', Block.obsidian, 'O', Block.blockDiamond});
		GameRegistry.addRecipe(new ItemStack(itemlighter), new Object[] {"  X", " X ", "X  ", 'X', Item.emerald });
		
		
		DimensionManager.registerDimension(DreamLand.dimensionID, 0);
		
		
	}

	@PostInit
	public void postInit(FMLPostInitializationEvent evt) {
		//TODO stuff

	}
}
