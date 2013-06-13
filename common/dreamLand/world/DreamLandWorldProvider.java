package dreamLand.world;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;
import dreamLand.utils.Config;
import dreamLand.world.biome.ModBiomes;
import dreamLand.world.terrain.ChunkProviderDreamLand;

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
        this.worldChunkMgr = new WorldChunkManagerHell(ModBiomes.dreamIsland, 0.8F, 0.1F);
        this.dimensionId = Config.dimensionID;
        this.hasNoSky = false;//true = world with normal sky but no light
    }
    /**
     * Returns a new chunk provider which generates chunks for this world
     */
    @Override
    public IChunkProvider createChunkGenerator() {
        return new ChunkProviderDreamLand(worldObj, worldObj.getSeed(), true);
    }
    /**
     * Calculates the angle of sun and moon in the sky relative to a specified time (usually worldTime)
     */
    public float calculateCelestialAngle(long par1, float par3)
    {
        return 1.0F; //0.0F = stationary moon and sun at top center of sky.
    }
    /**
     * removes sky coloring  <--not yet sure how to use this
     */
    @SideOnly(Side.CLIENT)

    public boolean isSkyColored()
    {
        return false;
    }
    /**
     * True if the player can respawn in this dimension (true = overworld, false = nether).
     */
    public boolean canRespawnHere()
    {
        return false;
    }
    public String getSaveFolder()
    {
        return "DreamLand";
    }
    /**
     * Returns 'true' if in the "main surface world", but 'false' if in the Nether or End dimensions.
     */
    public boolean isSurfaceWorld()
    {
        return true;
    }

    /**
     * Returns array with sunrise/sunset colors
     */
    public float[] calcSunriseSunsetColors(float par1, float par2)
    {
        return null;//removes sunrise sunset colors
    }

    /*@SideOnly(Side.CLIENT)
    public float getStarBrightness(float par1)
    {
        return worldObj.getStarBrightnessBody(par1);
    }
     */

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
    @SideOnly(Side.CLIENT)
    @Override
    public float getCloudHeight()
    {
        return 200F;//256.0F Sets cloud height at 256 instead of 128, 0.0F = clouds at Bedrock
    }
    /**
     * Gets the hard-coded portal location to use when entering this dimension.
     */
    public ChunkCoordinates getEntrancePortalLocation()
    {
        return new ChunkCoordinates(100, 50, 0);
    }
}
