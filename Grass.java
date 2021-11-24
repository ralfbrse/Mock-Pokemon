public interface Grass {

    public String specialMenu = "1. Vine Whip\n2. Razor Leaf\n3. Solar Beam";
    public int numSpecialMenuItems = 3;

    /**
     * Vine whip move for grass pokemon
     * @param p Pokemon being attacked
     * @return Action string
     */
    public String vineWhip(Pokemon p);

    /**
     * Razor leaf move for grass pokemon
     * @param p Pokemon being attacked
     * @return Action string
     */
    public String razorLeaf(Pokemon p);

    /**
     * Solar beam move for grass pokemon
     * @param p Pokemon being attacked
     * @return Action string
     */
    public String solarBeam(Pokemon p);

}