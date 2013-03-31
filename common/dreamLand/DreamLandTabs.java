package dreamLand;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class DreamLandTabs extends CreativeTabs {

	public DreamLandTabs(int par1, String par2Str) {
		super(par1, par2Str);
		// TODO Auto-generated constructor stub
	}
	
	@SideOnly(Side.CLIENT)
	
	
	@Override
	public ItemStack getIconItemStack()
	{
		return new ItemStack(DreamLand.itemlighter);
	}
}
