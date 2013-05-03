package dreamLand.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelSonicCreeper extends ModelBase
{
  //fields
    public ModelRenderer head;
    public ModelRenderer body;
    public ModelRenderer leg3;
    public ModelRenderer leg4;
    public ModelRenderer leg1;
    public ModelRenderer leg2;
    public ModelRenderer LearI;
    public ModelRenderer REarI;
    public ModelRenderer LEarO;
    public ModelRenderer REarO;
    public ModelRenderer REarU;
    public ModelRenderer LEarU;
    public ModelRenderer EarTop;
    
    protected float field_78145_g = 16.0F;

	public ModelSonicCreeper() {
		this(0.0F);
	}
  
  public ModelSonicCreeper(float par1)
  {
	  //System.out.println("Model loaded");
	  
	textureWidth = 64;
    textureHeight = 32;
    
      this.head = new ModelRenderer(this, 0, 0);
      this.head.addBox(-4F, -8F, -4F, 8, 8, 8);
      this.head.setRotationPoint(0F, 6F, 0F);
      this.head.setTextureSize(64, 32);
      this.head.mirror = true;
      this.setRotation(head, 0F, 0F, 0F);
      this.body = new ModelRenderer(this, 16, 16);
      this.body.addBox(-4F, 0F, -2F, 8, 12, 4);
      this.body.setRotationPoint(0F, 6F, 0F);
      this.body.setTextureSize(64, 32);
      this.body.mirror = true;
      this.setRotation(body, 0F, 0F, 0F);
      this.leg3 = new ModelRenderer(this, 0, 16);
      this.leg3.addBox(-2F, 0F, -2F, 4, 6, 4);
      this.leg3.setRotationPoint(-2F, 18F, -4F);
      this.leg3.setTextureSize(64, 32);
      this.leg3.mirror = true;
      this.setRotation(leg3, 0F, 0F, 0F);
      this.leg4 = new ModelRenderer(this, 0, 16);
      this.leg4.addBox(-2F, 0F, -2F, 4, 6, 4);
      this.leg4.setRotationPoint(2F, 18F, -4F);
      this.leg4.setTextureSize(64, 32);
      this.leg4.mirror = true;
      this.setRotation(leg4, 0F, 0F, 0F);
      this.leg1 = new ModelRenderer(this, 0, 16);
      this.leg1.addBox(0F, 0F, -2F, 4, 6, 4);
      this.leg1.setRotationPoint(-4F, 18F, 4F);
      this.leg1.setTextureSize(64, 32);
      this.leg1.mirror = true;
      this.setRotation(leg1, 0F, 0F, 0F);
      this.leg2 = new ModelRenderer(this, 0, 16);
      this.leg2.addBox(-2F, 0F, -2F, 4, 6, 4);
      this.leg2.setRotationPoint(2F, 18F, 4F);
      this.leg2.setTextureSize(64, 32);
      this.leg2.mirror = true;
      this.setRotation(leg2, 0F, 0F, 0F);
      this.LearI = new ModelRenderer(this, 32, 0);
      this.LearI.addBox(4F, -6F, -1F, 1, 3, 3);
      this.LearI.setRotationPoint(0F, 6F, 0F);
      this.LearI.setTextureSize(64, 32);
      this.LearI.mirror = true;
      this.setRotation(LearI, 0F, 0F, 0F);
      this.REarI = new ModelRenderer(this, 32, 0);
      this.REarI.addBox(-5F, -6F, -1F, 1, 3, 3);
      this.REarI.setRotationPoint(0F, 6F, 0F);
      this.REarI.setTextureSize(64, 32);
      this.REarI.mirror = true;
      this.setRotation(REarI, 0F, 0F, 0F);
      this.LEarO = new ModelRenderer(this, 40, 0);
      this.LEarO.addBox(4.5F, -5.5F, -0.5F, 1, 2, 2);
      this.LEarO.setRotationPoint(0F, 6F, 0F);
      this.LEarO.setTextureSize(64, 32);
      this.LEarO.mirror = true;
      this.setRotation(LEarO, 0F, 0F, 0F);
      this.REarO = new ModelRenderer(this, 40, 0);
      this.REarO.addBox(-5.5F, -5.5F, -0.5F, 1, 2, 2);
      this.REarO.setRotationPoint(0F, 6F, 0F);
      this.REarO.setTextureSize(64, 32);
      this.REarO.mirror = true;
      this.setRotation(REarO, 0F, 0F, 0F);
      this.REarU = new ModelRenderer(this, 32, 6);
      this.REarU.addBox(-5F, -9F, 0F, 1, 3, 1);
      this.REarU.setRotationPoint(0F, 6F, 0F);
      this.REarU.setTextureSize(64, 32);
      this.REarU.mirror = true;
      this.setRotation(REarU, 0F, 0F, 0F);
      this.LEarU = new ModelRenderer(this, 32, 6);
      this.LEarU.addBox(4F, -9F, 0F, 1, 3, 1);
      this.LEarU.setRotationPoint(0F, 6F, 0F);
      this.LEarU.setTextureSize(64, 32);
      this.LEarU.mirror = true;
      this.setRotation(LEarU, 0F, 0F, 0F);
      this.EarTop = new ModelRenderer(this, 46, 0);
      this.EarTop.addBox(-4F, -9F, 0F, 8, 1, 1);
      this.EarTop.setRotationPoint(0F, 6F, 0F);
      this.EarTop.setTextureSize(64, 32);
      this.EarTop.mirror = true;
      this.setRotation(EarTop, 0F, 0F, 0F);
  }
  

public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7)
  {
    super.render(par1Entity, par2, par3, par4, par5, par6, par7);
    setRotationAngles(par2, par3, par4, par5, par6, par7, par1Entity);
    head.render(par7);
    body.render(par7);
    leg3.render(par7);
    leg4.render(par7);
    leg1.render(par7);
    leg2.render(par7);
    LearI.render(par7);
    REarI.render(par7);
    LEarO.render(par7);
    REarO.render(par7);
    REarU.render(par7);
    LEarU.render(par7);
    EarTop.render(par7);
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
    this.EarTop.rotateAngleX = this.head.rotateAngleX;
    this.EarTop.rotateAngleY = this.head.rotateAngleY;
    this.LEarU.rotateAngleX = this.head.rotateAngleX;
    this.LEarU.rotateAngleY = this.head.rotateAngleY;
    this.LearI.rotateAngleX = this.head.rotateAngleX;
    this.LearI.rotateAngleY = this.head.rotateAngleY;
    this.LEarO.rotateAngleX = this.head.rotateAngleX;
    this.LEarO.rotateAngleY = this.head.rotateAngleY;
    this.REarU.rotateAngleX = this.head.rotateAngleX;
    this.REarU.rotateAngleY = this.head.rotateAngleY;
    this.REarU.rotateAngleX = this.head.rotateAngleX;
    this.REarI.rotateAngleY = this.head.rotateAngleY;
    this.REarI.rotateAngleX = this.head.rotateAngleX;
    this.REarO.rotateAngleY = this.head.rotateAngleY;
    this.leg1.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 1.4F * par2;
    this.leg2.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 1.4F * par2;
    this.leg3.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 1.4F * par2;
    this.leg4.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 1.4F * par2;
  }

}
