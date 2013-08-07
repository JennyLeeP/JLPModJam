package dreamLand.items;

public class ItemBlockDreamWall extends ItemDreamBlock{

	public ItemBlockDreamWall(int par1) {
		super(par1);
		this.setMaxDamage(0);
        this.setHasSubtypes(true);
        MetaNames = new String[]{"dreamCobble", "dreamStoneBrick", "dreamStoneMossBrick", "dreamStoneCrackedBrick","nmCobble", "nmBrick", "nmCrackedBrick", "bloodCobble", "bloodBrick","marble", "granite"};
	}
}
