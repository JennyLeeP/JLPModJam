package dreamLand.blocks;

import java.util.List;
import java.util.Random;

import net.minecraft.block.BlockFlower;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.event.terraingen.TerrainGen;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dreamLand.DreamLand;
import dreamLand.utils.Archive;
import dreamLand.world.terrain.trees.WorldGenAshTrees;
import dreamLand.world.terrain.trees.WorldGenBigSparklingTree;
import dreamLand.world.terrain.trees.WorldGenBrilliantTrees;
import dreamLand.world.terrain.trees.WorldGenDLTrees;
import dreamLand.world.terrain.trees.WorldGenDarkTrees;
import dreamLand.world.terrain.trees.WorldGenDeathTrees;
import dreamLand.world.terrain.trees.WorldGenFrigidTrees;
import dreamLand.world.terrain.trees.WorldGenInfernalTrees;
import dreamLand.world.terrain.trees.WorldGenLifeTrees;

public class BlockDreamSaplings extends BlockFlower {

	public static final String[] DREAM_WOOD_TYPES = new String[] {"sparkling", "ash", "brilliant", "dark", "frigid", "infernal","life","death"};
    private static final String[] DreamSaplings = new String[] {"sparkling_sapling", "ash_sapling", "brilliant_sapling", "dark_sapling", "frigid_sapling", "infernal_sapling","life_sapling","death sapling"};
    @SideOnly(Side.CLIENT)
    private Icon[] saplingIcon;

