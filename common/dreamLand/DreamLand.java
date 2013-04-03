package dreamLand;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.EnumHelper;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import dreamLand.blocks.BlockDreamGrass;
import dreamLand.blocks.BlockDreamLand;
import dreamLand.blocks.BlockPortalDreamLand;
import dreamLand.blocks.sparklingSapling;
import dreamLand.world.BiomeGenDreamLand;
import dreamLand.world.DreamLandWorldProvider;

@Mod(modid = DreamLand.modid, name = "DreamLand", version = DreamLand.VERSION)
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class DreamLand {

    public static final String VERSION = "1.0";
    public static final String modid = "DreamLand";

    @Instance("DreamLand")
    public static DreamLand instance;

    @SidedProxy(clientSide = "dreamLand.ClientProxy", serverSide = "dreamLand.CommonProxy")
    public static CommonProxy proxy;

    static EnumArmorMaterial armorPravlon = EnumHelper.addArmorMaterial("PhantomIron", 29,
            new int[] { 2, 7, 5, 3 }, 9);
    static EnumToolMaterial toolPhantomIron = EnumHelper.addToolMaterial("PhantomIron", 3, 2000,
            12.0F, 9, 25);

    public static Block portalObsidian;
    public static Block dreamStone;
    public static Block dreamQuartz;
    public static Block dreamDirt;
    public static Block dreamGravel;
    public static Block dreamGrass;
    public static Block oreLucidity;
    public static Block oreStarcesium;

    public static BlockPortalDreamLand portal;

    public static Item itemlighter;
    public static Item itemLucidity;
    public static Item itemSwordPhantomIron;
    public static Item itemSparklingSapling;

    public static int dimensionID = 21;
    public static BiomeGenBase dreamIsland;

    static boolean enableDreamDimension;

    // declare new Creative Tab
    public static CreativeTabs tabDreamLand = new DreamLandTabs(CreativeTabs.getNextID(),
            "tabDreamLand");

    @PreInit
    public void preInit(FMLPreInitializationEvent evt) {

        // Loads the Config File
        Config.init(evt);
        
        // Blocks
        portal = (BlockPortalDreamLand) new BlockPortalDreamLand(Config.DreamLandPortalID)
                .setUnlocalizedName("portal");

        portalObsidian = new BlockDreamLand(Config.PortalObsidianID).setUnlocalizedName("portalObsidian")
                .setHardness(3.0F);
        dreamStone = new BlockDreamLand(Config.DreamStoneID).setUnlocalizedName("dreamStone").setHardness(
                2.0F);
        dreamQuartz = new BlockDreamLand(Config.DreamQuartzID).setUnlocalizedName("dreamQuartz")
                .setStepSound(Block.soundStoneFootstep).setHardness(2.0F);
        dreamDirt = new BlockDreamLand(Config.DreamDirtID).setUnlocalizedName("dreamDirt")
                .setStepSound(Block.soundGrassFootstep).setHardness(0.6F);
        dreamGravel = new BlockDreamLand(Config.DreamSandID).setUnlocalizedName("cyaGravel")
                .setHardness(1.0F).setStepSound(Block.soundGravelFootstep);
        oreLucidity = new BlockDreamLand(Config.OreLucidityID, Config.itemLucidityID).setUnlocalizedName(
                "oreLucidity").setHardness(2.0F);
        oreStarcesium = new BlockDreamLand(Config.OreStarCesiumID, Item.netherStar.itemID)
                .setUnlocalizedName("oreStarCesium").setHardness(2.0F);
        dreamGrass = new BlockDreamGrass(Config.DreamGrassID).setHardness(0.6F)
                .setStepSound(Block.soundGrassFootstep).setUnlocalizedName("grass");

        // Items
        itemlighter = new ItemLighter(Config.itemLighterId - 256).setUnlocalizedName("itemLighter");
        itemSwordPhantomIron = new ItemDreamSword(Config.swordPhantomId - 256, toolPhantomIron)
                .setUnlocalizedName("itemSwordPhantomIron");
        itemLucidity = new DreamLandItems(Config.itemLucidityID - 256).setUnlocalizedName("itemLucidity");
        itemSparklingSapling = new sparklingSapling(Config.itemSparklingSaplingID - 256)
                .setUnlocalizedName("sparklingSapling");

        dreamIsland = (new BiomeGenDreamLand(100)).setColor(6316128).setBiomeName("Dream Land")
                .setMinMaxHeight(0.3F, 2.0F).setTemperatureRainfall(0.2F, 0.3F);
    }

    @Init
    public void init(FMLInitializationEvent evt) {

        GameRegistry.registerBlock(portalObsidian, "Obsidiatal");
        GameRegistry.registerBlock(portal, "DreamLand_Portal");
        GameRegistry.registerBlock(dreamStone, "Dream_Stone");
        GameRegistry.registerBlock(dreamQuartz, "Dream_Quartz");
        GameRegistry.registerBlock(dreamDirt, "Dream_Dirt");
        GameRegistry.registerBlock(dreamGravel, "CyaGravel");
        GameRegistry.registerBlock(dreamGrass, "Dream_Grass");
        GameRegistry.registerBlock(oreLucidity, "OreLucidity");
        GameRegistry.registerBlock(oreStarcesium, "OreStarCesium");

        GameRegistry.registerItem(itemlighter, "Boom Stick");
        GameRegistry.registerItem(itemSwordPhantomIron, "Phantom Sword");
        GameRegistry.registerItem(itemLucidity, "Lucidity");
        GameRegistry.registerItem(itemSparklingSapling, "Sparking Sapling");

        LanguageRegistry.addName(portal, "Portal");
        LanguageRegistry.addName(portalObsidian, "ShadowGate");
        LanguageRegistry.addName(dreamStone, "SoldjerStone");
        LanguageRegistry.addName(dreamQuartz, "Surrealite");
        LanguageRegistry.addName(dreamDirt, "Chaotic Earth");
        LanguageRegistry.addName(dreamGravel, "CyaGravel");
        LanguageRegistry.addName(dreamGrass, "Water Grass");
        LanguageRegistry.addName(oreLucidity, "OreLucidity");
        LanguageRegistry.addName(oreStarcesium, "OreStarCesium");

        LanguageRegistry.addName(itemlighter, "Igniter");
        LanguageRegistry.addName(itemSwordPhantomIron, "Malum Sword");
        LanguageRegistry.addName(itemLucidity, "Lucidity");
        LanguageRegistry.addName(itemSparklingSapling, "Sparking Sapling");

        // Creative Tab
        LanguageRegistry.instance().addStringLocalization("itemGroup.tabDreamLand", "en_US",
                "Dreamland");

        GameRegistry.addRecipe(new ItemStack(portalObsidian), new Object[] { "XXX", "XOX", "XXX",
                'X', Block.obsidian, 'O', Block.blockDiamond });
        GameRegistry.addRecipe(new ItemStack(itemlighter), new Object[] { "  X", " X ", "X  ", 'X',
                Item.emerald });
        GameRegistry.addRecipe(new ItemStack(itemSwordPhantomIron), new Object[] { " O ", " O ",
                " X ", 'X', Item.emerald, 'O', Item.diamond });

        DimensionManager.registerProviderType(DreamLand.dimensionID, DreamLandWorldProvider.class,
                true);
        DimensionManager.registerDimension(DreamLand.dimensionID, DreamLand.dimensionID);

    }

    @PostInit
    public void postInit(FMLPostInitializationEvent evt) {
        // TODO stuff

    }
}
