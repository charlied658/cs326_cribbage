package edu.skidmore.cs326.spring2022.skribbage.persistence.test;

import edu.skidmore.cs326.spring2022.skribbage.persistence.DatabaseProperties;

//import static org.junit.Assert.assertTrue;
//
//import org.apache.log4j.Logger;
//
//import static org.junit.Assert.assertNotNull;
//
//import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DatabasePropertiesTest {

	@Test
	public void testGetUserIDValue() {
		assertEquals("Incorrect UserID Property", "skribbage_app", DatabaseProperties.getInstance().getValue("UserID"));
	}

	@Test
	public void testAppPasswordGetValue() {
		assertEquals("Incorrect AppPassword Property", "z5(DHjabY!O",
				DatabaseProperties.getInstance().getValue("AppPassword"));
	}

	@Test
	public void testDBUrlGetValue() {
		assertEquals("Incorrect DBUrl Property", "jdbc:mysql://bits.monead.com:3306/skribbage",
				DatabaseProperties.getInstance().getValue("DBUrl"));
	}
}
