package dreamLand.blocks;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import dreamLand.DreamLand;
import dreamLand.utils.Archive;

public class sparklingSapling extends Item {

    public sparklingSapling(int par1) {
        super(par1);
        /*float f = 0.4F;*/
        /*this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 2.0F, 0.5F + f);*/
        this.setCreativeTab(DreamLand.tabDreamLand);
    }

    @Override
    public void updateIcons(IconRegister par1IconRegister) {
        iconIndex = par1IconRegister.registerIcon(Archive.modID + ":sparklingSapling");
    }

    /*
     * protected boolean canThisPlantGrowOnThisBlockID(int i) {
     * return i == DreamLand.dreamGrass.blockID;
     * }
     */

    /*
     * public void updateTick(World world, int i, int j, int k, Random random) {
     * int l = world.getBlockMetadata(i, j, k) & 3;
     * world.setBlock(i, j, k, 0);
     * Object obj = null;
     * obj = new WorldGenSparklingTree();
     * if (!((WorldGenerator) (obj)).generate(world, random, i, j, k)){
     * world.setBlockMetadataWithNotify(i, j, k, blockID, l);
     * }
     * }
     */

    /*
     * public int damageDropped(int i) {
     * return i & 3;
     * }
     */

}
