package DodolsCastle;

import static org.junit.Assert.*;

import org.junit.Test;

public class ActionTest {
    
    @Test
    public void testActionConstruct()
    {
        Action test = new Action("Test", "Description");   
        String[] array = {test.name, test.description, test.modifiedDescription, Integer.toString(test.heroStatusModifier)};
        String[] array2 = {"Test", "Description", null, "0"};

        assertArrayEquals(array2, array);
    }
}
