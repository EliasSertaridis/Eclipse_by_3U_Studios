import java.util.*;
import java.util.List;
import java.util.Scanner;

public class Quest {

    private String name;
    private String description;
    private List<String> objectives;
    private List<Quest> quests;
    private List<Item> wonItems;
    private boolean completed;
    public Quest(String name, String description, List<String> objectives, List<Item> wonItems, boolean complete) {
        this.name=name;
        this.description=description;

    }


    List<String> objectives = new ArrayList<>();

    List<Quest> quests = new ArrayList<>();


    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setObjectives(List<String> objectives)  {
        this.objectives=objectives;
    }
    public List<String> getObjectives() {
        return objectives;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public boolean isCompleted() {
        return completed;
    }
    public void acceptQuest(Quest quest) {
        quests.add(quest);
        System.out.println("Quest accepted: " + quest.getName());
    }

    public void trackQuest(Quest quest) {
        System.out.println("Quest tracked: " + quest.getName());
        List<String> objectives = quest.getObjectives();
        System.out.println("Objectives:");
        for (String objective : objectives) {
            System.out.println("- " + objective);
        }


        public void completeQuest(Quest quests, List<String> items, PlayableCharacter character) {
            quest.setCompleted(true);
            quests.remove(quest);
            int skillp = character.getSkillPoints();
            skillp+=1;
            character.setSkillPoints(skillp);
            Inventory.addItemToInventory(Item items);
            System.out.println("Quest completed! You earned " + skillp + " skill points and received the following items: " + earnedItems);
        }




        public void interact(NonPlayableCharacter npc)
        {
            System.out.println("NPC: " + npc.getDialogue());
            System.out.print("Accept or reject the quest? (accept/reject): ");
            Scanner scanner= new Scanner(System.in);
            String userInput = scanner.nextLine();

            if (userInput.equals("accept")) {
                // Player accepts the quest
                acceptQuest(quest);
            }
            else if(userInput.equals("reject")) {
                // Player rejects the quest
                System.out.println("Quest rejected.");
            }
            else
            {
                // Player types wrong
                System.out.println("Accept or reject the quest? (accept/reject): ");
                String userInput = scanner.nextLine();
            }
        }

    }

/*
            String questName = "Save the Village";
            List<String> objectives = new ArrayList<>();
            objectives.add("Defeat the monster");
            objectives.add("Find the lost artifact");
            System.out.println("NPC: Welcome, adventurer!");
            System.out.println("NPC: I have a quest for you: " + questName);
            System.out.println("Mission Description:");
            for (String objective : objectives) {
                System.out.println("- " + objective);
            }
            System.out.println("Do you accept this quest? (yes/no)");

            // Player accepts the quest
            player.acceptQuest(new Quest(questName, objectives));
        }
*/

}