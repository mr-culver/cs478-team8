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
    }

    public Room getRoom()
    {
        return this.currentRoom;
    }

    public void moveRoom(Room inputRoom)
    {
        this.currentRoom = inputRoom;
    }

    public String getPossibleMoves()
    {
        String possibleMoves = "You can move through a door to the ";
        if(currentRoom.doors[0] != null)
            possibleMoves += "North ";
        if(currentRoom.doors[1] != null)
            possibleMoves += "East ";
        if(currentRoom.doors[2] != null)
            possibleMoves += "South ";
        if(currentRoom.doors[3] != null)
            possibleMoves += "West ";

        return possibleMoves;
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
