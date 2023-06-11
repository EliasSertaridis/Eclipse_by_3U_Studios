import java.util.*;

public class Race {
    enum raceType{
        Human,
        Elf,
        Dwarf,
        Halfling,
        Ork
    }
    private raceType race;
    private List<Ability> HumanAbilities = new ArrayList<>(2);
    private List<Ability> ElfAbilities = new ArrayList<>(2);
    private List<Ability> DwarfAbilities = new ArrayList<>(2);
    private List<Ability> HalflingAbilities = new ArrayList<>(2);
    private List<Ability> OrkAbilities = new ArrayList<>(2);
    private enum sizeType{
        small,
        medium,
        large,
        huge
    }
    private sizeType size;
    private enum resistanceType{
        Fire,
        Ice,
        Arcane,
        Holy,
        Lightning,
        Slashing,
        Piercing,
        Bludgeoning
    }
    private resistanceType resistance;
    private double resistMod;

    public Race(raceType race, sizeType size, resistanceType resistance, double resistMod) {
        this.race = race;
        this.size = size;
        this.resistance = resistance;
        this.resistMod = resistMod;
    }

    public raceType getRace() {
        return race;
    }

    public void setRace(raceType race) {
        this.race = race;
    }

    public sizeType getSize() {
        return size;
    }

    public void setSize(sizeType size) {
        this.size = size;
    }

    public resistanceType getResistance() {
        return resistance;
    }

    public void setResistance(resistanceType resistance) {
        this.resistance = resistance;
    }

    public double getResistMod() {
        return resistMod;
    }

    public void setResistMod(double resistMod) {
        this.resistMod = resistMod;
    }

    public List<Ability> getHumanAbilities() {
        return HumanAbilities;
    }

    public void setHumanAbilities(List<Ability> humanAbilities) {
        HumanAbilities = humanAbilities;
    }

    public List<Ability> getElfAbilities() {
        return ElfAbilities;
    }

    public void setElfAbilities(List<Ability> elfAbilities) {
        ElfAbilities = elfAbilities;
    }

    public List<Ability> getDwarfAbilities() {
        return DwarfAbilities;
    }

    public void setDwarfAbilities(List<Ability> dwarfAbilities) {
        DwarfAbilities = dwarfAbilities;
    }

    public List<Ability> getHalflingAbilities() {
        return HalflingAbilities;
    }

    public void setHalflingAbilities(List<Ability> halflingAbilities) {
        HalflingAbilities = halflingAbilities;
    }

    public List<Ability> getOrkAbilities() {
        return OrkAbilities;
    }

    public void setOrkAbilities(List<Ability> orkAbilities) {
        OrkAbilities = orkAbilities;
    }

    public Map<String, Integer> getReputationWithMerchantRaces(){
        Map<String,Integer> repWithMerch = new HashMap<>();
        repWithMerch.put(raceType.Human.toString(), 1);
        repWithMerch.put(raceType.Ork.toString(),1);
        repWithMerch.put(raceType.Elf.toString(),1);
        repWithMerch.put(raceType.Dwarf.toString(),1);
        repWithMerch.put(raceType.Halfling.toString(),1);

        return repWithMerch;
    }

    public LinkedHashMap<raceType,String> getRaces(){
        LinkedHashMap<raceType,String> raceTypes= new LinkedHashMap<>();
        raceTypes.put(raceType.Human , "Jack of all trades");
        raceTypes.put(raceType.Elf, "Nimble, and Elegant");
        raceTypes.put(raceType.Dwarf, "Stiff and Strong");
        raceTypes.put(raceType.Halfling, "Small and Dexterous");
        raceTypes.put(raceType.Ork, "Big and Scary");
        return raceTypes;
    }

    public void setAbility(raceType type, Ability ability){
        switch (type){
            case Human:
                HumanAbilities.add(ability);
                break;
            case Elf:
                ElfAbilities.add(ability);
                break;
            case Dwarf:
                DwarfAbilities.add(ability);
                break;
            case Halfling:
                HalflingAbilities.add(ability);
                break;
            case Ork:
                OrkAbilities.add(ability);
                break;
        }
    }

    public void getAvailableAbilities(raceType race){
        switch (race){
            case Human:
                System.out.println("The available abilities for Human are: ");
                for (int i=0; i<2; i++){
                    System.out.println((i+1) + ". Name: " + HumanAbilities.get(i).getName() + ", Description: " + HumanAbilities.get(i).getDescription() + ", Ability Modifier: " + HumanAbilities.get(i).getAbilityMod() + ", Ability Modifier Type: " + HumanAbilities.get(i).getAbilityModType());
                }
                break;
            case Elf:
                System.out.println("The available abilities for Elf are: ");
                for (int i=0; i<2; i++){
                    System.out.println((i+1) + ". Name: " + ElfAbilities.get(i).getName() + ", Description: " + ElfAbilities.get(i).getDescription() + ", Ability Modifier: " + ElfAbilities.get(i).getAbilityMod() + ", Ability Modifier Type: " + ElfAbilities.get(i).getAbilityModType());
                }
                break;
            case Dwarf:
                System.out.println("The available abilities for Dwarf are: ");
                for (int i=0; i<2; i++){
                    System.out.println((i+1) + ". Name: " + DwarfAbilities.get(i).getName() + ", Description: " + DwarfAbilities.get(i).getDescription() + ", Ability Modifier: " + DwarfAbilities.get(i).getAbilityMod() + ", Ability Modifier Type: " + DwarfAbilities.get(i).getAbilityModType());
                }
                break;
            case Halfling:
                System.out.println("The available abilities for Halfling are: ");
                for (int i=0; i<2; i++){
                    System.out.println((i+1) + ". Name: " + HalflingAbilities.get(i).getName() + ", Description: " + HalflingAbilities.get(i).getDescription() + ", Ability Modifier: " + HalflingAbilities.get(i).getAbilityMod() + ", Ability Modifier Type: " + HalflingAbilities.get(i).getAbilityModType());
                }
                break;
            case Ork:
                System.out.println("The available abilities for Ork are: ");
                for (int i=0; i<2; i++){
                    System.out.println((i+1) + ". Name: " + OrkAbilities.get(i).getName() + ", Description: " + OrkAbilities.get(i).getDescription() + ", Ability Modifier: " + OrkAbilities.get(i).getAbilityMod() + ", Ability Modifier Type: " + OrkAbilities.get(i).getAbilityModType());
                }
                break;
        }
    }
}