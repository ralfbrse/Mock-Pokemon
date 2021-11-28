public abstract class PokemonDecorator {
    private Pokemon pokemon;

    public PokemonDecorator(Pokemon p, String extraName, int extraHp) {

    }

    public String getAttackMenu(int atkType) {
        return null;

    }

    public int getAttackDamage(int atkType, int move) {
        return move;

    }
}
