package dreamLand;

import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;
public class DreamLandWorldProvider extends WorldProvider{

	public String getDimensionName() 
	{
		return "DreamLand";
	}
	public void registerWorldChunkManager()
	{
		this.worldChunkMgr = new WorldChunkManagerHell(BiomeGenBase.sky, 0.8F, 0.1F);
		this.dimensionId = DreamLand.dimensionID;
		
	}
	
	public boolean canRespawnHere()
	{
		return true;
	}
	@Override
	public IChunkProvider createChunkGenerator()
	{
		return new ChunkProviderDreamLand();
	}
}
