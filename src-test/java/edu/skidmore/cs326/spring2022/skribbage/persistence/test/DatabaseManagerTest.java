package edu.skidmore.cs326.spring2022.skribbage.persistence.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.skidmore.cs326.spring2022.skribbage.persistence.DatabaseManager;

/**
 * 
 * @author Ricardo
 *		   Last Edited: By Ricardo, March 31, 2022
 */
public class DatabaseManagerTest {

	/**
	 * The Test instance of databasemanager
	 */
	private DatabaseManager databaseinstance;
	
	/**
	 * Sets up the default testing setting before everytest
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		databaseinstance = new DatabaseManager();
	}

	/**
	 * Testing when the userAuthenticate fails with wrong username and password
	 */
	@Test
	public void userAuthenticatefail() {
		Boolean verification = databaseinstance.userAuthenticate("Rick Sanches", "szechuanSauce");
		assertEquals(false, verification);
	}
	
	/**
	 * Testing when the userAuthenticate works with correct username and password
	 */
	@Test
	public void userAuthenticateSuccess() {
		Boolean verification = databaseinstance.userAuthenticate("nchantzi", "ILoveSQL");
		assertEquals(true, verification);
	}
	
	@Test
	public void inventoryQuery() {
		String cointtest = databaseinstance.inventoryQuery(325);
	}

}
