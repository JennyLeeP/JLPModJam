package dreamLand.world.biome;

import static net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.CLAY;
import static net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.FLOWERS;
import static net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS;
import static net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.SAND;
import static net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.SAND_PASS2;
import static net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.TREE;
import static net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType.CUSTOM;
import static net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType.DIRT;
import static net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType.GRAVEL;
import net.minecraft.block.Block;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;
import net.minecraftforge.event.terraingen.OreGenEvent;
import net.minecraftforge.event.terraingen.TerrainGen;
import dreamLand.blocks.ModBlocks;
import dreamLand.world.terrain.WorldGenCursedNodes;
import dreamLand.world.terrain.WorldGenDLFlowers;
import dreamLand.world.terrain.WorldGenDLSand;
import dreamLand.world.terrain.WorldGenMethIce;

public class BiomeDecoratorDL extends BiomeDecorator {

    public WorldGenerator dirtGen;
    public WorldGenerator gravelGen;
    public WorldGenerator plantYellowGen;
    public WorldGenerator plantRedGen;
    public WorldGenerator methIceGen = new WorldGenMethIce(4);

    public WorldGenerator Solarium;
    public WorldGenerator Quartz;
    public WorldGenerator BlackTourmaline;
    public WorldGenerator Carnelian;
    public WorldGenerator GoldenCalcite;
    public WorldGenerator BlueTopaz;
    public WorldGenerator Rubelite;
    public WorldGenerator Azurite;
    
    public WorldGenerator cursedNodesGen;
    
    public WorldGenerator whiteFlowersGen;
    public WorldGenerator orangeFlowersGen;
    public WorldGenerator yellowFlowersGen;
    public WorldGenerator magentaFlowersGen;
    public WorldGenerator blueFlowersGen;
    public WorldGenerator lightBlueFlowersGen;
    public WorldGenerator cyanFlowersGen;
    public WorldGenerator lightGrayFlowersGen;
    public WorldGenerator grayFlowersGen;
    public WorldGenerator purpleFlowersGen;
    public WorldGenerator pinkFlowersGen;
    public WorldGenerator limeFlowersGen;
    public WorldGenerator greenFlowersGen;
    public WorldGenerator brownFlowersGen;
    public WorldGenerator redFlowersGen;
    public WorldGenerator blackFlowersGen;

    
    public int methIcePerChunk;
    public int grassPerChunk;
    public int nodesPerChunk;
    
    public int whiteFlowersPerChunk;
    public int orangeFlowersPerChunk;
    public int yellowFlowersPerChunk;
    public int blueFlowersPerChunk;
    public int lightBlueFlowersPerChunk;
    public int CyanFlowersPerChunk;
    public int limeFlowersPerChunk;
    public int lightGrayFlowersPerChunk;
    public int grayFlowersPerChunk;
    public int purpleFlowersPerChunk;
    public int magentaFlowersPerChunk;
    public int pinkFlowersPerChunk;
    public int greenFlowersPerChunk;
    public int brownFlowersPerChunk;
    public int redFlowersPerChunk;
    public int blackFlowersPerChunk;

