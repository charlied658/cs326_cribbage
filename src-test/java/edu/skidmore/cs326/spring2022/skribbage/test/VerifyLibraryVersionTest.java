package edu.skidmore.cs326.spring2022.skribbage.test;

import static org.junit.Assert.assertNull;

import org.junit.Test;

import edu.skidmore.cs326.spring2022.skribbage.util.VerifyLibraryVersion;

/**
 * Unit tests for VerifyLibraryVersion.
 * 
 * @author readda
 */
public class VerifyLibraryVersionTest {
    /**
     * Test the checkGraphicsLibraryMminVersion method. Assumes the correct
     * library is on the classpath.
     */
    @Test
    public void testcheckGraphicsLibraryMinVersion() {
        assertNull("Incorrect version of the graphics library found",
            VerifyLibraryVersion.getInstance()
                .checkGraphicsLibraryMinVersion());
    }
}
