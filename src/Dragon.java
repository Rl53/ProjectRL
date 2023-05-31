
import java.awt.Rectangle;

public class  Dragon{
  private int maxHp;
  private int hp;
  private int damage;
  private String element;
  private boolean breath;

  private Rectangle rect;




  public Dragon(String elder){
    breath = false;
    maxHp = 30;
    hp = 30;
    damage = 15;
    rect = new Rectangle(100,100);
    int value = (int)(Math.random() * 4)+1;
    if (value == 1){
      element = "fire";
    } else if (value == 2){
      element = "ice";
    } else if (value == 3){
      element = "lightning";
    } else if (value == 4){
      element = "earth";
    }
    if (elder.equals("elder")){
      hp = 90;
      maxHp = 90;
      damage = 30;
    }
    
  }
  
  public String getElement(){
    return element;
  }
  
  public int getHp(){
    return hp;
  }

  public boolean isBreath(){
    return breath;
  }

  public Rectangle getBody(){ return rect;}

  public int attack(int b){
    if (breath == true){
      breath = false;
      System.out.println("Dragon " + (b+1) +" breaths out a blast of "+element+".");
      return damage * 2;
    }
    int value = (int)(Math.random() * 4)+1;
    if (value == 1){
      breath = true;
    }
    int extra = (int)(Math.random() * 3)+1;
    if (extra == 1){
      System.out.println("Dragon " + (b+1)+ " slashes with it's claws.");
    }if (extra == 2){
      System.out.println("Dragon " + (b+1)+ " hits you with it's tail.");
    }if (extra == 3){
      System.out.println("Dragon " + (b+1)+ " bites down on you.");
    }
    return damage;
  }
  public String takeDamage(int damaged){
    hp -= damaged;
    if (hp <= 0){
      return "That "+element+ " dragon has died!";
    }
    return "You deal "+damaged+ " damage.";
  }

  public boolean isDead(){
    if (hp <= 0){
      return true;
    }
    return false;
  }

  
  






  
}