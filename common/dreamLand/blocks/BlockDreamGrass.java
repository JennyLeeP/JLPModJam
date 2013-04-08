package dreamLand.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import net.minecraft.world.ColorizerGrass;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dreamLand.DreamLand;
import dreamLand.utils.Archive;

public class BlockDreamGrass extends Block {

    @SideOnly(Side.CLIENT)
    private Icon iconDreamGrassTop;
    @SideOnly(Side.CLIENT)
    private Icon iconSnowSide;
    @SideOnly(Side.CLIENT)
    private Icon iconDreamGrassSideOverlay;

    public BlockDreamGrass(int par1) {
        super(par1, Material.grass);
        this.setTickRandomly(true);
        this.setCreativeTab(DreamLand.tabDreamLand);
    }

    @Override
    @SideOnly(Side.CLIENT)
    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    public Icon getBlockTextureFromSideAndMetadata(int par1, int par2) {
        return par1 == 1 ? iconDreamGrassTop : (par1 == 0 ? ModBlocks.dreamDirt
                .getBlockTextureFromSide(par1) : blockIcon);
    }

    /**
     * Ticks the block if it's been scheduled
     */
    @Override
    public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random) {
        if (!par1World.isRemote){
            if ((par1World.getBlockLightValue(par2, par3 + 1, par4) < 4)
                    && (par1World.getBlockLightOpacity(par2, par3 + 1, par4) > 2)){
                par1World.setBlock(par2, par3, par4, ModBlocks.dreamDirt.blockID);
            }else if (par1World.getBlockLightValue(par2, par3 + 1, par4) >= 9){
                for (int l = 0; l < 4; ++l){
                    int i1 = (par2 + par5Random.nextInt(3)) - 1;
                    int j1 = (par3 + par5Random.nextInt(5)) - 3;
                    int k1 = (par4 + par5Random.nextInt(3)) - 1;
                    par1World.getBlockId(i1, j1 + 1, k1);

                    if ((par1World.getBlockId(i1, j1, k1) == Block.dirt.blockID)
                            && (par1World.getBlockLightValue(i1, j1 + 1, k1) >= 4)
                            && (par1World.getBlockLightOpacity(i1, j1 + 1, k1) <= 2)){
                        par1World.setBlock(i1, j1, k1, ModBlocks.dreamGrass.blockID);// /find
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
        return ModBlocks.dreamDirt.idDropped(0, par2Random, par3);
    }

    @Override
    @SideOnly(Side.CLIENT)
    /**
     * Retrieves the block texture to use based on the display side. Args: iBlockAccess, x, y, z, side
     */
    public Icon getBlockTexture(IBlockAccess par1IBlockAccess, int par2, int par3, int par4,
            int par5) {
        if (par5 == 1){
            return iconDreamGrassTop;
        }else if (par5 == 0){
            return ModBlocks.dreamDirt.getBlockTextureFromSide(par5);
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
        blockIcon = par1IconRegister.registerIcon(Archive.texture + this.getUnlocalizedName2()
                + "_side");
        iconDreamGrassTop = par1IconRegister.registerIcon(Archive.texture
                + this.getUnlocalizedName2() + "_top");
        // this.iconSnowSide = par1IconRegister.registerIcon("snow_side");
        iconDreamGrassSideOverlay = par1IconRegister.registerIcon(Archive.texture
                + this.getUnlocalizedName2() + "_side_overlay");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getBlockColor() {
        double d0 = 0.5D;
        double d1 = 1.0D;
        return ColorizerGrass.getGrassColor(d0, d1);
    }

    @Override
    @SideOnly(Side.CLIENT)
    /**
     * Returns the color this block should be rendered. Used by leaves.
     */
    public int getRenderColor(int par1) {
        return this.getBlockColor();
    }

    // @SideOnly(Side.CLIENT)

    /**
     * Returns a integer with hex for 0xrrggbb with this color multiplied
     * against the blocks color. Note only called when first determining what to
     * render.
     */
    /*
     * public int colorMultiplier(IBlockAccess par1IBlockAccess, int par2, int
     * par3, int par4) { int l = 0;//110; int i1 = 0;//214; int j1 = 0;//150;
     * for (int k1 = -1; k1 <= 1; ++k1) { for (int l1 = -1; l1 <= 1; ++l1) { int
     * i2 = par1IBlockAccess.getBiomeGenForCoords(par2 + l1, par4 +
     * k1).getBiomeGrassColor(); l += (i2 & 16711680) >> 16; i1 += (i2 & 65280)
     * >> 8; j1 += i2 & 255; } } //return (l) << 16 | (i1) << 8 | j1 ; return (l
     * / 9 & 255) << 16 | (i1 / 9 & 255) << 8 | j1 / 9 & 255; }
     * @SideOnly(Side.CLIENT) public Icon getIconSideOverlay() { return
     * this.iconDreamGrassSideOverlay; }
     */

}
