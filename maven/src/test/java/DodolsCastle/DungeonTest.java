package DodolsCastle;

import static org.junit.Assert.*;

import org.junit.Test;

public class DungeonTest {
    
    @Test
    public void testDungeonLayout()
    {
        Dungeon test = new Dungeon();
        Room[][] test2 = new Room[4][4];
        assertArrayEquals(test2, test.layout);
    }

    @Test
    public void testGetEntrance()
    {
        Dungeon test = new Dungeon();
        test.initializeLayout();

        String crDescription = "The room is dimly lit, a cracking fire sits in a great stone hearth on the far side of the room. " +
        "The walls are lined with several tall bookshelves, while the floor is well worn bare flagstone. A table sits near the fire, " +
        "covered in various books, surrounded by three couches covered with pelts and cushions.  A mass of arcane machinery looms " + 
        "in the north-east corner of the room -- various levers and whirring mechanisms that you have never seen the like of before. " +
        "A suit of old armor stands slightly hunched near the levers. " + 
        "There are doors to the west, south, and east.";
        Room testRoom = new Room("Common Room", crDescription);

        String[] testArray = {testRoom.name, testRoom.description};
        String[] testArray2 = {test.getEntrance().name, test.getEntrance().description};
        assertArrayEquals(testArray, testArray2);
    }

    @Test
    public void testInitializeArray()
    {
        Dungeon test = new Dungeon();
        test.initializeLayout();

        String testDesc = "The door opens into a small balcony with a panoramic mountaintop view above the clouds. " +
        "Though the wind howls around you, it seems to be reduced to no more than a gentle breeze here, and feels somewhat warm " +
        "despite the icy landscape all around.  A small wooden table with two chairs sits in the corner, atop it are two goblets " +
        "and a simple chess set. The only door leads back to the east.";
        String testName = "Balcony";

        assertEquals(testName, test.layout[0][0].name);
        assertEquals(testDesc, test.layout[0][0].description);

        testDesc = "The room is dimly lit, a cracking fire sits in a great stone hearth on the far side of the room. " +
        "The walls are lined with several tall bookshelves, while the floor is well worn bare flagstone. A table sits near the fire, " +
        "covered in various books, surrounded by three couches covered with pelts and cushions.  A mass of arcane machinery looms " + 
        "in the north-east corner of the room -- various levers and whirring mechanisms that you have never seen the like of before. " +
        "A suit of old armor stands slightly hunched near the levers. " + 
        "There are doors to the west, south, and east.";
        testName = "Common Room";

        assertEquals(testName, test.layout[0][1].name);
        assertEquals(testDesc, test.layout[0][1].description);

        testDesc = "You are in a dense, lush forest. It feels as though it is a spring morning, birds sing in the distance. " + 
        "There is a long dirt path running east to west, and you can see a clearing through the thicket to the south.";
        testName = "Arboretum";

        assertEquals(testName, test.layout[0][2].name);
        assertEquals(testDesc, test.layout[0][2].description);

        testDesc = "Dodol's old lab, everything is dusty and some stuff is broken, maybe some" +
        " explanation as to who dodol is and a hint that hes the inactive suit of armor in the common room, as well as" +
        " perhaps needing the hat back " + 
        "The only door leads back to the west.";
        testName = "Laboratory";

        assertEquals(testName, test.layout[0][3].name);
        assertEquals(testDesc, test.layout[0][3].description);

        assertEquals(null, test.layout[1][0]);

        testDesc = "A long hallway stretches north to south with doors on either side. The way is lit by " +
        "torches hanging from sconces in the walls, a locked and shuttered window is in the middle, through it you look down on a bustling " +
        "medieval town on a river. " +  
        "There are doors to the north and south.";
        testName = "North Hall";

        assertEquals(testName, test.layout[1][1].name);
        assertEquals(testDesc, test.layout[1][1].description);

        testDesc = "After trudging through the dense forest you enter a small clearing, " + 
        "a small pond fed by a spring is in the center. " +
        "You can see the path through the trees back to the north, the rest of the wood is too thick to traverse.";
        testName = "Clearing";

        assertEquals(testName, test.layout[1][2].name);
        assertEquals(testDesc, test.layout[1][2].description);

        assertEquals(null, test.layout[1][3]);

        testDesc = "Large medieval kitchen with unseen servants doing some cleaning and whatnot" +
        " some appliances from our world can be seen as well " + 
        "The only door leads back to the east.";
        testName = "Kitchen";

        assertEquals(testName, test.layout[2][0].name);
        assertEquals(testDesc, test.layout[2][0].description);

        testDesc = "Middle hall portion, connects to the hall above, kitchen to the west, " +
        " Dawnelle's room to the east, and the south hall to the south. " + 
        "There are doors to the north, south, east, and west.";
        testName = "Middle Hall";

        assertEquals(testName, test.layout[2][1].name);
        assertEquals(testDesc, test.layout[2][1].description);

        testDesc = "Room with a cat on a desk over a book holding a quill, scurries off " + 
        "The only door leads back to the west.";
        testName = "Cat's Room";

        assertEquals(testName, test.layout[2][2].name);
        assertEquals(testDesc, test.layout[2][2].description);

        assertEquals(null, test.layout[2][3]);

        testDesc = "Wizardy room, maybe a magic defense, hint to hat solution " + 
        "The only door leads back to the east.";
        testName = "Aurum's Room";

        assertEquals(testName, test.layout[3][0].name);
        assertEquals(testDesc, test.layout[3][0].description);

        testDesc = "South hall portion, connects to stuff " + 
        "THere are doors to the north, west, and east.";
        testName = "South Hall";

        assertEquals(testName, test.layout[3][1].name);
        assertEquals(testDesc, test.layout[3][1].description);

        testDesc = "Cleric's room, devoted to martial training and prayer, sparse, other hint " + 
        "The only door leads back to the east.";
        testName = "Jondar's Room";

        assertEquals(testName, test.layout[3][2].name);
        assertEquals(testDesc, test.layout[3][2].description);

        assertEquals(null, test.layout[3][3]);
    }

