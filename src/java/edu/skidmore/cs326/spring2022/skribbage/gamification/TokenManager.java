package edu.skidmore.cs326.spring2022.skribbage.gamification;

import java.util.ArrayList;
import org.apache.log4j.Logger;

import edu.skidmore.cs326.spring2022.skribbage.SkribbageBattleRoyale;

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
     * Logger for the class.
     */
    private static final Logger LOG;

    /**
     * Create static resources.
     */
    static {
        LOG = Logger.getLogger(SkribbageBattleRoyale.class);
    }

    /**
     * Constructor.
     *
     * @param initialAmount
     *            the amount of in wallet at instantiation
     */
    public TokenManager(int initialAmount) {
        LOG.info("initializes tokenManager with " + initialAmount + " Tokens.");
        tokens = new ArrayList<Token>();
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
        LOG.info("adds " + amount + " Tokens to tokenManager.");
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
        LOG.info("removes " + amount + " Tokens to tokenManager.");
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
        LOG.info("returns the amount of token in TokenManager.");
        return tokens.size();
    }

}
