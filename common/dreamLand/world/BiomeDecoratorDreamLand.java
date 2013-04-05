package dreamLand.world;

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
import static net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType.COAL;
import static net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType.DIAMOND;
import static net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType.DIRT;
import static net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType.GOLD;
import static net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType.GRAVEL;
import static net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType.IRON;
import static net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType.LAPIS;
import static net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType.REDSTONE;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenBigMushroom;
import net.minecraft.world.gen.feature.WorldGenCactus;
import net.minecraft.world.gen.feature.WorldGenFlowers;
import net.minecraft.world.gen.feature.WorldGenLiquids;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenPumpkin;
import net.minecraft.world.gen.feature.WorldGenReed;
import net.minecraft.world.gen.feature.WorldGenSand;
import net.minecraft.world.gen.feature.WorldGenWaterlily;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;
import net.minecraftforge.event.terraingen.OreGenEvent;
import net.minecraftforge.event.terraingen.TerrainGen;

public class BiomeDecoratorDreamLand extends BiomeDecorator {

    public short sTopBlock;
    public short sFillerBlock;
    // public boolean
    @SuppressWarnings("unused")
    private WorldGenDreamLandTrees treeGenerator;

    public BiomeDecoratorDreamLand(BiomeGenBase par1BiomeGenBase) {
        super(par1BiomeGenBase);

        sandGen = new WorldGenSand(7, Block.sand.blockID);
        gravelAsSandGen = new WorldGenSand(6, Block.gravel.blockID);
        dirtGen = new WorldGenMinable(Block.dirt.blockID, 32);
        gravelGen = new WorldGenMinable(Block.gravel.blockID, 32);
        coalGen = new WorldGenMinable(Block.oreCoal.blockID, 16);
        ironGen = new WorldGenMinable(Block.oreIron.blockID, 8);
        goldGen = new WorldGenMinable(Block.oreGold.blockID, 8);
        redstoneGen = new WorldGenMinable(Block.oreRedstone.blockID, 7);
        diamondGen = new WorldGenMinable(Block.oreDiamond.blockID, 7);
        lapisGen = new WorldGenMinable(Block.oreLapis.blockID, 6);
        plantYellowGen = new WorldGenFlowers(Block.plantYellow.blockID);
        plantRedGen = new WorldGenFlowers(Block.plantRed.blockID);
        mushroomBrownGen = new WorldGenFlowers(Block.mushroomBrown.blockID);
        mushroomRedGen = new WorldGenFlowers(Block.mushroomRed.blockID);
        bigMushroomGen = new WorldGenBigMushroom();
        reedGen = new WorldGenReed();
        cactusGen = new WorldGenCactus();
        waterlilyGen = new WorldGenWaterlily();
        waterlilyPerChunk = 0;
        treesPerChunk = 10;
        flowersPerChunk = 2;
        grassPerChunk = 1;
        deadBushPerChunk = 1;
        mushroomsPerChunk = 15;
        reedsPerChunk = 0;
        cactiPerChunk = 0;
        sandPerChunk = 1;
        sandPerChunk2 = 3;
        clayPerChunk = 1;
        bigMushroomsPerChunk = 5;
        generateLakes = true;
        biome = par1BiomeGenBase;

        treeGenerator = new WorldGenDreamLandTrees(true);
    }

    /**
     * Decorates the world. Calls code that was formerly (pre-1.8) in
     * ChunkProviderGenerate.populate
     */
    @Override
    public void decorate(World par1World, Random par2Random, int par3, int par4) {
        // System.out.println("decorate");
        if (currentWorld != null){
            throw new RuntimeException("Already decorating!!");
        }else{
            currentWorld = par1World;
            randomGenerator = par2Random;
            chunk_X = par3;
            chunk_Z = par4;
            this.decorate();
            currentWorld = null;
            randomGenerator = null;
        }
    }

    /**
     * The method that does the work of actually decorating chunks
     */
    @Override
    protected void decorate() {
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
            // this.treeGenerator.generate(this.currentWorld,
            // this.randomGenerator, j,
            // this.currentWorld.getTopSolidOrLiquidBlock(j, k), k);
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
     * Standard ore generation helper. Generates most ores.
     */
    @Override
    protected void genStandardOre1(int par1, WorldGenerator par2WorldGenerator, int par3, int par4) {
        for (int l = 0; l < par1; ++l){
            int i1 = chunk_X + randomGenerator.nextInt(16);
            int j1 = randomGenerator.nextInt(par4 - par3) + par3;
            int k1 = chunk_Z + randomGenerator.nextInt(16);
            par2WorldGenerator.generate(currentWorld, randomGenerator, i1, j1, k1);
        }
    }

    /**
     * Standard ore generation helper. Generates Lapis Lazuli.
     */
    @Override
    protected void genStandardOre2(int par1, WorldGenerator par2WorldGenerator, int par3, int par4) {
        for (int l = 0; l < par1; ++l){
            int i1 = chunk_X + randomGenerator.nextInt(16);
            int j1 = randomGenerator.nextInt(par4) + randomGenerator.nextInt(par4) + (par3 - par4);
            int k1 = chunk_Z + randomGenerator.nextInt(16);
            par2WorldGenerator.generate(currentWorld, randomGenerator, i1, j1, k1);
        }
    }

    /**
     * Generates ores in the current chunk
     */
    @Override
    protected void generateOres() {
        MinecraftForge.ORE_GEN_BUS.post(new OreGenEvent.Pre(currentWorld, randomGenerator, chunk_X,
                chunk_Z));
        if (TerrainGen.generateOre(currentWorld, randomGenerator, dirtGen, chunk_X, chunk_Z, DIRT)){
            this.genStandardOre1(20, dirtGen, 0, 128);
        }
        if (TerrainGen.generateOre(currentWorld, randomGenerator, gravelGen, chunk_X, chunk_Z,
                GRAVEL)){
            this.genStandardOre1(10, gravelGen, 0, 128);
        }
        if (TerrainGen.generateOre(currentWorld, randomGenerator, coalGen, chunk_X, chunk_Z, COAL)){
            this.genStandardOre1(20, coalGen, 0, 128);
        }
        if (TerrainGen.generateOre(currentWorld, randomGenerator, ironGen, chunk_X, chunk_Z, IRON)){
            this.genStandardOre1(20, ironGen, 0, 64);
        }
        if (TerrainGen.generateOre(currentWorld, randomGenerator, goldGen, chunk_X, chunk_Z, GOLD)){
            this.genStandardOre1(2, goldGen, 0, 32);
        }
        if (TerrainGen.generateOre(currentWorld, randomGenerator, redstoneGen, chunk_X, chunk_Z,
                REDSTONE)){
            this.genStandardOre1(8, redstoneGen, 0, 16);
        }
        if (TerrainGen.generateOre(currentWorld, randomGenerator, diamondGen, chunk_X, chunk_Z,
                DIAMOND)){
            this.genStandardOre1(1, diamondGen, 0, 16);
        }
        if (TerrainGen
                .generateOre(currentWorld, randomGenerator, lapisGen, chunk_X, chunk_Z, LAPIS)){
            this.genStandardOre2(1, lapisGen, 16, 16);
        }
        MinecraftForge.ORE_GEN_BUS.post(new OreGenEvent.Post(currentWorld, randomGenerator,
                chunk_X, chunk_Z));
    }
}
