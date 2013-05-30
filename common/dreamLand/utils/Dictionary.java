package dreamLand.utils;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import dreamLand.blocks.ModBlocks;

public class Dictionary {

    public static void register() {
        OreDictionary.registerOre("plankWood", new ItemStack(ModBlocks.dreamPlanks,1, Short.MAX_VALUE));
        
        OreDictionary.registerOre("logWood", new ItemStack(ModBlocks.dreamLogs,1, Short.MAX_VALUE));
        
        OreDictionary.registerOre("logWood", new ItemStack(ModBlocks.nmLogs,1, Short.MAX_VALUE));
        
        OreDictionary.registerOre("treeSapling", new ItemStack(ModBlocks.dreamSaplings, 1, Short.MAX_VALUE));
        
        OreDictionary.registerOre("treeLeaves", new ItemStack(ModBlocks.dreamLeaves, 1, Short.MAX_VALUE));
    }

}
