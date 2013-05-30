package dreamLand.blocks;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import dreamLand.utils.Archive;
import dreamLand.utils.Config;

public class ModBlocks {

    public static Block portalObsidian;
    public static Block dreamStone;
    public static Block dreamQuartz;
    public static Block dreamDirt;
    public static Block dreamGravel;
    public static Block dreamGrass;
    public static Block dreamSand;
    public static Block dreamCobble;
    public static Block dreamWall;
    public static Block nmStone;
    public static Block nmDirt;
    public static Block nmGravel;
    public static Block nmGrass;
    public static Block nmSand;
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
    public static Block bloodCobble;
    public static Block bloodStairs;
    
    public static BlockPortalDreamLand portal;
    public static BlockPortalNightMare nmPortal;

    public static void init() {

        // Portal
        portal = (BlockPortalDreamLand) new BlockPortalDreamLand(Config.DreamLandPortalID).setUnlocalizedName(Archive.portal);
        nmPortal = (BlockPortalNightMare) new BlockPortalNightMare(Config.NightMarePortalID).setUnlocalizedName(Archive.nmPortal);

        // Blocks
        portalObsidian = new BlockDreamLand(Config.PortalObsidianID).setUnlocalizedName(Archive.portalObsidian).setHardness(3.0F).setLightValue(1.0F);

        dreamStone = new BlockDreamLand(Config.DreamStoneID).setUnlocalizedName(Archive.dreamStone).setHardness(1.5F);

        dreamQuartz = new BlockDreamLand(Config.DreamStoneBrickID).setUnlocalizedName(Archive.dreamStoneBrick).setStepSound(Block.soundStoneFootstep).setHardness(2.0F);

        dreamDirt = new BlockDreamLand(Config.DreamDirtID).setUnlocalizedName(Archive.dreamDirt).setStepSound(Block.soundGrassFootstep).setHardness(0.6F);

        dreamGravel = new BlockDreamFalling(Config.DreamGravelID).setUnlocalizedName(Archive.dreamGravel).setHardness(0.6F).setStepSound(Block.soundGravelFootstep);

        dreamGrass = new BlockDreamGrass(Config.DreamGrassID).setHardness(0.6F).setStepSound(Block.soundGrassFootstep).setUnlocalizedName(Archive.dreamGrass);
        
        dreamSand = new BlockDreamFalling(Config.DreamSandID).setHardness(0.5F).setStepSound(Block.soundSandFootstep).setUnlocalizedName(Archive.dreamSand);
        
        dreamCobble = new BlockDreamLand(Config.DreamCobbleID).setUnlocalizedName(Archive.dreamCobble).setHardness(1.5F);
        
        nmStone = new BlockDreamLand(Config.NMStoneID).setUnlocalizedName(Archive.nmStone).setHardness(1.5F);

        nmDirt = new BlockDreamLand(Config.NMDirtID).setUnlocalizedName(Archive.nmDirt).setStepSound(Block.soundGrassFootstep).setHardness(0.6F);

        nmGravel = new BlockDreamFalling(Config.NMGravelID).setUnlocalizedName(Archive.nmGravel).setHardness(0.6F).setStepSound(Block.soundGravelFootstep);

        nmGrass = new BlockNMGrass(Config.NMGrassID).setHardness(0.6F).setStepSound(Block.soundGrassFootstep).setUnlocalizedName(Archive.nmGrass);
        
        nmSand = new BlockDreamFalling(Config.NMSandID).setHardness(0.5F).setStepSound(Block.soundSandFootstep).setUnlocalizedName(Archive.nmSand);
        
        nmCobble = new BlockDreamLand(Config.NMCobbleID).setUnlocalizedName(Archive.nmCobble).setHardness(2.0F);
        
        bloodCobble = new BlockDreamLand(Config.BloodCobbleID).setUnlocalizedName(Archive.bloodCobble).setHardness(2.0F);
        
        //Stairs and Walls
        dreamStairs = (new BlockDreamStairs(Config.DreamStairsID, dreamCobble, 0)).setUnlocalizedName(Archive.dreamStairs).setHardness(2.0F).setStepSound(Block.soundStoneFootstep);
        
        nmStairs = (new BlockDreamStairs(Config.NMStairsID, nmCobble, 0)).setUnlocalizedName(Archive.nmStairs).setHardness(2.0F).setStepSound(Block.soundStoneFootstep);
        
        bloodStairs = (new BlockDreamStairs(Config.BloodStairsID, bloodCobble, 0)).setUnlocalizedName(Archive.bloodStairs).setHardness(2.0F).setStepSound(Block.soundStoneFootstep);
        
        dreamWall = (new BlockDreamWall(Config.DreamWallID, dreamCobble)).setUnlocalizedName(Archive.dreamWall).setHardness(0.3F);
        
        //Trees and leaves
        dreamLogs = new BlockDreamLogs(Config.DreamLogsID).setHardness(2.0F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName(Archive.dreamLogs);
        
        nmLogs = new BlockNMLogs(Config.NMLogsID).setHardness(2.0F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName(Archive.nmLogs);
        
        dreamPlanks = new BlockDreamPlanks(Config.DreamPlanksID).setHardness(2.0F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName(Archive.dreamPlanks);
        
        dreamLeaves = new BlockDreamLeaves(Config.DreamLeavesID).setHardness(0.6F).setStepSound(Block.soundGrassFootstep).setUnlocalizedName(Archive.dreamLeaves).setLightOpacity(1);
        
        dreamSaplings = new BlockDreamSaplings(Config.DreamSaplingsID).setHardness(0.0F).setStepSound(Block.soundGrassFootstep).setUnlocalizedName(Archive.dreamSaplings);
        
        // Ores
        oreMethaneClathrate = new BlockDreamMethane(Config.OreMethaneClathrateID, Config.itemMethaneClathrateID).setUnlocalizedName(Archive.oreMethaneClathrate).setHardness(1.0F);
        
        oreLucidity = new BlockDreamLand(Config.OreLucidityID, Config.itemLucidityID).setUnlocalizedName(Archive.oreLucidity).setHardness(2.0F);

        oreStarcesium = new BlockDreamLand(Config.OreStarCesiumID, Item.netherStar.itemID).setUnlocalizedName(Archive.oreStarcesium).setHardness(2.0F);
    }
}