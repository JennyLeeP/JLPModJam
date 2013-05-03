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

    // Blocks
    	//Dream Dimension
    public static int DreamLandPortalID;
    public static int PortalObsidianID;
    public static int DreamStoneID;
    public static int DreamQuartzID;//maybe change to something else
    public static int DreamDirtID;
    public static int DreamSandID;
    public static int OreLucidityID;
    public static int OreStarCesiumID;
    public static int DreamGrassID;
    public static int DreamGravelID;
    public static int DreamCobbleID;
    public static int DreamStairsID;
    public static int DreamWallID;
    public static int DreamLogsID;
    public static int DreamPlanksID;
    public static int DreamLeavesID;
    public static int DreamSaplingsID;
    public static int NMGrassID;
    public static int NMDirtID;
    public static int NMStoneID;
    public static int NMGravelID;
    public static int NMSandID;
    public static int NMCobbleID;
    public static int NMStairsID;

    // Enable Dimension
    public static boolean enableDreamDimension;

    // Dimension ID
    public static int dimensionID;

    // IDs to make into cake
    public static int[] defaultIDs;
    // Cake related thing
    public static Property ids;

    public static void init(FMLPreInitializationEvent event) {

        File configFile = new File(event.getModConfigurationDirectory(), Archive.modName + ".cfg");

        Configuration config = new Configuration(configFile);

        try{
            config.load();

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

    private static void configItems(Configuration config) {
        int iID = 30000;
        itemLighterId = config.getItem(Archive.itemLighter, iID++).getInt();
        swordPhantomId = config.getItem(Archive.itemSwordPhantomIron, iID++).getInt();
        itemLucidityID = config.getItem(Archive.itemLucidity, iID++).getInt();
        itemSparklingSaplingID = config.getItem(Archive.itemSparklingSapling, iID++).getInt();
    }

    private static void configBlocks(Configuration config) {
        int bID = 4000;
        DreamLandPortalID = config.getBlock(Archive.portal, bID++).getInt();
        PortalObsidianID = config.getBlock(Archive.portalObsidian, bID++).getInt();
        DreamStoneID = config.getBlock(Archive.dreamStone, bID++).getInt();
        DreamQuartzID = config.getBlock(Archive.dreamQuartz, bID++).getInt();
        DreamDirtID = config.getBlock(Archive.dreamDirt, bID++).getInt();
        DreamSandID = config.getBlock(Archive.dreamSand, bID++).getInt();
        OreLucidityID = config.getBlock(Archive.oreLucidity, bID++).getInt();
        OreStarCesiumID = config.getBlock(Archive.oreStarcesium, bID++).getInt();
        DreamGrassID = config.getBlock(Archive.dreamGrass, bID++).getInt();
        DreamGravelID = config.getBlock(Archive.dreamGravel, bID++).getInt();
        DreamCobbleID = config.getBlock(Archive.dreamCobble, bID++).getInt();
        DreamStairsID = config.getBlock(Archive.dreamStairs, bID++).getInt();
        DreamWallID = config.getBlock(Archive.dreamWall, bID++).getInt();
        DreamLogsID = config.getBlock(Archive.dreamLogs, bID++).getInt();
        DreamPlanksID = config.getBlock(Archive.dreamPlanks, bID++).getInt();
        DreamLeavesID = config.getBlock(Archive.dreamLeaves, bID++).getInt();
        DreamSaplingsID = config.getBlock(Archive.dreamSaplings, bID++).getInt();
        NMGrassID = config.getBlock(Archive.nmGrass, bID++).getInt();
        NMDirtID = config.getBlock(Archive.nmDirt, bID++).getInt();
        NMStoneID = config.getBlock(Archive.nmStone, bID++).getInt();
        NMGravelID = config.getBlock(Archive.nmGravel, bID++).getInt();
        NMSandID = config.getBlock(Archive.nmSand, bID++).getInt();
        NMCobbleID = config.getBlock(Archive.nmCobble, bID++).getInt();
        NMStairsID = config.getBlock(Archive.nmStairs, bID++).getInt();
    }

    private static void setDefaults() {
        defaultIDs = new int[] { Block.cactus.blockID, Block.tallGrass.blockID, Block.dirt.blockID,
                Block.grass.blockID, Block.carrot.blockID, Block.crops.blockID, DreamGrassID,
                DreamDirtID };
    }

    private static void configGeneral(Configuration config) {
        String general = "General";
        enableDreamDimension = config.get(general, "enableDreamDimension", true).getBoolean(true);

        dimensionID = config.get(general, "Dimension ID: ", 21).getInt();

        ids = config.get(general, "White List:", defaultIDs);
    }
}