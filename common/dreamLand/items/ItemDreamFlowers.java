package dreamLand.items;

public class ItemDreamFlowers extends ItemDreamBlock{

    public ItemDreamFlowers(int par1) {
        super(par1);
        setMaxDamage(0);
        setHasSubtypes(true);
        MetaNames = new String[]{"whiteFlower","orangeFlower","magentaFlower","lightBlueFlower","yellowFlower", "limeFlower", "pinkFlower","grayFlower"
                , "lightGrayFlower", "cyanFlower", "purpleFlower", "blueFlower", "brownFlower", "greenFlower", "redFlower", "blackFlower"};
    }

}
