package DodolsCastle;

import java.util.*;

public class Dungeon {
    Room currentEntrance;
    //ArrayList<Room> altEntrances;
    Room[][] layout;

    public Dungeon()
    {
        this.layout = new Room[4][4];
        //this.currentEntrance = layout[0][0];
    }

    public void selectLayout(int select)
    {
        //selects a layout from predefined options.
        //could add randomization later if there is time?
    }

    public void initializeLayout()
    {
        // I would call this method in the constructor personally
        //  but it could also just be called in main during initial setup, which is how it will be implemented at first

        // Create objects first so each room can be added to throughout the method
        // > Balcony [0,0]
        String balconyDescription = "The door opens into a small \033[0;4mbalcony\033[0m with a panoramic mountaintop view above the clouds." +
        "Though the wind howls around you, it seems to be reduced to no more than a gentle breeze here, and feels somewhat warm" +
        "despite the icy landscape all around.  A small wooden table with two chairs sits in the corner, atop it are two goblets" +
        "and a simple chess set.";
        this.layout[0][0] = new Room("Balcony", balconyDescription);

        // > Common Room [0,1]
        String crDescription = "The " + "\033[0;4mCommon Room\033[0m" +" is dimly lit, a cracking fire sits in a great stone hearth on the far side of the room." + 
        " The floor is covered with numerous pelts, while the walls are lined with bookshelves reaching into the gloom" +
        " of the high ceiling."; // more description, dawnelle running off from the desk maybe? Dodol over in the corner too!
        this.layout[0][1] = new Room("Common Room", crDescription);
        this.currentEntrance = this.layout[0][1];

        // > Arboretum [0,2]
        String arboretumDescription = "Super huge \033[0;4marboretum\033[0m that seems to be outdoors, some doctor who/narnia wizardry stuff";
        this.layout[0][2] = new Room("Arboretum", arboretumDescription);

        // > Laboratory [0,3]
        String laboratoryDescription = "\033[0;4mDodol's old lab\033[0m, everything is dusty and some stuff is broken, maybe some" +
        " explanation as to who dodol is and a hint that hes the inactive suit of armor in the common room, as well as" +
        " perhaps needing the hat back"; // the return of the hat seems like a good simple goal
        this.layout[0][3] = new Room("Laboratory", laboratoryDescription);

        // > Blank [1,0]
        // south of the balcony
        this.layout[1][0] = null;

        // > Hallway [1,1]
        String northHallDescription = "\033[0;4mFirst hallway portion\033[0m, connects to the common room and the hall below";
        this.layout[1][1] = new Room("North Hall", northHallDescription);

        // > Blank [1,2]
        // south of the arboretum
        this.layout[1][2] = null;

        // > Blank [1,3]
        // branch off lab?
        this.layout[1][3] = null;

        // > Kitchen [2,0]
        String kitchenDescription = "Large medieval \033[0;4mkitchen\033[0m with unseen servants doing some cleaning and whatnot" +
        " some appliances from our world can be seen as well";
        this.layout[2][0] = new Room("Kitchen", kitchenDescription);

        // > Hallway [2,1]
        String middleHallDescription = "\033[0;4mMiddle hall portion\033[0m, connects to the hall above, kitchen to the west, " +
        " Dawnelle's room to the east, and the south hall to the south.";
        this.layout[2][1] = new Room("Middle Hall", middleHallDescription);

        // > Bedroom - Dawnelle math cat [2,2]
        String bedroomDawnelleDescription = "\033[0;4mRoom\033[0m with a cat on a desk over a book holding a quill, scurries off";
        this.layout[2][2] = new Room("Cat's Room", bedroomDawnelleDescription);

        // > Blank [2,3]
        this.layout[2][3] = null;

        // > Bedroom - Aurum [3,0]
        String bedroomAurumDescription = "\033[0;4mWizardy room\033[0m, maybe a magic defense, hint to hat solution";
        this.layout[3][0] = new Room("Aurum's Room", bedroomAurumDescription);

        // > Hallway [3,1]
        String southHallDescription = "\033[0;4mSouth hall portion\033[0m, connects to stuff";
        this.layout[3][1] = new Room("South Hall", southHallDescription);

        // > Bedroom - Jondar [3,2]
        String bedroomJondarDescription = "\033[0;4mCleric's room\033[0m, devoted to martial training and prayer, sparse, other hint";
        this.layout[3][2] = new Room("Jondar's Room", bedroomJondarDescription);

        // > Blank [3,3]
        // door back to your bathroom and home? If you leave without returning dodol's hat different ending
        this.layout[3][3] = null;

        // After the basic rooms are created, they need to be linked together through their
        //  Room[] "doors", this probably should be done through a method but they can also be linked manually
        // 0 = North | 1 = East | 2 = South | 3 = West | Like a clock
        // > Balcony [0,0]
        this.layout[0][0].doors[1] = this.layout[0][1];
        // > Common Room [0,1]
        this.layout[0][1].doors[1] = this.layout[0][2];
        this.layout[0][1].doors[2] = this.layout[1][1];
        this.layout[0][1].doors[3] = this.layout[0][0];
        // > Arboretum [0,2]
        this.layout[0][2].doors[1] = this.layout[0][3];
        this.layout[0][2].doors[3] = this.layout[0][1];
        // > Laboratory [0,3]
        this.layout[0][3].doors[3] = this.layout[0][2];
        // > Blank [1,0]
        // > Hallway [1,1]
        this.layout[1][1].doors[0] = this.layout[0][1];
        this.layout[1][1].doors[2] = this.layout[2][1];
        // > Blank [1,2]
        // > Blank [1,3]
        // > Kitchen [2,0]
        this.layout[2][0].doors[1] = this.layout[2][1];
        // > Hallway [2,1]
        this.layout[2][1].doors[0] = this.layout[1][1];
        this.layout[2][1].doors[1] = this.layout[2][2];
        this.layout[2][1].doors[2] = this.layout[3][1];
        this.layout[2][1].doors[3] = this.layout[2][0];
        // > Bedroom - Dawnelle math cat [2,2]
        this.layout[2][2].doors[3] = this.layout[2][1];
        // > Blank [2,3]
        // > Bedroom - Aurum [3,0]
        this.layout[3][0].doors[1] = this.layout[3][1];
        // > Hallway [3,1]
        this.layout[3][1].doors[0] = this.layout[2][1];
        this.layout[3][1].doors[1] = this.layout[3][2];
        this.layout[3][1].doors[3] = this.layout[3][0];
        // > Bedroom - Jondar [3,2]
        this.layout[3][2].doors[3] = this.layout[3][1];
        // > Blank [3,3]

        // Room actions should also be added here once we start with that functionality
    }

    public void printDungeon()
    {
        String shortName;

        System.out.println("---------------------");

        for(int i = 0; i < 4; i++)
        {
            System.out.print("|");
            for(int j = 0; j < 4; j++)
            {
                if(layout[i][j] != null)
                {
                    // clunky way to grab first two chars of a string
                    // wasn't sure how to do it better in java
                    char letterOne = layout[i][j].name.toCharArray()[0];
                    char letterTwo = layout[i][j].name.toCharArray()[1];
                    shortName = Character.toString(letterOne);
                    shortName += Character.toString(letterTwo);
                }
                else
                {
                    shortName = "Nl";
                }
                System.out.print(" " + shortName + " |");
            }
            if(i != 3)
                System.out.println("\n|----+----+----+----|");
            else
                System.out.println();
        }
        System.out.println("---------------------\n");
    }

    public Room getEntrance()
    {
        return this.currentEntrance;
    }
}
