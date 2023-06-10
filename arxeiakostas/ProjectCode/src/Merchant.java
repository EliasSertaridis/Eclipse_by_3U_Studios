import java.util.List;
import java.util.Map;

public class Merchant extends NonPlayableCharacter{

    private enum MerchantType{
        Blacksmith,
        Shopkeeper
    }
    private MerchantType merchantType;
    private enum RaceType{
        Human,
        Elf,
        Dwarf,
        Halfling,
        Ork
    }
    private RaceType race;
    private List<Item> merchantInventory;
    private Map<Item, Float> prices;


    //constructor for merchant
    public Merchant(String name, int hp, int strength, int dexterity, int vitality, int intelligence, int wisdom, String dialogue, int reputation, MerchantType merchantType, RaceType race) {
        super(name, hp, strength, dexterity, vitality, intelligence, wisdom, dialogue);
        this.merchantType = merchantType;
        this.race = race;
    }


    //setters, getters
    public MerchantType getMerchantType() {
        return merchantType;
    }

    public void setMerchantType(MerchantType merchantType) {
        this.merchantType = merchantType;
    }

    public RaceType getRace() {
        return race;
    }

    public void setRace(RaceType race) {
        this.race = race;
    }

    public List getMerchantInventory() {
        return merchantInventory;
    }

    public void setMerchantInventory(List merchantInventory) {
        this.merchantInventory = merchantInventory;
    }

    public Map<Item, Float> getPrices(){
        return prices;
    }

    public void setPrices(Map prices){this.prices = prices;}

    //methods for merchant class

    // method that checks whether this playable character deserves a discount based on his reputation with
    // the race of this specific merchant
    public boolean checkForDiscount(PlayableCharacter character, Merchant merchant){
        if(character.getReputationWithTypeOfMerchant(merchant) < 5){
            return false;
        }
        else{
            return true;
        }
    }

}
