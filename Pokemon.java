public abstract class Pokemon extends Entity{
    
  public static final double [][] battleTable = { {1,.5,2}, {2,1,.5}, {.5, 2, 1} };

  /**
   * Constructor. Default hp 20
   * @param n name of pokemon
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

  //FIXME
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

  ///////////////
  public String attack(Pokemon p, int atkType, int move) {
    double total;
    total = this.getAttackDamage(atkType, move) * this.getAttackMultiplier(p, atkType);
    p.takeDamage((int)Math.floor(total));
    return this.getAttackString(atkType, move);
  }

  public String getAttackString(int atkType, int move) {
    String out = "";

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
    int damage = (int)( Math.random() * ((10 - 2) + 1) + 2) ;
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


  //FIXME ?
  public int getType(){
      
    if(this instanceof Fire) return 0;
    else if(this instanceof Water) return 1;
    else if(this instanceof Grass) return 2;

    return 0;
      
  }




  
  /**
   * Displays menu of special attacks
   * @return Menu string
   */
  public String getSpecialMenu(){
    return null;

  }

  /**
   * @return number of special menu items
   */
  public int getNumSpecialMenuItems(){
    return 0;
    
  }

  /**
   * Executes attack and deals damage.
   * @param p pokemon to attack
   * @param move move to perform
   * @return action string
   */
  public String specialAttack(Pokemon p, int move){
    return null;
    
  }


  /**
   * 
   * @return Menu of basic attacks
   */
  public String getBasicMenu() {
    return ("1. Fight \n2. Use potion \n3. Throw pokeball \n4. Run away");
  }


  public int getNumBasicMenuItems() {
    
    return 4;
  }
  
  public String basicAttack(Pokemon p, int move) {
    if (move == 1) return this.slam(p);
    
    else if (move == 2) return this.tackle(p);
    
    else if (move == 3) return this.punch(p);
    
    else return null;
  }
  
  /**
   * Slam attack. Damage range 0-5. Deals damage in method
   * @param p pokemon to attack
   * @return action string
   */
  public String slam(Pokemon p) {
    int damage = (int)( Math.random() * ((5) + 1)) ;
    p.takeDamage(damage);

    return this.getName() + " slams "+ p.getName() + " for " + damage + " damage!";
      
  }

  /**
   * Tackle attack. Damage range 2-3. Deals damage in method
   * @param p pokemon to attack
   * @return action string
   */
  public String tackle(Pokemon p){
    int damage = (int)( Math.random() * ((3 - 2) + 1) + 2) ;
    p.takeDamage(damage);

    return this.getName() + " tackled "+ p.getName() + " for " + damage + " damage!";
  }

  /**
   * Punch attack. Damage range 1-4. Deals damage in method
   * @param p pokemon to attack
   * @return action string
   */
  public String punch(Pokemon p){
    int damage = (int)( Math.random() * ((4 - 1) + 1) + 1) ;
    p.takeDamage(damage);

    return this.getName() + " punched "+ p.getName() + " for " + damage + " damage!";
  }
}