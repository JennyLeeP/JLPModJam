package dreamLand.compatibility;

import cpw.mods.fml.common.event.FMLInterModComms;
import dreamLand.blocks.ModBlocks;
import dreamLand.world.biome.ModBiomes;

public class BCCompatibility {
    public static void init()
    {
        addFacades();
        excludeOilGeneration();
    }
    private static void excludeOilGeneration()
    {
        FMLInterModComms.sendMessage("BuildCraft|Energy", "oil-gen-exclude", Integer.toString(ModBiomes.dreamIsland.biomeID));
        FMLInterModComms.sendMessage("BuildCraft|Energy", "oil-gen-exclude", Integer.toString(ModBiomes.nightMare.biomeID));
    }
    private static void addFacades()
    {
        //Wood
        FMLInterModComms.sendMessage("BuildCraft|Transport", "add-facade", ModBlocks.dreamLogs.blockID + "@" + 0);
    }
    
}
