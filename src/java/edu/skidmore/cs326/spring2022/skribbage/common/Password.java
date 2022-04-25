package edu.skidmore.cs326.spring2022.skribbage.common;

/**
 * Represents a hashed password. Contains the hashed password and salt.
 * Edits by Declan Morris on 4/19:
 * Commented out isHashed attribute by recommendation of Architect;
 * Passwords should always be hashed when they are created.
 * This can be done by calling hashNewPassword on a String using
 * the public LoginAuthenticator instance.
 * Edits by DSR on 4/19:
 * Fixed JavaDoc and updated to manage Base64-encoded hash information
 */
public class Password implements Payload {
    /**
     * The Base64-encoded password.
     */
    private String hashedPasswordBase64;

    /**
     * The Base64-encoded salt.
     */
    private String saltBase64;

    /**
     * Creates a new password object. The value is expected to be a Base64
     * encoded salt and password hash.
     * 
     * @see #setSaltAndPasswordBase64(String)
     * @param saltAndHashBase64
     *            The Base64 encoded salt and password hash
     */
    public Password(String saltAndHashBase64) {
        setSaltAndPasswordBase64(saltAndHashBase64);
    }

    /**
     * Sets the salt and password hash. The value is expected to be a Base64
     * encoded salt and password hash. The salt and hash are to be separated
     * using the separator character defined in the PasswordHasher class.
     * The salt is expected at the beginning of the value: saltSEPARATORhash
     * 
     * @throws IllegalArgumentException
     *             if the string is not in the correct format.
     * @see PasswordHasher#SALT_AND_PASSWORD_BASE64_SEPARATOR
     * @param saltAndHashBase64
     *            The Base64 encoded salt and password hash
     */
    private void setSaltAndPasswordBase64(String saltAndHashBase64) {
        String[] saltAndHashSplit = saltAndHashBase64
            .split(PasswordHasher.SALT_AND_PASSWORD_BASE64_SEPARATOR);

        if (saltAndHashSplit.length != 2) {
            throw new IllegalArgumentException(
                "Supplied salt and hash are not in expected format");
        }

        saltBase64 = saltAndHashSplit[0];
        hashedPasswordBase64 = saltAndHashSplit[1];
    }

    /**
     * Returns Base64-encoded hashed password.
     * 
     * @return String Base64-encoded password hash
     */
    public String getBase64PasswordHash() {
        return hashedPasswordBase64;
    }

    /**
     * Returns the Base64-encoded salt for the password.
     * 
     * @return The Base64-encoded salt
     */
    public String getBase64Salt() {
        return saltBase64;
    }

    /**
     * Returns the properly formatted Base64-encoded salt and password hash.
     * 
     * @return The Base64-encoded salt and password hash
     */
    public String getBase64SaltAndPasswordHash() {
        return getBase64Salt()
            + PasswordHasher.SALT_AND_PASSWORD_BASE64_SEPARATOR
            + getBase64PasswordHash();
    }

    @Override
    public boolean equals(Object o) {
        if (o != null && o instanceof Password) {
            return ((Password) o).getBase64SaltAndPasswordHash()
                .equals(getBase64SaltAndPasswordHash());
        }

        return false;
    }

    @Override
    public int hashCode() {
        return getBase64SaltAndPasswordHash().hashCode();
    }

    @Override
    public String toString() {
        return "Hashed password and salt";
    }
}
