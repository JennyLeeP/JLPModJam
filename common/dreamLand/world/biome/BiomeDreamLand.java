package dreamLand.world.biome;

import java.util.Random;

import cpw.mods.fml.common.ObfuscationReflectionHelper;

import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;
import dreamLand.blocks.ModBlocks;
import dreamLand.world.terrain.WorldGenSparklingTree;

public class BiomeDreamLand extends BiomeGenBase {

	public static int LucidColor = 0x56621;
	public static int LucidWater = 0x228855;
	public static int NightmareColor = 0x56621;
	public static int NightmareWater = 0x228855;
	
	public static final BiomeDreamLand lucid = (new BiomeGenLucidDL(7)).setColor(LucidColor).setBiomeName("Lucid");

	public static final BiomeDreamLand nightmare = (new BiomeGenNightMareDL(8)).setColor(16711680).setBiomeName("NightMare").setDisableRain();

    public short sTopBlock;
    public short sFillerBlock;

    
    protected static WorldGenSparklingTree worldGenDreamLandTrees;
    
    
    public BiomeDreamLand(int par1) {
        super(par1);

        System.out.println("Silverfish line 20 BiomeGenDreamLand");
        this.sTopBlock = (short) ModBlocks.dreamGrass.blockID;
        this.sFillerBlock = (short) ModBlocks.dreamDirt.blockID;
        this.minHeight = 0.1F;
		this.maxHeight = 0.3F;
		
		worldGenDreamLandTrees = new WorldGenSparklingTree(true);
		
		//this.spawnableCreatureList.add(new SpawnListEntry(EntityPigTFC.class, 10, 4, 4));
		this.theBiomeDecorator = this.createBiomeDecorator();
		
		this.spawnableMonsterList.clear();
		
		
    }

    /**
     * Allocate a new BiomeDecorator for this BiomeGenBase
     */
    @Override
    public BiomeDecorator createBiomeDecorator() {
        return new BiomeDecoratorDreamLand(this);
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
