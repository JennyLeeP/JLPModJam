package dreamLand.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import dreamLand.blocks.BlockDreamStoneSlabs.SlabType;
import dreamLand.utils.Reference;
import dreamLand.utils.Config;

public class ModBlocks {

    public static Block portalObsidian;
    public static Block dreamStone;
    public static Block dreamStones;
    public static Block dreamDirt;
    public static Block dreamGrass;
    public static Block dreamCobble;
    public static Block dreamWall;
    public static Block nmStone;
    public static Block nmDirt;
    public static Block nmGrass;
    public static Block nmCobble;
    public static Block oreLucidity;
    public static Block oreBlocks;
    public static Block oreMethaneClathrate;
    public static Block dreamStairs;
    public static Block nmStairs;
    public static Block dreamLogs;
    public static Block nmLogs;
    public static Block dreamPlanks;
    public static Block dreamLeaves;
    public static Block dreamSaplings;
    public static Block bloodStairs;
    public static Block dreamFalling;
    public static Block dreamFence;
    public static Block dreamWoodSlabs;
    public static Block dreamStoneSlabs;
    public static Block dreamWoodDBLSlabs;
    public static Block dreamStoneDBLSlabs;
    public static Block dreamFlowers;
    public static Block chickenAlter;
    
    public static BlockPortalDreamLand portal;
    public static BlockPortalNightMare nmPortal;

