public class Grass extends Pokemon{

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
        String out = "stood menacingly near";

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
        if (atkType == 2) {
            int damage;
            switch (move) {
                case 1:
                    damage = (int)( Math.random() * ((3 - 1) + 1) + 1) ;
                break;
            
                case 2:
                    damage = (int)( Math.random() * ((4 - 2) + 1) + 2) ;
                break;
        
                case 3:
                    damage = (int)( Math.random() * (5 + 1)) ;
                break;

                default:
                    damage = 1;
                break;
            }
            return damage;    
        }

        return super.getAttackDamage(atkType, move);
    }

    @Override
    public double getAttackMultiplier(Pokemon p, int atkType) {
        return super.getAttackMultiplier(p, atkType);
    }


}