public abstract class Pokemon extends Entity{
    
  public static final double [][] battleTable = { {1,.5,2}, {2,1,.5}, {.5, 2, 1} };

  /**
   * Constructor. Default hp 20
   * @param n name of pokemon
   */
  public Pokemon(String n, int h, int m) {
    super(n, h, m);
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

  public String getAttackTypeMenu() {
    return "\n1. Basic \n2Special";
    }

  public int getNumAttackTypeMenuItems(){
    return 2;
  }

  //FIXME
  public String getAttackMenu(int atkType) {
    if (atkType == 1) return "\n1. Slam \n2. Tackle \n3. Punch";
    if (atkType == 2) return "FIXME BRUH";
    return "bruh";
  }
  


  /**
   * 
   * @return Number of attack menu items
   */
  public int getNumAttackMenuItems(int atkType) {
    return 3;
      
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