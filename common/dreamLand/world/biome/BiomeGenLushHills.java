package dreamLand.world.biome;

import java.util.Random;

import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.SpawnListEntry;
import net.minecraft.world.gen.feature.WorldGenShrub;
import net.minecraft.world.gen.feature.WorldGenerator;
import dreamLand.blocks.ModBlocks;
import dreamLand.entity.EntitySonicCreeper;
import dreamLand.world.terrain.trees.WorldGenBigSparklingTree;
import dreamLand.world.terrain.trees.WorldGenBrilliantTrees;



public class BiomeGenLushHills extends BiomeDreamLand{
    
    private BiomeDecoratorDL customBiomeDecorator;
    @SuppressWarnings("unchecked")
    public BiomeGenLushHills(int par1)
    {
        super(par1);
        theBiomeDecorator = new BiomeDecoratorDL(this);
        customBiomeDecorator = (BiomeDecoratorDL)theBiomeDecorator;
        this.sTopBlock = (short) ModBlocks.dreamGrass.blockID;
        this.sFillerBlock = (short) ModBlocks.dreamDirt.blockID;
        this.minHeight = 0.1F;
        this.maxHeight = 0.3F;
        spawnableCreatureList.clear();
        this.spawnableCreatureList.add(new SpawnListEntry(EntityChicken.class, 10, 4, 4));
        this.spawnableCreatureList.add(new SpawnListEntry(EntitySonicCreeper.class, 10, 1, 2));
        this.waterColorMultiplier = 8900670;
        this.customBiomeDecorator.blueFlowersPerChunk = 3;
        this.customBiomeDecorator.grayFlowersPerChunk = 2;
        this.customBiomeDecorator.purpleFlowersPerChunk = 3;
        this.customBiomeDecorator.treesPerChunk = 7;
        this.customBiomeDecorator.nodesPerChunk = 3;


    }
    public int getBiomeGrassColor()
    {
        return 0xA6EDE0;
        //return 0x9ab219;
    }
    /**
     * Allocate a new BiomeDecorator for this BiomeGenBase
     */
    @Override
    public BiomeDecorator createBiomeDecorator()
    {   
        return getModdedBiomeDecorator(new BiomeDecoratorDL(this));
    }
    /**
     * Gets a WorldGen appropriate for this biome. Use this method to add World Gen items to certain Biomes.
     */
    public WorldGenerator getRandomWorldGenForTrees(Random par1Random)
    {
        return (WorldGenerator)(par1Random.nextInt(10) == 4 ? new WorldGenBigSparklingTree(false) : (par1Random.nextInt(2) == 0 ? new WorldGenShrub(3, 0) : (par1Random.nextInt(3) == 0 ? new WorldGenBrilliantTrees(false) : new WorldGenBigSparklingTree(true))));
    }

}
