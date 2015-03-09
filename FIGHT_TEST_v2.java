/* FIGHT_TEST_v2 uses Event to determine what happens when the party enters a new room.

   2015/2/28:  The current room's event.runEvent() will fire.
               Actual combat is not initialized.
   2015/3/8:   
 */

import java.io.*;

public class FIGHT_TEST_v2
{
   public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException
   {
      Party party = null;
      boolean go = true;
      Room[] rooms = null;
      Map map = null;
      Enemy[] enemies = null;
      Combat combat;
      
      File fin = new File("Alcatraz_v.2.txt");
      
      map = Map.initMap(fin); //Initialize display map & components
      
      rooms = Room.initRooms(fin); //Initialize rooms
      
      party = Party.createParty(); //[DEV:TEST]Create party of 4 PCs. This is a testing method.
      party.setLocation(rooms[Room.locateStart(fin)]); //Set initial party location
      
      do
      {
         map.display(party); //Draw map to screen
         
         go = party.getLocation().enter(party); //Print room name. Check if visited; if not, print description of room.
         
         if(go == true)
            go = Room.move(party); //Display and selection options for next movement.
         
      }while(go);
      
      System.out.println("Quittin'...");

   }//end main()
}

//Just saving some section headers to copy+paste here:
//CONSTRUCTORS---------------------------------------------------------------------------



//GETS & SETS----------------------------------------------------------------------------



//CLASS-LEVEL METHODS--------------------------------------------------------------------

