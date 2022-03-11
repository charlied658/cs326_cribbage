package edu.skidmore.cs326.spring2022.skribbage.persistence.test;

import edu.skidmore.cs326.spring2022.skribbage.persistence.DatabaseProperties;

import static org.junit.Assert.assertTrue;

import org.apache.log4j.Logger;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DatabasePropertiesTest {

	@Test
	public void testGetValue() {
		assertEquals("Incorrect UserID Property","skribbage_adm", DatabaseProperties.getInstance().getValue("UserID"));
	}
	
	
	
}
