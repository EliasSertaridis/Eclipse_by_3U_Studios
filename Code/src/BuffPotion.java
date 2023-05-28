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


    public BuffPotion(String name, String description, int statModifier, StatForModifing statToBeModified) {
        super(name, description);
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
}
