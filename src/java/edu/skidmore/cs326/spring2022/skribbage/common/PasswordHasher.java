package edu.skidmore.cs326.spring2022.skribbage.common;

import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Base64;

import org.apache.log4j.Logger;

import edu.skidmore.cs326.spring2022.skribbage.frontend.PastGamesPage;

/**
 * Singleton class used to hash given passwords.
 *
 * @author Declan Morris
 *      Edited by Jonah Marcus on 20 April 2022 to address Bug #48.
 */
public class PasswordHasher {

    /**
     * The only instance of this class that should ever exist.
     */
    private static PasswordHasher instance = null;
    
    /**
     * Logger instance for logging.
     */
    private static final Logger LOG;

    static {
        LOG = Logger.getLogger(PasswordHasher.class);
    }

    /**
     * Constructor should only be accessed when the instance
     * is first created.
     */
    private PasswordHasher() {

    }

    /**
     * Get method for the singleton instance. Populates instance variable if it
     * has
     * not been populated already (should only happen once).
     *
     * @return returns the instance
     */
    public static PasswordHasher getInstance() {
        if (instance == null) {
            instance = new PasswordHasher();
        }
        return instance;
    }

    /**
     * The salt length in bytes.
     */
    private static final int SALT_LENGTH = 10;

    /**
     * The character separating the salt from the password in the Base64 encoded
     * value. This should be a character that is not used in Base64 encoding.
     */
    public static final String SALT_AND_PASSWORD_BASE64_SEPARATOR = "~";

    /**
     * Generate a salt. This is a random set of bytes used to secure the
     * password
     * and reduce risk of security breach
     *
     * @param length
     *            The salt's size in bytes
     * @return The salt.
     */
    protected byte[] generateSalt(int length) {
        byte[] salt = new byte[length];
        new SecureRandom().nextBytes(salt);
        return salt;
    }

    /**
     * Create a SHA-256 hash of a password and salt.
     *
     * @param password
     *            The password to hash
     * @param salt
     *            The salt being applied to the password
     * @return The hashed salted password
     */
    protected byte[] hashPasswordAndSalt(String password, byte[] salt) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");

            byte[] passwordBytes = password.getBytes();
            byte[] saltAndPassword =
                new byte[salt.length + passwordBytes.length];
            System.arraycopy(salt, 0, saltAndPassword, 0, salt.length);
            System.arraycopy(passwordBytes, 0, saltAndPassword, salt.length,
                passwordBytes.length);

            return md.digest(saltAndPassword);
        }
        catch (Throwable throwable) {
            //System.out.println("Unable to create SHA-256 digest for data");
            //throwable.printStackTrace();
            LOG.error("Unable to create SHA-256 digest for data", throwable);
        }

        return null;
    }

    /**
     * Check whether a password matches a hashed one.
     *
     * @param attemptedPassword
     *            The password being checked, often a password
     *            entered by a user to login
     * @param hashedSaltedPassword
     *            The hash of the salted password, often this is a
     *            value associated with the user
     * @param salt
     *            The salt for the hashed salted password, often
     *            this is a value associated with the user
     * @return True if the attempted password and salt hashes to the hashed
     *         salted
     *         password
     */
    protected boolean doesPasswordMatch(String attemptedPassword,
        byte[] hashedSaltedPassword, byte[] salt) {

        byte[] attemptedSaltedPasswordHash =
            hashPasswordAndSalt(attemptedPassword, salt);

        return Arrays.equals(attemptedSaltedPasswordHash, hashedSaltedPassword);
    }

    /**
     * Encode a byte array to a Base64 encoded string.
     *
     * @param data
     *            The byte array to encode
     * @return The Base64 encoded string
     */
    protected String base64Encode(byte[] data) {
        return Base64.getEncoder().encodeToString(data);
    }

    /**
     * Decode a Base64 encoded string to a byte array.
     *
     * @param data
     *            The Base64 encoded string
     * @return The resulting byte array
     */
    protected byte[] base64Decode(String data) {
        return Base64.getDecoder().decode(data);
    }

    /**
     * Demonstrate the process for hashing a new password. This is the process a
     * password would go through when being initially set by a user.
     *
     * @see #SALT_AND_PASSWORD_BASE64_SEPARATOR
     * @param newPassword
     *            The new password to be hashed.
     * @return The Base64 encoded salt and salted password hash separated by a
     *         character to allow them to be split apart
     */
    @SuppressWarnings("unused")
    public String hashNewPassword(String newPassword) {
        // Generate new salt
        byte[] newSalt = generateSalt(SALT_LENGTH);

        // Create salted hash for new password
        byte[] newSaltedPasswordHash =
            hashPasswordAndSalt(newPassword, newSalt);

        // Base64 encode the new salted password and salt
        return base64Encode(newSalt) + SALT_AND_PASSWORD_BASE64_SEPARATOR
            + base64Encode(newSaltedPasswordHash);

    }

}
