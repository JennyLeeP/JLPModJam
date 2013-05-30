package dreamLand.world.terrain;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenDLFlowers extends WorldGenerator {

    /** The ID of the plant block used in this plant generator. */
    private int plantBlockId;
    @SuppressWarnings("unused")
    private int metaID;

    public WorldGenDLFlowers(int par1)
    {
        this.plantBlockId = par1;
    }
    
    public WorldGenDLFlowers(int par1, int par2) {
        this.plantBlockId = par1;
        this.metaID = par2;
    }

    @Override
    public boolean generate(World par1World, Random par2Random, int posX, int posY, int posZ) {
        for (int l = 0; l < 64; ++l)
        {
            int i1 = posX + par2Random.nextInt(8) - par2Random.nextInt(8);
            int j1 = posY + par2Random.nextInt(4) - par2Random.nextInt(4);
            int k1 = posZ + par2Random.nextInt(8) - par2Random.nextInt(8);

            if (par1World.isAirBlock(i1, j1, k1) && (!par1World.provider.hasNoSky || j1 < 127) && Block.blocksList[this.plantBlockId].canBlockStay(par1World, i1, j1, k1))
            {
                par1World.setBlock(i1, j1, k1, this.plantBlockId, 0, 2);
            }
        }

        return true;
    }

}
