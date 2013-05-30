package dreamLand.world.biome;

import java.util.Random;

import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.SpawnListEntry;
import net.minecraft.world.gen.feature.WorldGenHugeTrees;
import net.minecraft.world.gen.feature.WorldGenShrub;
import net.minecraft.world.gen.feature.WorldGenerator;
import dreamLand.blocks.ModBlocks;
import dreamLand.entity.EntitySonicCreeper;
import dreamLand.world.terrain.trees.WorldGenBigSparklingTree;
import dreamLand.world.terrain.trees.WorldGenBrilliantTrees;



public class BiomeGenLucidDL extends BiomeDreamLand{
	@SuppressWarnings("unchecked")
	public BiomeGenLucidDL(int i)
	{
		super(i);
		this.sTopBlock = (short) ModBlocks.dreamGrass.blockID;
        this.sFillerBlock = (short) ModBlocks.dreamDirt.blockID;
        this.minHeight = 0.1F;
		this.maxHeight = 0.3F;
		this.theBiomeDecorator.treesPerChunk = 7;
		spawnableCreatureList.clear();
        this.spawnableCreatureList.add(new SpawnListEntry(EntityChicken.class, 10, 4, 4));
        this.spawnableCreatureList.add(new SpawnListEntry(EntitySonicCreeper.class, 3, 1, 2));
        
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
        return (WorldGenerator)(par1Random.nextInt(10) == 4 ? this.worldGeneratorBigSparklingTree : (par1Random.nextInt(2) == 0 ? new WorldGenShrub(3, 0) : (par1Random.nextInt(3) == 0 ? new WorldGenBrilliantTrees(false) : new WorldGenBigSparklingTree(true))));
    }
    
}
