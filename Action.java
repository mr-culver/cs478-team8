package DodolsCastle;

import java.util.*;

public class Action {
    String description;
    String shortDescription; //maybe just an id?
    ArrayList<Action> heroActionsAdd;
    ArrayList<Action> heroActionsSub;
    ArrayList<Action> roomActionsAdd;
    ArrayList<Action> roomActionsSub;
    ArrayList<Action> requirementsPos;
    ArrayList<Action> requirementsNeg;
    //this class will be beefy. might need getters and setters for each list
    ArrayList<Room> affectedRooms;
    int heroStatus; //delta for the hero. Could be positive or negative

    public Action(String desc, String shortDesc, ArrayList<Room> affect, int delta)
    {
        this.description = desc;
        this.shortDescription = shortDesc;
        this.affectedRooms = affect;
        this.heroStatus = delta;
        // could initialize the lists here or with getters and setters
    }

    public String getDescription()
    {
        return this.description;
    }

    public void runAction()
    {
        //will update hero class and all affected rooms. will be quite the beefy method
    }
}
