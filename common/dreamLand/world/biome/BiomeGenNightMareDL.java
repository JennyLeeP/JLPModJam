package dreamLand.world.biome;

import java.util.Random;

import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.SpawnListEntry;
import net.minecraft.world.gen.feature.WorldGenShrub;
import net.minecraft.world.gen.feature.WorldGenerator;
import dreamLand.blocks.ModBlocks;
import dreamLand.entity.EntityNMCreeper;
import dreamLand.world.terrain.trees.WorldGenAshTrees;
import dreamLand.world.terrain.trees.WorldGenInfernalTrees;

public class BiomeGenNightMareDL extends BiomeDreamLand{

	@SuppressWarnings("unchecked")
	public BiomeGenNightMareDL(int i)
	{
		super(i);
		this.sTopBlock = (short) ModBlocks.nmGrass.blockID;
        this.sFillerBlock = (short) ModBlocks.nmDirt.blockID;
        this.minHeight = 0.1F;
		this.maxHeight = 0.3F;
		spawnableCreatureList.clear();
		this.spawnableCreatureList.add(new SpawnListEntry(EntityNMCreeper.class, 20, 1, 1));
	}
	/**
     * Allocate a new BiomeDecorator for this BiomeGenBase
     */
	@Override
    public BiomeDecorator createBiomeDecorator()
    {   
        return getModdedBiomeDecorator(new BiomeDecoratorNM(this));
    }
	/**
     * Gets a WorldGen appropriate for this biome. Use this method to add World Gen items to certain Biomes.
     */
    public WorldGenerator getRandomWorldGenForTrees(Random par1Random)
    {
        return (WorldGenerator)(par1Random.nextInt(10) == 4 ? this.worldGeneratorAshTrees : (par1Random.nextInt(2) == 0 ? new WorldGenShrub(3, 0) : (par1Random.nextInt(3) == 0 ? new WorldGenAshTrees(false) : new WorldGenInfernalTrees(true))));
    }
}
