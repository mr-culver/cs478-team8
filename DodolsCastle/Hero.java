package DodolsCastle;

import java.util.*;

public class Hero {
    Room currentRoom;
    ArrayList<Action> actions;
    int status;
    ArrayList<String> history;

    public Hero(Room start)
    {
        this.currentRoom = start;
        this.status = 30; //start with some initial hp value
        this.history = new ArrayList<String>();
        this.actions = new ArrayList<Action>();
        this.actions.addAll(getStarterHeroActions());
    }

    public Room getRoom()
    {
        return this.currentRoom;
    }

    public void moveRoom(Room inputRoom)
    {
        this.currentRoom = inputRoom;
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

        return starterActions;
    }
}
