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
        return (atkType == 2) ? 3 : super.getNumAttackMenuItems(atkType);
    }

    @Override
    public String getAttackString(int atkType, int move) {
        String out = "";

        if (atkType == 2) {
            switch (move) {
                case 1:
                    out = "WHIPPED"; //Vine whip
                    break;
                case 2:
                    out = "CUT"; //Razor leaf
                    break;
                case 3: 
                    out = "SUN DRIED LIKE A TOMATO LMAO"; //Solar beam
                    break;
                default:
                    break;
            }
            return out;
        }
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