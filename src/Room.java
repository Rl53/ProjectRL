public class Room{
  Monster[] monsters;


  public Room(int counter){
    // species will randomize and change after adding more classes

    if (counter < 4){
      Dragon m1 = new Dragon("",40,40,10,400,400,"dragon", false);
      Monster[] m = {m1};
      monsters = m;
    } else if (counter < 7) {
      Dragon m1 = new Dragon("",40,40,10,400,400,"dragon", false);
      Goblin m2 = new Goblin("",30,30,10,400,400,"goblin", false);
      Monster[] m = {m1,m2};
      monsters = m;
    } else if (counter < 10){
      Dragon m1 = new Dragon("",30,30,10,400,400,"dragon", false);
      Dragon m2 = new Dragon("",30,30,10,400,400,"dragon", false);
      Dragon m3 = new Dragon("",30,30,10,400,400,"dragon", false);
      Monster[] m = {m1,m2,m3};
      monsters = m;
    } else if (counter == 10){
      Dragon dragon1 = new Dragon("elder",30,30,10,400,400,"dragon", false);
      Monster[] m = {dragon1};
      monsters = m;
    }
  }
  public boolean monsterDead(){
    for (int i = 0; i < monsters.length; i++){
      if (!monsters[i].isDead()){
        return false;
      }
    }
    return true;
  }
  public Monster[] getMonsters(){
    return monsters;
  }
  public void targetList(){
    System.out.print("Which creature do you attack, ");
    for (int i = 0; i < monsters.length; i++){
    System.out.print("the " + monsters[i].getElement()+ monsters[i].getSpecies() +"("+(i+1)+"), ");
      }
    System.out.println("?");
  }

  
}