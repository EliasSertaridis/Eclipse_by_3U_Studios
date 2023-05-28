import java.util.*;

public class Inventory {

    private static final int inventorySize = 100000;
    private List<Item> items = new ArrayList<Item>();
    private Map<Item, Integer> itemStock = new HashMap<Item, Integer>();

    public Inventory() {
    }

    public List<Item> getItems() {
        return items;
    }

    public Item getItemByName(String name) {
        Item item = null;
        for (Item item1 : items) {
            if (name.equals(item1.getName())) {
                item = item1;
            }
        }
        return item;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public void addItemToInventory(Item item) {
        if (checkSpace()) {
            items.add(item);
            itemStock.put(item, itemStock.getOrDefault(item, 0) + 1);
        } else {
            System.out.println("The inventory is FULL. Do you want to go to the inventory?");
            Scanner scanner = new Scanner(System.in);
            String input;
            boolean madeChoice = false;
            while (!madeChoice) {
                input = scanner.nextLine();
                if (input.equals("Yes")) {
                    madeChoice = true;
                    openInventory();
                } else if (input.equals("No")) {
                    madeChoice = true;
                } else
                    System.out.println("What you typed is not an option. The options you have here are: /n Yes /n No");
            }
        }
    }

    public void removeItemFromInventory(Item item) {
        if (items.remove(item)) {
            Integer stock = itemStock.get(item);
            if (stock != null && stock > 1) {
                itemStock.put(item, stock - 1);
            } else {
                itemStock.remove(item);
            }
            System.out.println("Item removed: " + item.getName());
        } else {
            System.out.println("Item not found: " + item.getName());
        }
    }

    public List<QuickItem> getAllQuickItems() {
        List<QuickItem> quickItems = new ArrayList<QuickItem>();
        for (Item item : items) {
            if (item instanceof QuickItem) {
                quickItems.add((QuickItem) item);
            }
        }
        return quickItems;
    }

    public List<Equipment> getAllEquipment() {
        List<Equipment> equipment = new ArrayList<Equipment>();
        for (Item item : items) {
            if (item instanceof Equipment) {
                equipment.add((Equipment) item);
            }
        }
        return equipment;
    }

    public List<Armor> getAllEquipmentOfType(Armor.TypeOfArmor armor) {
        List<Armor> armorType = new ArrayList<Armor>();
        for (Equipment equipment : getAllEquipment()) {
            if (equipment instanceof Armor) {
                if (((Armor) equipment).getArmorType() == armor) {
                    armorType.add((Armor) equipment);
                }
            }
        }
        return armorType;
    }

    public List<Weapon> getAllEquipmentOfType() {
        List<Weapon> weapon = new ArrayList<Weapon>();
        for (Equipment equipment : getAllEquipment()) {
            if (equipment instanceof Weapon) {
                weapon.add((Weapon) equipment);
            }
        }
        return weapon;
    }

    public boolean checkSpace() {
        if (items.size() + 1 > inventorySize) {
            return false;
        } else {
            return true;
        }
    }

    public void openInventory() {
        showInventory();
        chooseItem();

    }


    public void showInventory() {
        System.out.println("Items in the Inventory:");
        for (Item item : itemStock.keySet()) {
            int stock = itemStock.get(item);
            System.out.println("- " + item.getName() + ", Description: " + item.getDescription() + ", Stock: " + stock);
        }
    }

    public void chooseItem() {
        System.out.println("Type the name of the Item that you want to choose: ");
        Scanner scanner = new Scanner(System.in);
        String input;
        input = scanner.nextLine();
        Item item = getItemByName(input);
        if (input.equals("Exit")) {
        } else {
            System.out.println("Item Name: " + item.getName() + "/n Item Description: " + item.getDescription());
            System.out.println("You want to Use or Discard this Item?");
            input = scanner.nextLine();
            if (input.equals("Use")) {
                optUse(item);
            }else if (input.equals("Discard")) {
                optDiscard(item);
            } else if (input.equals("Exit")) {

            }
        }
    }
    public void optUse(Item item){
        if(item.use()){
            removeItemFromInventory(item);
        }else{

        }
    }
    public void optDiscard(Item item){
        if(item.discard()) {
            removeItemFromInventory(item);
        }else{

        }
    }
}



