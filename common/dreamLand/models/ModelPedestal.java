package dreamLand.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelPedestal extends ModelBase
{
  //fields
    ModelRenderer innerQube;
    ModelRenderer outerQube;
    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer Shape3;
    ModelRenderer Shape4;
  
  public ModelPedestal()
  {
    textureWidth = 128;
    textureHeight = 512;
    
      innerQube = new ModelRenderer(this, 0, 0);
      innerQube.addBox(-6F, 0F, -6F, 12, 4, 12);
      innerQube.setRotationPoint(0F, 20F, 0F);
      innerQube.setTextureSize(64, 32);
      innerQube.mirror = true;
      setRotation(innerQube, 0F, 0F, 0F);
      outerQube = new ModelRenderer(this, 0, 0);
      outerQube.addBox(-6F, 0F, -6F, 12, 4, 12);
      outerQube.setRotationPoint(0F, 20F, 0F);
      outerQube.setTextureSize(64, 32);
      outerQube.mirror = true;
      setRotation(outerQube, 0F, 0.7853982F, 0F);
      Shape1 = new ModelRenderer(this, 0, 17);
      Shape1.addBox(-4F, -3F, -4F, 8, 24, 8);
      Shape1.setRotationPoint(0F, -1F, 0F);
      Shape1.setTextureSize(128, 512);
      Shape1.mirror = true;
      setRotation(Shape1, 0F, -0.3839724F, 0F);
      Shape2 = new ModelRenderer(this, 0, 16);
      Shape2.addBox(-4F, -3F, -4F, 8, 24, 8);
      Shape2.setRotationPoint(0F, -1F, 0F);
      Shape2.setTextureSize(128, 512);
      Shape2.mirror = true;
      setRotation(Shape2, 0F, 0.3839724F, 0F);
      Shape3 = new ModelRenderer(this, 0, 0);
      Shape3.addBox(-6F, -4F, -6F, 12, 4, 12);
      Shape3.setRotationPoint(0F, -4F, 0F);
      Shape3.setTextureSize(128, 512);
      Shape3.mirror = true;
      setRotation(Shape3, 0F, 0F, 0F);
      Shape4 = new ModelRenderer(this, 0, 0);
      Shape4.addBox(-6F, -4F, -6F, 12, 4, 12);
      Shape4.setRotationPoint(0F, -4F, 0F);
      Shape4.setTextureSize(128, 512);
      Shape4.mirror = true;
      setRotation(Shape4, 0F, 0.7853982F, 0F);
  }
  
  public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7)
  {
    super.render(par1Entity, par2, par3, par4, par5, par6, par7);
    setRotationAngles(par2, par3, par4, par5, par6, par7, par1Entity);
    innerQube.render(par7);
    outerQube.render(par7);
    Shape1.render(par7);
    Shape2.render(par7);
    Shape3.render(par7);
    Shape4.render(par7);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity)
  {
    super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
  }

}
