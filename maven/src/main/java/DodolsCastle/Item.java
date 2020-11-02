package DodolsCastle;

import java.util.ArrayList;

public class Item 
{
    String name;
    String description;
    Boolean canTake;
    ArrayList<Action> heroActionsAdd;
    
    public Item()
    {
        this.name = null;
        this.description = null;
        this.canTake = false; // unneeded
        heroActionsAdd = new ArrayList<Action>();
        // bool wearable
        // bool worn
        // string wear description
    }
    
    public Item(String inputName, String inputDescription, Boolean canTake)
    {
        this.name = inputName;
        this.description = inputDescription;
        this.canTake = canTake;
        heroActionsAdd = new ArrayList<Action>();
    }
}
