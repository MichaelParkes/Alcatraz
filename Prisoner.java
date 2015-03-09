import java.util.Observer;
import java.util.Observable;

//import java.util.Random;

public class Prisoner extends Enemy
{
   private Armor armor;
   
   public Prisoner()
   {
      super("Prisoner", 10, null);
      this.armor = null;
   }
   
   public void setArmor(Armor a) {this.armor = a;}
   
   public void defend(int damage, int acc)
   {
      if(this.armor != null)
         damage = this.armor.DefendWith(damage, acc);
      
      this.harm(damage);
      
      System.out.println("Prisoner takes " + damage + " damage!");
      
      return;
   }
   
   public void subscribeToTimer(Observable timer)
   {
      timer.addObserver(this);
      combatTimer = timer;
   }
}