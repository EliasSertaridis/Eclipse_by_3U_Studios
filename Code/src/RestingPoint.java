import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

public class RestingPoint {

    PlayableCharacter playableCharacter;
    int restoreAmount;
    HealthPotion main;
    SkillTree skillTree;

    public RestingPoint() {
    }

    public SkillTree getSkillTree() {
        return skillTree;
    }

    public void setSkillTree(SkillTree skillTree) {
        this.skillTree = skillTree;
    }

    public HealthPotion getMain() {
        return main;
    }

    public void setMain(HealthPotion main) {
        this.main = main;
    }

    public PlayableCharacter getPlayableCharacter() {
        return playableCharacter;
    }

    public void setPlayableCharacter(PlayableCharacter playableCharacter) {
        this.playableCharacter = playableCharacter;
    }

    public int getRestoreAmount() {
        return restoreAmount;
    }

    public void setRestoreAmount(int restoreAmount) {
        this.restoreAmount = restoreAmount;
    }

    public void interact(){
        boolean on=true;

        playableCharacter.getPlayerStatus().getInventory().restoreEssentials(main,restoreAmount);
        playableCharacter.restoreEssentials();
        checkEnoughSkillPoints();
        while(on) {
            System.out.println("Spell Slots");
            System.out.println("Skill Tree");
            System.out.println("Save and Exit");
            System.out.println("Save");
            System.out.println("Exit");
            Scanner scanner = new Scanner(System.in);
            String input;
            input = scanner.nextLine();
            if (input.equals("Spell")) {
                optForSpellSlotMod();
            } else if (input.equals("Skill")) {
                optForSkillTree();
            } else if (input.equals("Save and Exit")) {
            } else if (input.equals("Save")) {
            } else if (input.equals("Exit")) {
                on=false;
            }
        }
    }
    public void optForSkillTree(){
        boolean on=true;

        while(on) {
            System.out.println("Your skill points are " + playableCharacter.getSkillPoints());
            skillTree.displayAvailableSkills();
            System.out.println("Type the name of the skill you want to update:");
            Scanner scanner = new Scanner(System.in);
            String input;
            input = scanner.nextLine();
            if(input.equals("Exit")) on=false;
            else {
                chooseAvailableSkill(input);
            }

          /*  List<Skill> availableSkills = skillTree.getAvailableSkills();

            for (Skill skill : availableSkills) {
                if (input.equals(skill.getName())) {
                    System.out.println("The skill named "+skill.getName()+" has the following effect: "+ skill.getDescription());
                    System.out.println("Do you want to unlock this skill? Yes or No");
                    input=scanner.nextLine();
                    if(input.equals("Yes")) {
                        skillTree.unlockSkill(skill, playableCharacter);
                        on = false;
                    }else if(input.equals("No")){}
                    else System.out.println("Your input was incorrect. You are going to be returned to the Available skills menu");
                } else System.out.println("There is no skill matching your input. Please try again.");
            }*/
        }
    }
    public  void optForSpellSlotMod(){
        Spell currentSpell = null;
        boolean on;
        playableCharacter.getSpellSlot().currentSpells();
        int slot=chooseSpellSlot();
        showAllSpells();
        System.out.println("Type the name of the spell you want to check out.");
        Scanner scanner= new Scanner(System.in);
        String input;
        input=scanner.nextLine();
        List<Spell> spells= playableCharacter.getInventory().getAllSpells();
        chooseSpell(input,slot);
    }
    public void checkEnoughSkillPoints(){
        if(playableCharacter.getSkillPoints()>=1){
            System.out.println("Note: You have available skills to unlock");
        }
    }
    public void chooseAvailableSkill(String entry){
        Scanner scanner = new Scanner(System.in);
        String input;
        List<Skill> availableSkills = skillTree.getAvailableSkills();
        for (Skill skill : availableSkills) {
            if (entry.equals(skill.getName())) {
                System.out.println("The skill named "+skill.getName()+" has the following effect: "+ skill.getDescription());
                System.out.println("Do you want to unlock this skill? Yes or No");
                input=scanner.nextLine();
                verifySkillAcquisition(input,skill);

            } else System.out.println("There is no skill matching your input. Please try again.");
        }
    }
    public void verifySkillAcquisition(String input,Skill skill){
        if(input.equals("Yes")) {
            skillTree.unlockSkill(skill, playableCharacter);
        }else if(input.equals("No")){}
        else System.out.println("Your input was incorrect. You are going to be returned to the Available skills menu");
    }

