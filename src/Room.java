public class Room{
  Dragon[] dragons;


  public Room(int counter){
    if (counter < 4){
      Dragon dragon1 = new Dragon("");
      Dragon[] drag = {dragon1};
      dragons = drag;
    } else if (counter < 7) {
      Dragon dragon1 = new Dragon("");
      Dragon dragon2 = new Dragon("");
      Dragon[] drag = {dragon1,dragon2};
      dragons = drag;
    } else if (counter < 10){
      Dragon dragon1 = new Dragon("");
      Dragon dragon2 = new Dragon("");
      Dragon dragon3 = new Dragon("");
      Dragon[] drag = {dragon1,dragon2,dragon3};
      dragons = drag;
    } else if (counter == 10){
      Dragon dragon1 = new Dragon("elder");
         Dragon[] drag = {dragon1};
         dragons = drag;
    }
  }
  public boolean dragonsDead(){
    for (int i = 0; i < dragons.length; i++){
      if (dragons[i].isDead()==false){
        return false;
      }
    }
    return true;
  }
  public Dragon[] getDragons(){
    return dragons;
  }
  public void targetList(){
    System.out.print("Which dragon do you attack, ");
    for (int i = 0; i < dragons.length; i++){
    System.out.print("the " + dragons[i].getElement()+ " dragon"+"("+(i+1)+"), ");
      }
    System.out.println("?");
  }

  
}