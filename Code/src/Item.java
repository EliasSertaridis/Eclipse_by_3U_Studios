public class Item {

   private String name;
   private  String description;

   private  String takhs;

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
// we love takhs for ever
    public void setDescription(String description) {
        this.description = description;
    }

}
