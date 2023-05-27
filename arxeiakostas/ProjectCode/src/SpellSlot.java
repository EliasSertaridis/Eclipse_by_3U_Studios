import java.util.ArrayList;
import java.util.List;

public class SpellSlot extends Inventory{
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
}
