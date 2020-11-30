package DodolsCastle;

public class Dungeon {
    Room currentEntrance;
    //ArrayList<Room> altEntrances;
    Room[][] layout;

    public Dungeon()
    {
        this.layout = new Room[4][4];
        //this.currentEntrance = this.layout[0][1];
    }
    
    public void initializeLayout()
    {
        // I would call this method in the constructor personally
        //  but it could also just be called in main during initial setup, which is how it will be implemented at first

        // Create objects first so each room can be added to throughout the method
        // > Balcony [0,0]
        String balconyDescription = "The door opens into a small balcony with a panoramic mountaintop view above the clouds. " +
        "Though the wind howls around you, it seems to be reduced to no more than a gentle breeze here, and feels somewhat warm " +
        "despite the icy landscape all around.  A small wooden table with two chairs sits in the corner, atop it are two goblets " +
        "and a simple chess set. The only door leads back to the east.";
        this.layout[0][0] = new Room("Balcony", balconyDescription);

        // > Common Room [0,1]
        String crDescription = "The room is dimly lit, a cracking fire sits in a great stone hearth on the far side of the room. " +
        "The walls are lined with several tall bookshelves, while the floor is well worn bare flagstone. A table sits near the fire, " +
        "covered in various books, surrounded by three couches covered with pelts and cushions.  A mass of arcane machinery looms " + 
        "in the north-east corner of the room -- various levers and whirring mechanisms that you have never seen the like of before. " +
        "A suit of old armor stands slightly hunched near the levers. " + 
        "There are doors to the west, south, and east.";
        this.layout[0][1] = new Room("Common Room", crDescription);
        this.currentEntrance = this.layout[0][1]; // set head pointer for the entrance
        
        // > Arboretum [0,2]
        String arboretumDescription = "You are in a dense, lush forest. It feels as though it is a spring morning, birds sing in the distance. " + 
        "There is a long dirt path running east to west, and you can see a clearing through the thicket to the south.";
        this.layout[0][2] = new Room("Arboretum", arboretumDescription);

        // > Laboratory [0,3]
        String laboratoryDescription = "Dodol's old lab, everything is dusty and some stuff is broken, maybe some" +
        " explanation as to who dodol is and a hint that hes the inactive suit of armor in the common room, as well as" +
        " perhaps needing the hat back " + 
        "The only door leads back to the west.";
        this.layout[0][3] = new Room("Laboratory", laboratoryDescription);

        // > Blank [1,0]
        // south of the balcony
        this.layout[1][0] = null;

        // > Hallway [1,1]
        String northHallDescription = "A long hallway stretches north to south with doors on either side. The way is lit by " +
        "torches hanging from sconces in the walls, a locked and shuttered window is in the middle, through it you look down on a bustling " +
        "medieval town on a river. " +  
        "There are doors to the north and south.";
        this.layout[1][1] = new Room("North Hall", northHallDescription);

        // > Clearing with fountain [1,2]
        // south of the arboretum
        String clearingDescription = "After trudging through the dense forest you enter a small clearing, " + 
        "a small pond fed by a spring is in the center. " +
        "You can see the path through the trees back to the north, the rest of the wood is too thick to traverse.";
        this.layout[1][2] = new Room("Clearing", clearingDescription);

        // > Blank [1,3]
        // branch off lab?
        this.layout[1][3] = null;

        // > Kitchen [2,0]
        String kitchenDescription = "Large medieval kitchen with unseen servants doing some cleaning and whatnot" +
        " some appliances from our world can be seen as well " + 
        "The only door leads back to the east.";
        this.layout[2][0] = new Room("Kitchen", kitchenDescription);

        // > Hallway [2,1]
        String middleHallDescription = "Middle hall portion, connects to the hall above, kitchen to the west, " +
        " Dawnelle's room to the east, and the south hall to the south. " + 
        "There are doors to the north, south, east, and west.";
        this.layout[2][1] = new Room("Middle Hall", middleHallDescription);

        // > Bedroom - Dawnelle math cat [2,2]
        String bedroomDawnelleDescription = "Room with a cat on a desk over a book holding a quill, scurries off " + 
        "The only door leads back to the west.";
        this.layout[2][2] = new Room("Cat's Room", bedroomDawnelleDescription);

        // > Blank [2,3]
        this.layout[2][3] = null;

        // > Bedroom - Aurum [3,0]
        String bedroomAurumDescription = "Wizardy room, maybe a magic defense, hint to hat solution " + 
        "The only door leads back to the east.";
        this.layout[3][0] = new Room("Aurum's Room", bedroomAurumDescription);

        // > Hallway [3,1]
        String southHallDescription = "South hall portion, connects to stuff " + 
        "THere are doors to the north, west, and east.";
        this.layout[3][1] = new Room("South Hall", southHallDescription);

        // > Bedroom - Jondar [3,2]
        String bedroomJondarDescription = "Cleric's room, devoted to martial training and prayer, sparse, other hint " + 
        "The only door leads back to the east."; // maybe door home too
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
        this.layout[0][2].doors[2] = this.layout[1][2];
        this.layout[0][2].doors[3] = this.layout[0][1];
        // > Laboratory [0,3]
        this.layout[0][3].doors[3] = this.layout[0][2];
        // > Blank [1,0]
        // > Hallway [1,1]
        this.layout[1][1].doors[0] = this.layout[0][1];
        this.layout[1][1].doors[2] = this.layout[2][1];
        // > Clearing [1,2]
        this.layout[1][2].doors[0] = this.layout[0][2];
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


        // actions are now created and stuff   

        // >> bookshelves -> common room
        Action coBookshelves = new Action();
        coBookshelves.name = "examine bookshelves";
        coBookshelves.description = "You examine the bookshelves - placeholder";
        this.layout[0][1].actions.add(coBookshelves);
        // >> ex table -> common room
        Action coTable = new Action();
        coTable.name = "examine table";
        coTable.description = "You examine the table, among the old books scattered around you see a small red potion.";

        // >>> ex table no potion -> common room
        Action coTableNP = new Action();
        coTableNP.name = "examine table";
        coTableNP.description = "You examine the table, there are old books you cant read the titles of scattered about the surface.";

        // >>> drink potion
        Action drinkPotion = new Action();
        drinkPotion.name = "drink potion";
        drinkPotion.description = "You drink the potion, bubbly warmth spreads throughout your body, you feel extremely refreshed.";
        drinkPotion.heroStatusModifier = 20;

        // >>> potion item
        Item potion = new Item();
        potion.name = "potion";
        potion.description = "A small red phial filled with a viscous red liquid that bubbles slightly.";
        drinkPotion.heroItemSub = potion;
        potion.heroActionsAdd.add(drinkPotion);

        // >> take potion
        Action takePotion = new Action();
        takePotion.name = "take potion";
        takePotion.description = "You pick the potion up, its contents fizz slightly.";
        takePotion.roomActionsSub.add(takePotion);
        takePotion.roomActionsSub.add(coTable); 
        takePotion.roomActionsAdd.add(coTableNP);
        takePotion.heroItemAdd = potion;
        coTable.roomActionsAdd.add(takePotion);
        this.layout[0][1].actions.add(coTable); 

        // >> machinery -> common room
        Action coMachinery = new Action();
        coMachinery.name = "examine machinery";
        coMachinery.description = "You examine the arcane machinery in the corner - placeholder";
        this.layout[0][1].actions.add(coMachinery);

        // >> ex armor -> common room
        Action coArmor = new Action();
        coArmor.name = "examine armor";
        coArmor.description = "You examine the suit of armor in the corner, it appears to be held up without any supports - placeholder";
        this.layout[0][1].actions.add(coArmor);

        // >> wear old hat
        Action wOldHat = new Action();
        wOldHat.name = "wear old hat";
        wOldHat.description = "You attempt to wear the old hat but it doesnt seem to fit on your head.";

        // >> examine old hat -> cat room
        Action caXOldHat = new Action();
        caXOldHat.name = "examine hat";
        caXOldHat.description = "You examine the old hat on the desk, yadda yadda - placeholder";
        this.layout[2][2].actions.add(caXOldHat);

        // >> take old hat -> cat room
        Action caTOldHat = new Action();
        caTOldHat.name = "take hat";
        caTOldHat.description = "You take the old hat";
        caTOldHat.heroActionsAdd.add(wOldHat);
        caTOldHat.roomActionsSub.add(caTOldHat);
        caTOldHat.roomActionsSub.add(caXOldHat);
        //caTOldHat.modifiedDescription = ""; // description without hat
        this.layout[2][2].actions.add(caTOldHat);

        // >> go home -> common room
        Action goHome = new Action();
        goHome.name = "go home";
        goHome.description = "You step through your bathroom door back into your house... - placeholder";

        // >> place old hat -> common room
        Action coPlaceOldHat = new Action();
        coPlaceOldHat.name = "place old hat";
        coPlaceOldHat.description = "You place the old worn hat on the suit of armor... your bathroom door appears - placeholder";
        coPlaceOldHat.heroActionsSub.add(wOldHat);
        coPlaceOldHat.requirementsPos.add(wOldHat);
        coPlaceOldHat.roomActionsAdd.add(goHome);
        //coPlaceOldHat.modifiedDescription = ""; // adds hat to armor in description, as well as new door home
        this.layout[0][1].actions.add(coPlaceOldHat);

        // >> examine lever -> common room
        Action coXLever = new Action();
        coXLever.name = "examine lever";
        coXLever.description = "There are many levers attached to the arcane machinery but the one nearest the suit of armor " + 
        "catches your eye.  It is the only one without a layer of dust and seems to move easily -- you could pull it and see what happens";
        // id like this to have several other nested lever pulls with different descriptions to give the illusion of stuff happening
        // not planned to actually have any affect on the game other than being a red herring and described in hints about dodol
        this.layout[0][1].actions.add(coXLever);

        // >> pull lever -> common room
        Action coLever = new Action();
        coLever.name = "pull lever";
        coLever.description = "You pull the lever, it has no effect that you can discern.";
        // id like this to have several other nested lever pulls with different descriptions to give the illusion of stuff happening
        // not planned to actually have any affect on the game other than being a red herring and described in hints about dodol
        this.layout[0][1].actions.add(coLever);


        // item object creation
        // > examine pond -> clearing
        Action clXPond = new Action();
        clXPond.name = "examine pond";
        clXPond.description = "The small pond is crystal clear, rippling slightly from the water fed into it by the spring. " + 
        "Resting nearby is an empty scabbard, its well worn leather gilded with silver.";
        this.layout[1][2].actions.add(clXPond);

        Action clXPondNS = new Action();
        clXPondNS.name = "examine pond";
        clXPondNS.description = "The small pond is crystal clear, rippling slightly from the water fed into it by the spring.";

        // > examine sword scabbard -> clearing
        Action clXScabbard = new Action();
        clXScabbard.name = "examine empty scabbard";
        clXScabbard.description = "The scabbard is empty, its well worn leather gilded with an intricate silver design.";
        this.layout[1][2].actions.add(clXScabbard);

        // > take sword scabbard -> clearing
        Action clTScabbard = new Action();
        clTScabbard.name = "take empty scabbard";
        clTScabbard.description = "You take the empty scabbard from the ground. It is warm to the touch.";

        Item clScabbard = new Item();
        clScabbard.name = "empty scabbard";
        clScabbard.description = "The scabbard is empty, its well worn leather gilded with an intricate silver design.  It is warm to the touch.";
        clTScabbard.roomActionsSub.add(clXScabbard);
        clTScabbard.roomActionsSub.add(clTScabbard);
        clTScabbard.roomActionsSub.add(clXPond);
        clTScabbard.roomActionsAdd.add(clXPondNS);
        clTScabbard.heroItemAdd = clScabbard;
        this.layout[1][2].actions.add(clTScabbard);

        // > examine new hat -> Aurum's room
        Action auXNewHat = new Action();
        auXNewHat.name = "examine new hat";
        auXNewHat.description = "It is a new an expensive wizard hat, with the leather barely broken in and no crooks in its point " +
        "There is a note attached that you find quite impossible to remove, it reads: 'Aurum, every wizard needs a hat - From Dodol'";
        this.layout[3][0].actions.add(auXNewHat);

        // > take new hat -> Aurum's room
        Action auTNewHat = new Action();
        auTNewHat.name = "take new hat";
        auTNewHat.description = "You take the new hat from the desk.";
        //auTNewHat.roomActionsSub.add(auXDesk);
        //auTNewHat.roomActionsAdd.add(auXDeskNH);
        auTNewHat.roomActionsSub.add(auTNewHat);
        auTNewHat.roomActionsSub.add(auXNewHat);

        Item auNewHat = new Item();
        auNewHat.name = "new hat";
        auNewHat.description = "It is a new an expensive wizard hat, with the leather barely broken in and no crooks in its point " +
        "There is a note attached that you find quite impossible to remove, it reads: 'Aurum, every wizard needs a hat - From Dodol'";

        Action wNewHat = new Action();
        wNewHat.name = "wear new hat";
        wNewHat.description = "As you attempt to wear the new hat it seems to shrink to avoid being placed on your head.";

        auNewHat.heroActionsAdd.add(wNewHat);
        auTNewHat.heroItemAdd = auNewHat;

        this.layout[3][0].actions.add(auTNewHat);

    }

    public void printDungeon()
    {
        String shortName;

        System.out.println("[Dev] Printing room data structure...");
        System.out.println("---------------------");

        for(int i = 0; i < 4; i++)
        {
            System.out.print("|");
            for(int j = 0; j < 4; j++)
            {
                if(layout[i][j] != null)
                {
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
                System.out.println("");
        }
        System.out.println("---------------------");
        System.out.println();
    }

    public Room getEntrance()
    {
        return this.currentEntrance;
    }
}