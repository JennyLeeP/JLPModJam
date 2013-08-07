package dreamLand.items;

public class ItemDreamOres extends ItemDreamBlock{

    public ItemDreamOres(int par1) {
        super(par1);
        setMaxDamage(0);
        setHasSubtypes(true);
        MetaNames = new String[]{"dlSolum","dlQuartz","dlBlackTourmaline","dlCarnelian","dlGoldenCalcite","dlBlueTopaz","dlRubelite","dlAzurite"
                ,"malumite","nmQuartz","nmBlackTourmaline","nmCarnelian","nmGoldenCalcite","nmBlueTopaz","nmRubelite","nmAzurite"};
    }

}
