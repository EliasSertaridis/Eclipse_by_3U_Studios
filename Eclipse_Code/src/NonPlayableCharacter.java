public class NonPlayableCharacter extends Character{

    private String dialogue;
    private int reputation;

    public NonPlayableCharacter(String name, int hp, int strength, int dexterity, int vitality, int intelligence, int wisdom, String dialogue, int reputation) {
        super(name, hp, strength, dexterity, vitality, intelligence, wisdom);
        this.dialogue = dialogue;
        this.reputation = reputation;
    }

    public String getDialogue() {
        return dialogue;
    }

    public void setDialogue(String dialogue) {
        this.dialogue = dialogue;
    }

    public int getReputation() {
        return reputation;
    }

    public void setReputation(int reputation) {
        this.reputation = reputation;
    }
}
