package DodolsCastle;

import java.util.*;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Dungeon DodolCastle = new Dungeon();
        DodolCastle.selectLayout(0);
    }

    public void start(Room cur)
    {
        //set current entrace and room.
        //initializes dungeon with start point.
    }

    public void actionHandler()
    {
        //displays initial room layout. Handles action recieved from other classes.
    }
    
}
