import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlayerStatus {

    PlayableCharacter player;
    CurrentEquipment equipment;
    Inventory inventory;

    public PlayerStatus() {
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
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

    public int totalDamage(Weapon weapon){
        double totalDamage;
        double scalingDamage = 0;
        if(weapon.getScalingType()== Weapon.TypeOfScaling.DEX) {
            scalingDamage = (weapon.getScaling() + 1)*(player.getDexterity());
        }else if(weapon.getScalingType()== Weapon.TypeOfScaling.STR) {
            scalingDamage = (weapon.getScaling() + 1)*(player.getStrength());
        }
        else if(weapon.getScalingType()== Weapon.TypeOfScaling.INT) {
            scalingDamage = (weapon.getScaling() + 1)*(player.getIntelligence());
        }
        else if(weapon.getScalingType()== Weapon.TypeOfScaling.WIS) {
            scalingDamage = (weapon.getScaling() + 1)*(player.getWisdom());
        }
        totalDamage= weapon.getDamage()+scalingDamage;
        return (int)totalDamage;
    }

    public void openPlayerStatus() {
        int i = 0;
        boolean madeChoice = false;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hp: " + player.getHp());
        System.out.println("Level: " + player.getLevel());
        System.out.println("Equiped Armor: ");
        System.out.println("Head Piece: " + equipment.getHead().getName());
        System.out.println("Chest Piece: " + equipment.getChest().getName());
        System.out.println("Hand Piece: " + equipment.getHands().getName());
        System.out.println("Leg Piece: " + equipment.getLegs().getName());
        System.out.println("Right Weapon: " + equipment.getRightWeapon().getName());
        System.out.println("Left Weapon: " + equipment.getLeftWeapon().getName());
        List<QuickItem> items = new ArrayList<>();
        items = equipment.getCurrentQuickItems();
        for (QuickItem item : items) {
            System.out.println("Quick Item Slot " + i + " " + item.getName());
            i++;
        }
        while (i < 5) {
            System.out.println("Quick Item Slot " + i + " Empty");
            i++;
        }
        System.out.println("Enter which Field you want to change: ");
        String input = scanner.nextLine();
        while (!madeChoice) {
            if (input.equals("Head") || input.equals("Chest") || input.equals("Hand") || input.equals("Leg") || input.equals("Right") || input.equals("Left")) {
                madeChoice = true;
                chooseEquipmentType(input);
            } else {
                System.out.println("You typed it wrong. Try again");
                input = scanner.nextLine();
            }
        }

    }

    public void chooseEquipmentType(String choice) {
        if (choice.equals("Head")) {
            chooseHead();
        } else if (choice.equals("Hand")) {
            chooseHand();
        } else if (choice.equals("Chest")) {
            chooseChest();
        } else if (choice.equals("Leg")) {
            chooseLeg();
        } else if (choice.equals("Right")) {
            chooseRightWeapon();
        } else if (choice.equals("Left")) {
            chooseLeftWeapon();
        } else
            System.out.println("Nothing");

    }

    public void chooseHead() {
        int i = 1;
        List<Armor> armor = inventory.getAllEquipmentOfType(Armor.TypeOfArmor.Head);
        System.out.println("All the Head Armor  of the player:");
        for (Armor head : armor) {
            System.out.println(i + ".  " + head.getName());
            i++;
        }
        Scanner scanner = new Scanner(System.in);
        String input;
        input=scanner.nextLine();
        int position= Integer.parseInt(input);
        chooseEquipment(armor.get(position));
    }

    public void chooseChest() {
        int i = 1;
        List<Armor> armor = inventory.getAllEquipmentOfType(Armor.TypeOfArmor.Chest);
        System.out.println("All the Chest Armor  of the player:");
        for (Armor chest : armor) {
            System.out.println(i + ".  " + chest.getName());
            i++;
        }
        Scanner scanner = new Scanner(System.in);
        String input;
        input=scanner.nextLine();
        int position= Integer.parseInt(input);
        chooseEquipment(armor.get(position-1));
    }

    public void chooseHand() {
        int i = 1;
        List<Armor> armor = inventory.getAllEquipmentOfType(Armor.TypeOfArmor.Hands);
        System.out.println("All the Hand Armor  of the player:");
        for (Armor hand : armor) {
            System.out.println(i + ".  " + hand.getName());
            i++;
        }Scanner scanner = new Scanner(System.in);
        String input;
        input=scanner.nextLine();
        int position= Integer.parseInt(input);
        chooseEquipment(armor.get(position-1));

    }

    public void chooseLeg() {
        int i = 1;
        List<Armor> armor = inventory.getAllEquipmentOfType(Armor.TypeOfArmor.Legs);
        System.out.println("All the Leg Armor  of the player:");
        for (Armor leg : armor) {
            System.out.println(i + ".  " + leg.getName());
            i++;
        }
        Scanner scanner = new Scanner(System.in);
        String input;
        input=scanner.nextLine();
        int position= Integer.parseInt(input);
        chooseEquipment(armor.get(position));
    }

    public void chooseRightWeapon() {
        int i = 1;
        List<Weapon> equipment = inventory.getAllEquipmentOfType();
        System.out.println("All the Weapons of the player:");
        for (Equipment weapon : equipment) {
            System.out.println(i + ".  " + weapon.getName());
            i++;
        }
        Scanner scanner = new Scanner(System.in);
        String input;
        input=scanner.nextLine();
        int position= Integer.parseInt(input);
        chooseEquipment(equipment.get(position-1));
        compareStats(equipment.get(position-1),this.equipment.getRightWeapon());
    }

    public void chooseLeftWeapon() {
        int i = 1;
        List<Weapon> equipment = inventory.getAllEquipmentOfType();
        System.out.println("All the Weapons of the player:");
        for (Equipment weapon : equipment) {
            System.out.println(i + ".  " + weapon.getName());
            i++;
        }
        Scanner scanner = new Scanner(System.in);
        String input;
        input=scanner.nextLine();
        int position= Integer.parseInt(input);
        chooseEquipment(equipment.get(position-1));
        compareStats(equipment.get(position-1),this.equipment.getLeftWeapon());
    }
    public void chooseEquipment(Weapon weapon){
        System.out.println("Weapon Name: "+weapon.getName());
        System.out.println("Weapon Description: "+weapon.getDescription());
        System.out.println("This Weapon Scales With: "+weapon.getScalingType());
        System.out.println("The total Damage that "+ weapon.getName()+" can do is "+totalDamage(weapon));
        System.out.println("Weapon Weight: "+weapon.getWeight());
    }
    public void chooseEquipment(Armor armor){
        System.out.println(armor.armorType+" Armor Name: "+armor.getName());
        System.out.println(armor.armorType+" Armor Description: "+armor.getDescription());
        System.out.println("Defense: "+armor.getDefense());
        System.out.println(armor.getWeight()+" Armor Weight: "+armor.getWeight());
    }

    public void compareStats(Weapon newWeapon, Weapon oldWeapon){
        int diff=0;
        int diffWeight=0;
        System.out.println("The equiped "+oldWeapon.getName()+" has a total damage of "+totalDamage(oldWeapon));
        if(totalDamage(oldWeapon)<totalDamage(newWeapon)){
            diff=totalDamage(newWeapon)-totalDamage(oldWeapon);
            System.out.println("The "+newWeapon.getName()+" has "+diff+" more damage than "+oldWeapon.getName());
        }else if(totalDamage(oldWeapon)>totalDamage(newWeapon)){
            diff=totalDamage(oldWeapon)-totalDamage(newWeapon);
            System.out.println("The "+oldWeapon.getName()+" has "+diff+" more damage than "+newWeapon.getName());

        }else if(totalDamage(oldWeapon)==totalDamage(newWeapon)) {
            System.out.println("Both "+oldWeapon.getName()+" and "+newWeapon.getName()+" have the same damage of "+totalDamage(oldWeapon));
        }
            if(oldWeapon.getWeight()< newWeapon.getWeight()){
                diffWeight= newWeapon.getWeight()- oldWeapon.getWeight();
                System.out.println("The "+newWeapon.getName()+" has "+diffWeight+" more Weight than "+oldWeapon.getName());
            }
            else if(newWeapon.getWeight()< oldWeapon.getWeight()){
                diffWeight= oldWeapon.getWeight()- newWeapon.getWeight();
                System.out.println("The "+oldWeapon.getName()+" has "+diffWeight+" more Weight than "+newWeapon.getName());
            }
            else if(newWeapon.getWeight()== oldWeapon.getWeight()){
                System.out.println("Both "+oldWeapon.getName()+" and "+newWeapon.getName()+" have the same Weight of "+oldWeapon.getWeight());

            }
    }
    public void compareStats(Armor oldArmor, Armor newArmor){

    }
}

// System.out.println(enemy.get(i-1).getName());