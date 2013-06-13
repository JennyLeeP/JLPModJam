package dreamLand.world.terrain;

import static net.minecraftforge.event.terraingen.PopulateChunkEvent.Populate.EventType.DUNGEON;
import static net.minecraftforge.event.terraingen.PopulateChunkEvent.Populate.EventType.LAKE;
import static net.minecraftforge.event.terraingen.PopulateChunkEvent.Populate.EventType.LAVA;

import java.util.List;
import java.util.Random;

import dreamLand.blocks.ModBlocks;
import dreamLand.world.biome.BiomeDreamLand;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSand;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.util.MathHelper;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.SpawnerAnimals;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.ChunkProviderGenerate;
import net.minecraft.world.gen.NoiseGeneratorOctaves;
import net.minecraft.world.gen.feature.WorldGenLakes;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.Event.Result;
import net.minecraftforge.event.terraingen.ChunkProviderEvent;
import net.minecraftforge.event.terraingen.PopulateChunkEvent;
import net.minecraftforge.event.terraingen.TerrainGen;

public class ChunkProviderNightMare extends ChunkProviderGenerate {

	/** RNG. */
	private Random rand;

	/** A NoiseGeneratorOctaves used in generating terrain */
	private NoiseGeneratorOctaves noiseGen1;

	/** A NoiseGeneratorOctaves used in generating terrain */
	private NoiseGeneratorOctaves noiseGen2;

	/** A NoiseGeneratorOctaves used in generating terrain */
	private NoiseGeneratorOctaves noiseGen3;

	/** A NoiseGeneratorOctaves used in generating terrain */
	private NoiseGeneratorOctaves noiseGen4;

	/** A NoiseGeneratorOctaves used in generating terrain */
	public NoiseGeneratorOctaves noiseGen5;

	/** A NoiseGeneratorOctaves used in generating terrain */
	public NoiseGeneratorOctaves noiseGen6;
	public NoiseGeneratorOctaves mobSpawnerNoise;

	/** Reference to the World object. */
	private World worldObj;

	/** Holds the overall noise array used in chunk generation */
	private double[] noiseArray;
	private double[] stoneNoise = new double[256];

	/** The biomes that are used to generate the chunk */
	private BiomeGenBase[] biomesForGeneration;

	/** A double array that hold terrain noise from noiseGen3 */
	double[] noise3;

	/** A double array that hold terrain noise */
	double[] noise1;

	/** A double array that hold terrain noise from noiseGen2 */
	double[] noise2;

	/** A double array that hold terrain noise from noiseGen5 */
	double[] noise5;

	/** A double array that holds terrain noise from noiseGen6 */
	double[] noise6;

	/**
	 * Used to store the 5x5 parabolic field that is used during terrain
	 * generation.
	 */
	float[] parabolicField;
	int[][] field_73219_j = new int[32][32];
	
	private final boolean mapFeaturesEnabled;

	public ChunkProviderNightMare(World par1World, long par2, boolean par4) {
		super(par1World, par2, par4);
		this.worldObj = par1World;
		this.mapFeaturesEnabled = par4;
		this.rand = new Random(par2);
		this.noiseGen1 = new NoiseGeneratorOctaves(this.rand, 16);
		this.noiseGen2 = new NoiseGeneratorOctaves(this.rand, 16);
		this.noiseGen3 = new NoiseGeneratorOctaves(this.rand, 8);
		this.noiseGen4 = new NoiseGeneratorOctaves(this.rand, 4);
		this.noiseGen5 = new NoiseGeneratorOctaves(this.rand, 10);
		this.noiseGen6 = new NoiseGeneratorOctaves(this.rand, 16);
		this.mobSpawnerNoise = new NoiseGeneratorOctaves(this.rand, 8);

		NoiseGeneratorOctaves[] noiseGens = {noiseGen1, noiseGen2, noiseGen3, noiseGen4, noiseGen5, noiseGen6, mobSpawnerNoise};
		noiseGens = TerrainGen.getModdedNoiseGenerators(par1World, this.rand, noiseGens);
		this.noiseGen1 = noiseGens[0];
		this.noiseGen2 = noiseGens[1];
		this.noiseGen3 = noiseGens[2];
		this.noiseGen4 = noiseGens[3];
		this.noiseGen5 = noiseGens[4];
		this.noiseGen6 = noiseGens[5];
		this.mobSpawnerNoise = noiseGens[6];
	}

