package dreamLand.items;

public class ItemDreamWoodBlock extends ItemDreamBlock{
    
    public ItemDreamWoodBlock(int par1) {
        super(par1);
        setMaxDamage(0);
        setHasSubtypes(true);
        MetaNames = new String[]{"sparkling", "ash", "brilliant","dark", "frigid", "infernal", "life", "death"};
    }   
}
