package DodolsCastle;

//import java.nio.file.Files;
import java.nio.file.Path;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.*;
//import javax.lang.model.util.ElementScanner14;
import java.io.*;

public class App 
{
    public static String loadgame = "no";
    public static int count = 0;
    public static ArrayList<String> moves = new ArrayList<String>();
    public static void main( String[] args )
    {
        Scanner input = new Scanner(System.in);
        Boolean testPrinting = false; // allows test print blocks to execute for dev testing
        Dungeon dodolsCastle = new Dungeon();
        dodolsCastle.initializeLayout();
        Hero player = new Hero(dodolsCastle.currentEntrance);
        readinsave();
        if(testPrinting)
            dodolsCastle.printDungeon();
        welcomeMessage();
        actionHandler(player, testPrinting, input, false);
        input.close();
        // end game display stuff - credits and whatnot
    }

    public static void welcomeMessage()
    {
        // big work in progress
        System.out.println("----------+++| Dodol's Castle |+++----------");
        System.out.println();
        //console.printf("\n\n");
        System.out.println("Welcome to the text-based adventure game, Dodol's Castle!");
        System.out.println("Version info and stuff goes here (>'.')>");
        System.out.println();
        System.out.println();
        System.out.println("Story intro placeholder -- puts you walking into the common room unexpectedly from your house");
    }

