package dreamLand.render;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFence;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.world.IBlockAccess;
import org.lwjgl.opengl.GL11;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class DLFenceRender implements ISimpleBlockRenderingHandler{
    public static int fenceModel = RenderingRegistry.getNextAvailableRenderId();

    @Override
    public boolean renderWorldBlock (IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer)
    {

        if (modelId == fenceModel)
        {
            return renderer.renderBlockFence((BlockFence) block, x, y, z);
        }
        return true;
    }

    @Override
    public void renderInventoryBlock (Block block, int metadata, int modelID, RenderBlocks renderer)
    {
        if (modelID == fenceModel)
        {
            Tessellator tessellator = Tessellator.instance;

            for (int k = 0; k < 4; ++k)
            {
                float f2 = 0.125F;

                if (k == 0)
                {
                    renderer.setRenderBounds((double)(0.5F - f2), 0.0D, 0.0D, (double)(0.5F + f2), 1.0D, (double)(f2 * 2.0F));
                }

                if (k == 1)
                {
                    renderer.setRenderBounds((double)(0.5F - f2), 0.0D, (double)(1.0F - f2 * 2.0F), (double)(0.5F + f2), 1.0D, 1.0D);
                }

                f2 = 0.0625F;

                if (k == 2)
                {
                    renderer.setRenderBounds((double)(0.5F - f2), (double)(1.0F - f2 * 3.0F), (double)(-f2 * 2.0F), (double)(0.5F + f2), (double)(1.0F - f2), (double)(1.0F + f2 * 2.0F));
                }

                if (k == 3)
                {
                    renderer.setRenderBounds((double)(0.5F - f2), (double)(0.5F - f2 * 3.0F), (double)(-f2 * 2.0F), (double)(0.5F + f2), (double)(0.5F - f2), (double)(1.0F + f2 * 2.0F));
                }

                GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
                tessellator.startDrawingQuads();
                tessellator.setNormal(0.0F, -1.0F, 0.0F);
                renderer.renderFaceYNeg(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(block, 0, metadata));
                tessellator.draw();
                tessellator.startDrawingQuads();
                tessellator.setNormal(0.0F, 1.0F, 0.0F);
                renderer.renderFaceYPos(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(block, 1, metadata));
                tessellator.draw();
                tessellator.startDrawingQuads();
                tessellator.setNormal(0.0F, 0.0F, -1.0F);
                renderer.renderFaceZNeg(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(block, 2, metadata));
                tessellator.draw();
                tessellator.startDrawingQuads();
                tessellator.setNormal(0.0F, 0.0F, 1.0F);
                renderer.renderFaceZPos(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(block, 3, metadata));
                tessellator.draw();
                tessellator.startDrawingQuads();
                tessellator.setNormal(-1.0F, 0.0F, 0.0F);
                renderer.renderFaceXNeg(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(block, 4, metadata));
                tessellator.draw();
                tessellator.startDrawingQuads();
                tessellator.setNormal(1.0F, 0.0F, 0.0F);
                renderer.renderFaceXPos(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(block, 5, metadata));
                tessellator.draw();
                GL11.glTranslatef(0.5F, 0.5F, 0.5F);
            }

            renderer.setRenderBounds(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
        }
    }

    @Override
    public boolean shouldRender3DInInventory ()
    {
        return true;
    }

    @Override
    public int getRenderId ()
    {
        return fenceModel;
    }
}
