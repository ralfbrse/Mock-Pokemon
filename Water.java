public interface Water {
    public String specialMenu = "1. Water Gun\n2. Bubble Beam\n3. Waterfall";
    public int numSpecialMenuItems = 3;
    
    /**
     * Water gun move for water pokemon
     * @param p Pokemon being attacked
     * @return Action string
     */
    public String waterGun(Pokemon p);

    /**
     * Bubble beam move for water pokemon
     * @param p Pokemon being attacked
     * @return Action string
     */
    public String bubbleBeam(Pokemon p);

    /**
     * Waterfall move for water pokemon
     * @param p Pokemon being attacked
     * @return Action string
     */
    public String waterfall(Pokemon p);
}
