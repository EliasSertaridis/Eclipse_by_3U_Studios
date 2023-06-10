import java.util.HashMap;
import java.util.Map;

public class Race {
    public enum raceType{
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

}