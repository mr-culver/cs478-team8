package DodolsCastle;

import static org.junit.Assert.*;

import org.junit.Test;

public class MoveTest 
{
    @Test
    public void testMoveWest()
    {
        Dungeon dodolsCastle = new Dungeon();
        dodolsCastle.initializeLayout();
        Hero player = new Hero(dodolsCastle.currentEntrance);
        player.moveRoom(3); // move west
        assertEquals(dodolsCastle.layout[0][0], player.currentRoom); // should be on balcony
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
    public void testTakeHat()
    {
        // Arrange
        String expected = "wear old hat";

        // Act
        Dungeon dodolsCastle = new Dungeon();
        dodolsCastle.initializeLayout();
        Hero player = new Hero(dodolsCastle.currentEntrance);
        player.moveRoom(2); // move south
        player.moveRoom(2); // move south
        player.moveRoom(0); // move east
        player.actions.add(player.currentRoom.actions.get(1).heroActionsAdd.get(0));
        //player.currentRoom.actions.get(1).runAction(console, player);
        String actual = player.actions.get(2).name;

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void runGame()
    {
        App.main(null);
    }
    
}
