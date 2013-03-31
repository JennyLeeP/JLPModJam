package dreamLand;


import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemLighter extends Item{

	public ItemLighter(int par1)
	{
		super(par1);
		this.maxStackSize = 1;
        this.setMaxDamage(64);
        this.setCreativeTab(DreamLand.tabDreamLand);
	}
	
	public void updateIcons(IconRegister par1IconRegister)
	{
		this.iconIndex = par1IconRegister.registerIcon(DreamLand.modid + ":boomStick");
	}
	
	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
	{
		int blockID = par3World.getBlockId(par4, par5, par6);
		if (blockID == DreamLand.portalObsidian.blockID)
		{
			DreamLand.portal.tryToCreatePortal(par3World, par4, par5 + 1, par6);
		}
		
		return true;
		
	}
}
