package dreamLand.world.biome;

import net.minecraft.world.biome.BiomeGenBase;

public class ModBiomes {
	
	public static BiomeGenBase dreamIsland;
    public static BiomeGenBase nightMare;
    
	public static void init() {
		dreamIsland = (new BiomeGenLucidDL(100)).setColor(6316128).setBiomeName("Dream Land").setMinMaxHeight(0.3F, 2.0F).setTemperatureRainfall(0.2F, 0.3F);
	    nightMare = (new BiomeGenNightMareDL(101)).setColor(6316128).setBiomeName("NightMare").setMinMaxHeight(0.3F, 2.0F).setTemperatureRainfall(0.2F, 0.3F);
	}
}
