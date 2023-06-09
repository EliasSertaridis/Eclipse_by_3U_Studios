import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Race {
    enum raceType{
        Human,
        Elf,
        Dwarf,
        Halfling,
        Ork
    }
    private raceType race;
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

    public Map<String, Integer> getReputationWithMerchantRaces(){
        Map<String,Integer> repWithMerch = new HashMap<>();
        repWithMerch.put(raceType.Human.toString(), 1);
        repWithMerch.put(raceType.Ork.toString(),1);
        repWithMerch.put(raceType.Elf.toString(),1);
        repWithMerch.put(raceType.Dwarf.toString(),1);
        repWithMerch.put(raceType.Halfling.toString(),1);

        return repWithMerch;
    }

    public LinkedHashMap<raceType,String> getRaceTypes(){
        LinkedHashMap<raceType,String> raceTypes= new LinkedHashMap<>();
        raceTypes.put(raceType.Human , "Jack of all trades");
        raceTypes.put(raceType.Elf, "Nimble, and Elegant");
        raceTypes.put(raceType.Dwarf, "Stiff and Strong");
        raceTypes.put(raceType.Halfling, "Small and Dexterous");
        raceTypes.put(raceType.Ork, "Big and Scary");
        return raceTypes;
    }
}