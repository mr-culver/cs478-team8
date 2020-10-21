package DodolsCastle;

import java.io.IOException;
import java.io.InputStreamReader;

//might need to import java.util.*

public class App 
{
    public static void main( String[] args )
    {
        Dungeon dodolsCastle = new Dungeon();
        dodolsCastle.initializeLayout();
        Hero player = new Hero(dodolsCastle.currentEntrance);
        //System.out.println(dodolsCastle.currentEntrance.name);
        dodolsCastle.printDungeon(); // for testing
        actionHandler(player);

    }

    public static void actionHandler(Hero player)
    {
        // print room description
        System.out.print(player.currentRoom.description + "\n");

        // get available actions from player.actions & player.currentRoom.actions
        // possible implementation:
        /*
        List<Action> availableActions = new List<Action>();
		availableActions.AddAll(protagonist.GetCurrentRoom().getActions());
		availableActions.AddAll(protagonist.getActions());
		foreach(Action action in availableActions)
		{
			bool needsMet = false;
			bool restraintPresent = false;
				
			foreach(Action checkAction in availableActions)
			{
				foreach(int posReqId in action.GetPositiveRequirements())
				{
					if (checkAction.getID() == posReqId)
					{
							needsMet = true;
					}
				}
					
				foreach(int negReqId in action.GetNegativeRequirements())
				{
					if (checkAction.getID() == negReqId)
					{
							restraintPresent = true;
					}
				}
			}
				
			if(!needsMet || restraintPresent)
			{
				availableActions.Remove(this.action); // something like this
			}
		}
        */

        // present options to player (actions first for clarity)
        // show available rooms to move to
        System.out.print(player.getPossibleMoves() + "\n");

        // get player input
        System.out.print("--------------------\n" +
        "Input the action you wish to take\n" + "> ");
        InputStreamReader input = new InputStreamReader(System.in);
        char r = 'z'; 
        // not sure where to put things in regards to the try-catch block
        try
        {
            boolean invalid = true;
            while(invalid)
            {
                r = (char)input.read();
                if(r == 'n' || r == 'e' || r == 's' || r == 'w')
                {
                    invalid = false;
                } 
                else
                {
                    System.out.println("Please enter a valid action\n> ");
                }
            }
                       
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }

        // handle input, only looks for cardinal directions for moves right now
        if(r == 'n')
        {
            player.currentRoom = player.currentRoom.doors[0];
        } 
        else if(r == 'e')
        {
            player.currentRoom = player.currentRoom.doors[1];
        }
        else if(r == 's')
        {
            player.currentRoom = player.currentRoom.doors[2];  
        }
        else if(r == 'w')
        {
            player.currentRoom = player.currentRoom.doors[3];
        }
        // more foreach to check with each action after looking for moves once implemented

        if(player.status > 0)
        {
            actionHandler(player);
        }
        else
        {
            System.out.println("Game Over");
        }

    }
}
