package dreamLand.world.terrain;

import java.util.Random;

import dreamLand.blocks.ModBlocks;

import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenCursedNodes extends WorldGenerator {

    private int blockId;
    private int metaID;

    public WorldGenCursedNodes(int par1, int par2) {
        this.blockId = par1;
        this.metaID = par2;
    }
    @Override
    public boolean generate(World world, Random random, int x, int y, int z) {
       
        int var1 = world.getBlockId(x, y, z);
        for (int i1 = 0; i1 < 64; i1++){
            if(var1 == ModBlocks.dreamStone.blockID){
                // Center Block
                world.setBlock(x, y, z, this.blockId, this.metaID, 2);
                // Surrounding Blocks
                world.setBlock(x - 1, y, z, this.blockId, this.metaID, 2);
                world.setBlock(x + 1, y, z, this.blockId, this.metaID, 2);
                world.setBlock(x, y - 1, z, this.blockId, this.metaID, 2);
                world.setBlock(x, y + 1, z, this.blockId, this.metaID, 2);
                world.setBlock(x, y, z - 1, this.blockId, this.metaID, 2);
                world.setBlock(x, y, z + 1, this.blockId, this.metaID, 2);
            }
        }
        return true;
    }

}
