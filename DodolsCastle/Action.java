package DodolsCastle;

import java.util.*;

public class Action 
{
    String name;
    String description;
    int id;
    int heroStatusModifier; //delta for the affect on hero. Could be positive or negative
    ArrayList<Integer> heroActionsAdd; // actions to be added to the hero
    ArrayList<Integer> heroActionsSub; // actions to be removed from the hero
    ArrayList<Integer> roomActionsAdd; // actions to be added to the room
    ArrayList<Integer> roomActionsSub; // actions to be removed from the room
    ArrayList<Integer> requirementsPos; // looked at by actionChecker()
    ArrayList<Integer> requirementsNeg; // ^^

    public Action(String inputName, int inputID, String inputDescription)
    {
        this.name = inputName;
        this.description = inputDescription;
        this.id = inputID;
        this.heroStatusModifier = 0;
        heroActionsAdd = new ArrayList<Integer>();
        heroActionsSub = new ArrayList<Integer>();
        roomActionsAdd = new ArrayList<Integer>();
        roomActionsSub = new ArrayList<Integer>();
        requirementsPos = new ArrayList<Integer>();
        requirementsNeg = new ArrayList<Integer>();
    }

    public String getDescription()
    {
        return this.description;
    }

    public void runAction()
    {
        //will update hero class and all affected rooms. will be quite the beefy method
        if (!heroActionsAdd.isEmpty())
		{
			
		}
		if (!heroActionsSub.isEmpty())
		{
			
		}
		if (!roomActionsAdd.isEmpty())
		{
			
		}
		if (!roomActionsSub.isEmpty())
		{
			
		}
    }
}
