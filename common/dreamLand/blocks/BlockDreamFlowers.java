package dreamLand.blocks;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraftforge.common.IPlantable;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dreamLand.DreamLand;
import dreamLand.utils.Reference;

public class BlockDreamFlowers extends BlockFlower implements IPlantable{

    @SideOnly(Side.CLIENT)
    private Icon[] icon;
    String[]  FlowerTypes = {"whiteFlower","orangeFlower","magentaFlower","lightBlueFlower","yellowFlower", "limeFlower", "pinkFlower","grayFlower"
            , "lightGrayFlower", "cyanFlower", "purpleFlower", "blueFlower", "brownFlower", "greenFlower", "redFlower", "blackFlower"};
    
    public BlockDreamFlowers(int par1) {
        super(par1);
        this.setStepSound(Block.soundGrassFootstep);
        this.setCreativeTab(DreamLand.tabDreamLand);
    }
    @Override
    protected boolean canThisPlantGrowOnThisBlockID(int par1)
    {
        return par1 == Block.grass.blockID || par1 == Block.dirt.blockID || par1 == Block.tilledField.blockID || par1 == ModBlocks.dreamDirt.blockID || par1 == ModBlocks.nmDirt.blockID;
    }
    @SideOnly(Side.CLIENT)
    @Override
    public Icon getIcon(int side, int meta)
    {
        return icon[meta];
    }
    @Override
    public boolean isOpaqueCube()
    {
        return false;
    }
    @Override
    public boolean renderAsNormalBlock()
    {
        return false;
    }
    @Override
    public int getRenderType() {
        return 1;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister) {
        icon = new Icon[16];

        for (int i = 0; i < FlowerTypes.length; i++) {
            icon[i] = par1IconRegister.registerIcon(Reference.texture  + FlowerTypes[i]);
        }
    }
    @SuppressWarnings("unchecked")
    @Override
    public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, @SuppressWarnings("rawtypes") List par3List)
    {
        for(int i= 0; i < FlowerTypes.length; i++){
            par3List.add(new ItemStack(par1, 1, i));
        }
    }
    @Override
    public int damageDropped (int meta)
    {
        return meta;
    }

   
}
