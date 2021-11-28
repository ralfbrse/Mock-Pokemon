public abstract class PokemonDecorator extends Pokemon {
    private Pokemon pokemon;

    public PokemonDecorator(Pokemon p, String extraName, int extraHp){
        super(p.getName() + extraName, p.getHp()+extraHp, p.getMaxHp()+extraHp );
        pokemon = p;
    }
    

    public String getAttackMenu(int atkType) {
        return "\n1. Slam \n2. Tackle \n3. Punch";
        }

    public String getNumAttackMenuItems(){
        return null;
        
    }


    public String getAttackString(int atkType, int move) {
        return null;
        
    }

    public int getAttackDamage(int atkType, int move) {
        return move;

    }
}
