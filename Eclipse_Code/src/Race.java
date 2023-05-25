public class Race {
    private String name;
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

    public Race(String name, sizeType size, resistanceType resistance, double resistMod) {
        this.name = name;
        this.size = size;
        this.resistance = resistance;
        this.resistMod = resistMod;
    }

}
