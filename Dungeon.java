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
    Room[][] MapLayout = new Room[3][3];

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
        Room Entrance = new Room("The Entrance to Dodol's Castle", "Entrance");
        layout.add(Entrance);
        Room Exit = new Room("The Exit to Dodol's Castle", "Exit");
        this.layout.add(Exit);
        Room Kitchen = new Room("The Kitchen of Dodol's Castle", "Kitchen");
        this.layout.add(Kitchen);
        Room Bathroom = new Room("The castles bathroom", "Bathroom");
        this.layout.add(Bathroom);
        Room The_Great_Hall = new Room("The Great Hall of Dodol's Castle", "Great Hall");
        this.layout.add(The_Great_Hall);
        Room StoreRoom = new Room("The StoreRoom of Dodol's Castle", "StoreRoom");
        this.layout.add(StoreRoom);
        Room Bed_Chambers = new Room("The Bed Chambers of Dodol's Castle", "Bed Chambers");
        this.layout.add(Bed_Chambers);
        Room Kings_Quarters = new Room("The Kings Quarters of Dodol's Castle", "Kings Quarters");
        this.layout.add(Kings_Quarters);
        Room The_Throne_Room = new Room("The Throne Room of Dodol's Castle", "Throne Room");
        this.layout.add(The_Throne_Room);
        this.currentEntrance = Entrance;
        this.Escape = Exit;
        Collections.shuffle(layout);
        print();        

        }

    }
    public void print()
    {
        int m =0;
            for (int i = 0; i < 3; i++) 
            { 	
                for (int y = 0; y < 3; y++) 
                { 
                    if(MapLayout[i][y]==null)
                    {
                       MapLayout[i][y] = layout.get(m);
                       m++;
                    }
                }	 
            }
            System.out.println("------------------------------------------------------"); 
            for (int i = 0; i < 3; i++) 
            { 	
                for (int y = 0; y < 3; y++) 
                { 		 
                   System.out.print(MapLayout[i][y]); 
                }	 
                System.out.println("");
                System.out.println("------------------------------------------------------"); 

            }
    }
    

    public Room getEntrance()
    {
        return this.currentEntrance;
    }
}
