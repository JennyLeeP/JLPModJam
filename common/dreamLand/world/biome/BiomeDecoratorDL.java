package dreamLand.world.biome;

import static net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.CLAY;
import static net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.FLOWERS;
import static net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS;
import static net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.SAND;
import static net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.SAND_PASS2;
import static net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.TREE;

import static net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType.COAL;
import static net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType.DIRT;
import static net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType.IRON;
import static net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType.LAPIS;

import static net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType.GRAVEL;


import dreamLand.blocks.ModBlocks;
import dreamLand.world.terrain.WorldGenDLFlowers;
import dreamLand.world.terrain.WorldGenDLSand;
import dreamLand.world.terrain.WorldGenMethIce;

import net.minecraft.block.Block;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;
import net.minecraftforge.event.terraingen.OreGenEvent;
import net.minecraftforge.event.terraingen.TerrainGen;

public class BiomeDecoratorDL extends BiomeDecorator {

    public WorldGenerator dirtGen;
    public WorldGenerator gravelGen;
    public WorldGenerator plantYellowGen;
    public WorldGenerator plantRedGen;
    public WorldGenerator methIceGen = new WorldGenMethIce(4);

    public WorldGenerator coalGen;
    public WorldGenerator ironGen;
    public WorldGenerator lapisGen;

    public int methIcePerChunk;
    public int grassPerChunk;

    public BiomeDecoratorDL(BiomeGenBase par1BiomeGenBase) {
        super(par1BiomeGenBase);
        this.plantYellowGen = new WorldGenDLFlowers(Block.plantYellow.blockID, 1);
        this.plantRedGen = new WorldGenDLFlowers(Block.plantRed.blockID);
        this.sandGen = new WorldGenDLSand(7, ModBlocks.dreamFalling.blockID,0);
        this.dirtGen = new WorldGenMinable(ModBlocks.dreamDirt.blockID, 0, 32, ModBlocks.dreamStone.blockID);
        this.gravelGen = new WorldGenMinable(ModBlocks.dreamFalling.blockID, 1, 32, ModBlocks.dreamStone.blockID);

        this.coalGen = new WorldGenMinable(ModBlocks.oreLucidity.blockID, 0, 16, ModBlocks.dreamStone.blockID);
        this.ironGen = new WorldGenMinable(ModBlocks.oreStarcesium.blockID,0 , 8, ModBlocks.dreamStone.blockID); 
        this.lapisGen = new WorldGenMinable(Block.oreLapis.blockID,0 , 6, ModBlocks.dreamStone.blockID);

        this.methIcePerChunk = 2;
        this.flowersPerChunk = 2;
        this.grassPerChunk = 1;
        this.sandPerChunk = 7;
        this.sandPerChunk2 = 5;
    }
    /**
     * The method that does the work of actually decorating chunks
     */
    @Override
    protected void decorate()
    {
        MinecraftForge.EVENT_BUS.post(new DecorateBiomeEvent.Pre(currentWorld, randomGenerator, chunk_X, chunk_Z));
        this.generateOres();
        int i;
        int j;
        int k;

        boolean doGen = TerrainGen.decorate(currentWorld, randomGenerator, chunk_X, chunk_Z, SAND);
        for (i = 0; doGen && i < this.sandPerChunk; ++i)
        {
            j = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
            k = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
            this.sandGen.generate(this.currentWorld, this.randomGenerator, j, this.currentWorld.getTopSolidOrLiquidBlock(j, k), k);
        }
        doGen = TerrainGen.decorate(currentWorld, randomGenerator, chunk_X, chunk_Z, SAND_PASS2);
        for (i = 0; doGen && i < this.sandPerChunk2; ++i)
        {
            j = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
            k = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
            this.sandGen.generate(this.currentWorld, this.randomGenerator, j, this.currentWorld.getTopSolidOrLiquidBlock(j, k), k);
        }
        doGen = TerrainGen.decorate(currentWorld, randomGenerator, chunk_X, chunk_Z, CLAY);
        for (i = 0; doGen && i < this.methIcePerChunk; ++i)
        {
            j = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
            k = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
            this.methIceGen.generate(this.currentWorld, this.randomGenerator, j, this.currentWorld.getTopSolidOrLiquidBlock(j, k), k);
        }
        i = this.treesPerChunk;

        if (this.randomGenerator.nextInt(10) == 0)
        {
            ++i;
        }

        int l;

        doGen = TerrainGen.decorate(currentWorld, randomGenerator, chunk_X, chunk_Z, TREE);
        for (j = 0; doGen && j < i; ++j)
        {
            k = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
            l = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
            WorldGenerator worldgenerator = this.biome.getRandomWorldGenForTrees(this.randomGenerator);
            worldgenerator.setScale(1.0D, 1.0D, 1.0D);
            worldgenerator.generate(this.currentWorld, this.randomGenerator, k, this.currentWorld.getHeightValue(k, l), l);
        }

        int i1;

        doGen = TerrainGen.decorate(currentWorld, randomGenerator, chunk_X, chunk_Z, FLOWERS);
        for (j = 0; doGen && j < this.flowersPerChunk; ++j)
        {
            k = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
            l = this.randomGenerator.nextInt(128);
            i1 = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
            this.plantYellowGen.generate(this.currentWorld, this.randomGenerator, k, l, i1);

            if (this.randomGenerator.nextInt(4) == 0)
            {
                k = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
                l = this.randomGenerator.nextInt(128);
                i1 = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
                this.plantRedGen.generate(this.currentWorld, this.randomGenerator, k, l, i1);
            }
        }

        doGen = TerrainGen.decorate(currentWorld, randomGenerator, chunk_X, chunk_Z, GRASS);
        for (j = 0; doGen && j < this.grassPerChunk; ++j)
        {
            k = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
            l = this.randomGenerator.nextInt(128);
            i1 = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
            WorldGenerator worldgenerator1 = this.biome.getRandomWorldGenForGrass(this.randomGenerator);
            worldgenerator1.generate(this.currentWorld, this.randomGenerator, k, l, i1);
        }
        MinecraftForge.EVENT_BUS.post(new DecorateBiomeEvent.Post(currentWorld, randomGenerator, chunk_X, chunk_Z));
    }
    /**
     * Standard ore generation helper. Generates most ores.
     */
    protected void genStandardOre1(int par1, WorldGenerator par2WorldGenerator, int par3, int par4)
    {
        for (int l = 0; l < par1; ++l)
        {
            int i1 = this.chunk_X + this.randomGenerator.nextInt(16);
            int j1 = this.randomGenerator.nextInt(par4 - par3) + par3;
            int k1 = this.chunk_Z + this.randomGenerator.nextInt(16);
            par2WorldGenerator.generate(this.currentWorld, this.randomGenerator, i1, j1, k1);
        }
    }

