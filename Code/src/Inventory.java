import java.sql.SQLOutput;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Inventory {

    private static final int inventorySize = 100000;
    private List<Item> items = new ArrayList<Item>();
    private Map<Item, Integer> itemStock = new HashMap<Item, Integer>();

    private PlayableCharacter player;

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


    public PlayableCharacter getPlayer() {
        return player;
    }

    public void setPlayer(PlayableCharacter player) {
        this.player = player;
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
        choose();
    }


    public void showInventory() {
        System.out.println("Items in the Inventory:");
        for (Item item : itemStock.keySet()) {
            int stock = itemStock.get(item);
            System.out.println("- " + item.getName() + ", Description: " + item.getDescription() + ", Stock: " + stock);
        }
    }
    public void optCrafting() {
        Scanner scanner= new Scanner(System.in);
      //  List<Recipe> recipes= new ArrayList<Recipe>();
        String input;
        for (Item item : itemStock.keySet()) {
            int flag = 0;
            boolean checked1 = true;
            boolean checked2 = true;
            boolean checked3 = true;
            if (item instanceof Recipe) {
                for (Item resources : itemStock.keySet()) {
                    int stock = itemStock.get(resources);
                    if (((Recipe) item).getResource1() == resources && stock >= 1 && checked1) {
                        checked1 = false;
                        flag++;
                        stock--;
                    }
                    if (((Recipe) item).getResource2() == resources && stock >= 1 && checked2) {
                        checked2 = false;
                        flag++;
                        stock--;
                    }
                    if (((Recipe) item).getResource3() == resources && stock >= 1 && checked3) {
                        checked3 = false;
                        flag++;
                        //stock--;
                    }
                }
                if (flag == 3) {
                    System.out.println("- " + item.getName() + " is craftable and it gives you the " + ((Recipe) item).getCreation().getName() + " Item.");
                   // recipes.add((Recipe) item);
                } else System.out.println("- " + item.getName() + " is not craftable.");
            }
        }
        System.out.println("Type the name of the Recipe you want to use or type Exit to go back");
        input = scanner.nextLine();
        Item item = getItemByName(input);
        optUse(item);
    }
    public void choose(){
        System.out.println("Type the name of the Item that you want to choose or type Crafting to only see the crafting recipes: ");
        Scanner scanner = new Scanner(System.in);
        String input;
        input = scanner.nextLine();
        if(input.equals("Crafting")){
            optCrafting();
        }else chooseItem(input);
    }
    public void chooseItem(String input) {
        Scanner scanner = new Scanner(System.in);
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
        int flag=0;
        boolean checked1=true;
        boolean checked2=true;
        boolean checked3=true;
        if(item.use()){
            if(item instanceof Recipe){
                for (Item resources : itemStock.keySet()) {
                    int stock = itemStock.get(resources);
                    if(((Recipe) item).getResource1()==resources && stock>=1 && checked1){
                        checked1=false;
                       flag++;
                       stock--;
                    }if(((Recipe) item).getResource2()==resources && stock>=1 && checked2) {
                        checked2=false;
                        flag++;
                        stock--;
                    }if(((Recipe) item).getResource3()==resources && stock>=1 && checked3) {
                        checked3=false;
                        flag++;
                        //stock--;
                    }
                }
            }if(flag==3 &&item instanceof Recipe ) removeItemFromInventory(item);
            else if(item instanceof Recipe && flag!=3) System.out.println("This item can not be used");
            else removeItemFromInventory(item);
            if(item instanceof Recipe){
                removeItemFromInventory(((Recipe) item).getResource1());
                removeItemFromInventory(((Recipe) item).getResource2());
                removeItemFromInventory(((Recipe) item).getResource3());
                addItemToInventory(((Recipe) item).getCreation());
            }else if(item instanceof BuffPotion){
                ExecutorService executorService = Executors.newSingleThreadExecutor();

                executorService.execute(() -> {
                    player.consumes((BuffPotion) item);
                    System.out.println("The buff is no more");
                });

                System.out.println("I was here");

                // Shutdown the executor service when it's no longer needed
                executorService.shutdown();


            }else if(item instanceof HealthPotion){
                player.consumes((HealthPotion) item);
            }
        }else{

        }
        System.out.println("I was here");
    }
    public void optDiscard(Item item){
        if(item.discard()) {
            removeItemFromInventory(item);
        }else{

        }
    }
}



