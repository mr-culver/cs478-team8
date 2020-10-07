package magicCastle;
import java.util.*;
import java.awt.event.KeyAdapter;
import java.util.Random;
public class mainClass extends KeyAdapter
{
   
    // all variables which are used as global from this whole class
    public static String name;
    public static int lowerDamage;
    public static int upperDamage;
    public static int defence;
    public static int hp;
    public static int checker;
    public static int day;
    public static int magicCastle;
    public static int orbPower;
    public static int checkerForDamage = 1;
    public static String[] tableValues = new String[64];
    
    //constructor
     public mainClass()
    {
        // initialize instance variables        
    }
    
    //main method.
    public static void main(String[] args) {
        
        orbPower = 0;
        checker =0;
        magicCastle = 15;
        day = 1;
        
        //set for getting input values
        Scanner sc= new Scanner(System.in);
       
        //for random values.
        Random rand = new Random();
        
        //first initialize all table values with " "
        for(int i=0;i<64;i++){
            tableValues[i] = " ";
        }
        
        //randomly set the orb locations;
            for(int i=0;i<64;i++){
                if(i>=2 && i<60 && tableValues[i]==" "){
                    int j=2+rand.nextInt(60-2+1);
                    tableValues[j]="O";
                }
            }
        
          
        System.out.println("Welcome to magicCastle");
        System.out.println("---------------------");
        System.out.println("Main Menu");               
        System.out.println("1) New Game");
        System.out.println("2) Resume Game");
        System.out.println("3) Exit Game");
        System.out.println("Enter choice.");
        name = "Mitchel C";
        lowerDamage = 2;
        upperDamage = 4;        
        defence = 1;
        hp = 20;       
        
        //input an integer
        int option = sc.nextInt();
        if(option==1){
            orbPower = 0;
            checker = 0;
            magicCastle = 15;
            day = 1;
            characteristics();
            tableValues[0] = "S";
            tableValues[11] = "S";
            tableValues[21] = "S";
            tableValues[25] = "S";
            tableValues[52] = "S";
            tableValues[63] = "K";
            System.out.println("\nThe Default Map is:");
            
            //map and castle menu methods.
            map();  
            castleMenu(sc,rand);

       }
        else if(option==3){
            System.out.println("Game Ended.");
            System.exit(0);
        }            
}
    
    //map method.
    public static void map(){
            System.out.println("+---+---+---+---+---+---+---+---+ ");
            System.out.println("| "+tableValues[0]+" | "+tableValues[1]+" | "+tableValues[2]+" | "+tableValues[3]+" | "
            +tableValues[4]+" | "+tableValues[5]+" | "+tableValues[6]+" | "+tableValues[7]+" | ");
            System.out.println("+---+---+---+---+---+---+---+---+ ");
            System.out.println("| "+tableValues[8]+" | "+tableValues[9]+" | "+tableValues[10]+" | "+tableValues[11]+" | "
            +tableValues[12]+" | "+tableValues[13]+" | "+tableValues[14]+" | "+tableValues[15]+" | ");
            System.out.println("+---+---+---+---+---+---+---+---+ ");
            System.out.println("| "+tableValues[16]+" | "+tableValues[17]+" | "+tableValues[18]+" | "+tableValues[19]+" | "
            +tableValues[20]+" | "+tableValues[21]+" | "+tableValues[22]+" | "+tableValues[23]+" | ");
            System.out.println("+---+---+---+---+---+---+---+---+ ");
            System.out.println("| "+tableValues[24]+" | "+tableValues[25]+" | "+tableValues[26]+" | "+tableValues[27]+" | "
            +tableValues[28]+" | "+tableValues[29]+" | "+tableValues[30]+" | "+tableValues[31]+" | ");
            System.out.println("+---+---+---+---+---+---+---+---+ ");
            System.out.println("| "+tableValues[32]+" | "+tableValues[33]+" | "+tableValues[34]+" | "+tableValues[35]+" | "
            +tableValues[36]+" | "+tableValues[37]+" | "+tableValues[38]+" | "+tableValues[39]+" | ");
            System.out.println("+---+---+---+---+---+---+---+---+ ");
            System.out.println("| "+tableValues[40]+" | "+tableValues[41]+" | "+tableValues[42]+" | "+tableValues[43]+" | "
            +tableValues[44]+" | "+tableValues[45]+" | "+tableValues[46]+" | "+tableValues[47]+" | ");
            System.out.println("+---+---+---+---+---+---+---+---+ ");
            System.out.println("| "+tableValues[48]+" | "+tableValues[49]+" | "+tableValues[50]+" | "+tableValues[51]+" | "
            +tableValues[52]+" | "+tableValues[53]+" | "+tableValues[54]+" | "+tableValues[55]+" | ");
            System.out.println("+---+---+---+---+---+---+---+---+ ");
            System.out.println("| "+tableValues[56]+" | "+tableValues[57]+" | "+tableValues[58]+" | "+tableValues[59]+" | "
            +tableValues[60]+" | "+tableValues[61]+" | "+tableValues[62]+" | "+tableValues[63]+" | ");
    }

