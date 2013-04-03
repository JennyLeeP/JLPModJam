package dreamLand;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.world.World;

public class ItemDreamSword extends ItemSword {

    protected ItemDreamSword(int var1, EnumToolMaterial var2) {
        super(var1, var2);
        this.setCreativeTab(DreamLand.tabDreamLand);
    }

    @Override
    public void updateIcons(IconRegister par1IconRegister) {
        iconIndex = par1IconRegister.registerIcon(DreamLand.modid + ":swordPhantomIron");
    }

    @Override
    public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y,
            int z, int par7, float par8, float par9, float par10) {

        world.playSoundEffect(x + 0.5D, y + 0.5D, z + 0.5D, "random.pop", 1.0F,
                (itemRand.nextFloat() * 0.4F) + 0.8F);

        return checkBlock(x, y, z, world);
    }

    public boolean checkBlock(int x, int y, int z, World world) {

        int[] id = Config.ids.getIntList();

        List<Integer> ids = new ArrayList<Integer>();
        for (int i : id)
            ids.add(i);

        while (ids.iterator().hasNext()){
            // Value is equal to a int value
            if (ids.iterator().next().equals(world.getBlockId(x, y, z))){
                return world.setBlock(x, y, z, Block.cake.blockID);
            }
        }
        return false;
    }
}