package edu.skidmore.cs326.spring2022.skribbage.persistence.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.skidmore.cs326.spring2022.skribbage.common.Password;
import edu.skidmore.cs326.spring2022.skribbage.common.User;
import edu.skidmore.cs326.spring2022.skribbage.persistence.DatabaseManager;
import edu.skidmore.cs326.spring2022.skribbage.persistence.PersistenceFacade;

/**
 * @author Ricardo Rosario Last Edited: By Ricardo, April 13, 2022
 */
public class FacadeTest {

	/**
	 * The Test instatnce of Facade Needed to create 2 users There is 1 correct user
	 * with the correct password and correct username The other user is with the
	 * wrong password and wrong username that is not in the database
	 */
	private PersistenceFacade facadeinstanace;
	private User wrongTestUser;
	private Password wrongTestPassword;
	private User correctTestUser;
	private Password correctTestPassword;

	/**
	 * Sets up the default testing setting before everytest.
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		facadeinstanace = new PersistenceFacade();
		wrongTestUser = new User("DJKhaled.com", "Khaled", "AnotherOne", null);
		wrongTestPassword = new Password("AnotherOne");
		correctTestUser = new User("nchantzi@skidmore.edu", "nchantzi", "ILoveSQL", null);
		correctTestPassword = new Password("ILoveSQL");
	}

	/**
	 * Testing when the userDelete corrects with the correct user
	 */
	@Test
	public void userDeleteTestCorrect() {
		boolean iscorrect = facadeinstanace.userDelete(correctTestUser);
		assertEquals(true, iscorrect);
	}

//	@Test
//	public void userDeleteTestFail() {
//		boolean iscorrect = facadeinstanace.userDelete(wrongTestUser);
//		assertEquals(false, iscorrect);
//	}

	/**
	 * Testing when the user wants to change their password Passing in the user, the
	 * current pass and the new password
	 */
	@Test
	public void passwordChangeCorrect() {
		boolean iscorrect = facadeinstanace.passwordChange(correctTestUser, correctTestPassword, wrongTestPassword);
		assertEquals(true, iscorrect);
	}
	
	/**
	 * Testing when the user wants to change their password Passing in the user, the
	 * current pass and the new password however it fails
	 */
//	@Test
//	public void passwordChangeFail() {
//		boolean iscorrect = facadeinstanace.passwordChange(correctTestUser, correctTestPassword, wrongTestPassword);
//		assertEquals(true, iscorrect);
//	}

}
