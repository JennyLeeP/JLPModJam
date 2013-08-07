package dreamLand.render;

import org.lwjgl.opengl.GL11;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dreamLand.models.ModelChickenAlter;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

@SideOnly(Side.CLIENT)
public class ItemChickenAlterRender implements IItemRenderer{
    
    private ModelChickenAlter alterModel;
    
    public ItemChickenAlterRender(){
        alterModel = new ModelChickenAlter();
    }
    @Override
    public boolean handleRenderType(ItemStack item, ItemRenderType type) {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item,
            ItemRendererHelper helper) {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public void renderItem(ItemRenderType type, ItemStack item, Object... data) {

        switch (type) {
            case ENTITY: {
                renderChickenAlter(-0.5F, 0.0F, 0.5F, 1.0F);
                return;
            }
            case EQUIPPED: {
                renderChickenAlter(0.0F, 0.0F, 1.0F, 1.0F);
                return;
            }
            case EQUIPPED_FIRST_PERSON: {
                renderChickenAlter(0.0F, 0.0F, 1.0F, 1.0F);
                return;
            }
            case INVENTORY: {
                renderChickenAlter(0.0F, -0.1F, 1.0F, 1.0F);
                return;
            }
            default:
                return;
        }
    }
    private void renderChickenAlter(float x, float y, float z, float scale) {

        GL11.glPushMatrix();
        GL11.glDisable(GL11.GL_LIGHTING);

        // Scale, Translate, Rotate
        GL11.glScalef(scale, scale, scale);
        GL11.glTranslatef(x, y, z);
        GL11.glRotatef(-90F, 1F, 0, 0);

        // Bind texture
        
        //FMLClientHandler.instance().getClient().renderEngine.func_110577_a(Textures.MODEL_CALCINATOR);

        // Render
        //alterModel.render();

        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glPopMatrix();
    }
}