    /**
     * Standard ore generation helper. Generates Lapis Lazuli.
     */
    protected void genStandardOre2(int par1, WorldGenerator par2WorldGenerator, int par3, int par4)
    {
        for (int l = 0; l < par1; ++l)
        {
            int i1 = this.chunk_X + this.randomGenerator.nextInt(16);
            int j1 = this.randomGenerator.nextInt(par4) + this.randomGenerator.nextInt(par4) + (par3 - par4);
            int k1 = this.chunk_Z + this.randomGenerator.nextInt(16);
            par2WorldGenerator.generate(this.currentWorld, this.randomGenerator, i1, j1, k1);
        }
    }

    /**
     * Generates ores in the current chunk
     */
    protected void generateOres()
    {
        MinecraftForge.ORE_GEN_BUS.post(new OreGenEvent.Pre(currentWorld, randomGenerator, chunk_X, chunk_Z));
        if (TerrainGen.generateOre(currentWorld, randomGenerator, dirtGen, chunk_X, chunk_Z, DIRT))
            this.genStandardOre1(20, this.dirtGen, 0, 128);
        if (TerrainGen.generateOre(currentWorld, randomGenerator, gravelGen, chunk_X, chunk_Z, GRAVEL))
            this.genStandardOre1(10, this.gravelGen, 0, 128);
        if (TerrainGen.generateOre(currentWorld, randomGenerator, coalGen, chunk_X, chunk_Z, COAL))
            this.genStandardOre1(20, this.coalGen, 0, 128);
        if (TerrainGen.generateOre(currentWorld, randomGenerator, ironGen, chunk_X, chunk_Z, IRON))
            this.genStandardOre1(20, this.ironGen, 0, 64);
        if (TerrainGen.generateOre(currentWorld, randomGenerator, lapisGen, chunk_X, chunk_Z, LAPIS))
            this.genStandardOre2(1, this.lapisGen, 16, 16);
        
        MinecraftForge.ORE_GEN_BUS.post(new OreGenEvent.Post(currentWorld, randomGenerator, chunk_X, chunk_Z));
    }
}
