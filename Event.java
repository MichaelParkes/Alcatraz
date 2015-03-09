public interface Event
{
   public abstract boolean runEvent(Party party);
}

/*
   public boolean runEvent(Party party)
   {
      Random rnd = new Random();
      int i = rnd.nextInt(100);
      boolean go = true; //boolean go is used to determine if gameplay continues after this room's event has been resolved.
      
      //if i <= 70, nothing happens
      if(i > 70 && i <= 90) //Approx 30% chance of combat
      {
         //Combat
         System.out.print(" fight!\r\n");
      }
      else if(i > 90)
      {
         //Loot things
         System.out.print(" loot!\r\n");
      }
      
      return go;
   }
*/
