package DodolsCastle;

import static org.junit.Assert.*;

import java.io.*;

import org.junit.*;

public class PrintTest {
    
    private final PrintStream out = System.out;
    private final ByteArrayOutputStream outStream = new ByteArrayOutputStream();

    @Before
    public void setUp()
    {
        System.setOut(new PrintStream(outStream));
    }

    @Test
    public void testHeroInventory()
    {
        Dungeon dodolsCastle = new Dungeon();
        dodolsCastle.initializeLayout();
        Hero example = new Hero(dodolsCastle.currentEntrance);

        example.printInventory();

        assertEquals("You are not carrying anything.", outStream.toString().trim());
        outStream.reset();

        Item test = new Item("test", "something", true);
        example.items.add(test);

        example.printInventory();

        assertEquals("You are carrying:" + System.lineSeparator() + "\t- test", outStream.toString().trim());
    }

    @Test
    public void testHeroHistory()
    {
        Dungeon dodolsCastle = new Dungeon();
        dodolsCastle.initializeLayout();
        Hero example = new Hero(dodolsCastle.currentEntrance);

        example.history.add("Test something");

        example.printHistory();

        String test = "You think about what you have done since you got to the castle..." + System.lineSeparator() + "-------------------- Log Book --------------------\n" + System.lineSeparator() + "Test something" + System.lineSeparator() + System.lineSeparator() + "--------------------------------------------------";
        assertEquals(test, outStream.toString().trim());
    }

    @Test
    public void testRunActionPrint()
    {
        Dungeon dodolsCastle = new Dungeon();
        dodolsCastle.initializeLayout();
        Hero example = new Hero(dodolsCastle.currentEntrance);
        Action test = new Action("test", "something");
        test.heroStatusModifier = -1;

        test.runAction(example);
        example.printHistory();

        String test2 = "You think about what you have done since you got to the castle..." + System.lineSeparator() + "-------------------- Log Book --------------------\n" + System.lineSeparator() + "-1 | Turn: 1" + System.lineSeparator() + System.lineSeparator() + "--------------------------------------------------";
        
        assertEquals(test2, outStream.toString().trim());
        outStream.reset();
        example.history.remove(0);

        test.heroStatusModifier = 1;
        test.runAction(example);
        example.printHistory();

        test2 = "You think about what you have done since you got to the castle..." + System.lineSeparator() + "-------------------- Log Book --------------------\n" + System.lineSeparator() + "1 | Turn: 2" + System.lineSeparator() + System.lineSeparator() + "--------------------------------------------------";
        assertEquals(test2, outStream.toString().trim());
    }

    @After
    public void cleanUp()
    {
        System.setOut(out);
    }
}
