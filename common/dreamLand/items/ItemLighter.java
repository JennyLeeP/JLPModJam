package dreamLand.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dreamLand.DreamLand;
import dreamLand.blocks.ModBlocks;
import dreamLand.utils.Reference;

public class ItemLighter extends Item {

    public ItemLighter(int par1) {
        super(par1);
        maxStackSize = 1;
        this.setMaxDamage(64);
        this.setCreativeTab(DreamLand.tabDreamLand);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister) {
        this.itemIcon = par1IconRegister.registerIcon(Reference.texture
                + this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
    }

    @Override
    public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer,
            World par3World, int par4, int par5, int par6, int par7, float par8, float par9,
            float par10) {
        int blockID = par3World.getBlockId(par4, par5, par6);
        if (blockID == ModBlocks.portalObsidian.blockID){
            ModBlocks.portal.tryToCreatePortal(par3World, par4, par5 + 1, par6);
        }
        if (blockID == ModBlocks.nmCobble.blockID){
            ModBlocks.nmPortal.tryToCreatePortal(par3World, par4, par5 + 1, par6);
        }
        return true;

    }
}
