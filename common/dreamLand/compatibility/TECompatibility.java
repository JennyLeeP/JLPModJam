package dreamLand.compatibility;

import net.minecraft.item.ItemStack;
import dreamLand.blocks.ModBlocks;
import thermalexpansion.api.crafting.CraftingHelpers;
import thermalexpansion.api.crafting.CraftingManagers;
import thermalexpansion.api.item.ItemRegistry;

public class TECompatibility {
    protected static void init()
    {
        addSawMillRecipes();
        addPulverizerRecipes();
    }
    private static void addSawMillRecipes()
    {
        CraftingHelpers.addSawmillLogToPlankRecipe(new ItemStack(ModBlocks.dreamLogs.blockID, 1, 0), new ItemStack(ModBlocks.dreamPlanks.blockID, 6, 0));
        CraftingHelpers.addSawmillLogToPlankRecipe(new ItemStack(ModBlocks.dreamLogs.blockID, 1, 1), new ItemStack(ModBlocks.dreamPlanks.blockID, 6, 1));
        CraftingHelpers.addSawmillLogToPlankRecipe(new ItemStack(ModBlocks.dreamLogs.blockID, 1, 2), new ItemStack(ModBlocks.dreamPlanks.blockID, 6, 2));
        CraftingHelpers.addSawmillLogToPlankRecipe(new ItemStack(ModBlocks.dreamLogs.blockID, 1, 3), new ItemStack(ModBlocks.dreamPlanks.blockID, 6, 3));
        CraftingHelpers.addSawmillLogToPlankRecipe(new ItemStack(ModBlocks.nmLogs.blockID, 1, 0), new ItemStack(ModBlocks.dreamPlanks.blockID, 6, 4));
        CraftingHelpers.addSawmillLogToPlankRecipe(new ItemStack(ModBlocks.nmLogs.blockID, 1, 1), new ItemStack(ModBlocks.dreamPlanks.blockID, 6, 5));
        CraftingHelpers.addSawmillLogToPlankRecipe(new ItemStack(ModBlocks.nmLogs.blockID, 1, 2), new ItemStack(ModBlocks.dreamPlanks.blockID, 6, 6));
        CraftingHelpers.addSawmillLogToPlankRecipe(new ItemStack(ModBlocks.nmLogs.blockID, 1, 3), new ItemStack(ModBlocks.dreamPlanks.blockID, 6, 7));
    }
    private static void addPulverizerRecipes()
    {
        ItemStack woodchips = ItemRegistry.getItem("woodchips", 1);
        
        CraftingManagers.pulverizerManager.addRecipe(160, new ItemStack(ModBlocks.dreamLogs.blockID, 1, 0), woodchips);
        CraftingManagers.pulverizerManager.addRecipe(160, new ItemStack(ModBlocks.dreamLogs.blockID, 1, 1), woodchips);
        CraftingManagers.pulverizerManager.addRecipe(160, new ItemStack(ModBlocks.dreamLogs.blockID, 1, 2), woodchips);
        CraftingManagers.pulverizerManager.addRecipe(160, new ItemStack(ModBlocks.dreamLogs.blockID, 1, 3), woodchips);
        CraftingManagers.pulverizerManager.addRecipe(160, new ItemStack(ModBlocks.nmLogs.blockID, 1, 0), woodchips);
        CraftingManagers.pulverizerManager.addRecipe(160, new ItemStack(ModBlocks.nmLogs.blockID, 1, 1), woodchips);
        CraftingManagers.pulverizerManager.addRecipe(160, new ItemStack(ModBlocks.nmLogs.blockID, 1, 2), woodchips);
        CraftingManagers.pulverizerManager.addRecipe(160, new ItemStack(ModBlocks.nmLogs.blockID, 1, 3), woodchips);
        
        //TODO pulverizer recipes for Ores / Gems
    }
}
