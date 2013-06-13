package dreamLand.render;

import dreamLand.blocks.BlockDreamFence;
import net.minecraft.client.renderer.RenderBlocks;

public class RenderDreamBlock extends RenderBlocks{
    
    public boolean renderBlockDreamFence(BlockDreamFence par1BlockFence, int par2, int par3, int par4)
    {
        boolean flag = false;
        float f = 0.375F;
        float f1 = 0.625F;
        this.setRenderBounds((double)f, 0.0D, (double)f, (double)f1, 1.0D, (double)f1);
        this.renderStandardBlock(par1BlockFence, par2, par3, par4);
        flag = true;
        boolean flag1 = false;
        boolean flag2 = false;

        if (par1BlockFence.canConnectFenceTo(this.blockAccess, par2 - 1, par3, par4) || par1BlockFence.canConnectFenceTo(this.blockAccess, par2 + 1, par3, par4))
        {
            flag1 = true;
        }

        if (par1BlockFence.canConnectFenceTo(this.blockAccess, par2, par3, par4 - 1) || par1BlockFence.canConnectFenceTo(this.blockAccess, par2, par3, par4 + 1))
        {
            flag2 = true;
        }

        boolean flag3 = par1BlockFence.canConnectFenceTo(this.blockAccess, par2 - 1, par3, par4);
        boolean flag4 = par1BlockFence.canConnectFenceTo(this.blockAccess, par2 + 1, par3, par4);
        boolean flag5 = par1BlockFence.canConnectFenceTo(this.blockAccess, par2, par3, par4 - 1);
        boolean flag6 = par1BlockFence.canConnectFenceTo(this.blockAccess, par2, par3, par4 + 1);

        if (!flag1 && !flag2)
        {
            flag1 = true;
        }

        f = 0.4375F;
        f1 = 0.5625F;
        float f2 = 0.75F;
        float f3 = 0.9375F;
        float f4 = flag3 ? 0.0F : f;
        float f5 = flag4 ? 1.0F : f1;
        float f6 = flag5 ? 0.0F : f;
        float f7 = flag6 ? 1.0F : f1;

        if (flag1)
        {
            this.setRenderBounds((double)f4, (double)f2, (double)f, (double)f5, (double)f3, (double)f1);
            this.renderStandardBlock(par1BlockFence, par2, par3, par4);
            flag = true;
        }

        if (flag2)
        {
            this.setRenderBounds((double)f, (double)f2, (double)f6, (double)f1, (double)f3, (double)f7);
            this.renderStandardBlock(par1BlockFence, par2, par3, par4);
            flag = true;
        }

        f2 = 0.375F;
        f3 = 0.5625F;

        if (flag1)
        {
            this.setRenderBounds((double)f4, (double)f2, (double)f, (double)f5, (double)f3, (double)f1);
            this.renderStandardBlock(par1BlockFence, par2, par3, par4);
            flag = true;
        }

        if (flag2)
        {
            this.setRenderBounds((double)f, (double)f2, (double)f6, (double)f1, (double)f3, (double)f7);
            this.renderStandardBlock(par1BlockFence, par2, par3, par4);
            flag = true;
        }

        par1BlockFence.setBlockBoundsBasedOnState(this.blockAccess, par2, par3, par4);
        return flag;
    }
}
