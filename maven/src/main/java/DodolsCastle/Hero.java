package DodolsCastle;

import java.util.*;

public class Hero {
    Room currentRoom;
    ArrayList<Action> actions;
    int status;
    int turnCounter;
    ArrayList<String> history;

    public Hero(Room start)
    {
        this.currentRoom = start;
        this.status = 30; //start with some initial hp value
        this.turnCounter = 0; 
        this.history = new ArrayList<String>();
        this.actions = new ArrayList<Action>();
        this.actions.addAll(getStarterHeroActions());
    }

    public Room getRoom()
    {
        return this.currentRoom;
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
            history.add(event + " | Turn: " + this.turnCounter);
        }
    }

    public ArrayList<String> getHistory()
    {
        return this.history;
    }

    public ArrayList<String> getAvailableMoves()
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

    public ArrayList<Action> getStarterHeroActions()
    {
        ArrayList<Action> starterActions = new ArrayList<Action>();
        
        // > Hero actions
        // >> Punch self - for testing
        Action punchSelf = new Action();
        punchSelf.name = "punch self";
        punchSelf.description = "You punch yourself in the face. Ouch!";
        punchSelf.heroStatusModifier = -10;
        starterActions.add(punchSelf);

        Action checkHistory  = new Action();
        checkHistory.name = "check log";
        checkHistory.description = "You checked your log book. It states: ";
        checkHistory.heroStatusModifier = 0;
        starterActions.add(checkHistory);

        return starterActions;
    }

    public void moveRoom(int direction)
    {
        if(direction >= 0 && direction <= 4)
        {
            currentRoom = currentRoom.doors[direction];
        }
    }
}