public class Equipment extends Item{

    private int weight;

    public Equipment(String name, String description, int  weigh) {
        super(name, description);
        this.weight =weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
