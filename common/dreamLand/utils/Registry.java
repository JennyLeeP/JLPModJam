package dreamLand.utils;

import net.minecraft.entity.EntityList;
import net.minecraftforge.common.DimensionManager;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import dreamLand.blocks.ItemBlockDreamWall;
import dreamLand.blocks.ModBlocks;
import dreamLand.entity.EntityNMCreeper;
import dreamLand.entity.EntityPhoenix;
import dreamLand.entity.EntitySonicCreeper;
import dreamLand.items.ModItems;
import dreamLand.utils.handlers.RecipeHandler;
import dreamLand.world.DreamLandWorldProvider;

public class Registry {

    public static void register() {

        registerBlocks();

        registerItems();
        
        registerMobs();

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
        
        GameRegistry.registerBlock(ModBlocks.dreamSand, "Dream_Sand");

        GameRegistry.registerBlock(ModBlocks.oreLucidity, "OreLucidity");

        GameRegistry.registerBlock(ModBlocks.oreStarcesium, "OreStarCesium");
        
        GameRegistry.registerBlock(ModBlocks.dreamCobble, "Dream_Cobble");
        
        GameRegistry.registerBlock(ModBlocks.dreamStairs, "Dream_Stairs");

        GameRegistry.registerBlock(ModBlocks.dreamLogs, "Dream_Logs");
        
        GameRegistry.registerBlock(ModBlocks.dreamPlanks, "Dream_Planks");
        
        GameRegistry.registerBlock(ModBlocks.dreamLeaves, "Dream_Leaves");
        
        GameRegistry.registerBlock(ModBlocks.dreamSaplings, "Dream_Saplings");
        
        GameRegistry.registerBlock(ModBlocks.dreamWall, ItemBlockDreamWall.class, "Dream_Wall");
        
        GameRegistry.registerBlock(ModBlocks.nmGrass, "NM_Grass");
        
        GameRegistry.registerBlock(ModBlocks.nmDirt, "NM_Dirt");
        
        GameRegistry.registerBlock(ModBlocks.nmStone, "NM_Stone");
        
        GameRegistry.registerBlock(ModBlocks.nmGravel, "NM_Gravel");
        
        GameRegistry.registerBlock(ModBlocks.nmSand, "NM_Sand");
        
        GameRegistry.registerBlock(ModBlocks.nmCobble, "NM_Cobble");
        
        GameRegistry.registerBlock(ModBlocks.nmStairs, "NM_Stairs");
    }

    private static void registerItems() {

        GameRegistry.registerItem(ModItems.itemlighter, "Boom Stick");

        GameRegistry.registerItem(ModItems.itemSwordPhantomIron, "Phantom Sword");

        GameRegistry.registerItem(ModItems.itemLucidity, "Lucidity");

        GameRegistry.registerItem(ModItems.itemSparklingSapling, "Sparking Sapling");
    }

    private static void registerMobs()
    {
    	//************SONIC CREEPER ***********
    	int entityID;
		entityID = EntityRegistry.findGlobalUniqueEntityId();
		EntityRegistry.registerGlobalEntityID(EntitySonicCreeper.class, "SonicCreeper", entityID);
		EntityList.addMapping(EntitySonicCreeper.class, "SonicCreeper", entityID, 0x6E4875, 0x969696);
    	//************NightMare Creeper *******
		entityID = EntityRegistry.findGlobalUniqueEntityId();
		EntityRegistry.registerGlobalEntityID(EntityNMCreeper.class, "NightMareCreeper", entityID);
		EntityList.addMapping(EntityNMCreeper.class, "NightMareCreeper", entityID, 0x262425, 0x780510);
		//*************Ibong Adarna************
		
		
		
		//************Phoenix******************
		entityID = EntityRegistry.findGlobalUniqueEntityId();
		EntityRegistry.registerGlobalEntityID(EntityPhoenix.class, "Phoenix", entityID);
		EntityList.addMapping(EntityPhoenix.class, "Phoenix", entityID, 0x780510, 0xD16B04);
		
		
		
    	
    }
    private static void registerDimension() {

        DimensionManager.registerProviderType(Config.dimensionID, DreamLandWorldProvider.class, true);//boolean = to keep Dim loaded or not
       
        DimensionManager.registerDimension(Config.dimensionID, Config.dimensionID);
    }
}