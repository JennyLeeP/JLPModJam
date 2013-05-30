package dreamLand.items;

public class ItemDreamTrees extends ItemDreamBlock{

    public ItemDreamTrees(int i) {
        super(i);
        setMaxDamage(0);
        setHasSubtypes(true);
        MetaNames = new String[]{"sparkling","brilliant","frigid", "life"};
    }

}
