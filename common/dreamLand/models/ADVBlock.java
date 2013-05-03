package dreamLand.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ADVBlock extends ModelBase
{
  //fields
    ModelRenderer innerQube;
    ModelRenderer outerQube;
  
  public ADVBlock()
  {
    textureWidth = 128;
    textureHeight = 512;
    
      innerQube = new ModelRenderer(this, 0, 0);
      innerQube.addBox(0F, 0F, 0F, 14, 14, 14);
      innerQube.setRotationPoint(-7F, 9F, -7F);
      innerQube.setTextureSize(128, 512);
      innerQube.mirror = true;
      setRotation(innerQube, 0F, 0F, 0F);
      outerQube = new ModelRenderer(this, 64, 0);
      outerQube.addBox(0F, 0F, 0F, 16, 16, 16);
      outerQube.setRotationPoint(-8F, 8F, -8F);
      outerQube.setTextureSize(128, 512);
      outerQube.mirror = true;
      setRotation(outerQube, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5);
    innerQube.render(f5);
    outerQube.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, null);
  }

}
