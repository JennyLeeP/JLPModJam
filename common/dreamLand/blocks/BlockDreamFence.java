package dreamLand.blocks;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dreamLand.DreamLand;
import dreamLand.render.DLFenceRender;
import dreamLand.utils.Archive;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFence;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class BlockDreamFence extends BlockFence{
    Icon[] icons = new Icon[16];

    public BlockDreamFence(int par1, String par2Str, Material par3Material) {
        super(par1, par2Str, par3Material);
        setBurnProperties(this.blockID, 5, 20);
        this.setHardness(2.0F);
        this.setResistance(5.0F);
        this.setStepSound(Block.soundWoodFootstep);
        setBurnProperties(this.blockID, 5, 20);
        this.setCreativeTab(DreamLand.tabDreamLand);
    }
    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    @SideOnly(Side.CLIENT)
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

        for(int i = 0; i < TreeTypes.length; i++)
        {
            icons[i] = iconRegisterer.registerIcon(Archive.texture + TreeTypes[i] + "_Planks");
        }
    }
    public static boolean isIdAFence(int par0)
    {
        return true;
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
    public boolean canPlaceTorchOnTop(World world, int x, int y, int z)
    {
        return true;
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
    public int getRenderType()
    {
        return DLFenceRender.fenceModel;
    }
}
