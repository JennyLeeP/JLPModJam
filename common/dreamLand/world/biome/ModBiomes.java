package dreamLand.world.biome;

import dreamLand.utils.Config;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;

public class ModBiomes {

    public static BiomeGenBase LushHills;
    public static BiomeGenBase TreacherousHills;

    public static void init() {
        intiBiomes();
        registerBiomeTypes();
    }
    public static void intiBiomes(){
        LushHills = (new BiomeGenLushHills(Config.biomeLushHillsID)).setColor(8900670).setBiomeName("Lush Hills").setMinMaxHeight(0.3F, 2.0F).setTemperatureRainfall(0.2F, 0.3F);
        TreacherousHills = (new BiomeGenTreacherousHills(Config.biomeTreacherousHillsID)).setColor(6316128).setBiomeName("Treacherous Hills").setMinMaxHeight(0.3F, 2.0F).setTemperatureRainfall(0.2F, 0.3F);
    }
    
    public static void registerBiomeTypes(){
        BiomeDictionary.registerBiomeType(LushHills, Type.MAGICAL, Type.HILLS, Type.FOREST);
        BiomeDictionary.registerBiomeType(TreacherousHills, Type.NETHER, Type.HILLS);
    }
}
