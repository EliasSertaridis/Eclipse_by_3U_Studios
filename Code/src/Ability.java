public class Ability {

    private String name;
    private String description;
    private int abilityMod;
    enum AbilityModType{
        INT,
        DEX,
        STR,
        WIS,
        VIT
    }
    private AbilityModType abilityModType;

    public Ability(String name,String description, int abilityMod, AbilityModType abilityModType) {
        this.name = name;
        this.description = description;
        this.abilityMod = abilityMod;
        this.abilityModType = abilityModType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAbilityMod() {
        return abilityMod;
    }

    public void setAbilityMod(int abilityMod) {
        this.abilityMod = abilityMod;
    }

    public AbilityModType getAbilityModType() {
        return abilityModType;
    }

    public void setAbilityModType(AbilityModType abilityModType) {
        this.abilityModType = abilityModType;
    }
}