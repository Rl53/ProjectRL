public class Player{
  int maxHp;
  int hp;
  Sword sword = new Sword();
  Armor armor = new Armor();

  public Player(){
    maxHp = 100;
    hp = 100;
    
  }
 public void takeDamage(int damaged){
   int dodged = (int)((Math.random()*100)+1);
   if (armor.getDodge() >= dodged){
     damaged = 0;
     System.out.println("You dodged the attack!");
   } else {
    hp -= (damaged - armor.getDefense());
    System.out.println("You take "+(damaged - armor.getDefense())+ " damage.");
    if (hp <= 0){
      System.out.println("You have died!");
      System.exit(0);
    }
   }
  }
  public Sword getSword(){
    return sword;
  }
  public int getMax(){
    return maxHp;
  }
  public void hpMore(int more){
    hp += more;
  }
  public Armor getArmor(){
    return armor;
  }
  public void setMax(int newer){
    maxHp = newer;
  }
  public void fullHp(){
    hp = maxHp;
  }






  
}