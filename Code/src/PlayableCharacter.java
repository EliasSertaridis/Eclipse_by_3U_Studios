import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlayableCharacter extends Character{
    private int money;
    private int level;
    private double equipLoad;
    private double defenceModifier;
    private CurrentEquipment currentEquipment;
    private PlayerStatus playerStatus;
    private Race race;
    public PlayableCharacter(String name, int hp, int strength, int dexterity, int vitality, int intelligence, int wisdom, int money, int level, double equipLoad, double defenceModifier) {
        super(name, hp, strength, dexterity, vitality, intelligence, wisdom);
        this.money = money;
        this.level = level;
        this.equipLoad = equipLoad;
        this.defenceModifier = defenceModifier;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
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
    public void consumes(BuffPotion buffPotion){

        switch(buffPotion.getStatToBeModified()) {
            case INT:
                setIntelligence(getIntelligence()+buffPotion.getStatModifier());
                try {
                    Thread.sleep(120000);  // Sleep for 2 minutes (2 * 60,000 milliseconds)
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                setIntelligence(getIntelligence()-buffPotion.getStatModifier());
                break;
            case STR:
                setStrength(getStrength()+buffPotion.getStatModifier());
                System.out.println("THE STR NOW IS "+getStrength());
                try {
                    Thread.sleep(120000);  // Sleep for 2 minutes (2 * 60,000 milliseconds)
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                setStrength(getStrength()-buffPotion.getStatModifier());
                System.out.println("THE STR IS BACK AT"+getStrength());
                break;
            case DEX:
                setDexterity(getDexterity()+buffPotion.getStatModifier());
                try {
                    Thread.sleep(120000);  // Sleep for 2 minutes (2 * 60,000 milliseconds)
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                setDexterity(getDexterity()-buffPotion.getStatModifier());
                break;
            case WIS:
                setWisdom(getWisdom()+buffPotion.getStatModifier());
                try {
                    Thread.sleep(120000);  // Sleep for 2 minutes (2 * 60,000 milliseconds)
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                setDexterity(getDexterity()-buffPotion.getStatModifier());
                break;
            case VIT:
                setVitality(getVitality()+buffPotion.getStatModifier());
                try {
                    Thread.sleep(120000);  // Sleep for 2 minutes (2 * 60,000 milliseconds)
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }setVitality(getVitality()-buffPotion.getStatModifier());
                break;

        }
    }
    public void consumes(HealthPotion healthPotion){
        if(getHp()+ healthPotion.getRegenPoints()>=getMaxHP()){
            setHp(getMaxHP());
        }else setHp(getHp()+healthPotion.getRegenPoints());
    }

}