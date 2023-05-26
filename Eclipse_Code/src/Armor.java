public class Armor extends Equipment{

    TypeOfArmor armorType;
    enum TypeOfArmor{
        Head,
        Chest,
        Hands,
        Legs
    }
    int defense;

    public Armor(String name, String description, int weight,TypeOfArmor armorType,int defense) {
        super(name, description, weight);
        this.armorType=armorType;
        this.defense=defense;
    }

    public TypeOfArmor getArmorType() {
        return armorType;
    }

    public void setArmorType(TypeOfArmor armorType) {
        this.armorType = armorType;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }
}
