package dreamLand.world.biome;

import static net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.BIG_SHROOM;
import static net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.CACTUS;
import static net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.CLAY;
import static net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.FLOWERS;
import static net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS;
import static net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.LAKE;
import static net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.LILYPAD;
import static net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.PUMPKIN;
import static net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.REED;
import static net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.SAND;
import static net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.SAND_PASS2;
import static net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.SHROOM;
import static net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.TREE;
import java.util.Random;

import dreamLand.world.terrain.WorldGenDreamLandTrees;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenLiquids;
import net.minecraft.world.gen.feature.WorldGenPumpkin;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;
import net.minecraftforge.event.terraingen.TerrainGen;

public class BiomeDecoratorDreamLand extends BiomeDecorator {

    public short sTopBlock;
    public short sFillerBlock;
    // public boolean
    @SuppressWarnings("unused")
    private WorldGenDreamLandTrees treeGenerator;

    public BiomeDecoratorDreamLand(BiomeGenBase par1BiomeGenBase) {
        super(par1BiomeGenBase);
    }

        

    /**
     * The method that does the work of actually decorating chunks
     */
    @Override
    protected void decorate() {
    System.out.println("decorate line 67 in BiomeDecoratorDreamLand");
        MinecraftForge.EVENT_BUS.post(new DecorateBiomeEvent.Pre(currentWorld, randomGenerator,
                chunk_X, chunk_Z));

        this.generateOres();
        int i;
        int j;
        int k;

        boolean doGen = TerrainGen.decorate(currentWorld, randomGenerator, chunk_X, chunk_Z, SAND);
        for (i = 0; doGen && (i < sandPerChunk2); ++i){
            j = chunk_X + randomGenerator.nextInt(16) + 8;
            k = chunk_Z + randomGenerator.nextInt(16) + 8;
            sandGen.generate(currentWorld, randomGenerator, j,
                    currentWorld.getTopSolidOrLiquidBlock(j, k), k);
            //this.treeGenerator.generate(this.currentWorld,
            // this.randomGenerator, j,
            // this.currentWorld.getTopSolidOrLiquidBlock(j, k), k);
            System.out.println(currentWorld);
        }

        doGen = TerrainGen.decorate(currentWorld, randomGenerator, chunk_X, chunk_Z, CLAY);
        for (i = 0; doGen && (i < clayPerChunk); ++i){
            j = chunk_X + randomGenerator.nextInt(16) + 8;
            k = chunk_Z + randomGenerator.nextInt(16) + 8;
            clayGen.generate(currentWorld, randomGenerator, j,
                    currentWorld.getTopSolidOrLiquidBlock(j, k), k);
        }

        doGen = TerrainGen.decorate(currentWorld, randomGenerator, chunk_X, chunk_Z, SAND_PASS2);
        for (i = 0; doGen && (i < sandPerChunk); ++i){
            j = chunk_X + randomGenerator.nextInt(16) + 8;
            k = chunk_Z + randomGenerator.nextInt(16) + 8;
            sandGen.generate(currentWorld, randomGenerator, j,
                    currentWorld.getTopSolidOrLiquidBlock(j, k), k);
        }

        i = treesPerChunk;

        if (randomGenerator.nextInt(10) == 0){
            ++i;
        }

        int l;

        doGen = TerrainGen.decorate(currentWorld, randomGenerator, chunk_X, chunk_Z, TREE);
        i = (int) (randomGenerator.nextFloat() + 0.1);
        for (j = 0; doGen && (j < i); ++j){
            k = chunk_X + randomGenerator.nextInt(16) + 8;
            l = chunk_Z + randomGenerator.nextInt(16) + 8;
            WorldGenerator worldgenerator = biome.getRandomWorldGenForTrees(randomGenerator);
            worldgenerator.setScale(1.0D, 1.0D, 1.0D);
            worldgenerator.generate(currentWorld, randomGenerator, k,
                    currentWorld.getHeightValue(k, l), l);
        }

        doGen = TerrainGen.decorate(currentWorld, randomGenerator, chunk_X, chunk_Z, BIG_SHROOM);
        for (j = 0; doGen && (j < bigMushroomsPerChunk); ++j){
            k = chunk_X + randomGenerator.nextInt(16) + 8;
            l = chunk_Z + randomGenerator.nextInt(16) + 8;
            bigMushroomGen.generate(currentWorld, randomGenerator, k,
                    currentWorld.getHeightValue(k, l), l);
        }

        int i1;

        doGen = TerrainGen.decorate(currentWorld, randomGenerator, chunk_X, chunk_Z, FLOWERS);
        for (j = 0; doGen && (j < flowersPerChunk); ++j){
            k = chunk_X + randomGenerator.nextInt(16) + 8;
            l = randomGenerator.nextInt(128);
            i1 = chunk_Z + randomGenerator.nextInt(16) + 8;
            plantYellowGen.generate(currentWorld, randomGenerator, k, l, i1);

            if (randomGenerator.nextInt(4) == 0){
                k = chunk_X + randomGenerator.nextInt(16) + 8;
                l = randomGenerator.nextInt(128);
                i1 = chunk_Z + randomGenerator.nextInt(16) + 8;
                plantRedGen.generate(currentWorld, randomGenerator, k, l, i1);
            }
        }

        doGen = TerrainGen.decorate(currentWorld, randomGenerator, chunk_X, chunk_Z, GRASS);
        for (j = 0; doGen && (j < grassPerChunk); ++j){
            k = chunk_X + randomGenerator.nextInt(16) + 8;
            l = randomGenerator.nextInt(128);
            i1 = chunk_Z + randomGenerator.nextInt(16) + 8;
            WorldGenerator worldgenerator1 = biome.getRandomWorldGenForGrass(randomGenerator);
            worldgenerator1.generate(currentWorld, randomGenerator, k, l, i1);
        }

        doGen = TerrainGen.decorate(currentWorld, randomGenerator, chunk_X, chunk_Z, LILYPAD);
        for (j = 0; doGen && (j < waterlilyPerChunk); ++j){
            k = chunk_X + randomGenerator.nextInt(16) + 8;
            l = chunk_Z + randomGenerator.nextInt(16) + 8;

            for (i1 = randomGenerator.nextInt(128); (i1 > 0)
                    && (currentWorld.getBlockId(k, i1 - 1, l) == 0); --i1){
                ;
            }

            waterlilyGen.generate(currentWorld, randomGenerator, k, i1, l);
        }

        doGen = TerrainGen.decorate(currentWorld, randomGenerator, chunk_X, chunk_Z, SHROOM);
        for (j = 0; doGen && (j < mushroomsPerChunk); ++j){
            if (randomGenerator.nextInt(4) == 0){
                k = chunk_X + randomGenerator.nextInt(16) + 8;
                l = chunk_Z + randomGenerator.nextInt(16) + 8;
                i1 = currentWorld.getHeightValue(k, l);
                mushroomBrownGen.generate(currentWorld, randomGenerator, k, i1, l);
            }

            if (randomGenerator.nextInt(8) == 0){
                k = chunk_X + randomGenerator.nextInt(16) + 8;
                l = chunk_Z + randomGenerator.nextInt(16) + 8;
                i1 = randomGenerator.nextInt(128);
                mushroomRedGen.generate(currentWorld, randomGenerator, k, i1, l);
            }
        }

        if (doGen && (randomGenerator.nextInt(4) == 0)){
            j = chunk_X + randomGenerator.nextInt(16) + 8;
            k = randomGenerator.nextInt(128);
            l = chunk_Z + randomGenerator.nextInt(16) + 8;
            mushroomBrownGen.generate(currentWorld, randomGenerator, j, k, l);
        }

        if (doGen && (randomGenerator.nextInt(8) == 0)){
            j = chunk_X + randomGenerator.nextInt(16) + 8;
            k = randomGenerator.nextInt(128);
            l = chunk_Z + randomGenerator.nextInt(16) + 8;
            mushroomRedGen.generate(currentWorld, randomGenerator, j, k, l);
        }

        doGen = TerrainGen.decorate(currentWorld, randomGenerator, chunk_X, chunk_Z, REED);
        for (j = 0; doGen && (j < reedsPerChunk); ++j){
            k = chunk_X + randomGenerator.nextInt(16) + 8;
            l = chunk_Z + randomGenerator.nextInt(16) + 8;
            i1 = randomGenerator.nextInt(128);
            reedGen.generate(currentWorld, randomGenerator, k, i1, l);
        }

        for (j = 0; doGen && (j < 10); ++j){
            k = chunk_X + randomGenerator.nextInt(16) + 8;
            l = randomGenerator.nextInt(128);
            i1 = chunk_Z + randomGenerator.nextInt(16) + 8;
            reedGen.generate(currentWorld, randomGenerator, k, l, i1);
        }

        doGen = TerrainGen.decorate(currentWorld, randomGenerator, chunk_X, chunk_Z, PUMPKIN);
        if (doGen && (randomGenerator.nextInt(32) == 0)){
            j = chunk_X + randomGenerator.nextInt(16) + 8;
            k = randomGenerator.nextInt(128);
            l = chunk_Z + randomGenerator.nextInt(16) + 8;
            (new WorldGenPumpkin()).generate(currentWorld, randomGenerator, j, k, l);
        }

        doGen = TerrainGen.decorate(currentWorld, randomGenerator, chunk_X, chunk_Z, CACTUS);
        for (j = 0; doGen && (j < cactiPerChunk); ++j){
            k = chunk_X + randomGenerator.nextInt(16) + 8;
            l = randomGenerator.nextInt(128);
            i1 = chunk_Z + randomGenerator.nextInt(16) + 8;
            cactusGen.generate(currentWorld, randomGenerator, k, l, i1);
        }

        doGen = TerrainGen.decorate(currentWorld, randomGenerator, chunk_X, chunk_Z, LAKE);
        if (doGen && generateLakes){
            for (j = 0; j < 50; ++j){
                k = chunk_X + randomGenerator.nextInt(16) + 8;
                l = randomGenerator.nextInt(randomGenerator.nextInt(120) + 8);
                i1 = chunk_Z + randomGenerator.nextInt(16) + 8;
                (new WorldGenLiquids(Block.tnt.blockID)).generate(currentWorld, randomGenerator, k,
                        l, i1);
            }

            for (j = 0; j < 20; ++j){
                k = chunk_X + randomGenerator.nextInt(16) + 8;
                l = randomGenerator
                        .nextInt(randomGenerator.nextInt(randomGenerator.nextInt(112) + 8) + 8);
                i1 = chunk_Z + randomGenerator.nextInt(16) + 8;
                (new WorldGenLiquids(Block.lavaMoving.blockID)).generate(currentWorld,
                        randomGenerator, k, l, i1);
            }
        }

        MinecraftForge.EVENT_BUS.post(new DecorateBiomeEvent.Post(currentWorld, randomGenerator,
                chunk_X, chunk_Z));
    }