    //player characteristics.
    public static void characteristics(){
         System.out.println("Player Characteristics are:");
        System.out.println("Name: "+name);
        System.out.println("Demage: "+lowerDamage+" to "+upperDamage);
        System.out.println("Defence: "+defence);
        System.out.println("HP: "+hp);
    }
    
    //attack method.
    public static void attack(Random rand){
                //validations for random values.
                if(upperDamage!=0){
                    upperDamage = lowerDamage+rand.nextInt(upperDamage-lowerDamage+1);
                }
                if(lowerDamage!=0){
                    lowerDamage = rand.nextInt(lowerDamage);            
                }
                if(defence!=0){
                    defence = rand.nextInt(defence);
                }
                
                int newhp = hp;
                if(hp!=0){
                hp = rand.nextInt(hp);
                }
                
                int finalhp = newhp-hp;
                if(magicCastle!=0){
                	magicCastle = rand.nextInt(magicCastle);
                }
                
                if(orbPower!=1){
                    System.out.println("You do not have the Orb of Power - the Ghost is immune! ");
                }
                System.out.println("Player's HP: "+hp);
                System.out.println("Ghost HP: "+magicCastle);
                
                //if player HP is not zero
                if(hp!=0){
                 System.out.println("You deal "+finalhp+" damage to the Ghost");
                System.out.println("Ooch the Ghost hit you for "+magicCastle+" damage.\nEncounter!- Ghost");
                
                //if player got orb power and Castle's Ghost HP is zero then player is won.
                if(orbPower==1 && magicCastle==0){
                System.out.println("You deal "+magicCastle+" damage to the Ghost");
                System.out.println("Castle's Ghost is dead! You are victorious! ");
                System.out.println("Congratulations, you have defeated the Ghost! ");
                System.out.println("The world is saved! You win!  ");
                System.out.println("You Won Fight in  "+day+" days");                
                }
                System.out.println("Demage: "+lowerDamage+" to "+upperDamage);
                System.out.println("Defence: "+defence);
                System.out.println("HP: "+hp);
                  
                }
                
                //else player loose.
                else{
                System.out.println("Sorry your hp is 0 so you loose.");
                System.out.println("Game Ended.");
                System.exit(0);
                }
    
    }
    
