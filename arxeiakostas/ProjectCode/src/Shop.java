import java.util.*;

public class Shop{

    // method that starts a dialogue with the player in order to choose the type of transaction he wants to make
    public int showOptionsForTransactions(){
        int choice;
        System.out.println("Welcome traveller! How can I be of service today? \n");
        System.out.println("1. Buy/upgrade product.\n");
        System.out.println("2. Sell product.\n");
        Scanner myObj = new Scanner(System.in);
        try{
             choice = myObj.nextInt();
        }
        catch (InputMismatchException e){
            System.out.println("Invalid input. Please try entering 1 or 2 to specify your choice.");
            choice = myObj.nextInt();
        }
        if(choice == 1){
            System.out.println("I will gladly show you my merchandise! I can upgrade your gear if you'll let me while we are at it!");
            return choice;
        }
        else if(choice == 2){
            System.out.println("I could you some goods, truth be told. Let's see what you're offering...");
            return choice;
        }
        else {
            System.out.println("InInvalid input. Please try entering 1 or 2 to specify your choice.");
            return -1;
        }
    }

    //method that takes the map of items and their prices and does a 50% discount on all items and returns the
    // discounted items
    public void discountedItems(Merchant merchant){
        Map<Item, Float> discountedPrices = new HashMap<>();
        for (Map.Entry<Item, Float> entry : merchant.getPrices().entrySet()) {
            Item item = entry.getKey();
            float originalPrice = entry.getValue();
            float discountedPrice = (float) originalPrice / 2;
            discountedPrices.put(item, discountedPrice);
        }

        merchant.setPrices(discountedPrices);
    }

    //method that shows to the player all the items and available actions he can make during the use case.
    public void showTransactionsScreen(int choice, boolean discount, Merchant merchant, PlayableCharacter character){
        // the player chooses to buy, while his reputation is 5 or bigger so print all the items with reduced prices,
        // the merchant has available
        if(choice == 1){
            if(discount) System.out.println("Here is everything that I have for sale! I have made a little discount for you! \n");
            else{System.out.println("Here is everything that I have for sale!\n");}
            // prints the item names and their  prices
            Map<Item, Float> discountedItems = merchant.getPrices();

            for (Map.Entry<Item, Float> entry : discountedItems.entrySet()) {
                Item item = entry.getKey();
                float discountedPrice = entry.getValue();

                System.out.println("- " + item.getName() + ": " + discountedPrice + "\n");
            }
            System.out.println("What item do you wish to purchase? (Please type the name of the item you want and press Enter) \n");

            boolean found = false;
            Scanner myObj = new Scanner(System.in);
            String input;
            Item selectedItem = null;
            while(!found){

                // player types the item he wishes to purchase
                input = myObj.nextLine();
                //checks if the item the player typed is in the catalogue and if it is it takes its price and checks if he
                // has enough to purchase it, else outputs that the item he asked is not in the catalogue
                for(Map.Entry<Item, Float> entry : discountedItems.entrySet()){
                    Item item = entry.getKey();
                    if(item.getName().equals(input)){
                        float price = entry.getValue();
                        if(character.hasEnoughMoney(price)){
                            System.out.println("You have the money to purchase the item. \n");
                            selectedItem = item;
                            found = true;
                            break;
                        }
                    }
                    else{
                        System.out.println("I do not have this Item. Please select one of the available items. \n");
                    }
                }
            }
            if(found){
                //check if the character of the player has room in his inventory to put the item he purchases and if yes add
                // the item, else he can go to his inventory, remove an item and come back
                character.getInventory().addItemToInventory(selectedItem);
                //reduce the money of the player
                character.reduceMoney(merchant, selectedItem);
                //increment his reputation with the race of the merchant
                character.incReputationWithTypeOfMerchant(merchant);
                merchant.updateMerchantInventory(selectedItem);
            }
            System.out.println("Do you wish for me to upgrade anything from your gear also? (type Υes for 'yes' or Νo for 'no')\n");
            Scanner scanner = new Scanner(System.in);
            String input1;
            boolean madeChoice = false;
            while (!madeChoice) {
                input1 = scanner.nextLine();
                //here we have the upgrade part of the use case
                if (input1.equals("Yes")) {
                    madeChoice = true;
                    List<Equipment> eq = character.getInventory().getAllEquipment();
                    System.out.println("Here is all the Equipment you have, that you can upgrade: \n");
                    for (Equipment equipment : eq) {
                        System.out.println("- " + equipment.getName());
                    }
                    System.out.println("Type in the name of the item you want to upgrade: \n");
                    Scanner scan = new Scanner(System.in);
                    String input2 = scanner.nextLine();
                    Equipment eqForUpgrade;
                    for(Equipment equipment : eq){
                        if(equipment.getName().equals(input2)){
                            eqForUpgrade = equipment;
                            break;
                        }
                    }

                } else if (input1.equals("No")) {
                    madeChoice = true;
                } else
                    System.out.println("What you typed is not an option. The options you have here are: \n Yes \n No");
            }
        }
        else if(choice == 2){

        }

    }

}
