
package edu.skidmore.cs326.spring2022.skribbage.gamification.test;

import edu.skidmore.cs326.spring2022.skribbage.gamification.TokenManager;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * Test class for Wallet.
 * 
 * @author jratsimb
 */
public class TokenManagerTest {

    /**
     * instance of wallet to be tested.
     */
    private TokenManager testInstance;

    /**
     * Test that when the instance of a wallet is created the amount of.
     * Token in it is equal to the passed parameter.
     */
    @Before
    public void setup() {
        testInstance = new TokenManager(10);
    }

    /**
     * Test the add token method.
     */
    @Test
    public void testAddToken() {
        testInstance.addToken(5);
        assertEquals(15, testInstance.getAmount());
        testInstance.addToken(100);
        assertEquals(115, testInstance.getAmount());
    }

    /**
     * Test the remove token method.
     */
    @Test
    public void testRemoveToken() {
        testInstance.removeToken(5);
        assertEquals(5, testInstance.getAmount());
        testInstance.removeToken(5);
        assertEquals(0, testInstance.getAmount());
    }

    /**
     * Test the getAmount method.
     */
    @Test
    public void testGetAmount() {
        assertEquals(10, testInstance.getAmount());
        testInstance.addToken(7);
        assertEquals(17, testInstance.getAmount());
        testInstance.removeToken(17);
        assertEquals(0, testInstance.getAmount());
    }

}
