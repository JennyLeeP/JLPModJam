package dreamLand.items;

import dreamLand.DreamLand;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

public class ItemDreamBlock extends ItemBlock{

    public String[] MetaNames;
    public Icon[] icons;
    
    public ItemDreamBlock(int par1) {
        super(par1);
        setHasSubtypes(true);
        this.setCreativeTab(DreamLand.tabDreamLand);
    }
    @Override
    public String getUnlocalizedName(ItemStack itemstack)
    {
        //System.out.println(getUnlocalizedName()+ "." + MetaNames[itemstack.getItemDamage()]);
        //System.out.println(getUnlocalizedName().concat("."+ MetaNames[itemstack.getItemDamage()]) + "2");
        if(MetaNames != null)
            
            return getUnlocalizedName().concat("."+ MetaNames[itemstack.getItemDamage()]);
        
        return super.getUnlocalizedName(itemstack);
    }
    @Override
    public int getMetadata(int meta) 
    {       
        return meta;
    }
    @Override
    public Icon getIconFromDamage(int meta)
    {
        return Block.blocksList[this.itemID].getIcon(16, meta);
    }
}
