package dreamLand.utils.hadlers;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;
import dreamLand.blocks.ModBlocks;
import dreamLand.items.ModItems;

public class RecipeHandler {

    public static void add() {
        // Creates Shaped Recipes
        addShapedRecipes();
        
        // Creates Shapeless Recipes
        addShapelessRecipes();
    }

    private static void addShapedRecipes() {
        GameRegistry.addRecipe(new ItemStack(ModBlocks.portalObsidian), new Object[] { "XXX",
                "XOX", "XXX", 'X', Block.obsidian, 'O', Block.blockDiamond });
        
        GameRegistry.addRecipe(new ItemStack(ModItems.itemlighter), new Object[] { "  X", " X ",
                "X  ", 'X', Item.emerald });
        
        GameRegistry.addRecipe(new ItemStack(ModItems.itemSwordPhantomIron), new Object[] { " O ",
                " O ", " X ", 'X', Item.emerald, 'O', Item.diamond });
    }
    
    private static void addShapelessRecipes() {}
}
