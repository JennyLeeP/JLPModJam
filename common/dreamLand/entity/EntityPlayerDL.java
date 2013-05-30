package dreamLand.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.World;

public class EntityPlayerDL extends EntityPlayer{

    public EntityPlayerDL(World par1World) {
        super(par1World);
        // TODO Auto-generated constructor stub
    }
    public void onUpdate(ItemStack itemstack, World world, Entity entity, int i, boolean flag){
        EntityPlayer Player = (EntityPlayer) entity;
        if(Player.isPlayerFullyAsleep() == true && Player.getCurrentEquippedItem().itemID == Item.axeDiamond.itemID){
            System.out.println("sleeping with axe");
        }
    }
    @Override
    public void sendChatToPlayer(String s) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public boolean canCommandSenderUseCommand(int i, String s) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public ChunkCoordinates getPlayerCoordinates() {
        // TODO Auto-generated method stub
        return null;
    }

}
