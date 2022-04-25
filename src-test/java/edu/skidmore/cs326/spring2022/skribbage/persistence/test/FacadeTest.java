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
	 * user. with the correct password and correct username The other user is with
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
		wrongTestUser = new User("DJKhaled.com", "Khaled", null);

		
		correctTestUser = new User("Ricardo@skidmore.edu", "Rick", null);
		correctTestPassword = new Password(PasswordHasher.getInstance().hashNewPassword("ILoveSQL"));
//		wrongTestPassword = new Password("Anotherone");
//		newTestPassword = new Password("thisIsNewPass");
		correctTestItem = new Item();
		correctTestItem.setItemType(ItemTypes.PARTY_HAT);
		correctTestItem.setQuantityHeld(31);
		inventoryUser = new User("inconsequential", "inconsequential", null);
		inventoryUser.setUserId(236);
		walletUser = new User("inconsequential", "inconsequential", null);
		walletUser.setUserId(325);
//		databasemanagerinstance = new DatabaseManager();
	}

	/**
	 * Testing when the user wants to change their password Passing in the user,
	 * the. current pass and the new password
	 */
//	@Test
//	public void passwordChangeCorrect() {
//		facadeinstanace.passwordChange(correctTestUser, correctTestPassword, newTestPassword);
//		boolean iscorrect = facadeinstanace.login(correctTestUser, newTestPassword);
//		assertEquals(true, iscorrect);
//	}

	/**
	 * Testing when the user wants to change their password Passing in the user, the
	 * current pass and the new password however it fails
	 */
	// @Test
	// public void passwordChangeFail() {
	// boolean iscorrect = facadeinstanace.passwordChange(correctTestUser,
	// correctTestPassword, wrongTestPassword);
	// assertEquals(true, iscorrect);
	// }

	/**
	 * Testing when the user wants to log in with the correct username and password
	 */
	@Test
	public void getpass() {
		Password pass = facadeinstanace.getPassword(correctTestUser);
		assertEquals("testing to see if we get same password", "9TRMu+qZwS8JHg==~D1YF2LUPx48x5eHKLrxYI22XDJh+1uOPZ5FKHByqsg8=", pass.getBase64SaltAndPasswordHash());
	}

	/**
	 * Testing the capability to display inventory values.
	 */
//	@Test
//	public void displayInventoryTest() {
//
//		HashMap<String, Item> hashMap = facadeinstanace.displayInventory(inventoryUser);
//		System.out.println("1 " + correctTestItem.toString());
//		System.out.println("2 " + hashMap.get("PARTY_HAT").toString());
//		assertEquals(correctTestItem.toString(), hashMap.get("PARTY_HAT").toString());
//	}

	/**
	 * Testing the capability to display wallet values.
	 */
//	@Test
//	public void displayWalletTest() {
//
//		assertEquals(facadeinstanace.displayWallet(walletUser), "player coin value: 100000");
//	}

	/**
	 * Testing when the user wants to log in with the correct username and password.
	 */
//	@Test
//	public void createUserCorrect() {
//		facadeinstanace.userCreate(wrongTestUser, wrongTestPassword);
//		// boolean iscorrect = facadeinstanace.login(wrongTestUser,
//		// wrongTestPassword);
//		// assertEquals(true, iscorrect);
//	}

	/**
	 * Testing when the userDelete corrects with the correct user.
	 */
//	@Test
//	public void userDeleteTestCorrect() {
//		boolean iscorrect = facadeinstanace.userDelete(wrongTestUser, wrongTestPassword);
//		assertEquals(true, iscorrect);
//	}
//
//	@Test
//	public void userDeleteTestFail() {
//		boolean iscorrect = facadeinstanace.userDelete(wrongTestUser, wrongTestPassword);
//		assertEquals(false, iscorrect);
//	}



	/**
	 * Testing when the user wants to change their password Passing in the user, the
	 * current pass and the new password however it fails
	 */
	// @Test
	// public void passwordChangeFail() {
	// boolean iscorrect = facadeinstanace.passwordChange(correctTestUser,
	// correctTestPassword, wrongTestPassword);
	// assertEquals(true, iscorrect);
	// }

	/**
	 * Testing when the user wants to log in with the correct username and password
	 */
//	 @Test
//	 public void loginCorrect() {
//	 boolean iscorrect = facadeinstanace.login(correctTestUser,
//	 correctTestPassword);
//	 assertEquals(true, iscorrect);
//	 }

	/**
	 * Testing the capability to display inventory values.
	 */
//    @Test
//    public void displayInventoryTest() {
//
//        HashMap<String, Item> hashMap =
//            facadeinstanace.displayInventory(inventoryUser);
//        System.out.println("1 " + correctTestItem.toString());
//        System.out.println("2 " + hashMap.get("PARTY_HAT").toString());
//        assertEquals(correctTestItem.toString(),
//            hashMap.get("PARTY_HAT").toString());
//    }

	/**
	 * Testing the capability to display wallet values.
	 */
//    @Test
//    public void displayWalletTest() {
//
//        assertEquals(facadeinstanace.displayWallet(walletUser),
//            "player coin value: 100000");
//    }

	/**
	 * Testing when the user wants to log in with the correct username and password.
	 */
//    @Test
//    public void createUserCorrect() {
//        facadeinstanace.userCreate(wrongTestUser, wrongTestPassword);
//        // boolean iscorrect = facadeinstanace.login(wrongTestUser,
	// wrongTestPassword);
//        // assertEquals(true, iscorrect);
//    }

	/**
	 * Testing when the userDelete corrects with the correct user.
	 */
//    @Test
//    public void userDeleteTestCorrect() {
//        boolean iscorrect = facadeinstanace.userDelete(wrongTestUser, wrongTestPassword);
//        assertEquals(true, iscorrect);
//    }
	
	/**
	 * Testing to see if the username exists already
	 */
	@Test
	public void accountExistsSuccess() {
		Boolean verification = facadeinstanace.userNameExists(correctTestUser);
		assertEquals("User should exist", true, verification);
	}

}
