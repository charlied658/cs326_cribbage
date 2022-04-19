package edu.skidmore.cs326.spring2022.skribbage.common;

/**
 * Operations of a PasswordHasher.
 * 
 * @author Declan Morris
 */
public interface PasswordHashing {
    /**
     * Generate a random salt to be attached to a password.
     * @param length of the salt (should be a constant)
     * @return salt
     */
    byte[] generateSalt(int length);

    /**
     * Create a hash of a password and add salt.
     * 
     * @param salt
     *            to add
     * @param password
     *            to hash
     * @return hashed and salted password value.
     */
    byte[] hashPasswordAndSalt(String password, byte[] salt);

    /**
     * Determines if an entered password matches a stored one.
     * 
     * @param password
     *            the password value entered
     * @param hashedSaltedPassword
     *            the stored value to be compared against
     * @param salt
     *            the salt used to salt the password
     * @return doesPasswordMatch
     */
    boolean doesPasswordMatch(String password, byte[] hashedSaltedPassword,
        byte[] salt);

    /**
     * Encode a byte array into a base64 encoded string.
     * 
     * @param data
     * @return the encoded string
     */
    String base64Encode(byte[] data);

    /**
     * Decode a base64 encoded string to a byte array.
     * 
     * @param data
     * @return the byte array
     */
    byte[] base64Decode(String data);

    /**
     * Generate a random salt to add and hash a newly created password.
     * 
     * @param password
     *            the password value
     * @return the hashed password value
     */
    String hashNewPassword(String password);

}
