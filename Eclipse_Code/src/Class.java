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
        Legs
    }
    private Map<armorSetPiece,Armor> KnightSet1;
    private Map<armorSetPiece,Armor> KnightSet2;
    private List<Weapon> KnightWeapons;
    private Map<armorSetPiece,Armor> BarbarianSet1;
    private Map<armorSetPiece,Armor> BarbarianSet2;
    private List<Weapon> BarbarianWeapons;
    private Map<armorSetPiece,Armor> AssassinSet1;
    private Map<armorSetPiece,Armor> AssassinSet2;
    private List<Weapon> AssassinWeapons;
    private Map<armorSetPiece,Armor> WizardSet1;
    private Map<armorSetPiece,Armor> WizardSet2;
    private List<Weapon> WizardWeapons;
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

    public Map<armorSetPiece, Armor> getKnightSet1() {
        return KnightSet1;
    }

    public void setKnightSet1(Map<armorSetPiece, Armor> knightSet1) {
        KnightSet1 = knightSet1;
    }

    public Map<armorSetPiece, Armor> getKnightSet2() {
        return KnightSet2;
    }

    public void setKnightSet2(Map<armorSetPiece, Armor> knightSet2) {
        KnightSet2 = knightSet2;
    }

    public List<Weapon> getKnightWeapons() {
        return KnightWeapons;
    }

    public void setKnightWeapons(List<Weapon> knightWeapons) {
        KnightWeapons = knightWeapons;
    }

    public Map<armorSetPiece, Armor> getBarbarianSet1() {
        return BarbarianSet1;
    }

    public void setBarbarianSet1(Map<armorSetPiece, Armor> barbarianSet1) {
        BarbarianSet1 = barbarianSet1;
    }

    public Map<armorSetPiece, Armor> getBarbarianSet2() {
        return BarbarianSet2;
    }

    public void setBarbarianSet2(Map<armorSetPiece, Armor> barbarianSet2) {
        BarbarianSet2 = barbarianSet2;
    }

    public List<Weapon> getBarbarianWeapons() {
        return BarbarianWeapons;
    }

    public void setBarbarianWeapons(List<Weapon> barbarianWeapons) {
        BarbarianWeapons = barbarianWeapons;
    }

    public Map<armorSetPiece, Armor> getAssassinSet1() {
        return AssassinSet1;
    }

    public void setAssassinSet1(Map<armorSetPiece, Armor> assassinSet1) {
        AssassinSet1 = assassinSet1;
    }

    public Map<armorSetPiece, Armor> getAssassinSet2() {
        return AssassinSet2;
    }

    public void setAssassinSet2(Map<armorSetPiece, Armor> assassinSet2) {
        AssassinSet2 = assassinSet2;
    }

    public List<Weapon> getAssassinWeapons() {
        return AssassinWeapons;
    }

    public void setAssassinWeapons(List<Weapon> assassinWeapons) {
        AssassinWeapons = assassinWeapons;
    }

    public Map<armorSetPiece, Armor> getWizardSet1() {
        return WizardSet1;
    }

    public void setWizardSet1(Map<armorSetPiece, Armor> wizardSet1) {
        WizardSet1 = wizardSet1;
    }

    public Map<armorSetPiece, Armor> getWizardSet2() {
        return WizardSet2;
    }

    public void setWizardSet2(Map<armorSetPiece, Armor> wizardSet2) {
        WizardSet2 = wizardSet2;
    }

    public List<Weapon> getWizardWeapons() {
        return WizardWeapons;
    }

    public void setWizardWeapons(List<Weapon> wizardWeapons) {
        WizardWeapons = wizardWeapons;
    }

    public void setStartingEquipment(armorSetPiece piece, Armor armor, classType type, int set){
        switch (type){
            case Knight:
                if (set==1) KnightSet1.put(piece,armor);
                else if (set==2) KnightSet2.put(piece,armor);
                break;
            case Barbarian:
                if (set==1) BarbarianSet1.put(piece,armor);
                else if (set==2) BarbarianSet2.put(piece,armor);
                break;
            case Assassin:
                if (set==1) AssassinSet1.put(piece,armor);
                else if (set==2) AssassinSet2.put(piece,armor);
                break;
            case Wizard:
                if (set==1) WizardSet1.put(piece,armor);
                else if (set==2) WizardSet2.put(piece,armor);
                break;

        }
    }

    public void setStartingWeapons(Weapon weapon, classType type){
        switch (type){
            case Knight:
                KnightWeapons.add(weapon);
                break;
            case Barbarian:
                BarbarianWeapons.add(weapon);
                break;
            case Assassin:
                AssassinWeapons.add(weapon);
                break;
            case Wizard:
                WizardWeapons.add(weapon);
                break;
        }
    }

    public void getStartingEquipment(classType type){
        switch (type){
            case Knight:
                System.out.println("Knight set 1 is: ");
                Set<Map.Entry<armorSetPiece,Armor>> set1 = KnightSet1.entrySet();
                for (Map.Entry<armorSetPiece,Armor> piece: set1){
                        System.out.println(piece.getKey() + ", Name: " + piece.getValue().getName() + ", Defence: " + piece.getValue().getDefense());
                }
                System.out.println("Knight set 2 is :");
                Set<Map.Entry<armorSetPiece,Armor>> set2 = KnightSet1.entrySet();
                for (Map.Entry<armorSetPiece,Armor> piece: set2){
                    System.out.println(piece.getKey() + ", Name: " + piece.getValue().getName() + ", Defence: " + piece.getValue().getDefense());
                }
                break;
            case Barbarian:
                System.out.println("Barbarian set 1 is: ");
                Set<Map.Entry<armorSetPiece,Armor>> barbset1 = BarbarianSet1.entrySet();
                for (Map.Entry<armorSetPiece,Armor> piece: barbset1){
                    System.out.println(piece.getKey() + ", Name: " + piece.getValue().getName() + ", Defence: " + piece.getValue().getDefense());
                }
                System.out.println("Barbarian set 2 is :");
                Set<Map.Entry<armorSetPiece,Armor>> barbset2 = BarbarianSet2.entrySet();
                for (Map.Entry<armorSetPiece,Armor> piece: barbset2){
                    System.out.println(piece.getKey() + ", Name: " + piece.getValue().getName() + ", Defence: " + piece.getValue().getDefense());
                }
                break;
            case Assassin:
                System.out.println("Assassin set 1 is: ");
                Set<Map.Entry<armorSetPiece,Armor>> assaset1 = AssassinSet2.entrySet();
                for (Map.Entry<armorSetPiece,Armor> piece: assaset1){
                    System.out.println(piece.getKey() + ", Name: " + piece.getValue().getName() + ", Defence: " + piece.getValue().getDefense());
                }
                System.out.println("Assassin set 2 is :");
                Set<Map.Entry<armorSetPiece,Armor>> assaset2 = AssassinSet2.entrySet();
                for (Map.Entry<armorSetPiece,Armor> piece: assaset2){
                    System.out.println(piece.getKey() + ", Name: " + piece.getValue().getName() + ", Defence: " + piece.getValue().getDefense());
                }
                break;
            case Wizard:
                System.out.println("Wizard set 1 is: ");
                Set<Map.Entry<armorSetPiece,Armor>> wizset1 = WizardSet1.entrySet();
                for (Map.Entry<armorSetPiece,Armor> piece: wizset1){
                    System.out.println(piece.getKey() + ", Name: " + piece.getValue().getName() + ", Defence: " + piece.getValue().getDefense());
                }
                System.out.println("Wizard set 2 is :");
                Set<Map.Entry<armorSetPiece,Armor>> wizset2 = WizardSet2.entrySet();
                for (Map.Entry<armorSetPiece,Armor> piece: wizset2){
                    System.out.println(piece.getKey() + ", Name: " + piece.getValue().getName() + ", Defence: " + piece.getValue().getDefense());
                }
                break;
        }
    }

    public void getStartWeap(classType type){
        switch (type){
            case Knight:
                for (int i=0; i<4; i++){
                    System.out.println((i+1) + ". Name:" + KnightWeapons.get(i).getName() + ", DamageType: " + KnightWeapons.get(i).getDamageType() + ", Damage: " + KnightWeapons.get(i).getDamage());
                }
                break;
            case Barbarian:
                for (int i=0; i<4; i++){
                    System.out.println((i+1) + ". Name:" + BarbarianWeapons.get(i).getName() + ", DamageType: " + BarbarianWeapons.get(i).getDamageType() + ", Damage: " + BarbarianWeapons.get(i).getDamage());
                }
                break;
            case Assassin:
                for (int i=0; i<4; i++){
                    System.out.println((i+1) + ". Name:" + AssassinWeapons.get(i).getName() + ", DamageType: " + AssassinWeapons.get(i).getDamageType() + ", Damage: " + AssassinWeapons.get(i).getDamage());
                }
                break;
            case Wizard:
                for (int i=0; i<4; i++){
                    System.out.println((i+1) + ". Name:" + WizardWeapons.get(i).getName() + ", DamageType: " + WizardWeapons.get(i).getDamageType() + ", Damage: " + WizardWeapons.get(i).getDamage());
                }
                break;
        }

    }
}
