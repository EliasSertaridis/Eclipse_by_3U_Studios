import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlayableCharacter extends Character{
    private int money;
    private int level;
    private double equipLoad;
    private double defenceModifier;

    public PlayableCharacter(String name, int hp, int strength, int dexterity, int vitality, int intelligence, int wisdom, int money, int level, double equipLoad, double defenceModifier) {
        super(name, hp, strength, dexterity, vitality, intelligence, wisdom);
        this.money = money;
        this.level = level;
        this.equipLoad = equipLoad;
        this.defenceModifier = defenceModifier;
    }

    public PlayableCharacter(){
        super();
    }


    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public double getEquipLoad() {
        return equipLoad;
    }

    public void setEquipLoad(double equipLoad) {
        this.equipLoad = equipLoad;
    }

    public double getDefenceModifier() {
        return defenceModifier;
    }

    public void setDefenceModifier(double defenceModifier) {
        this.defenceModifier = defenceModifier;
    }

    public Map<String, Integer> getPlayerStats(){
        Map<String, Integer> playerStats = new HashMap<>();
        playerStats.put(getName(),getHp());
        return playerStats;
    }
    public Map<String, Integer> getReputationWithMerchantRaces(){
        Map<String,Integer> repWithMerch = new HashMap<>();
        repWithMerch.put(Race.raceType.Human.toString(), 1);
        repWithMerch.put(Race.raceType.Ork.toString(),1);
        repWithMerch.put(Race.raceType.Elf.toString(),1);
        repWithMerch.put(Race.raceType.Dwarf.toString(),1);
        repWithMerch.put(Race.raceType.Halfling.toString(),1);

        return repWithMerch;
    }

}