package edu.skidmore.cs326.spring2022.skribbage.common.test;

import edu.skidmore.cs326.spring2022.skribbage.common.Location;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.*;
import static org.junit.Assert.assertNotEquals;

/**
 * @author Alex Carney
 */
public class LocationTest {

    /**
     * Test instance.
     */
    private Location testInstance;

    /**
     * Test instance two.
     */
    private Location testInstanceTwo;

    /**
     * Test instance three.
     */
    private Location testInstanceThree;

    /**
     * Row testing value.
     */
    private static final Integer ROW_TEST_VALUE = 5;

    /**
     * Column testing values.
     */
    private static final Integer COL_TEST_VALUE = 10;

    /**
     * Logger instance for logging.
     */
    private static final Logger LOG;

    static {
        LOG = Logger.getLogger(LocationTest.class);
    }

    /**
     * Setup before testing.
     */
    @Before
    public void setup() {
        testInstance = new Location(ROW_TEST_VALUE, COL_TEST_VALUE);
        testInstanceTwo = new Location(ROW_TEST_VALUE, COL_TEST_VALUE);
        testInstanceThree = new Location(ROW_TEST_VALUE * 2, COL_TEST_VALUE * 2);
    }

    /**
     * Get row testing.
     */
    @Test
    public void testGetRow() {
        assertNotNull(testInstance);
        assertEquals(testInstance.getRow(), ROW_TEST_VALUE);
    }

    /**
     * Get column testing.
     */
    @Test
    public void testGetCol() {
        assertEquals(testInstance.getColumn(), COL_TEST_VALUE);
    }

    /**
     * Equality test.
     */
    @Test
    public void testEquality() {
        assertEquals(testInstance, testInstanceTwo);
    }

    /**
     * Inequality testing.
     */
    @Test
    public void testInequality() {
        assertNotEquals(testInstance, testInstanceThree);
    }
}
