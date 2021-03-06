import java.util.Observable;
import java.util.Observer;

public abstract class Character implements Comparable<Character>, Observer
{
   private String name;
   private int maxHp; //Maximum Hit Points
   private int curHp; //Current Hit Points
   private int actionDelay;
   private boolean defeated;
   Observable combatTimer;

//CONSTRUCTORS--------------------------------------------------------------------------- 
   public Character(String n, int hitPoints)
   {
      this.name = n;
      this.maxHp = hitPoints;
      this.curHp = hitPoints;
      this.actionDelay = 0;
      this.defeated = false;
      combatTimer = null;
   }
   
//GETS & SETS----------------------------------------------------------------------------

   public String getName() {return this.name;}
   public void setName(String n)  {this.name = n;}
   public int getDelay() {return this.actionDelay;}
   public void setDelay(int delay) {this.actionDelay = delay;}
   public void modDelay(int mod) {this.actionDelay -= mod;}
   public abstract Weapon getWeapon();
   public boolean defeated() {return this.defeated;}
   public int getMaxHp(){return this.maxHp;}
   public void setMaxHp(int HP){this.maxHp = HP;}
   public int getCurHp(){return this.curHp;}
   public void setCurHp(int HP){this.curHp = HP;}
   public void setDefeated(boolean f){this.defeated=f;}
   
//CLASS-LEVEL METHODS--------------------------------------------------------------------

   public abstract void subscribeToTimer(Observable timer);
   public abstract void defend(int damage,int acc);

   public void harm(int damage)
   {
      this.curHp -= damage;
      
      if(this.curHp < 1)
         this.defeated = true;
   }
   
   public void restore()
   {
      this.curHp = this.maxHp;
      this.actionDelay = 0;
      this.defeated = false;
   }
   
   public int compareTo(Character that)
   {
      return this.actionDelay - that.actionDelay;
   }
   
   public void update(Observable obs, Object args)
   {
      if(obs instanceof CombatTimer){
         CombatTimer myTimer = (CombatTimer)obs;
         actionDelay -= myTimer.getChange();
      }
   }
}
