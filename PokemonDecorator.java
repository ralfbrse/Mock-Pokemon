public abstract class PokemonDecorator extends Pokemon {
    private Pokemon pokemon;

    public PokemonDecorator(Pokemon p, String extraName, int extraHp){
        super(p.getName() + extraName, p.getHp()+extraHp, p.getMaxHp()+extraHp );
        
    }
    

    public String getAttackMenu(int atkType) {
        if (atkType == 1) return "\n1. Slam \n2. Tackle \n3. Punch";
        else if (atkType == 2) return "FIXME BRUH";
        else return "";
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
