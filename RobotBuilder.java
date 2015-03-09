public class RobotBuilder
{
   private Robot robot;
   private Weapon primary;
   private Armor armor;
   private ForceField ff;
   private boolean done;
   
   public RobotBuilder()
   {
      this.primary = null;
      this.armor = new Armor(1);
      this.ff = new ForceField(1);
      this.robot = new Robot();
      this.done = false;
   }
   
   public Robot build()
   {
      if(done)
         return null;
      else
      {
         done = true;
         return this.robot;
      }
   }
   
   public RobotBuilder setName(String n)
   {
      this.robot.setName(n);
      return this;
   }
   
   public RobotBuilder setHP(int hp)
   {
      this.robot.setMaxHp(hp);
      this.robot.setCurHp(hp);
      return this;
   }
   
   public RobotBuilder setWeapon(Weapon w)
   {
      this.robot.setWeapon(w);
      return this;
   }
   
   public RobotBuilder setArmor(Armor a)
   {
      this.robot.setArmor(a);
      return this;
   }
   
   public RobotBuilder setForceField(ForceField frcfld)
   {
      this.robot.setForceField(frcfld);
      return this;
   }
}