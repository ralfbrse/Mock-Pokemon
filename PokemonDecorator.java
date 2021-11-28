public abstract class PokemonDecorator extends Pokemon {
    private Pokemon pokemon;

    public PokemonDecorator(Pokemon p, String extraName, int extraHp){
        super(p.getName(), p.getHp()+extraHp, p.getMaxHp()+extraHp );
        

    }

    
    public String getAttackMenu(int atkType) {
        if (atkType == 1) return "\n1. Slam \n2. Tackle \n3. Punch";
        if (atkType == 2) return "FIXME BRUH";
        return "bruh";
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
