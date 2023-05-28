import java.util.*;
public class Shop {
    public void showOptionsForTransactions() throws IllegalArgumentException{
        System.out.println("Please choose the action you want to perfom. \n");
        System.out.println("1. Buy/Upgrade Product from the merchant. \n");
        System.out.println("2. Sell Product to the merchant. \n");
        System.out.println("Press the corresponding number to choose your action.");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();

        if( choice == 1){
            //call the method that continues this choice
        }
        else if (choice == 2) {
            //call the method that continues this choice
        }
        else{
            throw new IllegalArgumentException("Please insert 1 or 2 to make a choice");
        }
    }
}
