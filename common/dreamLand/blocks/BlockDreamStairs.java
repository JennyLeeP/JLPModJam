package dreamLand.blocks;

import dreamLand.DreamLand;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;

public class BlockDreamStairs extends BlockStairs{
    
    public BlockDreamStairs(int par1, Block par2Block, int par3) {
        super(par1, par2Block, par3);
        this.setCreativeTab(DreamLand.tabDreamLand);
    }
}
