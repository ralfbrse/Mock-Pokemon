import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class PokemonGenerator {
    private HashMap<String, String> pokemon = new HashMap<String, String>();
    private static PokemonGenerator instance = null;

    public PokemonGenerator(){
        //constructor should read from the file into a
        //HashMap to store the different pokémon names and their associated
        //elemental type.

        try (Scanner read = new Scanner(new File("PokemonList.txt"))) {
            while (read.hasNextLine()) {
                String line = read.nextLine();
                String[] data = line.split(",");
                String e = data[0];
                String e2 = data[1];
                pokemon.put(e,e2);
            }
            read.close();
        }
        catch (FileNotFoundException fnf) {
            System.out.println("file not found");
        }
    }

    public static PokemonGenerator getInstance(){
        if (instance == null){
            instance = new PokemonGenerator();
        }
        return instance;
    }

    public Pokemon generateRandomPokemon(int level){
        // generateRandomPokemon should randomly pick a pokémon from the HashMap,
        // Construct a pokémon of the corresponding elemental base type.
        // Then for each level greater than one, repeatedly decorate it with a random buff
        // (ex. a level 3 pokémon might be a Fire pokémon decorated with +ATK and +HP),
        // this will cause the constructed pokémon to gain an additional title, increase
        // its hp and maxHp, and/or do additional damage
        
        Random random = new Random();
        String[] pokemonSet = pokemon.keySet().toArray(new String[0]);
        String randomPokemonStr = pokemonSet[random.nextInt(pokemon.size())];
        Pokemon randPoke = this.getPokemon(randomPokemonStr);

        if (level > 1){
            level -= 1;
            while (level > 0){
                this.addRandomBuff(randPoke);
                level -= 1;
            }
        }
        
        return randPoke;
    }

    public Pokemon getPokemon(String name){
        //getPokemon passes in a string with the name of a pokémon and
        //constructs an object of the correct corresponding type.
        Pokemon p = null; //FIXME
        switch (pokemon.get(name)) {
            case "Grass":
                p = new Grass(name, 0, 0);
                break;
            case "Fire":
                p = new Fire(name, 0, 0);
                break;

            case "Water":
                p = new Water(name, 0, 0);
                break;
        
            default:
                break;
        }

        return p;
    }
    public Pokemon addRandomBuff(Pokemon p){
        Pokemon bruh = new AttackUp(p);
        return bruh;
        // addRandomBuff/Debuff randomly chooses a buff/debuff to apply
        //to the pokémon (note: this should not reset the pokémon’s hp (ex.
        //if the pokémon’s hp was 14/20, then after being buffed with the
        //+HP it should be 15/21).

    }
    public Pokemon addRandomDebuff(Pokemon p){
        return p;

    }
}
