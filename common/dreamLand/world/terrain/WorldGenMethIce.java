package dreamLand.world.terrain;

import java.util.Random;

import dreamLand.blocks.ModBlocks;

import net.minecraft.block.material.Material;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenMethIce extends WorldGenerator{
	/** The block ID for clay. */
    private int methaneBlockId;

    /** The number of blocks to generate. */
    private int numberOfBlocks;

    public WorldGenMethIce(int par1)
    {
        this.methaneBlockId = ModBlocks.oreMethaneClathrate.blockID;
        this.numberOfBlocks = par1;
    }

    public boolean generate(World par1World, Random par2Random, int par3, int par4, int par5)
    {
        if (par1World.getBlockMaterial(par3, par4, par5) != Material.water)
        {
            return false;
        }
        else
        {
            int l = par2Random.nextInt(this.numberOfBlocks - 2) + 2;
            byte b0 = 1;

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

                            if (j2 == ModBlocks.dreamDirt.blockID || j2 == ModBlocks.oreMethaneClathrate.blockID)
                            {
                                par1World.setBlock(i1, i2, j1, this.methaneBlockId, 0, 2);
                            }
                        }
                    }
                }
            }

            return true;
        }
    }
}
