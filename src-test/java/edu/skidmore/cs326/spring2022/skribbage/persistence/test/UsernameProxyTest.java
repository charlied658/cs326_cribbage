package edu.skidmore.cs326.spring2022.skribbage.persistence.test;

import edu.skidmore.cs326.spring2022.skribbage.persistence.UsernameProxy;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * username proxy test for password check.
 * 
 * @author Nikoleta Chantzi
 */


public class UsernameProxyTest {

    /**
     * instance.
     */
    private UsernameProxy usernameProxyinstance = new UsernameProxy();

    /**
     * Testing usernameCheck with appropriate password
     */
    @Test
    public void usernameCheckSuccess() {
        Boolean verification = usernameProxyinstance.usernameCheck("nchantzi");
        assertEquals("Username should get accepted", true, verification);
    }

    /**
     * Testing usernameCheck with inappropriate password
     */
    @Test
    public void usernameCheckFail() {
        Boolean verification =
            usernameProxyinstance.usernameCheck("nfuckn");
        assertEquals("Username should not get accepted", false, verification);

    }

}
