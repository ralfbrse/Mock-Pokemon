import java.awt.Point;
import java.util.ArrayList;

public class Trainer extends Entity {

  private int money;
  private int potions;
  private int pokeballs;
  private Point loc;
  private ArrayList<Pokemon> pokemon = new ArrayList<Pokemon>();

  /**
   * Trainer constructor
   * @param n name
   * @param p pokemon
   * @param m map
   */
  public Trainer(String n, Pokemon p) {
    super(n, 25, 25); //FIXME
    this.pokemon.add(p);
    //this.loc = map.findStart();
    this.money = 25;
    this.potions = 1;
    this.pokeballs = 5;
  }

  /**
   * @returns current amount of money
   */
  public int getMoney() {
    return this.money;
  }

  /**
   * @param amt amount
   * @return true if you can spend money, false otherwise
   */
  public boolean spendMoney(int amt) {
    if(this.money >= amt) {
      this.money -= amt;
      return true;
    }
    return false;
  }

  /**
   * adds amount to the total money
   * @param amt amount
   */
  public void receiveMoney(int amt) {
    this.money += amt;
  }

  /**
   * @return true if there are potion, false otherwise
   */
  public boolean hasPotion() {
    if(this.potions > 0) {
      return true;
    }
    return false;
  }

  /**
   * add to the number of potion owned
   */
  public void receivePotion() {
    this.potions += 1;
  }

  /**
   * heals the pokemon in the slot, if applicable
   * @param pokeIndex the pokemon in that slot
   */
  public void usePotion(int pokeIndex) {
    if(this.hasPotion()) {
      this.potions -= 1;
      pokemon.get(pokeIndex).heal();
    }
  }

  /**
   * @return true if there are pokeballs, false otherwise
   */
  public boolean hasPokeball() {
    if(this.pokeballs <= 0) {
      return false;
    }
    return true;
  }

  /**
   * add to the number of potion owned
   */
  public void receivePokeball() {
    this.pokeballs += 1;
  }

  /**
   * a chance to catch the pokemon if we have pokeballs
   * health above 64 is 75%, between 64 and 34 is 25%, anything less is 10)% 
   * @param p pokemon
   * @return true if we can catch pokemon, false otherwise
   */
  public boolean catchPokemon(Pokemon p) { //FIXME
    if(this.hasPokeball()) {
      this.pokeballs -= 1;
      double healthPercent = 100 - 100*(p.getHp()/p.getMaxHp());
      int random = (int)Math.random()*3;
      if((int)healthPercent >= 65 && random == 1) {
        pokemon.add(p);
        return true;
      }
      else if((int)healthPercent >= 35 && (random == 1 || random == 2 || random == 3)) {
        pokemon.add(p);
        return true;
      }
      else if((int)healthPercent > 0) {
        pokemon.add(p);
        return true;
      }
    }
    return false;
  }

  /**
   * @return location
   */
  public Point getLocation() {
    return this.loc;
  }

  //FIXME x4
  /**
   * @return the character north of location if applicable
   */
  public char goNorth() {
    double x = this.getLocation().getX();
    double y = this.getLocation().getY();
    map.reveal(loc);
    if((x - 1.0) >= 0.0) {
      loc.setLocation(x-1 , y);
      return map.getCharAtLoc(this.getLocation());
    } else {
      System.out.println("\nCan't go that way!");
    }
    return map.getCharAtLoc(this.getLocation());
  }

  /**
   * @return the character south of location if applicable
   */
  public char goSouth() {
    double x = this.getLocation().getX();
    double y = this.getLocation().getY();
    map.reveal(loc);
    if((x + 1.0) <= 4.0) {
      loc.setLocation(x+ 1, y);
      return map.getCharAtLoc(this.getLocation());
    } else {
      System.out.println("\nCan't go that way!");
    }
    return map.getCharAtLoc(this.getLocation());
  }

  /**
   * @return the character east of location if applicable
   */
  public char goEast() {
    double x = this.getLocation().getX();
    double y = this.getLocation().getY();
    map.reveal(loc);
    if((y + 1.0) <= 4.0) {
      loc.setLocation( x, y + 1.0);
      return map.getCharAtLoc(this.getLocation());
    } else {
      System.out.println("\nCan't go that way!");
    }
    return map.getCharAtLoc(this.getLocation());
  }

  /**
   * @return the character west of location if applicable
   */
  public char goWest() {
    double x = this.getLocation().getX();
    double y = this.getLocation().getY();
    map.reveal(loc);
    if((y - 1.0) >= 0.0) {
      loc.setLocation(x, y - 1);
      return map.getCharAtLoc(this.getLocation());
    } else {
      System.out.println("\nCan't go that way!");
    }
    return map.getCharAtLoc(this.getLocation());
  }

  /**
   * @return the number of pokemon in the party
   */
  public int getNumPokemon() {
    return this.pokemon.size();
  }

  /**
   * heals all pokemon
   */
  public void healAllPokemon() {
    for(int i = 0; i < pokemon.size(); i++) {
      this.pokemon.get(i).heal();
    }
  }


  public void buffAllPokemon() {
    //FIXME
  }

  public void debuffPokemon(int index) {
    //FIXME
  }

  /**
   * @param index pokemon slot
   * @return the pokemon at the index
   */
  public Pokemon getPokemon(int index) {
    return this.pokemon.get(index);
  }

  /** //FIXME
   * @return the list of pokemon that you own
   */
  public String getPokemonList() {
    String list = "Pokemon\n-------";
    String list2 = "";
    int number = 1;
    for(int i = 0; i < pokemon.size(); i++) {
      list2 = list2 + "\n" + number + ". " + pokemon.get(i).getName() + " HP: " + pokemon.get(i).getHp() + "/" + pokemon.get(i).getMaxHp();
      number++;
    }
    return list + list2;
  }

  public Pokemon removePokemon(int index) {
    this.pokemon.remove(index);
    return null;
  } //FIXME

  /**
   * @return the trainer info
   */
  @Override //FIXME Types?
  public String toString() {
    return super.toString() + "\nMoney: " + this.getMoney() + "\nPotions: " + this.potions + "\nPoke Balls: " + this.pokeballs + "\n" + this.getPokemonList();
  }
}