import java.util.Random;

public class BarracksRnd implements Event
{
   public BarracksRnd()
   {
      //Empty constructor
   }
   
   public boolean runEvent(Party party)
   {
      Random rnd = new Random();
      int i = rnd.nextInt(100);
      boolean go = true; //boolean go is used to determine if gameplay continues after this room's event has been resolved.
      
      //if i <= 35, nothing happens
      if(i > 25 && i <= 90) //Approx 65% chance of combat
      {
         //Combat
         System.out.print("Barracks fight!\r\n\r\n");
      }
      else if(i > 90)
      {
         //Loot things
         System.out.print("Barracks loot!\r\n\r\n");
      }
      
      return go;
   }
}
