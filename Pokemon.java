public abstract class Pokemon extends Entity{
    
  public static final double [][] battleTable = { {1,.5,2}, {2,1,.5}, {.5, 2, 1} };

  /**
   * Constructor. Default hp 20
   * @param n name of pokemon
   */
  public Pokemon(String n) {
    super(n, 20);
  }

  /**
   * Displays menu of special attacks
   * @return Menu string
   */
  abstract String getSpecialMenu();

  /**
   * @return number of special menu items
   */
  abstract int getNumSpecialMenuItems();

  /**
   * Executes attack and deals damage.
   * @param p pokemon to attack
   * @param move move to perform
   * @return action string
   */
  abstract String specialAttack(Pokemon p, int move);


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

  public String getAttackTypeMenu() {
    return "\n1. Basic \n2Special";
    }

  public String getNumAttackTypeMenuItems(){
    return 2;
  }

  public String getAttackMenu() {
    String out = "\n1. Slam \n2. Tackle \n3. Punch";
    return out;
  }

  /**
   * 
   * @return Number of attack menu items
   */
  public int getNumAttackMenuItems() {
    return 3;
      
  }

  /**
   * Slam attack. Damage range 0-5. Deals damage in method
   * @param p pokemon to attack
   * @return action string
   */
  public String slam(Pokemon p) {
    int damage = (int)( Math.random() * ((5 - 0) + 1) + 0) ;
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

  /**
   * Check elemental type of pokemon for (dis)advantage on attacks
   * @return pokemon type int
   */
  public int getType(){
      
    if(this instanceof Fire) return 0;
    else if(this instanceof Water) return 1;
    else if(this instanceof Grass) return 2;

    return 0;
      
  }

}