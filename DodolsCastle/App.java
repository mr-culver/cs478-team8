package DodolsCastle;

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
        dodolsCastle.printDungeon(console); // for testing
        welcomeMessage(console);
        actionHandler(console, player);

    }

    public static void welcomeMessage(Console console)
    {
        // big work in progress
        console.printf("\n________________________\n\n+++| Dodol's Castle |+++\n________________________\n");
        console.printf("Welcome to the text-based adventure game, Dodol's Castle!\n");
        console.printf("Version info and stuff goes here (>'.')>\n");
        console.printf("\n\nStory intro placeholder -- puts you walking into the common room unexpectedly from your house\n");
    }

    public static void actionHandler(Console console, Hero player)
    {
        // print room description
        //System.out.print("\n\n" + player.currentRoom.description + "\n\n");
        console.printf("\n\n" + player.currentRoom.description + "\n");

        // get available actions from player.actions & player.currentRoom.actions
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
                    for(Action posReq : action.requirementsPos)
                    {
                        if(checkAction == posReq)
                        {
                            needsMet = true; // doesnt account for more than one need right now
                        }
                    }

                    for(Action negReq : action.requirementsNeg)
                    {
                        if(checkAction == negReq)
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

        // get player input -- needs lots of improvement
        console.printf("________________________________________________\n");
        
        Boolean invalid = true;
        while(invalid)
        {
            String in = console.readLine("> ");
            if(in.contains("north") && player.currentRoom.doors[0] != null)
            {
                console.printf("You moved north.");
                player.currentRoom = player.currentRoom.doors[0];
                invalid = false;
            }
            else if(in.contains("east") && player.currentRoom.doors[1] != null)
            {
                console.printf("You moved east");
                player.currentRoom = player.currentRoom.doors[1];
                invalid = false;
            }
            else if(in.contains("south") && player.currentRoom.doors[2] != null)
            {
                console.printf("You moved south");
                player.currentRoom = player.currentRoom.doors[2];
                invalid = false;
            }
            else if(in.contains("west") && player.currentRoom.doors[3] != null)
            {
                console.printf("You moved west");
                player.currentRoom = player.currentRoom.doors[3];
                invalid = false;
            }
            else if(invalid)
            {
                for(Action action : availableActions)
                {
                    for(String nameCheck : action.name)
                    {
                        if(in.contains(nameCheck))
                        {
                            action.runAction(console, player);
                            invalid = false;
                        }
                    }
                }
            }
            if(invalid)
            {
                console.printf("Please enter a valid action\n");
            }
        }

        if(player.status > 0)
        {
            actionHandler(console, player);
        }
        else
        {
            System.out.println("Game Over");
        } 

    }
}
