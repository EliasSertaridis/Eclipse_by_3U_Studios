import java.util.Scanner;

public class RestingPoint {

    PlayableCharacter playableCharacter;
    int restoreAmount;
    HealthPotion main;
    SkillTree skillTree;

    public RestingPoint() {
    }

    public SkillTree getSkillTree() {
        return skillTree;
    }

    public void setSkillTree(SkillTree skillTree) {
        this.skillTree = skillTree;
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
        System.out.println("Spell Slots");
        System.out.println("Skill Tree");
        System.out.println("Save and Exit");
        System.out.println("Save");
        System.out.println("Exit");
        Scanner scanner= new Scanner(System.in);
        String input;
        input=scanner.nextLine();
        if(input.equals("Spell")){}
        else if(input.equals("Skill")){
            optForSkillTree();
        }
        else if(input.equals("Save and Exit")){}
        else if(input.equals("Save")){}
        else if(input.equals("Exit")){}
    }
    public void optForSkillTree(){
        skillTree.displayAvailableSkills();
    }
}
