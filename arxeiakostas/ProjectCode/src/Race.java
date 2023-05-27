import java.util.HashMap;
import java.util.Map;

public class Race {
    private enum raceType{
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
    public Map<String, Integer> getReputationWithMerchantRaces(){
        Map<String,Integer> repWithMerch = new HashMap<>();
        repWithMerch.put(raceType.Human.toString(), 1);
        repWithMerch.put(raceType.Ork.toString(),1);
        repWithMerch.put(raceType.Elf.toString(),1);
        repWithMerch.put(raceType.Dwarf.toString(),1);
        repWithMerch.put(raceType.Halfling.toString(),1);

        return repWithMerch;
    }
}
