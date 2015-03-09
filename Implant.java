import java.util.Random;

public class Implant extends Item implements Defend
{
    private int evade;

//CONSTRUCTORS---------------------------------------------------------------------------
   
   public Implant(int e)
   {
	   super("Implant", "A cybernetic doo-hickey that heightens spatial awareness, granting an increased chance to dodge attacks.\n");
       this.evade = (e * 10);
   }

//CLASS-LEVEL METHODS--------------------------------------------------------------------

   public int DefendWith(int damage, int accuracy)
	{
	   Random rnd = new Random();
	      int i = rnd.nextInt(100);//Returns 0 to 99
	      int hitRange = accuracy - this.evade;
	      
	      if(i < hitRange) {
	    	   //System.out.println("HIT\n");
	         return damage; }
	      else
	      {
	         System.out.println("The attack is dodged!");
	         return 0;
	      }
	}

   @Override
   public void equip(PC owner)
   {
   	owner.setImp(this);
   }
}
