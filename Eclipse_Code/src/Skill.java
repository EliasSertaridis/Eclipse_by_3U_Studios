import java.util.ArrayList;
import java.util.List;

public class Skill {
    private String name;
    private String description;
    private int level;
    private int skillPointNeeded;
    private List<Skill> dependencies;
    public TypeOfBoosting statForBoosting;
    private int amountOfBoosting;
    enum TypeOfBoosting{
        INT,DEX,VIT,WIS,STR
    }

    public Skill(String name, String description, TypeOfBoosting statForBoosting, int amountOfBoosting, int skillPointNeeded) {
        this.skillPointNeeded=skillPointNeeded;
        this.amountOfBoosting=amountOfBoosting;
        this.statForBoosting=statForBoosting;
        this.name = name;
        this.description=description;
        this.level = 0;
        this.dependencies = new ArrayList<>();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getSkillPointNeeded() {
        return skillPointNeeded;
    }

    public void setSkillPointNeeded(int skillPointNeeded) {
        this.skillPointNeeded = skillPointNeeded;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Skill> getDependencies() {
        return dependencies;
    }

    public void setDependencies(List<Skill> dependencies) {
        this.dependencies = dependencies;
    }

    public TypeOfBoosting getStatForBoosting() {
        return statForBoosting;
    }

    public void setStatForBoosting(TypeOfBoosting statForBoosting) {
        this.statForBoosting = statForBoosting;
    }

    public int getAmountOfBoosting() {
        return amountOfBoosting;
    }

    public void setAmountOfBoosting(int amountOfBoosting) {
        this.amountOfBoosting = amountOfBoosting;
    }

    public void removeDependency(Skill skill){
        dependencies.remove(skill);
    }
    public void addDependency(Skill skill) {
        dependencies.add(skill);
    }

    public boolean checkIfDepends(Skill skill){
        boolean temp=false;
        for(Skill dependenceSkill : dependencies){
            if (dependenceSkill==skill) {
                temp= true;
                break;
            }else temp= false;
        }return temp;
    }

    public boolean hasDependencies() {
        return !dependencies.isEmpty();
    }

    public boolean hasUnlockedDependencies() {
        for (Skill dependency : dependencies) {
            if (dependency.getLevel() == 0) {
                return false;
            }
        }
        return true;
    }
    public void addSkillEffect(PlayableCharacter playableCharacter){
        if(statForBoosting==TypeOfBoosting.VIT){
            playableCharacter.setVitality(playableCharacter.getVitality()+amountOfBoosting);
        }
        else if(statForBoosting==TypeOfBoosting.DEX){
            playableCharacter.setDexterity(playableCharacter.getDexterity()+amountOfBoosting);
        }
        else if(statForBoosting==TypeOfBoosting.STR){
            playableCharacter.setStrength(playableCharacter.getStrength()+amountOfBoosting);
        }
        else if(statForBoosting==TypeOfBoosting.INT){
            playableCharacter.setIntelligence(playableCharacter.getIntelligence()+amountOfBoosting);
        }
        else if(statForBoosting==TypeOfBoosting.WIS){
            playableCharacter.setWisdom(playableCharacter.getWisdom()+amountOfBoosting);
        }
    }
}
