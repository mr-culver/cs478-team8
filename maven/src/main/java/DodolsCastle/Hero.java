package DodolsCastle;

import java.util.*;

public class Hero {
    Room currentRoom;
    ArrayList<Action> actions;
    int status;
    int turnCounter;
    ArrayList<String> history;
    ArrayList<Item> items;

    public Hero(Room start)
    {
        this.currentRoom = start;
        this.status = 30; //start with some initial hp value
        this.turnCounter = 0; 
        this.history = new ArrayList<String>();
        this.actions = new ArrayList<Action>();
        this.actions.addAll(initStarterHeroActions());
        this.items = new ArrayList<Item>();
    }

    public Room getRoom()
    {
        return this.currentRoom;
    }

    public void moveRoom(int direction)
    {
        if(direction >= 0 && direction <= 4)
        {
            currentRoom = currentRoom.doors[direction];
        }
    }

    public void addHistory(String event, String effect)
    {
        this.turnCounter++;

        if (effect == "north")
        {
            history.add(event + " from " + this.currentRoom.name + " to " + this.currentRoom.doors[0].name + " | Turn: " + this.turnCounter);
        }

        else if (effect == "east")
        {
            history.add(event + " from " + this.currentRoom.name + " to " + this.currentRoom.doors[1].name + " | Turn: " + this.turnCounter);
        }

        else if (effect == "south")
        {
            history.add(event + " from " + this.currentRoom.name + " to " + this.currentRoom.doors[2].name + " | Turn: " + this.turnCounter);
        }

        else if (effect == "west")
        {
            history.add(event + " from " + this.currentRoom.name + " to " + this.currentRoom.doors[3].name + " | Turn: " + this.turnCounter);
        }

        else
        {
            history.add(effect + " | Turn: " + this.turnCounter);
        }
    }

    public ArrayList<String> getHistory()
    {
        return this.history;
    }

    public void printHistory()
    {
        System.out.println("You think about what you have done since you got to the castle...");
        System.out.println("-------------------- Log Book --------------------\n");
        for (String x : history)
        {
            System.out.println(x);
        }
        System.out.println();
        System.out.println("--------------------------------------------------\n");
    }

    public ArrayList<String> getAvailableMoves() // unused
    {
        ArrayList<String> availableMoves = new ArrayList<String>();
        if(currentRoom.doors[0] != null)
            availableMoves.add("north");
        if(currentRoom.doors[1] != null)
            availableMoves.add("east");
        if(currentRoom.doors[2] != null)
            availableMoves.add("south") ;
        if(currentRoom.doors[3] != null)
            availableMoves.add("west");

        return availableMoves;
    }
    
    public String getStatusDescription(Boolean testPrinting)
    {
        String desc = "";
        if(testPrinting)
            desc = "[Dev] Status = " + status + "\n";
        if(status >= 50)
        {
            desc += "You feel absolutely fantastic.";
        }
        else if(status >= 30)
        {
            desc += "You're feeling pretty well";
        }
        else if(status >= 15)
        {
            desc += "You arent feeling very well";
        }
        else if(status >= 1)
        {
            desc += "You feel very poorly";
        }
        else
        {
            desc += "You are incapacitated.";
        }
        return desc;
    }

    public void printInventory()
    {
        if(items.isEmpty())
        {
            System.out.println("You are not carrying anything.");
        }
        else
        {
            System.out.println("You are carrying:");
            for(Item i : items)
            {
                System.out.println("\t- " + i.name);
            }
            System.out.println();
        }   
    }

    public ArrayList<Action> initStarterHeroActions()
    {
        ArrayList<Action> starterActions = new ArrayList<Action>();
        
        // > Hero actions
        // >> Punch self - for testing
        Action punchSelf = new Action();
        punchSelf.name = "punch self";
        punchSelf.description = "You punch yourself in the face. Ouch!";
        punchSelf.heroStatusModifier = -10;
        starterActions.add(punchSelf);

        return starterActions;
    }

    
}