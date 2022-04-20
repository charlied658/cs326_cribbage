package edu.skidmore.cs326.spring2022.skribbage.gamification;

import java.util.ArrayList;

/**
 * @author jaroderatsimbazafy.
 *         Wallet class.
 *         Token manager for individual player
 */
public class TokenManager implements Manager {

    /**
     * ArrayList of to simulate a wallet.
     */
    private ArrayList<Token> tokens;

    /**
     * Constructor.
     *
     * @param initialAmount
     *            the amount of  in wallet at instantiation
     */
    public TokenManager(int initialAmount) {
        for (int i = 0; i < initialAmount; i++) {
            tokens.add(new Token());
        }
    }

    /**
     * add to wallet.
     *
     * @param amount
     *            The amount to add to the wallet
     */
    public void addToken(int amount) {

        for (int i = 0; i < amount; i++) {
            tokens.add(new Token());
        }
    }

    /**
     * remove from wallet.
     *
     * @param amount
     *            The amount to remove from the wallet
     */
    public void removeToken(int amount) {

        for (int i = 0; i < amount; i++) {
            tokens.remove(0);
        }
    }

    /**
     * get the number of in the wallet.
     *
     * @return the number of in the wallet(size of the ArrayList)
     */
    public int getAmount() {
        return tokens.size();
    }

}
