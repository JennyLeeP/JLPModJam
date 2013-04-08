package dreamLand.world.terrain;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSapling;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.ForgeDirection;

public class WorldGenDreamLandTrees extends WorldGenerator {

    /**
     * Contains three sets of two values that provide complimentary indices for
     * a given 'major' index - 1 and 2 for 0, 0 and 2 for 1, and 0 and 1 for 2.
     */
    static final byte[] otherCoordPairs = new byte[] { (byte) 2, (byte) 0, (byte) 0, (byte) 1,
            (byte) 2, (byte) 1 };

    /** random seed for GenBigTree */
    Random rand = new Random();

    /** Reference to the World object. */
    World worldObj;
    int[] basePos = new int[] { 0, 0, 0 };
    int heightLimit = 0;
    int height;
    double heightAttenuation = 0.618D;
    double branchDensity = 1.0D;
    double branchSlope = 0.381D;
    double scaleWidth = 1.0D;
    double leafDensity = 1.0D;

    /**
     * Currently always 1, can be set to 2 in the class constructor to generate
     * a double-sized tree trunk for big trees.
     */
    int trunkSize = 1;

    /**
     * Sets the limit of the random value used to initialize the height limit.
     */
    int heightLimitLimit = 12;

    /**
     * Sets the distance limit for how far away the generator will populate
     * leaves from the base leaf node.
     */
    int leafDistanceLimit = 4;

    /** Contains a list of a points at which to generate groups of leaves. */
    int[][] leafNodes;

    public WorldGenDreamLandTrees(boolean par1) {
        super(par1);
        // System.out.println("trees");
    }

    /**
     * Generates a list of leaf nodes for the tree, to be populated by
     * generateLeaves.
     */
    void generateLeafNodeList() {
        height = (int) (heightLimit * heightAttenuation);

        if (height >= heightLimit){
            height = heightLimit - 1;
        }

        int i = (int) (1.382D + Math.pow((leafDensity * heightLimit) / 13.0D, 2.0D));

        if (i < 1){
            i = 1;
        }

        int[][] aint = new int[i * heightLimit][4];
        int j = (basePos[1] + heightLimit) - leafDistanceLimit;
        int k = 1;
        int l = basePos[1] + height;
        int i1 = j - basePos[1];
        aint[0][0] = basePos[0];
        aint[0][1] = j;
        aint[0][2] = basePos[2];
        aint[0][3] = l;
        --j;

        while (i1 >= 0){
            int j1 = 0;
            float f = this.layerSize(i1);

            if (f < 0.0F){
                --j;
                --i1;
            }else{
                for (double d0 = 0.5D; j1 < i; ++j1){
                    double d1 = scaleWidth * f * (rand.nextFloat() + 0.328D);
                    double d2 = rand.nextFloat() * 2.0D * Math.PI;
                    int k1 = MathHelper.floor_double((d1 * Math.sin(d2)) + basePos[0] + d0);
                    int l1 = MathHelper.floor_double((d1 * Math.cos(d2)) + basePos[2] + d0);
                    int[] aint1 = new int[] { k1, j, l1 };
                    int[] aint2 = new int[] { k1, j + leafDistanceLimit, l1 };

                    if (this.checkBlockLine(aint1, aint2) == -1){
                        int[] aint3 = new int[] { basePos[0], basePos[1], basePos[2] };
                        double d3 = Math.sqrt(Math.pow(Math.abs(basePos[0] - aint1[0]), 2.0D)
                                + Math.pow(Math.abs(basePos[2] - aint1[2]), 2.0D));
                        double d4 = d3 * branchSlope;

                        if ((aint1[1] - d4) > l){
                            aint3[1] = l;
                        }else{
                            aint3[1] = (int) (aint1[1] - d4);
                        }

                        if (this.checkBlockLine(aint3, aint1) == -1){
                            aint[k][0] = k1;
                            aint[k][1] = j;
                            aint[k][2] = l1;
                            aint[k][3] = aint3[1];
                            ++k;
                        }
                    }
                }

                --j;
                --i1;
            }
        }

        leafNodes = new int[k][4];
        System.arraycopy(aint, 0, leafNodes, 0, k);
    }

    void genTreeLayer(int par1, int par2, int par3, float par4, byte par5, int par6) {
        int i1 = (int) (par4 + 0.618D);
        byte b1 = otherCoordPairs[par5];
        byte b2 = otherCoordPairs[par5 + 3];
        int[] aint = new int[] { par1, par2, par3 };
        int[] aint1 = new int[] { 0, 0, 0 };
        int j1 = -i1;
        int k1 = -i1;

        for (aint1[par5] = aint[par5]; j1 <= i1; ++j1){
            aint1[b1] = aint[b1] + j1;
            k1 = -i1;

            while (k1 <= i1){
                double d0 = Math.pow(Math.abs(j1) + 0.5D, 2.0D)
                        + Math.pow(Math.abs(k1) + 0.5D, 2.0D);

                if (d0 > par4 * par4){
                    ++k1;
                }else{
                    aint1[b2] = aint[b2] + k1;
                    int l1 = worldObj.getBlockId(aint1[0], aint1[1], aint1[2]);

                    if ((l1 != 0) && (l1 != Block.leaves.blockID)){
                        ++k1;
                    }else{
                        if (par6 != Block.leaves.blockID){
                            this.setBlockAndMetadata(worldObj, aint1[0], aint1[1], aint1[2], par6,
                                    0);
                        }
                        ++k1;
                    }
                }
            }
        }
    }

