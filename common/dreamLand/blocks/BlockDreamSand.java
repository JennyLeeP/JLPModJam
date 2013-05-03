package dreamLand.blocks;

import java.util.Random;

import dreamLand.DreamLand;
import dreamLand.utils.Archive;
import net.minecraft.block.BlockSand;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

public class BlockDreamSand extends BlockSand{

	int dropid;

    public BlockDreamSand(int id) {
        super(id, Material.sand);
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
