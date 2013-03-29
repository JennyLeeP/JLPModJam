package dreamLand;



import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = "DreamLand", name = "DreamLand", version = DreamLand.VERSION)
public class DreamLand {

	public static final String VERSION = "1.0";
	@SidedProxy(clientSide = "dreamLand.ClientProxy", serverSide = "dreamLand.CommonProxy")
	public static CommonProxy proxy;
	public static Block portal;
	public static Item itemlighter;
	static boolean enableDreamDimension;
	
	@Instance("DreamLand")
	public static DreamLand instance;
	
	
	@PreInit
	public void preInit(FMLPreInitializationEvent evt) {
		Configuration config = new Configuration(
				evt.getSuggestedConfigurationFile());
		config.load();
		// General
		enableDreamDimension = config.get("general", "enableDreamDimension",
						true).getBoolean(true);
		
		int itemLighterId = config.getItem("itemLighter", 2278).getInt(2278);
		config.save();
		
	itemlighter = new DreamLandItem(itemLighterId - 256);
	}

	
	@Init
	public void init(FMLInitializationEvent evt) {
		proxy.registerRenderThings();
		
		portal = new BlockPortalDreamLand(4000, 0)/*.setBlockName("portal")*/;
		GameRegistry.registerBlock(portal, "DreamLand Portal");
		LanguageRegistry.addName(portal, "Portal");
		
	
	}
	
	@PostInit
	public void postInit(FMLPostInitializationEvent evt) {
		//TODO stuff
		
	}
}
