import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Scanner;

public class Combat {
    private boolean turn;
    private double block = 0;
    private boolean chosenBlock;
    private double dodge = 0;
    private boolean chosenDodge;
    private double attackDamage = 0;
    private int finalDamage = 0;
    private Inventory inventory;
    SpellSlot spellSlot;
    Map<String, Integer> playerStats;
    Map<String, Integer> enemyStats;
    Map<Enemy.Type,Double> enemyInfo;

    public Combat() {

    }

    public boolean isTurn() {
        return turn;
    }

    public void setTurn(boolean turn) {
        this.turn = turn;
    }

    public void compareLevel(PlayableCharacter pc, Enemy enemy){
        if(enemy.getLevel() >= pc.getLevel()){
            this.turn = true;
        } else {
            this.turn = false;
        }
    }

    public void chooseDodge(PlayableCharacter pc){
        double dexMod = (double) pc.getDexterity();
        double equipLoad = pc.getEquipLoad();
        double totalWeight = pc.getCurrentEquipment().totalWeight();
        int equipLoadMod = 0;
        if(totalWeight/equipLoad<3.3){
            equipLoadMod = 1;
        } else if (totalWeight/equipLoad<6.6 && totalWeight/equipLoad>3.3) {
            equipLoadMod = 0;
        } else if (totalWeight/equipLoad>6.6) {
            equipLoadMod = -1;
        }
        this.dodge = (dexMod+(double) equipLoadMod)/100;
        this.chosenDodge = true;
        this.chosenBlock = false;
    }

    public void chooseBlock(PlayableCharacter pc){
        if(pc.getCurrentEquipment().hasShield()==true){
            this.block = pc.getCurrentEquipment().getShieldDefence();
            this.chosenBlock = true;
            this.chosenDodge = false;
        }
    }

    public void chooseAttack(PlayableCharacter pc){
        int i = 1;
        Scanner attack = new Scanner(System.in);
        System.out.println("Your available attacks are: ");
        System.out.println(i + ". " + pc.getCurrentEquipment().getRightWeapon());
        i++;
        System.out.println(i+ ". " + pc.getCurrentEquipment().getLeftWeapon());
        for(Spell spell: spellSlot.getSpellSlots()){
            i++;
            System.out.println(i+ ", " + spellSlot.getSpellSlots().get(i-3));
        }
        System.out.println("Choose your attack!");
        int attackChosen = attack.nextInt();
        switch (attackChosen){
            case 1:
                this.attackDamage = pc.getPlayerStatus().totalDamage(pc.getCurrentEquipment().getRightWeapon());
                break;
            case 2:
                this.attackDamage = pc.getPlayerStatus().totalDamage(pc.getCurrentEquipment().getLeftWeapon());
                break;
            case 3:
                this.attackDamage = spellSlot.totalSpellDamage(spellSlot.getSpellSlots().get(0));
                break;
            case 4:
                this.attackDamage = spellSlot.totalSpellDamage(spellSlot.getSpellSlots().get(1));
                break;
            case 5:
                this.attackDamage = spellSlot.totalSpellDamage(spellSlot.getSpellSlots().get(2));
                break;
            case 6:
                this.attackDamage = spellSlot.totalSpellDamage(spellSlot.getSpellSlots().get(3));
                break;
        }
    }

    public void calcPlayerDamage(PlayableCharacter pc, Enemy enemy){
        double resistMod=0;
        double weakMod=0;
        int i=0;
        for(Spell spell: spellSlot.getSpellSlots()) {
            if (enemy.getResistance().equals(pc.getCurrentEquipment().getRightWeapon().getDamageType()) || enemy.getResistance().equals(spellSlot.getSpellSlots().get(i).getDamageType())) {
                resistMod = enemy.getResistMod();
            } else if (enemy.getWeakness().equals(pc.getCurrentEquipment().getLeftWeapon().getDamageType()) || enemy.getWeakness().equals(spellSlot.getSpellSlots().get(i).getDamageType())) {
                weakMod = enemy.getWeakMod();
            }
            i++;
        }
        this.finalDamage = (int) (attackDamage + attackDamage*weakMod - attackDamage*resistMod);
    }

