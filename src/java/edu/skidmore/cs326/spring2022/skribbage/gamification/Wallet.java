package edu.skidmore.cs326.spring2022.skribbage.gamification;

import java.util.ArrayList;

/**
 * @author jaroderatsimbazafy.
 * Wallet class.
 * Token manager for individual player
 */
public class Wallet {

    /**
     * ArrayList of tokens to simulate a wallet.
     */
    private ArrayList<Token> Tokens;

    /**
     * Constructor.
     *
     * @param initialAmount
     *            the amount of tokens in wallet at instantiation
     */
    public Wallet(int initialAmount) {
        for (int i = 0; i < initialAmount; i++) {
            Tokens.add(new Token());
        }
    }

    /**
     * add tokens to wallet.
     *
     * @param amount
     *            The amount to add to the wallet
     */
    public void addToken(int amount) {

        for (int i = 0; i < amount; i++) {
            Tokens.add(new Token());
        }
    }

    /**
     * remove tokens from wallet.
     *
     * @param amount
     *            The amount to remove from the wallet
     */
    public void removeToken(int amount) {

        for (int i = 0; i < amount; i++) {
            Tokens.remove(0);
        }
    }

    /**
     * get the number of Tokens in the wallet.
     *
     * @return the number of tokens in the wallet(size of the ArrayList)
     */
    public int getAmount() {
        return Tokens.size();
    }

}
