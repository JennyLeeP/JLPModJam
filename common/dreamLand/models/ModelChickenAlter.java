package dreamLand.models;
import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;

public class ModelChickenAlter extends ModelBase
{
  //fields
    ModelRenderer Base;
    ModelRenderer Base2;
    ModelRenderer Base3;
    ModelRenderer Platform;
    ModelRenderer Body;
    ModelRenderer LeftWing;
    ModelRenderer RightWing;
    ModelRenderer Head;
    ModelRenderer UpperBeak;
    ModelRenderer LowerBeak;
    ModelRenderer Gobler;
    ModelRenderer LeftLeg;
    ModelRenderer RightLeg;
  
  public ModelChickenAlter()
  {
    textureWidth = 64;
    textureHeight = 64;
    
      Base = new ModelRenderer(this, 0, 0);
      Base.addBox(-8F, 0F, -8F, 16, 2, 16);
      Base.setRotationPoint(0F, 22F, 0F);
      Base.setTextureSize(64, 64);
      Base.mirror = true;
      setRotation(Base, 0F, 0F, 0F);
      Base2 = new ModelRenderer(this, 0, 18);
      Base2.addBox(-6F, 0F, -6F, 12, 8, 12);
      Base2.setRotationPoint(0F, 14F, 0F);
      Base2.setTextureSize(64, 64);
      Base2.mirror = true;
      setRotation(Base2, 0F, 0F, 0F);
      Base3 = new ModelRenderer(this, 32, 48);
      Base3.addBox(-4F, 0F, -4F, 8, 8, 8);
      Base3.setRotationPoint(0F, 6F, 0F);
      Base3.setTextureSize(64, 64);
      Base3.mirror = true;
      setRotation(Base3, 0F, 0F, 0F);
      Platform = new ModelRenderer(this, 8, 4);
      Platform.addBox(-6F, 0F, -6F, 12, 2, 12);
      Platform.setRotationPoint(0F, 4F, 0F);
      Platform.setTextureSize(64, 64);
      Platform.mirror = true;
      setRotation(Platform, 0F, 0F, 0F);
      Body = new ModelRenderer(this, 0, 40);
      Body.addBox(-3F, -4F, -4F, 6, 6, 8);
      Body.setRotationPoint(0F, -2F, 0F);
      Body.setTextureSize(64, 64);
      Body.mirror = true;
      setRotation(Body, 0F, 0F, 0F);
      LeftWing = new ModelRenderer(this, 0, 54);
      LeftWing.addBox(0F, 0F, -3F, 1, 4, 6);
      LeftWing.setRotationPoint(3F, -6F, 0F);
      LeftWing.setTextureSize(64, 64);
      LeftWing.mirror = true;
      setRotation(LeftWing, 0F, 0F, 0F);
      RightWing = new ModelRenderer(this, 0, 54);
      RightWing.addBox(-1F, 0F, -3F, 1, 4, 6);
      RightWing.setRotationPoint(-3F, -6F, 0F);
      RightWing.setTextureSize(64, 64);
      RightWing.mirror = true;
      setRotation(RightWing, 0F, 0F, 0F);
      Head = new ModelRenderer(this, 14, 55);
      Head.addBox(-2F, -6F, -3F, 4, 6, 3);
      Head.setRotationPoint(0F, -4F, -3F);
      Head.setTextureSize(64, 64);
      Head.mirror = true;
      setRotation(Head, 0F, 0F, 0F);
      UpperBeak = new ModelRenderer(this, 28, 45);
      UpperBeak.addBox(-2F, -4F, -5F, 4, 1, 2);
      UpperBeak.setRotationPoint(0F, -4F, -3F);
      UpperBeak.setTextureSize(64, 64);
      UpperBeak.mirror = true;
      setRotation(UpperBeak, 0F, 0F, 0F);
      LowerBeak = new ModelRenderer(this, 40, 45);
      LowerBeak.addBox(-2F, -3F, -5F, 4, 1, 2);
      LowerBeak.setRotationPoint(0F, -4F, -3F);
      LowerBeak.setTextureSize(64, 64);
      LowerBeak.mirror = true;
      setRotation(LowerBeak, 0F, 0F, 0F);
      Gobler = new ModelRenderer(this, 28, 41);
      Gobler.addBox(-1F, -2F, -4F, 2, 2, 1);
      Gobler.setRotationPoint(0F, -4F, -3F);
      Gobler.setTextureSize(64, 64);
      Gobler.mirror = true;
      setRotation(Gobler, 0F, 0F, 0F);
      LeftLeg = new ModelRenderer(this, 52, 41);
      LeftLeg.addBox(0F, 0F, -3F, 3, 4, 3);
      LeftLeg.setRotationPoint(0F, 0F, 2F);
      LeftLeg.setTextureSize(64, 64);
      LeftLeg.mirror = true;
      setRotation(LeftLeg, 0F, 0F, 0F);
      RightLeg = new ModelRenderer(this, 52, 41);
      RightLeg.addBox(-3F, 0F, -3F, 3, 4, 3);
      RightLeg.setRotationPoint(0F, 0F, 2F);
      RightLeg.setTextureSize(64, 64);
      RightLeg.mirror = true;
      setRotation(RightLeg, 0F, 0F, 0F);
  }
  
  public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7)
  {
      super.render(par1Entity, par2, par3, par4, par5, par6, par7);
      setRotationAngles(par2, par3, par4, par5, par6, par7, par1Entity);
    Base.render(par7);
    Base2.render(par7);
    Base3.render(par7);
    Platform.render(par7);
    Body.render(par7);
    LeftWing.render(par7);
    RightWing.render(par7);
    Head.render(par7);
    UpperBeak.render(par7);
    LowerBeak.render(par7);
    Gobler.render(par7);
    LeftLeg.render(par7);
    RightLeg.render(par7);
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
