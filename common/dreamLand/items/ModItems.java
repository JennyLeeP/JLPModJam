package dreamLand.items;

import net.minecraft.item.Item;
import dreamLand.DreamLand;
import dreamLand.blocks.sparklingSapling;
import dreamLand.utils.Archive;
import dreamLand.utils.Config;

public class ModItems {

    public static Item itemlighter;
    public static Item itemLucidity;
    public static Item itemSwordPhantomIron;
    public static Item itemSparklingSapling;

    public static void init() {

        itemlighter = new ItemLighter(Config.itemLighterId - 256)
                .setUnlocalizedName(Archive.itemlighter);

        itemSwordPhantomIron = new ItemDreamSword(Config.swordPhantomId - 256,
                DreamLand.toolPhantomIron).setUnlocalizedName(Archive.itemSwordPhantomIron);

        itemLucidity = new DreamLandItems(Config.itemLucidityID - 256)
                .setUnlocalizedName(Archive.itemLucidity);

        itemSparklingSapling = new sparklingSapling(Config.itemSparklingSaplingID - 256)
                .setUnlocalizedName(Archive.itemSparklingSapling);
    }
}