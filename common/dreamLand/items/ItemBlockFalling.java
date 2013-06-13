package dreamLand.items;

public class ItemBlockFalling extends ItemDreamBlock{

    public ItemBlockFalling(int par1) {
        super(par1);
        setMaxDamage(0);
        setHasSubtypes(true);
        MetaNames = new String[]{"dreamSand", "dreamGravel", "nmSand","nmGravel"};
    }

}
