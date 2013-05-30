package dreamLand.blocks;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dreamLand.DreamLand;
import dreamLand.utils.Archive;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

public class BlockDreamPlanks extends BlockDreamLand{

    Icon[] icons = new Icon[16];
    
    
    public BlockDreamPlanks(int id) {
        super(id, Material.wood);
        this.setCreativeTab(DreamLand.tabDreamLand);
    }
    @SideOnly(Side.CLIENT)

    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    @Override
    public Icon getIcon(int i, int meta)
    {
            return icons[meta];
    }
    String[] TreeTypes = {"sparkling","ash","brilliant", "dark", "frigid", "infernal", "life", "death"};
    
    @SideOnly(Side.CLIENT)
    /**
     * When this method is called, your block should register all the icons it needs with the given IconRegister. This
     * is the only chance you get to register icons.
     */
    @Override
    public void registerIcons(IconRegister iconRegisterer)
    {
        
        for(int i = 0; i < 8; i++)
        {
            icons[i] = iconRegisterer.registerIcon(Archive.texture + TreeTypes[i] + "_Planks");
        }
    }
    
    @SuppressWarnings("unchecked")
    @SideOnly(Side.CLIENT)

    /**
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     */
    @Override
    public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, @SuppressWarnings("rawtypes") List par3List)
    {
        for(int i = 0; i < 8; i++)
        {
        par3List.add(new ItemStack(par1, 1, i));
        }
    }
}
