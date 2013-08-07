package dreamLand.utils.handlers;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import cpw.mods.fml.common.registry.GameRegistry;
import dreamLand.blocks.ModBlocks;
import dreamLand.items.ModItems;

public class RecipeHandler {

    public static void add() {
        // Creates Shaped Recipes
        addShapedRecipes();

        // Creates Shapeless Recipes
        addShapelessRecipes();
        
        // Smelting Recipes
        addSmeltingRecipes();
    }

    private static void addShapedRecipes() {
        GameRegistry.addRecipe(new ItemStack(ModBlocks.portalObsidian), new Object[] { "XXX", "XOX", "XXX", 'X', Block.obsidian, 'O', Block.blockDiamond });

        GameRegistry.addRecipe(new ItemStack(ModItems.itemlighter), new Object[] { "  X", " X ", "X  ", 'X', Item.emerald });

        GameRegistry.addRecipe(new ItemStack(ModItems.itemSwordPhantomIron), new Object[] { " O ", " O ", " X ", 'X', Item.emerald, 'O', Item.diamond });
        // PLanks to Fences
        GameRegistry.addRecipe(new ItemStack(ModBlocks.dreamFence,4,0), new Object[] { "XXX", "X X", 'X', new ItemStack(ModBlocks.dreamPlanks,1,0)});
        GameRegistry.addRecipe(new ItemStack(ModBlocks.dreamFence,4,1), new Object[] { "XXX", "X X", 'X', new ItemStack(ModBlocks.dreamPlanks,1,1)});
        GameRegistry.addRecipe(new ItemStack(ModBlocks.dreamFence,4,2), new Object[] { "XXX", "X X", 'X', new ItemStack(ModBlocks.dreamPlanks,1,2)});
        GameRegistry.addRecipe(new ItemStack(ModBlocks.dreamFence,4,3), new Object[] { "XXX", "X X", 'X', new ItemStack(ModBlocks.dreamPlanks,1,3)});
        GameRegistry.addRecipe(new ItemStack(ModBlocks.dreamFence,4,4), new Object[] { "XXX", "X X", 'X', new ItemStack(ModBlocks.dreamPlanks,1,4)});
        GameRegistry.addRecipe(new ItemStack(ModBlocks.dreamFence,4,5), new Object[] { "XXX", "X X", 'X', new ItemStack(ModBlocks.dreamPlanks,1,5)});
        GameRegistry.addRecipe(new ItemStack(ModBlocks.dreamFence,4,6), new Object[] { "XXX", "X X", 'X', new ItemStack(ModBlocks.dreamPlanks,1,6)});
        GameRegistry.addRecipe(new ItemStack(ModBlocks.dreamFence,4,7), new Object[] { "XXX", "X X", 'X', new ItemStack(ModBlocks.dreamPlanks,1,7)});

        // Stones to walls
        GameRegistry.addRecipe(new ItemStack(ModBlocks.dreamWall,6,0), new Object[] { "XXX", "XXX", 'X', new ItemStack(ModBlocks.dreamCobble,1,0)});
        GameRegistry.addRecipe(new ItemStack(ModBlocks.dreamWall,6,1), new Object[] { "XXX", "XXX", 'X', new ItemStack(ModBlocks.dreamStones,1,2)});
        GameRegistry.addRecipe(new ItemStack(ModBlocks.dreamWall,6,2), new Object[] { "XXX", "XXX", 'X', new ItemStack(ModBlocks.dreamStones,1,3)});
        GameRegistry.addRecipe(new ItemStack(ModBlocks.dreamWall,6,3), new Object[] { "XXX", "XXX", 'X', new ItemStack(ModBlocks.dreamStones,1,4)});
        GameRegistry.addRecipe(new ItemStack(ModBlocks.dreamWall,6,4), new Object[] { "XXX", "XXX", 'X', new ItemStack(ModBlocks.nmCobble,1,0)});
        GameRegistry.addRecipe(new ItemStack(ModBlocks.dreamWall,6,5), new Object[] { "XXX", "XXX", 'X', new ItemStack(ModBlocks.dreamStones,1,6)});
        GameRegistry.addRecipe(new ItemStack(ModBlocks.dreamWall,6,6), new Object[] { "XXX", "XXX", 'X', new ItemStack(ModBlocks.dreamStones,1,7)});
        GameRegistry.addRecipe(new ItemStack(ModBlocks.dreamWall,6,7), new Object[] { "XXX", "XXX", 'X', new ItemStack(ModBlocks.dreamStones,1,0)});
        GameRegistry.addRecipe(new ItemStack(ModBlocks.dreamWall,6,8), new Object[] { "XXX", "XXX", 'X', new ItemStack(ModBlocks.dreamStones,1,1)});
        GameRegistry.addRecipe(new ItemStack(ModBlocks.dreamWall,6,9), new Object[] { "XXX", "XXX", 'X', new ItemStack(ModBlocks.dreamStones,1,9)});
        GameRegistry.addRecipe(new ItemStack(ModBlocks.dreamWall,6,10), new Object[] { "XXX", "XXX", 'X', new ItemStack(ModBlocks.dreamStones,1,10)});
        
        // Stones to Slabs
        GameRegistry.addRecipe(new ItemStack(ModBlocks.dreamStoneSlabs,6,0), new Object[] { "XXX", 'X', new ItemStack(ModBlocks.dreamCobble,1,0)});
        
        // Flowers to Dyes
        GameRegistry.addRecipe(new ItemStack(Item.dyePowder,2,15), new Object[] { "XX", 'X', new ItemStack(ModBlocks.dreamFlowers,1,0 )});// White - bonemeal
        GameRegistry.addRecipe(new ItemStack(Item.dyePowder,2,14), new Object[] { "XX", 'X', new ItemStack(ModBlocks.dreamFlowers,1,1 )});// orange
        GameRegistry.addRecipe(new ItemStack(Item.dyePowder,2,13), new Object[] { "XX", 'X', new ItemStack(ModBlocks.dreamFlowers,1,2 )});// magenta
        GameRegistry.addRecipe(new ItemStack(Item.dyePowder,2,12), new Object[] { "XX", 'X', new ItemStack(ModBlocks.dreamFlowers,1,3 )});// light blue
        GameRegistry.addRecipe(new ItemStack(Item.dyePowder,2,11), new Object[] { "XX", 'X', new ItemStack(ModBlocks.dreamFlowers,1,4 )});// yellow
        GameRegistry.addRecipe(new ItemStack(Item.dyePowder,2,10), new Object[] { "XX", 'X', new ItemStack(ModBlocks.dreamFlowers,1,5 )});// lime
        GameRegistry.addRecipe(new ItemStack(Item.dyePowder,2,9), new Object[] { "XX", 'X', new ItemStack(ModBlocks.dreamFlowers,1,6 )});// pink
        GameRegistry.addRecipe(new ItemStack(Item.dyePowder,2,8), new Object[] { "XX", 'X', new ItemStack(ModBlocks.dreamFlowers,1,7 )});// gray
        GameRegistry.addRecipe(new ItemStack(Item.dyePowder,2,7), new Object[] { "XX", 'X', new ItemStack(ModBlocks.dreamFlowers,1,8 )});//  silver
        GameRegistry.addRecipe(new ItemStack(Item.dyePowder,2,6), new Object[] { "XX", 'X', new ItemStack(ModBlocks.dreamFlowers,1,9 )});// cyan
        GameRegistry.addRecipe(new ItemStack(Item.dyePowder,2,5), new Object[] { "XX", 'X', new ItemStack(ModBlocks.dreamFlowers,1,10 )});// purple
        GameRegistry.addRecipe(new ItemStack(Item.dyePowder,2,4), new Object[] { "XX", 'X', new ItemStack(ModBlocks.dreamFlowers,1,11 )});// blue - lapis
        GameRegistry.addRecipe(new ItemStack(Item.dyePowder,2,3), new Object[] { "XX", 'X', new ItemStack(ModBlocks.dreamFlowers,1,12 )});// brown - cocoa
        GameRegistry.addRecipe(new ItemStack(Item.dyePowder,2,2), new Object[] { "XX", 'X', new ItemStack(ModBlocks.dreamFlowers,1,13 )});// green
        GameRegistry.addRecipe(new ItemStack(Item.dyePowder,2,1), new Object[] { "XX", 'X', new ItemStack(ModBlocks.dreamFlowers,1,14)});// red
        GameRegistry.addRecipe(new ItemStack(Item.dyePowder,2,0), new Object[] { "XX", 'X', new ItemStack(ModBlocks.dreamFlowers,1,15 )});// Black - inksacs
    }

