public class HpDown extends PokemonDecorator{
    public HpDown(Pokemon p){
        super(p, "-Hp", (int)( Math.random() * ((-1 - 2) + 1) - 2));
    }
}
