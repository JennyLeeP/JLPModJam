package dreamLand.blocks;

import java.util.List;

import net.minecraft.block.Block;
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
    private Icon icon[];
    
    String[] StoneTypes = {"bloodCobble", "dreamStoneBrick","nmStoneBrick","bloodBrick"};
    
    public BlockDreamStone(int id) {
        super(id, Material.rock);
        setCreativeTab(DreamLand.tabDreamLand);
        setStepSound(Block.soundStoneFootstep);
        setHardness(1.5F);
        setResistance(10.0F);
    }
    @SideOnly(Side.CLIENT)
    @Override
    public Icon getIcon(int i, int meta)
    {
            return icon[meta];
    }
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister) 
    {
        icon = new Icon[4];
        for(int i = 0; i < StoneTypes.length; i++){
            icon[i] = iconRegister.registerIcon(Archive.texture + StoneTypes[i]);
        }
    }
    @Override
    public int damageDropped (int meta)
    {
        return meta;
    }
    @SuppressWarnings("unchecked")
    @SideOnly(Side.CLIENT)
    @Override
    public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, @SuppressWarnings("rawtypes") List par3List)
    {
        for(int i = 0; i < StoneTypes.length; i++){
        par3List.add(new ItemStack(par1, 1, i));
        }
    }
    
}
