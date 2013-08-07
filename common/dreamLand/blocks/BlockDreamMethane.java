package dreamLand.blocks;

import java.util.Random;

import dreamLand.DreamLand;
import dreamLand.items.ModItems;
import dreamLand.utils.Reference;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

public class BlockDreamMethane extends Block{
    int dropid;
    public BlockDreamMethane(int par1, int drop)
    {
        super(par1, Material.clay);
        dropid = blockID;
        this.setCreativeTab(DreamLand.tabDreamLand);
    }

    /**
     * Returns the ID of the items to drop on destruction.
     */
    public int idDropped(int par1, Random par2Random, int par3)
    {
        return ModItems.itemMethaneClathrate.itemID;
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random par1Random)
    {
        return 2;
    }
    @Override
    public void registerIcons(IconRegister par1IconRegister) {
        blockIcon = par1IconRegister.registerIcon(Reference.texture
                + this.getUnlocalizedName2());
    }
}
