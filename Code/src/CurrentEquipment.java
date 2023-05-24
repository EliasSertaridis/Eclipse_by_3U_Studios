import java.util.ArrayList;

public class CurrentEquipment {

    ArrayList<Armor> currentArmor=new ArrayList<Armor>();
    Armor head,chest,hands,legs;
    ArrayList<Weapon> currentWeapons=new ArrayList<Weapon>();
    Weapon rightWeapon,leftWeapon;
    ArrayList<QuickItem> currentQuickItems=new ArrayList<QuickItem>();

    public CurrentEquipment(ArrayList<Armor> currentArmor, ArrayList<Weapon> currentWeapons, ArrayList<QuickItem> currentQuickItems) {
        this.currentArmor = currentArmor;
        this.currentWeapons = currentWeapons;
        this.currentQuickItems = currentQuickItems;
    }

    public ArrayList<Armor> getCurrentArmor() {
        return currentArmor;
    }

    public void setCurrentArmor(ArrayList<Armor> currentArmor) {
        this.currentArmor = currentArmor;
    }

    public ArrayList<Weapon> getCurrentWeapons() {
        return currentWeapons;
    }

    public void setCurrentWeapons(ArrayList<Weapon> currentWeapons) {
        this.currentWeapons = currentWeapons;
    }

    public ArrayList<QuickItem> getCurrentQuickItems() {
        return currentQuickItems;
    }

    public void setCurrentQuickItems(ArrayList<QuickItem> currentQuickItems) {
        this.currentQuickItems = currentQuickItems;
    }
}
