package dreamLand.items;

public class ItemDreamStone extends ItemDreamBlock{

    public ItemDreamStone(int par1) {
        super(par1);
        setMaxDamage(0);
        setHasSubtypes(true);
        MetaNames = new String[]{"bloodCobble", "bloodBrick", "dreamStoneBrick", "dreamStoneMossBrick", "dreamStoneCrackedBrick", "dreamStoneChiseledBrick","nmBrick","nmCrackedBrick","nmChiseledBrick", "marble", "granite", "cursedStone"};
    }
}
