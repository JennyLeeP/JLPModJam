package dreamLand.world.terrain.trees;

import java.util.Random;

import dreamLand.blocks.BlockDreamSaplings;
import dreamLand.blocks.ModBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSapling;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.ForgeDirection;

public class WorldGenAshTrees extends WorldGenerator{

    public WorldGenAshTrees(boolean par1)
    {
        super(par1);
    }
    @Override
    
    public boolean generate(World par1World, Random par2Random, int posX, int posY, int posZ)
    {
        int l = par2Random.nextInt(3) + 5;
        boolean flag = true;

        if (posY >= 1 && posY + l + 1 <= 256)//generates tree if posY is greater than 1 and less than 256
        {
            int i1;//y
            int j1;//x
            int k1;//z
            int l1;

            for (i1 = posY; i1 <= posY + 1 + l; ++i1)
            {
                byte b0 = 1;

                if (i1 == posY)
                {
                    b0 = 0;
                }

                if (i1 >= posY + 1 + l - 2)
                {
                    b0 = 2;
                }

                for (j1 = posX - b0; j1 <= posX + b0 && flag; ++j1)
                {
                    for (k1 = posZ - b0; k1 <= posZ + b0 && flag; ++k1)
                    {
                        if (i1 >= 0 && i1 < 256)
                        {
                            l1 = par1World.getBlockId(j1, i1, k1);

                            Block block = Block.blocksList[l1];

                            if (l1 != 0 && (block != null && !block.isLeaves(par1World, j1,  i1, k1)))
                            {
                                flag = false;
                            }
                        }
                        else
                        {
                            flag = false;
                        }
                    }
                }
            }

            if (!flag)
            {
                return false;
            }
            else
            {
                i1 = par1World.getBlockId(posX, posY - 1, posZ);
                Block soil = Block.blocksList[i1];
                boolean isValidSoil = soil != null && soil.canSustainPlant(par1World, posX, posY - 1, posZ, ForgeDirection.UP, (BlockDreamSaplings)ModBlocks.dreamSaplings);

                if (isValidSoil && posY < 256 - l - 1)
                {
                    soil.onPlantGrow(par1World, posX, posY - 1, posZ, posX, posY, posZ);
                    int i2;

                    for (i2 = posY - 3 + l; i2 <= posY + l; ++i2)
                    {
                        j1 = i2 - (posY + l);
                        k1 = 1 - j1 / 2;

                        for (l1 = posX - k1; l1 <= posX + k1; ++l1)
                        {
                            int j2 = l1 - posX;

                            for (int k2 = posZ - k1; k2 <= posZ + k1; ++k2)
                            {
                                int l2 = k2 - posZ;

                                if (Math.abs(j2) != k1 || Math.abs(l2) != k1 || par2Random.nextInt(2) != 0 && j1 != 0)
                                {
                                    int i3 = par1World.getBlockId(l1, i2, k2);
                                    Block block = Block.blocksList[i3];

                                    if (block == null || block.canBeReplacedByLeaves(par1World, l1, i2, k2))
                                    {
                                        this.setBlockAndMetadata(par1World, l1, i2, k2, ModBlocks.dreamLeaves.blockID, 1);
                                    }
                                }
                            }
                        }
                    }

                    for (i2 = 0; i2 < l; ++i2)
                    {
                        j1 = par1World.getBlockId(posX, posY + i2, posZ);

                        Block block = Block.blocksList[j1];

                        if (j1 == 0 || block == null || block.isLeaves(par1World, posX, posY + i2, posZ))
                        {
                            this.setBlockAndMetadata(par1World, posX, posY + i2, posZ, ModBlocks.nmLogs.blockID, 0);
                        }
                    }

                    return true;
                }
                else
                {
                    return false;
                }
            }
        }
        else
        {
            return false;
        }
    }
}
