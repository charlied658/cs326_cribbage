package edu.skidmore.cs326.spring2022.skribbage.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import edu.skidmore.cs326.spring2022.skribbage.SkribbagePropertiesManager;

/**
 * Unit tests for SkribbagePropeties.
 * 
 * @author readda
 */
public class SkribbagePropertiesManagerTest {
    /**
     * Verify that at least one property was loaded.
     */
    @Test
    public void testPropertiesLoaded() {
        assertTrue("No properties loaded",
            SkribbagePropertiesManager.getInstance().getNumProperties() > 0);
    }

    /**
     * The GUI library minimum version should be defined in the properties file.
     */
    @Test
    public void testGUIMinValueProperty() {
        assertNotNull("GUI minimum version was not found in properties file",
            SkribbagePropertiesManager.getInstance()
                .getProperty("GUILibraryMinVersion"));
    }
}