    //move method.
    public static void move(Scanner sc,Random rand){
        outer3:
        while(true){
        int index = 0;
        int checkingIndex = 0;
        System.out.println("W = up; A = left; F = down; D = right ");
        char move = sc.next().charAt(0);
        System.out.println("Your Move:");        
        System.out.println(move);
        
	//getting index of player position.
        for(int i=0;i<64;i++){
                if(tableValues[i]=="H" || tableValues[i]=="H/S"){
                    index = i;
                    break;
                }
         }

           	//for right side movement
        if (move == 'a') {            
            if(index!=0){
            checkingIndex = index-1;
            
		//if we are on the street.
            if(tableValues[checkingIndex] == "S"){
                tableValues[checkingIndex]="H/S";
                tableValues[index] = "S";
                System.out.println("You are out on the street! ");
                break;
            }
            
            //if we found Orbit Power.
         else if(tableValues[checkingIndex]=="O"){             
             System.out.println("You found the Orb of Power! ");
             System.out.println("Your attack increases by 5! ");
             System.out.println("Your defence increases by 5!  ");
             System.out.println("Day"+day+": You are inside the Castle.\nEncounter!- Ghost");
             upperDamage = upperDamage+5;
             lowerDamage = lowerDamage+5;
             defence = defence+5;
             hp = hp+5;
             tableValues[checkingIndex]="H";
             tableValues[index]= " ";
             orbPower = 1;
             break;
         }
         else{
             if(checkerForDamage==1){
                 if(upperDamage!=0){
                    upperDamage = lowerDamage+rand.nextInt(upperDamage-lowerDamage+1);
                }
                if(lowerDamage!=0){
                    lowerDamage = rand.nextInt(lowerDamage);            
                }
                if(defence!=0){
                    defence = rand.nextInt(defence);
                }
                
                if(hp!=0){
                hp = rand.nextInt(hp);
                }
                
                //setting new player position
            if(hp!=0){
            tableValues[index]= " ";
            tableValues[checkingIndex]="H"; 
            System.out.println("Day"+day+": You are inside the Castle.\nEncounter!- Ghost");
            orbPower = 0;
            break;
            }
            else{
            System.out.println("Sorry You are defated by the Ghost");
            System.out.println("you hp is zero");
            System.out.println("Game End");
            System.exit(0);
            
            }
            
            }
            
             // if we find empty block then.
              else{
             tableValues[index]= " ";
            tableValues[checkingIndex]="H";             
            System.out.println("Day"+day+": You are inside the Castle.\nEncounter!- Ghost");
            orbPower = 0;
            break;
             }
                        
         }
        }
        
            //if player wants to get out of the Castle
        else{
           System.out.println("Sorry you cannot get out of the Castle! "); 
           continue outer3;
        }
    }
         ///for left side movement
        else if (move == 'd') {
            if(index!=63){
            checkingIndex = index+1;
                  if(tableValues[checkingIndex] == "S"){
                tableValues[checkingIndex]="H/S";
                tableValues[index] = "S";
                System.out.println("You are out on the street! ");
                break;
            }
         else if(tableValues[checkingIndex]=="O"){             
             System.out.println("You found the Orb of Power! ");
             System.out.println("Your attack increases by 5! ");
             System.out.println("Your defence increases by 5!  ");
             System.out.println("Day"+day+": You are inside the Castle.\nEncounter!- Ghost");
             upperDamage = upperDamage+5;
             lowerDamage = lowerDamage+5;
             defence = defence+5;
             hp = hp+5;
             tableValues[index]= " ";
             tableValues[checkingIndex]="H";
             orbPower = 1;
             break;
         }
                  else{
             if(checkerForDamage==1){
                            if(upperDamage!=0){
                    upperDamage = lowerDamage+rand.nextInt(upperDamage-lowerDamage+1);
                }
                if(lowerDamage!=0){
                    lowerDamage = rand.nextInt(lowerDamage);            
                }
                if(defence!=0){
                    defence = rand.nextInt(defence);
                }
                
                if(hp!=0){
                hp = rand.nextInt(hp);
                }
            if(hp!=0){
            tableValues[index]= " ";
            tableValues[checkingIndex]="H"; 
            System.out.println("Day"+day+": You are inside the Castle.\nEncounter!- Ghost");
            orbPower = 0;
            break;
            }
            else{
            System.out.println("Sorry You are defated by the Ghost");
            System.out.println("you hp is zero");
            System.out.println("Game End");
            System.exit(0);
            }
            
            }
              else{
             tableValues[index]= " ";
            tableValues[checkingIndex]="H"; 
            System.out.println("Day"+day+": You are inside the Castle.\nEncounter!- Ghost");
            orbPower = 0;
            break;
             }
                        
         }
        }
        else{
           System.out.println("Sorry you cannot get out of the Castle! "); 
           continue outer3;
        }
    }
        
        //for upper side movement
        else if (move == 'w') {
            if(index!=0 && index!=1 && index!=2 && index!=3 && index!=4 && index!=5 && index!=6 && index!=7){
            checkingIndex = index-8;
               if(tableValues[checkingIndex] == "S"){
                tableValues[checkingIndex]="H/S";
                tableValues[index] = "S";
                System.out.println("You are out on the street! ");
                break;
            }
         else if(tableValues[checkingIndex]=="O"){             
             System.out.println("You found the Orb of Power! ");
             System.out.println("Your attack increases by 5! ");
             System.out.println("Your defence increases by 5!  ");
             System.out.println("Day"+day+": You are inside the Castle.\nEncounter!- Ghost");
             upperDamage = upperDamage+5;
             lowerDamage = lowerDamage+5;
             defence = defence+5;
             hp = hp+5;
             tableValues[index]= " ";
             tableValues[checkingIndex]="H";
             orbPower = 1;
             break;
         }
                  else{
             if(checkerForDamage==1){
                            if(upperDamage!=0){
                    upperDamage = lowerDamage+rand.nextInt(upperDamage-lowerDamage+1);
                }
                if(lowerDamage!=0){
                    lowerDamage = rand.nextInt(lowerDamage);            
                }
                if(defence!=0){
                    defence = rand.nextInt(defence);
                }
                
                if(hp!=0){
                hp = rand.nextInt(hp);
                }
            if(hp!=0){
            tableValues[index]= " ";
            tableValues[checkingIndex]="H"; 
            System.out.println("Day"+day+": You are inside the Castle.\nEncounter!- Ghost");
            orbPower = 0;
            break;
            }
            else{
            System.out.println("Sorry You are defated by the Ghost");
            System.out.println("you hp is zero");
            System.out.println("Game End");
            System.exit(0);
            }
            
            }
              else{
             tableValues[index]= " ";
            tableValues[checkingIndex]="H"; 
            System.out.println("Day"+day+": You are inside the Castle.\nEncounter!- Ghost");
            orbPower = 0;
            break;
             }
                        
         }
        }
        else{
           System.out.println("Sorry you cannot get out of the Castle! "); 
           continue outer3;
        }
        
    }
    
        ///for down side movement
        else if (move == 'f') {
            if(index!=56 && index!=57 && index!=58 && index!=59 && index!=60 && index!=61 && index!=62 && index!=63){
            checkingIndex = index+8;
                if(tableValues[checkingIndex] == "S"){
                tableValues[checkingIndex]="H/S";
                tableValues[index] = "S";
                System.out.println("You are out on the street! ");
                break;
                
            }
         else if(tableValues[checkingIndex]=="O"){             
             System.out.println("You found the Orb of Power! ");
             System.out.println("Your attack increases by 5! ");
             System.out.println("Your defence increases by 5!  ");
             System.out.println("Day"+day+": You are inside the Castle.\nEncounter!- Ghost");
             upperDamage = upperDamage+5;
             lowerDamage = lowerDamage+5;
             defence = defence+5;
             hp = hp+5;
             tableValues[index]= " ";
             tableValues[checkingIndex]="H";
             orbPower = 1;
             break;
         }
                  else{
             if(checkerForDamage==1){
                             if(upperDamage!=0){
                    upperDamage = lowerDamage+rand.nextInt(upperDamage-lowerDamage+1);
                }
                if(lowerDamage!=0){
                    lowerDamage = rand.nextInt(lowerDamage);            
                }
                if(defence!=0){
                    defence = rand.nextInt(defence);
                }
                
                if(hp!=0){
                hp = rand.nextInt(hp);
                }
            if(hp!=0){
            tableValues[index]= " ";
            tableValues[checkingIndex]="H"; 
            System.out.println("Day"+day+": You are inside the Castle.\nEncounter!- Ghost");
            orbPower = 0;
            break;
            }
            else{
            System.out.println("Sorry You are defated by the Ghost");
            System.out.println("you hp is zero");
            System.out.println("Game End");
            System.exit(0);
            }
            
            }
              else{
             tableValues[index]= " ";
            tableValues[checkingIndex]="H"; 
            System.out.println("Day"+day+": You are inside the Castle.\nEncounter!- Ghost");
            orbPower = 0;
            break;
             }
                        
         }
        }
        else{
           System.out.println("Sorry you cannot get out of the Castle! "); 
           continue outer3;
        }
        
        }
        
        }
        
    }
    
