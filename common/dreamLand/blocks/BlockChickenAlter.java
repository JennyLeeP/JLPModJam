package dreamLand.blocks;

import java.util.Random;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import dreamLand.tileEntity.TileChickenAlter;

public class BlockChickenAlter extends BlockContainer{

    public BlockChickenAlter(int par1) {
        super(par1, Material.rock);
        this.setBlockBounds(0.1F, 0.0F, 0.1F, 0.9F, 1.25F, 0.9F);
    }
    @Override
    public TileEntity createNewTileEntity(World world) {

        return new TileChickenAlter();
    }
    public int idDropped(int par1, Random par2Random, int par3)
    {
        return 0;
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random par1Random)
    {
        return 0;
    }
  //This will tell minecraft not to render any side of our cube.
    public boolean shouldSideBeRendered(IBlockAccess iblockaccess, int i, int j, int k, int l)
    {
       return false;
    }
    
    @Override
    public boolean renderAsNormalBlock() {

        return false;
    }

    @Override
    public boolean isOpaqueCube() {

        return false;
    }
    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
    {
        int l = par1World.getBlockMetadata(par2, par3, par4);
        float f = 0.0625F;
        float f1 = (float)(1 + l * 2) / 16.0F;
        float f2 = 1.25F;
        return AxisAlignedBB.getAABBPool().getAABB((double)((float)par2 + f1), (double)par3, (double)((float)par4 + f), (double)((float)(par2 + 1) - f), (double)((float)par3 + f2 - f), (double)((float)(par4 + 1) - f));
    }
    /**
     * Called whenever the block is added into the world. Args: world, x, y, z
     */
    @Override
    public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLiving par5EntityLiving, ItemStack par6ItemStack)
    {
        int dir = MathHelper.floor_double((double)((par5EntityLiving.rotationYaw * 4F) / 360F) + 0.5D) & 3;
        par1World.setBlockMetadataWithNotify(par2, par3, par4, dir, 0);
        
    }
    public int idPicked(World par1World, int par2, int par3, int par4)
    {
        return 0;
    }
}
