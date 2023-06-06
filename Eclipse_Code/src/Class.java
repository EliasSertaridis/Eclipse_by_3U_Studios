import java.util.ArrayList;
import java.util.List;

public class Class {

    enum classType{
        Knight,
        Barbarian,
        Assassin,
        Wizard
    }
    private classType name;
    private String description;

    public Class(classType name) {
        this.name = name;
    }

    public classType getName() {
        return name;
    }

    public void setName(classType name) {
        this.name = name;
    }

    public List<classType> getClassTypes(){
        List <classType> classTypes = new ArrayList<>();
        classTypes.add(classType.Knight);
        classTypes.add(classType.Barbarian);
        classTypes.add(classType.Assassin);
        classTypes.add(classType.Wizard);
        return classTypes;
    }

    private void setDescription(classType name){
        switch (name){
            case Knight:
                this.description = "Melee Class, usually wears heavy armor, wielding a longsword and a shield.";
                break;
            case Barbarian:
                this.description = "Melee Class, usually wears medium armor, wielding a battle-axe.";
                break;
            case Assassin:
                this.description = "Melee & Ranged Class, usually wears light armor, wielding a shortsword and a bow.";
                break;
            case Wizard:
                this.description = "Ranged Class, usually wears light armor, wielding a staff";
                break;
        }
    }
}
