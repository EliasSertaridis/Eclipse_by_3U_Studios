import java.util.ArrayList;
import java.util.HashMap;
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
    private List<Item> inventory;

    public Merchant(String name, int hp, int strength, int dexterity, int vitality, int intelligence, int wisdom, String dialogue, int reputation, MerchantType merchantType, RaceType race, List<Item> inventory) {
        super(name, hp, strength, dexterity, vitality, intelligence, wisdom, dialogue, reputation);
        this.merchantType = merchantType;
        this.race = race;
        this.inventory = inventory;
    }

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

    public List<Item> getInventory() {
        return inventory;
    }

    public void setInventory(List<Item> inventory) {
        this.inventory = inventory;
    }

    public void getReputationWithCharacter(){
        
    }
}
