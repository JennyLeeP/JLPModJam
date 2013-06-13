package dreamLand.compatibility;

import cpw.mods.fml.common.Loader;

public class DreamLandCompatibility {
    public static void init()
    {
        if (Loader.isModLoaded("Forestry"))
        {
            try {
                ForestryCompatibility.init();
            }
            catch (Exception e) {
                System.out.println("[DreamLand] There was an error while initializing Forestry Compatibility with DreamLand");
                e.printStackTrace(System.err);
            }
        }
        if (Loader.isModLoaded("ThermalExpansion"))
        {
            try {
                TECompatibility.init();
            }
            catch (Exception e) {
                System.out.println("[DreamLand] There was an error while initializing Thermal Expansion Compatibility with DreamLand");
                e.printStackTrace(System.err);
            }
        }
        if (Loader.isModLoaded("BuildCraft|Transport"))
        {
            try {
                BCCompatibility.init();
            }
            catch (Exception e) {
                System.out.println("[DreamLand] There was an error while initializing BuildCraft Compatibility with DreamLand");
                e.printStackTrace(System.err);
            }
        }
        System.out.println("[DreamLand] has completed loading Mod Compatibility");
    }
}
