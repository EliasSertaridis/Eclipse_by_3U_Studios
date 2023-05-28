import java.sql.SQLOutput;
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
        boolean on=true;
        while(on) {
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
            List<QuickItem> items;//= new ArrayList<>();
            items = equipment.getCurrentQuickItems();
            for (QuickItem item : items) {
                System.out.println("Quick Item Slot " + (i+1) + " " + item.getName());
                i++;
            }
            while (i < 5) {
                System.out.println("Quick Item Slot " + (i+1) + " Empty");
                i++;
            }
            System.out.println("Enter which Field you want to change: ");
            String input = scanner.nextLine();
            while (!madeChoice) {
                if (input.equals("Head") || input.equals("Chest") || input.equals("Hand") || input.equals("Leg") || input.equals("Right") || input.equals("Left")) {
                    madeChoice = true;
                    chooseEquipmentType(input);
                }else if(input.equals("Slot1") || input.equals("Slot2") || input.equals("Slot3") || input.equals("Slot4")|| input.equals("Slot5")){
                    madeChoice= true;
                    chooseQuickItems(input);
                }else if(input.equals("Exit")){
                    on=false;
                    madeChoice=true;
                }
                else {
                    System.out.println("You typed it wrong. Try again");
                    input = scanner.nextLine();
                }
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

    public void chooseQuickItems(String choice) {
        if (choice.equals("Slot1")) {
            chooseQuickItem(0);
        } else if (choice.equals("Slot2")) {
            chooseQuickItem(1);
        } else if (choice.equals("Slot3")) {
            chooseQuickItem(2);
        } else if (choice.equals("Slot4")) {
            chooseQuickItem(3);
        }else if(choice.equals("Slot5")) {
            chooseQuickItem(4);
        }else
            System.out.println("Nothing");

    }

    public void chooseQuickItem(int slot) {
        boolean on = true;
        while (on) {
            int i = 1;
            boolean option = false;
            List<QuickItem> quickItem = inventory.getAllQuickItems();
            System.out.println("All the Quick Items of the player:");
            for (QuickItem item : quickItem) {
                System.out.println(i + ".  " + item.getName());
                i++;
            }
            Scanner scanner = new Scanner(System.in);
            String input;
            input = scanner.nextLine();
            if (input.equals("Exit")) {
                on = false;
            } else {
                int position = Integer.parseInt(input);
                showQuickItemInfo(quickItem.get(position - 1));
                System.out.println("You want to equip " + quickItem.get(position - 1).getName() + " ?");
                input = scanner.nextLine();
                while (!option) {
                    if (input.equals("Yes")) {
                        if(this.equipment.getCurrentQuickItems().size()>slot){
                        this.equipment.changeQuickItem(this.equipment.getCurrentQuickItems().get(slot),quickItem.get(position-1));
                        }else{
                            this.equipment.addQuickItem(quickItem.get(position-1));
                        }
                        on = false;
                        option = true;
                    } else if (input.equals("No")) {
                        option = true;
                    } else if (input.equals("Exit")) {
                        option = true;
                        on = false;
                    } else {
                        System.out.println("You typed it wrong. Try again ");
                    }
                }
            }
        }
    }

    public void chooseHead() {
        boolean on=true;
        while(on) {
            int i = 1;
            boolean option=false;
            List<Armor> armor = inventory.getAllEquipmentOfType(Armor.TypeOfArmor.Head);
            System.out.println("All the Head Armor  of the player:");
            for (Armor head : armor) {
                System.out.println(i + ".  " + head.getName());
                i++;
            }
            Scanner scanner = new Scanner(System.in);
            String input;
            input = scanner.nextLine();
            if(input.equals("Exit")){
                on=false;
            }else{
            int position = Integer.parseInt(input);
            chooseEquipment(armor.get(position - 1));
            compareStats(armor.get(position - 1), this.equipment.getHead());
            System.out.println("You want to equip " + armor.get(position - 1).getName() + " ?");
            input = scanner.nextLine();
            while(!option){
            if (input.equals("Yes")) {
                if (fitCheck(armor.get(position - 1), this.equipment.getHead())) {
                    this.equipment.setHead(armor.get(position - 1));
                    on=false;
                    option=true;
                }
                }else if(input.equals("No")){
                    option=true;
                }else if(input.equals("Exit")){
                    option=true;
                    on=false;
                }else {
                    System.out.println("You typed it wrong. Try again ");
                }
            }}
        }

}

    public void chooseChest() {
        boolean on = true;
        while (on) {
            int i = 1;
            boolean option = false;
            List<Armor> armor = inventory.getAllEquipmentOfType(Armor.TypeOfArmor.Chest);
            System.out.println("All the Chest Armor  of the player:");
            for (Armor chest : armor) {
                System.out.println(i + ".  " + chest.getName());
                i++;
            }
            Scanner scanner = new Scanner(System.in);
            String input;
            input = scanner.nextLine();
            if (input.equals("Exit")) {
                on = false;
            } else {
                int position = Integer.parseInt(input);
                chooseEquipment(armor.get(position - 1));
                compareStats(armor.get(position - 1), this.equipment.getChest());
                System.out.println("You want to equip " + armor.get(position - 1).getName() + " ?");
                input = scanner.nextLine();
                while (!option) {
                    if (input.equals("Yes")) {
                        if (fitCheck(armor.get(position - 1), this.equipment.getChest())) {
                            this.equipment.setChest(armor.get(position - 1));
                            on = false;
                            option = true;
                        }
                    } else if (input.equals("No")) {
                        option = true;
                    } else if (input.equals("Exit")) {
                        option = true;
                        on = false;
                    } else {
                        System.out.println("You typed it wrong. Try again ");
                    }
                }
            }
        }
    }

    public void chooseHand() {
        boolean on=true;
        while(on) {
            int i = 1;
            boolean option = false;
            List<Armor> armor = inventory.getAllEquipmentOfType(Armor.TypeOfArmor.Hands);
            System.out.println("All the Hand Armor  of the player:");
            for (Armor hand : armor) {
                System.out.println(i + ".  " + hand.getName());
                i++;
            }
            Scanner scanner = new Scanner(System.in);
            String input;
            input = scanner.nextLine();
            if (input.equals("Exit")) {
                on = false;
            } else {
                int position = Integer.parseInt(input);
                chooseEquipment(armor.get(position - 1));
                compareStats(armor.get(position - 1), this.equipment.getHands());
                System.out.println("You want to equip " + armor.get(position - 1).getName() + " ?");
                input = scanner.nextLine();
                while (!option) {
                    if (input.equals("Yes")) {
                        if (fitCheck(armor.get(position - 1), this.equipment.getHands())) {
                            this.equipment.setHands(armor.get(position - 1));
                            on = false;
                            option = true;
                        }
                    } else if (input.equals("No")) {
                        option = true;
                    } else if (input.equals("Exit")) {
                        option = true;
                        on = false;
                    } else {
                        System.out.println("You typed it wrong. Try again ");
                    }
                }
            }
        }
    }

    public void chooseLeg() {
        boolean on = true;
        while (on) {
            int i = 1;
            boolean option = false;
            List<Armor> armor = inventory.getAllEquipmentOfType(Armor.TypeOfArmor.Legs);
            System.out.println("All the Leg Armor  of the player:");
            for (Armor leg : armor) {
                System.out.println(i + ".  " + leg.getName());
                i++;
            }
            Scanner scanner = new Scanner(System.in);
            String input;
            input = scanner.nextLine();
            if (input.equals("Exit")) {
                on = false;
            } else {
                int position = Integer.parseInt(input);
                chooseEquipment(armor.get(position));
                compareStats(armor.get(position - 1), this.equipment.getLegs());
                System.out.println("You want to equip " + armor.get(position - 1).getName() + " ?");
                input = scanner.nextLine();
                while (!option) {
                    if (input.equals("Yes")) {
                        if (fitCheck(armor.get(position - 1), this.equipment.getLegs())) {
                            this.equipment.setLegs(armor.get(position - 1));
                            on = false;
                            option = true;
                        }
                    } else if (input.equals("No")) {
                        option = true;
                    } else if (input.equals("Exit")) {
                        option = true;
                        on = false;
                    } else {
                        System.out.println("You typed it wrong. Try again ");
                    }
                }
            }
        }
    }

    public void chooseRightWeapon() {
        boolean on=true;
        while(on) {
            int i = 1;
            boolean option = false;
            List<Weapon> equipment = inventory.getAllEquipmentOfType();
            System.out.println("All the Weapons of the player:");
            for (Equipment weapon : equipment) {
                System.out.println(i + ".  " + weapon.getName());
                i++;
            }
            Scanner scanner = new Scanner(System.in);
            String input;
            input = scanner.nextLine();
            if (input.equals("Exit")) {
                on = false;
            } else {
                int position = Integer.parseInt(input);
                chooseEquipment(equipment.get(position - 1));
                compareStats(equipment.get(position - 1), this.equipment.getRightWeapon());
                System.out.println("You want to equip " + equipment.get(position - 1).getName() + " ?");
                input = scanner.nextLine();
                while (!option) {
                    if (input.equals("Yes")) {
                        if (fitCheck(equipment.get(position - 1), this.equipment.getRightWeapon())) {
                            this.equipment.setRightWeapon(equipment.get(position - 1));
                            on = false;
                            option = true;
                        }
                    } else if (input.equals("No")) {
                        option = true;
                    } else if (input.equals("Exit")) {
                        option = true;
                        on = false;
                    } else {
                        System.out.println("You typed it wrong. Try again ");
                    }
                }
            }
        }
}

    public void chooseLeftWeapon() {
        boolean on = true;
        while (on) {
            int i = 1;
            boolean option = false;
            List<Weapon> equipment = inventory.getAllEquipmentOfType();
            System.out.println("All the Weapons of the player:");
            for (Equipment weapon : equipment) {
                System.out.println(i + ".  " + weapon.getName());
                i++;
            }
            Scanner scanner = new Scanner(System.in);
            String input;
            input = scanner.nextLine();
            if (input.equals("Exit")) {
                on = false;
            } else {
                int position = Integer.parseInt(input);
                chooseEquipment(equipment.get(position - 1));
                compareStats(equipment.get(position - 1), this.equipment.getLeftWeapon());
                System.out.println("You want to equip " + equipment.get(position - 1).getName() + " ?");
                input = scanner.nextLine();
                while (!option) {
                    if (input.equals("Yes")) {
                        if (fitCheck(equipment.get(position - 1), this.equipment.getLeftWeapon())) {
                            this.equipment.setLeftWeapon(equipment.get(position - 1));
                            on = false;
                            option = true;
                        }
                    } else if (input.equals("No")) {
                        option = true;
                    } else if (input.equals("Exit")) {
                        option = true;
                        on = false;
                    } else {
                        System.out.println("You typed it wrong. Try again ");
                    }
                }
            }
        }
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
        System.out.println(armor.getName()+" Armor Weight: "+armor.getWeight());
    }
    public void showQuickItemInfo(QuickItem quickItem){
        System.out.println("Quick Item Name: "+quickItem.getName());
        System.out.println("Quick Item Description: "+quickItem.getDescription());
        if(quickItem instanceof HealthPotion){
            System.out.println("Healing Effect: "+((HealthPotion) quickItem).getRegenPoints());
        }else if(quickItem instanceof BuffPotion){
            System.out.println("This Potion Buff"+((BuffPotion) quickItem).getStatToBeModified()+" By: "+((BuffPotion) quickItem).statModifier);
        }
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
                System.out.println("The "+oldWeapon.getName()+" has "+diffWeight+" less Weight than "+newWeapon.getName());
        }
        else if(newWeapon.getWeight()< oldWeapon.getWeight()){
                diffWeight= oldWeapon.getWeight()- newWeapon.getWeight();
                System.out.println("The "+newWeapon.getName()+" has "+diffWeight+" less Weight than "+oldWeapon.getName());
        }
        else if(newWeapon.getWeight()== oldWeapon.getWeight()){
                System.out.println("Both "+oldWeapon.getName()+" and "+newWeapon.getName()+" have the same Weight of "+oldWeapon.getWeight());

        }
    }
    public void compareStats(Armor oldArmor, Armor newArmor){
        int diff=0;
        int diffWeight=0;
        System.out.println("The Current "+oldArmor.getArmorType()+" Armor has "+oldArmor.getDefense()+" Defense");

        if(oldArmor.getDefense()<newArmor.getDefense()){
            diff=newArmor.getDefense()-oldArmor.getDefense();
            System.out.println("The "+newArmor.getName()+" has "+diff+" more Defense than "+ oldArmor.getName());
        }else if(oldArmor.getDefense()>newArmor.getDefense()){
            diff=oldArmor.getDefense()-newArmor.getDefense();
            System.out.println("The "+oldArmor.getName()+" has "+diff+" more Defense than "+ newArmor.getName());
        }else if(oldArmor.getDefense()==newArmor.getDefense()){
            System.out.println("Both "+oldArmor.getName()+" and "+newArmor.getName()+" have the same Defense of "+oldArmor.getDefense());

        }

        if(oldArmor.getWeight()< newArmor.getWeight()){
            diffWeight= newArmor.getWeight()- oldArmor.getWeight();
            System.out.println("The "+oldArmor.getName()+" has "+diffWeight+" less Weight than "+newArmor.getName());
        }
        else if(newArmor.getWeight()< oldArmor.getWeight()){
            diffWeight= oldArmor.getWeight()- newArmor.getWeight();
            System.out.println("The "+newArmor.getName()+" has "+diffWeight+" less Weight than "+oldArmor.getName());
        }
        else if(newArmor.getWeight()== oldArmor.getWeight()){
            System.out.println("Both "+oldArmor.getName()+" and "+newArmor.getName()+" have the same Weight of "+oldArmor.getWeight());

        }


    }
    public boolean fitCheck(Weapon newWeapon,Weapon oldWeapon){
        if(checkCompatibility(newWeapon,oldWeapon)){
            return true;
        }else{
            System.out.println("You can not wear this piece yet");
            return false;
        }
    }
    public boolean fitCheck(Armor newArmor,Armor oldArmor){
        if(checkCompatibility(newArmor,oldArmor)){
            return true;
        }else{
            System.out.println("You can not wear this piece yet");
            return false;
        }
    }
    public boolean checkCompatibility(Weapon newWeapon, Weapon oldWeapon){
        int newWeight;
        newWeight= equipment.totalWeight() - oldWeapon.getWeight()+newWeapon.getWeight();
        if(newWeight<player.getEquipLoad()){
            return true;
        }else return false;
    }
    public boolean checkCompatibility(Armor newArmor,Armor oldArmor){
        int newWeight;
        newWeight= equipment.totalWeight() - oldArmor.getWeight()+newArmor.getWeight();
        if(newWeight<player.getEquipLoad()){
            return true;
        }else return false;
    }


}

// System.out.println(enemy.get(i-1).getName());