package dreamLand.blocks;
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
        return Block.blocksList[this.itemID].getIcon(2, meta);
    }
    
    @Override
    public String getUnlocalizedName(ItemStack itemstack)
    {
        switch(itemstack.getItemDamage())
        {
            case 0:
                return Archive.dreamCobble;
            case 1:
                return Archive.nmCobble;
            
            default:
                return Archive.nmDirt;
        }
    }
}
