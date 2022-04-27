package edu.skidmore.cs326.spring2022.skribbage.persistence.test;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import edu.skidmore.cs326.spring2022.skribbage.common.UserRole;
import org.junit.Before;
import org.junit.Test;

import edu.skidmore.cs326.spring2022.skribbage.common.Password;
import edu.skidmore.cs326.spring2022.skribbage.common.PasswordHasher;
import edu.skidmore.cs326.spring2022.skribbage.common.User;
import edu.skidmore.cs326.spring2022.skribbage.persistence.DatabaseManager;
import edu.skidmore.cs326.spring2022.skribbage.persistence.Item;
import edu.skidmore.cs326.spring2022.skribbage.persistence.ItemTypes;
import edu.skidmore.cs326.spring2022.skribbage.persistence.PersistenceFacade;

/**
 * @author Ricardo Rosario Last Edited: By Ricardo, April 13, 2022
 */
public class FacadeTest {

    /**
     * The Test instatnce of Facade Needed to create 2 users There is 1 correct
     * user. with the correct password and correct username The other user is
     * with
     * the wrong password and wrong username that is not in the database
     */
    private PersistenceFacade facadeinstanace;

    /**
     * wrongtestuser.
     */
    private User wrongTestUser;

    /**
     * wrongtestpassword.
     */
    private Password wrongTestPassword;

    /**
     * correcttestuser.
     */
    private User correctTestUser;

    /**
     * correcttestpassword.
     */
    private Password correctTestPassword;

    /**
     * inventoryuser.
     */
    private User inventoryUser;

    /**
     * walletUser.
     */
    private User walletUser;

    /**
     * correcttestitem.
     */
    private Item correctTestItem;

    /**
     * newUser
     */
    private User newTestUser;

    /**
     * newTestPassword
     */
    private Password newTestPassword;

    /**
     * Sets up the default testing setting before everytest.
     * 
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        facadeinstanace = new PersistenceFacade();

        correctTestUser = new User("Ricardo@skidmore.edu", "Rick", null);
        correctTestPassword = facadeinstanace.getPassword(correctTestUser);

        wrongTestUser = new User("DJKhaled.com", "Khaled", null);
        wrongTestPassword = new Password(PasswordHasher.getInstance()
            .hashNewPassword("AnotherOne"));

        newTestUser = new User("JohnnyDepp1@gmail.com", "Willy Wonka", null);
        newTestPassword = new Password(PasswordHasher.getInstance()
            .hashNewPassword("Captain"));

        correctTestItem = new Item();
        correctTestItem.setItemType(ItemTypes.MIRROR);
        correctTestItem.setQuantityHeld(31);
        inventoryUser = new User("inconsequential", "TestingUser", null);
        inventoryUser.setUserId(3);
        walletUser = new User("inconsequential", "Your", null);
        walletUser.setUserId(325);
        // databasemanagerinstance = new DatabaseManager();
    }

    /**
     * Testing when the user wants to log in with the correct username and
     * password.
     */
    // @Test
    // public void createUserCorrect() {
    // facadeinstanace.userCreate(newTestUser, newTestPassword);
    // boolean iscorrect1 = facadeinstanace.userNameExists(newTestUser);
    // assertEquals("Checking if the new user was creating", true, iscorrect1);
    // String pass = facadeinstanace.getPassword(newTestUser)
    // .getBase64SaltAndPasswordHash();
    // assertEquals("Checking if the new user cotains the correct password",
    // pass, newTestPassword.getBase64SaltAndPasswordHash());
    // }

    /**
     * Testing when the user wants to change their password Passing in the user,
     * the. current pass and the new password
     */
    @Test
    public void passwordChangeCorrect() {
        facadeinstanace.passwordChange(correctTestUser, newTestPassword);
        String pass = facadeinstanace.getPassword(correctTestUser)
            .getBase64SaltAndPasswordHash();
        assertEquals("This checks that the password was changed", pass,
            newTestPassword.getBase64SaltAndPasswordHash());
    }

    /**
     * Testing when the user wants to change their password Passing in the user,
     * the
     * current pass and the new password however it fails
     */
    // @Test
    // public void passwordChangeFail() {
    //
    // }

    /**
     * Testing when logic wants to log in a user and wants to obtain a password
     * (Working)
     */
    @Test
    public void getpass() {
        Password pass = facadeinstanace.getPassword(correctTestUser);
        assertEquals("testing to see if we get same password",
            correctTestPassword.getBase64SaltAndPasswordHash(),
            pass.getBase64SaltAndPasswordHash());
    }

    /**
     * Testing to see if the username exists already
     */
    @Test
    public void accountExistsSuccess() {
        Boolean verification = facadeinstanace.userNameExists(correctTestUser);
        assertEquals("User should exist", true, verification);
    }

    /**
     * Testing to see that the username doesn't exist
     */
    @Test
    public void accountDoesntExist() {
        Boolean verification = facadeinstanace.userNameExists(newTestUser);
        assertEquals("User should not exist", false, verification);
    }

    /**
     * Testing the capability to display wallet values.
     */
    @Test
    public void displayWalletTest() {
        walletUser.setUserId(9952);

        assertEquals("Testing to see if displayWallet Works",
            facadeinstanace.displayWallet(walletUser),
            "player coin value: 10000");
    }

    /**
     * Testing validating username to see if it doesn't have bad words
     */
    // @Test
    // public void validateUsernameCuss() {
    //
    // facadeinstanace.validateUsername(correctTestUser);
    // }

    /**
     * Testing the capability to display inventory values.
     */
     @Test
     public void displayInventoryTest() {
    
     HashMap<String, Item> hashMap =
     facadeinstanace.displayInventory(inventoryUser);
     System.out.println("1 " + correctTestItem.toString());
     System.out.println("2 " + hashMap.get("MIRROR").toString());
     assertEquals(correctTestItem.toString(),
     hashMap.get("MIRROR").toString());
     }

    /**
     * Testing the capability to display inventory values.
     */
    // @Test
    // public void displayInventoryTest() {
    //
    // HashMap<String, Item> hashMap =
    // facadeinstanace.displayInventory(inventoryUser);
    // System.out.println("1 " + correctTestItem.toString());
    // System.out.println("2 " + hashMap.get("PARTY_HAT").toString());
    // assertEquals(correctTestItem.toString(),
    // hashMap.get("PARTY_HAT").toString());
    // }

}
