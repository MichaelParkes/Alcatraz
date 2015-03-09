import java.util.Observable;
import java.util.Observer;

public class PC extends Character
{
   private Weapon primary; //Each PC may equip one primary weapon. Weapon stats are passed to an attack()-type method.
   //private Accessory acc; //Each PC may equip one accessory (medkit, drone, motion detector, decoy, shield... just ideas). A use()-type method may grant this character more options in combat.
   private ForceField ff; //Each PC may equip one force field. Force fields discharge and cancel one incoming attack. Must recharge between uses. Must subscribe to the observable combatTimer to recharge.
   private Armor armor; //Each PC may equip one suit of armor. Armor reduces incoming damage.
   private Implant implant; //Each PC may equip one implant. Implants grant a chance to evade incoming attacks.
   //private Behavior special; <--[DEV]Maybe add special/unique abilities for each class later
   private boolean defeated;
   
//CONSTRUCTORS---------------------------------------------------------------------------

   private PC() {super("", -1);} //Hidden private constructor

   public PC(String n, int hp)
   {
      super(n, hp);
      this.primary = null;
      this.ff = new ForceField(0);
      this.armor = new Armor(0);
      this.implant = new Implant(0);
      this.defeated = false;
   }

//GETS & SETS----------------------------------------------------------------------------

   public Weapon getWeapon() {return this.primary;}
   public void setWeapon(Weapon w) {this.primary = w;}
   public ForceField getFF() {return this.ff;}
   public void setFF(ForceField frcFld) {this.ff = frcFld;}
   public Armor getArmor(){return this.armor;}
   public void setArmor(Armor Arm){this.armor = Arm;}
   public Implant getImp(){return this.implant;}
   public void setImp(Implant imp){this.implant = imp;}
   public boolean getDefeated() {return this.defeated;}
   public void setDefeated(boolean d) {this.defeated = d;}

//CLASS-LEVEL METHODS--------------------------------------------------------------------

   public void defend(int damage, int acc)
   {
      if(this.implant != null)
   	   damage = this.implant.DefendWith(damage, acc);
      
   	if(damage == 0)
   		return;
      
      if(this.ff != null)
   	   damage = this.ff.DefendWith(damage,acc);
      
   	if(damage == 0)
   		return;
      
      if(this.armor != null)
   	   damage = this.armor.DefendWith(damage,acc);
      
   	this.harm(damage);
      
      System.out.println("Crew member takes " + damage + " damage!");
           
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