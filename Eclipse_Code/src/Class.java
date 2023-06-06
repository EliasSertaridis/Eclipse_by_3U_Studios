import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
        setDescription(name);
    }

    public LinkedHashMap<classType,String> getClassTypes(){
        LinkedHashMap<classType,String> classTypes= new LinkedHashMap<>();
        classTypes.put(classType.Knight , "Melee Class, usually wears heavy armor, wielding a longsword and a shield.");
        classTypes.put(classType.Barbarian, "Melee Class, usually wears medium armor, wielding a battle-axe.");
        classTypes.put(classType.Assassin, "Melee & Ranged Class, usually wears light armor, wielding a shortsword and a bow.");
        classTypes.put(classType.Wizard, "Ranged Class, usually wears light armor, wielding a staff");
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

    public String getDescription() {
        return description;
    }
}
