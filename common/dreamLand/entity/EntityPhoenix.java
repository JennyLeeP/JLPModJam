package dreamLand.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dreamLand.utils.Reference;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class EntityPhoenix extends EntityTameable{

	public EntityPhoenix(World par1World) {
		super(par1World);
		this.moveSpeed = 0.2F;
		this.setSize(1.0F, 2.0F);
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAIAttackOnCollide(this, 0.25F, false));
        this.tasks.addTask(3, new EntityAIWander(this, 0.2F));
        this.tasks.addTask(4, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(4, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityEnderman.class, 16.0F, 0, true));
        this.targetTasks.addTask(2, new EntityAIHurtByTarget(this, false));
	}
	@SideOnly(Side.CLIENT)
    public String getTexture()
    {
        return Reference.mobTexture + "phoenix.png";
    }

	@Override
	public EntityAgeable createChild(EntityAgeable entityageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getMaxHealth() {
		// TODO Auto-generated method stub
		return 20;
	}

}
