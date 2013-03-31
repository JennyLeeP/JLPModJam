package dreamLand;


import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.world.World;

public class ItemDreamSword extends ItemSword {

	
		protected ItemDreamSword(int var1, EnumToolMaterial var2) {
			super(var1, var2);
			this.setCreativeTab(DreamLand.tabDreamLand);
		
		}
		public void updateIcons(IconRegister par1IconRegister)
		{
			this.iconIndex = par1IconRegister.registerIcon(DreamLand.modid + ":swordPhantomIron");
		}
		@Override
		public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
		{
		par3World.playSoundEffect((double)par4 + 0.5D, (double)par5 + 0.5D, (double)par6 + 0.5D, "random.pop", 1.0F, itemRand.nextFloat() * 0.4F + 0.8F);
        return par3World.setBlock(par4, par5, par6, Block.cake.blockID);
		}
}

