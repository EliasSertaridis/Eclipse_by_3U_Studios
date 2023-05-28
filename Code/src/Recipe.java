public class Recipe extends Item{

    private Item creation;
    private Item resource1,resource2,resource3;


    public Recipe(String name, String description,Item creation,Item resource1,Item resource2,Item resource3) {
        super(name, description);
        this.creation=creation;
        this.resource1=resource1;
        this.resource2=resource2;
        this.resource3=resource3;
    }

    public Item getCreation() {
        return creation;
    }

    public void setCreation(Item creation) {
        this.creation = creation;
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
}
