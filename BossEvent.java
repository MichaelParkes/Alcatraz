public class BossEvent implements Event
{
   public BossEvent()
   {
      //Empty constructor
   }
   
   public boolean runEvent(Party party)
   {
      boolean go = true;
      
      System.out.print("There's a boss in here!\r\n\r\n");
      
      return go;
   }
}
