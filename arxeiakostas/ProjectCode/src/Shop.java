import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Map;
public class Shop{

    // method that starts a dialogue with the player in order to choose the type of transaction he wants to make
    public int showOptionsForTransactions(){
        int choice = 0;
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
            return 1;
        }
        else if(choice == 2){
            System.out.println("I could you some goods, truth be told. Let's see what you're offering...");
            return 2;
        }
        else {
            System.out.println("InInvalid input. Please try entering 1 or 2 to specify your choice.");
            choice = myObj.nextInt();
            return -1;
        }
    }

    //function that takes the map of items and their prices and does a 50% discount on all items and returns the
    // discounted items
    public Map<Item, Float> showDiscountedItems(Merchant merchant){
        Map<Item, Float> discountedPrices = new HashMap<>();
        for (Map.Entry<Item, Float> entry : merchant.getPrices().entrySet()) {
            Item item = entry.getKey();
            float originalPrice = entry.getValue();
            float discountedPrice = (float) originalPrice / 2;
            discountedPrices.put(item, discountedPrice);
        }

        return discountedPrices;
    }

    
}
