//import java.util.Random;

//The enemy class is designed to be decorated with EnemyDecorators to create unique enemies
public abstract class Enemy extends Character
{
   private Weapon primary; //Can use pre-coded weapons, or custom weapons via the Weapons class constructor

//CONSTRUCTORS---------------------------------------------------------------------------

   private Enemy() {super("", -1);} //Hidden default constructor
   
   public Enemy(String n, int hitPoints, Weapon w)
   {
      super(n, hitPoints);
      this.primary = w;
   }

//GETS & SETS----------------------------------------------------------------------------

   public Weapon getWeapon() {return this.primary;}
   public void setWeapon(Weapon w) {this.primary = w;}

//CLASS-LEVEL METHODS--------------------------------------------------------------------

   public abstract void defend(int damage, int acc);
}
