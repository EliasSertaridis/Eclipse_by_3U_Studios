public class HealthPotion extends QuickItem{


    private int regenPoints;
    public HealthPotion(String name, String description, Item.rarityType rarity, int regenPoints) {
        super(name, description, rarity);
        this.regenPoints=regenPoints;
    }

    public int getRegenPoints() {
        return regenPoints;
    }

    public void setRegenPoints(int regenPoints) {
        this.regenPoints = regenPoints;
    }
}
