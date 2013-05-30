package dreamLand.utils;

import dreamLand.utils.portal.DreamLandTeleporter;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.player.PlayerSleepInBedEvent;

public class EventHookContainerClass {
  
    public Entity par5Entity ;
    public World par1World;
    
    public void sendToDreamLand(World par1World, int par2, int par3, int par4, Entity par5Entity){
        //TODO send player to dimension
        MinecraftServer minecraftserver = MinecraftServer.getServer();
        int dimID = Config.dimensionID;
        WorldServer worldserver = minecraftserver.worldServerForDimension(dimID);
       
        minecraftserver.getConfigurationManager().transferPlayerToDimension((EntityPlayerMP) par5Entity, Config.dimensionID,
                new DreamLandTeleporter(worldserver));
        
        EntityPlayer Player = (EntityPlayer) par5Entity;
        if(Player.isPlayerFullyAsleep() == true && Player.getCurrentEquippedItem().itemID == Item.axeDiamond.itemID){
            System.out.println("sleeping with axe");
        }
    }
    @ForgeSubscribe
    public void onSleepyTime(PlayerSleepInBedEvent event)
    {
        //sendToDreamLand(par1World, 0, 0, 0, par5Entity);
       event.result  = event.result;
    }
    
}
