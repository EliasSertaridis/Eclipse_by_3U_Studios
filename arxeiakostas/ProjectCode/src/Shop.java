import java.util.*;
public class Shop {

    //method that implements a menu in order for the player to choose the type of transaction he wants to do
    public void showOptionsForTransactions() throws IllegalArgumentException{
        System.out.println("Please choose the action you want to perfom. \n");
        System.out.println("1. Buy/Upgrade Product from the merchant. \n");
        System.out.println("2. Sell Product to the merchant. \n");
        System.out.println("Press the corresponding number to choose your action.");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();

        // players choice is to Buy and/or Upgrade
        if( choice == 1){
            //call the method that continues this choice
        }
        //players choice is to sell
        else if (choice == 2) {
            //call the method that continues this choice
        }
        //wrong input from player
        else{
            throw new IllegalArgumentException("Please insert 1 or 2 to make a choice");
        }
    }
}
