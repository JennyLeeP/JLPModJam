package dreamLand.blocks;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dreamLand.DreamLand;
import dreamLand.utils.Archive;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class BlockDreamPlanks extends BlockDreamLand{

    @SideOnly(Side.CLIENT)
    Icon[] icons = new Icon[16];
    String[] TreeTypes = {"sparkling","ash","brilliant", "dark", "frigid", "infernal", "life", "death"};
    
    public BlockDreamPlanks(int id) {
        super(id, Material.wood);
        this.setCreativeTab(DreamLand.tabDreamLand);
        this.setHardness(2.0F);
        this.setStepSound(Block.soundWoodFootstep);
        setBurnProperties(this.blockID, 5, 20);
        
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public Icon getIcon(int i, int meta)
    {
            return icons[meta];
    }
    
    @SideOnly(Side.CLIENT)
    
    @Override
    public void registerIcons(IconRegister iconRegister)
    {
        
        for(int i = 0; i < TreeTypes.length; i++)
        {
            icons[i] = iconRegister.registerIcon(Archive.texture + TreeTypes[i] + "_Planks");
        }
    }
    public int getFlammability (IBlockAccess world, int x, int y, int z, int metadata, ForgeDirection face)
    {
        if (metadata == 1 || metadata == 3 || metadata == 5 || metadata == 7)
            return 0;
        return blockFlammability[blockID];
    }
    
    public int getFireSpreadSpeed(World world, int x, int y, int z, int metadata, ForgeDirection face)
    {
        if (metadata == 1 || metadata == 3 || metadata == 5 || metadata == 7)
            return 0;
        return blockFireSpreadSpeed[blockID];
    }
    @Override
    public int damageDropped (int meta)
    {
        return meta;
    }
    @SuppressWarnings("unchecked")
    @SideOnly(Side.CLIENT)

    /**
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     */
    @Override
    public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, @SuppressWarnings("rawtypes") List par3List)
    {
        for(int i = 0; i < TreeTypes.length; i++)
        {
        par3List.add(new ItemStack(par1, 1, i));
        }
    }
}
