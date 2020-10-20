package DodolsCastle;

import java.util.*;

public class Dungeon {
    Room currentEntrance;
    ArrayList<Room> altEntrances; //array list in use because regular list cannot change its size
    //after instantiation

    public Dungeon(Room cur, ArrayList<Room> alt)
    {
        this.currentEntrance = cur;
        this.altEntrances = alt;
    }

    public void selectLayout(int select)
    {
        //selects a layout from predefined options.
        //could add randomization later if there is time?
    }

    public Room getEntrance()
    {
        return this.currentEntrance;
    }
}
