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

    @After
    public void cleanUp()
    {
        System.setOut(out);
    }
}
