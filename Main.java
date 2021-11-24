/**
 * @author: Michael Lav
 * @author: Raphael Burce
 * @author: Seung Baik
 * @date: 10/24/2021
 * 
 * Pokemon project 1: A text game version of the game Pokemon.
 */

import java.util.Scanner;
import java.awt.Point;
public class Main {

  public static void main(String[] args) {
    Trainer trainer;
    Pokemon pokemon = new Squirtle();
    Map map = new Map();
    int currMap = 1;
    map.loadMap(currMap);
    boolean inNav = true;
    char tile = 'n';
    int direction;

    System.out.println("Prof. Oak: Hello there new trainer, what is your name?");
    String name = CheckInput.getString();
    System.out.println("\n" + "Great to meet you " + name + ". Choose your first pokemon:\n1. Charmander\n2. Bulbasaur\n3. Squirtle");
    int choice = CheckInput.getIntRange(1,3);
      
    if(choice == 1){
      pokemon = new Charmander();
      trainer = new Trainer(name, pokemon, map);
      System.out.println("\n" + trainer + "\n");
    }
    else if(choice == 2){
      pokemon = new Bulbasaur();
      trainer = new Trainer(name, pokemon, map);
      System.out.println("\n" + trainer + "\n");
    } 
    else{
      trainer = new Trainer(name, pokemon, map);
      System.out.println("\n" + trainer + "\n");
    }
    
    System.out.println(map.mapToString(trainer.getLocation()));
    while(inNav) {
      int originalAmount = trainer.getNumPokemon();
      direction = mainMenu();
      if (direction == 1) tile = trainer.goNorth();
      else if (direction == 2) tile = trainer.goSouth();
      else if (direction == 3) tile = trainer.goEast();
      else if (direction == 4) tile = trainer.goWest();
      else if(direction == 5){
         inNav = false;
         break;
        }

      if(tile == 'w'){
        Pokemon opponent = chooseRandomPokemon();
        trainerAttack(trainer, opponent);
        if (opponent.getHp() <= 0){
          map.removeCharAtLoc(trainer.getLocation());
        }
        if (trainer.getNumPokemon() == originalAmount + 1){
          map.removeCharAtLoc(trainer.getLocation());
        }
        if(opponent.getHp() > 0 && (trainer.getNumPokemon() != originalAmount + 1)) {
          boolean reroll = true;

          while(reroll){

            int rDirection = (int)( Math.random() * ((4 - 1) + 1) + 1);

            if( (rDirection == 1) && (trainer.getLocation().getY() <4) ){
              trainer.goEast();
              reroll = false;
            }
            else if( (rDirection == 2) && (trainer.getLocation().getX() > 0) ){
              trainer.goNorth();
              reroll = false;
            }
            else if((rDirection == 3) && (trainer.getLocation().getX() <4)){
              trainer.goSouth();
              reroll = false;
            }
            else if((rDirection == 4)  && (trainer.getLocation().getY() > 0) ){
              trainer.goWest();
              reroll = false;
            }
          }
        }
        System.out.println("\n" + trainer + "\n");
      }

      if(tile == 'c'){
        store(trainer);
        System.out.println("\n" + trainer + "\n");
      }

      if(tile == 'f'){
        int next = currMap + 1;
        currMap = next;
        if (next == 4) next = 1;
        System.out.println("\nYou have found the finish!");
        System.out.println("\n" + trainer + "\n");
        map.loadMap(next);
      }

      if(tile == 'i'){
        int random = (int)( Math.random() * ((2 - 1) + 1) + 1);
        switch(random){
            case 1:
                trainer.receivePotion();
                System.out.println("\nYou found one potion!");
                break;
            case 2:
                trainer.receivePokeball();
                System.out.println("\nYou found one pokeball!");
                break;
          }
          map.removeCharAtLoc(trainer.getLocation());
          System.out.println("\n" + trainer + "\n");
      }
      
      if(tile == 'p'){
        System.out.println("\nYou meet Trainer Patches");
        System.out.println("He brings his hands over to you and gives you...");
        int random = (int)( Math.random() * ((4 - 1) + 1) + 1);
        switch(random){
            case 1:
                trainer.receivePotion();
                System.out.println("A potion! He says goodbye and leaves.");
                break;
            case 2:
                trainer.receivePokeball();
                System.out.println("A pokeball! He says goodbye and leaves.");
                break;
            case 3:
                trainer.receiveMoney(10);
                System.out.println("Money! He says goodbye and leaves.");
                break;
            case 4:
                trainer.takeDamage(5);
                System.out.println("A knucklesandwich and runs away.");
                break;
        }
        map.removeCharAtLoc(trainer.getLocation());
        System.out.println("\n" + trainer + "\n");
      }
      if(tile == 'n') {
        System.out.println("\nThere's nothing here...");
        System.out.println("\n" + trainer + "\n");
      }
      System.out.println(map.mapToString(trainer.getLocation()));
    }
    System.out.println("\nGame over...");
  }

