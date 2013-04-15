package dreamLand.blocks;

import java.util.Random;

import net.minecraft.block.BlockSand;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import dreamLand.DreamLand;
import dreamLand.utils.Archive;

public class BlockDreamGravel extends BlockSand {

    int dropid;

    public BlockDreamGravel(int id) {
        super(id, Material.ground);
        dropid = blockID;
        this.setCreativeTab(DreamLand.tabDreamLand);
    }

    @Override
    public int idDropped(int var1, Random var2, int var3) {
        return dropid;
    }

    @Override
    public void registerIcons(IconRegister par1IconRegister) {
        blockIcon = par1IconRegister.registerIcon(Archive.texture + this.getUnlocalizedName2());
    }
}