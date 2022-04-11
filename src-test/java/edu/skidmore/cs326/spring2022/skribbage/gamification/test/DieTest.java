package edu.skidmore.cs326.spring2022.skribbage.gamification.test;

import org.apache.log4j.Logger;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import edu.skidmore.cs326.spring2022.skribbage.gamification.BattleSpot;
import edu.skidmore.cs326.spring2022.skribbage.gamification.Die;

/**
 * Unit test for Die.
 * 
 * @author Henry Wilson
 */
public class DieTest {

    /**
     * Logger for the class.
     */
    private static final Logger LOG;

    /**
     * Create static resources.
     */
    static {
        LOG = Logger.getLogger(BattleSpotTest.class);
    }

    /**
     * Attribute to house the test instance.
     */
    private Die testInstance;

    @Before
    public void setup() {
        testInstance = new Die();
    }

    /**
     * Tests the functionality of rolling the die including setting negative
     * lower bounds and not allowing zeros.
     */
    @Test
    public void testRollDie() {

        int numTests = 0;

        Boolean negThrees = false;
        Boolean negTwos = false;
        Boolean negOnes = false;
        Boolean zeros = false;
        Boolean ones = false;
        Boolean twos = false;
        Boolean threes = false;
        Boolean fours = false;
        Boolean fives = false;
        Boolean sixes = false;

        Boolean[] cases = { negThrees, negTwos, negOnes, zeros, ones, twos,
            threes, fours, fives, sixes };

        while (numTests < 100) {

            int dieRoll = testInstance.rollDie(6, 0, true);
            
            assertTrue(dieRoll >= 0 && dieRoll <= 6);
            cases[dieRoll + 3] = true;
            numTests++;
        }
        numTests = 0;
        for (int i = 3; i <= 9; i++) {
            assertTrue(cases[i]);
            cases[i] = false;
        }

        while (numTests < 100) {
            int dieRoll = testInstance.rollDie(6, 1, false);
            System.out.println(dieRoll);
            assertTrue(dieRoll >= 1 && dieRoll <= 6);
            cases[dieRoll + 3] = true;
            numTests++;
        }
        numTests = 0;
        for (int i = 4; i <= 9; i++) {
            System.out.println(i);
            assertTrue(cases[i]);
            cases[i] = false;
        }

        while (numTests < 100) {
            int dieRoll = testInstance.rollDie(3, -3, true);
            assertTrue(dieRoll >= -3 && dieRoll <= 3);
            cases[dieRoll + 3] = true;
            numTests++;
        }
        numTests = 0;
        for (int i = 0; i <= 6; i++) {
            assertTrue(cases[i]);
            cases[i] = false;
        }
        while (numTests < 100) {
            int dieRoll = testInstance.rollDie(3, -3, false);
            assertTrue(dieRoll >= -3 && dieRoll <= 3 && dieRoll != 0);
            cases[dieRoll + 3] = true;
            numTests++;
        }
        numTests = 0;
        for (int i = 0; i <= 6; i++) {
            if (i != 3) {
                assertTrue(cases[i]);
            }
            cases[i] = false;
        }

    }

}
