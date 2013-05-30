package dreamLand.world.terrain;

import dreamLand.blocks.ModBlocks;

import net.minecraft.world.gen.feature.WorldGenMinable;

public class WorldGenNMMinable extends WorldGenMinable {

    public WorldGenNMMinable(int par1, int par2)
    {
        this(par1, par2, ModBlocks.nmStone.blockID);
    }

    public WorldGenNMMinable(int par1, int par2, int par3)
    {
        super(par1,par2,par3);
    }

    public WorldGenNMMinable(int id, int meta, int number, int target)
    {
        this(id, number, target);
    }

}
