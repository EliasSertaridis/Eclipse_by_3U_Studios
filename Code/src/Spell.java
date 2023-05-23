public class Spell extends Item{

    String[] damageType={"Fire","Ice","Arcane","Holy","Lightning"};
    float scaling;
    int damage;
    String[] statPrerequisiteName={"INT","WIS"};
    int statPrerequisite;

    public Spell(String name, String description,float scaling,int damage,String[]damageType,String[] statPrerequisiteName,int statPrerequisite) {
        super(name, description);
        this.damage=damage;
        this.scaling=scaling;
        this.damageType=damageType;
        this.statPrerequisite=statPrerequisite;
        this.statPrerequisiteName=statPrerequisiteName;
    }

    public String[] getDamageType() {
        return damageType;
    }

    public void setDamageType(String[] damageType) {
        this.damageType = damageType;
    }

    public float getScaling() {
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

    public String[] getStatPrerequisiteName() {
        return statPrerequisiteName;
    }

    public void setStatPrerequisiteName(String[] statPrerequisiteName) {
        this.statPrerequisiteName = statPrerequisiteName;
    }

    public int getStatPrerequisite() {
        return statPrerequisite;
    }

    public void setStatPrerequisite(int statPrerequisite) {
        this.statPrerequisite = statPrerequisite;
    }
}

