public class BuffPotion extends QuickItem{

    private int statModifier;
    StatForModifing statToBeModified;
    enum StatForModifing{
        STR,
        DEX,
        VIT,
        INT,
        WIS,
        Defence
    }


    public BuffPotion(String name, String description, rarityType rarity, int statModifier, StatForModifing statToBeModified) {
        super(name, description, rarity);
        this.statModifier = statModifier;
        this.statToBeModified = statToBeModified;
    }

    public int getStatModifier() {
        return statModifier;
    }

    public void setStatModifier(int statModifier) {
        this.statModifier = statModifier;
    }

    public StatForModifing getStatToBeModified() {
        return statToBeModified;
    }

    public void setStatToBeModified(StatForModifing  statToBeModified) {
        this.statToBeModified = statToBeModified;
    }

    @Override
    public boolean use() {
        System.out.println("You just used the item "+getName());
        return true;
    }
}
