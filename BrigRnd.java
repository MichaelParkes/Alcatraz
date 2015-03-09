import java.util.Random;

public class BrigRnd implements Event
{
   public BrigRnd()
   {
      //Empty constructor
   }
   
   //Brig-type rooms generate random encounters with easy prisoner-type enemies, low-level loot, or not event at all.
   public boolean runEvent(Party party)
   {
      Random rnd = new Random();
      int i = rnd.nextInt(100);
      boolean go = true; //boolean go is used to determine if gameplay continues after this room's event has been resolved.
      
      //if i <= 70, nothing happens
      if(i > 35 && i <= 90) //Approx 55% chance of combat
      {
         System.out.print("The crew is encounters an escaped band of prisoners!\r\n\r\n");
         
         //Generate party of "prisoner"-type enemies, up to 150% of party size
         int size = party.size();
         int j;
         PrisonerBuilder pb = null;
         
         if(size > 1)
            size = size + (size / 2) + (size % 2);
         else
            size = 2;
         
         size = rnd.nextInt(size) + 1;
         
         Enemy[] enemies = new Enemy[size];
         
         for(i = 0; i < enemies.length; i++)
         {
            pb = new PrisonerBuilder();
            
            j = rnd.nextInt(9);
            
            if(j < 4) //Make "weasel", a weak enemy type
            {
               pb.setName("weasel");
               pb.setHP(rnd.nextInt(11) + 15); //15-25 HP
               pb.setWeapon(new Weapon("shiv", "A makeshift stabbing weapon", rnd.nextInt(11) + 5, rnd.nextInt(3) + 14, rnd.nextInt(6) + 93));
               pb.setArmor(new Armor("jumpsuit", "Standard issue bright orange jumpsuit", -1));
            }
            else if(j > 3 || j < 7) //Make "thug", a moderately tough enemy
            {
               pb.setName("thug");
               pb.setHP(rnd.nextInt(11) + 25);
               pb.setWeapon(new Weapon("sturdy pipe", "A heavy section of pipe, salvaged from the Alcatraz's environmental system", rnd.nextInt(6) + 10, rnd.nextInt(11) + 45, rnd.nextInt(6) + 93));
               pb.setArmor(new Armor("jumpsuit", "Standard issue bright orange jumpsuit", -1));
            }
            else //Make "brute", 
            {
               pb.setName("armored brute");
               pb.setHP(rnd.nextInt(11) + 50);
               pb.setWeapon(new Weapon("fists", "Slow-swinging windmill punches land hard (if they land at all)", rnd.nextInt(11) + 15, rnd.nextInt(11) + 50, rnd.nextInt(6) + 83));
               pb.setArmor(new Armor("riot gear", "Padded and plated riot gear, probably stolen from an equipment locker", 1));
            }
            
            enemies[i] = pb.build();
         }
         
         //Instantiate new combat
         Combat cmb = new Combat(party, enemies);
         
         //Start combat
         go = cmb.fight(party, enemies);
         
         return go;
      }
      else if(i > 90) //Approx 10% chance of loot
      {
         System.out.print("Brig loot!\r\n\r\n");
      }
      
      return go;
   }
}
