import java.util.Observer;
import java.util.Observable;

public class ForceField extends Item implements Observer, Defend
{
   private int rechargeTime; //Amount of time needed to recharge. Less time is better.
   private int chargeTimer; //Set to 0 when force field discharges. Ticks upward with update()s from combatTimer.
   private boolean charged;
   private Observable obs;
   
//CONSTRUCTORS---------------------------------------------------------------------------
   
   public ForceField(int level)
   {
	   super("Force Field", "Maintins a defensive particle field around the user, nullifying a single incoming attack. Nullification drains the capacitor, which needs time to recharge between uses.\n");
	   this.rechargeTime = 1000 - (200 * level);
       this.chargeTimer = 0;
       this.charged = true;
       this.obs = null;
   }

//GETS & SETS----------------------------------------------------------------------------

   public void reset() {this.chargeTimer = 0;}

//CLASS-LEVEL METHODS--------------------------------------------------------------------

   public void update(Observable obs, Object arg)
   {
      if(obs instanceof CombatTimer){
         CombatTimer cmbTimer = (CombatTimer)obs;
         chargeTimer += cmbTimer.getChange();
      }
      
      if(chargeTimer >= rechargeTime)
         charged = true;
   }

   public void subscribeToTimer(Observable cmbTimer)
   {
      chargeTimer = 0;
      charged = true;
      cmbTimer.addObserver(this);
      obs = cmbTimer;
   }
   
   public void equip(PC owner)
   {
      owner.setFF(this);
   }
   
   public int DefendWith(int damage, int accuracy)
	{
	   if(charged)
	      {
	         charged = false;
	         chargeTimer = 0;
	         System.out.println("BONK! A force field blocked the attack!");	         
	         return 0;
	      }
	      else
	    	  return damage;         
	}
}
