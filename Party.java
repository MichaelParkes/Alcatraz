import java.util.Scanner;

class Party
{
   private Room location;
   private PC[] party;
   private int size;

//CONSTRUCTORS---------------------------------------------------------------------------

   private Party()
   {
      this.location = null;
      this.party = null;
      this.size = 0;
   }//Hidden default constructor
   
   public static Party createParty()
   {
      Scanner kb = new Scanner(System.in);
      Party newParty = new Party();
      int size = 0;
      String name = null;
      
      System.out.print("How many crew members on board?: ");
      
      while(size < 1)
      {
         try
         {
            size = kb.nextInt();
            kb.nextLine();
         }
         catch(Exception e)
         {
            System.out.print("Perhaps the commander has succumbed to space sickeness?");
            size = 0;
         }
         
         if(size < 1)
            System.out.print("That specification is not valid.\r\nHow many crew members on board?");
      }
      
      newParty.party = new PC[size];
      newParty.size = size;
      
      System.out.print("Complete the roster by entering the names of the " + size + " crew members.\r\n");
      
      for(int i = 0; i < size; i++) //This part may need some additional error-checking
      {
         System.out.printf("Crew member %d: ", i+1);
         name = kb.nextLine();
         
         if(name.indexOf('\n') != -1)
            name = name.substring(0, name.indexOf('\n'));
         
         if(name.indexOf('\r') != -1)
            name = name.substring(0, name.indexOf('\r'));
         
         newParty.party[i] = new PC(name, 100);
         newParty.party[i].setWeapon(WeaponFactory.getWeapon("unarmed", 1));
      }

      return newParty;
   }
   
//GETS & SETS----------------------------------------------------------------------------

   public Room getLocation() {return this.location;}
   public void setLocation(Room r) {this.location = r;}
   public PC[] getPartyMembers() {return this.party;}
   public int size() {return this.size;}
   
//CLASS-LEVEL METHODS--------------------------------------------------------------------

   public void restore()
   {
      for(int i = 0; i < this.size; i++)
         party[i].restore();
   }
}
