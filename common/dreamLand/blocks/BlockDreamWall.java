package dreamLand.blocks;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dreamLand.DreamLand;
import dreamLand.utils.Archive;
import net.minecraft.block.Block;
import net.minecraft.block.BlockWall;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class BlockDreamWall extends BlockWall{

	@SideOnly(Side.CLIENT)
	Icon[] icons = new Icon[16];
	String[] wallTypes = {"dreamCobble", "dreamStoneBrick","nmCobble", "nmStoneBrick", "bloodCobble", "bloodStoneBrick"};
	
	public BlockDreamWall(int par1, Block par2Block) {
		super(par1, par2Block);
		this.setCreativeTab(DreamLand.tabDreamLand);
	}
    @Override
    public boolean isBlockSolidOnSide(World world, int x, int y, int z, ForgeDirection side)
    {
        return side == ForgeDirection.UP;
    }
    @SideOnly(Side.CLIENT)
    @Override
    public Icon getIcon(int side, int meta)
    {
        return icons[meta];
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister) 
    {
        for(int i = 0; i < wallTypes.length; i++){
        icons[i] = iconRegister.registerIcon(Archive.texture + wallTypes[i]);
        }
    }
    
    @SuppressWarnings("unchecked")
	@Override
    public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, @SuppressWarnings("rawtypes") List par3List)
    {
        for(int i = 0; i < wallTypes.length; i++){
            par3List.add(new ItemStack(par1, 1, i));
        }  
    }
}
