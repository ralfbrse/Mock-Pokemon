public class Staryu extends Pokemon implements Water {

  public Staryu() {
    super("Staryu");
  }

  @Override
  public String waterGun(Pokemon p) {
    int dRange = (int)( Math.random() * ((5 - 1) + 1) + 1) ;
    int bTable = (int) battleTable[this.getType()][p.getType()];
    int damage = dRange * bTable;
    p.takeDamage(damage);

    return this.getName() + " sprays water at " + p.getName() + " dealing " + damage + " damage!";
  }

  @Override
  public String bubbleBeam(Pokemon p) {
    int dRange = (int)( Math.random() * ((2 - 1) + 1) + 1) ;
    int bTable = (int) battleTable[this.getType()][p.getType()];
    int damage = dRange * bTable;
    p.takeDamage(damage);

    return this.getName() + " shoots bubbles at " + p.getName() + " dealing " + damage + " damage!";
  }

  @Override
  public String waterfall(Pokemon p) {
    int dRange = (int)( Math.random() * ((4 - 1)  + 1) + 1);
    int bTable = (int) battleTable[this.getType()][p.getType()];
    int damage = dRange * bTable;
    p.takeDamage(damage);

    return this.getName() + " unleashed a waterfall on " + p.getName() + " dealing " + damage + " damage!";
  }

  @Override
  String getSpecialMenu() {
    return specialMenu;
  }

  @Override
  public int getNumSpecialMenuItems() {
    return numSpecialMenuItems;
  }

  @Override
  public String specialAttack(Pokemon p, int move) {
    String moveS = "";
    switch (move) {
      case 1:
        moveS = this.waterGun(p);
        break;
      case 2:
        moveS = this.bubbleBeam(p);
        break;
      case 3:
        moveS = this.waterfall(p);
        break;
      default:
        break;
    }
    return moveS;
  }
}