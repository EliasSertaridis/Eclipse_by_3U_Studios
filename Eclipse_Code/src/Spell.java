public class Spell extends Item{

    TypeOfDamage damageType;
    enum TypeOfDamage{
        Fire,
        Ice,
        Arcane,
        Holy,
        Lightning
    }
    private float scaling;
    private int damage;
    PrerequisiteStat statPrerequisiteName;
    enum PrerequisiteStat {
        INT,
        WIS
    }
    private int statPrerequisite;

    PlayerStatus playerStatus;

    public Spell(String name, String description, Item.rarityType rarity, float scaling,int damage,TypeOfDamage damageType,PrerequisiteStat statPrerequisiteName,int statPrerequisite) {
        super(name, description, rarity);
        this.damage=damage;
        this.scaling=scaling;
        this.damageType=damageType;
        this.statPrerequisite=statPrerequisite;
        this.statPrerequisiteName=statPrerequisiteName;
    }

    public TypeOfDamage getDamageType() {
        return damageType;
    }

    public void setDamageType(TypeOfDamage damageType) {
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

    public int totalSpellDamage(Spell spell) {
        double totalDamage;
        double scalingDamage = 0;
        if (spell.getStatPrerequisiteName() == PrerequisiteStat.INT) {
            scalingDamage = (spell.getScaling() + 1) * (playerStatus.player.getIntelligence());
        } else if (spell.getStatPrerequisiteName() == PrerequisiteStat.WIS) {
            scalingDamage = (spell.getScaling() + 1) * (playerStatus.player.getWisdom());
        }
        totalDamage = spell.getDamage() + scalingDamage;
        return (int) totalDamage;
    }
}

