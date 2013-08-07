package dreamLand.items;

import net.minecraft.item.Item;
import dreamLand.DreamLand;
import dreamLand.utils.Reference;
import dreamLand.utils.Config;

public class ModItems {

    public static Item itemlighter;
    public static Item itemLucidity;
    public static Item itemSwordPhantomIron;
    public static Item itemMethaneClathrate;
    // Seeds
    public static Item whiteSeeds;
    public static Item orangeSeeds;
    public static Item yellowSeeds;
    public static Item redSeeds;
    public static Item pinkSeeds;
    public static Item magentaSeeds;
    public static Item purpleSeeds;
    public static Item greenSeeds;
    public static Item limeSeeds;
    public static Item blueSeeds;
    public static Item lightBlueSeeds;
    public static Item graySeeds;
    public static Item lightGraySeeds;
    public static Item blackSeeds;
    public static Item brownSeeds;
    public static Item cyanSeeds;
    // Flowers
    public static Item whiteFlower;
    public static Item orangeFlower;
    public static Item yellowFlower;
    public static Item redFlower;
    public static Item pinkFlower;
    public static Item magentaFlower;
    public static Item purpleFlower;
    public static Item greenFlower;
    public static Item limeFlower;
    public static Item blueFlower;
    public static Item lightBlueFlower;
    public static Item grayFlower;
    public static Item lightGrayFlower;
    public static Item blackFlower;
    public static Item brownFlower;
    public static Item cyanFlower;

    public static void init() {

        itemlighter = new ItemLighter(Config.itemLighterId - 256).setUnlocalizedName(Reference.itemLighter);

        itemSwordPhantomIron = new ItemDreamSword(Config.swordPhantomId - 256, DreamLand.toolSolarium).setUnlocalizedName(Reference.itemSwordPhantomIron);

        itemLucidity = new DreamLandItems(Config.itemLucidityID - 256).setUnlocalizedName(Reference.itemLucidity);
        
        itemMethaneClathrate = new DreamLandItems(Config.itemMethaneClathrateID - 256).setUnlocalizedName(Reference.itemMethaneClathrate);
        // Seeds
        //whiteSeeds = new DreamLandItems(Config.whiteSeedsID - 256).setUnlocalizedName(Archive.whiteSeeds);
        
        // Flowers
        //whiteSeeds = new DreamLandItems(Config.whiteFlowerID - 256).setUnlocalizedName(Archive.whiteFlower);
    }
}