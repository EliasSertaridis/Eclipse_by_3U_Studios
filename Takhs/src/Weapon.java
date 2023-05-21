import java.util.Arrays;

public class Weapon extends Item {

    int damage;
    float scaling;
    String[] damageType={"Slashing","Piercing","Bludgeoning"};
    String[] weaponType={"Sword","Spear","Axe","Hammer"};


    public Weapon(String name, String description,String[] weaponType, String[] damageType, int damage, float scaling) {
        super(name, description);
        this.damage= damage;
        this.scaling= scaling;
        this.damageType= damageType;
        this.weaponType= weaponType;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public float getScaling() {
        return scaling;
    }

    public void setScaling(float scaling) {
        this.scaling = scaling;
    }

    public String[] getDamageType() {
        return damageType;
    }

    public void setDamageType(String[] damageType) {
        this.damageType = damageType;
    }

    public String[] getWeaponType() {
        return weaponType;
    }

    public void setWeaponType(String[] weaponType) {
        this.weaponType = weaponType;
    }
}
