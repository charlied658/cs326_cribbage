package edu.skidmore.cs326.spring2022.skribbage.persistence.test;

import static org.junit.Assert.assertEquals;

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
	 * correct user with the correct password and correct username The other user is
	 * with the wrong password and wrong username that is not in the database
	 */
	private DatabaseManager databaseinstance;

	/**
<<<<<<< HEAD
	 * wronttestuser.
=======
	 * wrongtestuser.
>>>>>>> 97d84c365ac46f838eb01a9778e0a4b76eb945bd
	 */
	private User wrongTestUser;

	/**
<<<<<<< HEAD
=======
	 * username that exists.
	 */
	private String existentUsername;

	/**
	 * username that doesnt exist.
	 */
	private String nonExistentUsername;

	/**
>>>>>>> 97d84c365ac46f838eb01a9778e0a4b76eb945bd
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

		wrongTestUser = new User("DJKhaled@hotmail.com", "Khaled", UserRole.UNAUTHORIZED);
		wrongTestPassword = new Password("AnotherOne");
		correctTestUser = new User("nchantzi@skidmore.edu", "nchantzi", UserRole.UNAUTHORIZED);
		correctTestPassword = new Password("ILoveSQL");
	}

	/**
	 * Testing when the userAuthenticate fails with wrong username and password.
	 */
	@Test
	public void userAuthenticatefail() {
		boolean verification = databaseinstance.userAuthenticate(wrongTestUser, wrongTestPassword);
		assertEquals(false, verification);
	}

	/**
	 * Testing when the userAuthenticate works with correct username and password.
	 */
	@Test
	public void userAuthenticateSuccess() {
		Boolean verification = databaseinstance.userAuthenticate(correctTestUser, correctTestPassword);
		assertEquals(true, verification);
	}

	/**
	 * Testing when the inventory deposit method
	 */
	@Test
	public void inventoryDeposit() {

		System.out.println("entered test");
		ItemTypes testType = ItemTypes.BIRTHDAY_CAKE;
		int testQuantity = 55;
		databaseinstance.inventoryDeposit(testType, testQuantity, correctTestUser);

		HashMap<String, Item> resultSet = databaseinstance.inventoryQuery(correctTestUser.getUserId());
		Item finalItem = resultSet.get(testType.toString());

		assertEquals(finalItem.getQuantityHeld(), testQuantity);
		assertEquals(finalItem.getItemType(), testType);
		System.out.println("test end");

		existentUsername = new String("nchantzi");
		nonExistentUsername = new String("jbrunsta");
		//wrongTestUser = new User("DJKhaled.com", "Khaled", null);
		wrongTestPassword = new Password("AnotherOne");
		//correctTestUser = new User("nchantzi@skidmore.edu", "nchantzi", null);
		correctTestPassword = new Password("ILoveSQL");
	}

//	/**
//	 * Testing when the userAuthenticate fails with wrong username and password.
//	 */
//	@Test
//	public void userAuthenticatefail() {
//		boolean verification = databaseinstance.userAuthenticate(wrongTestUser, wrongTestPassword);
//		assertEquals(false, verification);
//	}
//
//	/**
//	 * Testing when the userAuthenticate works with correct username and password.
//	 */
//	@Test
//	public void userAuthenticateSuccess() {
//		Boolean verification = databaseinstance.userAuthenticate(correctTestUser, correctTestPassword);
//		assertEquals(true, verification);
//	}

	/**
	 * Testing when the accountExists works with existent username
	 */
	@Test
	public void accountExistsSuccess() {
		Boolean verification = databaseinstance.accountExists(existentUsername);
		assertEquals("User should exist", true, verification);
	}

	/**
	 * Testing when the accountExists works with non existent username
	 */
	@Test
	public void accountExistsFail() {
		Boolean verification = databaseinstance.accountExists(nonExistentUsername);
		assertEquals("User should not exist", false, verification);

	}

	/**
	 * Testing when asking the inventoryQuery for coin count is successful.
	 */// @Test
		// public void inventoryQuerysuccess() {
		// String cointest = databaseinstance.walletQuery(325);
		// assertEquals(cointest, "player coin value: 100000");
		// }
		// @Test
		// public void inventoryQuerysuccess() {
		// String cointest = databaseinstance.walletQuery(325);
		// assertEquals(cointest, "player coin value: 100000");
		// }

	/**
	 * Testing when asking the inventoryQuery for coin count fails.
	 */
	// @Test
	// public void inventoryQueryfails() {
	// String cointest = databaseinstance.walletQuery(420);
	// assertEquals(cointest, "Account not found");
	// }


}
