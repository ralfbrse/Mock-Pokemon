public class Grass extends Pokemon{

    //public String specialMenu = "1. Vine Whip\n2. Razor Leaf\n3. Solar Beam";
    //public int numSpecialMenuItems = 3;

    public Grass(String n, int h, int m) {
        super(n, h, m);
    }

    @Override
    public String getAttackMenu(int atkType) {
        return (atkType == 2) ? "1. Vine Whip\n2. Razor Leaf\n3. Solar Beam" : super.getAttackMenu(atkType);
    }

    @Override
    public int getNumAttackMenuItems(int atkType) {
        // TODO Auto-generated method stub
        return super.getNumAttackMenuItems(atkType);
    }

    @Override
    public String getAttackString(int atkType, int move) {
        // TODO Auto-generated method stub
        return super.getAttackString(atkType, move);
    }


    @Override
    public int getAttackDamage(int atkType, int move) {
        // TODO Auto-generated method stub
        return super.getAttackDamage(atkType, move);
    }

    
    @Override
    public int getAttackMultiplier(Pokemon p, int atkType) {
        // TODO Auto-generated method stub
        return super.getAttackMultiplier(p, atkType);
    }


}