public class Main {
    public static void main(String[] args) {

        PlayableCharacter pc1 = new PlayableCharacter("mitsos",20,11,11,11,11,11,500,1,44.0,1.3);
        Enemy enemy1 = new Enemy("Mpampoulas", 14,11,11,11,11,11,"smash",2, Enemy.Type.Slashing, Enemy.Type.Fire,0.3,0.7,false,3);
        Combat combat = new Combat();
    }
}