	/**
	 * Will return back a chunk, if it doesn't exist and its not a MP client it
	 * will generates all the blocks for the specified chunk from the map seed
	 * and chunk seed
	 */

	@Override
	public Chunk provideChunk(int chunkX, int chunkZ) {
		rand.setSeed((chunkX * 341873128712L) + (chunkZ * 132897987541L));
		short[] abyte = new short[32768];
		this.generateTerrain(chunkX, chunkZ, abyte);
		biomesForGeneration = worldObj.getWorldChunkManager().loadBlockGeneratorData(biomesForGeneration, chunkX * 16, chunkZ * 16, 16, 16);
		this.replaceBlocksForBiome(chunkX, chunkZ, abyte, biomesForGeneration);
		new MapGenCavesDL().generate(this,this.worldObj, chunkX, chunkZ, abyte);
		new MapGenRavineDL().generate(this,this.worldObj, chunkX, chunkZ, abyte);
		
		if (mapFeaturesEnabled){
			
		}

		short[] ashort = new short[32768];
		int yMax = 32768 / 256;
		for (int x = 0; x < 16; x++){
			for (int z = 0; z < 16; z++){
				for (int y = 0; y < yMax; y++){
					int idx = (y << 8) | (z << 4) | x;
					int ido = (x << 11) | (z << 7) | y;
					ashort[idx] = abyte[ido];
				}
			}
		}

		Chunk chunk = new Chunk(worldObj, ashort, new byte[32768], chunkX, chunkZ);
		byte[] abyte1 = chunk.getBiomeArray();

		for (int k = 0; k < abyte1.length; ++k){
			abyte1[k] = (byte) biomesForGeneration[k].biomeID;
		}

		chunk.generateSkylightMap();
		return chunk;
	}

	/**
	 * Populates chunk with ores etc etc
	 */
	public void populate(IChunkProvider par1IChunkProvider, int par2, int par3)
	{
		BlockSand.fallInstantly = true;
		int k = par2 * 16;
		int l = par3 * 16;
		BiomeDreamLand biomedreamland = (BiomeDreamLand) this.worldObj.getBiomeGenForCoords(k + 16, l + 16);
		this.rand.setSeed(this.worldObj.getSeed());
		long i1 = this.rand.nextLong() / 2L * 2L + 1L;
		long j1 = this.rand.nextLong() / 2L * 2L + 1L;
		this.rand.setSeed((long)par2 * i1 + (long)par3 * j1 ^ this.worldObj.getSeed());
		boolean flag = false;

		MinecraftForge.EVENT_BUS.post(new PopulateChunkEvent.Pre(par1IChunkProvider, worldObj, rand, par2, par3, flag));



		int k1;
		int l1;
		int i2;

		if (TerrainGen.populate(par1IChunkProvider, worldObj, rand, par2, par3, flag, LAKE) && 
				!flag && this.rand.nextInt(4) == 0)
		{
			k1 = k + this.rand.nextInt(16) + 8;
			l1 = this.rand.nextInt(128);
			i2 = l + this.rand.nextInt(16) + 8;
			(new WorldGenLakes(Block.waterStill.blockID)).generate(this.worldObj, this.rand, k1, l1, i2);//water
		}

		if (TerrainGen.populate(par1IChunkProvider, worldObj, rand, par2, par3, flag, LAVA) &&
				!flag && this.rand.nextInt(8) == 0)
		{
			k1 = k + this.rand.nextInt(16) + 8;
			l1 = this.rand.nextInt(this.rand.nextInt(120) + 8);
			i2 = l + this.rand.nextInt(16) + 8;

			if (l1 < 63 || this.rand.nextInt(10) == 0)
			{
				(new WorldGenLakes(Block.lavaStill.blockID)).generate(this.worldObj, this.rand, k1, l1, i2);//lava
			}
		}

		boolean doGen = TerrainGen.populate(par1IChunkProvider, worldObj, rand, par2, par3, flag, DUNGEON);
		for (k1 = 0; doGen && k1 < 8; ++k1)
		{
			l1 = k + this.rand.nextInt(16) + 8;
			i2 = this.rand.nextInt(128);
			int j2 = l + this.rand.nextInt(16) + 8;

			if ((new WorldGenDLDungeons()).generate(this.worldObj, this.rand, l1, i2, j2))
			{
				;
			}
		}

		biomedreamland.decorate(this.worldObj, this.rand, k, l);
		SpawnerAnimals.performWorldGenSpawning(this.worldObj, biomedreamland, k + 8, l + 8, 16, 16, this.rand);
		k += 8;
		l += 8;


		MinecraftForge.EVENT_BUS.post(new PopulateChunkEvent.Post(par1IChunkProvider, worldObj, rand, par2, par3, flag));

		BlockSand.fallInstantly = false;
	}
	
