public class AttackUp extends PokemonDecorator {
    public AttackUp(Pokemon p){
        super(p, "+ATK", (int)( Math.random() * ((2 - 1) + 1) + 1));
    }

    public int getAttackBonus(int type){
        return type;
    }
}

    // Trainers can buff their pokémon by using potions
    //(full heal plus a random buff on the chosen pokémon), or by reaching the next
    //level (after the gym leader is defeated, all pokémon in the Trainer’s ArrayList get
    //buffed).
    //Pokemon will be debuffed randomly during fights (25% chance a
    //trainer’s Pokemon will debuff an enemy pokémon, and a 10% chance an enemy
    //pokémon will debuff the trainer’s pokémon).

    // Buffs: AttackUp – increases a pokémon’s damage by 1-2 and adds ‘+ATK’ to their name.
    // HpUp – increases a pokémon’s hp and maxHp by 1-2 and adds ‘+HP’ to their name.

    // Debuffs: AttackDown – decreases the pokémon’s damage by 1 and adds a ‘-ATK’ to their name.
    // HpDown – decreases a pokémon’s hp and maxHp by 1 and adds ‘-HP’ to their name