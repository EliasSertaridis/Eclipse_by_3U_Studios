import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlayerStatus {

    PlayableCharacter player;
    CurrentEquipment equipment;
    // Inventory inventory;

    public PlayerStatus() {
    }

    public Character getPlayer() {
        return player;
    }

    public void setPlayer(PlayableCharacter player) {
        this.player = player;
    }

    public CurrentEquipment getEquipment() {
        return equipment;
    }

    public void setEquipment(CurrentEquipment equipment) {
        this.equipment = equipment;
    }

    public void openPlayerStatus() {
        int i=0;
        boolean madeChoice=false;
        Scanner scanner= new Scanner(System.in);

        System.out.println("Hp: "+player.getHp());
        System.out.println("Level: "+player.getLevel());
        System.out.println("Equiped Armor: ");
        System.out.println("Head Piece: " + equipment.getHead().getName());
        System.out.println("Chest Piece: "+ equipment.getChest().getName());
        System.out.println("Hand Piece: "+equipment.getHands().getName());
        System.out.println("Leg Piece: "+ equipment.getLegs().getName());
        System.out.println("Right Weapon: "+ equipment.getRightWeapon().getName());
        System.out.println("Left Weapon: "+equipment.getLeftWeapon().getName());
        List<QuickItem> items=new ArrayList<>();
        items=equipment.getCurrentQuickItems();
        for(QuickItem item:items){
            System.out.println("Quick Item Slot "+i+" "+ item.getName());
            i++;
        }
        while(i<5){
            System.out.println("Quick Item Slot "+i+" Empty");
            i++;
        }
        System.out.println("Enter which Field you want to change: ");
        String input= scanner.nextLine();
        while(!madeChoice) {
            if (input.equals("Head")|| input.equals("Chest") || input.equals("Hand")||input.equals("Leg")|| input.equals("Right")|| input.equals("Left")) {
                madeChoice=true;
                chooseEquipment(input);
            } else {
                System.out.println("You typed it wrong. Try again");
                input = scanner.nextLine();
            }
            }

        }
    public void chooseEquipment(String choice){
        if(choice.equals("Head")){
            chooseHead();
        } else if(choice.equals("Hand")){
            chooseHand();
        }else if(choice.equals("Chest")){
            chooseChest();
        }else if(choice.equals("Leg")){
            chooseLeg();
        }else if(choice.equals("Right")){
            chooseRightWeapon();
        }else if(choice.equals("Left")){
            chooseLeftWeapon();
        }else
            System.out.println("Nothing");

    }
    public void chooseHead() {
        int i = 1;
        List<Armor> armor = equipment.getCurrentArmor();//prepei na bei to invetory
        System.out.println("All the Head Armor  of the player:");
        for (Armor head : armor) {
            if (head.armorType == Armor.TypeOfArmor.Head) {
                System.out.println(i+".  " + head.getName());
                i++;
            }
        }
    }
    public void chooseChest(){
        int i=1;
        List<Armor> armor = equipment.getCurrentArmor();//prepei na bei to invetory
        System.out.println("All the Chest Armor  of the player:");
        for (Armor chest : armor) {
            if (chest.armorType == Armor.TypeOfArmor.Chest) {
                System.out.println(i+".  " + chest.getName());
                i++;
            }
        }
    }
    public void chooseHand(){
        int i=1;
        List<Armor> armor = equipment.getCurrentArmor();//prepei na bei to invetory
        System.out.println("All the Hand Armor  of the player:");
        for (Armor hand : armor) {
            if (hand.armorType == Armor.TypeOfArmor.Hands) {
                System.out.println(i+".  " + hand.getName());
                i++;
            }
        }
    }
    public void chooseLeg(){
        int i=1;
        List<Armor> armor = equipment.getCurrentArmor();//prepei na bei to invetory
        System.out.println("All the Leg Armor  of the player:");
        for (Armor leg : armor) {
            if (leg.armorType == Armor.TypeOfArmor.Legs) {
                System.out.println(i+".  " + leg.getName());
                i++;
            }
        }
    }
    public void chooseRightWeapon(){
        int i=1;
        List<Weapon> weapons = equipment.getCurrentWeapons();//prepei na bei to invetory
        System.out.println("All the Weapons  of the player:");
        for (Weapon rightWeapon : weapons) {
                System.out.println(i+".  " + rightWeapon.getName());
                i++;
        }
    }
    public void chooseLeftWeapon(){
        int i=1;
        List<Weapon> weapons = equipment.getCurrentWeapons();//prepei na bei to invetory
        System.out.println("All the Weapons  of the player:");
        for (Weapon leftWeapon : weapons) {
            System.out.println(i+".  " + leftWeapon.getName());
            i++;
        }
    }
    }


