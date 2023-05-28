public class Item {

    private String name;
    private  String description;
    enum rarityType{
        Common,
        Rare,
        Unique,
        Legendary
    }
    protected static Item.rarityType rarity;
    private int minDropRateValue;
    private int maxDropRateValue;
    public Item(String name,String description, rarityType rarity){
        this.name=name;
        this.description=description;
        setDropRate(rarity);
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public rarityType getRarity() {
        return rarity;
    }


    public int getMinDropRateValue() {
        return minDropRateValue;
    }

    public int getMaxDropRateValue() {
        return maxDropRateValue;
    }

    private void setDropRate(rarityType type){
        switch (type){
            case Common:
                this.minDropRateValue=35;
                this.maxDropRateValue=65;
                break;
            case Rare:
                this.minDropRateValue=45;
                this.maxDropRateValue=55;
                break;
            case Unique:
                this.minDropRateValue=57;
                this.maxDropRateValue=52;
                break;
            case Legendary:
                this.minDropRateValue=50;
                this.maxDropRateValue=50;
                break;
        }
    }




    public boolean use(){
        System.out.println("This Item cannot be used.");
        return false;
    }
    public boolean discard(){
        System.out.println("This Item can be discarded.");
        return true;
    }
}
