package dreamLand.world;

import dreamLand.DreamLand;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.ChunkProviderHell;
public class DreamLandWorldProvider extends WorldProvider{

	@Override
	public String getDimensionName() 
	{
		return "DreamLand";
	}
	/**
     * creates a new world chunk manager for WorldProvider
     */
	public void registerWorldChunkManager()
	{
		this.worldChunkMgr = new WorldChunkManagerHell(DreamLand.dreamIsland, 0.8F, 0.1F);
		this.dimensionId = DreamLand.dimensionID;
		
	}
	
	/**
     * Returns a new chunk provider which generates chunks for this world
     */
	public IChunkProvider createChunkGenerator()
	{
		return new ChunkProviderDreamLand(this.worldObj, this.worldObj.getSeed(), true);
	}
	
}
