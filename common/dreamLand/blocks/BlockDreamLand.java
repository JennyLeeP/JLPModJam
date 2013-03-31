package dreamLand.blocks;


import dreamLand.DreamLand;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;

public class BlockDreamLand extends Block{

	//private Object blockIcon;
	public BlockDreamLand(int par1)
	{
			super(par1, Material.rock);
			this.setCreativeTab(DreamLand.tabDreamLand);
	}
	public void registerIcons(IconRegister par1IconRegister)
	{
		this.blockIcon = par1IconRegister.registerIcon(DreamLand.modid + ":" + this.getUnlocalizedName2());
	}
}