    public void chooseSpell(String entry,List<Spell> spells) {
        Spell currentSpell = null;
        boolean check=true;
        Scanner scanner= new Scanner(System.in);
        String input;
        for (Spell spell : spells) {       //Gia na mporesoume na to dei3oume kalutera me while loops oi me8odoi choooseSpell() kai verifyChanges() kai chooseSpellToRemove() einai oles mazi edw mesa. uparxoun 3exwrista kai pio 3exwrista.
            if (entry.equals(spell.getName())) {
                System.out.println("The " + spell.getName() + " is a " + spell.getDamageType() + " Type damage spell that does " + spell.getDamage() + " base damage. If you equip it the total damage is going to be " + playableCharacter.getSpellSlot().totalSpellDamage(spell));
                currentSpell = spell;
                check = false;
            }
        }
        if (check) {
            System.out.println("Your input was incorrect. Please try again.");
        } else if (playableCharacter.getSpellSlot().spellIsEquiped(currentSpell)) {
            System.out.println("This Spell is already equiped.");
        } else {
            System.out.println("Do you want to equip this spell?");
            input = scanner.nextLine();
            verifyChanges(input,currentSpell);
        }
    }
    public void verifyChanges(String input,Spell currentSpell){
        Scanner scanner=new Scanner(System.in);
        if (input.equals("Yes")) {
            if (playableCharacter.getSpellSlot().getNumberOfSpellsEquiped() < 4) {
                playableCharacter.getSpellSlot().addSpell(currentSpell);
            } else {
                System.out.println("Your Spell Slots are full.");
                for (Spell spell : playableCharacter.getSpellSlot().getSpellSlots()) {
                    System.out.println("- " + spell.getName());
                }
                System.out.println("Please type the spell you want to remove in order to add "+currentSpell.getName()+" :");
                input = scanner.nextLine();
                System.out.println(playableCharacter.getSpellSlot().getSpellByName(input).getName());
                if (playableCharacter.getSpellSlot().getSpellByName(input) != null) {
                    playableCharacter.getSpellSlot().changeSpell(currentSpell, playableCharacter.getSpellSlot().getSpellByName(input));
                }
            }
            System.out.println("The total amount of spells equiped is: " + playableCharacter.getSpellSlot().getNumberOfSpellsEquiped());
        } else if (input.equals("No")) {
        } else System.out.println("Your input was incorrect. Please type \"Yes\" or \"No\"");
    }


    public void showAllSpells(){
        List<Spell> spells= playableCharacter.getInventory().getAllSpells();
        System.out.println("All the spells That you own are:");
        if(spells==null){
            System.out.println("You currently don't own any spells");
        }else {
            for (Spell spell : spells) {
                System.out.println("- " + spell.getName());
            }

        }
    }
    public int chooseSpellSlot() {
        System.out.println("Type the number of the slot you want to change.");
        Scanner scanner= new Scanner(System.in);
        String input;
        int slot=0;
        input=scanner.nextLine();
        if(input.equals("Exit")){return 0;}
        try {
            slot= Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Your input was not Valid");
        }if(slot>4){
            System.out.println("You dont have that many slots. You are going to change the slot 4 since that is the closest one to your input.");
            return 4;}
        return slot;
    }
    public void chooseSpell(String input,int slot){
        boolean check=true;
        boolean verify;
        Spell currentSpell=null;
        Scanner scanner=new Scanner(System.in);
        List<Spell> spells= playableCharacter.getInventory().getAllSpells();
        for(Spell spell: spells){
            if(input.equals(spell.getName())){
                System.out.println("The "+spell.getName()+" is a " + spell.getDamageType() + " Type damage spell that does " + spell.getDamage() + " base damage. If you equip it the total damage is going to be "+playableCharacter.getSpellSlot().totalSpellDamage(spell));
                currentSpell=spell;
                check=false;
            }
        }
        if(check){
            System.out.println("Your input was incorrect. Please try again.");
        }else if(playableCharacter.getSpellSlot().spellIsEquiped(currentSpell)){
            System.out.println("This Spell is already equiped.");
        }
        else{
            System.out.println("Do you want to equip this spell?");
            verify=verifyChanges();
            if(verify){
                if(playableCharacter.getSpellSlot().getNumberOfSpellsEquiped()<4) {
                    playableCharacter.getSpellSlot().addSpell(currentSpell);
                }else playableCharacter.getSpellSlot().changeSpell(currentSpell,playableCharacter.getSpellSlot().getSpellSlots().get(slot-1));
            }else if(!verify){
            }
        }
    }
    public boolean verifyChanges(){
        Scanner scanner=new Scanner(System.in);
        String input;
        boolean on=true;
        boolean option=false;
        while(on){
        input=scanner.nextLine();
        if(input.equals("Yes")){
            option=true;
            on=false;
        }else if(input.equals("No")){
            on=false;
        }else System.out.println("Your input was incorrect. Please type \"Yes\" or \"No\"");
        }
        return option;
    }
    }


