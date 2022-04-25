package edu.skidmore.cs326.spring2022.skribbage.logic;

/**
 * @author lappiaha
 */
public class PlayerManager {

    /**
     * player object to utilize player class.
     */
    @SuppressWarnings("unused")
    private Player p;

    /**
     * method to add player points.
     * 
     * @param p
     * @param pointsToAdd
     */
    public void addPoints(Player p, int pointsToAdd) {
        pointsToAdd += p.getPoints();
    }

    /**
     * method to subtract player points.
     * 
     * @param p
     * @param pointsToSubtract
     */
    public void subtractPointsFromPlayer(Player p, int pointsToSubtract) {
        pointsToSubtract -= p.getPoints();
    }

    /**
     * method to set player points.
     * 
     * @param p
     */
    @SuppressWarnings("unused")
    public void setPlayerPoints(Player p) {
        int playerpoints = p.getPoints();
    }

}