    public BiomeDecoratorDL(BiomeGenBase par1BiomeGenBase) {
        super(par1BiomeGenBase);
        this.plantYellowGen = new WorldGenDLFlowers(Block.plantYellow.blockID);
        this.plantRedGen = new WorldGenDLFlowers(Block.plantRed.blockID);
        this.sandGen = new WorldGenDLSand(7, ModBlocks.dreamFalling.blockID,0);
        this.dirtGen = new WorldGenMinable(ModBlocks.dreamDirt.blockID, 0, 32, ModBlocks.dreamStone.blockID);
        this.gravelGen = new WorldGenMinable(ModBlocks.dreamFalling.blockID, 1, 32, ModBlocks.dreamStone.blockID);

        this.Solarium = new WorldGenMinable(ModBlocks.oreBlocks.blockID, 0, 6, ModBlocks.dreamStone.blockID);
        this.Quartz = new WorldGenMinable(ModBlocks.oreBlocks.blockID,1 , 8, ModBlocks.dreamStone.blockID); 
        this.BlackTourmaline = new WorldGenMinable(ModBlocks.oreBlocks.blockID,2 , 6, ModBlocks.dreamStone.blockID);
        this.Carnelian = new WorldGenMinable(ModBlocks.oreBlocks.blockID,3 , 6, ModBlocks.dreamStone.blockID);
        this.GoldenCalcite = new WorldGenMinable(ModBlocks.oreBlocks.blockID,4 , 6, ModBlocks.dreamStone.blockID);
        this.BlueTopaz = new WorldGenMinable(ModBlocks.oreBlocks.blockID,5 , 8, ModBlocks.dreamStone.blockID);
        this.Rubelite = new WorldGenMinable(ModBlocks.oreBlocks.blockID,6 , 6, ModBlocks.dreamStone.blockID);
        this.Azurite = new WorldGenMinable(ModBlocks.oreBlocks.blockID,7 , 6, ModBlocks.dreamStone.blockID);

        this.cursedNodesGen = new WorldGenCursedNodes(ModBlocks.dreamStones.blockID, 11);
        this.whiteFlowersGen = new WorldGenDLFlowers(ModBlocks.dreamFlowers.blockID,0);
        this.orangeFlowersGen = new WorldGenDLFlowers(ModBlocks.dreamFlowers.blockID,1);
        this.magentaFlowersGen = new WorldGenDLFlowers(ModBlocks.dreamFlowers.blockID,2);
        this.lightBlueFlowersGen = new WorldGenDLFlowers(ModBlocks.dreamFlowers.blockID,3);
        this.yellowFlowersGen = new WorldGenDLFlowers(ModBlocks.dreamFlowers.blockID,4);
        this.limeFlowersGen = new WorldGenDLFlowers(ModBlocks.dreamFlowers.blockID,5);
        this.pinkFlowersGen = new WorldGenDLFlowers(ModBlocks.dreamFlowers.blockID,6);
        this.grayFlowersGen = new WorldGenDLFlowers(ModBlocks.dreamFlowers.blockID,7);
        this.lightGrayFlowersGen = new WorldGenDLFlowers(ModBlocks.dreamFlowers.blockID,8);
        this.cyanFlowersGen = new WorldGenDLFlowers(ModBlocks.dreamFlowers.blockID,9);
        this.purpleFlowersGen = new WorldGenDLFlowers(ModBlocks.dreamFlowers.blockID,10);
        this.blueFlowersGen = new WorldGenDLFlowers(ModBlocks.dreamFlowers.blockID,11);
        this.brownFlowersGen = new WorldGenDLFlowers(ModBlocks.dreamFlowers.blockID,12);
        this.greenFlowersGen = new WorldGenDLFlowers(ModBlocks.dreamFlowers.blockID,13);
        this.redFlowersGen = new WorldGenDLFlowers(ModBlocks.dreamFlowers.blockID,14);
        this.blackFlowersGen = new WorldGenDLFlowers(ModBlocks.dreamFlowers.blockID,15);


        
        this.whiteFlowersPerChunk = 0;
        this.orangeFlowersPerChunk = 0;
        this.yellowFlowersPerChunk = 0;
        this.blueFlowersPerChunk = 0;
        this.lightBlueFlowersPerChunk = 0;
        this.CyanFlowersPerChunk = 0;
        this.limeFlowersPerChunk = 0;
        this.lightGrayFlowersPerChunk = 0;
        this.grayFlowersPerChunk = 0;
        this.purpleFlowersPerChunk = 0;
        this.magentaFlowersPerChunk = 0;
        this.pinkFlowersPerChunk = 0;
        this.greenFlowersPerChunk = 0;
        this.brownFlowersPerChunk = 0;
        this.redFlowersPerChunk = 0;
        this.blackFlowersPerChunk = 0;
        
        this.methIcePerChunk = 2;
        this.flowersPerChunk = 0;
        this.grassPerChunk = 1;
        this.sandPerChunk = 7;
        this.sandPerChunk2 = 5;
        this.nodesPerChunk = 0;
        
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
        for (j = 0; j < whiteFlowersPerChunk; ++j)
        {
            k = chunk_X + randomGenerator.nextInt(16) + 8;
            l = randomGenerator.nextInt(128);
            i1 = chunk_Z + randomGenerator.nextInt(16) + 8;
            whiteFlowersGen.generate(currentWorld, randomGenerator, k, l, i1);
        }
        for (j = 0; j < orangeFlowersPerChunk; ++j)
        {
            k = chunk_X + randomGenerator.nextInt(16) + 8;
            l = randomGenerator.nextInt(128);
            i1 = chunk_Z + randomGenerator.nextInt(16) + 8;
            orangeFlowersGen.generate(currentWorld, randomGenerator, k, l, i1);
        }
        for (j = 0; j < magentaFlowersPerChunk; ++j)
        {
            k = chunk_X + randomGenerator.nextInt(16) + 8;
            l = randomGenerator.nextInt(128);
            i1 = chunk_Z + randomGenerator.nextInt(16) + 8;
            magentaFlowersGen.generate(currentWorld, randomGenerator, k, l, i1);
        }
        for (j = 0; j < lightBlueFlowersPerChunk; ++j)
        {
            k = chunk_X + randomGenerator.nextInt(16) + 8;
            l = randomGenerator.nextInt(128);
            i1 = chunk_Z + randomGenerator.nextInt(16) + 8;
            lightBlueFlowersGen.generate(currentWorld, randomGenerator, k, l, i1);
        }
        for (j = 0; j < yellowFlowersPerChunk; ++j)
        {
            k = chunk_X + randomGenerator.nextInt(16) + 8;
            l = randomGenerator.nextInt(128);
            i1 = chunk_Z + randomGenerator.nextInt(16) + 8;
            yellowFlowersGen.generate(currentWorld, randomGenerator, k, l, i1);
        }
        for (j = 0; j < limeFlowersPerChunk; ++j)
        {
            k = chunk_X + randomGenerator.nextInt(16) + 8;
            l = randomGenerator.nextInt(128);
            i1 = chunk_Z + randomGenerator.nextInt(16) + 8;
           limeFlowersGen.generate(currentWorld, randomGenerator, k, l, i1);
        }
        for (j = 0; j < pinkFlowersPerChunk; ++j)
        {
            k = chunk_X + randomGenerator.nextInt(16) + 8;
            l = randomGenerator.nextInt(128);
            i1 = chunk_Z + randomGenerator.nextInt(16) + 8;
           pinkFlowersGen.generate(currentWorld, randomGenerator, k, l, i1);
        }
        for (j = 0; j < grayFlowersPerChunk; ++j)
        {
            k = chunk_X + randomGenerator.nextInt(16) + 8;
            l = randomGenerator.nextInt(128);
            i1 = chunk_Z + randomGenerator.nextInt(16) + 8;
            grayFlowersGen.generate(currentWorld, randomGenerator, k, l, i1);
        }
        for (j = 0; j < lightGrayFlowersPerChunk; ++j)
        {
            k = chunk_X + randomGenerator.nextInt(16) + 8;
            l = randomGenerator.nextInt(128);
            i1 = chunk_Z + randomGenerator.nextInt(16) + 8;
            lightGrayFlowersGen.generate(currentWorld, randomGenerator, k, l, i1);
        }
        for (j = 0; j < CyanFlowersPerChunk; ++j)
        {
            k = chunk_X + randomGenerator.nextInt(16) + 8;
            l = randomGenerator.nextInt(128);
            i1 = chunk_Z + randomGenerator.nextInt(16) + 8;
            cyanFlowersGen.generate(currentWorld, randomGenerator, k, l, i1);
        }
        for (j = 0; j < purpleFlowersPerChunk; ++j)
        {
            k = chunk_X + randomGenerator.nextInt(16) + 8;
            l = randomGenerator.nextInt(128);
            i1 = chunk_Z + randomGenerator.nextInt(16) + 8;
            purpleFlowersGen.generate(currentWorld, randomGenerator, k, l, i1);
        }
        for (j = 0; j < blueFlowersPerChunk; ++j)
        {
            k = chunk_X + randomGenerator.nextInt(16) + 8;
            l = randomGenerator.nextInt(128);
            i1 = chunk_Z + randomGenerator.nextInt(16) + 8;
            blueFlowersGen.generate(currentWorld, randomGenerator, k, l, i1);
        }
        for (j = 0; j < brownFlowersPerChunk; ++j)
        {
            k = chunk_X + randomGenerator.nextInt(16) + 8;
            l = randomGenerator.nextInt(128);
            i1 = chunk_Z + randomGenerator.nextInt(16) + 8;
            brownFlowersGen.generate(currentWorld, randomGenerator, k, l, i1);
        }
        for (j = 0; j < greenFlowersPerChunk; ++j)
        {
            k = chunk_X + randomGenerator.nextInt(16) + 8;
            l = randomGenerator.nextInt(128);
            i1 = chunk_Z + randomGenerator.nextInt(16) + 8;
            greenFlowersGen.generate(currentWorld, randomGenerator, k, l, i1);
        }
        for (j = 0; j < redFlowersPerChunk; ++j)
        {
            k = chunk_X + randomGenerator.nextInt(16) + 8;
            l = randomGenerator.nextInt(128);
            i1 = chunk_Z + randomGenerator.nextInt(16) + 8;
            redFlowersGen.generate(currentWorld, randomGenerator, k, l, i1);
        }
        for (j = 0; j < blackFlowersPerChunk; ++j)
        {
            k = chunk_X + randomGenerator.nextInt(16) + 8;
            l = randomGenerator.nextInt(128);
            i1 = chunk_Z + randomGenerator.nextInt(16) + 8;
            blackFlowersGen.generate(currentWorld, randomGenerator, k, l, i1);
        }
        for (j = 0; j < nodesPerChunk; ++j)
        {
            k = chunk_X + randomGenerator.nextInt(16) + 8;
            l = randomGenerator.nextInt(128);
            i1 = chunk_Z + randomGenerator.nextInt(16) + 8;
            cursedNodesGen.generate(currentWorld, randomGenerator, k, l, i1);
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
        if (TerrainGen.generateOre(currentWorld, randomGenerator, Solarium, chunk_X, chunk_Z, CUSTOM))
            this.genStandardOre1(5, this.Solarium, 0, 128);
        if (TerrainGen.generateOre(currentWorld, randomGenerator, Quartz, chunk_X, chunk_Z, CUSTOM))
            this.genStandardOre1(20, this.Quartz, 0, 64);
        if (TerrainGen.generateOre(currentWorld, randomGenerator, BlackTourmaline, chunk_X, chunk_Z, CUSTOM))
            this.genStandardOre2(6, this.BlackTourmaline, 32, 50);
        if (TerrainGen.generateOre(currentWorld, randomGenerator, Carnelian, chunk_X, chunk_Z, CUSTOM))
            this.genStandardOre2(6, this.Carnelian, 0, 32);
        if (TerrainGen.generateOre(currentWorld, randomGenerator, GoldenCalcite, chunk_X, chunk_Z, CUSTOM))
            this.genStandardOre2(6, this.GoldenCalcite, 32, 64);
        if (TerrainGen.generateOre(currentWorld, randomGenerator, BlueTopaz, chunk_X, chunk_Z, CUSTOM))
            this.genStandardOre2(4, this.BlueTopaz, 0, 64);
        if (TerrainGen.generateOre(currentWorld, randomGenerator, Rubelite, chunk_X, chunk_Z, CUSTOM))
            this.genStandardOre2(4, this.Rubelite, 64, 128);
        if (TerrainGen.generateOre(currentWorld, randomGenerator, Azurite, chunk_X, chunk_Z, CUSTOM))
            this.genStandardOre2(6, this.Azurite, 0, 16);
        
        MinecraftForge.ORE_GEN_BUS.post(new OreGenEvent.Post(currentWorld, randomGenerator, chunk_X, chunk_Z));
    }
}
