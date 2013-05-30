package dreamLand.utils;

import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import dreamLand.blocks.ModBlocks;
import dreamLand.entity.EntityNMCreeper;
import dreamLand.entity.EntityPhoenix;
import dreamLand.entity.EntitySonicCreeper;
import dreamLand.items.ItemBlockDreamWall;
import dreamLand.items.ItemDreamLeaves;
import dreamLand.items.ItemDreamPlanksBlock;
import dreamLand.items.ItemDreamSaplingBlock;
import dreamLand.items.ItemDreamTrees;
import dreamLand.items.ItemNMTrees;
import dreamLand.items.ModItems;
import dreamLand.utils.handlers.DreamLandFuelHandler;
import dreamLand.utils.handlers.RecipeHandler;
import dreamLand.world.DreamLandWorldProvider;
import dreamLand.world.NightMareWorldProvider;
import dreamLand.world.biome.ModBiomes;

public class Registry {

    public static void register() {

        registerBlocks();

        registerItems();
        
        registerFuels();
        
        registerMobs();

        registerDimension();
        
        registerEvents();

        RecipeHandler.add();
    }

    private static void registerBlocks() {

        GameRegistry.registerBlock(ModBlocks.portalObsidian, "Obsidiatal");

        GameRegistry.registerBlock(ModBlocks.portal, "DreamLand_Portal");

        GameRegistry.registerBlock(ModBlocks.dreamStone, "Dream_Stone");

        GameRegistry.registerBlock(ModBlocks.dreamQuartz, "Dream_Quartz");

        GameRegistry.registerBlock(ModBlocks.dreamDirt, "Dream_Dirt");

        GameRegistry.registerBlock(ModBlocks.dreamGravel, "dreamGravel");

        GameRegistry.registerBlock(ModBlocks.dreamGrass, "Dream_Grass");
        
        GameRegistry.registerBlock(ModBlocks.dreamSand, "Dream_Sand");

        GameRegistry.registerBlock(ModBlocks.oreLucidity, "OreLucidity");

        GameRegistry.registerBlock(ModBlocks.oreStarcesium, "OreStarCesium");
        
        GameRegistry.registerBlock(ModBlocks.dreamCobble, "Dream_Cobble");
        
        GameRegistry.registerBlock(ModBlocks.dreamStairs, "Dream_Stairs");

        GameRegistry.registerBlock(ModBlocks.dreamLogs, ItemDreamTrees.class, "Dream_Logs");
        
        GameRegistry.registerBlock(ModBlocks.nmLogs, ItemNMTrees.class, "NM_Logs");
        
        GameRegistry.registerBlock(ModBlocks.dreamPlanks, ItemDreamPlanksBlock.class,"Dream_Planks");
        
        GameRegistry.registerBlock(ModBlocks.dreamLeaves, ItemDreamLeaves.class, "Dream_Leaves");
        
        GameRegistry.registerBlock(ModBlocks.dreamSaplings, ItemDreamSaplingBlock.class,"Dream_Saplings");
        
        GameRegistry.registerBlock(ModBlocks.dreamWall, ItemBlockDreamWall.class, "Dream_Wall");
        
        GameRegistry.registerBlock(ModBlocks.nmPortal, "NightMare_Portal");
                
        GameRegistry.registerBlock(ModBlocks.nmGrass, "NM_Grass");
        
        GameRegistry.registerBlock(ModBlocks.nmDirt, "NM_Dirt");
        
        GameRegistry.registerBlock(ModBlocks.nmStone, "NM_Stone");
        
        GameRegistry.registerBlock(ModBlocks.nmGravel, "NM_Gravel");
        
        GameRegistry.registerBlock(ModBlocks.nmSand, "NM_Sand");
        
        GameRegistry.registerBlock(ModBlocks.nmCobble, "NM_Cobble");
        
        GameRegistry.registerBlock(ModBlocks.nmStairs, "NM_Stairs");
        
        GameRegistry.registerBlock(ModBlocks.bloodCobble, "Blood_Cobble");
        
        GameRegistry.registerBlock(ModBlocks.bloodStairs, "Blood_Stairs");
        
        GameRegistry.registerBlock(ModBlocks.oreMethaneClathrate, "Ore_Methane_Clathrate");
    }
/*
 * Register Items
 */
    private static void registerItems() {

        GameRegistry.registerItem(ModItems.itemlighter, "Boom Stick");

        GameRegistry.registerItem(ModItems.itemSwordPhantomIron, "Phantom Sword");

        GameRegistry.registerItem(ModItems.itemLucidity, "Lucidity");
        
        GameRegistry.registerItem(ModItems.itemMethaneClathrate, "Methane Clathrate");

        //GameRegistry.registerItem(ModItems.itemSparklingSapling, "Sparking Sapling");
    }
/*
 * Register Fuels
 */
    private static void registerFuels(){
        GameRegistry.registerFuelHandler(new DreamLandFuelHandler());
    }
    private static void registerMobs()
    {
    	//************SONIC CREEPER ***********
    	int entityID;
		entityID = EntityRegistry.findGlobalUniqueEntityId();
		EntityRegistry.registerGlobalEntityID(EntitySonicCreeper.class, "SonicCreeper", entityID);
		EntityRegistry.addSpawn(EntitySonicCreeper.class, 3, 1, 2, EnumCreatureType.creature, ModBiomes.dreamIsland);
		EntityList.addMapping(EntitySonicCreeper.class, "SonicCreeper", entityID, 0x6E4875, 0x969696);
    	//************NightMare Creeper *******
		entityID = EntityRegistry.findGlobalUniqueEntityId();
		EntityRegistry.registerGlobalEntityID(EntityNMCreeper.class, "NightMareCreeper", entityID);
		EntityRegistry.addSpawn(EntityNMCreeper.class, 3, 1, 2, EnumCreatureType.monster, ModBiomes.nightMare);
		EntityList.addMapping(EntityNMCreeper.class, "NightMareCreeper", entityID, 0x262425, 0x780510);
		//*************Ibong Adarna************
		
		
		
		//************Phoenix******************
		entityID = EntityRegistry.findGlobalUniqueEntityId();
		EntityRegistry.registerGlobalEntityID(EntityPhoenix.class, "Phoenix", entityID);
		EntityList.addMapping(EntityPhoenix.class, "Phoenix", entityID, 0x780510, 0xD16B04);
		//************Fire_Fish****************
		
		
    	
    }
    private static void registerDimension() {

        DimensionManager.registerProviderType(Config.dimensionID, DreamLandWorldProvider.class, true);//boolean = to keep Dim loaded or not
       
        DimensionManager.registerDimension(Config.dimensionID, Config.dimensionID);
        
        DimensionManager.registerProviderType(Config.dimensionNMID, NightMareWorldProvider.class, true);//boolean = to keep Dim loaded or not
        
        DimensionManager.registerDimension(Config.dimensionNMID, Config.dimensionNMID);
    }
    private static void registerEvents(){
        MinecraftForge.EVENT_BUS.register(new EventHookContainerClass());
    }
}