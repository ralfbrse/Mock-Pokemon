import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
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
        //generateRandomPokemon should randomly pick a pokémon from
        //the HashMap, and then construct a pokémon of the corresponding
        //elemental base type. Then for each level greater than one,
        //repeatedly decorate it with a random buff (ex. a level 3 pokémon
        //might be a Fire pokémon decorated with +ATK and +HP), this will
        //cause the constructed pokémon to gain an additional title, increase
        //its hp and maxHp, and/or do additional damage

        int range = (int)( Math.random() * pokemon.size());
        return null;
    }
    public Pokemon getPokemon(String name){
        //getPokemon passes in a string with the name of a pokémon and
        //constructs an object of the correct corresponding type.
        pokemon.get(name);
        return null;
    }
    public Pokemon addRandomBuff(Pokemon p){
        return p;
        // addRandomBuff/Debuff randomly chooses a buff/debuff to apply
        //to the pokémon (note: this should not reset the pokémon’s hp (ex.
        //if the pokémon’s hp was 14/20, then after being buffed with the
        //+HP it should be 15/21).

    }
    public Pokemon addRandomDebuff(Pokemon p){
        return p;

    }
}
