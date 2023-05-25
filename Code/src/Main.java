import java.lang.reflect.Type;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        PlayableCharacter takhs = new PlayableCharacter("Takhs",12,20,9,40,80,7,3009,19,53.4,0.9);
       Item flask = new Item("takhs"," he is not here");
       Weapon sword= new Weapon("excalibur","The sword of king Arthur",13 ,10,0.3,Weapon.TypeOfDamage.Slashing,Weapon.TypeOfWeapon.Sword);
       Armor head1= new Armor("kefali","its noice",13, Armor.TypeOfArmor.Head,1);
       Armor head2= new Armor("KARANIO","its HUGE",13, Armor.TypeOfArmor.Head,1);
        Armor chest1= new Armor("sti8os","its noice",13, Armor.TypeOfArmor.Chest,1);
        Armor hands1= new Armor("xeria","its noice",13, Armor.TypeOfArmor.Hands,1);
        Armor legs1= new Armor("podia","its noice",13, Armor.TypeOfArmor.Legs,1);
        PlayerStatus playerStatus=new PlayerStatus();
        playerStatus.setPlayer(takhs);
        CurrentEquipment eq1=new CurrentEquipment(head1,chest1,hands1,legs1,sword,sword);
        playerStatus.setEquipment(eq1);

        System.out.println(eq1.getCurrentEquipment()+" phase 1");

        eq1.setHead(head2);
       /* List<Equipment> equipment = eq1.getCurrentEquipment();
        System.out.println("Equipment of the player:");
        for (Equipment head : equipment) {
            System.out.println("- " + head.getName() + ", Disc: " + head.getDescription());
        }
        System.out.println("-----------------------------------------------");
        List<Armor> armor = eq1.getCurrentArmor();
        System.out.println("Armor of the player:");
        for (Armor pen : armor) {
            System.out.println("- " + pen.getName() + ", Disc: " + pen.getDescription()  );
        }
        System.out.println("-----------------------------------------------");
        System.out.println(playerStatus.player.getName()+" "+playerStatus.player.getHp());
        */
        playerStatus.openPlayerStatus();


    }
}
