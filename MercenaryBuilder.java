public class MercenaryBuilder
{
   private Mercenary mercenary;
   private Weapon primary;
   private Armor armor;
   private ForceField ff;
   private Implant implant;
   private boolean done;
   
   public MercenaryBuilder()
   {
      this.primary = null;
      this.armor = null;
      this.ff = null;
      this.implant = null;
      this.mercenary = new Mercenary();
      this.done = false;
   }
   
   public Mercenary build()
   {
      if(done)
         return null;
      else
      {
         done = true;
         return this.mercenary;
      }
   }
   
   public MercenaryBuilder setName(String n)
   {
      this.mercenary.setName(n);
      return this;
   }
   
   public MercenaryBuilder setHP(int hp)
   {
      this.mercenary.setMaxHp(hp);
      this.mercenary.setCurHp(hp);
      return this;
   }
   
   public MercenaryBuilder setWeapon(Weapon w)
   {
      this.mercenary.setWeapon(w);
      return this;
   }
   
   public MercenaryBuilder setArmor(Armor a)
   {
      this.mercenary.setArmor(a);
      return this;
   }
   
   public MercenaryBuilder setForceField(ForceField frcfld)
   {
      this.mercenary.setForceField(frcfld);
      return this;
   }
   
   public MercenaryBuilder setImplant(Implant imp)
   {
      this.mercenary.setImplant(imp);
      return this;
   }
}