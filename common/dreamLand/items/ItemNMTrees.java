package dreamLand.items;

public class ItemNMTrees extends ItemDreamBlock{
    public ItemNMTrees(int i) {
        super(i);
        setMaxDamage(0);
        setHasSubtypes(true);
        MetaNames = new String[]{"ash","dark","infernal","death"};
    }
}
