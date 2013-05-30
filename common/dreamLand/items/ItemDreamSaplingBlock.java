package dreamLand.items;

public class ItemDreamSaplingBlock extends ItemDreamBlock {

    public ItemDreamSaplingBlock(int i)
    {
        super(i);
        setMaxDamage(0);
        setHasSubtypes(true);
        MetaNames = new String[]{"sparkling", "ash", "brilliant","dark", "frigid", "infernal", "life", "death"};
    }

}