    /**
     * Gets the rough size of a layer of the tree.
     */
    float layerSize(int par1) {
        if (par1 < ((heightLimit) * 0.3D)){
            return -1.618F;
        }else{
            float f = heightLimit / 2.0F;
            float f1 = (heightLimit / 2.0F) - par1;
            float f2;

            if (f1 == 0.0F){
                f2 = f;
            }else if (Math.abs(f1) >= f){
                f2 = 0.0F;
            }else{
                f2 = (float) Math.sqrt(Math.pow(Math.abs(f), 2.0D) - Math.pow(Math.abs(f1), 2.0D));
            }

            f2 *= 0.5F;
            return f2;
        }
    }

    float leafSize(int par1) {
        return (par1 >= 0) && (par1 < leafDistanceLimit) ? ((par1 != 0)
                && (par1 != (leafDistanceLimit - 1)) ? 3.0F : 2.0F) : -1.0F;
    }

    /**
     * Generates the leaves surrounding an individual entry in the leafNodes
     * list.
     */
    void generateLeafNode(int par1, int par2, int par3) {
        int l = par2;

        for (int i1 = par2 + leafDistanceLimit; l < i1; ++l){
            float f = this.leafSize(l - par2);
            this.genTreeLayer(par1, l, par3, f, (byte) 1, Block.leaves.blockID);
        }
    }

    /**
     * Places a line of the specified block ID into the world from the first
     * coordinate triplet to the second.
     */
    void placeBlockLine(int[] par1ArrayOfInteger, int[] par2ArrayOfInteger, int par3) {
        int[] aint2 = new int[] { 0, 0, 0 };
        byte b0 = 0;
        byte b1;

        for (b1 = 0; b0 < 3; ++b0){
            aint2[b0] = par2ArrayOfInteger[b0] - par1ArrayOfInteger[b0];

            if (Math.abs(aint2[b0]) > Math.abs(aint2[b1])){
                b1 = b0;
            }
        }

        if (aint2[b1] != 0){
            byte b2 = otherCoordPairs[b1];
            byte b3 = otherCoordPairs[b1 + 3];
            byte b4;

            if (aint2[b1] > 0){
                b4 = 1;
            }else{
                b4 = -1;
            }

            double d0 = (double) aint2[b2] / (double) aint2[b1];
            double d1 = (double) aint2[b3] / (double) aint2[b1];
            int[] aint3 = new int[] { 0, 0, 0 };
            int j = 0;

            for (int k = aint2[b1] + b4; j != k; j += b4){
                aint3[b1] = MathHelper.floor_double(par1ArrayOfInteger[b1] + j + 0.5D);
                aint3[b2] = MathHelper.floor_double(par1ArrayOfInteger[b2] + (j * d0) + 0.5D);
                aint3[b3] = MathHelper.floor_double(par1ArrayOfInteger[b3] + (j * d1) + 0.5D);
                byte b5 = 0;
                int l = Math.abs(aint3[0] - par1ArrayOfInteger[0]);
                int i1 = Math.abs(aint3[2] - par1ArrayOfInteger[2]);
                int j1 = Math.max(l, i1);

                if (j1 > 0){
                    if (l == j1){
                        b5 = 4;
                    }else if (i1 == j1){
                        b5 = 8;
                    }
                }

                this.setBlockAndMetadata(worldObj, aint3[0], aint3[1], aint3[2], par3, b5);
            }
        }
    }

    /**
     * Generates the leaf portion of the tree as specified by the leafNodes
     * list.
     */
    void generateLeaves() {
        int i = 0;

        for (int j = leafNodes.length; i < j; ++i){
            int k = leafNodes[i][0];
            int l = leafNodes[i][1];
            int i1 = leafNodes[i][2];
            this.generateLeafNode(k, l, i1);
        }
    }

    /**
     * Indicates whether or not a leaf node requires additional wood to be added
     * to preserve integrity.
     */
    boolean leafNodeNeedsBase(int par1) {
        return par1 >= (heightLimit * 0.2D);
    }

