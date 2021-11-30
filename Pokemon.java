public abstract class Pokemon extends Entity{
    
  public static final double [][] battleTable = { {1,.5,2}, {2,1,.5}, {.5, 2, 1} };

  /**
   * 
   * @param n Name
   * @param h Current health
   * @param m Max health
   */
  public Pokemon(String n, int h, int m) {
    super(n, h, m);
  }

  public String getAttackTypeMenu() {
    return "\n1. Basic \n2Special";
  }

  public int getNumAttackTypeMenuItems(){
    return 2;
  }

  public String getAttackMenu(int atkType) {
    return "\n1. Slam \n2. Tackle \n3. Punch";
  }

  /**
   * 
   * @return Number of attack menu items
   */
  public int getNumAttackMenuItems(int atkType) {
    return 3;
  }

  public String attack(Pokemon p, int atkType, int move) {
    double total;

    total = this.getAttackDamage(atkType, move) * this.getAttackMultiplier(p, atkType) + this.getAttackBonus(atkType);
    p.takeDamage((int)Math.floor(total));
    return this.getName() + " " + this.getAttackString(atkType, move) + " " + p.getName() + " for " + total + " damage!";
  }

  public String getAttackString(int atkType, int move) {
    String out = "stood menacingly near";

    if (atkType == 1) {
      switch (move) {
        case 1:
          out = "SLAMMED";
          break;

        case 2:
          out = "TACKLED";
          break;

        case 3:
          out = "PUNCHED";
          break;
      
        default:
          break;
      }
    }
    return out;
  }

  public int getAttackDamage(int atkType, int move) {
    int damage;

    switch (move) {
      case 1:
        damage = (int)( Math.random() * ((5 - 0) + 1) + 0) ;
        break;
    
      case 2:
        damage = (int)( Math.random() * ((3 - 2) + 1) + 2) ;
        break;

      case 3:
        damage = (int)( Math.random() * ((4 - 1) + 1) + 1) ;
        break;
      default:
        damage = 1;
        break;
    }    
    return damage;
  }

  public double getAttackMultiplier(Pokemon p, int atkType) {
    if (atkType == 2) {
      double multi = battleTable[this.getType()][p.getType()];
      return multi;
    }
    return 1;
  }

  public int getAttackBonus(int atkType) {
    return 0;
  }

  public int getType(){
    if(this instanceof Fire) return 0;
    else if(this instanceof Water) return 1;
    else if(this instanceof Grass) return 2;
    return 0;
  }

}