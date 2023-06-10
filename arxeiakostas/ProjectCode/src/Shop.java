import java.util.InputMismatchException;
import java.util.Scanner;
public class Shop {
   //cool idea: maybe based on the reputation, the greeting of the merchant changes?
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
    //checks the reputation to see if the character deserves a discount or not
    public void checkForDiscount(){
        if(){}
    }
}