    //outDoor Menu method
    public static void outDoorMenu(Scanner sc,Random rand){
               
    	//first of all values of HPS are reset
                reset();
                outer:
                while(true){
                System.out.println("You run and Hide.");
                System.out.println("Outdoor Menu");
                System.out.println("1) View character.");
                System.out.println("2) View map.");
                System.out.println("3) Move.");
                System.out.println("4) Sense Orb.");
                System.out.println("5) Exit Game.");
                System.out.println("Enter choice.");
                int outdoorOption = sc.nextInt();
                if(outdoorOption==1){
                    characteristics();
                    combatMenu(sc,rand);
                    break;
                }
                else if(outdoorOption==2){
                    map();
                    combatMenu(sc,rand);
                    break;
                }
                else if(outdoorOption==3){
                    day++;
                    checkerForDamage = 0;
                    move(sc,rand);
                    if(orbPower==1){
                        combatMenu(sc,rand);
                        break;
                    }
                    continue outer;
                }
                else if(outdoorOption==4){
                    day++;
                    
                    //finding the position of Gate
                    for(int i=3;i<50;i++){                        
                        if(tableValues[i]=="O"){
                            if(i==3 || i==11 || i==19 || i==27 || i==35 || i==43 || i==51 ||  i==59){
                                System.out.println("You sense that the Gate is to the north. ");
                                break;
                            }
                            else if(i>11 || i>19 || i>27 || i>35 || i>43 || i>51 ||  i>59){
                                System.out.println("You sense that the Gate is to the northwest. ");
                                break;
                            }
                            else if(i==10 || i==18 || i==26 || i==34 || i==42 || i==50 ||  i==58){
                                System.out.println("You sense that the Gate is to the west. ");
                                break;
                            }
                            else{
                                System.out.println("You sense that the Gate is to the southeast. ");
                                break;
                            }
                                
                        }
                        
                        //break outer;
                    }
                    combatMenu(sc,rand);
                    break;
                }
                
                else {              
                System.out.println("Game Ended.");
                System.exit(0);
                    break;
                }
                
                }
                
    
    }
    
