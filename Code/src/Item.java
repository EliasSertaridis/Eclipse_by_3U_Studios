public class Item {

   private String name;
   private  String description;

    public Item(String name,String description){
        this.name=name;
        this.description=description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public boolean use(){
        System.out.println("This Item cannot be used.");
        return false;
    }
    public boolean discard(){
        System.out.println("This Item can be discarded.");
        return true;
    }
}
