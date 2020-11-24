package DodolsCastle;

import static org.junit.Assert.*;

import java.util.ArrayList;

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

    @Test
    public void testRunAction()
    {
        Room start = new Room("test", "something");
        Hero example = new Hero(start);
        Action test = new Action("Test", "Description"); 

        ArrayList<ArrayList<Action>> array = new ArrayList<ArrayList<Action>>();
        array.add(test.heroActionsAdd);
        array.add(test.heroActionsSub);
        array.add(test.roomActionsAdd);
        array.add(test.roomActionsSub);
        array.add(test.requirementsPos);
        array.add(test.requirementsNeg);
        array.add(test.itemRequirements);

        ArrayList<Action> heroActionsAdd = new ArrayList<Action>();
        ArrayList<Action> heroActionsSub = new ArrayList<Action>();
        ArrayList<Action> roomActionsAdd = new ArrayList<Action>();
        ArrayList<Action> roomActionsSub = new ArrayList<Action>();
        ArrayList<Action> requirementsPos = new ArrayList<Action>();
        ArrayList<Action> requirementsNeg = new ArrayList<Action>();
        ArrayList<Action> itemRequirements = new ArrayList<Action>();

        ArrayList<ArrayList<Action>> array2 = new ArrayList<ArrayList<Action>>();

        array2.add(heroActionsAdd);
        array2.add(heroActionsSub);
        array2.add(roomActionsAdd);
        array2.add(roomActionsSub);
        array2.add(requirementsPos);
        array2.add(requirementsNeg);
        array2.add(itemRequirements);

        assertEquals(array2, array);

        test.heroActionsAdd.add(test);
        test.runAction(example);

        assertEquals(test, example.actions.get(1));

        test.heroActionsAdd.remove(test);

        String[] array3 = {"punch self", "You punch yourself in the face. Ouch!"};
        String[] array4 = {example.actions.get(0).name, example.actions.get(0).description};
        
        test.heroActionsSub.add(test);
        test.runAction(example);

        assertArrayEquals(array3, array4);

        test.heroActionsSub.remove(test);

        test.roomActionsAdd.add(test);
        test.runAction(example);

        assertEquals(test, example.currentRoom.actions.get(0));

        test.roomActionsAdd.remove(test);
        test.roomActionsSub.add(test);
        test.runAction(example);

        assertEquals(0, example.currentRoom.actions.size());

        test.roomActionsSub.remove(test);

        Item fake = new Item("test", "something else", true);
        fake.heroActionsAdd.add(test);
        test.heroItemAdd = fake;

        test.runAction(example);

        assertEquals(test, example.actions.get(1));

        test.heroItemSub = fake;
        test.heroItemAdd = null;

        test.runAction(example);

        assertArrayEquals(array3, array4);
    }
}
