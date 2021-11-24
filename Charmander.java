public class Charmander extends Pokemon implements Fire {

  /**
   * Charmander constructor
   */
  public Charmander() {
    super("Charmander");
  }

  /**
   * @return the list of special attack
   */
  @Override
  public String getSpecialMenu( ){
    return specialMenu;
  }

  /**
   * @return the number of special attacks
   */
  @Override
  public int getNumSpecialMenuItems() {
    return numSpecialMenuItems;
  }
  
  /**
   * @param p pokemon 
   * @param move move slot
   * @return uses a special attack towards pokemon
   */
  @Override
  public String specialAttack(Pokemon p, int move) {
    if(move == 1) {
      return this.ember(p);
    }
    else if (move == 2) {
      return this.fireBlast(p);
    }
    return this.firePunch(p);
  }

  @Override
  public String ember(Pokemon p) {
    int dRange = (int)( Math.random() * ((3 - 0)+1) +0) ;
    int bTable = (int) battleTable[this.getType()][p.getType()];
    int damage = dRange * bTable;
    p.takeDamage(damage);

    return this.getName() + "! EMBER! " + p.getName() + " got burnt for " + damage + "!";
  }

  @Override
  public String fireBlast(Pokemon p) {
    int dRange = (int)( Math.random() * ((4 - 1)  + 1) + 1);
    int bTable = (int) battleTable[this.getType()][p.getType()];
    int damage = dRange * bTable;
    p.takeDamage(damage);

    return this.getName() + "! Fire blast! " + p.getName() + " is warm and takes " + damage + " damage!";
  }

  @Override
  public String firePunch(Pokemon p) {
    int dRange = (int)( Math.random() * ((3 - 1) + 1) + 1) ;
    int bTable = (int) battleTable[this.getType()][p.getType()];
    int damage = dRange * bTable;
    p.takeDamage(damage);

    return this.getName() + "! Hot punch! " + p.getName() + " got spicy punched for " + damage + " damage!";
  }
}