package dreamLand.items;

public class ItemDreamStone extends ItemDreamBlock{

    public ItemDreamStone(int par1) {
        super(par1);
        setMaxDamage(0);
        setHasSubtypes(true);
        MetaNames = new String[]{"dreamCobble","nmCobble","bloodCobble", "dreamStoneBrick"};
    }

}
