import java.util.Observable;
import java.util.Observer;

public class Robot extends Enemy
{
   private Armor armor;
   private ForceField ff;
   
   public Robot()
   {
      super("Robot", 10, null);
      this.armor = null;
      this.ff = null;
   }
   
   public void setArmor(Armor a) {this.armor = a;}
   public void setForceField(ForceField frcfld) {this.ff = frcfld;}
   
   public void defend(int damage, int acc)
   {
      if(this.ff != null)
         this.ff.DefendWith(damage, acc);
      
      if(damage == 0)
         return;
      
      if(this.armor != null)
         damage = this.armor.DefendWith(damage, acc);
      
      this.harm(damage);
      
      System.out.println("Robot takes " + damage + " damage!");
      
      return;
   }
   
   public void subscribeToTimer(Observable timer)
   {
      if(ff != null)
         ff.subscribeToTimer(timer);
         
      timer.addObserver(this);
      combatTimer = timer;
   }
}