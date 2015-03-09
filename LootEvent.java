public class LootEvent implements Event
{
   public LootEvent()
   {
      //Empty constructor
   }
   
   public boolean runEvent(Party party)
   {
      boolean go = true;
      
      System.out.print("There's a foot locker full of loot here!\r\n\r\n");
      
      return go;
   }
}
