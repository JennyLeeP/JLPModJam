package dreamLand.compatibility;

import cpw.mods.fml.common.event.FMLInterModComms;
import dreamLand.blocks.ModBlocks;
import dreamLand.utils.Config;
import dreamLand.world.biome.ModBiomes;

public class BCCompatibility {
    public static void init()
    {
        if(Config.enableDebug){
            System.out.println("[DreamLand] Starting BuildCraft integration. ");
            }
        addFacades();
        excludeOilGeneration();
        
        if(Config.enableDebug){
            System.out.println("[DreamLand] Finished BuildCraft integration. ");
            }
    }
    private static void excludeOilGeneration()
    {
        FMLInterModComms.sendMessage("BuildCraft|Energy", "oil-gen-exclude", Integer.toString(ModBiomes.LushHills.biomeID));
        FMLInterModComms.sendMessage("BuildCraft|Energy", "oil-gen-exclude", Integer.toString(ModBiomes.TreacherousHills.biomeID));
    }
    private static void addFacades()
    {
        System.out.println("[DreamLand] adding Facades to BuildCraft");
        /*
         *  This Method wants two Int's 1: Id of Block, 2 : meta of block.
         */
       
        //Wood
        FMLInterModComms.sendMessage("BuildCraft|Transport", "add-facade", ModBlocks.dreamLogs.blockID + "@" + 0);
        FMLInterModComms.sendMessage("BuildCraft|Transport", "add-facade", ModBlocks.dreamLogs.blockID + "@" + 1);
        FMLInterModComms.sendMessage("BuildCraft|Transport", "add-facade", ModBlocks.dreamLogs.blockID + "@" + 2);
        FMLInterModComms.sendMessage("BuildCraft|Transport", "add-facade", ModBlocks.dreamLogs.blockID + "@" + 3);
        FMLInterModComms.sendMessage("BuildCraft|Transport", "add-facade", ModBlocks.nmLogs.blockID + "@" + 0);
        FMLInterModComms.sendMessage("BuildCraft|Transport", "add-facade", ModBlocks.nmLogs.blockID + "@" + 1);
        FMLInterModComms.sendMessage("BuildCraft|Transport", "add-facade", ModBlocks.nmLogs.blockID + "@" + 2);
        FMLInterModComms.sendMessage("BuildCraft|Transport", "add-facade", ModBlocks.nmLogs.blockID + "@" + 3);
        
        //Planks
        FMLInterModComms.sendMessage("BuildCraft|Transport", "add-facade", ModBlocks.dreamPlanks.blockID + "@" + 0);
        FMLInterModComms.sendMessage("BuildCraft|Transport", "add-facade", ModBlocks.dreamPlanks.blockID + "@" + 1);
        FMLInterModComms.sendMessage("BuildCraft|Transport", "add-facade", ModBlocks.dreamPlanks.blockID + "@" + 2);
        FMLInterModComms.sendMessage("BuildCraft|Transport", "add-facade", ModBlocks.dreamPlanks.blockID + "@" + 3);
        FMLInterModComms.sendMessage("BuildCraft|Transport", "add-facade", ModBlocks.dreamPlanks.blockID + "@" + 4);
        FMLInterModComms.sendMessage("BuildCraft|Transport", "add-facade", ModBlocks.dreamPlanks.blockID + "@" + 5);
        FMLInterModComms.sendMessage("BuildCraft|Transport", "add-facade", ModBlocks.dreamPlanks.blockID + "@" + 6);
        FMLInterModComms.sendMessage("BuildCraft|Transport", "add-facade", ModBlocks.dreamPlanks.blockID + "@" + 7);
        
        //Stone
        FMLInterModComms.sendMessage("BuildCraft|Transport", "add-facade", ModBlocks.dreamStone.blockID + "@" + 0);
        FMLInterModComms.sendMessage("BuildCraft|Transport", "add-facade", ModBlocks.nmStone.blockID + "@" + 0);
        FMLInterModComms.sendMessage("BuildCraft|Transport", "add-facade", ModBlocks.dreamCobble.blockID + "@" + 0);
        FMLInterModComms.sendMessage("BuildCraft|Transport", "add-facade", ModBlocks.nmCobble.blockID + "@" + 0);
        FMLInterModComms.sendMessage("BuildCraft|Transport", "add-facade", ModBlocks.dreamStones.blockID + "@" + 0);
        FMLInterModComms.sendMessage("BuildCraft|Transport", "add-facade", ModBlocks.dreamStones.blockID + "@" + 1);
        FMLInterModComms.sendMessage("BuildCraft|Transport", "add-facade", ModBlocks.dreamStones.blockID + "@" + 2);
        FMLInterModComms.sendMessage("BuildCraft|Transport", "add-facade", ModBlocks.dreamStones.blockID + "@" + 3);
        FMLInterModComms.sendMessage("BuildCraft|Transport", "add-facade", ModBlocks.portalObsidian.blockID + "@" + 0);

        //Dirt, Sand and Gravel
        FMLInterModComms.sendMessage("BuildCraft|Transport", "add-facade", ModBlocks.dreamDirt.blockID + "@" + 0);
        FMLInterModComms.sendMessage("BuildCraft|Transport", "add-facade", ModBlocks.nmDirt.blockID + "@" + 0);
        FMLInterModComms.sendMessage("BuildCraft|Transport", "add-facade", ModBlocks.dreamFalling.blockID + "@" + 0);
        FMLInterModComms.sendMessage("BuildCraft|Transport", "add-facade", ModBlocks.dreamFalling.blockID + "@" + 1);
        FMLInterModComms.sendMessage("BuildCraft|Transport", "add-facade", ModBlocks.dreamFalling.blockID + "@" + 2);
        FMLInterModComms.sendMessage("BuildCraft|Transport", "add-facade", ModBlocks.dreamFalling.blockID + "@" + 3);

        System.out.println("[DreamLand] Finished adding Facades to BuildCraft");
    }
    
}