    public void calcEnemyDamage(PlayableCharacter pc,Enemy enemy){
        if (chosenDodge==true){
            Random rand = new Random();
            double rand_doub = rand.nextDouble();
            if (rand_doub<=dodge){
                this.finalDamage= 0;
                System.out.println("You successfully dodged the enemy attack!");
            } else {
                this.finalDamage = (int)(enemy.getEnemyAttack() - (enemy.getEnemyAttack() * (pc.getDefenceModifier()/10)));
            }
        } else if (chosenBlock==true) {
            this.finalDamage = (int)(enemy.getEnemyAttack() - (enemy.getEnemyAttack() * (block + pc.getDefenceModifier()/10)));
        }
    }

    private void acquireLoot(Enemy enemy){
        Random rand = new Random();
        int rand_int = rand.nextInt(100);
        if (enemy.getLoot().getMinDropRateValue()<=rand_int || rand_int<=enemy.getLoot().getMaxDropRateValue()){
            System.out.println("The enemy has left behind the following loot: ");
            System.out.println("Name: " + enemy.getLoot().getName());
            System.out.println("Description: " + enemy.getLoot().getDescription());
            System.out.println("Rarity: " + enemy.getLoot().getRarity());
            System.out.println("Would you like to pick it up: Yes(1) or No(2)");
            Scanner scanner = new Scanner(System.in);
            int loot = scanner.nextInt();
            if (loot==1){
                inventory.addItemToInventory(enemy.getLoot());
            }

        }
    }

    public void reduceHP(Character obj){
        int newHP;
        if ((obj.getHp()-finalDamage)>=0){
            newHP = obj.getHp()-finalDamage;
        } else {
            newHP = 0;
        }
        obj.setHp(newHP);
    }

    public void changeTurn(){
        if(turn) this.turn = false;
        else this.turn = true;
    }
    public void triggerCombat(PlayableCharacter pc, Enemy enemy){
        playerStats = new HashMap<>(pc.getPlayerStats());
        enemyStats = new HashMap<>(enemy.getEnemyStats());
        enemyInfo = new HashMap<Enemy.Type, Double>(enemy.getEnemyInfo(enemy.isFacedBefore()));
        System.out.println("Player name and HP: " + playerStats);
        System.out.println("Enemy name and HP: " + enemyStats);
        if(enemy.isFacedBefore()==true){
            for (Entry<String, Integer> entry: enemyStats.entrySet()){
                System.out.println("Resistance: " + entry.getKey() + " Modifier: " + entry.getValue());
            }
        }
        compareLevel(pc,enemy);
        while (pc.checkIfAlive(pc) == true && enemy.checkIfAlive(enemy) == true){
            if (turn){
                System.out.println("It is the Enemy's turn");
                System.out.println("Choose how you want to defend yourself");
                System.out.println("1. Block");
                System.out.println("2. Dodge");
                Scanner scanner = new Scanner(System.in);
                int choice = scanner.nextInt();
                if (choice==1){
                    chooseBlock(pc);
                } else if (choice==2){
                    chooseDodge(pc);
                }
                calcEnemyDamage(pc,enemy);
                System.out.println("You take " + finalDamage + " Damage");
                reduceHP(pc);
                System.out.println("Your remaining HP is: " + pc.getHp());
                pc.checkIfAlive(pc);
                changeTurn();
            } else if (!turn) {
                System.out.println("It is your turn");
                chooseAttack(pc);
                calcPlayerDamage(pc, enemy);
                System.out.println("You deal " + finalDamage + " Damage");
                reduceHP(enemy);
                System.out.println("The Enemy's remaining Hp is: " + enemy.getHp());
                enemy.checkIfAlive(enemy);
                changeTurn();
            }
        }
        if(!(pc.checkIfAlive(pc))){
            System.out.println("YOU DIED");
            pc.setHp(pc.getMaxHP());
            //resting point
        }else if (!(enemy.checkIfAlive(enemy))){
            System.out.println("ENEMY FELLED");
            acquireLoot(enemy);
        }
        enemy.setHp(enemy.getMaxHP());
    }
}


