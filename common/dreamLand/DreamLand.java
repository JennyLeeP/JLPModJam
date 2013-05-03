package dreamLand;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import dreamLand.blocks.ModBlocks;
import dreamLand.items.ModItems;
import dreamLand.sided.CommonProxy;
import dreamLand.utils.Archive;
import dreamLand.utils.Config;
import dreamLand.utils.DreamLandTabs;
import dreamLand.utils.DreamLand_EventBonemeal;
import dreamLand.utils.Registry;
import dreamLand.utils.handlers.LanguageHandler;
import dreamLand.world.biome.BiomeDreamLand;

@Mod(modid = Archive.modID, name = Archive.modName, version = Archive.VERSION)
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class DreamLand {

    @Instance(Archive.modID)
    public static DreamLand instance;

    @SidedProxy(clientSide = Archive.clientProxy, serverSide = Archive.serverProxy)
    public static CommonProxy proxy;

    public static EnumArmorMaterial armorPravlon = EnumHelper.addArmorMaterial("PhantomIron", 29,
            new int[] { 2, 7, 5, 3 }, 9);

    public static EnumToolMaterial toolPhantomIron = EnumHelper.addToolMaterial("PhantomIron", 3,
            2000, 12.0F, 9, 25);

    public static BiomeGenBase dreamIsland;

    // Declares a new Creative Tab
    public static CreativeTabs tabDreamLand = new DreamLandTabs(CreativeTabs.getNextID(),
            Archive.tabDreamLand);

    @PreInit
    public void preInit(FMLPreInitializationEvent evt) {

        // Loads the Configuration File
        Config.init(evt);

        // Creates the Items
        ModItems.init();
        
        // Creates the Blocks
        ModBlocks.init();
        
        dreamIsland = (new BiomeDreamLand(100)).setColor(6316128).setBiomeName("Dream Land").setMinMaxHeight(0.3F, 2.0F).setTemperatureRainfall(0.2F, 0.3F);
        GameRegistry.addBiome(DreamLand.dreamIsland);
        
        // Loads Languages
        LanguageHandler.loadLanguages();

        // Makes capes available :D
        proxy.initCapes();
        
        MinecraftForge.EVENT_BUS.register(new DreamLand_EventBonemeal());
    }

    @Init
    public void init(FMLInitializationEvent evt) {

        // Does all the game registry stuff
        Registry.register();
        
        proxy.registerRenderers();
        
       

    }

    @PostInit
    public void postInit(FMLPostInitializationEvent evt) {
        // TODO stuff

    }
}
