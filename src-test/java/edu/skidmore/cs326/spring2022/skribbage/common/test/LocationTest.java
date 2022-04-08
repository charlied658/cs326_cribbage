package edu.skidmore.cs326.spring2022.skribbage.common.test;

import edu.skidmore.cs326.spring2022.skribbage.common.Location;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.*;
import static org.junit.Assert.assertNotEquals;

public class LocationTest {

    /**
     * Test instance
     */
    private Location testInstance;

    private static final Integer ROW_TEST_VALUE = 5;

    private static final Integer COL_TEST_VALUE = 10;

    /**
     * Logger instance for logging.
     */
    private static final Logger LOG;

    static {
        LOG = Logger.getLogger(UserTest.class);
    }

    @Before
    public void setup() {
        testInstance = new Location(ROW_TEST_VALUE, COL_TEST_VALUE);
    }

    @Test
    public void testGetRow() {
        assertNotNull(testInstance);
        assertEquals(testInstance.getRow(), ROW_TEST_VALUE);
    }

    @Test
    public void testGetCol() {
        assertEquals(testInstance.getColumn(), COL_TEST_VALUE);
    }

    @Test
    public void testEquality() {
        Location testInstanceTwo = new Location(ROW_TEST_VALUE, COL_TEST_VALUE);
        assertEquals(testInstance, testInstanceTwo);
    }

    @Test
    public void testInequality() {
        Location testInstanceThree = new Location(ROW_TEST_VALUE*2, COL_TEST_VALUE*2);
        assertNotEquals(testInstance, testInstanceThree);
    }
}
