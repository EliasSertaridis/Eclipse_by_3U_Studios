import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Combat {
    private boolean turn;
    private double block = 0;
    private double dodge = 0;
    private double attackDamage = 0;
    private String attackType;

    PlayerStatus playerStatus;
    Enemy enemy;
    SpellSlot spellSlot;
    Spell spell;
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
        int equiploadMod = 0;
        if(totalWeight/equipLoad<3.3){
            equiploadMod = 1;
        } else if (totalWeight/equipLoad<6.6 && totalWeight/equipLoad>3.3) {
            equiploadMod = 0;
        } else if (totalWeight/equipLoad>6.6) {
            equiploadMod = -1;
        }
        this.dodge = (dexMod+(double) equiploadMod)/100;
    }

    public void chooseBlock(){
        if(playerStatus.equipment.hasShield()==true){
            this.block = playerStatus.equipment.getShieldDefence();
        }
    }

    public void chooseAttack(){
        int i = 1;
        Scanner attack = new Scanner(System.in);
        System.out.println("Your available attacks are: ");
        System.out.println(i + ". " + playerStatus.equipment.getRightWeapon());
        i++;
        System.out.println(i+ ". " + playerStatus.equipment.getLeftWeapon());
        List<Spell> spells;
        spells = spellSlot.getSpellSlots();
        for(Spell spell: spells){
            i++;
            System.out.println(i+ ", " + spells.get(i-3));
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
                this.attackDamage = spells.get(0).totalSpellDamage(spells.get(0));
                break;
            case 4:
                this.attackDamage = spells.get(1).totalSpellDamage(spells.get(1));
                break;
            case 5:
                this.attackDamage = spells.get(2).totalSpellDamage(spells.get(2));
                break;
            case 6:
                this.attackDamage = spells.get(3).totalSpellDamage(spells.get(3));
        }
    }
}


