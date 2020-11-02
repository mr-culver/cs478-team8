package DodolsCastle;

import java.io.*;
import java.util.*;

public class App 
{
    public static void main( String[] args )
    {
        Boolean testPrinting = false; // allows test print blocks to execute for dev testing
        Console console = System.console();
        Dungeon dodolsCastle = new Dungeon();
        dodolsCastle.initializeLayout();
        Hero player = new Hero(dodolsCastle.currentEntrance);
        if(testPrinting)
            dodolsCastle.printDungeon(console);
        welcomeMessage(console);
        actionHandler(console, player, testPrinting);
        // end game display stuff - credits and whatnot
    }

    public static void welcomeMessage(Console console)
    {
        // big work in progress
        formatMessage("----------+++| Dodol's Castle |+++----------", console);
        //console.printf("\n\n");
        formatMessage("Welcome to the text-based adventure game, Dodol's Castle!", console);
        formatMessage("Version info and stuff goes here (>'.')>", console);
        console.printf("\n\n");
        formatMessage("Story intro placeholder -- puts you walking into the common room unexpectedly from your house", console);
    }

    public static void formatMessage(String message, Console console)
    {
        ArrayList<String> messageArray = new ArrayList<String>();

        int prev = 0;

        for (int i = 0; i < message.length(); i++)
        {
            char x = message.charAt(i);

            if (x == ' ')
            {

                if (i - prev >= 90 && i - prev <= 100)
                {
                    if (prev == 0)
                    {
                        messageArray.add(message.substring(prev, i));
                        prev = i;  
                    }

                    else
                    {
                        messageArray.add(message.substring(prev + 1, i));
                        prev = i;
                    }
                    
                }
            }

            else if (i == message.length() - 1)
            {
                if (prev == 0)
                {
                    messageArray.add(message.substring(prev, i + 1));
                    prev = i;  
                }

                else
                {
                    messageArray.add(message.substring(prev + 1, i + 1));
                    prev = i;
                }
            }
        }

        if (messageArray.size() == 0)
        {
            messageArray.add(message.substring(0, message.length()));
        }

        for (String x : messageArray)
        {
            console.printf(x + "\n");
        }
        //console.printf("\n");
    }

    public static void actionHandler(Console console, Hero player, Boolean testPrinting)
    {
        // print room name & description        
        formatMessage("\n\n" + "+ " + player.currentRoom.name + " +", console);
        formatMessage(player.currentRoom.description + "\n", console);

        // get available actions from player.actions & player.currentRoom.actions
        if(testPrinting)
            console.printf("[Dev] Gathering available actions...\n");
        ArrayList<Action> availableActions = new ArrayList<Action>();
        ArrayList<Action> prunedList = new ArrayList<Action>();
        if(!player.actions.isEmpty())
        {
            availableActions.addAll(player.actions);
            if(testPrinting)
            {
                console.printf("[Dev] > Found actions in hero: \n");
                for (Action action : player.actions) 
                {
                    console.printf("\t- " + action.name + "\n");
                }
            }       
        }
        if(!player.currentRoom.actions.isEmpty())
        {
            availableActions.addAll(player.currentRoom.actions);
            if(testPrinting)
            {
                console.printf("[Dev] > Found actions in room: \n");
                for (Action action : player.currentRoom.actions) 
                {
                    console.printf("\t- " + action.name + "\n");
                }
            }
            

        }
        if(testPrinting)
            console.printf("[Dev] Checking action requirements...\n");     
        if(!availableActions.isEmpty())
        {

            for(Action action : availableActions)
            {
                if(testPrinting)
                    console.printf("[Dev] > Checking: " + action.name + "\n");
                Boolean needsMet = false;
                Boolean restraintPresent = false;

                for(Action checkAction : availableActions)
                {
                    if(action.requirementsPos.isEmpty())
                    {
                        needsMet = true;
                    }
                    else
                    {
                        for(Action posReq : action.requirementsPos)
                        {
                            if(checkAction == posReq)
                            {
                                needsMet = true; // doesnt account for more than one need right now
                            }
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
                    //availableActions.remove(action);
                    if(testPrinting)
                        console.printf("[Dev] >> Pruned " + "\n");
                }
                else
                {
                    prunedList.add(action);
                    if(testPrinting)
                        console.printf("[Dev] >> Accepted " + "\n");
                }
		    }
        }
        availableActions = prunedList;

        // player input & action selection logic
        //console.printf("________________________________________________\n");
        console.printf("--------------------------------------------------\n");
        
        Boolean invalid = true;
        Boolean gameOver = false;
        while(invalid)
        {
            String in = console.readLine("> ");
            if(in.contains("north") && player.currentRoom.doors[0] != null)
            {
                String effect = "north";
                console.printf("You moved north.");
                player.addHistory("You moved north", effect);
                player.currentRoom = player.currentRoom.doors[0];
                invalid = false;
            }
            else if(in.contains("east") && player.currentRoom.doors[1] != null)
            {
                String effect = "east";
                console.printf("You moved east");
                player.addHistory("You moved east", effect);
                player.currentRoom = player.currentRoom.doors[1];
                invalid = false;
            }
            else if(in.contains("south") && player.currentRoom.doors[2] != null)
            {
                String effect = "south";
                console.printf("You moved south");
                player.addHistory("You moved south", effect);
                player.currentRoom = player.currentRoom.doors[2];
                invalid = false;
            }
            else if(in.contains("west") && player.currentRoom.doors[3] != null)
            {
                String effect = "west";
                console.printf("You moved west");
                player.addHistory("You moved west", effect);
                player.currentRoom = player.currentRoom.doors[3];
                invalid = false;
            }
            else if(in.contains("status"))
            {
                formatMessage(player.getStatusDescription(testPrinting) + "\n", console);
                invalid = false;
            }
            else if(in.contains("log"))
            {
                // might just call a printLog method in hero.java instead?
                console.printf("You think about what you have done since you got to the castle...\n");
                console.printf("-------------------- Log Book --------------------\n\n");
                for (String x : player.history)
                {
                    console.printf(x + "\n");
                }
                console.printf("\n--------------------------------------------------\n");
                invalid = false;
            }
            else if(in.contains("help"))
            {
                printHelpInfo(availableActions, console);
                invalid = false;
            }
            else if(invalid)
            {
                for(Action action : availableActions)
                {
                    if(in.contains(action.name))
                    {
                        action.runAction(console, player);
                        invalid = false;
                        if(in.contains("go home"))
                        {
                            console.printf("\n");
                            gameOver = true;
                        }
                    }
                    
                }
            }
            if(invalid)
            {
                console.printf("Please enter a valid action, type 'help' for more info\n");
            }
        }

        if(player.status > 0 && !gameOver)
        {
            actionHandler(console, player, testPrinting);
        }
        else
        {
            console.printf("+++| Game Over |+++");
        } 
    }

    public static void printHelpInfo(ArrayList<Action> availableActions, Console console)
    {
        console.printf("Insert useful help info here\n");
        // print available actions
    }
}