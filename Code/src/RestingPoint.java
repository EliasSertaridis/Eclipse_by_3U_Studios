import java.sql.SQLOutput;
import java.util.List;
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
        boolean on=true;

        playableCharacter.getPlayerStatus().getInventory().restoreEssentials(main,restoreAmount);
        playableCharacter.setHp(playableCharacter.getMaxHP());
        while(on) {
            System.out.println("Spell Slots");
            System.out.println("Skill Tree");
            System.out.println("Save and Exit");
            System.out.println("Save");
            System.out.println("Exit");
            Scanner scanner = new Scanner(System.in);
            String input;
            input = scanner.nextLine();
            if (input.equals("Spell")) {
                optForSpellSlotMod();
            } else if (input.equals("Skill")) {
                optForSkillTree();
            } else if (input.equals("Save and Exit")) {
            } else if (input.equals("Save")) {
            } else if (input.equals("Exit")) {
                on=false;
            }
        }
    }
    public void optForSkillTree(){
        boolean on=true;

        while(on) {
            System.out.println("Your skill points are " + playableCharacter.getSkillPoints());
            skillTree.displayAvailableSkills();
            System.out.println("Type the name of the skill you want to update:");
            Scanner scanner = new Scanner(System.in);
            String input;
            input = scanner.nextLine();
            List<Skill> availableSkills = skillTree.getAvailableSkills();
            if(input.equals("Exit")) on=false;
            for (Skill skill : availableSkills) {
                if (input.equals(skill.getName())) {
                    skillTree.unlockSkill(skill, playableCharacter);
                    on=false;
                } else System.out.println("There is no skill matching your input. Please try again.");
            }
        }
    }
    public  void optForSpellSlotMod(){

    }
}
