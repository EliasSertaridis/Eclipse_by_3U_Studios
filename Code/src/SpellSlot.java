import java.util.ArrayList;
import java.util.List;

public class SpellSlot extends Inventory{

    private PlayableCharacter pc;
    private List<Spell> spellSlots = new ArrayList<>(4);

    public SpellSlot(List<Spell> spellSlots) {
        this.spellSlots = spellSlots;
    }

    public List<Spell> getSpellSlots() {
        return spellSlots;
    }

    public void setSpellSlots(List<Spell> spellSlots) {
        this.spellSlots = spellSlots;
    }

    public int totalSpellDamage(Spell spell) {
        double totalDamage;
        double scalingDamage = 0;
        if (spell.getStatPrerequisiteName() == Spell.PrerequisiteStat.INT) {
            scalingDamage = (spell.getScaling() + 1) * (pc.getIntelligence());
        } else if (spell.getStatPrerequisiteName() == Spell.PrerequisiteStat.WIS) {
            scalingDamage = (spell.getScaling() + 1) * (pc.getWisdom());
        }
        totalDamage = spell.getDamage() + scalingDamage;
        return (int) totalDamage;
    }
}