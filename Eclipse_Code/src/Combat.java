import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Combat {
    private boolean turn;
    private double block = 0;
    private double dodge = 0;

    PlayableCharacter playableCharacter;
    Enemy enemy;
    List<Double> playerStats = new ArrayList<Double>(playableCharacter.getPlayerStats());
    List<Double> enemyStats = new ArrayList<Double>(enemy.getEnemyStats());
    Map<Enemy.Type,Double> enemyInfo = new HashMap<Enemy.Type, Double>(enemy.getEnemyInfo(enemy.isFacedBefore()));

    public Combat() {}

    public boolean isTurn() {
        return turn;
    }

    public void setTurn(boolean turn) {
        this.turn = turn;
    }

    public void compareLevel(boolean turn){
        if(enemyStats.get(6)>= playerStats.get(6)){
            this.turn = true;
        } else {
            this.turn = false;
        }
    }

    public void chooseDodge(double dodge){
        double dexMod = (double) playableCharacter.getDexterity();
        double equipLoad = playableCharacter.getEquipLoad();
        this.dodge = dexMod*equipLoad/100;
    }
}