  /**
   * Displays main menu and asks for input
   * @return Integer option
   */
  public static int mainMenu() {
    System.out.println("1. Go North");
    System.out.println("2. Go South");
    System.out.println("3. Go East");
    System.out.println("4. Go West");
    System.out.println("5. Quit");
    return CheckInput.getIntRange(1,5);
  }

  /**
   * Makes new random pokemon
   * @return Random Pokemon
   */
  public static Pokemon chooseRandomPokemon() {
    int randNum = (int)( Math.random() * ((6 - 1) + 1) + 1);
    Pokemon random = null;
    switch(randNum) {
      case 1: random = new Charmander();
      break;
      case 2: random = new Squirtle();
      break;
      case 3: random = new Bulbasaur();
      break;
      case 4: random = new Ponyta();
      break;
      case 5: random = new Staryu();
      break;
      case 6: random = new Oddish();
    }
    return random;
  }

  /**
   * Combat for player vs wild pokemon
   * @param t trainer (you)
   * @param wild Wild pokemon
   */
  public static void trainerAttack(Trainer t, Pokemon wild){
    boolean caught = false;
    boolean inBattle = true;
    int pChoice = 0;
    int option = 0;
    int dead;
    System.out.println("\nWatch out! A wild "+ wild.getName() + "!");
    while (inBattle){
      System.out.println(wild.toString());
      System.out.println("\nWhat will you do?");
      System.out.println( "1. Fight \n2. Use potion \n3. Throw pokeball \n4. Run away");
      option = CheckInput.getIntRange(1, 4);
      switch (option) {
        case 1:
          pChoice = 0;
          System.out.println("\nChoose a pokemon");
          System.out.println( t.getPokemonList() );
          pChoice = CheckInput.getIntRange(1, t.getNumPokemon());
          pChoice -= 1;
          Pokemon fighter = t.getPokemon(pChoice);
          if( fighter.getHp() <= 0){
            System.out.println("\nThis pokemon is dead lmao.");
            int randDamage = (int)( Math.random() * ((3 - 1) + 1) + 1);
            System.out.println("\nThe wild "+ wild.getName() + " attacked you for "+ randDamage + " damage!");
            t.takeDamage(randDamage);
            break;
          }
          System.out.println("\n" + fighter.getName() + ", I choose you!");
          System.out.println("1. Basic attack");
          System.out.println("2. Special attack");
          option = CheckInput.getIntRange(1, 2);
          if(option == 1){
            System.out.println( "\n1. Slam \n2. Tackle \n3. Punch");
            option = CheckInput.getIntRange(1, 3);
            if (option == 1){
              System.out.println( "\n" + fighter.slam(wild));
            }
            else if (option == 2){
              System.out.println( "\n" + fighter.tackle(wild));
            }
            else if (option == 3){
              System.out.println( "\n" + fighter.punch(wild));
            }
          }
          else if(option == 2){
            System.out.println( "\n" + fighter.getSpecialMenu() );
            option = CheckInput.getIntRange(1, fighter.getNumSpecialMenuItems());
            System.out.println("\n" + fighter.specialAttack(wild, option));
          } 
          if(wild.getHp() >= 1){
            int randOption = (int)( Math.random() * ((2 - 1) + 1) + 1);

            if(randOption == 1){
              option = (int)( Math.random() * ((3 - 1) + 1) + 1); 
              if (option == 1){
                System.out.println( wild.slam(fighter) + "\n");
              }
              else if (option == 2){
                System.out.println( wild.tackle(fighter) + "\n");
              }
              else if (option == 3){
                System.out.println( wild.punch(fighter) + "\n");
              }
            }
            else if(randOption == 2){
              option = (int)( Math.random() * ((wild.getNumSpecialMenuItems() - 1) + 1) + 1);
              System.out.println(wild.specialAttack(fighter, option) + "\n");
            }
            if(fighter.getHp() == 0) System.out.println(fighter.getName() + " fainted!");
          }
          break;
        case 2:
          if(t.hasPotion()){
            pChoice = 0;
            System.out.println("\nChoose a Pokemon to heal");
            System.out.println(t.getPokemonList());
            pChoice = CheckInput.getIntRange(1, t.getNumPokemon());
            pChoice -= 1;
            t.usePotion(pChoice);
          }
          else System.out.println("\nYou have no potions!");
          break;
        case 3:
          if(!t.hasPokeball()){
            System.out.println("\nYou have no balls.");
          }
          else if (t.hasPokeball()){
            System.out.println("\nYou threw a pokeball!");
            
            if(t.catchPokemon(wild)){
              System.out.println("\nYou did it! You got a " + wild.getName());
              caught = true;
              break;
            } else{
              System.out.println("\nBig oof it broke free...");
            }
          }
          break;
        case 4:
          inBattle = false;
          System.out.println("\nYou ran...");
          break;
        default:
          break;
      }

      dead = 0;
      for (int i = 0; i < t.getNumPokemon(); i++) {
        if(t.getPokemon(i).getHp() == 0){
          dead += 1;
        }
      }
      if(dead == t.getNumPokemon()){
        int randDamage = (int)( Math.random() * ((3 - 1) + 1) + 1);
        System.out.println("The wild "+ wild.getName() + " attacked you for "+ randDamage + " damage and ran!");
        inBattle = false;
        break;
      }

      if(wild.getHp() <= 0 || caught) {
        System.out.println("\nYou won the battle!");
        inBattle = false;
      } 
    }
  }

