package dreamLand;

import net.minecraft.util.ChunkCoordinates;

public class DreamLandPortalPosition extends ChunkCoordinates {
    // Thank you Rebelkeithy
    public long field_85087_d;

    final DreamLandTeleporter field_85088_e;

    public DreamLandPortalPosition(DreamLandTeleporter par1Teleporter, int par2, int par3,
            int par4, long par5) {
        super();// (par2, par3, par4)
        field_85088_e = par1Teleporter;
        field_85087_d = par5;
    }
}
