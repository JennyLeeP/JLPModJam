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
    public static Block oreLucidity;
    public static Block oreStarcesium;

    public static BlockPortalDreamLand portal;

    public static void init() {

        // Portal
        portal = (BlockPortalDreamLand) new BlockPortalDreamLand(Config.DreamLandPortalID)
                .setUnlocalizedName(Archive.portal);

        // Blocks
        portalObsidian = new BlockDreamLand(Config.PortalObsidianID).setUnlocalizedName(
                Archive.portalObsidian).setHardness(3.0F);

        dreamStone = new BlockDreamLand(Config.DreamStoneID).setUnlocalizedName(Archive.dreamStone)
                .setHardness(2.0F);

        dreamQuartz = new BlockDreamLand(Config.DreamQuartzID).setUnlocalizedName(Archive.dreamQuartz)
                .setStepSound(Block.soundStoneFootstep).setHardness(2.0F);

        dreamDirt = new BlockDreamLand(Config.DreamDirtID).setUnlocalizedName(Archive.dreamDirt)
                .setStepSound(Block.soundGrassFootstep).setHardness(0.6F);

        dreamGravel = new BlockDreamLand(Config.DreamSandID).setUnlocalizedName(Archive.dreamGravel)
                .setHardness(1.0F).setStepSound(Block.soundGravelFootstep);

        dreamGrass = new BlockDreamGrass(Config.DreamGrassID).setHardness(0.6F)
                .setStepSound(Block.soundGrassFootstep).setUnlocalizedName(Archive.dreamGrass);

        // Ores
        oreLucidity = new BlockDreamLand(Config.OreLucidityID, Config.itemLucidityID)
                .setUnlocalizedName(Archive.oreLucidity).setHardness(2.0F);

        oreStarcesium = new BlockDreamLand(Config.OreStarCesiumID, Item.netherStar.itemID)
                .setUnlocalizedName(Archive.oreStarcesium).setHardness(2.0F);
    }
}