    /**
     * Places the trunk for the big tree that is being generated. Able to
     * generate double-sized trunks by changing a field that is always 1 to 2.
     */
    void generateTrunk() {
        int i = basePos[0];
        int j = basePos[1];
        int k = basePos[1] + height;
        int l = basePos[2];
        int[] aint = new int[] { i, j, l };
        int[] aint1 = new int[] { i, k, l };
        this.placeBlockLine(aint, aint1, Block.wood.blockID);

        if (trunkSize == 2){
            ++aint[0];
            ++aint1[0];
            this.placeBlockLine(aint, aint1, Block.wood.blockID);
            ++aint[2];
            ++aint1[2];
            this.placeBlockLine(aint, aint1, Block.wood.blockID);
            aint[0] += -1;
            aint1[0] += -1;
            this.placeBlockLine(aint, aint1, Block.wood.blockID);
        }
    }

    /**
     * Generates additional wood blocks to fill out the bases of different leaf
     * nodes that would otherwise degrade.
     */
    void generateLeafNodeBases() {
        int i = 0;
        int j = leafNodes.length;

        for (int[] aint = new int[] { basePos[0], basePos[1], basePos[2] }; i < j; ++i){
            int[] aint1 = leafNodes[i];
            int[] aint2 = new int[] { aint1[0], aint1[1], aint1[2] };
            aint[1] = aint1[3];
            int k = aint[1] - basePos[1];

            if (this.leafNodeNeedsBase(k)){
                this.placeBlockLine(aint, aint2, (byte) Block.wood.blockID);
            }
        }
    }

    /**
     * Checks a line of blocks in the world from the first coordinate to triplet
     * to the second, returning the distance (in blocks) before a non-air,
     * non-leaf block is encountered and/or the end is encountered.
     */
    int checkBlockLine(int[] par1ArrayOfInteger, int[] par2ArrayOfInteger) {
        int[] aint2 = new int[] { 0, 0, 0 };
        byte b0 = 0;
        byte b1;

        for (b1 = 0; b0 < 3; ++b0){
            aint2[b0] = par2ArrayOfInteger[b0] - par1ArrayOfInteger[b0];

            if (Math.abs(aint2[b0]) > Math.abs(aint2[b1])){
                b1 = b0;
            }
        }

        if (aint2[b1] == 0){
            return -1;
        }else{
            byte b2 = otherCoordPairs[b1];
            byte b3 = otherCoordPairs[b1 + 3];
            byte b4;

            if (aint2[b1] > 0){
                b4 = 1;
            }else{
                b4 = -1;
            }

            double d0 = (double) aint2[b2] / (double) aint2[b1];
            double d1 = (double) aint2[b3] / (double) aint2[b1];
            int[] aint3 = new int[] { 0, 0, 0 };
            int i = 0;
            int j;

            for (j = aint2[b1] + b4; i != j; i += b4){
                aint3[b1] = par1ArrayOfInteger[b1] + i;
                aint3[b2] = MathHelper.floor_double(par1ArrayOfInteger[b2] + (i * d0));
                aint3[b3] = MathHelper.floor_double(par1ArrayOfInteger[b3] + (i * d1));
                int k = worldObj.getBlockId(aint3[0], aint3[1], aint3[2]);

                if ((k != 0) && (k != Block.leaves.blockID)){
                    break;
                }
            }

            return i == j ? -1 : Math.abs(i);
        }
    }

    /**
     * Returns a boolean indicating whether or not the current location for the
     * tree, spanning basePos to to the height limit, is valid.
     */
    boolean validTreeLocation() {
        int[] aint = new int[] { basePos[0], basePos[1], basePos[2] };
        int[] aint1 = new int[] { basePos[0], (basePos[1] + heightLimit) - 1, basePos[2] };
        int i = worldObj.getBlockId(basePos[0], basePos[1] - 1, basePos[2]);

        Block soil = Block.blocksList[i];
        @SuppressWarnings("unused")
        boolean isValidSoil = true || ((soil != null) && soil.canSustainPlant(worldObj, basePos[0],
                basePos[1] - 1, basePos[2], ForgeDirection.UP, (BlockSapling) Block.sapling));
        if (!isValidSoil){
            return false;
        }else{
            int j = this.checkBlockLine(aint, aint1);

            if (j == -1){
                return true;
            }else if (j < 6){
                return false;
            }else{
                heightLimit = j;
                return true;
            }
        }
    }

    /**
     * Rescales the generator settings, only used in WorldGenBigTree
     */
    @Override
    public void setScale(double par1, double par3, double par5) {
        heightLimitLimit = (int) (par1 * 12.0D);

        if (par1 > 0.5D){
            leafDistanceLimit = 5;
        }

        scaleWidth = par3;
        leafDensity = par5;
    }

    @Override
    public boolean generate(World par1World, Random par2Random, int par3, int par4, int par5) {
        worldObj = par1World;
        long l = par2Random.nextLong();
        rand.setSeed(l);
        basePos[0] = par3;
        basePos[1] = par4;
        basePos[2] = par5;

        if (heightLimit == 0){
            heightLimit = 5 + rand.nextInt(heightLimitLimit);
        }

        if (!this.validTreeLocation()){
            return false;
        }else{
            this.generateLeafNodeList();
            this.generateLeaves();
            this.generateTrunk();
            this.generateLeafNodeBases();
            return true;
        }
    }
}
