public class PlayerStatus {

    Character player;
    CurrentEquipment equipment;

    public PlayerStatus(Character player, CurrentEquipment equipment) {
        this.player = player;
        this.equipment = equipment;
    }

    public Character getPlayer() {
        return player;
    }

    public void setPlayer(Character player) {
        this.player = player;
    }

    public CurrentEquipment getEquipment() {
        return equipment;
    }

    public void setEquipment(CurrentEquipment equipment) {
        this.equipment = equipment;
    }

    public void openPlayerStatus(){
        System.out.println();

    }
}
