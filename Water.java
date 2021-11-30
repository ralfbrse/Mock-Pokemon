public class Water extends Pokemon{

    //public String specialMenu = "1. Vine Whip\n2. Razor Leaf\n3. Solar Beam";
    //public int numSpecialMenuItems = 3;

    public Water(String n, int h, int m) {
        super(n, h, m);
    }

    @Override
    public String getAttackMenu(int atkType) {
        return (atkType == 2) ? "1. Water Gun\n2. Bubble Beam\n3. Waterfall" : super.getAttackMenu(atkType);
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
                    out = "Splashed"; //Water Gun
                    break;
                case 2:
                    out = "Shot"; //Bubble Beam
                    break;
                case 3: 
                    out = "Crushed"; //Waterfall
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
    public double getAttackMultiplier(Pokemon p, int atkType) {
        // TODO Auto-generated method stub
        return super.getAttackMultiplier(p, atkType);
    }

}