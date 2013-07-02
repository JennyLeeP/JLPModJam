package dreamLand.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import dreamLand.utils.Archive;
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
    public static Block oreStarcesium;
    public static Block dreamStairs;
    public static Block nmStairs;
    public static Block dreamLogs;
    public static Block nmLogs;
    public static Block dreamPlanks;
    public static Block dreamLeaves;
    public static Block dreamSaplings;
    public static Block oreMethaneClathrate;
    public static Block bloodStairs;
    public static Block dreamFalling;
    public static Block dreamFence;
    
    public static BlockPortalDreamLand portal;
    public static BlockPortalNightMare nmPortal;

    public static void init() {

        // Portal
        portal = (BlockPortalDreamLand) new BlockPortalDreamLand(Config.DreamLandPortalID).setUnlocalizedName(Archive.portal);
        nmPortal = (BlockPortalNightMare) new BlockPortalNightMare(Config.NightMarePortalID).setUnlocalizedName(Archive.nmPortal);

        // Blocks
        portalObsidian = new BlockDreamLand(Config.PortalObsidianID).setUnlocalizedName(Archive.portalObsidian).setHardness(3.0F).setLightValue(1.0F).setResistance(2000.0F);

        dreamStone = new BlockDreamLand(Config.DreamStoneID, Config.DreamCobbleID,0).setUnlocalizedName(Archive.dreamStone).setHardness(1.5F).setResistance(10.0F);

        dreamStones = new BlockDreamStone(Config.DreamStonesID).setUnlocalizedName(Archive.dreamStones);

        dreamDirt = new BlockDreamLand(Config.DreamDirtID).setUnlocalizedName(Archive.dreamDirt).setStepSound(Block.soundGrassFootstep).setHardness(0.6F);

        dreamFalling = new BlockDreamFalling(Config.DreamFallingID).setUnlocalizedName(Archive.dreamFalling).setHardness(0.6F).setStepSound(Block.soundGravelFootstep);

        dreamGrass = new BlockDreamGrass(Config.DreamGrassID).setHardness(0.6F).setStepSound(Block.soundGrassFootstep).setUnlocalizedName(Archive.dreamGrass);
        
        
        dreamCobble = new BlockDreamLand(Config.DreamCobbleID).setUnlocalizedName(Archive.dreamCobble).setHardness(1.5F).setResistance(10.0F);
        
        nmStone = new BlockDreamLand(Config.NMStoneID, Config.NMCobbleID,2).setUnlocalizedName(Archive.nmStone).setHardness(1.5F).setResistance(10.0F);

        nmDirt = new BlockDreamLand(Config.NMDirtID).setUnlocalizedName(Archive.nmDirt).setStepSound(Block.soundGrassFootstep).setHardness(0.6F);

        nmGrass = new BlockNMGrass(Config.NMGrassID).setHardness(0.6F).setStepSound(Block.soundGrassFootstep).setUnlocalizedName(Archive.nmGrass);
        
        nmCobble = new BlockDreamLand(Config.NMCobbleID).setUnlocalizedName(Archive.nmCobble).setHardness(2.0F).setResistance(10.0F);
        
        //Stairs and Walls
        dreamStairs = (new BlockDreamStairs(Config.DreamStairsID, dreamCobble, 0)).setUnlocalizedName(Archive.dreamStairs).setHardness(2.0F).setStepSound(Block.soundStoneFootstep);
        
        nmStairs = (new BlockDreamStairs(Config.NMStairsID, nmCobble, 0)).setUnlocalizedName(Archive.nmStairs).setHardness(2.0F).setStepSound(Block.soundStoneFootstep);
        
        bloodStairs = (new BlockDreamStairs(Config.BloodStairsID, dreamStones, 0)).setUnlocalizedName(Archive.bloodStairs).setHardness(2.0F).setStepSound(Block.soundStoneFootstep);
        
        dreamWall = (new BlockDreamWall(Config.DreamWallID, dreamStones)).setUnlocalizedName(Archive.dreamWall).setHardness(0.3F);
        
        // Slabs and Fences
        dreamFence = (new BlockDreamFence(Config.DreamFenceID, "wood", Material.wood)).setUnlocalizedName(Archive.dreamFence);
        //dreamWoodSlabs = (new BlockDreamSlabs(Config.DreamFenceID, "wood", Material.wood)).setUnlocalizedName(Archive.dreamFence).setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundWoodFootstep);
        //Trees and leaves
        dreamLogs = new BlockDreamLogs(Config.DreamLogsID).setHardness(2.0F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName(Archive.dreamLogs);
        
        nmLogs = new BlockNMLogs(Config.NMLogsID).setHardness(2.0F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName(Archive.nmLogs);
        
        dreamPlanks = new BlockDreamPlanks(Config.DreamPlanksID).setUnlocalizedName(Archive.dreamPlanks);
        
        dreamLeaves = new BlockDreamLeaves(Config.DreamLeavesID).setUnlocalizedName(Archive.dreamLeaves).setLightOpacity(1);
        
        dreamSaplings = new BlockDreamSaplings(Config.DreamSaplingsID).setHardness(0.0F).setStepSound(Block.soundGrassFootstep).setUnlocalizedName(Archive.dreamSaplings);
        
        // Ores
        oreMethaneClathrate = new BlockDreamMethane(Config.OreMethaneClathrateID, Config.itemMethaneClathrateID).setUnlocalizedName(Archive.oreMethaneClathrate).setHardness(1.0F).setStepSound(Block.soundGravelFootstep);
        
        oreLucidity = new BlockDreamLand(Config.OreLucidityID, Config.itemLucidityID,0).setUnlocalizedName(Archive.oreLucidity).setHardness(2.0F);

        oreStarcesium = new BlockDreamLand(Config.OreStarCesiumID, Item.netherStar.itemID,0).setUnlocalizedName(Archive.oreStarcesium).setHardness(2.0F);
        
        // Custom Render Blocks
        //blockPedestal = new Block
    }
}