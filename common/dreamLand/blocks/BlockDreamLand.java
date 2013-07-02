package dreamLand.blocks;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import dreamLand.DreamLand;
import dreamLand.utils.Archive;

public class BlockDreamLand extends Block {

    int dropid;
    int metaData;
    
    public BlockDreamLand(int par1) {
        super(par1, Material.ground);
        dropid = blockID;
        this.setCreativeTab(DreamLand.tabDreamLand);
    }

    public BlockDreamLand(int id, int drop, int meta) {
        super(id, Material.rock);
        dropid = drop;
       metaData = meta;
        this.setCreativeTab(DreamLand.tabDreamLand);
    }

    public BlockDreamLand(int par1, Material par2Material) {
        super(par1, Material.wood);
        dropid = blockID;
        this.setCreativeTab(DreamLand.tabDreamLand);
    }

    @Override
    public int idDropped(int var1, Random var2, int var3) {
        return dropid;
    }
    @SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(IconRegister par1IconRegister) {
        blockIcon = par1IconRegister.registerIcon(Archive.texture
                + this.getUnlocalizedName2());
    }
    @SideOnly(Side.CLIENT)
    private Icon[] icons;
}