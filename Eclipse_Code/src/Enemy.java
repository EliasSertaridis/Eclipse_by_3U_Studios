public class Enemy extends NonPlayableCharacter{

    enum Type{
        Fire,
        Ice,
        Arcane,
        Holy,
        Lightning,
        Slashing,
        Piercing,
        Bludgeoning
    }
    private Type resistance;
    private Type weakness;

    private double resistMod;
    private double weakMod;

    private boolean facedBefore;
    private int level;

    public Enemy(String name, int hp, int strength, int dexterity, int vitality, int intelligence, int wisdom, String dialogue, int reputation, Type resistance, Type weakness, double resistMod, double weakMod, int level) {
        super(name, hp, strength, dexterity, vitality, intelligence, wisdom, dialogue, reputation);
        this.resistance = resistance;
        this.weakness = weakness;
        this.resistMod = resistMod;
        this.weakMod = weakMod;
        this.facedBefore = false;
        this.level = level;
    }

    public Type getResistance() {
        return resistance;
    }

    public void setResistance(Type resistance) {
        this.resistance = resistance;
    }

    public Type getWeakness() {
        return weakness;
    }

    public void setWeakness(Type weakness) {
        this.weakness = weakness;
    }

    public double getResistMod() {
        return resistMod;
    }

    public void setResistMod(double resistMod) {
        this.resistMod = resistMod;
    }

    public double getWeakMod() {
        return weakMod;
    }

    public void setWeakMod(double weakMod) {
        this.weakMod = weakMod;
    }

    public boolean isFacedBefore() {
        return facedBefore;
    }

    public void setFacedBefore(boolean facedBefore) {
        this.facedBefore = facedBefore;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
