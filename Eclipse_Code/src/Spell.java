public class Spell extends Item{

    TypeOfDamage damageType;
    enum TypeOfDamage{
        Fire,
        Ice,
        Arcane,
        Holy,
        Lightning
    }
    private double scaling;
    private int damage;
    PrerequisiteStat statPrerequisiteName;
    enum PrerequisiteStat {
        INT,
        WIS
    }
    private   int statPrerequisite;

    public Spell(String name, String description, rarityType rarity, TypeOfDamage damageType, double scaling, int damage, PrerequisiteStat statPrerequisiteName, int statPrerequisite) {
        super(name, description, rarity);
        this.damageType = damageType;
        this.scaling = scaling;
        this.damage = damage;
        this.statPrerequisiteName = statPrerequisiteName;
        this.statPrerequisite = statPrerequisite;
    }

    public TypeOfDamage getDamageType() {
        return damageType;
    }

    public void setDamageType(TypeOfDamage damageType) {
        this.damageType = damageType;
    }

    public double getScaling() {
        return scaling;
    }

    public void setScaling(float scaling) {
        this.scaling = scaling;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public PrerequisiteStat getStatPrerequisiteName() {
        return statPrerequisiteName;
    }

    public void setStatPrerequisiteName(PrerequisiteStat statPrerequisiteName) {
        this.statPrerequisiteName = statPrerequisiteName;
    }



    public int getStatPrerequisite() {
        return statPrerequisite;
    }

    public void setStatPrerequisite(int statPrerequisite) {
        this.statPrerequisite = statPrerequisite;
    }

}

