package dreamLand.blocks;

import java.util.List;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dreamLand.DreamLand;
import dreamLand.utils.Archive;

public class BlockDreamStone extends BlockDreamLand{

    @SideOnly(Side.CLIENT)
    Icon[] icons = new Icon[16];
    String[] stoneTypes = {"bloodCobble","dreamStoneBrick","nmStoneBrick","bloodBrick"};
    
    public BlockDreamStone(int par1) {
        super(par1, Material.rock);
        this.setCreativeTab(DreamLand.tabDreamLand);
    }
    @Override
    public Icon getIcon(int side, int meta)
    {
        return icons[meta];
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister) 
    {
        for(int i = 0; i < stoneTypes.length; i++){
            icons[i] = iconRegister.registerIcon(Archive.texture + stoneTypes[i]);
        }
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, @SuppressWarnings("rawtypes") List par3List)
    {
        for(int i = 0; i < stoneTypes.length; i++){
        par3List.add(new ItemStack(par1, 1, i));
        }
    }
    @Override
    public int damageDropped (int meta)
    {
        return meta;
    }
}
