package dreamLand.compatibility;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraftforge.liquids.LiquidStack;
import net.minecraftforge.oredict.OreDictionary;
import dreamLand.blocks.ModBlocks;
import dreamLand.world.biome.ModBiomes;
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
        addClimateInfo();
        //addFermenterRecipes();
        //addFlowers();
        addFarmRecipes();
        addBlocksToManager();
        addBlocksToBackpacks();
    }
    private static void addClimateInfo()
    {
        //Normal Bees
        EnumTemperature.normalBiomeIds.add(ModBiomes.dreamIsland.biomeID);
        EnumHumidity.normalBiomeIds.add(ModBiomes.dreamIsland.biomeID);
        //Hell Bees
        EnumTemperature.hotBiomeIds.add(ModBiomes.nightMare.biomeID);
        EnumHumidity.aridBiomeIds.add(ModBiomes.nightMare.biomeID);
    }
    private static void addFarmRecipes()
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
        // Digger's Backpack
        // Forester's Backpack
        BackpackManager.backpackItems[FORESTER].add(new ItemStack(ModBlocks.dreamLogs, 1, OreDictionary.WILDCARD_VALUE));
        BackpackManager.backpackItems[FORESTER].add(new ItemStack(ModBlocks.nmLogs, 1, OreDictionary.WILDCARD_VALUE));
        BackpackManager.backpackItems[FORESTER].add(new ItemStack(ModBlocks.dreamLeaves, 1, OreDictionary.WILDCARD_VALUE));
        BackpackManager.backpackItems[FORESTER].add(new ItemStack(ModBlocks.dreamSaplings, 1, OreDictionary.WILDCARD_VALUE));
    }
}
