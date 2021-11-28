public class AttackDown extends PokemonDecorator{
    public AttackDown(Pokemon p){
        super(p, "-ATK", (int)( Math.random() * ((-1 - 2) + 1) - 2));

    }
    public int getAttackBonus(int type){
        return type;
    }
}