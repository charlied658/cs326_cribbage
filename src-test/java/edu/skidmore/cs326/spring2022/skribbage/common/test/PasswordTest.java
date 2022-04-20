package edu.skidmore.cs326.spring2022.skribbage.common.test;

import edu.skidmore.cs326.spring2022.skribbage.common.Password;
import edu.skidmore.cs326.spring2022.skribbage.common.PasswordHasher;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Simple class for testing the user bean.
 * 
 * @author Alex Carney
 * @author DSR
 */
public class PasswordTest {

    /**
     * Logger instance for logging.
     */
    private static final Logger LOG;

    static {
        LOG = Logger.getLogger(PasswordTest.class);
    }

    /**
     * Test password constructor passing correctly formatted salt and hash.
     */
    @Test
    public void testPassword() {
        assertNotNull("Password object not created",
            new Password(
                "testSalt" + PasswordHasher.SALT_AND_PASSWORD_BASE64_SEPARATOR
                    + "testPassword"));
    }

    /**
     * Test password constructor passing incorrectly formatted salt and hash.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testPasswordBadFormat() {
        new Password("testSalt testPassword");
    }

    /**
     * Test the hashed password accessor.
     */
    @Test
    public void testGetBase64PasswordHash() {
        Password p = new Password(
            "testSalt" + PasswordHasher.SALT_AND_PASSWORD_BASE64_SEPARATOR
                + "testPassword");
        assertEquals("Incorrect hashed password value", "testPassword",
            p.getBase64PasswordHash());
    }

    /**
     * Test the salt accessor.
     */
    @Test
    public void testGetBase64Salt() {
        Password p = new Password(
            "testSalt" + PasswordHasher.SALT_AND_PASSWORD_BASE64_SEPARATOR
                + "testPassword");
        assertEquals("Incorrect salt value", "testSalt", p.getBase64Salt());
    }

    /**
     * Test the salt accessor.
     */
    @Test
    public void testGetBase64SaltAndPasswordHash() {
        Password p = new Password(
            "testSalt" + PasswordHasher.SALT_AND_PASSWORD_BASE64_SEPARATOR
                + "testPassword");
        assertEquals("Incorrect salt and hashed password value",
            "testSalt" + PasswordHasher.SALT_AND_PASSWORD_BASE64_SEPARATOR
                + "testPassword",
            p.getBase64SaltAndPasswordHash());
    }
}
