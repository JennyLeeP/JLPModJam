package dreamLand.blocks;

import java.util.List;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import dreamLand.DreamLand;
import dreamLand.utils.Archive;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSand;
import net.minecraft.block.StepSound;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

public class BlockDreamFalling extends BlockSand{
    
    int dropid;
    @SideOnly(Side.CLIENT)
    Icon[] icons = new Icon[16];
    String[]  fallingBlocks = {"dreamSand","dreamGravel","nmSand","nmGravel"};

    public BlockDreamFalling(int id) {
        super(id, Material.sand);
        dropid = blockID;
        this.setCreativeTab(DreamLand.tabDreamLand);
    }
    @Override
    /**
     * Sets the footstep sound for the block. Returns the object for convenience in constructing.
     */
    public Block setStepSound(StepSound par1StepSound)
    {
        this.stepSound = par1StepSound;
        return this;
    }
    @Override
    public int idDropped(int var1, Random var2, int var3) {
        return dropid;
    }
    @Override
    public Icon getIcon(int side, int meta)
    {
        return icons[meta];
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(IconRegister iconRegister) {
        for(int i = 0; i < fallingBlocks.length; i++)
        {
            icons[i] = iconRegister.registerIcon(Archive.texture + fallingBlocks[i]);
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
}
