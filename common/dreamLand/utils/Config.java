package dreamLand.utils;

import java.io.File;
import java.util.logging.Level;

import net.minecraft.block.Block;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.Property;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class Config {

    // Items
    public static int itemLighterId;
    public static int swordPhantomId;
    public static int itemLucidityID;
    public static int itemMethaneClathrateID;
    public static int whiteSeedsID;
    public static int whiteFlowerID;
    
    // Blocks
    public static int DreamLandPortalID;
    public static int PortalObsidianID;
    public static int DreamStoneID;
    public static int DreamStonesID;
    public static int DreamDirtID;
    public static int DreamSandID;
    public static int OreLucidityID;
    public static int DreamGrassID;
    public static int DreamGravelID;
    public static int DreamCobbleID;
    public static int DreamStairsID;
    public static int NightMarePortalID;
    public static int NMGrassID;
    public static int NMDirtID;
    public static int NMStoneID;
    public static int NMGravelID;
    public static int NMSandID;
    public static int NMCobbleID;
    public static int NMStairsID;
    public static int NMLogsID;
    public static int BloodStairsID;
    public static int DreamFenceID;
    // Meta Blocks
    public static int DreamWallID;
    public static int DreamLogsID;
    public static int DreamPlanksID;
    public static int DreamLeavesID;
    public static int DreamSaplingsID;
    public static int DreamFallingID;
    public static int DreamWoodSlabsID;
    public static int DreamStoneSlabsID;
    public static int DreamWoodDBLSlabsID;
    public static int DreamStoneDBLSlabsID;
    public static int DreamFlowersID;
    //Ores
    public static int OreMethaneClathrateID;
    public static int DreamOresID;
    // Custom Blocks
    public static int ChickenAlterID;

    // Enable Debug
    public static boolean enableDebug;
    public static boolean enableDebugNaming;
    public static boolean enableModCompatibility;

    // Biome ID's
    public static int biomeLushHillsID;
    public static int biomeTreacherousHillsID;
    // Dimension ID
    public static int dimensionID;
    public static int dimensionNMID;
    
    // Particle effects
    public static boolean enableTreeParticles;

    // IDs to make into cake
    public static int[] defaultIDs;
    // Cake related thing
    public static Property ids;
    
    public static int shamanVillagerID;

    public static void init(FMLPreInitializationEvent event) {

        File configFile = new File(event.getModConfigurationDirectory(), Reference.modName + ".cfg");

        Configuration config = new Configuration(configFile);

        try{
            config.load();

            configDebug(config);
            
            configWorld(config);
            
            configItems(config);

            configBlocks(config);

            setDefaults();

            configGeneral(config);

        }catch(Exception e){
            FMLLog.log(Level.SEVERE, e, Reference.modName
                    + " has had a problem loading its configuration");
        }finally{
            if (config.hasChanged())
                config.save();
        }
    }
    private static void configDebug(Configuration config){
        String debug = "Debug";
        enableDebug = config.get(debug, "enableDebug", false).getBoolean(false);
        enableDebugNaming = config.get(debug, "enableDebugNaming", false).getBoolean(false);
    }
    
    private static void configWorld(Configuration config){
        String world = "World";
        dimensionID = config.get(world, "Dream-DimensionID", 42).getInt();
        dimensionNMID = config.get(world, "NightNare-DimensionID", 21).getInt();
        biomeLushHillsID = config.get(world, "BiomeLushHillsID", 100).getInt();
        biomeTreacherousHillsID = config.get(world, "BiomeTreacherousHillsID", 101).getInt();
    }

    private static void configItems(Configuration config) {
        int iID = 30000;
        itemLighterId = config.getItem(Reference.itemLighter, iID++).getInt();
        swordPhantomId = config.getItem(Reference.itemSwordPhantomIron, iID++).getInt();
        itemLucidityID = config.getItem(Reference.itemLucidity, iID++).getInt();
        itemMethaneClathrateID = config.getItem(Reference.itemMethaneClathrate, iID++).getInt();
        whiteSeedsID = config.getItem(Reference.whiteSeeds, iID++).getInt();
        whiteFlowerID = config.getItem(Reference.whiteFlower, iID++).getInt();
    }

    private static void configBlocks(Configuration config) {
        int bID = 4000;
        // Portals
        DreamLandPortalID = config.getBlock(Reference.portal, bID++).getInt();
        PortalObsidianID = config.getBlock(Reference.portalObsidian, bID++).getInt();
        NightMarePortalID = config.getBlock(Reference.nmPortal, bID++).getInt(); 
        
        // Stone, Grass and Dirt
        DreamStoneID = config.getBlock(Reference.dreamStone, bID++).getInt();
        NMStoneID = config.getBlock(Reference.nmStone, bID++).getInt();
        DreamGrassID = config.getBlock(Reference.dreamGrass, bID++).getInt();
        DreamDirtID = config.getBlock(Reference.dreamDirt, bID++).getInt();
        NMGrassID = config.getBlock(Reference.nmGrass, bID++).getInt();
        NMDirtID = config.getBlock(Reference.nmDirt, bID++).getInt();
        
        // Bricks and Cobble
        DreamCobbleID = config.getBlock(Reference.dreamCobble, bID++).getInt();
        NMCobbleID = config.getBlock(Reference.nmCobble, bID++).getInt();
        DreamStonesID = config.getBlock(Reference.dreamStones, bID++).getInt();
        
        // Gravel and Sand
        DreamFallingID = config.getBlock(Reference.dreamFalling, bID++).getInt();
        
        // Walls and Stairs 
        DreamStairsID = config.getBlock(Reference.dreamStairs, bID++).getInt();
        NMStairsID = config.getBlock(Reference.nmStairs, bID++).getInt();
        BloodStairsID = config.getBlock(Reference.bloodStairs, bID++).getInt();
        DreamWallID = config.getBlock(Reference.dreamWall, bID++).getInt();
        // Slabs and Fences
        DreamFenceID = config.getBlock(Reference.dreamFence, bID++).getInt();
        DreamWoodSlabsID = config.getBlock(Reference.dreamWoodSlabs, bID++).getInt();
        DreamStoneSlabsID = config.getBlock(Reference.dreamStoneSlabs, bID++).getInt();
        DreamWoodDBLSlabsID = config.getBlock(Reference.dreamWoodDBLSlabs, bID++).getInt();
        DreamStoneDBLSlabsID = config.getBlock(Reference.dreamStoneDBLSlabs, bID++).getInt();
        // Logs, Leaves and Planks
        DreamLogsID = config.getBlock(Reference.dreamLogs, bID++).getInt();
        NMLogsID = config.getBlock(Reference.nmLogs, bID++).getInt();
        DreamPlanksID = config.getBlock(Reference.dreamPlanks, bID++).getInt();
        DreamLeavesID = config.getBlock(Reference.dreamLeaves, bID++).getInt();
        DreamSaplingsID = config.getBlock(Reference.dreamSaplings, bID++).getInt();
        // Flowers and Plants
        DreamFlowersID = config.getBlock(Reference.dreamFlowers, bID++).getInt();
        
        // Ores
        OreLucidityID = config.getBlock(Reference.oreLucidity, bID++).getInt();
        OreMethaneClathrateID = config.getBlock(Reference.oreMethaneClathrate, bID++).getInt();
        DreamOresID = config.getBlock(Reference.blockDreamOres, bID++).getInt();
        // Custom
        ChickenAlterID = config.getBlock(Reference.chickenAlter, bID++).getInt();
        // Villagers
        String villager = "Villager";
        shamanVillagerID = config.get(villager, "shamanVillagerID", 78844).getInt();
            
    }

    private static void setDefaults() {
        defaultIDs = new int[] { Block.cactus.blockID, Block.tallGrass.blockID, Block.dirt.blockID,
                Block.grass.blockID, Block.carrot.blockID, Block.crops.blockID, DreamGrassID,
                DreamDirtID };
    }

    private static void configGeneral(Configuration config) {
        String general = "General";
        enableTreeParticles = config.get(general, "enableTreeParticles", true).getBoolean(true);
        enableModCompatibility = config.get(general, "enableModCompatibility", true).getBoolean(true);
        ids = config.get(general, "White List:", defaultIDs);
    }
    
}