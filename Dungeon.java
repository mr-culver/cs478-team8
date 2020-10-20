package DodolsCastle;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Dungeon {
    Room currentEntrance;
    Room Escape;
    ArrayList<Room> altEntrances; //array list in use because regular list cannot change its size
    //after instantiation
    ArrayList<Room> layout;
    Room cur;
    ArrayList<Room> alt;


    public Dungeon()
    {
        this.currentEntrance = cur;
        this.altEntrances = alt;
        this.altEntrances = new ArrayList<Room>();
        this.layout = new ArrayList<Room>();
    }

    public void selectLayout(int select)
    {
        //selects a layout from predefined options.
        //could add randomization later if there is time?
        if (select == 0)
        {
        Room Entrance = new Room("The Entrance to dodol's castle", "Entrance");
        layout.add(Entrance);
        Room Exit = new Room("The Exit to dodol's castle", "Exit");
        this.layout.add(Exit);
        Room ROOM1 = new Room("RANDOM ROOM1", "ROOM1");
        this.layout.add(ROOM1);
        Room ROOM2 = new Room("RANDOM ROOM2", "ROOM2");
        this.layout.add(ROOM2);
        Room ROOM3 = new Room("RANDOM ROOM3", "ROOM3");
        this.layout.add(ROOM3);
        this.currentEntrance = Entrance;
        this.Escape = Exit;
        Collections.shuffle(layout);

        for (int i = 0; i < layout.size();i++) 
        { 		      
            System.out.println(layout.get(i)); 		
        }
        System.out.println("Done"); 		

        

        }

    }

    public Room getEntrance()
    {
        return this.currentEntrance;
    }
}