  /**
   * Introduces PokeStore and hospital for healing
   * @param T Trainer (you)
   */
  public static void store(Trainer T){
    System.out.println("\nYou've entered the city.");
    System.out.println("\nWhere would you like to go?");
    System.out.println("1. Store");
    System.out.println("2. Pokemon Hospital");
    int place = CheckInput.getIntRange(1,2);

    switch (place){
      case 1:
        System.out.println("\nHello! What can I help you with?");
        System.out.println("1. Buy Potions - $5");
        System.out.println("2. Buy Poke Balls - $3");
        System.out.println("3. Exit");
        int input = CheckInput.getIntRange(1,3);
        while(input != 3){
          if(input == 1){
          if(T.spendMoney(5)) {
          System.out.println("\nHere's your potion.");
          T.receivePotion();
          System.out.println("\nAnything else?");
          System.out.println("1. Buy Potions - $5");
          System.out.println("2. Buy Poke Balls - $3");
          System.out.println("3. Exit");
          input = CheckInput.getIntRange(1,3);
        } else {
          System.out.println("\nNot enough money.");
          break;
        }
      }
      if(input == 2){
        if(T.spendMoney(3)) {
          System.out.println("\nHere's your pokeball.");
          T.receivePokeball();
          System.out.println("\nAnything else?");
          System.out.println("1. Buy Potions - $5");
          System.out.println("2. Buy Poke Balls - $3");
          System.out.println("3. Exit");
          input = CheckInput.getIntRange(1,3);
        } else {
          System.out.println("\nNot enough money.");
          break;
        }
      }
    }
        if(input == 3) {
      System.out.println("\nThank you, come again soon");
    }
        break;
      case 2:
        System.out.println("\nHello! Welcome to the Pokemon Hospital.");
        System.out.println("I'll fix your pokemon up in a jiffy!");
        System.out.println("There you go! See you again soon.");
        T.heal();
        T.healAllPokemon();
        break;
    }
  }
}