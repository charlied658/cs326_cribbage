package edu.skidmore.cs326.spring2022.skribbage.gamification;

/**
 * Interface for the Wallet class.
 * 
 * @author jratsimb
 */
public interface Manager {

    /**
     * Method to add token.
     * 
     * @param amount
     *            number of token to add.
     */
    void addToken(int amount);

    /**
     * Method to remove token.
     * 
     * @param amount
     */
    void removeToken(int amount);

    /**
     * return the number of token.
     * 
     * @return amount of token
     */
    int getAmount();
}
