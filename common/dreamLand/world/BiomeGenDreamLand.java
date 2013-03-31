package dreamLand.world;

import net.minecraft.block.Block;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.SpawnListEntry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dreamLand.DreamLand;

public class BiomeGenDreamLand extends BiomeGenBase{

	public short sTopBlock;
	public short sFillerBlock;
	public BiomeGenDreamLand(int par1)
    {
        super(par1);
        this.spawnableMonsterList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableWaterCreatureList.clear();
        this.spawnableCaveCreatureList.clear();
        this.spawnableMonsterList.add(new SpawnListEntry(EntityEnderman.class, 10, 4, 4));
        this.sTopBlock = (short)DreamLand.dreamDirt.blockID;
        this.sFillerBlock = (short)DreamLand.dreamStone.blockID;
        this.theBiomeDecorator = new BiomeDecoratorDreamLand(this);
    }

	/**
     * Allocate a new BiomeDecorator for this BiomeGenBase
     */
    @Override
    public BiomeDecorator createBiomeDecorator()
    {   
    	System.out.println("Biome Decorator");
        return new BiomeDecoratorDreamLand(this);
    }
    @SideOnly(Side.CLIENT)

    /**
     * takes temperature, returns color
     */
    public int getSkyColorByTemp(float par1)
    {
        return 0;
    }
    
}
