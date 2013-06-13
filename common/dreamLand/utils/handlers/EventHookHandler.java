package dreamLand.utils.handlers;

import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.player.PlayerSleepInBedEvent;

public class EventHookHandler {
  
    
    @ForgeSubscribe
    public void onSleepyTime(PlayerSleepInBedEvent event)
    {
       event.result  = event.result;
    }
    
}