    protected BlockDreamSaplings(int par1)
    {
        super(par1);
        float f = 0.4F;
        this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 2.0F, 0.5F + f);
        this.setCreativeTab(DreamLand.tabDreamLand);
    }

    /**
     * Ticks the block if it's been scheduled
     */
    public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
        if (!par1World.isRemote)
        {
            super.updateTick(par1World, par2, par3, par4, par5Random);

            if (par1World.getBlockLightValue(par2, par3 + 1, par4) >= 9 && par5Random.nextInt(7) == 0)
            {
                this.markOrGrowMarked(par1World, par2, par3, par4, par5Random);
            }
        }
    }

    @SideOnly(Side.CLIENT)

    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    public Icon getIcon(int par1, int par2)
    {
        par2 &= 7;
        return this.saplingIcon[par2];
    }

    public void markOrGrowMarked(World par1World, int par2, int par3, int par4, Random par5Random)
    {
        int l = par1World.getBlockMetadata(par2, par3, par4);

        if ((l & 8) == 0)
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, l | 8, 4);
        }
        else
        {
            this.growTree(par1World, par2, par3, par4, par5Random);
        }
    }

    /**
     * Attempts to grow a sapling into a tree
     */
    public void growTree(World par1World, int chunkX, int chunkY, int chunkZ, Random par5Random)
    {
        if (!TerrainGen.saplingGrowTree(par1World, par5Random, chunkX, chunkY, chunkZ)) return;

        int l = par1World.getBlockMetadata(chunkX, chunkY, chunkZ) & 7;
        Object object = null;
        int i1 = 0;
        int j1 = 0;
        boolean flag = false;
        if (l == 1)//Meta Sapling 1
        {
            object = new WorldGenAshTrees(true);
        }
        else if (l == 2)//Meta Sapling 2
        {
            for (i1 = 0; i1 >= -1; --i1)
            {
                for (j1 = 0; j1 >= -1; --j1)
                {
                    if (this.isSameSapling(par1World, chunkX + i1, chunkY, chunkZ + j1, 2) && this.isSameSapling(par1World, chunkX + i1 + 1, chunkY, chunkZ + j1, 2) && this.isSameSapling(par1World, chunkX + i1, chunkY, chunkZ + j1 + 1, 2) && this.isSameSapling(par1World, chunkX + i1 + 1, chunkY, chunkZ + j1 + 1, 2))
                    {
                        object = new WorldGenBrilliantTrees(true);
                        flag = true;
                        break;
                    }
                }

                if (object != null)
                {
                    break;
                }
            }
            if (object == null)
            {
                j1 = 0;
                i1 = 0;
                object = new WorldGenDLTrees(true, 8 + par5Random.nextInt(7), 1, 2, false,0);
            }
        }
        else if (l == 3)//Meta Sapling 3 = vanilla jungle
        {
            for (i1 = 0; i1 >= -1; --i1)
            {
                for (j1 = 0; j1 >= -1; --j1)
                {
                    if (this.isSameSapling(par1World, chunkX + i1, chunkY, chunkZ + j1, 3) && this.isSameSapling(par1World, chunkX + i1 + 1, chunkY, chunkZ + j1, 3) && this.isSameSapling(par1World, chunkX + i1, chunkY, chunkZ + j1 + 1, 3) && this.isSameSapling(par1World, chunkX + i1 + 1, chunkY, chunkZ + j1 + 1, 3))
                    {
                        object = new WorldGenDarkTrees(true, 30 + par5Random.nextInt(20), 1, 3);
                        flag = true;
                        break;
                    }
                }

                if (object != null)
                {
                    break;
                }
            }

            if (object == null)
            {
                j1 = 0;
                i1 = 0;
                object = new WorldGenDLTrees(true, 15 + par5Random.nextInt(20), 1, 3, false,1);
            }
        }
        else if (l == 4)//Meta Sapling 4
        {
            object = new WorldGenFrigidTrees(true);
            //System.out.println("Sapling grow 4");
        }
        else if (l == 5)//Meta Sapling 5
        {
            object = new WorldGenInfernalTrees(true);
            //System.out.println("Sapling grow 5");
        }
        else if (l == 6)//Meta Sapling 6
        {
            object = new WorldGenLifeTrees(true);
            //System.out.println("Sapling  grow 6");
        }
        else if (l == 7)//Meta Sapling 7
        {
            object = new WorldGenDeathTrees(true);
            //System.out.println("Sapling grow 7");
        }
        else
        {
            object = new WorldGenBigSparklingTree(true);

            if (par5Random.nextInt(10) == 0)
            {
                object = new WorldGenBigSparklingTree(true);
            }
        }
//Meta Sapling if stops here ********
        if (flag)
        {
            par1World.setBlock(chunkX + i1, chunkY, chunkZ + j1, 0, 0, 4);
            par1World.setBlock(chunkX + i1 + 1, chunkY, chunkZ + j1, 0, 0, 4);
            par1World.setBlock(chunkX + i1, chunkY, chunkZ + j1 + 1, 0, 0, 4);
            par1World.setBlock(chunkX + i1 + 1, chunkY, chunkZ + j1 + 1, 0, 0, 4);
        }
        else
        {
            par1World.setBlock(chunkX, chunkY, chunkZ, 0, 0, 4);
        }

        if (!((WorldGenerator)object).generate(par1World, par5Random, chunkX + i1, chunkY, chunkZ + j1))
        {
            if (flag)
            {
                par1World.setBlock(chunkX + i1, chunkY, chunkZ + j1, this.blockID, l, 4);
                par1World.setBlock(chunkX + i1 + 1, chunkY, chunkZ + j1, this.blockID, l, 4);
                par1World.setBlock(chunkX + i1, chunkY, chunkZ + j1 + 1, this.blockID, l, 4);
                par1World.setBlock(chunkX + i1 + 1, chunkY, chunkZ + j1 + 1, this.blockID, l, 4);
            }
            else
            {
                par1World.setBlock(chunkX, chunkY, chunkZ, this.blockID, l, 4);
            }
        }
    }

    /**
     * Determines if the same sapling is present at the given location.
     */
    public boolean isSameSapling(World par1World, int chunkX, int par3, int par4, int par5)
    {
        return par1World.getBlockId(chunkX, par3, par4) == this.blockID && (par1World.getBlockMetadata(chunkX, par3, par4) & 7) == par5;
    }

    /**
     * Determines the damage on the item the block drops. Used in cloth and wood.
     */
    public int damageDropped(int par1)
    {
        return par1 & 7;
    }

    @SuppressWarnings("unchecked")
    @SideOnly(Side.CLIENT)

    /**
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     */
    public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, @SuppressWarnings("rawtypes") List par3List)
    {
        par3List.add(new ItemStack(par1, 1, 0));
        par3List.add(new ItemStack(par1, 1, 1));
        par3List.add(new ItemStack(par1, 1, 2));
        par3List.add(new ItemStack(par1, 1, 3));
        par3List.add(new ItemStack(par1, 1, 4));
        par3List.add(new ItemStack(par1, 1, 5));
        par3List.add(new ItemStack(par1, 1, 6));
        par3List.add(new ItemStack(par1, 1, 7));
    }

    @SideOnly(Side.CLIENT)

    /**
     * When this method is called, your block should register all the icons it needs with the given IconRegister. This
     * is the only chance you get to register icons.
     */
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.saplingIcon = new Icon[DreamSaplings.length];

        for (int i = 0; i < this.saplingIcon.length; ++i)
        {
            this.saplingIcon[i] = par1IconRegister.registerIcon(Archive.texture + DreamSaplings[i]);
        }
    }
    @Override
    protected boolean canThisPlantGrowOnThisBlockID(int id)
    {
        if(id == ModBlocks.dreamDirt.blockID || id == ModBlocks.dreamGrass.blockID || id == ModBlocks.nmDirt.blockID || id == ModBlocks.nmGrass.blockID)
        {
            return true;
        }
        return false;
    }
    @Override
    public boolean isWood(World world, int x, int y, int z)
    {
        return false;
    }
}