    @Test
    public void testDoors()
    {
        Dungeon test = new Dungeon();
        test.initializeLayout();

        String testName = "Common Room";

        assertEquals(null, test.layout[0][0].doors[0]);
        assertEquals(testName, test.layout[0][0].doors[1].name);
        assertEquals(null, test.layout[0][0].doors[2]);
        assertEquals(null, test.layout[0][0].doors[3]);

        testName = "Arboretum";

        assertEquals(null, test.layout[0][1].doors[0]);
        assertEquals(testName, test.layout[0][1].doors[1].name);
        testName = "North Hall";
        assertEquals(testName, test.layout[0][1].doors[2].name);
        testName = "Balcony";
        assertEquals(testName, test.layout[0][1].doors[3].name);

        testName = "Laboratory";

        assertEquals(null, test.layout[0][2].doors[0]);
        assertEquals(testName, test.layout[0][2].doors[1].name);
        testName = "Clearing";
        assertEquals(testName, test.layout[0][2].doors[2].name);
        testName = "Common Room";
        assertEquals(testName, test.layout[0][2].doors[3].name);

        testName = "Arboretum";

        assertEquals(null, test.layout[0][3].doors[0]);
        assertEquals(null, test.layout[0][3].doors[1]);
        assertEquals(null, test.layout[0][3].doors[2]);
        assertEquals(testName, test.layout[0][3].doors[3].name);

        assertEquals(null, test.layout[1][0]);

        testName = "Common Room";

        assertEquals(testName, test.layout[1][1].doors[0].name);
        assertEquals(null, test.layout[1][1].doors[1]);
        testName = "Middle Hall";
        assertEquals(testName, test.layout[1][1].doors[2].name);
        assertEquals(null, test.layout[1][1].doors[3]);

        testName = "Arboretum";

        assertEquals(testName, test.layout[1][2].doors[0].name);
        assertEquals(null, test.layout[1][2].doors[1]);
        assertEquals(null, test.layout[1][2].doors[2]);
        assertEquals(null, test.layout[1][2].doors[3]);

        assertEquals(null, test.layout[1][3]);

        testName = "Middle Hall";

        assertEquals(null, test.layout[2][0].doors[0]); 
        assertEquals(testName, test.layout[2][0].doors[1].name);
        assertEquals(null, test.layout[2][0].doors[2]);       
        assertEquals(null, test.layout[2][0].doors[3]);

        testName = "North Hall";

        assertEquals(testName, test.layout[2][1].doors[0].name);
        testName = "Cat's Room";
        assertEquals(testName, test.layout[2][1].doors[1].name);
        testName = "South Hall";
        assertEquals(testName, test.layout[2][1].doors[2].name);
        testName = "Kitchen";
        assertEquals(testName, test.layout[2][1].doors[3].name);

        testName = "Middle Hall";

        assertEquals(null, test.layout[2][2].doors[0]);
        assertEquals(null, test.layout[2][2].doors[1]);
        assertEquals(null, test.layout[2][2].doors[2]);
        assertEquals(testName, test.layout[2][2].doors[3].name);

        assertEquals(null, test.layout[2][3]);

        testName = "South Hall";

        assertEquals(null, test.layout[3][0].doors[0]);
        assertEquals(testName, test.layout[3][0].doors[1].name);
        assertEquals(null, test.layout[3][0].doors[2]);
        assertEquals(null, test.layout[3][0].doors[3]);

        testName = "Middle Hall";

        assertEquals(testName, test.layout[3][1].doors[0].name);
        testName = "Jondar's Room";
        assertEquals(testName, test.layout[3][1].doors[1].name);
        assertEquals(null, test.layout[3][1].doors[2]);
        testName = "Aurum's Room";
        assertEquals(testName, test.layout[3][1].doors[3].name);

        testName = "South Hall";

        assertEquals(null, test.layout[3][2].doors[0]);
        assertEquals(null, test.layout[3][2].doors[1]);
        assertEquals(null, test.layout[3][2].doors[2]);
        assertEquals(testName, test.layout[3][2].doors[3].name);

        assertEquals(null, test.layout[3][3]);
    }
}
