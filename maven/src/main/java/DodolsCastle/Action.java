package DodolsCastle;

import java.util.ArrayList;
import java.io.*;

public class Action 
{
    String name; // name and alternates/abbreviations
    String description; // the description that will show with the action is run
    String modifiedDescription; // stores a description that can be inserted into rooms
    int heroStatusModifier; //delta for the affect on hero. Could be positive or negative
    ArrayList<Action> heroActionsAdd; // actions to be added to the hero
    ArrayList<Action> heroActionsSub; // actions to be removed from the hero
    ArrayList<Action> roomActionsAdd; // actions to be added to the room
    ArrayList<Action> roomActionsSub; // actions to be removed from the room
    ArrayList<Action> requirementsPos; // looked at by actionChecker()
    ArrayList<Action> requirementsNeg; // ^^
    ArrayList<Action> itemRequirements; // added to accomodate new item class
    Item heroItemAdd;
    Item heroItemSub;

    public Action()
    {
        this.name = null;
        this.description = null;
        this.heroStatusModifier = 0;
        heroActionsAdd = new ArrayList<Action>();
        heroActionsSub = new ArrayList<Action>();
        roomActionsAdd = new ArrayList<Action>();
        roomActionsSub = new ArrayList<Action>();
        requirementsPos = new ArrayList<Action>();
        requirementsNeg = new ArrayList<Action>();
        itemRequirements = new ArrayList<Action>();
        heroItemAdd = null;
        heroItemSub = null;
    }

    public Action(String inputName, String inputDescription)
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
        itemRequirements = new ArrayList<Action>();
        heroItemAdd = null;
        heroItemSub = null;
    }

    public void runAction(Console console, Hero player)
    {
        //console.printf(this.name + "\n"); // might not be needed
        //console.printf(this.description + "\n");
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
        if(heroItemAdd != null)
        {
            player.items.add(heroItemAdd);
            if(!heroItemAdd.heroActionsAdd.isEmpty())
            for(Action a : this.heroItemAdd.heroActionsAdd)
            {   
                player.actions.add(a);
            }
        }
        if(heroItemSub != null)
        {
            player.items.remove(heroItemSub);
            if(!heroItemSub.heroActionsAdd.isEmpty())
            for(Action a : this.heroItemSub.heroActionsAdd)
            {   
                player.actions.remove(a);
            }
        }

        player.status += heroStatusModifier;

        if (heroStatusModifier != 0)
        {
            if (heroStatusModifier < 0)
            {
                String effect = Integer.toString(heroStatusModifier);
                player.addHistory("You took " + heroStatusModifier + " damage from " + this.name +"!", effect);    
            }

            else
            {
                String effect = Integer.toString(heroStatusModifier);
                player.addHistory("You healed " + heroStatusModifier + " of health from " + this.name + ".", effect);
            }
            
        }
        else
        {
            String effect = this.name;
            player.addHistory(this.description, effect);
        }
    }
}
