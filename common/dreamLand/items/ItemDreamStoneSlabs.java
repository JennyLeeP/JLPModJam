package dreamLand.items;

import net.minecraft.block.Block;
import net.minecraft.block.BlockHalfSlab;
import net.minecraft.item.ItemSlab;
import net.minecraft.item.ItemStack;
import dreamLand.blocks.BlockDreamStoneSlabs;

public class ItemDreamStoneSlabs extends ItemSlab{

    private static BlockHalfSlab doubleSlab;
    private static boolean isFullBlock;

    public ItemDreamStoneSlabs(int par1) {
        super(par1, doubleSlab, doubleSlab, isFullBlock);
        setMaxDamage(0);
        setHasSubtypes(true);
       
    }
    @Override
    public int getMetadata(int meta)
    {
        return meta;
    }
    @Override
    public String getUnlocalizedName(ItemStack itemStack) {
        BlockDreamStoneSlabs slab = (BlockDreamStoneSlabs)Block.blocksList[itemStack.itemID];

        return super.getUnlocalizedName() + "." + (new StringBuilder()).append(slab.getFullSlabName(itemStack.getItemDamage())).toString();
    }
}
