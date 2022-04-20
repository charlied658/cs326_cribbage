package edu.skidmore.cs326.spring2022.skribbage.common.test;

import edu.skidmore.cs326.spring2022.skribbage.common.Password;
import edu.skidmore.cs326.spring2022.skribbage.common.PasswordHasher;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.junit.Test;

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
        LOG.trace("Test Password constructor");
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
        LOG.trace("Test Password constructor with bad salt and hash encoding");
        new Password("testSalt testPassword");
    }

    /**
     * Test the hashed password accessor.
     */
    @Test
    public void testGetBase64PasswordHash() {
        LOG.trace("Test Password hash getter");
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
        LOG.trace("Test Password salt getter");
        Password p = new Password(
            "testSalt" + PasswordHasher.SALT_AND_PASSWORD_BASE64_SEPARATOR
                + "testPassword");
        assertEquals("Incorrect salt value", "testSalt", p.getBase64Salt());
    }

    /**
     * Test the salt and password hash accessor.
     */
    @Test
    public void testGetBase64SaltAndPasswordHash() {
        LOG.trace("Test Password salt and hash getter");
        Password p = new Password(
            "testSalt" + PasswordHasher.SALT_AND_PASSWORD_BASE64_SEPARATOR
                + "testPassword");
        assertEquals("Incorrect salt and hashed password value",
            "testSalt" + PasswordHasher.SALT_AND_PASSWORD_BASE64_SEPARATOR
                + "testPassword",
            p.getBase64SaltAndPasswordHash());
    }

    /**
     * Test the equals method when Password are equal.
     */
    @Test
    public void testEqualsIsEqual() {
        LOG.trace("Test Password equals when equal");
        Password p1 = new Password(
            "testSalt" + PasswordHasher.SALT_AND_PASSWORD_BASE64_SEPARATOR
                + "testPassword");
        Password p2 = new Password(
            "testSalt" + PasswordHasher.SALT_AND_PASSWORD_BASE64_SEPARATOR
                + "testPassword");

        assertTrue("Passwords should match", p1.equals(p2));
    }

    /**
     * Test the equals method when Password are not equal.
     */
    @Test
    public void testEqualsNotEqual() {
        LOG.trace("Test Password equals when not equal");
        Password p1 = new Password(
            "testSalt" + PasswordHasher.SALT_AND_PASSWORD_BASE64_SEPARATOR
                + "testPassword");
        Password p2 = new Password(
            "testSalt2" + PasswordHasher.SALT_AND_PASSWORD_BASE64_SEPARATOR
                + "testPassword2");

        assertFalse("Passwords should not match", p1.equals(p2));
    }

    /**
     * Test the hashCode method when Passwords are equal.
     */
    @Test
    public void testHashCode() {
        LOG.trace("Test Password hashCode when equal");
        Password p1 = new Password(
            "testSalt" + PasswordHasher.SALT_AND_PASSWORD_BASE64_SEPARATOR
                + "testPassword");
        Password p2 = new Password(
            "testSalt" + PasswordHasher.SALT_AND_PASSWORD_BASE64_SEPARATOR
                + "testPassword");

        assertEquals("Password hashCodes should match", p1.hashCode(),
            p2.hashCode());
    }

}
