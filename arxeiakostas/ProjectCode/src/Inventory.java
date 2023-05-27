import java.util.ArrayList;
import java.util.List;

public class Inventory {
    List<Item> items= new ArrayList<Item>();

    public Inventory() {
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
    public void addItemToInventory(Item item){
        items.add(item);
    }
    public void removeItemFromInventory(Item item){
        items.remove(item);
    }
    public List<QuickItem> getAllQuickItems(){
        List<QuickItem> quickItems=new ArrayList<QuickItem>();
        for(Item item:items){
            if(item instanceof QuickItem){
                quickItems.add((QuickItem) item);
            }
        }
        return quickItems;
    }
    public List<Equipment> getAllEquipment(){
        List<Equipment> equipment =new ArrayList<Equipment>();
        for(Item item:items){
            if(item instanceof Equipment){
                equipment.add((Equipment) item);
            }
        }
        return equipment;
    }
    public List<Armor> getAllEquipmentOfType(Armor.TypeOfArmor armor){
        List<Armor> armorType = new ArrayList<Armor>();
        for(Equipment equipment: getAllEquipment()){
            if(equipment instanceof Armor){
                if(((Armor) equipment).getArmorType()==armor){
                    armorType.add((Armor) equipment);
                }
            }
        }
        return armorType;
    }
    public List<Weapon> getAllEquipmentOfType(){
        List<Weapon> weapon = new ArrayList<Weapon>();
        for(Equipment equipment: getAllEquipment()){
            if(equipment instanceof Weapon){
                    weapon.add((Weapon) equipment);
            }
        }
        return weapon;
    }
}
