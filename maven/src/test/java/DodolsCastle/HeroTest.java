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

        String[] action = {example.actions.get(0).name, example.actions.get(1).name};

        Object[] test = {example.currentRoom, example.status, example.turnCounter, example.history, action};

        Action punch = new Action();
        punch.name = "punch self";
        punch.description = "You punch yourself in the face. Ouch!";
        punch.heroStatusModifier = -10;

        Action check  = new Action();
        check.name = "check log";
        check.description = "You checked your log book. It states: ";
        check.heroStatusModifier = 0;

        String[] action2 = {punch.name, check.name};

        ArrayList<String> history2 = new ArrayList<String>();
        Object[] test2 = {start, 30, 0, history2, action2};

        assertArrayEquals(test2, test);
    }
}
