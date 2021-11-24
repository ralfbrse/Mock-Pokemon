public class Bulbasaur extends Pokemon implements Grass  {

  public Bulbasaur() {
    super("Bulbasaur");    
  }

  @Override
  public String getSpecialMenu() {
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
        moveS = this.vineWhip(p);
        break;
      
      case 2:
        moveS = this.razorLeaf(p);
        break;

      case 3:
        moveS = this.solarBeam(p);
        break;

      default:
        break;
    }
    return moveS;
  }
  
  
  @Override
  public String vineWhip(Pokemon p) {
    int dRange = (int)( Math.random() * ((3 - 1) + 1) + 1) ;
    int bTable = (int) battleTable[this.getType()][p.getType()];
    int damage = dRange * bTable;
    p.takeDamage(damage);

    return this.getName() + "! Watch em whip! " + p.getName() + " got nae naed for " + damage + " damage!";
  }

  @Override
  public String razorLeaf(Pokemon p) {
    int dRange = (int)( Math.random() * ((4 - 2) + 1) + 2) ;
    int bTable = (int) battleTable[this.getType()][p.getType()];
    int damage = dRange * bTable;
    p.takeDamage(damage);
    return this.getName() + " throws sharp leaf at " + p.getName() + ", dealing " + damage + " damage!";
  }

  @Override
  public String solarBeam(Pokemon p) {
    int dRange = (int)( Math.random() * (5 + 1)) ;
    int bTable = (int) battleTable[this.getType()][p.getType()];
    int damage = dRange * bTable;
    p.takeDamage(damage);
    return this.getName() + " shines light into " + p.getName() + "'s eyes for " + damage + " damage!";
  } 
}