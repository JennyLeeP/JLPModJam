package dreamLand;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class DreamLandItem extends Item {

	public DreamLandItem(int id) {
		super(id);
		setCreativeTab(CreativeTabs.tabMaterials);
	}
	public String getTextureFile() 
	{
		return "/resources/item.png";
	}
	
	//TODO stuff
}
