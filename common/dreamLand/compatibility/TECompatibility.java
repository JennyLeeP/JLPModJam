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
    }
    private static void addPulverizerRecipes()
    {
        ItemStack woodchips = ItemRegistry.getItem("woodchips", 1);
        
        CraftingManagers.pulverizerManager.addRecipe(160, new ItemStack(ModBlocks.dreamLogs.blockID, 1, 0), woodchips);
    }
}
