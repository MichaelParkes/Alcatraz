import java.util.Observable;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Random;

public class Combat extends Observable
{
   private int timeElapsed; //Measure time 
   private ArrayList<Character> actionQueue;
   private CombatTimer timer; 
   
//CONSTRUCTORS---------------------------------------------------------------------------

   //private Combat() {}//Hidden default constructor
   
   public Combat(Party party, Enemy[] enemies)
   {
      this.timeElapsed = 0;
      timer = new CombatTimer();
      this.actionQueue = new ArrayList<Character>(party.size() + enemies.length);
   }

//GETS & SETS----------------------------------------------------------------------------



//CLASS-LEVEL METHODS--------------------------------------------------------------------

   public boolean fight(Party party, Enemy[] enemies)
   {
      Random rnd = new Random();
      Character actor, target;
      int i, j;
      int ps = party.size();
      int es = enemies.length;
      int partyDefeat = 0;
      int enemyDefeat = 0;
      
      //Display the fight to console
      System.out.print("A ");
      
      if(es > 1)
      {
         for(i = 0; i < enemies.length; i++)
         {
            if(i == enemies.length - 1)
               System.out.print("and " +enemies[i].getName() + " ");
            else
               System.out.print(enemies[i].getName() + ", ");
         }
         System.out.print("attack!\r\n\r\n");
      }
      else
      {
         System.out.print(enemies[0].getName() + " ");
         System.out.print("attacks!\r\n\r\n");
      }
      
      //Populate the Action Queue. Initial delay times are randomized.
      for(i = 0; i < party.size(); i++) //PCs
      {
         actor = party.getPartyMembers()[i];
         actor.setDelay(rnd.nextInt(20));
         actionQueue.add(actor);
         actor.subscribeToTimer(timer);
      }
      
      for(j = 0; i < party.size() + enemies.length; i++, j++) //Enemies
      {
         actor = enemies[j];
         actor.setDelay(rnd.nextInt(20));
         actionQueue.add(actor);
         actor.subscribeToTimer(timer);
      }
      
      actionQueue.trimToSize();
      Collections.sort(actionQueue);
      
      //Main fighting loop
      while(partyDefeat < ps && enemyDefeat < es)
      {
         actor = actionQueue.remove(0);
                  
         timeElapsed = actor.getDelay();
         
         //Update the timer and this wil notify all subscribed objects
         timer.addTime(timeElapsed);
         
         //If the next character to act is a PC, target a random enemy to attack. If the next character is an enemy, target random PC.
         //This method might lag if, for instance, there are 6 defeated enemies in a 7-enemy party. Consider revision.
         do
         {
            if(actor instanceof PC)
               target = enemies[rnd.nextInt(es)];
            else
               target = party.getPartyMembers()[rnd.nextInt(ps)];
         }while(target.defeated());
         
         //Attack
         System.out.print(actor.getName() + " attacks " + target.getName() + " with ");
         Weapon.attack(actor.getWeapon(), target);
         actor.setDelay(actor.getWeapon().getSpeed()); 
         actionQueue.add(actor);
            
         if(target.defeated())
         {
            if(target instanceof Enemy)
               System.out.println("A " + target.getName() + " is defeated!");
            else
               System.out.println(target.getName() + " is defeated!");
            
            actionQueue.remove(target);
            
            if(target instanceof PC)
               partyDefeat++;
            else
               enemyDefeat++;
         }
         
         Collections.sort(actionQueue);
      }
      
      //Unsubscribe all from CombatTimer
      this.timer.deleteObservers();
      
      if(partyDefeat == ps)
      {
         System.out.println("\r\nU ded.\r\n");
         return false;
      }
      else
      {
         party.restore();
         System.out.println("\r\nThe attackers are defeated! Sweet victory!\r\n");
         return true;
      }
   }

   public void tick()
   {
      setChanged();
      notifyObservers();
   }

}
