public class Construction {

    String name;
    String description;
    int timeNeeded;
    Item reward;

    public Construction(String name, String description, int timeNeeded, Item reward) {
        this.name = name;
        this.description = description;
        this.timeNeeded = timeNeeded;
        this.reward = reward;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTimeNeeded() {
        return timeNeeded;
    }

    public void setTimeNeeded(int timeNeeded) {
        this.timeNeeded = timeNeeded;
    }

    public Item getReward() {
        return reward;
    }

    public void setReward(Item reward) {
        this.reward = reward;
    }
}
