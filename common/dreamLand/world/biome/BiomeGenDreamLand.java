package dreamLand.world.biome;

import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;
import dreamLand.blocks.ModBlocks;
import dreamLand.world.terrain.WorldGenDreamLandTrees;

public class BiomeGenDreamLand extends BiomeGenBase {

    public WorldGenerator treeGenerator;
    public WorldGenerator ruinsGenerator;

    public short sTopBlock;
    public short sFillerBlock;

    public BiomeGenDreamLand(int par1) {
        super(par1);

        // System.out.println("Silverfish");//test line TODO
        sTopBlock = (short) ModBlocks.dreamGrass.blockID;
        sFillerBlock = (short) ModBlocks.dreamDirt.blockID;
        theBiomeDecorator.treesPerChunk = 10;
        treeGenerator = new WorldGenDreamLandTrees(true);
        /*
         * this.spawnableCreatureList.clear();
         * this.spawnableMonsterList.clear(); this.sTopBlock = (short)
         * DreamLand.dreamGrass.blockID; this.sFillerBlock = (short)
         * DreamLand.dreamDirt.blockID;
         */
    }

    /**
     * Allocate a new BiomeDecorator for this BiomeGenBase
     */
    @Override
    public BiomeDecorator createBiomeDecorator() {
        return new BiomeDecoratorDreamLand(this);
    }
}
