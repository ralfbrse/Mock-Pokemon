public interface Fire {
    
    
    public String specialMenu = "1. Ember \n2. Fire Blast \n3. Fire Punch";
    public int numSpecialMenuItems = 3;

    /**
     * Ember move for fire pokemon
     * @param p Pokemon being attacked
     * @return Action string
     */
    public String ember(Pokemon p);
    /**
     * Fire blast move for fire pokemon
     * @param p Pokemon being attacked
     * @return Action string
     */
    public String fireBlast(Pokemon p);
    /**
     * Fire punch move for fire pokemon
     * @param p Pokemon being attacked
     * @return Action string
     */
    public String firePunch(Pokemon p);
}