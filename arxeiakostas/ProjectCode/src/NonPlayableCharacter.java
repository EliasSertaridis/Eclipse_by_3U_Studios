public class NonPlayableCharacter extends Character{

    private String dialogue;

    public NonPlayableCharacter(String name, int hp, int strength, int dexterity, int vitality, int intelligence, int wisdom, String dialogue) {
        super(name, hp, strength, dexterity, vitality, intelligence, wisdom);
        this.dialogue = dialogue;
    }

    public String getDialogue() {
        return dialogue;
    }

    public void setDialogue(String dialogue) {
        this.dialogue = dialogue;
    }
}