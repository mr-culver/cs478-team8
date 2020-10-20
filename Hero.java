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
        this.history.add("The hero has entered the castle.");
        //maybe add beginning actions here like movement and pickup?
    }

    public Room getRoom()
    {
        return this.currentRoom;
    }

    public void moveRoom()
    {
        //move to another room
    }

    public void updateStatus(int[] range)
    {
        //do some calculation on hero status
    }

    public ArrayList<Action> geActions()
    {
        return this.actions;
    }

    public ArrayList<Action> getActions()
    {
        return this.actions;
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