	/**
	 * Generates the shape of the terrain for the chunk though its all stone
	 * though the water is frozen if the temperature is low enough
	 */
	public void generateTerrain(int chunkX, int chunkZ, short[] idsTop) {
		byte b0 = 4;
		byte b1 = 16;
		byte seaLevel = 63;
		int k = b0 + 1;
		byte b3 = 17;
		int l = b0 + 1;
		biomesForGeneration = worldObj.getWorldChunkManager().getBiomesForGeneration(
				biomesForGeneration, (chunkX * 4) - 2, (chunkZ * 4) - 2, k + 5, l + 5);
		noiseArray = this.initializeNoiseField(noiseArray, chunkX * b0, 0, chunkZ * b0, k, b3, l);

		for (int i1 = 0; i1 < b0; ++i1){
			for (int j1 = 0; j1 < b0; ++j1){
				for (int k1 = 0; k1 < b1; ++k1){
					double d0 = 0.125D;
					double d1 = noiseArray[((((i1 + 0) * l) + j1 + 0) * b3) + k1 + 0];
					double d2 = noiseArray[((((i1 + 0) * l) + j1 + 1) * b3) + k1 + 0];
					double d3 = noiseArray[((((i1 + 1) * l) + j1 + 0) * b3) + k1 + 0];
					double d4 = noiseArray[((((i1 + 1) * l) + j1 + 1) * b3) + k1 + 0];
					double d5 = (noiseArray[((((i1 + 0) * l) + j1 + 0) * b3) + k1 + 1] - d1) * d0;
					double d6 = (noiseArray[((((i1 + 0) * l) + j1 + 1) * b3) + k1 + 1] - d2) * d0;
					double d7 = (noiseArray[((((i1 + 1) * l) + j1 + 0) * b3) + k1 + 1] - d3) * d0;
					double d8 = (noiseArray[((((i1 + 1) * l) + j1 + 1) * b3) + k1 + 1] - d4) * d0;

					for (int l1 = 0; l1 < 8; ++l1){
						double d9 = 0.25D;
						double d10 = d1;
						double d11 = d2;
						double d12 = (d3 - d1) * d9;
						double d13 = (d4 - d2) * d9;

						for (int i2 = 0; i2 < 4; ++i2){
							int j2 = ((i2 + (i1 * 4)) << 11) | ((0 + (j1 * 4)) << 7)
									| ((k1 * 8) + l1);
							short short1 = 128;
							j2 -= short1;
							double d14 = 0.25D;
							double d15 = (d11 - d10) * d14;
							double d16 = d10 - d15;

							for (int k2 = 0; k2 < 4; ++k2){
								if ((d16 += d15) > 0.0D){
									idsTop[j2 += short1] = (short) ModBlocks.nmStone.blockID;
								}else if (((k1 * 8) + l1) < seaLevel){
									idsTop[j2 += short1] = (short) Block.lavaStill.blockID;
								}else{
									idsTop[j2 += short1] = 0;
								}
							}

							d10 += d12;
							d11 += d13;
						}

						d1 += d5;
						d2 += d6;
						d3 += d7;
						d4 += d8;
					}
				}
			}
		}
	}
	/**
	 * generates a subset of the level's terrain data. Takes 7 arguments: the
	 * [empty] noise array, the position, and the size.
	 */
	private double[] initializeNoiseField(double[] par1ArrayOfDouble, int par2, int par3, int par4,
			int par5, int par6, int par7) {
		ChunkProviderEvent.InitNoiseField event = new ChunkProviderEvent.InitNoiseField(this,
				par1ArrayOfDouble, par2, par3, par4, par5, par6, par7);
		MinecraftForge.EVENT_BUS.post(event);
		if (event.getResult() == Result.DENY){
			return event.noisefield;
		}

		if (par1ArrayOfDouble == null){
			par1ArrayOfDouble = new double[par5 * par6 * par7];
		}

		if (parabolicField == null){
			parabolicField = new float[25];

			for (int k1 = -2; k1 <= 2; ++k1){
				for (int l1 = -2; l1 <= 2; ++l1){
					float f = 10.0F / MathHelper.sqrt_float((k1 * k1) + (l1 * l1) + 0.2F);
					parabolicField[k1 + 2 + ((l1 + 2) * 5)] = f;
				}
			}
		}

		double d0 = 684.412D;
		double d1 = 684.412D;
		noise5 = noiseGen5.generateNoiseOctaves(noise5, par2, par4, par5, par7, 1.121D, 1.121D,
				0.5D);
		noise6 = noiseGen6.generateNoiseOctaves(noise6, par2, par4, par5, par7, 200.0D, 200.0D,
				0.5D);
		noise3 = noiseGen3.generateNoiseOctaves(noise3, par2, par3, par4, par5, par6, par7,
				d0 / 80.0D, d1 / 160.0D, d0 / 80.0D);
		noise1 = noiseGen1.generateNoiseOctaves(noise1, par2, par3, par4, par5, par6, par7, d0, d1,
				d0);
		noise2 = noiseGen2.generateNoiseOctaves(noise2, par2, par3, par4, par5, par6, par7, d0, d1,
				d0);
		int i2 = 0;
		int j2 = 0;

		for (int k2 = 0; k2 < par5; ++k2){
			for (int l2 = 0; l2 < par7; ++l2){
				float f1 = 0.0F;
				float f2 = 0.0F;
				float f3 = 0.0F;
				byte b0 = 2;
				BiomeGenBase biomegenbase = biomesForGeneration[k2 + 2 + ((l2 + 2) * (par5 + 5))];

				for (int i3 = -b0; i3 <= b0; ++i3){
					for (int j3 = -b0; j3 <= b0; ++j3){
						BiomeGenBase biomegenbase1 = biomesForGeneration[k2 + i3 + 2
						                                                 + ((l2 + j3 + 2) * (par5 + 5))];
						float f4 = parabolicField[i3 + 2 + ((j3 + 2) * 5)]
								/ (biomegenbase1.minHeight + 2.0F);

						if (biomegenbase1.minHeight > biomegenbase.minHeight){
							f4 /= 2.0F;
						}

						f1 += biomegenbase1.maxHeight * f4;
						f2 += biomegenbase1.minHeight * f4;
						f3 += f4;
					}
				}

				f1 /= f3;
				f2 /= f3;
				f1 = (f1 * 0.9F) + 0.1F;
				f2 = ((f2 * 4.0F) - 1.0F) / 8.0F;
				double d2 = noise6[j2] / 8000.0D;

				if (d2 < 0.0D){
					d2 = -d2 * 0.3D;
				}

				d2 = (d2 * 3.0D) - 2.0D;

				if (d2 < 0.0D){
					d2 /= 2.0D;

					if (d2 < -1.0D){
						d2 = -1.0D;
					}

					d2 /= 1.4D;
					d2 /= 2.0D;
				}else{
					if (d2 > 1.0D){
						d2 = 1.0D;
					}

					d2 /= 8.0D;
				}

				++j2;

				for (int k3 = 0; k3 < par6; ++k3){
					double d3 = f2;
					double d4 = f1;
					d3 += d2 * 0.2D;
					d3 = (d3 * par6) / 16.0D;
					double d5 = (par6 / 2.0D) + (d3 * 4.0D);
					double d6 = 0.0D;
					double d7 = ((k3 - d5) * 12.0D * 128.0D) / 128.0D / d4;

					if (d7 < 0.0D){
						d7 *= 4.0D;
					}

					double d8 = noise1[i2] / 512.0D;
					double d9 = noise2[i2] / 512.0D;
					double d10 = ((noise3[i2] / 10.0D) + 1.0D) / 2.0D;

					if (d10 < 0.0D){
						d6 = d8;
					}else if (d10 > 1.0D){
						d6 = d9;
					}else{
						d6 = d8 + ((d9 - d8) * d10);
					}

					d6 -= d7;

					if (k3 > (par6 - 4)){
						double d11 = (k3 - (par6 - 4)) / 3.0F;
						d6 = (d6 * (1.0D - d11)) + (-10.0D * d11);
					}

					par1ArrayOfDouble[i2] = d6;
					++i2;
				}
			}
		}

		return par1ArrayOfDouble;
	}

