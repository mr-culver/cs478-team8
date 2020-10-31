package DodolsCastle;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class RoomTest {
    
    @Test
    public void testRoomConstruct()
    {
        Room test = new Room("Test", "description");
        Object[] array = {test.name, test.description, test.doors, test.actions};

        Room[] doors2 = new Room[4];
        ArrayList<Action> actions2 = new ArrayList<Action>();
        Object[] array2 = {"Test", "description", doors2, actions2};

        assertArrayEquals(array2, array);
    }

    @Test
    public void testGetDescription()
    {
        Room test = new Room("Test", "description");
        String desc = test.getDescription();
        String desc2 = "description";

        assertEquals("description", desc2, desc);
    }
}
