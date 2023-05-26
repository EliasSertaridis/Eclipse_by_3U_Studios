import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

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
    private Weapon leftHandWeapon;
    private Weapon rightHandWeapon;
    private Spell spell1;
    private Spell spell2;
    private double enemyAttackDamage;

    public Enemy(String name, int hp, int strength, int dexterity, int vitality, int intelligence, int wisdom, String dialogue, int reputation, Type resistance, Type weakness, double resistMod, double weakMod, boolean facedBefore, int level) {
        super(name, hp, strength, dexterity, vitality, intelligence, wisdom, dialogue, reputation);
        this.resistance = resistance;
        this.weakness = weakness;
        this.resistMod = resistMod;
        this.weakMod = weakMod;
        this.facedBefore = facedBefore;
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

    public Weapon getLeftHandWeapon() {
        return leftHandWeapon;
    }

    public void setLeftHandWeapon(Weapon leftHandWeapon) {
        this.leftHandWeapon = leftHandWeapon;
    }

    public Weapon getRightHandWeapon() {
        return rightHandWeapon;
    }

    public void setRightHandWeapon(Weapon rightHandWeapon) {
        this.rightHandWeapon = rightHandWeapon;
    }

    public Map<String, Integer> getEnemyStats(){
        Map<String, Integer> enemyStats = new HashMap<>();
        enemyStats.put(getName(),getHp());
        return enemyStats;
    }

    public Map<Type,Double> getEnemyInfo(boolean facedBefore){
        Map<Type,Double> enemyInfo = new HashMap<Type,Double>();
        if(facedBefore==true){
            enemyInfo.put(getResistance(),getResistMod());
            enemyInfo.put(getWeakness(),getWeakMod());
        }
        return enemyInfo;
    }

    public double getEnemyAttack(){
        Random rand = new Random();
        int rand_int = rand.nextInt(4);
        if(rand_int==0){
            this.enemyAttackDamage = rightHandWeapon.getDamage();
        } else if (rand_int==1) {
            this.enemyAttackDamage = leftHandWeapon.getDamage();
        } else if (rand_int==2) {
            this.enemyAttackDamage = spell1.getDamage();
        } else if (rand_int==3) {
            this.enemyAttackDamage = spell2.getDamage();
        }
        return enemyAttackDamage;
    }
}
