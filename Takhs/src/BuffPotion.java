public class BuffPotion extends QuickItem{

    int statModifier;
    String[] statToBeModified={"STR","DEX","VIT","INT","WIS","Defence"};

    public BuffPotion(String name, String description,int statModifier,String[] statToBeModified) {
        super(name, description);
        this.statModifier=statModifier;
        this.statToBeModified=statToBeModified;
    }

    public int getStatModifier() {
        return statModifier;
    }

    public void setStatModifier(int statModifier) {
        this.statModifier = statModifier;
    }

    public String[] getStatToBeModified() {
        return statToBeModified;
    }

    public void setStatToBeModified(String[] statToBeModified) {
        this.statToBeModified = statToBeModified;
    }
}
