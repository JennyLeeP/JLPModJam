package dreamLand.utils;

import net.minecraftforge.common.DimensionManager;
import cpw.mods.fml.common.registry.GameRegistry;
import dreamLand.blocks.ModBlocks;
import dreamLand.items.ModItems;
import dreamLand.utils.hadlers.RecipeHandler;
import dreamLand.world.DreamLandWorldProvider;

public class Registry {

    public static void register() {

        registerBlocks();

        registerItems();

        registerDimension();

        RecipeHandler.add();
    }

    private static void registerBlocks() {

        GameRegistry.registerBlock(ModBlocks.portalObsidian, "Obsidiatal");

        GameRegistry.registerBlock(ModBlocks.portal, "DreamLand_Portal");

        GameRegistry.registerBlock(ModBlocks.dreamStone, "Dream_Stone");

        GameRegistry.registerBlock(ModBlocks.dreamQuartz, "Dream_Quartz");

        GameRegistry.registerBlock(ModBlocks.dreamDirt, "Dream_Dirt");

        GameRegistry.registerBlock(ModBlocks.dreamGravel, "CyaGravel");

        GameRegistry.registerBlock(ModBlocks.dreamGrass, "Dream_Grass");

        GameRegistry.registerBlock(ModBlocks.oreLucidity, "OreLucidity");

        GameRegistry.registerBlock(ModBlocks.oreStarcesium, "OreStarCesium");
    }

    private static void registerItems() {

        GameRegistry.registerItem(ModItems.itemlighter, "Boom Stick");

        GameRegistry.registerItem(ModItems.itemSwordPhantomIron, "Phantom Sword");

        GameRegistry.registerItem(ModItems.itemLucidity, "Lucidity");

        GameRegistry.registerItem(ModItems.itemSparklingSapling, "Sparking Sapling");
    }

    private static void registerDimension() {

        DimensionManager.registerProviderType(Config.dimensionID, DreamLandWorldProvider.class,
                true);

        DimensionManager.registerDimension(Config.dimensionID, Config.dimensionID);
    }
}