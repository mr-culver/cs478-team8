package DodolsCastle;

import static org.junit.Assert.*;

import org.junit.Test;

public class ItemTest {
    
    @Test
    public void testItemConstruct()
    {
        Item test = new Item("test", "this is a test", true);

        String[] testArray = {test.name, test.description, test.canTake.toString()};

        String[] testArray2 = {"test", "this is a test", "true"};

        assertArrayEquals(testArray2, testArray);
    }
}
