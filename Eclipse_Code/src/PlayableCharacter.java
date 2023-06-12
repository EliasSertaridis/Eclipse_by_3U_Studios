import java.util.*;

public class PlayableCharacter extends Character{
    private int skillPoints;
    private int money;
    private int level;
    private double equipLoad;
    private double defenceModifier;
    private CurrentEquipment currentEquipment;
    private PlayerStatus playerStatus;
    private Race race;
    private Inventory inventory;
    private SpellSlot spellSlot;
    private Class pc_class;
    private Map <String, Integer> reputation;

    public PlayableCharacter(){
        super();
    }
    public PlayableCharacter(String name, String gender, int hp, int strength, int dexterity, int vitality, int intelligence, int wisdom, int money, int level, double equipLoad) {
        super(name, gender, hp, strength, dexterity, vitality, intelligence, wisdom);
        this.money = money;
        this.level = level;
        this.equipLoad = equipLoad;
    }

    public Class getPc_class() {
        return pc_class;
    }

    public void setPc_class(Class pc_class) {
        this.pc_class = pc_class;
    }

    public SpellSlot getSpellSlot() {
        return spellSlot;
    }

    public void setSpellSlot(SpellSlot spellSlot) {
        this.spellSlot = spellSlot;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public int getSkillPoints() {
        return skillPoints;
    }

    public void setSkillPoints(int skillPoints) {
        this.skillPoints = skillPoints;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public double getEquipLoad() {
        return equipLoad;
    }

    public void setEquipLoad(double equipLoad) {
        this.equipLoad = equipLoad;
    }

    public double getDefenceModifier() {
        return defenceModifier;
    }

    public void setDefenceModifier(double defenceModifier) {
        this.defenceModifier = defenceModifier;
    }

    public CurrentEquipment getCurrentEquipment() {
        return currentEquipment;
    }

    public void setCurrentEquipment(CurrentEquipment currentEquipment) {
        this.currentEquipment = currentEquipment;
    }

    public PlayerStatus getPlayerStatus() {
        return playerStatus;
    }

    public void setPlayerStatus(PlayerStatus playerStatus) {
        this.playerStatus = playerStatus;
    }

    public Map<String, Integer> getPlayerStats(){
        Map<String, Integer> playerStats = new HashMap<>();
        playerStats.put(getName(),getHp());
        return playerStats;
    }
    public void setReputation(){
        Map<String,Integer> repWithMerch = new HashMap<>();
        repWithMerch.put(Race.raceType.Human.toString(), 1);
        repWithMerch.put(Race.raceType.Ork.toString(),1);
        repWithMerch.put(Race.raceType.Elf.toString(),1);
        repWithMerch.put(Race.raceType.Dwarf.toString(),1);
        repWithMerch.put(Race.raceType.Halfling.toString(),1);
        this.reputation = repWithMerch;
    }
    public Map getReputation(){
        return reputation;
    }
    //function that takes the race of a merchant and returns the reputation of the character with that merchant
    public int getReputationWithTypeOfMerchant(Merchant merchant){
        String raceOfMerch = String.valueOf(merchant.getRace());
        //loop for accessing the map with the reputation of the character with the different races of merchants
        //and when it finds the one we want it returns it
        for(Map.Entry<String, Integer> entry : reputation.entrySet()){
            // if the key value of the map is the same with the race of the merchant,return the reputation with that
            //race, else return 0
            if(Objects.equals(raceOfMerch, entry.getKey())){
                return entry.getValue();
            }
        }
        return 0;
    }

    //checks if the character has enough money to buy an item from a merchant
    public boolean hasEnoughMoney(float price){
        float playerMoney = getMoney();
        if(playerMoney < price){
            return false;
        }
        else if(playerMoney > price){
            return true;
        }
        else{
            System.out.println("Warning: After this purchase you will be broke!");
            return true;
        }
    }

    public void reduceMoney(Merchant merchant, Item item){
        Map<Item, Float> prices = merchant.getPrices();
        for(Map.Entry<Item, Float> entry : prices.entrySet()){
            if(item.getName().equals(entry.getKey())){
                float reducedMoney = getMoney() - entry.getValue();
                setMoney((int) reducedMoney);
                break;
            }
        }
    }

    public void incReputationWithTypeOfMerchant(Merchant merchant){
        String raceOfMerch = String.valueOf(merchant.getRace());
        for(Map.Entry<String, Integer> entry : reputation.entrySet()){
            // if the key value of the map is the same with the race of the merchant,return the reputation with that
            //race, else return 0
            if(Objects.equals(raceOfMerch, entry.getKey())){
                entry.setValue(entry.getValue() + 1);
            }
        }
    }
    public void setDefenceMod(){
        this.defenceModifier = currentEquipment.getTotalDefense();
    }
    public void consumes(BuffPotion buffPotion){

        switch(buffPotion.getStatToBeModified()) {
            case INT:
                setIntelligence(getIntelligence()+buffPotion.getStatModifier());
                try {
                    Thread.sleep(120000);  // Sleep for 2 minutes (2 * 60,000 milliseconds)
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                setIntelligence(getIntelligence()-buffPotion.getStatModifier());
                break;
            case STR:
                setStrength(getStrength()+buffPotion.getStatModifier());
                System.out.println("THE STR NOW IS "+getStrength());
                try {
                    Thread.sleep(120000);  // Sleep for 2 minutes (2 * 60,000 milliseconds)
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                setStrength(getStrength()-buffPotion.getStatModifier());
                System.out.println("THE STR IS BACK AT"+getStrength());
                break;
            case DEX:
                setDexterity(getDexterity()+buffPotion.getStatModifier());
                try {
                    Thread.sleep(120000);  // Sleep for 2 minutes (2 * 60,000 milliseconds)
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                setDexterity(getDexterity()-buffPotion.getStatModifier());
                break;
            case WIS:
                setWisdom(getWisdom()+buffPotion.getStatModifier());
                try {
                    Thread.sleep(120000);  // Sleep for 2 minutes (2 * 60,000 milliseconds)
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                setDexterity(getDexterity()-buffPotion.getStatModifier());
                break;
            case VIT:
                setVitality(getVitality()+buffPotion.getStatModifier());
                try {
                    Thread.sleep(120000);  // Sleep for 2 minutes (2 * 60,000 milliseconds)
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }setVitality(getVitality()-buffPotion.getStatModifier());
                break;

        }
    }
    public void consumes(HealthPotion healthPotion){
        if(getHp()+ healthPotion.getRegenPoints()>=getMaxHP()){
            setHp(getMaxHP());
        }else setHp(getHp()+healthPotion.getRegenPoints());
    }
    public void restoreEssentials(){
        setHp(getMaxHP());
    }
    public void setBaseStats(PlayableCharacter pc){
        boolean setStats = false;
        int str=0;
        int dex=0;
        int vit=0;
        int intel=0;
        int wis=0;
        int count=0;
        System.out.println("You have 55 points to distribute between the following 5 stats:");
        System.out.println("1. Strength: affects your equipload and the ability to use some weapons");
        System.out.println("2. Dexterity: affects your speed and the ability to use some weapons");
        System.out.println("3. Vitality: affects your resistance to status effects");
        System.out.println("4. Intelligence: affects your ability to use spells that scale with this stat");
        System.out.println("5. Wisdom: affects your ability to use spells that scale with this stat");
        System.out.println("To add a point first write 'add' and then the number associated with the stat as presented above.");
        System.out.println("To remove a point first write 'remove' and then the number associated with the stat as presented above.");
        System.out.println("Whenever you feel satisfied and wish to finalize your stats, type 'done'.");
        System.out.println("If you wish to see how you have distributed your points type 'show'.");
        Scanner scanner = new Scanner(System.in);
        while (!setStats){
            String choice = scanner.nextLine();
            if (choice.equals("add")){
                choice=scanner.nextLine();
                int stat = Integer.parseInt(choice);
                switch (stat){
                    case 1:
                        str = str + 1;
                        count++;
                        pc.setStrength(str);
                        break;
                    case 2:
                        dex = dex + 1;
                        count++;
                        pc.setDexterity(dex);
                        break;
                    case 3:
                        vit = vit + 1;
                        count++;
                        pc.setVitality(vit);
                        break;
                    case 4:
                        intel = intel + 1;
                        count++;
                        pc.setIntelligence(intel);
                        break;
                    case 5:
                        wis = wis + 1;
                        count++;
                        pc.setWisdom(wis);
                        break;
                    default:
                        System.out.println("You typed a false number. please try again, and make sure to type 'add' first.");
                        System.out.println(getStrength());
                }
            } else if (choice.equals("remove")) {
                int stat = scanner.nextInt();
                switch (stat){
                    case 1:
                        if(pc.getStrength()==0){
                            System.out.println("Your Strength is already at 0.");
                        } else {
                            str = str - 1;
                            count--;
                            pc.setStrength(str);
                        }
                        break;
                    case 2:
                        if(pc.getDexterity()==0){
                            System.out.println("Your Dexterity is already at 0.");
                        } else {
                            dex = dex - 1;
                            count--;
                            pc.setDexterity(dex);
                        }
                        break;
                    case 3:
                        if (pc.getVitality()==0){
                            System.out.println("Your Vitality is already at 0.");
                        } else {
                            vit = vit - 1;
                            count--;
                            pc.setVitality(vit);
                        }
                        break;
                    case 4:
                        if (pc.getIntelligence()==0){
                            System.out.println("Your Intelligence is already at 0.");
                        } else {
                            intel = intel - 1;
                            count--;
                            pc.setIntelligence(intel);
                        }
                        break;
                    case 5:
                        if (pc.getWisdom()==0){
                            System.out.println("Your Wisdom is already at 0.");
                        } else {
                            wis = wis - 1;
                            count--;
                            pc.setWisdom(wis);
                        }
                        break;
                    default:
                        System.out.println("You typed a false number. please try again, and make sure to type 'remove' first.");
                }
            } else if (choice.equals("done")) {
                if (count<55){
                    System.out.println("You have not distributed all the available points. Do you wish to end this process?");
                    System.out.println("For 'Yes' type 1, for 'No' type 2.");
                    int yer = scanner.nextInt();
                    if (yer==1) setStats = true;
                    else if (yer==2) {
                        break;
                    } else {
                        System.out.println("The input you provided is incorrect. Please try again.");
                    }
                } else {
                    setStats = true;
                }
            } else if (choice.equals("show")) {
                System.out.println("Your current stats are: ");
                System.out.println("Strength: " + pc.getStrength());
                System.out.println("Dexterity: " + pc.getDexterity());
                System.out.println("Vitality: " + pc.getVitality());
                System.out.println("Intelligence: " + pc.getIntelligence());
                System.out.println("Wisdom: " + pc.getWisdom());
            } else {
                System.out.println("The input you provided is incorrect. Please try again.");
            }
            if (count==55){
                System.out.println("You have distributed all the available points. Your current stats are: ");
                System.out.println("Strength: " + pc.getStrength());
                System.out.println("Dexterity: " + pc.getDexterity());
                System.out.println("Vitality: " + pc.getVitality());
                System.out.println("Intelligence: " + pc.getIntelligence());
                System.out.println("Wisdom: " + pc.getWisdom());
                System.out.println("If you are satisfied with your current stats, type 'done'.");
                String in = scanner.nextLine();
                if (in.equals("done")) setStats = true;
                else System.out.println("The input you provided is incorrect. Please try again.");
            }
        }
    }

    public void setNameGender(PlayableCharacter pc){
        boolean name_check = false;
        boolean gender_check = false;
        System.out.println("Please type your name.");
        Scanner scanner = new Scanner(System.in);
        while (!name_check){
            String name = scanner.nextLine();
            System.out.println("Are you sure you want your name to be " + name + " ?");
            System.out.println("For Yes type 'y', for No type 'n'.");
            String affirm = scanner.nextLine();
            if (affirm.equals("y")){
                name_check = true;
                pc.setName(name);
                System.out.println("Your name is " + pc.getName());
            } else if (affirm.equals("n")) {
                System.out.println("What would you like your name to be?");
            } else {
                System.out.println("You typed the wrong letter. Please enter your name again.");
            }
        }
        System.out.println("Please type your gender.");
        while (!gender_check){
            String gender = scanner.nextLine();
            System.out.println("Are you sure you want your gender to be " + gender + " ?");
            System.out.println("For Yes type 'y', for No type 'n'.");
            String affirm = scanner.nextLine();
            if (affirm.equals("y")){
                gender_check = true;
                pc.setGender(gender);
                System.out.println("Your gender is " + pc.getGender());
            } else if (affirm.equals("n")) {
                System.out.println("What would you like your gender to be?");
            } else {
                System.out.println("You typed the wrong letter. Please enter your gender again.");
            }
        }
    }


    public void setClass(){
        System.out.println("The Game has 4 starting Classes, from which you must choose 1 to start your adventure.");
        int i = 1;
        Set<Map.Entry<Class.classType,String>> classTypes = pc_class.getClasses().entrySet();
        for (Map.Entry<Class.classType,String> classType: classTypes){
            System.out.println(i + ". " + classType.getKey() + ": " + classType.getValue());
            i++;
        }
        System.out.println("Please choose the Class you want by typing the number [1-4] according to the order it was presented.");
        boolean class_check = false;
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
        while (!class_check){
            int class_chosen = scanner.nextInt();
            System.out.println("Are you sure you want your Class to be number " + class_chosen + " ?");
            System.out.println("For Yes type 'y', for No type 'n'.");
            String affirm = scanner1.nextLine();
            if (affirm.equals("y")){
                switch (class_chosen){
                    case 1:
                        pc_class.setName(Class.classType.Knight);
                        break;
                    case 2:
                        pc_class.setName(Class.classType.Barbarian);
                        break;
                    case 3:
                        pc_class.setName(Class.classType.Assassin);
                        break;
                    case 4:
                        pc_class.setName(Class.classType.Wizard);
                        break;
                }
                class_check = true;
                System.out.println("Your Class is " + pc_class.getName());
            } else if (affirm.equals("n")) {
                System.out.println("What would you like your Class to be?");
            } else {
                System.out.println("You typed the wrong number. Please enter your Class again.");
            }
        }
    }

    public void setRace(){
        System.out.println("The Game has 5 starting Races, from which you must choose 1 to start your adventure.");
        int i = 1;
        Set<Map.Entry<Race.raceType,String>> raceTypes = race.getRaces().entrySet();
        for (Map.Entry<Race.raceType,String> raceType: raceTypes){
            System.out.println(i + ". " + raceType.getKey() + ": " + raceType.getValue());
            i++;
        }
        System.out.println("Please choose the Race you want by typing the number [1-5] according to the order it was presented.");
        boolean race_check = false;
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
        while (!race_check){
            int race_chosen = scanner.nextInt();
            System.out.println("Are you sure you want your Race to be number " + race_chosen + " ?");
            System.out.println("For Yes type 'y', for No type 'n'.");
            String affirm = scanner1.nextLine();
            if (affirm.equals("y")){
                switch (race_chosen){
                    case 1:
                        race.setRace(Race.raceType.Human);
                        break;
                    case 2:
                        race.setRace(Race.raceType.Elf);
                        break;
                    case 3:
                        race.setRace(Race.raceType.Dwarf);
                        break;
                    case 4:
                        race.setRace(Race.raceType.Halfling);
                        break;
                    case 5:
                        race.setRace(Race.raceType.Ork);
                        break;
                }
                race_check = true;
                System.out.println("Your Race is " + race.getRace());
            } else if (affirm.equals("n")) {
                System.out.println("What would you like your Race to be?");
            } else {
                System.out.println("You typed the wrong number. Please enter your Race again.");
            }
        }
    }

    public void setEquipment(Class.classType type){
        System.out.println("The Class you have chosen comes with two sets of armor.");
        System.out.println("You must choose one of the two to start your adventure.");
        pc_class.getStartingEquipment(type);
        System.out.println("Type 1 for set1 and 2 for set2.");
        boolean armor_check = false;
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
        while (!armor_check){
            int armor_chosen = scanner.nextInt();
            System.out.println("Are you sure you want set number " + armor_chosen + " ?");
            System.out.println("For Yes type 'y', for No type 'n'.");
            String affirm = scanner1.nextLine();
            if (affirm.equals("y")){
                switch (type){
                    case Knight:
                        if (armor_chosen==1) {
                            currentEquipment.setHead(pc_class.getKnightSet1().get(0));
                            currentEquipment.setChest(pc_class.getKnightSet1().get(1));
                            currentEquipment.setHands(pc_class.getKnightSet1().get(2));
                            currentEquipment.setLegs(pc_class.getKnightSet1().get(3));
                            inventory.addItemToInventory(pc_class.getKnightSet1().get(0));
                            inventory.addItemToInventory(pc_class.getKnightSet1().get(1));
                            inventory.addItemToInventory(pc_class.getKnightSet1().get(2));
                            inventory.addItemToInventory(pc_class.getKnightSet1().get(3));
                        } else if (armor_chosen==2) {
                            currentEquipment.setHead(pc_class.getKnightSet2().get(0));
                            currentEquipment.setChest(pc_class.getKnightSet2().get(1));
                            currentEquipment.setHands(pc_class.getKnightSet2().get(2));
                            currentEquipment.setLegs(pc_class.getKnightSet2().get(3));
                            inventory.addItemToInventory(pc_class.getKnightSet2().get(0));
                            inventory.addItemToInventory(pc_class.getKnightSet2().get(1));
                            inventory.addItemToInventory(pc_class.getKnightSet2().get(2));
                            inventory.addItemToInventory(pc_class.getKnightSet2().get(3));
                        }
                        break;
                    case Barbarian:
                        if (armor_chosen==1) {
                            currentEquipment.setHead(pc_class.getBarbarianSet1().get(0));
                            currentEquipment.setChest(pc_class.getBarbarianSet1().get(1));
                            currentEquipment.setHands(pc_class.getBarbarianSet1().get(2));
                            currentEquipment.setLegs(pc_class.getBarbarianSet1().get(3));
                            inventory.addItemToInventory(pc_class.getBarbarianSet1().get(0));
                            inventory.addItemToInventory(pc_class.getBarbarianSet1().get(1));
                            inventory.addItemToInventory(pc_class.getBarbarianSet1().get(2));
                            inventory.addItemToInventory(pc_class.getBarbarianSet1().get(3));
                        } else if (armor_chosen==2) {
                            currentEquipment.setHead(pc_class.getBarbarianSet2().get(0));
                            currentEquipment.setChest(pc_class.getBarbarianSet2().get(1));
                            currentEquipment.setHands(pc_class.getBarbarianSet2().get(2));
                            currentEquipment.setLegs(pc_class.getBarbarianSet2().get(3));
                            inventory.addItemToInventory(pc_class.getBarbarianSet2().get(0));
                            inventory.addItemToInventory(pc_class.getBarbarianSet2().get(1));
                            inventory.addItemToInventory(pc_class.getBarbarianSet2().get(2));
                            inventory.addItemToInventory(pc_class.getBarbarianSet2().get(3));
                        }
                        break;
                    case Assassin:
                        if (armor_chosen==1) {
                            currentEquipment.setHead(pc_class.getAssassinSet1().get(0));
                            currentEquipment.setChest(pc_class.getAssassinSet1().get(1));
                            currentEquipment.setHands(pc_class.getAssassinSet1().get(2));
                            currentEquipment.setLegs(pc_class.getAssassinSet1().get(3));
                            inventory.addItemToInventory(pc_class.getAssassinSet1().get(0));
                            inventory.addItemToInventory(pc_class.getAssassinSet1().get(1));
                            inventory.addItemToInventory(pc_class.getAssassinSet1().get(2));
                            inventory.addItemToInventory(pc_class.getAssassinSet1().get(3));
                        } else if (armor_chosen==2) {
                            currentEquipment.setHead(pc_class.getAssassinSet2().get(0));
                            currentEquipment.setChest(pc_class.getAssassinSet2().get(1));
                            currentEquipment.setHands(pc_class.getAssassinSet2().get(2));
                            currentEquipment.setLegs(pc_class.getAssassinSet2().get(3));
                            inventory.addItemToInventory(pc_class.getAssassinSet2().get(0));
                            inventory.addItemToInventory(pc_class.getAssassinSet2().get(1));
                            inventory.addItemToInventory(pc_class.getAssassinSet2().get(2));
                            inventory.addItemToInventory(pc_class.getAssassinSet2().get(3));
                        }
                        break;
                    case Wizard:
                        if (armor_chosen==1) {
                            currentEquipment.setHead(pc_class.getWizardSet1().get(0));
                            currentEquipment.setChest(pc_class.getWizardSet1().get(1));
                            currentEquipment.setHands(pc_class.getWizardSet1().get(2));
                            currentEquipment.setLegs(pc_class.getWizardSet1().get(3));
                            inventory.addItemToInventory(pc_class.getWizardSet1().get(0));
                            inventory.addItemToInventory(pc_class.getWizardSet1().get(1));
                            inventory.addItemToInventory(pc_class.getWizardSet1().get(2));
                            inventory.addItemToInventory(pc_class.getWizardSet1().get(3));
                        } else if (armor_chosen==2) {
                            currentEquipment.setHead(pc_class.getWizardSet2().get(0));
                            currentEquipment.setChest(pc_class.getWizardSet2().get(1));
                            currentEquipment.setHands(pc_class.getWizardSet2().get(2));
                            currentEquipment.setLegs(pc_class.getWizardSet2().get(3));
                            inventory.addItemToInventory(pc_class.getWizardSet2().get(0));
                            inventory.addItemToInventory(pc_class.getWizardSet2().get(1));
                            inventory.addItemToInventory(pc_class.getWizardSet2().get(2));
                            inventory.addItemToInventory(pc_class.getWizardSet2().get(3));
                        }
                        break;
                }
                armor_check = true;
                System.out.println("Your Armor set is " + currentEquipment.getCurrentArmor());
            } else if (affirm.equals("n")) {
                System.out.println("Which armor set do you prefer?");
            } else {
                System.out.println("You typed the wrong number. Please enter your preferred armor set again.");
            }
        }
        System.out.println("Now you must choose your weapons according to your class.");
        System.out.println("Each class has 4 starting weapons. You must choose 2.");
        pc_class.getStartWeap(type);
        System.out.println("Type the number associated with the first weapon of your choice.");
        boolean weap1_check = false;
        int weap1_chosen = scanner.nextInt();
        while (!weap1_check){
            System.out.println("Are you sure you want the weapon number " + weap1_chosen + " ?");
            System.out.println("For Yes type 'y', for No type 'n'.");
            String affirm = scanner1.nextLine();
            if (affirm.equals("y")){
                switch (type){
                    case Knight:
                        if (weap1_chosen==1) {
                            currentEquipment.setRightWeapon(pc_class.getKnightWeapons().get(0));
                            inventory.addItemToInventory(pc_class.getKnightWeapons().get(0));
                        } else if (weap1_chosen==2) {
                            currentEquipment.setRightWeapon(pc_class.getKnightWeapons().get(1));
                            inventory.addItemToInventory(pc_class.getKnightWeapons().get(1));
                        } else if (weap1_chosen==3) {
                            currentEquipment.setRightWeapon(pc_class.getKnightWeapons().get(2));
                            inventory.addItemToInventory(pc_class.getKnightWeapons().get(2));
                        } else if (weap1_chosen==4) {
                            currentEquipment.setRightWeapon(pc_class.getKnightWeapons().get(3));
                            inventory.addItemToInventory(pc_class.getKnightWeapons().get(3));
                        }
                        break;
                    case Barbarian:
                        if (weap1_chosen==1) {
                            currentEquipment.setRightWeapon(pc_class.getBarbarianWeapons().get(0));
                            inventory.addItemToInventory(pc_class.getBarbarianWeapons().get(0));
                        } else if (weap1_chosen==2) {
                            currentEquipment.setRightWeapon(pc_class.getBarbarianWeapons().get(1));
                            inventory.addItemToInventory(pc_class.getBarbarianWeapons().get(1));
                        } else if (weap1_chosen==3) {
                            currentEquipment.setRightWeapon(pc_class.getBarbarianWeapons().get(2));
                            inventory.addItemToInventory(pc_class.getBarbarianWeapons().get(2));
                        } else if (weap1_chosen==4) {
                            currentEquipment.setRightWeapon(pc_class.getBarbarianWeapons().get(3));
                            inventory.addItemToInventory(pc_class.getBarbarianWeapons().get(3));
                        }
                        break;
                    case Assassin:
                        if (weap1_chosen==1) {
                            currentEquipment.setRightWeapon(pc_class.getAssassinWeapons().get(0));
                            inventory.addItemToInventory(pc_class.getAssassinWeapons().get(0));
                        } else if (weap1_chosen==2) {
                            currentEquipment.setRightWeapon(pc_class.getAssassinWeapons().get(1));
                            inventory.addItemToInventory(pc_class.getAssassinWeapons().get(1));
                        } else if (weap1_chosen==3) {
                            currentEquipment.setRightWeapon(pc_class.getAssassinWeapons().get(2));
                            inventory.addItemToInventory(pc_class.getAssassinWeapons().get(2));
                        } else if (weap1_chosen==4) {
                            currentEquipment.setRightWeapon(pc_class.getAssassinWeapons().get(3));
                            inventory.addItemToInventory(pc_class.getAssassinWeapons().get(3));
                        }
                        break;
                    case Wizard:
                        if (weap1_chosen==1) {
                            currentEquipment.setRightWeapon(pc_class.getWizardWeapons().get(0));
                            inventory.addItemToInventory(pc_class.getWizardWeapons().get(0));
                        } else if (weap1_chosen==2) {
                            currentEquipment.setRightWeapon(pc_class.getWizardWeapons().get(1));
                            inventory.addItemToInventory(pc_class.getWizardWeapons().get(1));
                        } else if (weap1_chosen==3) {
                            currentEquipment.setRightWeapon(pc_class.getWizardWeapons().get(2));
                            inventory.addItemToInventory(pc_class.getWizardWeapons().get(2));
                        } else if (weap1_chosen==4) {
                            currentEquipment.setRightWeapon(pc_class.getWizardWeapons().get(3));
                            inventory.addItemToInventory(pc_class.getWizardWeapons().get(3));
                        }
                        break;
                }
                weap1_check = true;
                System.out.println("Your right hand weapon is " + currentEquipment.getRightWeapon());
            } else if (affirm.equals("n")) {
                System.out.println("Which weapon do you prefer?");
            } else {
                System.out.println("You typed the wrong number. Please enter your preferred weapon again.");
            }
        }
        System.out.println("Type the number associated with the second weapon of your choice.");
        boolean weap2_check = false;
        int weap2_chosen = scanner.nextInt();
        while (!weap2_check){
            if (weap2_chosen == weap1_chosen){
                System.out.println("You cannot choose the same weapon twice. Please choose another weapon as your second.");
            } else {
                System.out.println("Are you sure you want the weapon number " + weap2_chosen + " ?");
                System.out.println("For Yes type 'y', for No type 'n'.");
                String affirm = scanner1.nextLine();
                if (affirm.equals("y")){
                    switch (type){
                        case Knight:
                            if (weap2_chosen==1 && weap2_chosen != weap1_chosen) {
                                currentEquipment.setLeftWeapon(pc_class.getKnightWeapons().get(0));
                                inventory.addItemToInventory(pc_class.getKnightWeapons().get(0));
                            } else if (weap2_chosen==2 && weap2_chosen != weap1_chosen) {
                                currentEquipment.setLeftWeapon(pc_class.getKnightWeapons().get(1));
                                inventory.addItemToInventory(pc_class.getKnightWeapons().get(1));
                            } else if (weap2_chosen==3 && weap2_chosen != weap1_chosen) {
                                currentEquipment.setLeftWeapon(pc_class.getKnightWeapons().get(2));
                                inventory.addItemToInventory(pc_class.getKnightWeapons().get(2));
                            } else if (weap2_chosen==4 && weap2_chosen != weap1_chosen) {
                                currentEquipment.setLeftWeapon(pc_class.getKnightWeapons().get(3));
                                inventory.addItemToInventory(pc_class.getKnightWeapons().get(3));
                            }
                            break;
                        case Barbarian:
                            if (weap2_chosen==1 && weap2_chosen != weap1_chosen) {
                                currentEquipment.setLeftWeapon(pc_class.getBarbarianWeapons().get(0));
                                inventory.addItemToInventory(pc_class.getBarbarianWeapons().get(0));
                            } else if (weap2_chosen==2 && weap2_chosen != weap1_chosen) {
                                currentEquipment.setLeftWeapon(pc_class.getBarbarianWeapons().get(1));
                                inventory.addItemToInventory(pc_class.getBarbarianWeapons().get(1));
                            } else if (weap2_chosen==3 && weap2_chosen != weap1_chosen) {
                                currentEquipment.setLeftWeapon(pc_class.getBarbarianWeapons().get(2));
                                inventory.addItemToInventory(pc_class.getBarbarianWeapons().get(2));
                            } else if (weap2_chosen==4 && weap2_chosen != weap1_chosen) {
                                currentEquipment.setLeftWeapon(pc_class.getBarbarianWeapons().get(3));
                                inventory.addItemToInventory(pc_class.getBarbarianWeapons().get(3));
                            }
                            break;
                        case Assassin:
                            if (weap2_chosen==1 && weap2_chosen != weap1_chosen) {
                                currentEquipment.setLeftWeapon(pc_class.getAssassinWeapons().get(0));
                                inventory.addItemToInventory(pc_class.getAssassinWeapons().get(0));
                            } else if (weap2_chosen==2 && weap2_chosen != weap1_chosen) {
                                currentEquipment.setLeftWeapon(pc_class.getAssassinWeapons().get(1));
                                inventory.addItemToInventory(pc_class.getAssassinWeapons().get(1));
                            } else if (weap2_chosen==3 && weap2_chosen != weap1_chosen) {
                                currentEquipment.setLeftWeapon(pc_class.getAssassinWeapons().get(2));
                                inventory.addItemToInventory(pc_class.getAssassinWeapons().get(2));
                            } else if (weap2_chosen==4 && weap2_chosen != weap1_chosen) {
                                currentEquipment.setLeftWeapon(pc_class.getAssassinWeapons().get(3));
                                inventory.addItemToInventory(pc_class.getAssassinWeapons().get(3));
                            }
                            break;
                        case Wizard:
                            if (weap2_chosen==1 && weap2_chosen != weap1_chosen) {
                                currentEquipment.setLeftWeapon(pc_class.getWizardWeapons().get(0));
                                inventory.addItemToInventory(pc_class.getWizardWeapons().get(0));
                            } else if (weap2_chosen==2 && weap2_chosen != weap1_chosen) {
                                currentEquipment.setLeftWeapon(pc_class.getWizardWeapons().get(1));
                                inventory.addItemToInventory(pc_class.getWizardWeapons().get(1));
                            } else if (weap2_chosen==3 && weap2_chosen != weap1_chosen) {
                                currentEquipment.setLeftWeapon(pc_class.getWizardWeapons().get(2));
                                inventory.addItemToInventory(pc_class.getWizardWeapons().get(2));
                            } else if (weap2_chosen==4 && weap2_chosen != weap1_chosen) {
                                currentEquipment.setLeftWeapon(pc_class.getWizardWeapons().get(3));
                                inventory.addItemToInventory(pc_class.getWizardWeapons().get(3));
                            }
                            break;
                    }
                    weap2_check = true;
                    System.out.println("Your left hand weapon is " + currentEquipment.getLeftWeapon());
                } else if (affirm.equals("n")) {
                    System.out.println("Which weapon do you prefer?");
                } else {
                    System.out.println("You typed the wrong number. Please enter your preferred weapon again.");
                }
            }
        }
    }

    public void setAbility(Race.raceType type){
        System.out.println("The Race you have chosen comes with two abilities.");
        System.out.println("You must choose one of the two to start your adventure.");
        race.getAvailableAbilities(type);
        System.out.println("Type 1 for the first ability and 2 for the second ability.");
        boolean ability_check = false;
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1  =new Scanner(System.in);
        while (!ability_check){
            int ab_chosen = scanner.nextInt();
            System.out.println("Are you sure you want your Ability to be number " + ab_chosen + " ?");
            System.out.println("For Yes type 'y', for No type 'n'.");
            String affirm = scanner1.nextLine();
            if (affirm.equals("y")){
                switch (type){
                    case Human:
                        if(ab_chosen==1){
                            if (race.getHumanAbilities().get(1).getAbilityModType()== Ability.AbilityModType.INT){
                                int intel = getIntelligence();
                                setIntelligence(intel + 1);
                            } else if (race.getHumanAbilities().get(1).getAbilityModType()== Ability.AbilityModType.WIS) {
                                int wis = getWisdom();
                                setWisdom(wis + 1);
                            } else if (race.getHumanAbilities().get(1).getAbilityModType()== Ability.AbilityModType.STR) {
                                int str = getStrength();
                                setStrength(str + 1);
                            } else if (race.getHumanAbilities().get(1).getAbilityModType()== Ability.AbilityModType.DEX) {
                                int dex = getDexterity();
                                setDexterity(dex + 1);
                            } else if (race.getHumanAbilities().get(1).getAbilityModType()== Ability.AbilityModType.VIT) {
                                int vit = getVitality();
                                setVitality(vit + 1);
                            }
                        } else if (ab_chosen==2) {
                            if (race.getHumanAbilities().get(2).getAbilityModType()== Ability.AbilityModType.INT){
                                int intel = getIntelligence();
                                setIntelligence(intel + 1);
                            } else if (race.getHumanAbilities().get(2).getAbilityModType()== Ability.AbilityModType.WIS) {
                                int wis = getWisdom();
                                setWisdom(wis + 1);
                            } else if (race.getHumanAbilities().get(2).getAbilityModType()== Ability.AbilityModType.STR) {
                                int str = getStrength();
                                setStrength(str + 1);
                            } else if (race.getHumanAbilities().get(2).getAbilityModType()== Ability.AbilityModType.DEX) {
                                int dex = getDexterity();
                                setDexterity(dex + 1);
                            } else if (race.getHumanAbilities().get(2).getAbilityModType()== Ability.AbilityModType.VIT) {
                                int vit = getVitality();
                                setVitality(vit + 1);
                            }
                        }
                        break;
                    case Elf:
                        if(ab_chosen==1){
                            if (race.getElfAbilities().get(1).getAbilityModType()== Ability.AbilityModType.INT){
                                int intel = getIntelligence();
                                setIntelligence(intel + 1);
                            } else if (race.getElfAbilities().get(1).getAbilityModType()== Ability.AbilityModType.WIS) {
                                int wis = getWisdom();
                                setWisdom(wis + 1);
                            } else if (race.getElfAbilities().get(1).getAbilityModType()== Ability.AbilityModType.STR) {
                                int str = getStrength();
                                setStrength(str + 1);
                            } else if (race.getElfAbilities().get(1).getAbilityModType()== Ability.AbilityModType.DEX) {
                                int dex = getDexterity();
                                setDexterity(dex + 1);
                            } else if (race.getElfAbilities().get(1).getAbilityModType()== Ability.AbilityModType.VIT) {
                                int vit = getVitality();
                                setVitality(vit + 1);
                            }
                        } else if (ab_chosen==2) {
                            if (race.getElfAbilities().get(2).getAbilityModType()== Ability.AbilityModType.INT){
                                int intel = getIntelligence();
                                setIntelligence(intel + 1);
                            } else if (race.getElfAbilities().get(2).getAbilityModType()== Ability.AbilityModType.WIS) {
                                int wis = getWisdom();
                                setWisdom(wis + 1);
                            } else if (race.getElfAbilities().get(2).getAbilityModType()== Ability.AbilityModType.STR) {
                                int str = getStrength();
                                setStrength(str + 1);
                            } else if (race.getElfAbilities().get(2).getAbilityModType()== Ability.AbilityModType.DEX) {
                                int dex = getDexterity();
                                setDexterity(dex + 1);
                            } else if (race.getElfAbilities().get(2).getAbilityModType()== Ability.AbilityModType.VIT) {
                                int vit = getVitality();
                                setVitality(vit + 1);
                            }
                        }
                        break;
                    case Dwarf:
                        if(ab_chosen==1){
                            if (race.getDwarfAbilities().get(1).getAbilityModType()== Ability.AbilityModType.INT){
                                int intel = getIntelligence();
                                setIntelligence(intel + 1);
                            } else if (race.getDwarfAbilities().get(1).getAbilityModType()== Ability.AbilityModType.WIS) {
                                int wis = getWisdom();
                                setWisdom(wis + 1);
                            } else if (race.getDwarfAbilities().get(1).getAbilityModType()== Ability.AbilityModType.STR) {
                                int str = getStrength();
                                setStrength(str + 1);
                            } else if (race.getDwarfAbilities().get(1).getAbilityModType()== Ability.AbilityModType.DEX) {
                                int dex = getDexterity();
                                setDexterity(dex + 1);
                            } else if (race.getDwarfAbilities().get(1).getAbilityModType()== Ability.AbilityModType.VIT) {
                                int vit = getVitality();
                                setVitality(vit + 1);
                            }
                        } else if (ab_chosen==2) {
                            if (race.getDwarfAbilities().get(2).getAbilityModType()== Ability.AbilityModType.INT){
                                int intel = getIntelligence();
                                setIntelligence(intel + 1);
                            } else if (race.getDwarfAbilities().get(2).getAbilityModType()== Ability.AbilityModType.WIS) {
                                int wis = getWisdom();
                                setWisdom(wis + 1);
                            } else if (race.getDwarfAbilities().get(2).getAbilityModType()== Ability.AbilityModType.STR) {
                                int str = getStrength();
                                setStrength(str + 1);
                            } else if (race.getDwarfAbilities().get(2).getAbilityModType()== Ability.AbilityModType.DEX) {
                                int dex = getDexterity();
                                setDexterity(dex + 1);
                            } else if (race.getDwarfAbilities().get(2).getAbilityModType()== Ability.AbilityModType.VIT) {
                                int vit = getVitality();
                                setVitality(vit + 1);
                            }
                        }
                        break;
                    case Halfling:
                        if(ab_chosen==1){
                            if (race.getHalflingAbilities().get(1).getAbilityModType()== Ability.AbilityModType.INT){
                                int intel = getIntelligence();
                                setIntelligence(intel + 1);
                            } else if (race.getHalflingAbilities().get(1).getAbilityModType()== Ability.AbilityModType.WIS) {
                                int wis = getWisdom();
                                setWisdom(wis + 1);
                            } else if (race.getHalflingAbilities().get(1).getAbilityModType()== Ability.AbilityModType.STR) {
                                int str = getStrength();
                                setStrength(str + 1);
                            } else if (race.getHalflingAbilities().get(1).getAbilityModType()== Ability.AbilityModType.DEX) {
                                int dex = getDexterity();
                                setDexterity(dex + 1);
                            } else if (race.getHalflingAbilities().get(1).getAbilityModType()== Ability.AbilityModType.VIT) {
                                int vit = getVitality();
                                setVitality(vit + 1);
                            }
                        } else if (ab_chosen==2) {
                            if (race.getHalflingAbilities().get(2).getAbilityModType()== Ability.AbilityModType.INT){
                                int intel = getIntelligence();
                                setIntelligence(intel + 1);
                            } else if (race.getHalflingAbilities().get(2).getAbilityModType()== Ability.AbilityModType.WIS) {
                                int wis = getWisdom();
                                setWisdom(wis + 1);
                            } else if (race.getHalflingAbilities().get(2).getAbilityModType()== Ability.AbilityModType.STR) {
                                int str = getStrength();
                                setStrength(str + 1);
                            } else if (race.getHalflingAbilities().get(2).getAbilityModType()== Ability.AbilityModType.DEX) {
                                int dex = getDexterity();
                                setDexterity(dex + 1);
                            } else if (race.getHalflingAbilities().get(2).getAbilityModType()== Ability.AbilityModType.VIT) {
                                int vit = getVitality();
                                setVitality(vit + 1);
                            }
                        }
                        break;
                    case Ork:
                        if(ab_chosen==1){
                            if (race.getOrkAbilities().get(1).getAbilityModType()== Ability.AbilityModType.INT){
                                int intel = getIntelligence();
                                setIntelligence(intel + 1);
                            } else if (race.getOrkAbilities().get(1).getAbilityModType()== Ability.AbilityModType.WIS) {
                                int wis = getWisdom();
                                setWisdom(wis + 1);
                            } else if (race.getOrkAbilities().get(1).getAbilityModType()== Ability.AbilityModType.STR) {
                                int str = getStrength();
                                setStrength(str + 1);
                            } else if (race.getOrkAbilities().get(1).getAbilityModType()== Ability.AbilityModType.DEX) {
                                int dex = getDexterity();
                                setDexterity(dex + 1);
                            } else if (race.getOrkAbilities().get(1).getAbilityModType()== Ability.AbilityModType.VIT) {
                                int vit = getVitality();
                                setVitality(vit + 1);
                            }
                        } else if (ab_chosen==2) {
                            if (race.getOrkAbilities().get(2).getAbilityModType()== Ability.AbilityModType.INT){
                                int intel = getIntelligence();
                                setIntelligence(intel + 1);
                            } else if (race.getOrkAbilities().get(2).getAbilityModType()== Ability.AbilityModType.WIS) {
                                int wis = getWisdom();
                                setWisdom(wis + 1);
                            } else if (race.getOrkAbilities().get(2).getAbilityModType()== Ability.AbilityModType.STR) {
                                int str = getStrength();
                                setStrength(str + 1);
                            } else if (race.getOrkAbilities().get(2).getAbilityModType()== Ability.AbilityModType.DEX) {
                                int dex = getDexterity();
                                setDexterity(dex + 1);
                            } else if (race.getOrkAbilities().get(2).getAbilityModType()== Ability.AbilityModType.VIT) {
                                int vit = getVitality();
                                setVitality(vit + 1);
                            }
                        }
                        break;
                }
                ability_check = true;
                System.out.println("Your Ability is set.");
            } else if (affirm.equals("n")) {
                System.out.println("What would you like your Ability to be?");
            } else {
                System.out.println("You typed the wrong number. Please enter your Ability again.");
            }
        }
    }

    public void createCharacter(PlayableCharacter pc){
        setNameGender(pc);
        setBaseStats(pc);
        setClass();
        setEquipment(pc_class.getName());
        setRace();
        setAbility(race.getRace());
        System.out.println("Would you like to finalize your creation?");
        System.out.println("For Yes type 'y', for No type 'n'.");
        Scanner scanner = new Scanner(System.in);
        String affirm = scanner.nextLine();
        if (affirm.equals("y")){
            System.out.println("Have a wonderful adventure.");
        } else if (affirm.equals("n")) {
            System.out.println("Close the game, and when you open it again select 'New Game'.");
        }
    }

}
