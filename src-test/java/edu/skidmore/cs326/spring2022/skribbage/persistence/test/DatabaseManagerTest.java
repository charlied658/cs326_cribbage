package edu.skidmore.cs326.spring2022.skribbage.persistence.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import edu.skidmore.cs326.spring2022.skribbage.persistence.DatabaseManager;

/**
 * @author Ricardo Rosario
 *         Last Edited: By Ricardo, March 31, 2022
 */
public class DatabaseManagerTest {

    /**
     * The Test instance of databasemanager.
     */
    private DatabaseManager databaseinstance;

    /**
     * Sets up the default testing setting before everytest.
     * 
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        databaseinstance = new DatabaseManager();
    }

    /**
     * Testing when the userAuthenticate fails with wrong username and password.
     */
    @Test
    public void userAuthenticatefail() {
        Boolean verification =
            databaseinstance.userAuthenticate("Rick Sanches", "szechuanSauce");
        assertEquals(false, verification);
    }

    /**
     * Testing when the userAuthenticate works with correct username and
     * password.
     */
    @Test
    public void userAuthenticateSuccess() {
        Boolean verification =
            databaseinstance.userAuthenticate("nchantzi", "ILoveSQL");
        assertEquals(true, verification);
    }

    /**
     * Testing when asking the inventoryQuery for coin count is successful.
     */
    @Test
    public void inventoryQuerysuccess() {
        String cointest = databaseinstance.inventoryQuery(325);
        assertEquals(cointest, "player coin value: 100000");
    }

    /**
     * Testing when asking the inventoryQuery for coin count fails.
     */
    @Test
    public void inventoryQueryfails() {
        String cointest = databaseinstance.inventoryQuery(420);
        assertEquals(cointest, "Account not found");
    }

}
