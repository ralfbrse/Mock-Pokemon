public abstract class Entity {
  private String name;
  private int hp;
  private int maxHp;

  /**
    * Entity object constructor
    * @param n Name
    * @param m Max hp
    */
  public Entity(String n, int h, int m){
    this.name = n;
    this.hp = h;
    this.maxHp = m;
  }

  /**
    * @return Current hp value
    */
  public int getHp(){
    return this.hp;
  }

  /**
    * @return Max hp value
    */
  public int getMaxHp(){
    return this.maxHp;
  }

  /**
    * Passes through integer and applies damage to take from hp
    * @param d Damage value
    */
  public void takeDamage(int d) {
    this.hp -= d;
    if (this.hp < 0) this.hp = 0;
  }

  /**
    * Hp takes the maxHp value
    */
  public void heal(){
    if (this.hp < this.maxHp){
        this.hp = this.maxHp;
      }
  }

  /**
    * @return Name
    */
  public String getName(){
    return this.name;
  }

  /**
    * Shows name and health values
    */
  @Override
  public String toString(){
    return this.getName() + " HP: " + this.getHp() + "/" + this.maxHp;
  }
}