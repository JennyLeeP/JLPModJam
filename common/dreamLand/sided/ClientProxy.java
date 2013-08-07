package dreamLand.sided;

import jadarstudios.api.developercapesapi.DeveloperCapesAPI;
import net.minecraft.src.ModLoader;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import dreamLand.entity.EntityNMCreeper;
import dreamLand.entity.EntityPhoenix;
import dreamLand.entity.EntitySonicCreeper;
import dreamLand.render.DLFenceRender;
import dreamLand.render.RenderChickenAlter;
import dreamLand.render.RenderNMCreeper;
import dreamLand.render.RenderPhoenix;
import dreamLand.render.RenderSonicCreeper;
import dreamLand.tileEntity.TileChickenAlter;

public class ClientProxy extends CommonProxy {
	
	public void registerRenderers() {
		
		RenderingRegistry.registerEntityRenderingHandler(EntitySonicCreeper.class, new RenderSonicCreeper());
		RenderingRegistry.registerEntityRenderingHandler(EntityNMCreeper.class, new RenderNMCreeper());
		RenderingRegistry.registerEntityRenderingHandler(EntityPhoenix.class, new RenderPhoenix());
		
		RenderingRegistry.registerBlockHandler(new DLFenceRender());
		ClientRegistry.bindTileEntitySpecialRenderer(TileChickenAlter.class, new RenderChickenAlter());
	}
	
    // Code that adds capes :D Github link for it to work:
    // https://github.com/jadar/DeveloperCapesAPI
	
	@Override
    public void initCapes() {
     // link for the file "capes.txt" - that makes the capes work
    
    DeveloperCapesAPI.getInstance().init("http://pwebg.com/Minecraft/Downloads/capes.txt");
    
    }
	@SuppressWarnings("static-access")
    @Override
	public boolean getGraphicsLevel()
	{
		// TODO Auto-generated method stub
		return ModLoader.getMinecraftInstance().isFancyGraphicsEnabled();
	}
}