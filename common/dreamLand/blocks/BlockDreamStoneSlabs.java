package dreamLand.blocks;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockHalfSlab;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dreamLand.DreamLand;
import dreamLand.utils.Reference;

public class BlockDreamStoneSlabs extends BlockHalfSlab{

    @SideOnly(Side.CLIENT)
    private Icon[] icons;
    protected final boolean isDoubleSlab;
    private SlabType slabType;

    public static enum SlabType
    {
        WOOD, STONE;
    }
    public static final String[] StoneSlabs ={"dreamCobble", "dreamStoneBrick", "dreamStoneCrackedBrick", "dreamStoneMossBrick", "nmCobble","nmBrick", "nmCrackedBrick", "bloodCobble","bloodBrick", "marble", "granite"};
    public static final String[] WoodSlabs ={"sparkling", "ash", "brilliant","dark", "frigid", "infernal", "life", "death"};

    public BlockDreamStoneSlabs(int par1, boolean par2, Material material, SlabType sType) {
        super(par1, par2, material);
        isDoubleSlab = par2;
        slabType = sType;
        useNeighborBrightness[blockID] = true;
        if(material ==  Material.wood){
            setStepSound(Block.soundWoodFootstep);
        }else if (material == Material.rock){
            setStepSound(Block.soundStoneFootstep);
        }
        if(!par2){
            setCreativeTab(DreamLand.tabDreamLand);
        }
    }

    @SideOnly(Side.CLIENT)
    @Override
    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    public Icon getIcon(int id, int meta)
    {
        if (slabType == SlabType.STONE)
            return icons[meta];
        else
            return icons[meta];
    }

    /**
     * Returns the ID of the items to drop on destruction.
     */
    public int idDropped(int par1, Random par2Random, int par3)
    {
        if (isDoubleSlab)
        {
            if (blockID == ModBlocks.dreamStoneDBLSlabs.blockID)
                return ModBlocks.dreamStoneSlabs.blockID;
            // else
            //return ModBlocks.dreamWoodSlabs.blockID;
        }
        //else
        return blockID;
    }
    @Override
    public int damageDropped(int meta)
    {
        return meta;
    }
    @Override
    protected ItemStack createStackedBlock(int par1)
    {
        return new ItemStack(blockID, 2, par1);
    }
    @Override
    public String getFullSlabName(int par1)
    {
        if (slabType == SlabType.STONE)
            if (par1 < 0 || par1 >= StoneSlabs.length)
            {
                par1 = 0;
            }
        return super.getUnlocalizedName() + "." + StoneSlabs[par1];

    }

    @SuppressWarnings("unchecked")
    @SideOnly(Side.CLIENT)

    /**
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     */
    public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, @SuppressWarnings("rawtypes") List par3List)
    {
        if (par1 != ModBlocks.dreamStoneDBLSlabs.blockID)
        {
            for (int j = 0; j < StoneSlabs.length; j++)
            {
                par3List.add(new ItemStack(par1, 1, j));
            }
        }/*else {
        for (int j = 0; j < WoodSlabs.length; j++){
            par3List.add(new ItemStack(par1, 1, j));
        }
    }*/
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(IconRegister iconRegister) {
        if (slabType == SlabType.STONE)
        {
            icons = new Icon[StoneSlabs.length];

            for (int i = 0; i < StoneSlabs.length; i++) {
                icons[i] = iconRegister.registerIcon(Reference.texture + StoneSlabs[i]);
            }
        }
        else
        {
            icons = new Icon[WoodSlabs.length];

            for (int i = 0; i < WoodSlabs.length; i++) {
                icons[i] = iconRegister.registerIcon(Reference.texture + WoodSlabs[i] + "_Planks");
            }
        }
    }
    @Override
    public int idPicked(World par1World, int par2, int par3, int par4)
    {
        return !isDoubleSlab ? blockID : (blockID == ModBlocks.dreamWoodDBLSlabs.blockID ? ModBlocks.dreamWoodSlabs.blockID : ModBlocks.dreamStoneSlabs.blockID);
    }
    private static int getTypeFromMeta(int meta)
    {
        return meta;
    }
}
