public class Equipment extends Item{

    private int weight;
    public Equipment(String name, String description, Item.rarityType rarity, int  weight) {
        super(name, description, rarity);
        this.weight =weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}