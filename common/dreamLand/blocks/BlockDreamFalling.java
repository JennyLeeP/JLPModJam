package dreamLand.blocks;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSand;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dreamLand.DreamLand;
import dreamLand.utils.Reference;

public class BlockDreamFalling extends BlockSand{

    int dropid;
    @SideOnly(Side.CLIENT)
    private Icon icon[];
    String[]  fallingBlocks = {"dreamSand","dreamGravel","nmSand","nmGravel"};
    private String stepSound;

    public BlockDreamFalling(int id) {
        super(id, Material.sand);
        dropid = blockID;
        this.setHardness(0.6F);
        this.setCreativeTab(DreamLand.tabDreamLand);
        //getSound(null, id, id, id);
        this.setStepSound(Block.soundSandFootstep);
    }

    public void sounds(IBlockAccess world, int X, int Y, int Z) {
        if(world.getBlockMetadata(X, Y, Z) == 0){
            System.out.println("meta = 0");
        }else {
            System.out.println("meta = else");
        }


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
        icon = new Icon[4];
        for(int i = 0; i < fallingBlocks.length; i++)
        {
            icon[i] = iconRegister.registerIcon(Reference.texture + fallingBlocks[i]);
        }
    }
    @SuppressWarnings("unchecked")
    @Override
    public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, @SuppressWarnings("rawtypes") List par3List)
    {
        for(int i= 0; i < fallingBlocks.length; i++){
            par3List.add(new ItemStack(par1, 1, i));
        }
    }
    @Override
    public int damageDropped (int meta)
    {
        return meta;
    }
    public void getSound(World world, int posX, int posY, int posZ){
        int meta = 0;
        meta = world.getBlockMetadata(posX, posY, posZ);
        if(meta == (0 | 2)){
            this.setStepSound(Block.soundSandFootstep);
        }else{
            this.setStepSound(Block.soundGravelFootstep);
        }
    }
}
