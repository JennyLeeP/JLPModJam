package dreamLand.compatibility;

import dreamLand.utils.Config;

public class ThaumcraftCompatibility {
    
    public static void init(){
        if(Config.enableDebug){
        System.out.println("[DreamLand] Starting Thaumcraft 'Init' integration. ");
        }
        //TODO Init items for Thaumcraft go here
        if(Config.enableDebug){
        System.out.println("[DreamLand] Starting Thaumcraft 'Init' integration. ");
        }
    }
    public static void postInit(){
        if(Config.enableDebug){
        System.out.println("[DreamLand] Starting Thaumcraft 'PostInit' integration. ");
        }
        addAspects();
        if(Config.enableDebug){
        System.out.println("[DreamLand] Starting Thaumcraft 'PostInit' integration. ");
        }
    }
    private static void addAspects()
    {

  
    }
}
