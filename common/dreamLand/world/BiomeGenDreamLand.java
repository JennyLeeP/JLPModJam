package dreamLand.world;

import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;
import dreamLand.DreamLand;

public class BiomeGenDreamLand extends BiomeGenBase{

	public WorldGenerator treeGenerator;
	public WorldGenerator ruinsGenerator;

	public short sTopBlock;
	public short sFillerBlock;

    public BiomeGenDreamLand(int par1)
    {
        super(par1);
        
        //System.out.println("Silverfish");//test line TODO
        this.sTopBlock = (short) DreamLand.dreamGrass.blockID;
        this.sFillerBlock = (short) DreamLand.dreamDirt.blockID;
        this.theBiomeDecorator.treesPerChunk = 10;
        this.treeGenerator = new WorldGenDreamLandTrees(true);
        /*
         * 
        this.spawnableCreatureList.clear();
        this.spawnableMonsterList.clear();
        this.sTopBlock = (short) DreamLand.dreamGrass.blockID;
        this.sFillerBlock = (short) DreamLand.dreamDirt.blockID;
        
 
        
        */
    }
    /**
     * Allocate a new BiomeDecorator for this BiomeGenBase
     */
    @Override
    public BiomeDecorator createBiomeDecorator()
    {   
        return new BiomeDecoratorDreamLand(this);
    }
}
