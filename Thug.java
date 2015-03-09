import java.util.Observable;

public class Thug extends Enemy
{
   //Currently no data fields
   
//CONSTRUCTORS---------------------------------------------------------------------------

   public Thug()
   {
      super("Thug", 50, new Weapon("Unarmed", "Empty-handed", 10, 50, 95));
   }
   
   public Thug(int num)
   {
      super("Thug " + num, 50, new Weapon("Unarmed", "Empty-handed", 10, 50, 95));
   }

@Override
public void defend(int damage, int acc) {
	// TODO Auto-generated method stub
	
}

@Override
public void subscribeToTimer(Observable timer) {
	// TODO Auto-generated method stub
	
}

//GETS & SETS----------------------------------------------------------------------------



//CLASS-LEVEL METHODS--------------------------------------------------------------------

}