    public static void init() {

        // Portal
        portal = (BlockPortalDreamLand) new BlockPortalDreamLand(Config.DreamLandPortalID).setUnlocalizedName(Reference.portal);
      
        nmPortal = (BlockPortalNightMare) new BlockPortalNightMare(Config.NightMarePortalID).setUnlocalizedName(Reference.nmPortal);

        // Blocks
        portalObsidian = new BlockDreamLand(Config.PortalObsidianID).setUnlocalizedName(Reference.portalObsidian).setHardness(3.0F).setLightValue(1.0F).setResistance(2000.0F);
      
        dreamStone = new BlockDreamLand(Config.DreamStoneID, Config.DreamCobbleID,0).setUnlocalizedName(Reference.dreamStone).setHardness(1.5F).setResistance(10.0F);
       
        dreamStones = new BlockDreamStone(Config.DreamStonesID).setUnlocalizedName(Reference.dreamStones);
     
        dreamDirt = new BlockDreamLand(Config.DreamDirtID).setUnlocalizedName(Reference.dreamDirt).setStepSound(Block.soundGrassFootstep).setHardness(0.6F);
      
        dreamFalling = new BlockDreamFalling(Config.DreamFallingID).setUnlocalizedName(Reference.dreamFalling);
     
        dreamGrass = new BlockDreamGrass(Config.DreamGrassID).setHardness(0.6F).setStepSound(Block.soundGrassFootstep).setUnlocalizedName(Reference.dreamGrass);
      
        dreamCobble = new BlockDreamLand(Config.DreamCobbleID).setUnlocalizedName(Reference.dreamCobble).setHardness(1.5F).setResistance(10.0F);
      
        nmStone = new BlockDreamLand(Config.NMStoneID, Config.NMCobbleID,2).setUnlocalizedName(Reference.nmStone).setHardness(1.5F).setResistance(10.0F);
       
        nmDirt = new BlockDreamLand(Config.NMDirtID).setUnlocalizedName(Reference.nmDirt).setStepSound(Block.soundGrassFootstep).setHardness(0.6F);
      
        nmGrass = new BlockNMGrass(Config.NMGrassID).setHardness(0.6F).setStepSound(Block.soundGrassFootstep).setUnlocalizedName(Reference.nmGrass); 
      
        nmCobble = new BlockDreamLand(Config.NMCobbleID).setUnlocalizedName(Reference.nmCobble).setHardness(2.0F).setResistance(10.0F);
        
        //Stairs and Walls
        dreamStairs = (new BlockDreamStairs(Config.DreamStairsID, dreamCobble, 0)).setUnlocalizedName(Reference.dreamStairs).setHardness(2.0F).setStepSound(Block.soundStoneFootstep);
       
        nmStairs = (new BlockDreamStairs(Config.NMStairsID, nmCobble, 0)).setUnlocalizedName(Reference.nmStairs).setHardness(2.0F).setStepSound(Block.soundStoneFootstep);
       
        bloodStairs = (new BlockDreamStairs(Config.BloodStairsID, dreamStones, 0)).setUnlocalizedName(Reference.bloodStairs).setHardness(2.0F).setStepSound(Block.soundStoneFootstep);
       
        dreamWall = (new BlockDreamWall(Config.DreamWallID, dreamStones)).setUnlocalizedName(Reference.dreamWall).setHardness(0.3F);
        
        // Slabs and Fences
        dreamFence = (new BlockDreamFence(Config.DreamFenceID, "wood", Material.wood)).setUnlocalizedName(Reference.dreamFence);
       
        dreamWoodSlabs = (new BlockDreamStoneSlabs(Config.DreamWoodSlabsID, false, Material.wood, SlabType.WOOD)).setUnlocalizedName(Reference.dreamWoodSlabs).setHardness(2.0F).setResistance(5.0F);
       
        dreamStoneSlabs = (new BlockDreamStoneSlabs(Config.DreamStoneSlabsID, false, Material.rock, SlabType.STONE)).setUnlocalizedName(Reference.dreamStoneSlabs).setHardness(2.0F).setResistance(5.0F);
      
        dreamWoodDBLSlabs = (new BlockDreamStoneSlabs(Config.DreamWoodDBLSlabsID, true, Material.wood, SlabType.WOOD)).setUnlocalizedName(Reference.dreamWoodDBLSlabs).setHardness(2.0F).setResistance(5.0F);
       
        dreamStoneDBLSlabs = (new BlockDreamStoneSlabs(Config.DreamStoneDBLSlabsID, true, Material.rock, SlabType.STONE)).setUnlocalizedName(Reference.dreamStoneDBLSlabs).setHardness(2.0F).setResistance(5.0F);
        
        //Trees and leaves
        dreamLogs = new BlockDreamLogs(Config.DreamLogsID).setHardness(2.0F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName(Reference.dreamLogs);
       
        nmLogs = new BlockNMLogs(Config.NMLogsID).setHardness(2.0F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName(Reference.nmLogs);
       
        dreamPlanks = new BlockDreamPlanks(Config.DreamPlanksID).setUnlocalizedName(Reference.dreamPlanks);
       
        dreamLeaves = new BlockDreamLeaves(Config.DreamLeavesID).setUnlocalizedName(Reference.dreamLeaves).setLightOpacity(1);
      
        dreamSaplings = new BlockDreamSaplings(Config.DreamSaplingsID).setHardness(0.0F).setStepSound(Block.soundGrassFootstep).setUnlocalizedName(Reference.dreamSaplings);
        
        // Ores
        oreMethaneClathrate = new BlockDreamMethane(Config.OreMethaneClathrateID, Config.itemMethaneClathrateID).setUnlocalizedName(Reference.oreMethaneClathrate).setHardness(1.0F).setStepSound(Block.soundGravelFootstep);
       
        oreLucidity = new BlockDreamLand(Config.OreLucidityID, Config.itemLucidityID,0).setUnlocalizedName(Reference.oreLucidity).setHardness(2.0F);
      
        oreBlocks = new BlockDreamOres(Config.DreamOresID, 0, 0).setUnlocalizedName(Reference.blockDreamOres);
       
        // Flowers and Plants
        dreamFlowers = new BlockDreamFlowers(Config.DreamFlowersID).setUnlocalizedName(Reference.dreamFlowers);
        // Custom Render Blocks
        chickenAlter = new BlockChickenAlter(Config.ChickenAlterID).setUnlocalizedName(Reference.chickenAlter);
        //crystalPedestal = new BlockPedestal(Config.PedestalID).setUnlocalizedName(Archive.pedestal);
    }
}