	/**
	 * Replaces the stone that was placed in with blocks that match the biome
	 */
	public void replaceBlocksForBiome(int par1, int par2, short[] par3ArrayOfByte,
			BiomeGenBase[] par4ArrayOfBiomeGenBase) {

		byte b0 = 63;
		double d0 = 0.03125D;
		stoneNoise = noiseGen4.generateNoiseOctaves(stoneNoise, par1 * 16, par2 * 16, 0, 16, 16, 1,
				d0 * 2.0D, d0 * 2.0D, d0 * 2.0D);

		for (int k = 0; k < 16; ++k){
			for (int l = 0; l < 16; ++l){
				BiomeGenBase biomegenbase = par4ArrayOfBiomeGenBase[l + (k * 16)];
				float f = biomegenbase.getFloatTemperature();
				int i1 = (int) ((stoneNoise[k + (l * 16)] / 3.0D) + 3.0D + (rand.nextDouble() * 0.25D));
				int j1 = -1;
				short b1 = ((BiomeDreamLand) biomegenbase).sTopBlock;
				short b2 = ((BiomeDreamLand) biomegenbase).sFillerBlock;

				for (int k1 = 127; k1 >= 0; --k1){
					int l1 = (((l * 16) + k) * 128) + k1;

					if (k1 <= (0 + rand.nextInt(5))){
						par3ArrayOfByte[l1] = (byte) Block.bedrock.blockID;
					}else{
						short b3 = par3ArrayOfByte[l1];

						if (b3 == 0){
							j1 = -1;
						}else if (b3 == ModBlocks.nmStone.blockID){
							if (j1 == -1){
								if (i1 <= 0){
									b1 = 0;
									b2 = (short) ModBlocks.nmStone.blockID;
								}else if ((k1 >= (b0 - 4)) && (k1 <= (b0 + 1))){
									b1 = ((BiomeDreamLand) biomegenbase).sTopBlock;
									b2 = ((BiomeDreamLand) biomegenbase).sFillerBlock;
								}

								if ((k1 < b0) && (b1 == 0)){
									if (f < 0.15F){
										b1 = (short) Block.ice.blockID;
									}else{
										b1 = (short) Block.lavaStill.blockID;
									}
								}

								j1 = i1;

								if (k1 >= (b0 - 1)){
									par3ArrayOfByte[l1] = b1;
								}else{
									par3ArrayOfByte[l1] = b2;
								}
							}else if (j1 > 0){
								--j1;
								par3ArrayOfByte[l1] = b2;

								if ((j1 == 0) && (b2 == ModBlocks.dreamFalling.blockID)){
									j1 = rand.nextInt(4);
									b2 = (short) ModBlocks.nmStone.blockID;
								}
							}
						}
					}
				}
			}
		}
	}
	/**
	 * Checks to see if a chunk exists at x, y
	 */
	@Override
	public boolean chunkExists(int par1, int par2) {
		return true;
	}
	/**
	 * loads or generates the chunk at the chunk location specified
	 */
	@Override
	public Chunk loadChunk(int par1, int par2) {
		return this.provideChunk(par1, par2);
	}


	/**
	 * Two modes of operation: if passed true, save all Chunks in one go. If
	 * passed false, save up to two chunks. Return true if all chunks have been
	 * saved.
	 */
	@Override
	public boolean saveChunks(boolean par1, IProgressUpdate par2IProgressUpdate) {
		return true;
	}

	/**
	 * Unloads chunks that are marked to be unloaded. This is not guaranteed to
	 * unload every such chunk.
	 */
	@Override
	public boolean unloadQueuedChunks() {
		return true;
	}

	/**
	 * Returns if the IChunkProvider supports saving.
	 */
	@Override
	public boolean canSave() {
		return true;
	}

	/**
	 * Converts the instance data to a readable string.
	 */
	@Override
	public String makeString() {
		return "RandomLevelSource";
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List getPossibleCreatures(EnumCreatureType enumcreaturetype, int i,
			int j, int k) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ChunkPosition findClosestStructure(World world, String s, int i,
			int j, int k) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getLoadedChunkCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void recreateStructures(int i, int j) {
		// TODO Auto-generated method stub

	}

	

}
