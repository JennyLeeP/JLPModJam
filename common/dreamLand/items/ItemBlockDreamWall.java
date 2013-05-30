package dreamLand.items;
import dreamLand.utils.Archive;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

public class ItemBlockDreamWall extends ItemBlock{

	public ItemBlockDreamWall(int par1) {
		super(par1);
		this.setMaxDamage(0);
        this.setHasSubtypes(true);
	}
	@Override
    public int getMetadata(int meta)
    {
        return meta;
    }
    
    @Override
    public Icon getIconFromDamage(int meta)
    {
        return Block.blocksList[this.itemID].getIcon(4, meta);
    }
    
    @Override
    public String getUnlocalizedName(ItemStack itemstack)
    {
        String name = "";
        switch(itemstack.getItemDamage())
        {
            case 0:
                name  = Archive.dreamCobble;
                break;
            case 1:
                name =  Archive.nmCobble;
                break;
            case 2:
                name =  Archive.dreamStoneBrick;
                break;
            case 3:
                name =  Archive.bloodCobble;
                break;
            default:
                name =  Archive.nmDirt;
                break;
        }
        //System.out.println(getUnlocalizedName() + "." + name);
        return getUnlocalizedName() + "." + name;
    }
}
