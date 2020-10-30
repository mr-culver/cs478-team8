package DodolsCastle;

import static org.junit.Assert.*;

import org.junit.Test;

public class DungeonTest {
    
    @Test
    public void testDungeonLayout()
    {
        Dungeon test = new Dungeon();
        Room[][] test2 = new Room[4][4];
        assertArrayEquals(test2, test.layout);
    }
}
