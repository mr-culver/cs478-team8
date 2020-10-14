public class App
{
	public static void main(String[] args)
	{
		Dungeon castle = new Dungeon(); // if the layout is variable, pass an argument here
		Hero protagonist = new Hero(castle.getEntrance());
		
		// maybe a method here to display startup info and option for tutorial info
		
		actionHandler();
	}
	
	public void actionHandler()
	{
		/*
		print room description
		
		get actions from hero & room
			List<Action> availableActions = new List<Action>();
			availableActions.AddAll(protagonist.GetCurrentRoom().getActions());
			availableActions.AddAll(protagonist.getActions());
			foreach(Action action in availableActions)
			{
				bool needsMet = false;
				bool restraintPresent = false;
				
				foreach(Action checkAction in availableActions)
				{
					foreach(int posReqId in action.GetPositiveRequirements())
					{
						if (checkAction.getID() == posReqId)
						{
							needsMet = true;
						}
					}
					
					foreach(int negReqId in action.GetNegativeRequirements())
					{
						if (checkAction.getID() == negReqId)
						{
							restraintPresent = true;
						}
					}
				}
				
				if(!needsMet || restraintPresent)
				{
					availableActions.Remove(this.action); // something like this
				}
			}
		present options to player?
		read player input (selected action)
		action.run(protagonist.currentRoom);
		if (protagonist.status > 0)
		do actionHandler();
		else handle end or restart
		*/
	}
}

public class Dungeon
{
	private Room entrance; // pointer to head node
	private List<Room> allRooms; // rooms that need to be linked together
	
	
	public Dungeon()
	{	
		allRooms = initRooms();
		entrance = allRooms.get(0); // does java's list.get return a pointer?
	}
	
	private List<Room> initRooms()
	{
		List<Room> roomSetup = new List<Room>();
		// add the basics of each room to a list
		roomSetup.add(new Room("Common Room", "The room is dimly lit, a cracking fire sits in a hearth on the far side."));
		roomSetup.add(new Room("Balcony", "The door blows open with a gust of wind, cool, but not unpleasent.  An array of stars..."));
		roomSetup.add(new Room("Arboretum", "flavorful description here"));
		// more rooms
		
		roomSetup.get(0).Door[0].setRoom();l
		// start adding actions to the rooms
		roomSetup.get(0).addAction(new Action(/*all kinds of stuff in here*/));
		roomSetup.get(0).addAction(new Action(/*all kinds of stuff in here*/)); // one for going through each door, etc.
		roomSetup.get(1).addAction(new Action(/*all kinds of stuff in here*/));
		roomSetup.get(1).addAction(new Action(/*all kinds of stuff in here*/));
		// this seems like a really clunky way of creating the base for the linked list
		// will need to add all actions to a list similar to rooms above and then finish fleshing them out from that list
	}
	
	class Room
	{
		private string name; // short description from class diagram
		private string description;
		private int id;
		private List<Actions> actions; // things you can do in the room
		private Room[4] door;
		
		public Room(string inputName, string inputDescription)
		{ 
			// should the constructor handle adding actions too?
			this.name = inputName;
			this.description = inputDescription;
			this.actions = new List<Actions>();
		}
		
		// we need getters and setters for name and description so Action objects can change them
		// methods to add and subtract actions from the private list
		// or just make stuff public? -- might need to make at least the actions/doors public
	}
	
}

public class Hero
{
	private Room currentRoom;
	private List<Actions> actions;
	private int status;
	public List<string> history;
	
	public Hero(*Room startingRoom) // not sure of syntax for passing pointers, something like this
	{
		currentRoom = startingRoom;
		actions = new List<Action>();
		status = 10;
		history = new List<string>();
	}
	
	public void changeStatus(int change)
	{
		status = status + change;
		if (status < 1)
		{
			// game over man
		}
	}
	// having separate player actions needed, they could include generic move actions and stuff
	// method for handling movement -- action checker would read possible moves as actions
}

public class Action
{ 
	private string name;
	private string description; // presented when the action is run
	private int id;
	private int heroStatusModifier;
	List<int> heroActionsAdd; // action IDs
	List<int> heroActionsSub;
	List<int> roomActionsAdd;
	List<int> roomActionsSub;
	List<int> reqPos;
	List<int> reqNeg;
	
	public Action(string inputName, string inputDescription)
	{ 	
		// should the constructor handle adding actions too?
		this.name = inputName;
		this.description = inputDescription;
	}
	
	public void runAction(*Room current)
	{
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