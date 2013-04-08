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
    public static int DreamLandPortalID;
    public static int PortalObsidianID;
    public static int DreamStoneID;
    public static int DreamQuartzID;
    public static int DreamDirtID;
    public static int DreamSandID;
    public static int OreLucidityID;
    public static int OreStarCesiumID;
    public static int DreamGrassID;

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
        itemLighterId = config.getItem("itemLighter", 30000).getInt(30000);
        swordPhantomId = config.getItem("itemSwordPhantomIron", 30001).getInt(30001);
        itemLucidityID = config.getItem("itemLucidity", 30002).getInt(30002);
        itemSparklingSaplingID = config.getItem("itemSparklingSapling", 30003).getInt(30003);
    }

    private static void configBlocks(Configuration config) {
        DreamLandPortalID = config.getBlock("blockPortal", 4000).getInt(4000);
        PortalObsidianID = config.getBlock("portalObsidian", 4001).getInt(4001);
        DreamStoneID = config.getBlock("dreamStone", 4002).getInt(4002);
        DreamQuartzID = config.getBlock("dreamQuartz", 4003).getInt(4003);
        DreamDirtID = config.getBlock("dreamDirt", 4004).getInt(4004);
        DreamSandID = config.getBlock("dreamGravel", 4005).getInt(4005);
        OreLucidityID = config.getBlock("oreLucidity", 4006).getInt(4006);
        OreStarCesiumID = config.getBlock("oreStarcesium", 4007).getInt(4007);
        DreamGrassID = config.getBlock("dreamGrass", 4008).getInt(4008);
    }

    private static void setDefaults() {
        defaultIDs = new int[] { Block.cactus.blockID, Block.tallGrass.blockID, Block.dirt.blockID,
                Block.grass.blockID, Block.carrot.blockID, Block.crops.blockID, DreamGrassID,
                DreamDirtID };
    }

    private static void configGeneral(Configuration config) {
        enableDreamDimension = config.get("general", "enableDreamDimension", true).getBoolean(true);

        dimensionID = config.get("general", "Dimension ID: ", 21).getInt(21);

        ids = config.get("general", "White List:", defaultIDs);
    }
}