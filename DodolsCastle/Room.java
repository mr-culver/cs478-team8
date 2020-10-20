package DodolsCastle;

import java.util.*;

public class Room {
    String description;
    ArrayList<Action> actions;
    Room[] doors;
    String shortDescription; //possibly an id or shorter version of the regular description

    public Room(String desc, String shortDesc)
    {
        this.description = desc;
        this.shortDescription = shortDesc;
        //maybe initialize doors here as well
    }

    public String getDescription()
    {
        return this.description;
    }

    public ArrayList<Action> geActions()
    {
        return this.actions;
    }

    public void updateDescription()
    {
        //update the description after an event
    }

    public void addAction(Action x)
    {
        //add an action to the list
    }

    public void removeAction(Action x)
    {
        //remove an action from the list
    }
}
