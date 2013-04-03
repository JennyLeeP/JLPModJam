package dreamLand;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class DreamLandItems extends Item {

    public DreamLandItems(int par1) {
        super(par1);
        this.setCreativeTab(DreamLand.tabDreamLand);
    }

    @Override
    public void updateIcons(IconRegister par1IconRegister) {
        iconIndex = par1IconRegister.registerIcon(DreamLand.modid + ":Lucidity");
    }
}