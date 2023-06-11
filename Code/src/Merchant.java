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
    private String[] inventory;

    public Merchant(String name,String gender ,int hp, int strength, int dexterity, int vitality, int intelligence, int wisdom, String dialogue, int reputation, MerchantType merchantType, RaceType race, String[] inventory) {
        super(name,gender, hp, strength, dexterity, vitality, intelligence, wisdom, dialogue, reputation);
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

    public String[] getInventory() {
        return inventory;
    }

    public void setInventory(String[] inventory) {
        this.inventory = inventory;
    }
    public void getReputationWithCharacter(){

    }
}
