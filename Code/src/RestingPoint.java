public class RestingPoint {

    PlayableCharacter playableCharacter;
    int restoreAmount;
    HealthPotion main;

    public RestingPoint() {
    }

    public HealthPotion getMain() {
        return main;
    }

    public void setMain(HealthPotion main) {
        this.main = main;
    }

    public PlayableCharacter getPlayableCharacter() {
        return playableCharacter;
    }

    public void setPlayableCharacter(PlayableCharacter playableCharacter) {
        this.playableCharacter = playableCharacter;
    }

    public int getRestoreAmount() {
        return restoreAmount;
    }

    public void setRestoreAmount(int restoreAmount) {
        this.restoreAmount = restoreAmount;
    }

    public void interact(){
        playableCharacter.getPlayerStatus().getInventory().restoreEssentials(main,restoreAmount);
        playableCharacter.setHp(playableCharacter.getMaxHP());
    }
}
