public class Shield extends Weapon{

    int defense;

    public Shield(String name, String description, TypeOfWeapon weaponType, TypeOfDamage damageType, int damage, double scaling, int defense) {
        super(name, description, weaponType, damageType, damage, scaling);
        this.defense = defense;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }
}
