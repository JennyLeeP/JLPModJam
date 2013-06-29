package dreamLand.utils;

public class Archive {

    // **************************Mod Stuff***************
    public static final String VERSION = "0.3";
    public static final String modID = "DreamLand";
    public static final String modName = "DreamLand";

    // *************************Locations*******************
    public static final String proxy = "dreamLand.sided.";
    public static final String clientProxy =  proxy+ "ClientProxy";
    public static final String serverProxy = proxy + "CommonProxy";
    public static final String texture = modID + ":";
    public static final String lang = "/mods/DreamLand/lang/";

    // **************************Items**********************
    public static final String itemLighter = "itemLighter";
    public static final String itemSwordPhantomIron = "itemSwordPhantomIron";
    public static final String itemLucidity = "itemLucidity";
    public static final String itemMethaneClathrate = "itemMethaneClathrate";

    // ***************************Blocks********************
    public static final String portal = "portal";
    public static final String portalObsidian = "portalObsidian";
    public static final String dreamStone = "dreamStone";
    public static final String dreamDirt = "dreamDirt";
    public static final String dreamGrass = "dreamGrass";
    public static final String dreamStairs = "dreamStairs";
    public static final String oreLucidity = "oreLucidity";
    public static final String oreStarcesium = "oreStarCesium";
    public static final String dreamCobble = "dreamCobble";
    public static final String nmPortal = "nmPortal";
    public static final String nmGrass = "nmGrass";
    public static final String nmDirt = "nmDirt";
    public static final String nmStone = "nmStone";
    public static final String nmCobble = "nmCobble";
    public static final String nmStairs = "nmStairs";
    public static final String nmLogs = "nmLogs";
    public static final String bloodStairs = "bloodStairs";
    public static final String oreMethaneClathrate = "oreMethaneClathrate";
    
    // ************************ Meta Blocks ********************
    public static final String dreamFence = "dreamFence";
    public static final String dreamStones1 = "dreamStones1";
    public static final String dreamFalling = "dreamFalling";
    public static final String dreamSaplings = "dreamSaplings";
    public static final String dreamLogs = "dreamLogs";
    public static final String dreamPlanks = "dreamPlanks";
    public static final String dreamLeaves = "dreamLeaves";
    public static final String dreamWall = "dreamWall";
    
    //*************************** Languages ********************
    public static final String tabDreamLand = "tabDreamLand";
    public static String[] langFiles = { 
        // EN Language
        lang + "en_US.xml", 
        // ES Language
        lang + "es_ES.xml" };
}