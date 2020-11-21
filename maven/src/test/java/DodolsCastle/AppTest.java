package DodolsCastle;

import static org.junit.Assert.*;

import java.io.*;
import java.util.Scanner;

import org.junit.*;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    private final InputStream in = System.in;
    private final PrintStream out = System.out;
    ByteArrayInputStream inStream = new ByteArrayInputStream("west\neast\nsouth\nnorth".getBytes());
    private final ByteArrayOutputStream outStream = new ByteArrayOutputStream();

    @Before
    public void setUp()
    {
        System.setIn(inStream);
        System.setOut(new PrintStream(outStream));
    }

    @Test
    public void testMovement()
    {
        Scanner test = new Scanner(inStream);

        Dungeon dodolsCastle = new Dungeon();
        dodolsCastle.initializeLayout();
        Hero example = new Hero(dodolsCastle.currentEntrance);

        App.actionHandler(example, false, test, true);

        String testName = "Balcony";
        String testDesc = "The door opens into a small balcony with a panoramic mountaintop view above the clouds. " +
        "Though the wind howls around you, it seems to be reduced to no more than a gentle breeze here, and feels somewhat warm " +
        "despite the icy landscape all around.  A small wooden table with two chairs sits in the corner, atop it are two goblets " +
        "and a simple chess set. The only door leads back to the east.";

        String actualName = example.currentRoom.name;
        String actualDesc = example.currentRoom.description;

        String[] testArray = {testName, testDesc};
        String[] testArray2 = {actualName, actualDesc};
        assertArrayEquals(testArray, testArray2);

        App.actionHandler(example, false, test, true);

        testName = "Common Room";
        testDesc = "The room is dimly lit, a cracking fire sits in a great stone hearth on the far side of the room. " +
        "The walls are lined with several tall bookshelves, while the floor is well worn bare flagstone. A table sits near the fire, " +
        "covered in various books, surrounded by three couches covered with pelts and cushions.  A mass of arcane machinery looms " + 
        "in the north-east corner of the room -- various levers and whirring mechanisms that you have never seen the like of before. " +
        "A suit of old armor stands slightly hunched near the levers. " + 
        "There are doors to the west, south, and east.";

        assertArrayEquals(testArray, testArray2);

        App.actionHandler(example, false, test, true);

        testName = "North Hall";
        testDesc = "A long hallway stretches north to south with doors on either side. The way is lit by " +
        "torches hanging from sconces in the walls, a locked and shuttered window is in the middle, through it you look down on a bustling " +
        "medieval town on a river. " +  
        "There are doors to the north and south.";

        assertArrayEquals(testArray, testArray2);

        App.actionHandler(example, false, test, true);
        
        testName = "Common Room";
        testDesc = "The room is dimly lit, a cracking fire sits in a great stone hearth on the far side of the room. " +
        "The walls are lined with several tall bookshelves, while the floor is well worn bare flagstone. A table sits near the fire, " +
        "covered in various books, surrounded by three couches covered with pelts and cushions.  A mass of arcane machinery looms " + 
        "in the north-east corner of the room -- various levers and whirring mechanisms that you have never seen the like of before. " +
        "A suit of old armor stands slightly hunched near the levers. " + 
        "There are doors to the west, south, and east.";

        assertArrayEquals(testArray, testArray2);

        test.close();
    }

    @After
    public void cleanUp()
    {
        System.setIn(in);
        System.setOut(out);
    }
}
