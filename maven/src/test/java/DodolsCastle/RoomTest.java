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

    @Test
    public void testGetActions()
    {
        Room test = new Room("Test", "description");

        ArrayList<Action> actions2 = new ArrayList<Action>();

        Action testAction = new Action("test", "something");

        test.actions.add(testAction);

        actions2.add(testAction);

        assertEquals(actions2, test.getActions());
    }

    @Test
    public void testUpdateDescription()
    {   
        Room test = new Room("Test", "description");

        String newDescription = "another description";

        test.updateDescription("another description");

        assertEquals(newDescription, test.getDescription());
    }

    @Test
    public void addAction()
    {
        Room test = new Room("Test", "description");

        ArrayList<Action> actions2 = new ArrayList<Action>();

        Action testAction = new Action("test", "something");

        actions2.add(testAction);

        test.addAction(testAction);

        assertEquals(actions2, test.getActions());
    }

    @Test
    public void removeAction()
    {
        Room test = new Room("Test", "description");

        ArrayList<Action> actions2 = new ArrayList<Action>();

        Action testAction = new Action("test", "something");

        actions2.add(testAction);

        test.addAction(testAction);

        Action testAction2 = new Action("test2", "yet another action");

        actions2.add(testAction2);
        test.addAction(testAction2);

        actions2.remove(testAction);
        test.removeAction(testAction);

        assertEquals(actions2, test.getActions());
    }
}
