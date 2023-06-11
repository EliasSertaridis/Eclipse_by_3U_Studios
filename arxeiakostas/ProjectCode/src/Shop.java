import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Map;
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
    public Map<Item, Float> discountedItems(Merchant merchant){
        Map<Item, Float> discountedPrices = new HashMap<>();
        for (Map.Entry<Item, Float> entry : merchant.getPrices().entrySet()) {
            Item item = entry.getKey();
            float originalPrice = entry.getValue();
            float discountedPrice = (float) originalPrice / 2;
            discountedPrices.put(item, discountedPrice);
        }

        return discountedPrices;
    }

    //method that shows to the player all the items and available actions he can make during the use case.
    public void showTransactionsScreen(int choice, boolean discount, Merchant merchant, PlayableCharacter character){
        // the player chooses to buy, while his reputation is 5 or bigger so print all the items with reduced prices,
        // the merchant has available
        if(choice == 1 && discount){
            System.out.println("Here is everything that I have for sale! I have made a little discount for you! \n");
            // prints the item names and their discounted prices
            Map<Item, Float> discountedItems = discountedItems(merchant);

            for (Map.Entry<Item, Float> entry : discountedItems.entrySet()) {
                Item item = entry.getKey();
                float discountedPrice = entry.getValue();

                System.out.println("- " + item.getName() + ": " + discountedPrice + "\n");
            }
            System.out.println("What item do you wish to purchase? (Please type the name of the item you want and press Enter) \n");

            boolean found = false;
            Scanner myObj = new Scanner(System.in);
            String input;
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
                            found = true;
                            break;
                        }
                    }
                    else{
                        System.out.println("I do not have this Item. Please select one of the available items.");
                    }
                }
            }
            //check if the character of the player has room in his inventory to put the item he purchases
            character.getInventory().checkSpace();
        }
        // the player chooses to buy, while his reputation is less than 5, so print all the items the merchant has to
        // offer, with their normal prices.
        else if(choice == 1 && !discount){
            System.out.println("Here is everything that I have for sale!\n");
            //prints the item names with their original prices
            Map<Item, Float> prices = merchant.getPrices();

            for(Map.Entry<Item,Float> entries :prices.entrySet()){
                Item item = entries.getKey();
                float ogPrice = entries.getValue();

                System.out.println("- " + item.getName() + ": " + ogPrice + "\n");
            }
            System.out.println("What item do you wish to purchase? (Please type the name of the item you want and press Enter) \n");
        }
    }
}
