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
    //PRINTING TESTS DO NOT ACCOUNT FOR DEV PRINTING

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

    @Test
    public void testStatus()
    {
        inStream = new ByteArrayInputStream("status".getBytes());
        Scanner test = new Scanner(inStream);

        Dungeon dodolsCastle = new Dungeon();
        dodolsCastle.initializeLayout();
        Hero example = new Hero(dodolsCastle.currentEntrance);

        App.actionHandler(example, false, test, true);

        String test2 = "--------------------------------------------------" + System.lineSeparator() + "Enter a command:" + System.lineSeparator() + String.format("\033[H\033[2J") + "+ Common Room +" + System.lineSeparator() + "The room is dimly lit, a cracking fire sits in a great stone hearth on the far side of the room. The walls" + System.lineSeparator() + "are lined with several tall bookshelves, while the floor is well worn bare flagstone. A table sits near the" + System.lineSeparator() + "fire, covered in various books, surrounded by three couches covered with pelts and cushions.  A mass of arcane" + System.lineSeparator() + "machinery looms in the north-east corner of the room -- various levers and whirring mechanisms that you have" + System.lineSeparator() + "never seen the like of before. A suit of old armor stands slightly hunched near the levers. There are doors" + System.lineSeparator() + "to the west, south, and east." + System.lineSeparator() + System.lineSeparator() + "You're feeling pretty well";

        assertEquals(test2, outStream.toString().trim());
    }

    @Test
    public void testLog()
    {
        inStream = new ByteArrayInputStream("west\neast\nlog".getBytes());
        Scanner test = new Scanner(inStream);

        Dungeon dodolsCastle = new Dungeon();
        dodolsCastle.initializeLayout();
        Hero example = new Hero(dodolsCastle.currentEntrance);

        App.actionHandler(example, false, test, true);

        outStream.reset();

        App.actionHandler(example, false, test, true);

        outStream.reset();

        App.actionHandler(example, false, test, true);

        String test2 = "--------------------------------------------------" + System.lineSeparator() + "Enter a command:" + System.lineSeparator() + String.format("\033[H\033[2J") + "+ Common Room +" + System.lineSeparator() + "The room is dimly lit, a cracking fire sits in a great stone hearth on the far side of the room. The walls" + System.lineSeparator() + "are lined with several tall bookshelves, while the floor is well worn bare flagstone. A table sits near the" + System.lineSeparator() + "fire, covered in various books, surrounded by three couches covered with pelts and cushions.  A mass of arcane" + System.lineSeparator() + "machinery looms in the north-east corner of the room -- various levers and whirring mechanisms that you have" + System.lineSeparator() + "never seen the like of before. A suit of old armor stands slightly hunched near the levers. There are doors" + System.lineSeparator() + "to the west, south, and east." + System.lineSeparator() + System.lineSeparator() + "You think about what you have done since you got to the castle..." + System.lineSeparator() + "-------------------- Log Book --------------------" + System.lineSeparator() + "\n" + "You moved west from Common Room to Balcony | Turn: 1" + System.lineSeparator() + "You moved east from Balcony to Common Room | Turn: 2" + System.lineSeparator() + "\n" + "--------------------------------------------------";
        assertEquals(test2, outStream.toString().trim());
    }

    @Test
    public void testPrintHelp()
    {
        inStream = new ByteArrayInputStream("help".getBytes());
        Scanner test = new Scanner(inStream);

        Dungeon dodolsCastle = new Dungeon();
        dodolsCastle.initializeLayout();
        Hero example = new Hero(dodolsCastle.currentEntrance);

        App.actionHandler(example, false, test, true);

        String test2 = "--------------------------------------------------" + System.lineSeparator() + "Enter a command:" + System.lineSeparator() + String.format("\033[H\033[2J") + "+ Common Room +" + System.lineSeparator() + "The room is dimly lit, a cracking fire sits in a great stone hearth on the far side of the room. The walls" + System.lineSeparator() + "are lined with several tall bookshelves, while the floor is well worn bare flagstone. A table sits near the" + System.lineSeparator() + "fire, covered in various books, surrounded by three couches covered with pelts and cushions.  A mass of arcane" + System.lineSeparator() + "machinery looms in the north-east corner of the room -- various levers and whirring mechanisms that you have" + System.lineSeparator() + "never seen the like of before. A suit of old armor stands slightly hunched near the levers. There are doors" + System.lineSeparator() + "to the west, south, and east." + System.lineSeparator() + System.lineSeparator() + "Common actions: move (any direction) | examine | take | status | log | inventory" + System.lineSeparator() + "Listing actions currently available to you:" + System.lineSeparator() + "\t- punch self" + System.lineSeparator() + System.lineSeparator() + "\t- examine bookshelves" + System.lineSeparator() + System.lineSeparator() + "\t- examine table" + System.lineSeparator() + System.lineSeparator() + "\t- examine machinery" + System.lineSeparator() + System.lineSeparator() + "\t- examine armor" + System.lineSeparator() + System.lineSeparator() + "\t- examine lever" + System.lineSeparator() + System.lineSeparator() + "\t- pull lever";
        assertEquals(test2, outStream.toString().trim());
    }

    @Test
    public void testWelcome()
    {
        Dungeon dodolsCastle = new Dungeon();
        dodolsCastle.initializeLayout();

        App.welcomeMessage();

        String test = "----------+++| Dodol's Castle |+++----------" + System.lineSeparator() + System.lineSeparator() + "Welcome to the text-based adventure game, Dodol's Castle!" + System.lineSeparator() + "Version: yes" + System.lineSeparator() + System.lineSeparator() + System.lineSeparator() + "On one quiet summer night you find yourself stumbling through a strange door on your way back from the bathroom," + System.lineSeparator() + "you feel the door close behind you, and as you glance over your shoulder you see it disappear into a stone" + System.lineSeparator() + "wall...";
        assertEquals(test, outStream.toString().trim());
    }

    @Test
    public void testAppInventory()
    {
        inStream = new ByteArrayInputStream("examine table\ntake potion\ninventory".getBytes());
        Scanner test = new Scanner(inStream);

        Dungeon dodolsCastle = new Dungeon();
        dodolsCastle.initializeLayout();
        Hero example = new Hero(dodolsCastle.currentEntrance);

        App.actionHandler(example, false, test, true);

        outStream.reset();

        App.actionHandler(example, false, test, true);

        outStream.reset();

        App.actionHandler(example, false, test, true);

        String test2 = "--------------------------------------------------" + System.lineSeparator() + "Enter a command:" + System.lineSeparator() + String.format("\033[H\033[2J") + "+ Common Room +" + System.lineSeparator() + "The room is dimly lit, a cracking fire sits in a great stone hearth on the far side of the room. The walls" + System.lineSeparator() + "are lined with several tall bookshelves, while the floor is well worn bare flagstone. A table sits near the" + System.lineSeparator() + "fire, covered in various books, surrounded by three couches covered with pelts and cushions.  A mass of arcane" + System.lineSeparator() + "machinery looms in the north-east corner of the room -- various levers and whirring mechanisms that you have" + System.lineSeparator() + "never seen the like of before. A suit of old armor stands slightly hunched near the levers. There are doors" + System.lineSeparator() + "to the west, south, and east." + System.lineSeparator() + System.lineSeparator() + "You are carrying:" + System.lineSeparator() + "\t- potion";
        assertEquals(test2, outStream.toString().trim());
    }

    @Test
    public void testActions()
    {
        inStream = new ByteArrayInputStream("examine table".getBytes());
        Scanner test = new Scanner(inStream);

        Dungeon dodolsCastle = new Dungeon();
        dodolsCastle.initializeLayout();
        Hero example = new Hero(dodolsCastle.currentEntrance);

        App.actionHandler(example, false, test, true);

        String test2 = "--------------------------------------------------" + System.lineSeparator() + "Enter a command:" + System.lineSeparator() + String.format("\033[H\033[2J") + "+ Common Room +" + System.lineSeparator() + "The room is dimly lit, a cracking fire sits in a great stone hearth on the far side of the room. The walls" + System.lineSeparator() + "are lined with several tall bookshelves, while the floor is well worn bare flagstone. A table sits near the" + System.lineSeparator() + "fire, covered in various books, surrounded by three couches covered with pelts and cushions.  A mass of arcane" + System.lineSeparator() + "machinery looms in the north-east corner of the room -- various levers and whirring mechanisms that you have" + System.lineSeparator() + "never seen the like of before. A suit of old armor stands slightly hunched near the levers. There are doors" + System.lineSeparator() + "to the west, south, and east." + System.lineSeparator() + System.lineSeparator() + "You examine the table, among the old books scattered around you see a small red potion.";
        assertEquals(test2, outStream.toString().trim());
    }

    @Test
    public void testWrongInput()
    {
        inStream = new ByteArrayInputStream("something".getBytes());
        Scanner test = new Scanner(inStream);

        Dungeon dodolsCastle = new Dungeon();
        dodolsCastle.initializeLayout();
        Hero example = new Hero(dodolsCastle.currentEntrance);

        App.actionHandler(example, false, test, true);

        String test2 = "--------------------------------------------------" + System.lineSeparator() + "Enter a command:" + System.lineSeparator() + "Please enter a valid action, type 'help' for more info";
        assertEquals(test2, outStream.toString().trim());
    }

    @After
    public void cleanUp()
    {
        System.setIn(in);
        System.setOut(out);
    }
}
