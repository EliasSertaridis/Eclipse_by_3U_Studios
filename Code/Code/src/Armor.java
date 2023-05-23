public class Armor extends Equipment{

    String[] armorType={"Head","Chest","Hands","Legs"};
    int defense;

    public Armor(String name, String description, int weight,String[] armorType,int defense) {
        super(name, description, weight);
        this.armorType=armorType;
        this.defense=defense;
    }

    public String[] getArmorType() {
        return armorType;
    }

    public void setArmorType(String[] armorType) {
        this.armorType = armorType;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }
}
