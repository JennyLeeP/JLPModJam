package dreamLand.entity;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIBase;

public class EntityAICustomCreeperSwell extends EntityAIBase{

	EntitySonicCreeper swellingCreeper;

	EntityLiving creeperAttackTarget;

	
	public EntityAICustomCreeperSwell(EntitySonicCreeper par1EntityCreeper) {
		swellingCreeper = par1EntityCreeper;
		setMutexBits(1);
	}
@Override
	public boolean shouldExecute() {
		EntityLiving var1 = swellingCreeper.getAttackTarget();
		return swellingCreeper.getCreeperState() > 0 || var1 != null && swellingCreeper.getDistanceSqToEntity(var1) < 9.0D;
	}
@Override
	public void startExecuting() {
		//swellingCreeper.getNavigator().clearPathEntity();
		creeperAttackTarget = swellingCreeper.getAttackTarget();
	}
@Override
	public void resetTask() {
		creeperAttackTarget = null;
	}
@Override
	public void updateTask() {
		creeperAttackTarget = swellingCreeper.getAttackTarget();
		if(creeperAttackTarget == null)
			swellingCreeper.setCreeperState(-1);
		else if(swellingCreeper.getDistanceSqToEntity(creeperAttackTarget) > 49.0D)
			swellingCreeper.setCreeperState(-1);
		else if(!swellingCreeper.getEntitySenses().canSee(creeperAttackTarget))
			swellingCreeper.setCreeperState(-1);
		else
			swellingCreeper.setCreeperState(1);
	}
	
}
