package dreamLand.world.terrain;

import dreamLand.blocks.ModBlocks;

import net.minecraft.world.gen.feature.WorldGenMinable;

public class WorldGenDLMinable extends WorldGenMinable {

    public WorldGenDLMinable(int par1, int par2)
    {
        this(par1, par2, ModBlocks.dreamStone.blockID);
    }

    public WorldGenDLMinable(int par1, int par2, int par3)
    {
        super(par1,par2,par3);
    }

    public WorldGenDLMinable(int id, int meta, int number, int target)
    {
        this(id, number, target);
    }

    


}
