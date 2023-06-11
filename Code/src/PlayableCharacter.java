import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlayableCharacter extends Character{
    private int money;
    private int level;
    private double equipLoad;
    private int defenceModifier;
    private CurrentEquipment currentEquipment;
    private PlayerStatus playerStatus;
    private Race race;
    public PlayableCharacter(String name, int hp, int strength, int dexterity, int vitality, int intelligence, int wisdom, int money, int level, double equipLoad) {
        super(name, hp, strength, dexterity, vitality, intelligence, wisdom);
        this.money = money;
        this.level = level;
        this.equipLoad = equipLoad;
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

    public int getDefenceModifier() {
        return defenceModifier;
    }

    public void setDefenceModifier(int defenceModifier) {
        this.defenceModifier = defenceModifier;
    }

    public CurrentEquipment getCurrentEquipment() {
        return currentEquipment;
    }

    public void setCurrentEquipment(CurrentEquipment currentEquipment) {
        this.currentEquipment = currentEquipment;
    }

    public PlayerStatus getPlayerStatus() {
        return playerStatus;
    }

    public void setPlayerStatus(PlayerStatus playerStatus) {
        this.playerStatus = playerStatus;
    }

    public Map<String, Integer> getPlayerStats(){
        Map<String, Integer> playerStats = new HashMap<>();
        playerStats.put(getName(),getHp());
        return playerStats;
    }

    //function that takes the race of a merchant and returns the reputation of the character with that merchant
    public int getReputationWithTypeOfMerchant(Merchant merchant){
        String raceofmerch = String.valueOf(merchant.getRace());
        //loop for accessing the map with the reputation of the character with the different races of merchants
        //and when it finds the one we want it returns it
        for(Map.Entry<String, Integer> entry : race.getReputationWithMerchantRaces().entrySet()){
            // if the key value of the map is the same with the race of the merchant,return the reputation with that
            //race, else return 0
            if(raceofmerch == entry.getKey()){
                return entry.getValue();
            }
        }
        return 0;
    }

    public void setDefenceMod(){
        this.defenceModifier = currentEquipment.getTotalDefense();
    }
}