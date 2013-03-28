package dreamLand;


import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = "DreamLand", name = "DreamLand", version = DreamLand.VERSION)
public class DreamLand {

	public static final String VERSION = "1.0";
	@SidedProxy(clientSide = "dreamLand.ClientProxy", serverSide = "dreamLand.CommonProxy")
	public static CommonProxy proxy;
	
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
		config.save();
	}

	
	//@Init
	public void Init(FMLInitializationEvent evt){
		//TODO stuff
	
	}
	
	@PostInit
	public void postInit(FMLPostInitializationEvent evt) {
		//TODO stuff
		
	}
}
