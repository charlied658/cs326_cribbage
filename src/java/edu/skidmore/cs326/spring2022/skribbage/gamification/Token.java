package edu.skidmore.cs326.spring2022.skribbage.gamification;

import org.apache.log4j.Logger;

import edu.skidmore.cs326.spring2022.skribbage.SkribbageBattleRoyale;

/**
 * @author jaroderatsimbazafy.
 *         Token Class, currency of the game.
 */
public class Token {

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
     * Constructor method.
     */
    public Token() {
        LOG.info("Initializing Token");
    }
}
