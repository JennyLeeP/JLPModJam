package dreamLand.render;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import dreamLand.blocks.ModBlocks;
import dreamLand.models.ModelChickenAlter;
import dreamLand.tileEntity.TileChickenAlter;
import dreamLand.utils.Reference;

public class RenderChickenAlter extends TileEntitySpecialRenderer{
    //public static int alterModel = RenderingRegistry.getNextAvailableRenderId();
    //protected ModelChickenAlter  model;



    @Override
    public void renderTileEntityAt(TileEntity tileEntity, double X, double Y, double Z, float f) {

        GL11.glPushMatrix();
        GL11.glDisable(GL11.GL_LIGHTING);
        TileChickenAlter tileChickenAlter = (TileChickenAlter)tileEntity;
        // Scale, Translate, Rotate
        GL11.glTranslatef((float) X + 0.5F, (float) Y + 1.5F, (float) Z + 0.5F);
        GL11.glRotatef(180F, 1F, 0F, 0F);
        /*Note that true tile entity coordinates (tileEntity.xCoord, etc) do not match to render coordinates (d, etc) that are calculated as [true coordinates] - [player coordinates (camera coordinates)]*/
        renderChickenAlter(tileChickenAlter, tileEntity.worldObj, tileEntity.xCoord, tileEntity.yCoord, tileEntity.zCoord, ModBlocks.chickenAlter);
        GL11.glPopMatrix();
    }
    //And this method actually renders your tile entity
    public void renderChickenAlter(TileChickenAlter tl, World world, int i, int j, int k, Block block) {
        Tessellator tessellator = Tessellator.instance;
        //This will make your block brightness dependent from surroundings lighting.
        float f = block.getBlockBrightness(world, i, j, k);
        int l = world.getLightBrightnessForSkyBlocks(i, j, k, 0);
        int l1 = l % 65536;
        int l2 = l / 65536;
        tessellator.setColorOpaque_F(f, f, f);
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float)l1, (float)l2); 
        bindTextureByName(Reference.tileTexture + "chickenAlter.png");

        ModelChickenAlter alterModel = new ModelChickenAlter();
        alterModel.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
    }

}

