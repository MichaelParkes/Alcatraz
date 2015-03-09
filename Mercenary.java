import java.util.Observable;
import java.util.Observer;

public class Mercenary extends Enemy
{
   private Armor armor;
   private ForceField ff;
   private Implant implant;
   
   public Mercenary()
   {
      super("Mercenary", 10, null);
      this.armor = null;
      this.ff = null;
      this.implant = null;
   }
   
   public void setArmor(Armor a) {this.armor = a;}
   public void setForceField(ForceField frcfld) {this.ff = frcfld;}
   public void setImplant(Implant imp) {this.implant = imp;}
   
   public void defend(int damage, int acc)
   {
      if(this.implant != null)
         this.implant.DefendWith(damage, acc);
      
      if(damage == 0)
         return;
      
      if(this.ff != null)
         this.ff.DefendWith(damage, acc);
      
      if(damage == 0)
         return;
      
      if(this.armor != null)
         damage = this.armor.DefendWith(damage, acc);
      
      this.harm(damage);
      
      System.out.println("Mercenary takes " + damage + " damage!");
      
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