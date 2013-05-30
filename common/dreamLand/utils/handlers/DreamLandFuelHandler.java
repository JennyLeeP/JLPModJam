package dreamLand.utils.handlers;

import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.IFuelHandler;
import dreamLand.items.ModItems;

public class DreamLandFuelHandler implements IFuelHandler{

    @Override
    public int getBurnTime(ItemStack fuel) {
        if(fuel.itemID == ModItems.itemMethaneClathrate.itemID){
            return 12000;
        }else{
            return 0;
        }
    }
}