    /**
	 * Decorates the world. Calls code that was formerly (pre-1.8) in ChunkProviderGenerate.populate
	 */
	@Override
	public void decorate(World par1World, Random par2Random, int par3, int par4)
	{
		if (this.currentWorld != null)
		{
			//throw new RuntimeException("Already decorating!!");
		}
		else
		{
			this.currentWorld = par1World;
			this.randomGenerator = par2Random;
			this.chunk_X = par3;
			this.chunk_Z = par4;
			this.decorate();
			this.currentWorld = null;
			this.randomGenerator = null;
		}
	}

    /**
	 * Standard ore generation helper. Generates most ores.
	 */
	@Override
	protected void genStandardOre1(int par1, WorldGenerator par2WorldGenerator, int par3, int par4)
	{
		for (int var5 = 0; var5 < par1; ++var5)
		{
			int var6 = this.chunk_X + this.randomGenerator.nextInt(16);
			int var7 = this.randomGenerator.nextInt(par4 - par3) + par3;
			int var8 = this.chunk_Z + this.randomGenerator.nextInt(16);
			par2WorldGenerator.generate(this.currentWorld, this.randomGenerator, var6, var7, var8);
		}
	}

	/**
	 * Standard ore generation helper. Generates Lapis Lazuli.
	 */
	@Override
	protected void genStandardOre2(int par1, WorldGenerator par2WorldGenerator, int par3, int par4)
	{
		for (int var5 = 0; var5 < par1; ++var5)
		{
			int var6 = this.chunk_X + this.randomGenerator.nextInt(16);
			int var7 = this.randomGenerator.nextInt(par4) + this.randomGenerator.nextInt(par4) + par3 - par4;
			int var8 = this.chunk_Z + this.randomGenerator.nextInt(16);
			par2WorldGenerator.generate(this.currentWorld, this.randomGenerator, var6, var7, var8);
		}
	}
}
