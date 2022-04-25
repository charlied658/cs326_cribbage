import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Base64;

import org.apache.log4j.Logger;

import edu.skidmore.cs326.spring2022.skribbage.frontend.PastGamesPage;

/**
 * These examples demonstrate basic salting and hashing of a password. This
 * class is not intended as a drop-in for integrating hashing into a
 * application.
 * Missing from these examples is a carefully designed interface, good
 * documentation, and error handling.
<<<<<<< HEAD
 *
=======
 *
>>>>>>> 485058935004f9f20512f4f6529c92172d8c79ce
 * @author readda
 *     Edited by Jonah Marcus on 20 April 2022 to address Bug #48.
 */
public class DemoPasswordHashing {
    /**
     * The salt length in bytes.
     */
    private static final int SALT_LENGTH = 10;

    /**
     * The character separating the salt from the password in the Base64 encoded
     * value. This should be a character that is not used in Base64 encoding.
     */
    private static final String SALT_AND_PASSWORD_BASE64_SEPARATOR = "~";
    
    /**
     * Logger instance for logging.
     */
    private static final Logger LOG;

    static {
        LOG = Logger.getLogger(DemoPasswordHashing.class);
    }

    /**
     * Demo class, no instances should be created outside the demo.
     */
    private DemoPasswordHashing() {

    }

    /**
     * Generate a salt. This is a random set of bytes.
<<<<<<< HEAD
     *
=======
     *
>>>>>>> 485058935004f9f20512f4f6529c92172d8c79ce
     * @param length
     *            The salt's size in bytes
     * @return The salt.
     */
    private byte[] generateSalt(int length) {
        byte[] salt = new byte[length];
        new SecureRandom().nextBytes(salt);
        return salt;
    }

    /**
     * Create a SHA-256 hash of a password and salt.
<<<<<<< HEAD
     *
=======
     *
>>>>>>> 485058935004f9f20512f4f6529c92172d8c79ce
     * @param password
     *            The password to hash
     * @param salt
     *            The salt being applied to the password
     * @return The hashed salted password
     */
    private byte[] hashPasswordAndSalt(String password, byte[] salt) {
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
<<<<<<< HEAD
     *
=======
     *
>>>>>>> 485058935004f9f20512f4f6529c92172d8c79ce
     * @param attemptedPassword
     *            The password being checked, often a password entered by a user
     *            to login
     * @param hashedSaltedPassword
     *            The hash of the salted password, often this is a value
     *            associated with the user
     * @param salt
     *            The salt for the hashed salted password, often this is a vlaue
     *            associated with the user
     * @return True if the attempted password and salt hashes to the hashed
     *         salted password
     */
    private boolean doesPasswordMatch(String attemptedPassword,
        byte[] hashedSaltedPassword,
        byte[] salt) {
        byte[] attemptedSaltedPasswordHash =
            hashPasswordAndSalt(attemptedPassword, salt);

        return Arrays.equals(attemptedSaltedPasswordHash, hashedSaltedPassword);
    }

    /**
     * Encode a byte array to a Base64 encoded string.
<<<<<<< HEAD
     *
=======
     *
>>>>>>> 485058935004f9f20512f4f6529c92172d8c79ce
     * @param data
     *            The byte array to encode
     * @return The Base64 encoded string
     */
    private String base64Encode(byte[] data) {
        return Base64.getEncoder().encodeToString(data);
    }

    /**
     * Decode a Base64 encoded string to a byte array.
<<<<<<< HEAD
     *
=======
     *
>>>>>>> 485058935004f9f20512f4f6529c92172d8c79ce
     * @param data
     *            The Base64 encoded string
     * @return The resulting byte array
     */
    private byte[] base64Decode(String data) {
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
    private String demoHashingNewPassword(String newPassword) {
        // Generate new salt
        byte[] newSalt = generateSalt(SALT_LENGTH);

        // Create salted hash for new password
        byte[] newSaltedPasswordHash =
            hashPasswordAndSalt(newPassword, newSalt);

        // Base64 encode the new salted password and salt
        return base64Encode(newSalt) + SALT_AND_PASSWORD_BASE64_SEPARATOR
            + base64Encode(newSaltedPasswordHash);

    }

    /**
     * Demonstrate use of the hashing methods for three scenarios:
     * 1. Hash a new password and obtain the Base64 encoded value containing the
     * salt and salted hash
     * 2. Verify a valid password (for example, a user logging in with the
     * correct password)
     * 3. Verify an invalid password (for example, a user logging in with the
     * wrong password)
     */
    private void demoMethods() {
        // Demo salt and hash new password
        String base64SaltedPasswordHash =
            demoHashingNewPassword("myPassword123*");
        System.out
            .println("New salt and salted password hash: "
                + base64SaltedPasswordHash);

        // Demo checking a valid password attempt
        String attemptedPassword = "myPassword123*";
        String[] splitBase64SaltAndHash = base64SaltedPasswordHash
            .split(SALT_AND_PASSWORD_BASE64_SEPARATOR);
        boolean validPassword = doesPasswordMatch(attemptedPassword,
            base64Decode(splitBase64SaltAndHash[1]),
            base64Decode(splitBase64SaltAndHash[0]));
        System.out.println("Valid password accepted? " + validPassword);

        // Demo checking an invalid password attempt
        attemptedPassword = "anotherPassword";
        splitBase64SaltAndHash = base64SaltedPasswordHash
            .split(SALT_AND_PASSWORD_BASE64_SEPARATOR);
        validPassword = doesPasswordMatch(attemptedPassword,
            base64Decode(splitBase64SaltAndHash[1]),
            base64Decode(splitBase64SaltAndHash[0]));
        System.out.println("Invalid password accepted? " + validPassword);
    }

    /**
     * Run the demo.
<<<<<<< HEAD
     *
=======
     *
>>>>>>> 485058935004f9f20512f4f6529c92172d8c79ce
     * @param args
     *            Command line arguments, not used
     */
    public static void main(String[] args) {
        DemoPasswordHashing d = new DemoPasswordHashing();
        d.demoMethods();
    }
}
