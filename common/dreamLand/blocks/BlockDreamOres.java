package dreamLand.blocks;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dreamLand.DreamLand;
import dreamLand.utils.Reference;

public class BlockDreamOres extends BlockDreamLand{
    
    @SideOnly(Side.CLIENT)
    private Icon icon[];
    String[]  Ores = {"dlSolum","dlQuartz","dlBlackTourmaline","dlCarnelian","dlGoldenCalcite","dlBlueTopaz","dlRubelite","dlAzurite"
            ,"malumite","nmQuartz","nmBlackTourmaline","nmCarnelian","nmGoldenCalcite","nmBlueTopaz","nmRubelite","nmAzurite"};
    
    public BlockDreamOres(int id, int drop, int meta) {
        super(id, drop, meta);
        dropid = blockID;
        setHardness(2.0F);
        setStepSound(Block.soundStoneFootstep);
        this.setCreativeTab(DreamLand.tabDreamLand);
    }
    @Override
    public int idDropped(int var1, Random var2, int var3) {
        return dropid;
    }
    @Override
    public Icon getIcon(int side, int meta)
    {
        return icon[meta];
    }
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister) {
        icon = new Icon[16];
        for(int i = 0; i < Ores.length; i++)
        {
            icon[i] = iconRegister.registerIcon(Reference.texture + Ores[i]);
        }
    }
    @SuppressWarnings("unchecked")
    @Override
    public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, @SuppressWarnings("rawtypes") List par3List)
    {
        for(int i= 0; i < Ores.length; i++){
            par3List.add(new ItemStack(par1, 1, i));
        }
    }
    @Override
    public int damageDropped (int meta)
    {
        return meta;
    }
}
