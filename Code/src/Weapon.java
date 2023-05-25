import java.util.Arrays;

public class Weapon extends Equipment {

    int damage;
    double scaling;
    TypeOfDamage damageType;

    enum TypeOfDamage {
        Slashing,
        Piercing,
        Bludgeoning
    }

    enum TypeOfWeapon {
        Sword,
        Spear,
        Axe,
        Hammer
    }

    TypeOfWeapon weaponType;


    public Weapon(String name, String description, int weight, int damage, double scaling, TypeOfDamage damageType, TypeOfWeapon weaponType) {
        super(name, description, weight);
        this.damage = damage;
        this.scaling = scaling;
        this.damageType = damageType;
        this.weaponType = weaponType;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public double getScaling() {
        return scaling;
    }

    public void setScaling(double scaling) {
        this.scaling = scaling;
    }

    public TypeOfDamage getDamageType() {
        return damageType;
    }

    public void setDamageType(TypeOfDamage damageType) {
        this.damageType = damageType;
    }

    public TypeOfWeapon getWeaponType() {
        return weaponType;
    }

    public void setWeaponType(TypeOfWeapon weaponType) {
        this.weaponType = weaponType;
    }
}
