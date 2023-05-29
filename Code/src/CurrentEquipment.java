import java.util.ArrayList;
import java.util.List;

public class CurrentEquipment {


    private Armor head, chest, hands, legs;
    private Weapon rightWeapon, leftWeapon;
    private List<QuickItem> currentQuickItems = new ArrayList<QuickItem>();
    private List<Equipment> currentEquipment= new ArrayList<Equipment>();

    public CurrentEquipment(Armor head, Armor chest, Armor hands, Armor legs, Weapon rightWeapon, Weapon leftWeapon) {
        this.head = head;
        this.chest = chest;
        this.hands = hands;
        this.legs = legs;
        this.rightWeapon = rightWeapon;
        this.leftWeapon = leftWeapon;
        initialize();
    }

    public Armor getHead() {
        return head;
    }

    public void setHead(Armor head) {
        this.head = head;
    }

    public Armor getChest() {
        return chest;
    }

    public void setChest(Armor chest) {
        this.chest = chest;
    }

    public Armor getHands() {
        return hands;
    }

    public void setHands(Armor hands) {
        this.hands = hands;
    }

    public Armor getLegs() {
        return legs;
    }

    public void setLegs(Armor legs) {
        this.legs = legs;
    }

    public Weapon getRightWeapon() {
        return rightWeapon;
    }

    public void setRightWeapon(Weapon rightWeapon) {
        updateEquipment(rightWeapon,this.rightWeapon);
        this.rightWeapon = rightWeapon;
    }

    public Weapon getLeftWeapon() {
        return leftWeapon;
    }

    public void setLeftWeapon(Weapon leftWeapon) {
        updateEquipment(leftWeapon,this.leftWeapon);
        this.leftWeapon = leftWeapon;
    }

    public List<Armor> getCurrentArmor() {
        List<Armor> armor = new ArrayList<>();
        for (Equipment equipment : currentEquipment) {
            if (equipment instanceof Armor) {
                armor.add((Armor) equipment);
            }
        }
        return armor;
    }

    public List<Weapon> getCurrentWeapons() {
        List<Weapon> weapons = new ArrayList<>();
        for (Equipment equipment : currentEquipment) {
            if (equipment instanceof Weapon) {
                weapons.add((Weapon) equipment);
            }
        }
        return weapons;
    }

    public List<QuickItem> getCurrentQuickItems() {
        return currentQuickItems;
    }

    public void setCurrentQuickItems(ArrayList<QuickItem> currentQuickItems) {
        this.currentQuickItems = currentQuickItems;
    }
    public List<Equipment> getCurrentEquipment(){
        return currentEquipment;
    }
    public void initialize(){
        currentEquipment.add(head);
        currentEquipment.add(chest);
        currentEquipment.add(hands);
        currentEquipment.add(legs);
        currentEquipment.add(rightWeapon);
        currentEquipment.add(leftWeapon);
    }

    public void setArmor(Armor armor){
        if(armor.getArmorType()== Armor.TypeOfArmor.Chest){
            setChest(armor);
        }else if(armor.getArmorType()== Armor.TypeOfArmor.Head){
            setHead(armor);
        }else if(armor.getArmorType()== Armor.TypeOfArmor.Hands){
            setHands(armor);
        }else if(armor.getArmorType()== Armor.TypeOfArmor.Legs){
            setLegs(armor);
        }

    }

    public void removeQuickItem(QuickItem quickItem){
        currentQuickItems.remove(quickItem);
    }
    public void addQuickItem(QuickItem quickItem){
        if (currentQuickItems.size()<5)
            currentQuickItems.add(quickItem);
        else System.out.println("This Item can not be added because the space is full.Please remove something and try again.");
    }
    public void changeQuickItem(QuickItem oldQuickItem,QuickItem newQuickItem){
        removeQuickItem(oldQuickItem);
        addQuickItem(newQuickItem);
    }
    public void removeEquipment(Equipment equipment){
        currentEquipment.remove(equipment);
    }
    public void addEquipment(Equipment equipment){
        currentEquipment.add(equipment);
    }
    public void updateArmor(Armor newArmor,Armor oldArmor){
        removeEquipment(oldArmor);
        addEquipment(newArmor);
        setArmor(newArmor);
    }
    public void updateEquipment(Equipment newEquipment,Equipment oldEquipment){
        if(newEquipment instanceof Armor){
            updateArmor((Armor) newEquipment,(Armor) oldEquipment);
        }else {
            removeEquipment(oldEquipment);
            addEquipment(newEquipment);
        }
    }
    public int totalWeight(){
        int weight=0;
        for (Equipment equipment : currentEquipment) {
            weight=weight+ equipment.getWeight();
        }
        return weight;
    }
    public boolean hasShield(){
        if((rightWeapon instanceof Shield)||(leftWeapon instanceof Shield)){
            return true;
        }else {return false;}
    }
    public int getShieldDefence(){
        if (rightWeapon instanceof Shield){
            return ((Shield) rightWeapon).getDefense();
        }else if (leftWeapon instanceof Shield){
            return ((Shield) leftWeapon).getDefense();
        }
        return 0;
    }

    public Armor getArmorByType(Armor.TypeOfArmor typeOfArmor) {
        if (typeOfArmor == Armor.TypeOfArmor.Chest) {
            return getChest();
        } else if (typeOfArmor == Armor.TypeOfArmor.Hands) {
            return getHands();
        } else if (typeOfArmor == Armor.TypeOfArmor.Head) {
            return getHead();
        } else if (typeOfArmor == Armor.TypeOfArmor.Legs) {
            return getLegs();
        }return null;
    }

    public int getTotalDefense(){
        int deffense=0;
        deffense=deffense+getHands().getDefense();
        deffense=deffense+getHead().getDefense();
        deffense=deffense+getLegs().getDefense();
        deffense=deffense+getChest().getDefense();
        return deffense;

    }



}
