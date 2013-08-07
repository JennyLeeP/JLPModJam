package dreamLand.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.common.IPlantable;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dreamLand.DreamLand;
import dreamLand.utils.Reference;

public class BlockNMGrass extends Block{

	@SideOnly(Side.CLIENT)
    private Icon iconNMGrassTop;
    @SideOnly(Side.CLIENT)
    private Icon iconSnowSide;
    @SideOnly(Side.CLIENT)
    private Icon iconNMGrassSideOverlay;

    public BlockNMGrass(int par1) {
        super(par1, Material.grass);
        this.setTickRandomly(true);
        this.setCreativeTab(DreamLand.tabDreamLand);
    }

    @Override
    @SideOnly(Side.CLIENT)
    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    public Icon getIcon(int par1, int par2) {
        return par1 == 1 ? iconNMGrassTop : (par1 == 0 ? ModBlocks.nmDirt
                .getBlockTextureFromSide(par1) : blockIcon);
    }
    @Override
    public boolean canSustainPlant(World world, int x, int y, int z, ForgeDirection direction, IPlantable plant)
    {
        return true;
    }
    /**
     * Ticks the block if it's been scheduled
     */
    @Override
    public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random) {
        if (!par1World.isRemote){
            if ((par1World.getBlockLightValue(par2, par3 + 1, par4) < 4)
                    && (par1World.getBlockLightOpacity(par2, par3 + 1, par4) > 2)){
                par1World.setBlock(par2, par3, par4, ModBlocks.nmDirt.blockID);
            }else if (par1World.getBlockLightValue(par2, par3 + 1, par4) >= 9){
                for (int l = 0; l < 4; ++l){
                    int i1 = (par2 + par5Random.nextInt(3)) - 1;
                    int j1 = (par3 + par5Random.nextInt(5)) - 3;
                    int k1 = (par4 + par5Random.nextInt(3)) - 1;
                    par1World.getBlockId(i1, j1 + 1, k1);

                    if ((par1World.getBlockId(i1, j1, k1) == ModBlocks.nmDirt.blockID)
                            && (par1World.getBlockLightValue(i1, j1 + 1, k1) >= 4)
                            && (par1World.getBlockLightOpacity(i1, j1 + 1, k1) <= 2)){
                        par1World.setBlock(i1, j1, k1, ModBlocks.nmGrass.blockID);// /find
                                                                                     // replacement
                                                                                     // TODO
                    }
                }
            }
        }
    }

    /**
     * Returns the ID of the items to drop on destruction.
     */
    @Override
    public int idDropped(int par1, Random par2Random, int par3) {
        return ModBlocks.nmDirt.idDropped(0, par2Random, par3);
    }

    @Override
    @SideOnly(Side.CLIENT)
    /**
     * Retrieves the block texture to use based on the display side. Args: iBlockAccess, x, y, z, side
     */
    public Icon getBlockTexture(IBlockAccess par1IBlockAccess, int par2, int par3, int par4,
            int par5) {
        if (par5 == 1){
            return iconNMGrassTop;
        }else if (par5 == 0){
            return ModBlocks.nmDirt.getBlockTextureFromSide(par5);
        }else{
            Material material = par1IBlockAccess.getBlockMaterial(par2, par3 + 1, par4);
            return (material != Material.snow) && (material != Material.craftedSnow) ? blockIcon
                    : iconSnowSide;
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    /**
     * When this method is called, your block should register all the icons it needs with the given IconRegister. This
     * is the only chance you get to register icons.
     */
    public void registerIcons(IconRegister par1IconRegister) {
        blockIcon = par1IconRegister.registerIcon(Reference.texture + this.getUnlocalizedName2()
                + "_side");
        iconNMGrassTop = par1IconRegister.registerIcon(Reference.texture
                + this.getUnlocalizedName2() + "_top");
        // this.iconSnowSide = par1IconRegister.registerIcon("snow_side");
        iconNMGrassSideOverlay = par1IconRegister.registerIcon(Reference.texture
                + this.getUnlocalizedName2() + "_side_overlay");
    }
}
