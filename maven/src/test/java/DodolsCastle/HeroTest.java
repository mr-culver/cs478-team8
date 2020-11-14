package DodolsCastle;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.ArrayList;

public class HeroTest {
    
    @Test
    public void testHeroConstruct()
    {
        Room start = new Room("Test", "Description");
        Hero example = new Hero(start);

        String[] action = {example.actions.get(0).name};

        Object[] test = {example.currentRoom, example.status, example.turnCounter, example.history, action};

        Action punch = new Action();
        punch.name = "punch self";
        punch.description = "You punch yourself in the face. Ouch!";
        punch.heroStatusModifier = -10;

        String[] action2 = {punch.name};

        ArrayList<String> history2 = new ArrayList<String>();
        Object[] test2 = {start, 30, 0, history2, action2};

        assertArrayEquals(test2, test);
    }

    @Test
    public void testGetRoom()
    {
        Room start = new Room("Test", "Description");
        Hero example = new Hero(start);

        Room test = new Room("Test", "Description");

        String[] actualArray = {example.getRoom().name, example.getRoom().description};
        String[] expectedArray = {test.name, test.description};

        assertArrayEquals(expectedArray, actualArray);
    }

    @Test
    public void testCorrectMove()
    {
        Dungeon dodolsCastle = new Dungeon();
        dodolsCastle.initializeLayout();
        Hero player = new Hero(dodolsCastle.currentEntrance);
        player.moveRoom(3); // move west. south and east should work as well.
        assertEquals(dodolsCastle.layout[0][0], player.currentRoom); // should be on balcony
    }

    @Test
    public void testWrongMove()
    {
        Dungeon dodolsCastle = new Dungeon();
        dodolsCastle.initializeLayout();
        Hero player = new Hero(dodolsCastle.currentEntrance);
        player.moveRoom(0); // move north. should be null. this case is handled in main
        assertEquals(null, player.currentRoom);
    }

    @Test
    public void testMoveToHatRoom()
    {
        Dungeon dodolsCastle = new Dungeon();
        dodolsCastle.initializeLayout();
        Hero player = new Hero(dodolsCastle.currentEntrance);
        player.moveRoom(2); // move south
        player.moveRoom(2); // move south
        player.moveRoom(1); // move east
        
        assertEquals(dodolsCastle.layout[2][2], player.currentRoom); // should be in cat room
    }

    @Test
    public void testGetHistory()
    {
        Dungeon dodolsCastle = new Dungeon();
        dodolsCastle.initializeLayout();
        Hero example = new Hero(dodolsCastle.currentEntrance);

        ArrayList<String> test = new ArrayList<String>();

        assertEquals(test, example.getHistory());
    }

    @Test
    public void testAddHistory()
    {
        Dungeon dodolsCastle = new Dungeon();
        dodolsCastle.initializeLayout();
        Hero example = new Hero(dodolsCastle.currentEntrance);

        example.addHistory("test", "south");

        ArrayList<String> test = new ArrayList<String>();
        test.add("test from Common Room to North Hall | Turn: 1");

        assertEquals(test.get(0), example.history.get(0));

        test.add("-10 | Turn: 2");
        test.add("examine table | Turn: 3");

        example.addHistory("example", "-10");
        example.addHistory("example2", "examine table");

        String combine = test.get(1) + test.get(2);
        String combine2 = example.history.get(1) + example.history.get(2);
        assertEquals(combine, combine2);
        
        test.add("test from Common Room to Balcony | Turn: 4");
        example.addHistory("test", "west");

        assertEquals(test.get(3), example.history.get(3));

        test.add("test from Common Room to Arboretum | Turn: 5");
        example.addHistory("test", "east");

        assertEquals(test.get(4), example.history.get(4));

        example.currentRoom = dodolsCastle.layout[1][1];
        test.add("test from North Hall to Common Room | Turn: 6");
        example.addHistory("test", "north");

        assertEquals(test.get(5), example.history.get(5));
    }

    @Test
    public void testGetStatus()
    {
        Dungeon dodolsCastle = new Dungeon();
        dodolsCastle.initializeLayout();
        Hero example = new Hero(dodolsCastle.currentEntrance);

        String test = "You're feeling pretty well";

        assertEquals(test, example.getStatusDescription(false));

        test = "You feel absolutely fantastic.";

        example.status = 50;

        assertEquals(test, example.getStatusDescription(false));

        test = "You are incapacitated.";

        example.status = 0;

        assertEquals(test, example.getStatusDescription(false));

        test = "You arent feeling very well";

        example.status = 15;

        assertEquals(test, example.getStatusDescription(false));

        test = "You feel very poorly";

        example.status = 1;

        assertEquals(test, example.getStatusDescription(false));

        test = "[Dev] Status = 1\nYou feel very poorly";

        assertEquals(test, example.getStatusDescription(true));
    }

    @Test
    public void testInventory()
    {
        Dungeon dodolsCastle = new Dungeon();
        dodolsCastle.initializeLayout();
        Hero example = new Hero(dodolsCastle.currentEntrance);

        ArrayList<Item> test = new ArrayList<Item>();

        Item something = new Item("test", "something", true);
        test.add(something);

        example.items.add(something);

        assertEquals(test.get(0), example.items.get(0));
    }

    @Test
    public void testAvailableMoves()
    {
        Dungeon dodolsCastle = new Dungeon();
        dodolsCastle.initializeLayout();
        Hero example = new Hero(dodolsCastle.currentEntrance);

        ArrayList<String> test = new ArrayList<String>();

        example.currentRoom = dodolsCastle.layout[2][1];

        test.add("north");
        test.add("east");
        test.add("south");
        test.add("west");

        String combine = test.get(0) + test.get(1) + test.get(2) + test.get(3);
        
        ArrayList<String> test2 = example.getAvailableMoves();
        String combine2 = test2.get(0) + test2.get(1) + test2.get(2) + test2.get(3);

        assertEquals(combine, combine2);

    }
}
