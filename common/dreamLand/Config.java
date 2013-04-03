package dreamLand;

import java.io.File;
import java.util.logging.Level;

import net.minecraft.block.Block;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.Property;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class Config {

    public static int itemLighterId, swordPhantomId, itemLucidityID, itemSparklingSaplingID,
            DreamLandPortalID, PortalObsidianID, DreamStoneID, DreamQuartzID, DreamDirtID,
            DreamSandID, OreLucidityID, OreStarCesiumID, DreamGrassID;

    public static boolean enableDreamDimension;

    public static Property ids;
    
    public static int[] defaultIDs = { Block.cactus.blockID, Block.tallGrass.blockID,
            Block.dirt.blockID, Block.grass.blockID, Block.carrot.blockID, Block.crops.blockID,
            DreamGrassID, DreamDirtID };

    public static void init(FMLPreInitializationEvent event) {

        File configFile = new File(event.getModConfigurationDirectory(), DreamLand.modid + ".cfg");

        Configuration config = new Configuration(configFile);

        try{
            config.load();

            // General
            enableDreamDimension = config.get("general", "enableDreamDimension", true).getBoolean(
                    true);
            ids = config.get("general", "White List:", defaultIDs);

            // Item
            itemLighterId = config.getItem("itemLighter", 30000).getInt(30000);
            swordPhantomId = config.getItem("itemSwordPhantomIron", 30001).getInt(30001);
            itemLucidityID = config.getItem("itemLucidity", 30002).getInt(30002);
            itemSparklingSaplingID = config.getItem("itemSparklingSapling", 30003).getInt(30003);

            // Block
            DreamLandPortalID = config.getBlock("blockPortal", 4000).getInt(4000);
            PortalObsidianID = config.getBlock("portalObsidian", 4001).getInt(4001);
            DreamStoneID = config.getBlock("dreamStone", 4002).getInt(4002);
            DreamQuartzID = config.getBlock("dreamQuartz", 4003).getInt(4003);
            DreamDirtID = config.getBlock("dreamDirt", 4004).getInt(4004);
            DreamSandID = config.getBlock("dreamGravel", 4005).getInt(4005);
            OreLucidityID = config.getBlock("oreLucidity", 4006).getInt(4006);
            OreStarCesiumID = config.getBlock("oreStarcesium", 4007).getInt(4007);
            DreamGrassID = config.getBlock("dreamGrass", 4008).getInt(4008);

        }catch(Exception e){
            FMLLog.log(Level.SEVERE, e, DreamLand.modid
                    + " has had a problem loading its configuration");
        }finally{
            config.save();
        }
    }
}