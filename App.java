package DodolsCastle;

import java.io.IOException;
import java.io.InputStreamReader;

//might need to import java.util.*
import java.io.*;
import java.util.*;

public class App 
{
    public static void main( String[] args )
    {
        Console console = System.console();
        Dungeon dodolsCastle = new Dungeon();
        dodolsCastle.initializeLayout();
        Hero player = new Hero(dodolsCastle.currentEntrance);
        //System.out.println(dodolsCastle.currentEntrance.name);
        dodolsCastle.printDungeon(); // for testing
        actionHandler(player);
        // starup message stuff
        actionHandler(console, player);

    }

    public static void actionHandler(Hero player)
    {
        //jjj
    }
    public static void actionHandler(Console console, Hero player)
    {
        console.printf("\n\n" + player.currentRoom.description + "\n\n");

        // get available actions from player.actions & player.currentRoom.actions
        //#region possible implementation:
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
        //#endregion
        //possible implementation:
        ArrayList<Action> availableActions = new ArrayList<Action>();
        if(!player.actions.isEmpty())
        {
            availableActions.addAll(player.actions);
        }
        if(!player.currentRoom.actions.isEmpty())
        {
            availableActions.addAll(player.currentRoom.actions);
        }

        if(!availableActions.isEmpty())
        {
            for(Action action : availableActions)
            {
                Boolean needsMet = false;
                Boolean restraintPresent = false;

                for(Action checkAction : availableActions)
                {
                    for(int posReqId : action.requirementsPos)
                    {
                        if(checkAction.id == posReqId)
                        {
                            needsMet = true; // doesnt account for more than one need right now
                        }
                    }

                    for(int negReqId : action.requirementsNeg)
                    {
                        if(checkAction.id == negReqId)
                        {
                            restraintPresent = true;
                        }
                    }
                }

                if(!needsMet || restraintPresent)
			    {
				    availableActions.remove(action);
			    }
		    }
        }

        // present options to player (actions first for clarity) -- maybe unneeded?
        // show available rooms to move to -- doors will be part of room description maybe?
        //console.printf(player.getPossibleMoves() + "\n");

        // get player input -- needs lots of improvement
        console.printf("________________________________________________\n" +
        "Input the action you wish to take\n\n");
        System.out.print("Available Actions " + player.getAvailableMoves() + "\n");
        Boolean invalid = true;
        while(invalid)
        {
            String in = console.readLine("> ");
            if(in.equalsIgnoreCase("north") && player.currentRoom.doors[0] != null)
            {
                console.printf("Moved north");
                player.currentRoom = player.currentRoom.doors[0];
                invalid = false;
            }
            else if(in.equalsIgnoreCase("east") && player.currentRoom.doors[1] != null)
            {
                console.printf("Moved east");
                player.currentRoom = player.currentRoom.doors[1];
                invalid = false;
            }
            else if(in.equalsIgnoreCase("south") && player.currentRoom.doors[2] != null)
            {
                console.printf("Moved south");
                player.currentRoom = player.currentRoom.doors[2];
                invalid = false;
            }
            else if(in.equalsIgnoreCase("west") && player.currentRoom.doors[3] != null)
            {
                console.printf("Moved west");
                player.currentRoom = player.currentRoom.doors[3];
                invalid = false;
            }
            else if(invalid)
            {
                for(Action action : availableActions)
                {
                    // check stuff
                }
            }
            if(invalid)
            {
                console.printf("Please enter a valid action\n");
            }
        }

        // present options to player (actions first for clarity)
        // show available rooms to move to
        // get player input -- needs LOTS OF improvement
        InputStreamReader input = new InputStreamReader(System.in);
        /* InputStreamReader input = new InputStreamReader(System.in);
        char r = 'z'; 
        // not sure where to put things in regards to the try-catch block
        try
@@ -93,10 +143,10 @@ public static void actionHandler(Hero player)
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
        } */

        // handle input, only looks for cardinal directions for moves right now
       // if(r == 'n')
        /* if(r == 'n')
        {
            player.currentRoom = player.currentRoom.doors[0];
        } 
@@ -111,17 +161,17 @@ else if(r == 's')
        else if(r == 'w')
        {
            player.currentRoom = player.currentRoom.doors[3];
        }
        } */
        // foreach loops to check with each action after looking for moves once implemented

        if(player.status > 0)
        {
            actionHandler(player);
            actionHandler(console, player);
        }
        else
        {
            System.out.println("Game Over");
        }
        } 

    }