    //reset method.
    public static void reset(){
         hp = 20;
         day++;
         magicCastle = 15;
         System.out.println("you and the Ghost are fully healed");
    }
    
    
    //combat menu
    public static void combatMenu(Scanner sc,Random rand){
        System.out.println("Demage: "+lowerDamage+" to "+upperDamage);
       System.out.println("Defence: "+defence);
       System.out.println("HP: "+hp);
        outer1:
        while(true){                             
              System.out.println("Combat Menu");
             System.out.println("1) Attack.");
             System.out.println("2) Run.");
            System.out.println("Enter choice.");
            int combatOption = sc.nextInt();
            if(combatOption==1){               
                attack(rand);
                continue outer1;
            }
            else{                                
                outDoorMenu(sc,rand);
                break;
            }
        }
               
    
    }
    
    public static void castleMenu(Scanner sc,Random rand){
        outer2:
        while(true){
        System.out.println("Magic Castle Menu"); 
        System.out.println("Day"+day+": \nYou are in a magic Castle.");
        System.out.println("1) View character.");
        System.out.println("2) View map.");
        System.out.println("3) Move.");
        System.out.println("4) Reset.");
        System.out.println("5) Save Game.");
        System.out.println("6) Exit Game.");
        System.out.println("Enter choice.");
        int againOption = sc.nextInt();
        if(againOption==1){       
        characteristics();
        continue outer2;
        }
        else if(againOption==2){
            if(checker==0){                
            tableValues[0] = "H/S";            
            checker = 1;
           }
            System.out.println("\nThe Map is:");
            map();
            continue outer2;
        }
        else if(againOption==3){
            day++;
            System.out.println("Day"+day+": You are inside the Castle.\nEncounter!- Ghost");
            checkerForDamage = 1;
            
            //after moving                        
                move(sc,rand);                
                combatMenu(sc,rand);
                break;
        }
        else if(againOption==4){
            reset();
        }
        else if(againOption==5){
        }
        else {
            System.out.println("Game Ended.");
            System.exit(0);
            break;
        }
        
        }
    }
        
}


