package dreamLand.world.biome;

import java.util.Random;

import cpw.mods.fml.common.ObfuscationReflectionHelper;

import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import dreamLand.world.terrain.trees.WorldGenAshTrees;
import dreamLand.world.terrain.trees.WorldGenBigSparklingTree;

public class BiomeDreamLand extends BiomeGenBase {
	/** The big tree generator. */
    protected WorldGenBigSparklingTree worldGeneratorBigSparklingTree;
    protected WorldGenAshTrees worldGeneratorAshTrees;
    
    public short sTopBlock;
    public short sFillerBlock;
    
    public BiomeDreamLand(int par1) {
        super(par1);
        this.worldGeneratorBigSparklingTree = new WorldGenBigSparklingTree(false);
        this.worldGeneratorAshTrees = new WorldGenAshTrees(false);
    }
    @Override
	public void decorate(World par1World, Random par2Random, int par3, int par4)
	{
		this.theBiomeDecorator.decorate(par1World, par2Random, par3, par4);
	}
    
    @Override
	public BiomeDreamLand setBiomeName(String par1Str)
	{
		this.biomeName = par1Str;
		return this;
	}
    @Override
	public BiomeDreamLand setColor(int par1)
	{
		this.color = par1;
		return this;
	}
    /**
	 * Disable the rain for the biome.
	 */
	@Override
	public BiomeDreamLand setDisableRain()
	{
		ObfuscationReflectionHelper.setPrivateValue(BiomeGenBase.class, this, false, 39);
		return this;
	}
}
