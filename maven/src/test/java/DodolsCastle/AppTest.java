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
    ByteArrayInputStream inStream = new ByteArrayInputStream("west".getBytes());
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

        String[] testArray = {"Balcony", "The door opens into a small balcony with a panoramic mountaintop view above the clouds. " +
        "Though the wind howls around you, it seems to be reduced to no more than a gentle breeze here, and feels somewhat warm " +
        "despite the icy landscape all around.  A small wooden table with two chairs sits in the corner, atop it are two goblets " +
        "and a simple chess set. The only door leads back to the east."};
        String[] testArray2 = {example.currentRoom.name, example.currentRoom.description};
        
        assertArrayEquals(testArray, testArray2);
        //assertEquals("Testing", outStream.toString().trim());
        test.close();
    }

    @After
    public void cleanUp()
    {
        System.setIn(in);
        System.setOut(out);
    }
}
