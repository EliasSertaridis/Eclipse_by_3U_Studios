public class Equipment extends Item{

    int weight;

    public Equipment(String name, String description, int  weight) {
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
