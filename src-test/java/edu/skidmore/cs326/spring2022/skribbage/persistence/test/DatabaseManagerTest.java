package edu.skidmore.cs326.spring2022.skribbage.persistence.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import edu.skidmore.cs326.spring2022.skribbage.common.UserRole;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import edu.skidmore.cs326.spring2022.skribbage.common.Password;
import edu.skidmore.cs326.spring2022.skribbage.common.User;
import edu.skidmore.cs326.spring2022.skribbage.persistence.DatabaseManager;
import edu.skidmore.cs326.spring2022.skribbage.persistence.Item;
import edu.skidmore.cs326.spring2022.skribbage.persistence.ItemTypes;

/**
 * @author Ricardo Rosario Last Edited: By Ricardo, March 31, 2022
 */
public class DatabaseManagerTest {

    /**
     * The Test instance of databasemanager. Needed to create 2 users There is 1
     * correct user with the correct password and correct username The other
     * user is
     * with the wrong password and wrong username that is not in the database
     */
    private DatabaseManager databaseinstance;

    /**
     * wrongtestuser
     */
    private User wrongTestUser;

    /**
     * username that exists.
     */
    private String existentUsername;

    /**
     * username that doesnt exist.
     */
    private String nonExistentUsername;

    /**
     * wrongtestpassword.
     */
    private Password wrongTestPassword;

    /**
     * correctTestuser.
     */
    private User correctTestUser;

    /**
     * correctestpassword.
     */
    private Password correctTestPassword;

    /**
     * Sets up the default testing setting before everytest.
     * 
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        databaseinstance = new DatabaseManager();
        existentUsername = "Rick";
        nonExistentUsername = "jbrunsta";
        wrongTestUser =
            new User("DJKhaled@hotmail.com", "Khaled", UserRole.UNAUTHORIZED);
        wrongTestPassword = new Password("salt~AnotherOne");
        correctTestUser = new User("nchantzi@skidmore.edu", "nchantzi",
            UserRole.UNAUTHORIZED);
        correctTestPassword = new Password("salt~ILoveSQL");
    }

//    /**
//     * Testing the inventory deposit method
//     */
//    @Test
//    public void inventoryDeposit() {
//
//        System.out.println("entered test");
//        ItemTypes testType = ItemTypes.BIRTHDAY_CAKE;
//        int testQuantity = 55;
//        databaseinstance.inventoryDeposit(testType, testQuantity,
//            correctTestUser);
//
//        HashMap<String, Item> resultSet =
//            databaseinstance.inventoryQuery(correctTestUser.getUserId());
//        Item finalItem = resultSet.get(testType.toString());
//
//        System.out.println("assert identical: " + finalItem.getQuantityHeld() + testQuantity);
//        assertEquals("Inventory deposit should work",
//            finalItem.getQuantityHeld(), testQuantity);
//        assertEquals("Inventory deposit should work", finalItem.getItemType(),
//            testType);
//
//    }

    /**
     * Testing when the userAuthenticate fails with wrong username and password.
     */
    // @Test
    // public void userAuthenticatefail() {
    // boolean verification =
    // databaseinstance.userAuthenticate(wrongTestUser, wrongTestPassword);
    // assertEquals(
    // "Wrong usernname or password, user should not be authenticated",
    // false, verification);
    // }

    /**
     * Testing when the userAuthenticate works with correct username and
     * password.
     */
    // @Test
    // public void userAuthenticateSuccess() {
    // Boolean verification = databaseinstance
    // .userAuthenticate(correctTestUser, correctTestPassword);
    // assertEquals(
    // "Correct usernname and password, user should be authenticated",
    // true, verification);
    // }

//    /**
//     * Testing when the accountExists works with existent username
//     */
//    @Test
//    public void accountExistsSuccess() {
//        Boolean verification = databaseinstance.accountExists(existentUsername);
//        assertEquals("User should exist", true, verification);
//    }

//    /**
//     * Testing when the accountExists works with non existent username
//     */
//    @Test
//    public void accountExistsFail() {
//        Boolean verification =
//            databaseinstance.accountExists(nonExistentUsername);
//        assertEquals("User should not exist", false, verification);
//
//    }

    /**
     * Test that salt value is null for non-existent username.
     */
    @Test
    public void testGetUserSaltBase64MissingUser() {
        assertNull("Salt for nonexistent account should be null",
            databaseinstance.getUserSaltBase64(nonExistentUsername));
    }

    /**
     * Test that salt value is not null for existing username.
     */
    @Test
    public void testGetUserSaltBase64ExistingUser() {
        assertNotNull("Salt for existing account should be found",
            databaseinstance.getUserSaltBase64(existentUsername));
    }

    /**
     * Testing when asking the inventoryQuery for coin count is successful.
     */
    @Test
    public void walletQuerysuccess() {
        String cointest = databaseinstance.walletQuery(9952);
        System.out.println("cointest: " + cointest);
        assertEquals("Coin count ashould be successful", cointest,
            "player coin value: 10000");
    }

    /**
     * Another test.
     */
    @Test
    public void inventoryQuerysuccess() {
        String cointest = databaseinstance.walletQuery(325);
        assertEquals("Coin count should be successful", cointest,
            "player coin value: 100000");
    }

    /**
     * Testing when asking the inventoryQuery for coin count fails.
     */
    @Test
    public void walletQueryfails() {
        String cointest = databaseinstance.walletQuery(420);
        assertEquals("Coin count should fail", cointest, "Account not found");
    }

}
