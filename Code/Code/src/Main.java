import java.lang.reflect.Type;

public class Main {

    public static void main(String[] args) {

       Item flask = new Item("takhs"," he is not here");
       Weapon sword= new Weapon("excalibur","The sword of king Arthur", Weapon.TypeOfWeapon.Sword,Weapon.TypeOfDamage.Slashing,10,0.3);
       flask.setName("makhs");
        System.out.println(sword.getDamageType()+flask.getDescription());
    }
}
