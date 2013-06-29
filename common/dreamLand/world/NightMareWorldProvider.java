package dreamLand.world;

import dreamLand.utils.Config;
import dreamLand.world.biome.ModBiomes;
import dreamLand.world.terrain.ChunkProviderNightMare;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;

public class NightMareWorldProvider extends WorldProvider{

	@Override
	public String getDimensionName() {
		return "NightMare";
	}
	/**
     * creates a new world chunk manager for WorldProvider
     */
    @Override
    public void registerWorldChunkManager() {
        this.worldChunkMgr = new WorldChunkManagerHell(ModBiomes.TreacherousHills, 0.8F, 0.1F);
        this.dimensionId = Config.dimensionNMID;
        this.hasNoSky = true;//true = world with normal sky but no light
    }
    /**
     * Returns a new chunk provider which generates chunks for this world
     */
    @Override
    public IChunkProvider createChunkGenerator() {
        return new ChunkProviderNightMare(this.worldObj, this.worldObj.getSeed(), true);
    }
    
    public String getSaveFolder()
    {
        return "TerraMala";
    }
    /**
     * Returns 'true' if in the "main surface world", but 'false' if in the Nether or End dimensions.
     */
    public boolean isSurfaceWorld()
    {
        return false;
    }
    /**
     * Return Vec3D with biome specific fog color
     */
    public Vec3 getFogColor(float par1, float par2)
    {
        int i = 10518688;
        float f2 = MathHelper.cos(par1 * (float)Math.PI * 2.0F) * 2.0F + 0.5F;

        if (f2 < 0.0F)
        {
            f2 = 0.0F;
        }

        if (f2 > 1.0F)
        {
            f2 = 1.0F;
        }

        float f3 = (float)(i >> 16 & 255) / 255.0F;
        float f4 = (float)(i >> 8 & 255) / 255.0F;
        float f5 = (float)(i & 255) / 255.0F;
        f3 *= f2 * 0.0F + 0.15F;
        f4 *= f2 * 0.0F + 0.15F;
        f5 *= f2 * 0.0F + 0.15F;
        return this.worldObj.getWorldVec3Pool().getVecFromPool((double)f3, (double)f4, (double)f5);
    }
    @Override
	public float getCloudHeight()
	{
		return 150F;//256.0F Sets cloud height at 256 instead of 128, 0.0F = clouds at Bedrock
	}
}
