package dreamLand.world.village;

import java.util.Random;

import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import cpw.mods.fml.common.registry.VillagerRegistry.IVillageTradeHandler;
import dreamLand.items.ModItems;
import dreamLand.utils.Config;


public class VillagerTrades implements IVillageTradeHandler{

    @Override
    public void manipulateTradesForVillager(EntityVillager villager, MerchantRecipeList recipeList, Random random) {
        if (villager.getProfession() == Config.shamanVillagerID)
        {
            recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(Item.emerald, 1, 23), new ItemStack(ModItems.itemSwordPhantomIron, 1, 20)));
        }
    }



}