    public static void formatMessage(String message)
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
            System.out.println(x);
        }
        //console.printf("\n");
    }

    public static void actionHandler(Hero player, Boolean testPrinting, Scanner input, Boolean appTest)
    {
        // print room name & description        
        formatMessage("\n\n" + "+ " + player.currentRoom.name + " +");
        formatMessage(player.currentRoom.description + "\n");

        // get available actions from player.actions & player.currentRoom.actions
        ArrayList<Action> availableActions = getAvailableActions(player.currentRoom, player, testPrinting);

        // player input & action selection logic
        System.out.println("--------------------------------------------------\n");

        if (loadgame == "yes" && count == 0)
        {
            System.out.println("Save found. Please hit enter to load save.");
            System.out.println();
            System.out.println("--------------------------------------------------");
        }
        
        Boolean invalid = true;
        Boolean gameOver = false;
        while(invalid)
        {
            System.out.println("Enter a command:");
            String in = input.nextLine();

            if (loadgame == "yes" && count < moves.size())
            {
                in = moves.get(count);
                count++;

                if (count < (moves.size()))
                {
                    try 
                    {
                        Robot r = new Robot();
                        r.keyPress(KeyEvent.VK_ENTER);
                        r.keyRelease(KeyEvent.VK_ENTER);
                    } 
                    catch (AWTException e) 
                    {
                        e.printStackTrace();
                    }
                }
            }

            System.out.print(String.format("\033[2J"));
            System.out.println();
            // movement handling
            if(in.contains("north") && player.currentRoom.doors[0] != null)
            {
                String effect = "north";
                System.out.println("You moved north.");
                player.addHistory("You moved north", effect);
                player.currentRoom = player.currentRoom.doors[0];
                invalid = false;
            }
            else if(in.contains("east") && player.currentRoom.doors[1] != null)
            {
                String effect = "east";
                System.out.println("You moved east.");
                player.addHistory("You moved east", effect);
                player.currentRoom = player.currentRoom.doors[1];
                invalid = false;
            }
            else if(in.contains("south") && player.currentRoom.doors[2] != null)
            {
                String effect = "south";
                System.out.println("You moved south.");
                player.addHistory("You moved south", effect);
                player.currentRoom = player.currentRoom.doors[2];
                invalid = false;
            }
            else if(in.contains("west") && player.currentRoom.doors[3] != null)
            {
                String effect = "west";
                System.out.println("You moved west.");
                player.addHistory("You moved west", effect);
                player.currentRoom = player.currentRoom.doors[3];
                invalid = false;
            }
            // show hero status (health description)
            else if(in.contains("status"))
            {
                formatMessage(player.getStatusDescription(testPrinting));
                invalid = false;
            }
            // show hero log (past actions, rooms)
            else if(in.contains("log"))
            {
                player.printHistory();
                invalid = false;
            }
            // displays helpful info and available actions
            else if(in.contains("help"))
            {
                printHelpInfo(availableActions);
                invalid = false;
            }
            // show inventory (player.items)
            else if (in.contains("inventory"))
            {
                player.printInventory();
                invalid = false;
            }
            // toggle developer test printing
            else if (in.contains("dev"))
            {
                System.out.println("[Dev] Toggling test printing...\n");          
                if(testPrinting) testPrinting = false;
                else testPrinting = true;
                System.out.println("[Dev] > Test Printing = " + testPrinting);
                invalid = false;
            }
            // save the game using savegame() from hero.java
            else if (in.contains("save game"))
            {
                String effect = "You saved the game.";
                player.savegame();
                player.addHistory("", effect);
                invalid = false;
            }

            // check input against available actions
            else if(invalid)
            {
                for(Action action : availableActions)
                {
                    if(in.contains(action.name))
                    {
                        formatMessage(action.description);
                        action.runAction(player);
                        invalid = false;
                        if(in.contains("go home"))
                        {
                            System.out.println();
                            gameOver = true;
                        }
                    }                
                }
            }         
            // check items for examiniation -- dead code now but might be used later
            /* else if(in.contains("examine"))
            {
                String thing = in.substring(8, in.length() - 1);
                if(!player.currentRoom.items.isEmpty())
                for (Item i : player.currentRoom.items)
                {
                    if(i.name.contains(thing))
                    {
                        if(console != null)
                        {
                            formatMessage("\nYou examine the " + i.name + ":", console);
                            formatMessage(i.description, console);
                        }  
                        invalid = false;                         
                    }
                }
                if(!player.items.isEmpty())
                for (Item i : player.items)
                {
                    if(i.name.contains(thing))
                    {
                        if(console != null)
                        {
                            formatMessage("\nYou examine the " + i.name + ":", console);
                            formatMessage(i.description, console);                        
                        }
                        invalid = false;                           
                    }
                }
            } */
            // check items for taking
            /* else if(in.contains("take"))
            {
                String thing = in.substring(5, in.length() - 1);
                ArrayList<Item> temp = new ArrayList<Item>();
                for (Item i : player.currentRoom.items)
                {
                    temp.add(i);
                    if(i.name.contains(thing) && i.canTake)
                    {
                        player.items.add(i);
                        temp.remove(i);
                        if(!i.heroActionsAdd.isEmpty())
                        {
                            for(Action a : i.heroActionsAdd)
                            {
                                player.actions.add(a);
                            }
                        }
                        if(console != null)
                        {
                            formatMessage("\nYou take the " + i.name + ".", console);
                        }
                        invalid = false;                 
                    }
                }
                player.currentRoom.items = temp;
            }   */        
            if(invalid)
            {
                if (appTest != true)
                {
                    System.out.println("Please enter a valid action, type 'help' for more info\n");    
                }
                
                else
                {
                    System.out.println("Please enter a valid action, type 'help' for more info\n");
                    break;
                }
            }
        }
        if(player.status > 0 && !gameOver)
        {
            if (appTest != true)
            {
                actionHandler(player, testPrinting, input, false);    
            }    
        }
        else
        {
            System.out.println("+++| Game Over |+++");
        } 
    }

    public static ArrayList<Action> getAvailableActions(Room curRoom, Hero player, Boolean testPrinting)
    {
        if(testPrinting)
            System.out.println("[Dev] Gathering available actions...\n");
        ArrayList<Action> availableActions = new ArrayList<Action>();
        ArrayList<Action> prunedList = new ArrayList<Action>();
        if(!player.actions.isEmpty())
        {
            availableActions.addAll(player.actions);
            if(testPrinting)
            {
                System.out.println("[Dev] > Found actions in hero: \n");
                for (Action action : player.actions) 
                {
                    System.out.println("\t- " + action.name + "\n");
                }
            }       
        }
        if(!player.currentRoom.actions.isEmpty())
        {
            availableActions.addAll(player.currentRoom.actions);
            if(testPrinting)
            {
                System.out.println("[Dev] > Found actions in room: \n");
                for (Action action : player.currentRoom.actions) 
                {
                    System.out.println("\t- " + action.name + "\n");
                }
            }
        }
        if(testPrinting)
            System.out.println("[Dev] Checking action requirements...\n");     
        if(!availableActions.isEmpty())
        {
            for(Action action : availableActions)
            {
                if(testPrinting)
                    System.out.println("[Dev] > Checking: " + action.name + "\n");
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
                        System.out.println("[Dev] >> Pruned " + "\n");
                }
                else
                {
                    prunedList.add(action);
                    if(testPrinting)
                        System.out.println("[Dev] >> Accepted " + "\n");
                }
		    }
        }
        availableActions = prunedList;
        return availableActions;
    }

    public static void printHelpInfo(ArrayList<Action> availableActions)
    {
        formatMessage("Insert useful help info here, common action keywords and stuff");
        formatMessage("Listing actions available to you:");
        for(Action a : availableActions)
        {
            System.out.println("\t- " + a.name + "\n");
        }
        // print available actions
    }

    public static void readinsave()
    {
        Path pathname;
        //Path fileName = Path.of("Saved Game Data.txt");
        pathname = Path.of("Saved_Game_Data.txt").toAbsolutePath();
        String pathna = pathname.toString();
        BufferedReader reader;
        ArrayList<String> search = new ArrayList<String>();
        search.add("north");
        search.add("east");
        search.add("south");
        search.add("west");
        search.add("bookshelves");
        search.add("table");
        search.add("lever");
        search.add("armor");
        search.add("machinery");
        search.add("hat");
        search.add("pond");
        search.add("empty scabbard");
        search.add("new hat");
        search.add("potion");
        search.add("self");
        try 
        {
            reader = new BufferedReader(new FileReader(pathna));
            String line = reader.readLine();
            System.out.print("Load Previous Game yes/no? ");
            BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));   
            String answer2; 
            answer2 = obj.readLine();
        if(answer2.toLowerCase().contains("yes"))
        {
            System.out.println("loading saved game....");
            loadgame ="yes";
            while(line != null)
            {            
            //System.out.println("line "+i+" says "+ line);
            for(int k =0; k<search.size();k++)
            {
            if ( line.toLowerCase().indexOf("moved "+search.get(k).toLowerCase()) != -1 ) 
            {
                moves.add(search.get(k));
            } 
            else if ( line.toLowerCase().indexOf("examine "+search.get(k).toLowerCase()) != -1 ) 
            {
                moves.add("examine "+search.get(k));
            }
            else if ( line.toLowerCase().indexOf("take "+search.get(k).toLowerCase()) != -1 ) 
            {
                moves.add("take "+search.get(k));
            }  
            else if ( line.toLowerCase().indexOf("wear old "+search.get(k).toLowerCase()) != -1 ) 
            {
                moves.add("wear old hat "+search.get(k));
            }
            else if ( line.toLowerCase().indexOf("place old "+search.get(k).toLowerCase()) != -1 ) 
            {
                moves.add("place old hat "+search.get(k));
            }
            else if ( line.toLowerCase().indexOf("pull "+search.get(k).toLowerCase()) != -1 ) 
            {
                moves.add("pull "+search.get(k));
            }
            else if ( line.toLowerCase().indexOf("wear "+search.get(k).toLowerCase()) != -1 ) 
            {
                moves.add("wear "+search.get(k));
            }
            else if ( line.toLowerCase().indexOf("-10") != -1 ) 
            {
                moves.add("punch self");
                k = search.size();
            }
            else if ( line.toLowerCase().indexOf("20 |") != -1 ) 
            {
                moves.add("drink potion");
                k = search.size();
            }
            }
            line = reader.readLine();
            }
        }
            else if(answer2.toLowerCase().contains("no"))
            {
                System.out.println("Starting new game....");
            }
            reader.close();
           // String actual = Files.readString(fileName);
            //System.out.println(actual);

        } catch (Exception e) 
        {
            System.out.println("No saved data found. Starting a new game.");
        }
        
        
    }
}