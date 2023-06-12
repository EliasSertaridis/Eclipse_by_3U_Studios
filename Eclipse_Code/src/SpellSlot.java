import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SpellSlot extends Inventory {

    PlayableCharacter playableCharacter;

    private List<Spell> spellSlots = new ArrayList<>(4);

    public SpellSlot() {
    }

    public List<Spell> getSpellSlots() {
        return spellSlots;
    }

    public void setSpellSlots(List<Spell> spellSlots) {
        this.spellSlots = spellSlots;
    }

    public int getNumberOfSpellsEquiped() {
        return spellSlots.size();
    }

    public void addSpell(Spell spell) {
        spellSlots.add(spell);
    }

    public void removeSpell(Spell spell) {
        spellSlots.remove(spell);
    }

    public void changeSpell(Spell newSpell, Spell oldSpell) {
        removeSpell(oldSpell);
        addSpell(newSpell);
    }

    public PlayableCharacter getPlayableCharacter() {
        return playableCharacter;
    }

    public void setPlayableCharacter(PlayableCharacter playableCharacter) {
        this.playableCharacter = playableCharacter;
    }
    public void currentSpells(){
        int i=0;

        for(Spell spell:spellSlots){
            i++;
            System.out.println(i+". "+spell.getName());
        }
        while(i<4){
            i++;
            System.out.println(i+". No Spell is Equiped in this slot");
        }
        System.out.println("-------------------------------------------");
    }
    public int totalSpellDamage(Spell spell) {
        double totalDamage;
        double scalingDamage = 0;
        if (spell.getStatPrerequisiteName() == Spell.PrerequisiteStat.INT) {
            scalingDamage = (spell.getScaling() + 1) * (playableCharacter.getIntelligence());
        } else if (spell.getStatPrerequisiteName() == Spell.PrerequisiteStat.WIS) {
            scalingDamage = (spell.getScaling() + 1) * (playableCharacter.getWisdom());
        }
        totalDamage = spell.getDamage() + scalingDamage;
        return (int) totalDamage;
    }

    public boolean spellIsEquiped(Spell spell) {
        boolean exists = false;
        for (Spell spells : spellSlots) {
            if (spell == spells) {
                exists = true;
                break;
            } else exists = false;
        }
        return exists;
    }
    public Spell getSpellByName(String name){
        Spell thisSpell=null;
        for(Spell spell:spellSlots){
            if(name.equals(spell.getName())){
                thisSpell=spell;
                break;
            }
        }return thisSpell;
    }
}
