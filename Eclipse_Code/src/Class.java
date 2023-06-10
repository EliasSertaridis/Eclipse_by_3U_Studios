import java.util.*;

public class Class {

    enum classType{
        Knight,
        Barbarian,
        Assassin,
        Wizard
    }
    private classType name;
    private String description;

    enum armorSetPiece{
        Head,
        Chest,
        Hands,
        Legs,
        LeftWeapon,
        RightWeapon
    }
    private Map<armorSetPiece,Equipment> KnightSet1;
    private Map<armorSetPiece,Equipment> KnightSet2;
    private Map<armorSetPiece,Equipment> BarbarianSet1;
    private Map<armorSetPiece,Equipment> BarbarianSet2;
    private Map<armorSetPiece,Equipment> AssassinSet1;
    private Map<armorSetPiece,Equipment> AssassinSet2;
    private Map<armorSetPiece,Equipment> WizardSet1;
    private Map<armorSetPiece,Equipment> WizardSet2;
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

    public LinkedHashMap<classType,String> getClasses(){
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

    public Map<armorSetPiece, Equipment> getKnightSet1() {
        return KnightSet1;
    }

    public void setKnightSet1(Map<armorSetPiece, Equipment> knightSet1) {
        KnightSet1 = knightSet1;
    }

    public Map<armorSetPiece, Equipment> getKnightSet2() {
        return KnightSet2;
    }

    public void setKnightSet2(Map<armorSetPiece, Equipment> knightSet2) {
        KnightSet2 = knightSet2;
    }

    public Map<armorSetPiece, Equipment> getBarbarianSet1() {
        return BarbarianSet1;
    }

    public void setBarbarianSet1(Map<armorSetPiece, Equipment> barbarianSet1) {
        BarbarianSet1 = barbarianSet1;
    }

    public Map<armorSetPiece, Equipment> getBarbarianSet2() {
        return BarbarianSet2;
    }

    public void setBarbarianSet2(Map<armorSetPiece, Equipment> barbarianSet2) {
        BarbarianSet2 = barbarianSet2;
    }

    public Map<armorSetPiece, Equipment> getAssassinSet1() {
        return AssassinSet1;
    }

    public void setAssassinSet1(Map<armorSetPiece, Equipment> assassinSet1) {
        AssassinSet1 = assassinSet1;
    }

    public Map<armorSetPiece, Equipment> getAssassinSet2() {
        return AssassinSet2;
    }

    public void setAssassinSet2(Map<armorSetPiece, Equipment> assassinSet2) {
        AssassinSet2 = assassinSet2;
    }

    public Map<armorSetPiece, Equipment> getWizardSet1() {
        return WizardSet1;
    }

    public void setWizardSet1(Map<armorSetPiece, Equipment> wizardSet1) {
        WizardSet1 = wizardSet1;
    }

    public Map<armorSetPiece, Equipment> getWizardSet2() {
        return WizardSet2;
    }

    public void setWizardSet2(Map<armorSetPiece, Equipment> wizardSet2) {
        WizardSet2 = wizardSet2;
    }

    public void setStartingEquipment(armorSetPiece piece, Equipment eq, classType type, int set){
        switch (type){
            case Knight:
                if (set==1) KnightSet1.put(piece,eq);
                else if (set==2) KnightSet2.put(piece,eq);
                break;
            case Barbarian:
                if (set==1) BarbarianSet1.put(piece,eq);
                else if (set==2) BarbarianSet2.put(piece,eq);
                break;
            case Assassin:
                if (set==1) AssassinSet1.put(piece,eq);
                else if (set==2) AssassinSet2.put(piece,eq);
                break;
            case Wizard:
                if (set==1) WizardSet1.put(piece,eq);
                else if (set==2) WizardSet2.put(piece,eq);
                break;

        }
    }

    public void getStartingEquipment(classType type){
        switch (type){
            case Knight:
                System.out.println("Knight set 1 is: ");
                Set<Map.Entry<armorSetPiece,Equipment>> set1 = KnightSet1.entrySet();
                for (Map.Entry<armorSetPiece,Equipment> piece: set1){
                    System.out.println(piece.getKey() + " " + piece.getValue().getName());
                }
                System.out.println("Knight set 2 is :");
                Set<Map.Entry<armorSetPiece,Equipment>> set2 = KnightSet1.entrySet();
                for (Map.Entry<armorSetPiece,Equipment> piece: set2){
                    System.out.println(piece.getKey() + " " + piece.getValue().getName());
                }
                break;
            case Barbarian:
                System.out.println("Barbarian set 1 is: ");
                Set<Map.Entry<armorSetPiece,Equipment>> barbset1 = BarbarianSet1.entrySet();
                for (Map.Entry<armorSetPiece,Equipment> piece: barbset1){
                    System.out.println(piece.getKey() + " " + piece.getValue().getName());
                }
                System.out.println("Barbarian set 2 is :");
                Set<Map.Entry<armorSetPiece,Equipment>> barbset2 = BarbarianSet2.entrySet();
                for (Map.Entry<armorSetPiece,Equipment> piece: barbset2){
                    System.out.println(piece.getKey() + " " + piece.getValue().getName());
                }
                break;
            case Assassin:
                System.out.println("Assassin set 1 is: ");
                Set<Map.Entry<armorSetPiece,Equipment>> assaset1 = AssassinSet2.entrySet();
                for (Map.Entry<armorSetPiece,Equipment> piece: assaset1){
                    System.out.println(piece.getKey() + " " + piece.getValue().getName());
                }
                System.out.println("Assassin set 2 is :");
                Set<Map.Entry<armorSetPiece,Equipment>> assaset2 = AssassinSet2.entrySet();
                for (Map.Entry<armorSetPiece,Equipment> piece: assaset2){
                    System.out.println(piece.getKey() + " " + piece.getValue().getName());
                }
                break;
            case Wizard:
                System.out.println("Wizard set 1 is: ");
                Set<Map.Entry<armorSetPiece,Equipment>> wizset1 = WizardSet1.entrySet();
                for (Map.Entry<armorSetPiece,Equipment> piece: wizset1){
                    System.out.println(piece.getKey() + " " + piece.getValue().getName());
                }
                System.out.println("Wizard set 2 is :");
                Set<Map.Entry<armorSetPiece,Equipment>> wizset2 = WizardSet2.entrySet();
                for (Map.Entry<armorSetPiece,Equipment> piece: wizset2){
                    System.out.println(piece.getKey() + " " + piece.getValue().getName());
                }
                break;
        }
    }
}
