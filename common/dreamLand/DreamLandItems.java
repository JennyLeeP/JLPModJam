package dreamLand;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class DreamLandItems extends Item{

	public DreamLandItems(int par1) {
		super(par1);
		this.setCreativeTab(DreamLand.tabDreamLand);
	}
	public void updateIcons(IconRegister par1IconRegister)
	{
		this.iconIndex = par1IconRegister.registerIcon(DreamLand.modid + ":Lucidity");
	}
}
