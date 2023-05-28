public class HealthPotion extends QuickItem{


    private int regenPoints;

    public HealthPotion(String name, String description, int regenPoints) {
        super(name, description);
        this.regenPoints = regenPoints;
    }

    public int getRegenPoints() {
        return regenPoints;
    }

    public void setRegenPoints(int regenPoints) {
        this.regenPoints = regenPoints;
    }
}
