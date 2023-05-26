import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Combat {
    private boolean turn;
    private double block = 0;
    private boolean chosenBlock;
    private double dodge = 0;
    private boolean chosenDodge;
    private double attackDamage = 0;
    private int finalDamage = 0;

    PlayerStatus playerStatus;
    Enemy enemy;
    SpellSlot spellSlot;
    Map<String, Integer> playerStats;
    Map<String, Integer> enemyStats;
    Map<Enemy.Type,Double> enemyInfo;

    public Combat() {
        playerStats = new HashMap<>(playerStatus.player.getPlayerStats());
        enemyStats = new HashMap<>(enemy.getEnemyStats());
        enemyInfo = new HashMap<Enemy.Type, Double>(enemy.getEnemyInfo(enemy.isFacedBefore()));
        System.out.println("Player name and HP: " + playerStats);
        System.out.println("Enemy name and HP: " + enemyStats);
        if(enemy.isFacedBefore()==true){
            for (Entry<String, Integer> entry: enemyStats.entrySet()){
                System.out.println("Resistance: " + entry.getKey() + " Modifier: " + entry.getValue());
            }
        }
    }

    public boolean isTurn() {
        return turn;
    }

    public void setTurn(boolean turn) {
        this.turn = turn;
    }

    public void compareLevel(boolean turn){
        if(enemy.getLevel()== playerStatus.player.getLevel()){
            this.turn = true;
        } else {
            this.turn = false;
        }
    }

    public void chooseDodge(){
        double dexMod = (double) playerStatus.player.getDexterity();
        double equipLoad = playerStatus.player.getEquipLoad();
        double totalWeight = playerStatus.equipment.totalWeight();
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

    public void chooseBlock(){
        if(playerStatus.equipment.hasShield()==true){
            this.block = playerStatus.equipment.getShieldDefence();
            this.chosenBlock = true;
            this.chosenDodge = false;
        }
    }

    public void chooseAttack(){
        int i = 1;
        Scanner attack = new Scanner(System.in);
        System.out.println("Your available attacks are: ");
        System.out.println(i + ". " + playerStatus.equipment.getRightWeapon());
        i++;
        System.out.println(i+ ". " + playerStatus.equipment.getLeftWeapon());
        for(Spell spell: spellSlot.getSpellSlots()){
            i++;
            System.out.println(i+ ", " + spellSlot.getSpellSlots().get(i-3));
        }
        System.out.println("Choose your attack!");
        int attackChosen = attack.nextInt();
        switch (attackChosen){
            case 1:
                this.attackDamage = playerStatus.totalDamage(playerStatus.equipment.rightWeapon);
                break;
            case 2:
                this.attackDamage = playerStatus.totalDamage(playerStatus.equipment.leftWeapon);
                break;
            case 3:
                this.attackDamage = spellSlot.getSpellSlots().get(0).totalSpellDamage(spellSlot.getSpellSlots().get(0));
                break;
            case 4:
                this.attackDamage = spellSlot.getSpellSlots().get(1).totalSpellDamage(spellSlot.getSpellSlots().get(1));
                break;
            case 5:
                this.attackDamage = spellSlot.getSpellSlots().get(2).totalSpellDamage(spellSlot.getSpellSlots().get(2));
                break;
            case 6:
                this.attackDamage = spellSlot.getSpellSlots().get(3).totalSpellDamage(spellSlot.getSpellSlots().get(3));
                break;
        }
    }

    public void calcPlayerDamage(){
        double resistMod=0;
        double weakMod=0;
        int i=0;
        for(Spell spell: spellSlot.getSpellSlots()) {
            if (enemy.getResistance().equals(playerStatus.equipment.getRightWeapon().getDamageType()) || enemy.getResistance().equals(spellSlot.getSpellSlots().get(i).getDamageType())) {
                resistMod = enemy.getResistMod();
            } else if (enemy.getWeakness().equals(playerStatus.equipment.getLeftWeapon().getDamageType()) || enemy.getWeakness().equals(spellSlot.getSpellSlots().get(i).getDamageType())) {
                weakMod = enemy.getWeakMod();
            }
            i++;
        }
        this.finalDamage = (int) (attackDamage + attackDamage*weakMod - attackDamage*resistMod);
    }

    public void calcEnemyDamage(){
        if (chosenDodge==true){
            this.finalDamage = (int)(enemy.getEnemyAttack() - (enemy.getEnemyAttack() * dodge));
        } else if (chosenBlock==true) {
            this.finalDamage = (int)(enemy.getEnemyAttack() - (enemy.getEnemyAttack() * block));
        }
    }
}


