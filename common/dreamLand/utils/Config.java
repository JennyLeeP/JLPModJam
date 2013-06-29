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
    public static int itemSparklingSaplingID;
    public static int itemMethaneClathrateID;
    
    // Blocks
    public static int DreamLandPortalID;
    public static int PortalObsidianID;
    public static int DreamStoneID;
    public static int DreamStones1ID;
    public static int DreamDirtID;
    public static int DreamSandID;
    public static int OreLucidityID;
    public static int OreStarCesiumID;
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
    //Ores
    public static int OreMethaneClathrateID;

    // Enable Debug
    public static boolean enableDebug;
    public static boolean enableDebugNaming;

    // Biome ID's
    public static int biomeLushHillsID;
    public static int biomeTreacherousHillsID;
    // Dimension ID
    public static int dimensionID;
    public static int dimensionNMID;

    // IDs to make into cake
    public static int[] defaultIDs;
    // Cake related thing
    public static Property ids;

    public static void init(FMLPreInitializationEvent event) {

        File configFile = new File(event.getModConfigurationDirectory(), Archive.modName + ".cfg");

        Configuration config = new Configuration(configFile);

        try{
            config.load();

            configDebug(config);
            
            configItems(config);

            configBlocks(config);

            setDefaults();

            configGeneral(config);

        }catch(Exception e){
            FMLLog.log(Level.SEVERE, e, Archive.modName
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

    private static void configItems(Configuration config) {
        int iID = 30000;
        itemLighterId = config.getItem(Archive.itemLighter, iID++).getInt();
        swordPhantomId = config.getItem(Archive.itemSwordPhantomIron, iID++).getInt();
        itemLucidityID = config.getItem(Archive.itemLucidity, iID++).getInt();
        itemMethaneClathrateID = config.getItem(Archive.itemMethaneClathrate, iID++).getInt();
    }

    private static void configBlocks(Configuration config) {
        int bID = 4000;
        // Portals
        DreamLandPortalID = config.getBlock(Archive.portal, bID++).getInt();
        PortalObsidianID = config.getBlock(Archive.portalObsidian, bID++).getInt();
        NightMarePortalID = config.getBlock(Archive.nmPortal, bID++).getInt(); 
        
        // Stone, Grass and Dirt
        DreamStoneID = config.getBlock(Archive.dreamStone, bID++).getInt();
        NMStoneID = config.getBlock(Archive.nmStone, bID++).getInt();
        DreamGrassID = config.getBlock(Archive.dreamGrass, bID++).getInt();
        DreamDirtID = config.getBlock(Archive.dreamDirt, bID++).getInt();
        NMGrassID = config.getBlock(Archive.nmGrass, bID++).getInt();
        NMDirtID = config.getBlock(Archive.nmDirt, bID++).getInt();
        
        // Bricks and Cobble
        DreamCobbleID = config.getBlock(Archive.dreamCobble, bID++).getInt();
        NMCobbleID = config.getBlock(Archive.nmCobble, bID++).getInt();
        DreamStones1ID = config.getBlock(Archive.dreamStones1, bID++).getInt();
        
        // Gravel and Sand
        DreamFallingID = config.getBlock(Archive.dreamFalling, bID++).getInt();
        
        // Walls and Stairs 
        DreamStairsID = config.getBlock(Archive.dreamStairs, bID++).getInt();
        NMStairsID = config.getBlock(Archive.nmStairs, bID++).getInt();
        BloodStairsID = config.getBlock(Archive.bloodStairs, bID++).getInt();
        DreamWallID = config.getBlock(Archive.dreamWall, bID++).getInt();
        // Slabs and Fences
        DreamFenceID = config.getBlock(Archive.dreamFence, bID++).getInt();
        
        // Logs, Leaves and Planks
        DreamLogsID = config.getBlock(Archive.dreamLogs, bID++).getInt();
        NMLogsID = config.getBlock(Archive.nmLogs, bID++).getInt();
        DreamPlanksID = config.getBlock(Archive.dreamPlanks, bID++).getInt();
        DreamLeavesID = config.getBlock(Archive.dreamLeaves, bID++).getInt();
        DreamSaplingsID = config.getBlock(Archive.dreamSaplings, bID++).getInt();
        
        // Ores
        OreLucidityID = config.getBlock(Archive.oreLucidity, bID++).getInt();
        OreStarCesiumID = config.getBlock(Archive.oreStarcesium, bID++).getInt();
        OreMethaneClathrateID = config.getBlock(Archive.oreMethaneClathrate, bID++).getInt();
            
    }

    private static void setDefaults() {
        defaultIDs = new int[] { Block.cactus.blockID, Block.tallGrass.blockID, Block.dirt.blockID,
                Block.grass.blockID, Block.carrot.blockID, Block.crops.blockID, DreamGrassID,
                DreamDirtID };
    }

    private static void configGeneral(Configuration config) {
        String general = "General";
        dimensionID = config.get(general, "Dimension ID: ", 42).getInt();
        dimensionNMID = config.get(general, "NMDimension ID: ", 21).getInt();
        biomeLushHillsID = config.get(general, "BiomeLushHills ID: ", 100).getInt();
        biomeTreacherousHillsID = config.get(general, "BiomeTreacherousHills ID: ", 101).getInt();
        
        ids = config.get(general, "White List:", defaultIDs);
    }
    
}