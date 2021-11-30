public class Fire extends Pokemon {

  public Fire(String n, int h, int m) {
    super(n, h, m);
  }

  @Override
  public String getAttackMenu(int atkType) {
    if(atkType == 2) {
      return "1. Ember \n2. Fire Blast \n3. Fire Punch";
    }
    return super.getAttackMenu(atkType);
  }

  @Override
  public int getNumAttackMenuItems(int atkType) {
    if(atkType == 2) {
      return 3;
    }
    return super.getNumAttackMenuItems(atkType);
  }

  @Override
  public String getAttackString(int atkType, int move) {
    String out = "";
      if (atkType == 2) {
        switch (move) {
          case 1:
            out = "BURNED"; //ember
            break;
          case 2:
            out = "BLASTED"; //fire Blast
            break;
          case 3: 
            out = "PUNCHED"; //fire punch
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
    int out = 0;
    if(atkType == 2) {
      switch(move) {
        case 1:
          out = (int)( Math.random() * ((3 - 0)+1) +0); //ember
          break;
        case 2:
          out = (int)( Math.random() * ((4 - 1)  + 1) + 1); //fire Blast
          break;
        case 3: 
          out = (int)( Math.random() * ((3 - 1) + 1) + 1) ; //fire punch
          break;
        default:
          break;
        }
        return out;
      }
    return super.getAttackDamage(atkType, move);
  }

  @Override
  public double getAttackMultiplier(Pokemon p, int atkType) {
    if(atkType == 2) {
      return battleTable[this.getType()][p.getType()];
    }
    return super.getAttackMultiplier(p, atkType);
  }
}