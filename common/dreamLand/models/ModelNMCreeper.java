package dreamLand.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelNMCreeper extends ModelBase
{
  
	//fields
    public ModelRenderer head;
    public ModelRenderer body;
    public ModelRenderer leg3;
    public ModelRenderer leg4;
    public ModelRenderer leg1;
    public ModelRenderer leg2;
    public ModelRenderer LHornL;
    public ModelRenderer RHornL;
    public ModelRenderer RHornU;
    public ModelRenderer LHornU;
  
  public ModelNMCreeper()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      head = new ModelRenderer(this, 0, 0);
      head.addBox(-4F, -8F, -4F, 8, 8, 8);
      head.setRotationPoint(0F, 6F, 0F);
      head.setTextureSize(64, 32);
      head.mirror = true;
      setRotation(head, 0F, 0F, 0F);
      body = new ModelRenderer(this, 16, 16);
      body.addBox(-4F, 0F, -2F, 8, 12, 4);
      body.setRotationPoint(0F, 6F, 0F);
      body.setTextureSize(64, 32);
      body.mirror = true;
      setRotation(body, 0F, 0F, 0F);
      leg3 = new ModelRenderer(this, 0, 16);
      leg3.addBox(-2F, 0F, -2F, 4, 6, 4);
      leg3.setRotationPoint(-2F, 18F, -4F);
      leg3.setTextureSize(64, 32);
      leg3.mirror = true;
      setRotation(leg3, 0F, 0F, 0F);
      leg4 = new ModelRenderer(this, 0, 16);
      leg4.addBox(-2F, 0F, -2F, 4, 6, 4);
      leg4.setRotationPoint(2F, 18F, -4F);
      leg4.setTextureSize(64, 32);
      leg4.mirror = true;
      setRotation(leg4, 0F, 0F, 0F);
      leg1 = new ModelRenderer(this, 0, 16);
      leg1.addBox(0F, 0F, -2F, 4, 6, 4);
      leg1.setRotationPoint(-4F, 18F, 4F);
      leg1.setTextureSize(64, 32);
      leg1.mirror = true;
      setRotation(leg1, 0F, 0F, 0F);
      leg2 = new ModelRenderer(this, 0, 16);
      leg2.addBox(-2F, 0F, -2F, 4, 6, 4);
      leg2.setRotationPoint(2F, 18F, 4F);
      leg2.setTextureSize(64, 32);
      leg2.mirror = true;
      setRotation(leg2, 0F, 0F, 0F);
      LHornL = new ModelRenderer(this, 0, 26);
      LHornL.addBox(2F, -10F, -1F, 1, 2, 1);
      LHornL.setRotationPoint(0F, 6F, 0F);
      LHornL.setTextureSize(64, 32);
      LHornL.mirror = true;
      setRotation(LHornL, 0.296706F, 0F, 0F);
      RHornL = new ModelRenderer(this, 0, 26);
      RHornL.addBox(-3F, -10F, -1F, 1, 2, 1);
      RHornL.setRotationPoint(0F, 6F, 0F);
      RHornL.setTextureSize(64, 32);
      RHornL.mirror = true;
      setRotation(RHornL, 0.296706F, 0F, 0F);
      RHornU = new ModelRenderer(this, 0, 26);
      RHornU.addBox(-3F, -11.5F, 0.5F, 1, 2, 1);
      RHornU.setRotationPoint(0F, 6F, 0F);
      RHornU.setTextureSize(64, 32);
      RHornU.mirror = true;
      setRotation(RHornU, 0.4537856F, 0F, 0F);
      LHornU = new ModelRenderer(this, 0, 26);
      LHornU.addBox(2F, -11.5F, 0.5F, 1, 2, 1);
      LHornU.setRotationPoint(0F, 6F, 0F);
      LHornU.setTextureSize(64, 32);
      LHornU.mirror = true;
      setRotation(LHornU, 0.4537856F, 0F, 0F);
  }
  
  public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7)
  {
    super.render(par1Entity, par2, par3, par4, par5, par6, par7);
    setRotationAngles(par2, par3, par4, par5, par6, par7, par1Entity);
   
    head.renderWithRotation(par7);
    body.renderWithRotation(par7);
    leg3.renderWithRotation(par7);
    leg4.renderWithRotation(par7);
    leg1.renderWithRotation(par7);
    leg2.renderWithRotation(par7);
    LHornL.renderWithRotation(par7);
    RHornL.renderWithRotation(par7);
    RHornU.renderWithRotation(par7);
    LHornU.renderWithRotation(par7);
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
    this.head.rotateAngleY = par4 / (180F / (float)Math.PI);
    this.head.rotateAngleX = par5 / (180F / (float)Math.PI);
    this.LHornL.rotateAngleX = this.head.rotateAngleX;
    this.LHornL.rotateAngleY = this.head.rotateAngleY;
    this.LHornU.rotateAngleX = this.head.rotateAngleX;
    this.LHornU.rotateAngleY = this.head.rotateAngleY;
    this.RHornL.rotateAngleX = this.head.rotateAngleX;
    this.RHornL.rotateAngleY = this.head.rotateAngleY;
    this.RHornU.rotateAngleX = this.head.rotateAngleX;
    this.RHornU.rotateAngleY = this.head.rotateAngleY;
    this.leg1.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 1.4F * par2;
    this.leg2.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 1.4F * par2;
    this.leg3.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 1.4F * par2;
    this.leg4.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 1.4F * par2;
    
    
  }

}
