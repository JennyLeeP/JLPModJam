package dreamLand.world.terrain;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import dreamLand.blocks.ModBlocks;

public class WorldGenNMSand extends WorldGenerator{
    /** Stores ID for WorldGenSand */
    private int sandID;

    /** The maximum radius used when generating a patch of blocks. */
    private int radius;
    private int metaData;

    
    public WorldGenNMSand(int par1, int par2, int par3) {
        this.sandID = par2;
        this.radius = par1;
        this.metaData = par3;
        
    }
    @Override
    public boolean generate(World par1World, Random par2Random, int par3, int par4, int par5) {
        if (par1World.getBlockMaterial(par3, par4, par5) != Material.lava)
        {
            return false;
        }
        else
        {
            int l = par2Random.nextInt(this.radius - 2) + 2;
            byte b0 = 2;

            for (int i1 = par3 - l; i1 <= par3 + l; ++i1)
            {
                for (int j1 = par5 - l; j1 <= par5 + l; ++j1)
                {
                    int k1 = i1 - par3;
                    int l1 = j1 - par5;

                    if (k1 * k1 + l1 * l1 <= l * l)
                    {
                        for (int i2 = par4 - b0; i2 <= par4 + b0; ++i2)
                        {
                            int j2 = par1World.getBlockId(i1, i2, j1);
                            if (j2 == ModBlocks.nmDirt.blockID || j2 == ModBlocks.nmGrass.blockID)
                            {
                                //System.out.println("Sand NM Meta = "+ metaData);
                                this.setBlockAndMetadata(par1World, i1, i2, j1, this.sandID,  this.metaData);
                                //par1World.setBlock(i1, i2, j1, this.sandID, 0, 2);
                            }
                        }
                    }
                }
            }

            return true;
        }
        
    }
}
