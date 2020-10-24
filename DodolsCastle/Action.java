package DodolsCastle;

import java.util.*;
import java.io.*;

public class Action 
{
    ArrayList<String> name; // name and alternates/abbreviations
    String description; // the description that will show with the action is run
    String modifiedDescription; // stores a description that can be inserted into rooms
    int heroStatusModifier; //delta for the affect on hero. Could be positive or negative
    ArrayList<Action> heroActionsAdd; // actions to be added to the hero
    ArrayList<Action> heroActionsSub; // actions to be removed from the hero
    ArrayList<Action> roomActionsAdd; // actions to be added to the room
    ArrayList<Action> roomActionsSub; // actions to be removed from the room
    ArrayList<Action> requirementsPos; // looked at by actionChecker()
    ArrayList<Action> requirementsNeg; // ^^

    public Action(ArrayList<String> inputName, String inputDescription)
    {
        this.name = inputName;
        this.description = inputDescription;
        this.heroStatusModifier = 0;
        heroActionsAdd = new ArrayList<Action>();
        heroActionsSub = new ArrayList<Action>();
        roomActionsAdd = new ArrayList<Action>();
        roomActionsSub = new ArrayList<Action>();
        requirementsPos = new ArrayList<Action>();
        requirementsNeg = new ArrayList<Action>();
    }

    public void runAction(Console console, Hero player)
    {
        //console.printf(this.name + "\n"); // might not be needed
        console.printf(this.description + "\n");
        if (!heroActionsAdd.isEmpty())
		{
            for(Action a : this.heroActionsAdd)
            {   
                player.actions.add(a);
            }			
		}
		if (!heroActionsSub.isEmpty())
		{
			for(Action a : this.heroActionsSub)
            {   
                player.actions.remove(a);
            }
		}
		if (!roomActionsAdd.isEmpty())
		{
			for(Action a : this.roomActionsAdd)
            {   
                player.currentRoom.actions.add(a);
            }
		}
		if (!roomActionsSub.isEmpty())
		{
			for(Action a : this.roomActionsSub)
            {   
                player.currentRoom.actions.remove(a);
            }
		}
    }
}
