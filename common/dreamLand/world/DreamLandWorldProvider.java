package dreamLand.world;

import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;
import dreamLand.DreamLand;

public class DreamLandWorldProvider extends WorldProvider {

    @Override
    public String getDimensionName() {
        return "DreamLand";
    }

    /**
     * creates a new world chunk manager for WorldProvider
     */
    @Override
    public void registerWorldChunkManager() {
        worldChunkMgr = new WorldChunkManagerHell(DreamLand.dreamIsland, 0.8F, 0.1F);
        dimensionId = DreamLand.dimensionID;

    }

    /**
     * Returns a new chunk provider which generates chunks for this world
     */
    @Override
    public IChunkProvider createChunkGenerator() {
        return new ChunkProviderDreamLand(worldObj, worldObj.getSeed(), true);
    }

}
