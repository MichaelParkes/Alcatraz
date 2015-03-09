public class PrisonerBuilder
{
   private Prisoner prisoner;
   private Weapon primary;
   private Armor armor;
   private boolean done;
   
   public PrisonerBuilder()
   {
      this.primary = null;
      this.armor = null;
      this.prisoner = new Prisoner();
      this.done = false;
   }
   
   public Prisoner build()
   {
      if(done)
         return null;
      else
      {
         done = true;
         return this.prisoner;
      }
   }
   
   public PrisonerBuilder setName(String n)
   {
      this.prisoner.setName(n);
      return this;
   }
   
   public PrisonerBuilder setHP(int hp)
   {
      this.prisoner.setMaxHp(hp);
      this.prisoner.setCurHp(hp);
      return this;
   }
   
   public PrisonerBuilder setWeapon(Weapon w)
   {
      this.prisoner.setWeapon(w);
      return this;
   }
   
   public PrisonerBuilder setArmor(Armor a)
   {
      this.prisoner.setArmor(a);
      return this;
   }
}