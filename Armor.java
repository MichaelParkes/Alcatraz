public class Armor extends Item implements Defend
{
    private int resistance;

//CONSTRUCTORS---------------------------------------------------------------------------
   
   public Armor()
   {
      super("Clothing", "This garb provides no significant protection");
      this.resistance = 0;
   }
   
   public Armor(int r)
   {
	   super("Armor", "This rugged garb reduces the damage of incoming attacks");
      if(r > -1)
         this.resistance = 5 + (10 * r);
      else
         this.resistance = 0;
   }
   
   public Armor(String name, String description, int r)
   {
	   super(name, description);
      
      if(r > -1)
         this.resistance = 5 + (10 * r);
      else
         this.resistance = 0;
   }

//CLASS-LEVEL METHODS--------------------------------------------------------------------

   public int DefendWith(int damage, int accuracy)
	{
      if(this.resistance == 0)
         return damage;
         
      float temp = (float)damage / resistance;
      damage = damage - Math.round(temp);
      
      if(damage == 0)
         System.out.println("The attack is absorbed by armor.");
      
	   return damage;
	}

   @Override
   public void equip(PC owner)
   {
   	owner.setArmor(this);
   }
}
