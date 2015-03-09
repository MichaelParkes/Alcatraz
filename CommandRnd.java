import java.util.Random;

public class CommandRnd implements Event
{
   public CommandRnd()
   {
      //Empty constructor
   }
   
   public boolean runEvent(Party party)
   {
      Random rnd = new Random();
      int i = rnd.nextInt(100);
      boolean go = true; //boolean go is used to determine if gameplay continues after this room's event has been resolved.
      
      //if i <= 70, nothing happens
      if(i > 15 && i <= 90) //Approx 75% chance of combat
      {
         //Combat
         System.out.print("Command fight!\r\n\r\n");
      }
      else if(i > 90)
      {
         //Loot things
         System.out.print("Command loot!\r\n\r\n");
      }
      
      return go;
   }
}
