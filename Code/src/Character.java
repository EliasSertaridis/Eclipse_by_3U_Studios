public class Character {
    private String name;
    private int hp;
    private int strength;
    private int dexterity;
    private int vitality;
    private int intelligence;
    private int wisdom;
    private int maxHP;

    public Character(String name, int hp, int strength, int dexterity, int vitality, int intelligence, int wisdom) {
        this.name = name;
        this.hp = hp;
        this.strength = strength;
        this.dexterity = dexterity;
        this.vitality = vitality;
        this.intelligence = intelligence;
        this.wisdom = wisdom;
        this.maxHP = hp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getVitality() {
        return vitality;
    }

    public void setVitality(int vitality) {
        this.vitality = vitality;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getWisdom() {
        return wisdom;
    }

    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
    }
}
