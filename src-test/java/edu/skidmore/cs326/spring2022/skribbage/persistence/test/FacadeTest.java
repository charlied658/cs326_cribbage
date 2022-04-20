package edu.skidmore.cs326.spring2022.skribbage.persistence.test;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import edu.skidmore.cs326.spring2022.skribbage.common.UserRole;
import org.junit.Before;
import org.junit.Test;

import edu.skidmore.cs326.spring2022.skribbage.common.Password;
import edu.skidmore.cs326.spring2022.skribbage.common.User;
import edu.skidmore.cs326.spring2022.skribbage.persistence.Item;
import edu.skidmore.cs326.spring2022.skribbage.persistence.ItemTypes;
import edu.skidmore.cs326.spring2022.skribbage.persistence.PersistenceFacade;

/**
 * @author Ricardo Rosario Last Edited: By Ricardo, April 13, 2022
 */
public class FacadeTest {

    /**
     * The Test instatnce of Facade Needed to create 2 users There is 1 correct
     * user.
     * with the correct password and correct username The other user is with the
     * wrong password and wrong username that is not in the database
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
     * Sets up the default testing setting before everytest.
     * 
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        facadeinstanace = new PersistenceFacade();
        wrongTestUser = new User("DJKhaled.com", "Khaled",
            UserRole.UNAUTHORIZED);
        wrongTestPassword = new Password("AnotherOne");
        correctTestUser =
            new User("nchantzi@skidmore.edu", "nchantzi",
                UserRole.UNAUTHORIZED);
        correctTestPassword = new Password("ILoveSQL");
        correctTestItem = new Item();
        correctTestItem.setItemType(ItemTypes.PARTY_HAT);
        correctTestItem.setQuantityHeld(31);
        inventoryUser = new User("inconsequential", "inconsequential",
            UserRole.UNAUTHORIZED);
        inventoryUser.setUserId(236);
        walletUser = new User("inconsequential", "inconsequential",
            UserRole.UNAUTHORIZED);
        walletUser.setUserId(325);
    }


    /**
     * Testing when the user wants to change their password Passing in the user,
     * the.
     * current pass and the new password
     */
    @Test
    public void passwordChangeCorrect() {
        boolean iscorrect = facadeinstanace.passwordChange(correctTestUser,
            correctTestPassword, wrongTestPassword);
        assertEquals(true, iscorrect);
    }

    /**
     * Testing when the user wants to change their password Passing in the user,
     * the
     * current pass and the new password however it fails
     */
    // @Test
    // public void passwordChangeFail() {
    // boolean iscorrect = facadeinstanace.passwordChange(correctTestUser,
    // correctTestPassword, wrongTestPassword);
    // assertEquals(true, iscorrect);
    // }

    /**
     * Testing when the user wants to log in with the correct username and
     * password
     */
    // @Test
    // public void loginCorrect() {
    // boolean iscorrect = facadeinstanace.login(correctTestUser,
    // correctTestPassword);
    // assertEquals(true, iscorrect);
    // }

    /**
     * Testing the capability to display inventory values.
     */
    @Test
    public void displayInventoryTest() {

        HashMap<String, Item> hashMap =
            facadeinstanace.displayInventory(inventoryUser);
        System.out.println("1 " + correctTestItem.toString());
        System.out.println("2 " + hashMap.get("PARTY_HAT").toString());
        assertEquals(correctTestItem.toString(),
            hashMap.get("PARTY_HAT").toString());
    }

    /**
     * Testing the capability to display wallet values.
     */
    @Test
    public void displayWalletTest() {

        assertEquals(facadeinstanace.displayWallet(walletUser),
            "player coin value: 100000");
    }

    /**
     * Testing when the user wants to log in with the correct username and
     * password.
     */
    @Test
    public void createUserCorrect() {
        facadeinstanace.userCreate(wrongTestUser, wrongTestPassword);
        // boolean iscorrect = facadeinstanace.login(wrongTestUser,
        // wrongTestPassword);
        // assertEquals(true, iscorrect);
    }
    
    /**
     * Testing when the userDelete corrects with the correct user.
     */
    @Test
    public void userDeleteTestCorrect() {
        boolean iscorrect = facadeinstanace.userDelete(wrongTestUser);
        assertEquals(true, iscorrect);
    }

    @Test
    public void userDeleteTestFail() {
        boolean iscorrect = facadeinstanace.userDelete(wrongTestUser);
        assertEquals(false, iscorrect);
    }

}
