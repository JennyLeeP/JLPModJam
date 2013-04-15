package dreamLand.utils;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dreamLand.items.ModItems;

public class DreamLandTabs extends CreativeTabs {

    public DreamLandTabs(int id, String name) {
        super(id, name);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public ItemStack getIconItemStack() {
        return new ItemStack(ModItems.itemSwordPhantomIron);
    }
}
