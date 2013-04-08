package dreamLand.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import dreamLand.DreamLand;
import dreamLand.utils.Archive;

public class BlockDreamLand extends Block {

    int dropid;
    
    public BlockDreamLand(int par1) {
        super(par1, Material.ground);
        dropid = blockID;
        this.setCreativeTab(DreamLand.tabDreamLand);
    }

    public BlockDreamLand(int id, int drop) {
        super(id, Material.rock);
        dropid = drop;
        this.setCreativeTab(DreamLand.tabDreamLand);
    }

    @Override
    public int idDropped(int var1, Random var2, int var3) {
        return dropid;
    }

    @Override
    public void registerIcons(IconRegister par1IconRegister) {
        blockIcon = par1IconRegister.registerIcon(Archive.modID + ":"
                + this.getUnlocalizedName2());
    }
}