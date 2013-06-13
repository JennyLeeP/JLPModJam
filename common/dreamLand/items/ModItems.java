package dreamLand.items;

import net.minecraft.item.Item;
import dreamLand.DreamLand;
import dreamLand.utils.Archive;
import dreamLand.utils.Config;

public class ModItems {

    public static Item itemlighter;
    public static Item itemLucidity;
    public static Item itemSwordPhantomIron;
    public static Item itemMethaneClathrate;

    public static void init() {

        itemlighter = new ItemLighter(Config.itemLighterId - 256).setUnlocalizedName(Archive.itemLighter);

        itemSwordPhantomIron = new ItemDreamSword(Config.swordPhantomId - 256, DreamLand.toolSolarium).setUnlocalizedName(Archive.itemSwordPhantomIron);

        itemLucidity = new DreamLandItems(Config.itemLucidityID - 256).setUnlocalizedName(Archive.itemLucidity);
        
        itemMethaneClathrate = new DreamLandItems(Config.itemMethaneClathrateID - 256).setUnlocalizedName(Archive.itemMethaneClathrate);
    }
}