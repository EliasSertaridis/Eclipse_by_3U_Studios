public class Blueprint extends Item{

    Construction construction;
    Item resource1,resource2,resource3;
    float xDimension;
    float yDimension;

    public Blueprint(String name, String description, Construction construction, Item resource1, Item resource2, Item resource3, float xDimension, float yDimension) {
        super(name, description);
        this.construction = construction;
        this.resource1 = resource1;
        this.resource2 = resource2;
        this.resource3 = resource3;
        this.xDimension = xDimension;
        this.yDimension = yDimension;
    }

    public Construction getConstruction() {
        return construction;
    }

    public void setConstruction(Construction construction) {
        this.construction = construction;
    }

    public Item getResource1() {
        return resource1;
    }

    public void setResource1(Item resource1) {
        this.resource1 = resource1;
    }

    public Item getResource2() {
        return resource2;
    }

    public void setResource2(Item resource2) {
        this.resource2 = resource2;
    }

    public Item getResource3() {
        return resource3;
    }

    public void setResource3(Item resource3) {
        this.resource3 = resource3;
    }

    public float getxDimension() {
        return xDimension;
    }

    public void setxDimension(float xDimension) {
        this.xDimension = xDimension;
    }

    public float getyDimension() {
        return yDimension;
    }

    public void setyDimension(float yDimension) {
        this.yDimension = yDimension;
    }
}
