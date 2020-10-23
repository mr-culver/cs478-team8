package DodolsCastle;

import java.util.*;

public class Room {
    String description;
    String name;
    public ArrayList<Action> actions;
    public Room[] doors; // 0 = North, 1 = East, 2 = South, 3 = West -- Like a clock
    //String shortDescription; //possibly an id or shorter version of the regular description
    // might not need the shortDescription, added the name String for clarity
    // a room can be identified by its coordinates in the Room matrix

    public Room(String inputName, String inputDescription)
    {
        this.description = inputDescription;
        this.name = inputName;
        this.doors = new Room[4];
        this.actions = new ArrayList<Action>();
    }

    public String getDescription()
    {
        return this.description;
    }

    public ArrayList<Action> getActions()
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
