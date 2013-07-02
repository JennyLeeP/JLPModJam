package dreamLand.compatibility;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraftforge.liquids.LiquidStack;
import net.minecraftforge.oredict.OreDictionary;
import dreamLand.blocks.ModBlocks;
import dreamLand.utils.Config;
import forestry.api.core.EnumHumidity;
import forestry.api.core.EnumTemperature;
import forestry.api.core.GlobalManager;
import forestry.api.core.ItemInterface;
import forestry.api.recipes.RecipeManagers;
import forestry.api.storage.BackpackManager;

public class ForestryCompatibility {
    private static final int MINER = 0;
    private static final int DIGGER = 1;
    private static final int FORESTER = 2;
    
    protected static void init()
    {
        if(Config.enableDebug){
        System.out.println("[DreamLand] Starting Forestry integration. ");
        }
        addClimateInfo();
        addFermenterRecipes();
        addBlocksToManager();
        addBlocksToBackpacks();
        if(Config.enableDebug){
        System.out.println("[DreamLand] Finished Forestry integration. ");
        }
    }
    private static void addClimateInfo()
    {
        //Normal Bees
        EnumTemperature.normalBiomeIds.add(Config.biomeLushHillsID);
        EnumHumidity.normalBiomeIds.add(Config.biomeLushHillsID);
        //Hell Bees
        EnumTemperature.hotBiomeIds.add(Config.biomeTreacherousHillsID);
        EnumHumidity.aridBiomeIds.add(Config.biomeTreacherousHillsID);
    }
    private static void addFermenterRecipes()
    {
        RecipeManagers.fermenterManager.addRecipe(new ItemStack(ModBlocks.dreamSaplings.blockID, 1, OreDictionary.WILDCARD_VALUE), 250, 1, new LiquidStack(ItemInterface.getItem("liquidBiomass").itemID, 1, ItemInterface.getItem("liquidBiomass").getItemDamage()),
                new LiquidStack(Block.waterStill, 1));
    }
    private static void addBlocksToManager()
    {
        GlobalManager.leafBlockIds.add(ModBlocks.dreamLeaves.blockID);
        GlobalManager.dirtBlockIds.add(ModBlocks.dreamDirt.blockID);
        GlobalManager.dirtBlockIds.add(ModBlocks.nmDirt.blockID);
        GlobalManager.sandBlockIds.add(ModBlocks.dreamFalling.blockID);
    }
    private static void addBlocksToBackpacks()
    {
        // Miner's Backpack
        BackpackManager.backpackItems[MINER].add(new ItemStack(ModBlocks.dreamStone, 1, 0));
        BackpackManager.backpackItems[MINER].add(new ItemStack(ModBlocks.nmStone, 1, 0));
        BackpackManager.backpackItems[MINER].add(new ItemStack(ModBlocks.dreamCobble, 1, 0));
        BackpackManager.backpackItems[MINER].add(new ItemStack(ModBlocks.nmCobble, 1, 0));
        BackpackManager.backpackItems[MINER].add(new ItemStack(ModBlocks.dreamStones, 1, 0));
        
        // Digger's Backpack
        BackpackManager.backpackItems[DIGGER].add(new ItemStack(ModBlocks.dreamDirt, 1, 1));
        BackpackManager.backpackItems[DIGGER].add(new ItemStack(ModBlocks.nmDirt, 1, 1));
        BackpackManager.backpackItems[DIGGER].add(new ItemStack(ModBlocks.dreamFalling, 1, OreDictionary.WILDCARD_VALUE));
        // Forester's Backpack
        BackpackManager.backpackItems[FORESTER].add(new ItemStack(ModBlocks.dreamLogs, 1, OreDictionary.WILDCARD_VALUE));
        BackpackManager.backpackItems[FORESTER].add(new ItemStack(ModBlocks.nmLogs, 1, OreDictionary.WILDCARD_VALUE));
        BackpackManager.backpackItems[FORESTER].add(new ItemStack(ModBlocks.dreamLeaves, 1, OreDictionary.WILDCARD_VALUE));
        BackpackManager.backpackItems[FORESTER].add(new ItemStack(ModBlocks.dreamSaplings, 1, OreDictionary.WILDCARD_VALUE));
    }
}