    private static void addShapelessRecipes() {
        //Logs to Planks
        GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.dreamPlanks, 4, 0), new Object[] {new ItemStack(ModBlocks.dreamLogs, 1, 0)});
        GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.dreamPlanks, 4, 2), new Object[] {new ItemStack(ModBlocks.dreamLogs, 1, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.dreamPlanks, 4, 4), new Object[] {new ItemStack(ModBlocks.dreamLogs, 1, 2)});
        GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.dreamPlanks, 4, 6), new Object[] {new ItemStack(ModBlocks.dreamLogs, 1, 3)});
        GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.dreamPlanks, 4, 1), new Object[] {new ItemStack(ModBlocks.nmLogs, 1, 0)});
        GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.dreamPlanks, 4, 3), new Object[] {new ItemStack(ModBlocks.nmLogs, 1, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.dreamPlanks, 4, 5), new Object[] {new ItemStack(ModBlocks.nmLogs, 1, 2)});
        GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.dreamPlanks, 4, 7), new Object[] {new ItemStack(ModBlocks.nmLogs, 1, 3)});

    }
    private static void addSmeltingRecipes(){
        // Cobble to Smooth Stone
        GameRegistry.addSmelting(ModBlocks.dreamCobble.blockID, new ItemStack(ModBlocks.dreamStone), 0.1f);
        GameRegistry.addSmelting(ModBlocks.nmCobble.blockID, new ItemStack(ModBlocks.nmStone), 0.1f);
        // Ores to ingots
        FurnaceRecipes.smelting().addSmelting(ModBlocks.oreBlocks.blockID, 0, new ItemStack(ModItems.itemlighter, 1, 0), 0.1f);
        FurnaceRecipes.smelting().addSmelting(ModBlocks.oreBlocks.blockID, 8, new ItemStack(ModItems.itemlighter, 1, 0), 0.1f);
    }
}
