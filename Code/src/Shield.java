public class Shield extends Weapon{

    int defense;

    public Shield(String name, String description, int weight, int damage, double scaling, TypeOfDamage damageType, TypeOfWeapon weaponType, int defense) {
        super(name, description, weight, damage, scaling, damageType, weaponType);
        this.defense = defense;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }
}
