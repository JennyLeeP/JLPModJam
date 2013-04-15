package dreamLand.utils;

public class Archive {

    // **************************Mod Stuff***************
    public static final String VERSION = "0.1";
    public static final String modID = "DreamLand";
    public static final String modName = "Dream Land";

    // *************************Locations*******************
    public static final String proxy = "dreamLand.sided.";
    public static final String clientProxy =  proxy+ "ClientProxy";
    public static final String serverProxy = proxy + "CommonProxy";
    public static final String texture = modID + ":";
    public static final String lang = "/mods/dreamLand/lang/";

    // **************************Items**********************
    public static final String itemLighter = "itemLighter";
    public static final String itemSwordPhantomIron = "itemSwordPhantomIron";
    public static final String itemLucidity = "itemLucidity";
    public static final String itemSparklingSapling = "sparklingSapling";

    // ***************************Blocks********************
    public static final String portal = "portal";
    public static final String portalObsidian = "portalObsidian";
    public static final String dreamStone = "dreamStone";
    public static final String dreamQuartz = "dreamQuartz";
    public static final String dreamDirt = "dreamDirt";
    public static final String dreamGravel = "cyaGravel";
    public static final String dreamGrass = "dreamGrass";
    public static final String oreLucidity = "oreLucidity";
    public static final String oreStarcesium = "oreStarCesium";
    
    //****************************Languages********************
    public static final String tabDreamLand = "tabDreamLand";
    public static String[] langFiles = { 
        // EN Language
        lang + "en_US.xml", 
        // ES Language
        lang + "es_ES.xml" };
}