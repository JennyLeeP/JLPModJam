package dreamLand.utils;

import java.util.Random;

import dreamLand.blocks.BlockDreamSaplings;
import dreamLand.blocks.ModBlocks;
import net.minecraftforge.event.Event.Result;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.player.BonemealEvent;

public class DreamLand_EventBonemeal {

	@ForgeSubscribe
	public boolean onUseBonemeal(BonemealEvent event){
		
		if(event.world.isRemote)
			return true;

		
		if(event.ID == ModBlocks.dreamSaplings.blockID)
		{
			((BlockDreamSaplings)(ModBlocks.dreamSaplings)).growTree(event.world, event.X, event.Y, event.Z, new Random());
			event.setResult(Result.ALLOW);
		}
		/*
		   if(id == ModBlocks.dreamPlants.blockID)
		{
			if(event.world.getBlockMetadata(event.X, event.Y, event.Z) < 5)
			{
				((BlockDreamPlants)(ModBlocks.dreamPlants)).fertilize(event.world, event.X, event.Y, event.Z);
				event.setResult(Result.ALLOW);
			}
		}
*/
		return false;
	}
}
