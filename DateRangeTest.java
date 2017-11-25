

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class DateRangeTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class DateRangeTest
{
    /**
     * Default constructor for test class DateRangeTest
     */
    public DateRangeTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void TestWithinRange()
    {
        DateRange testDateRange = new DateRange("11/06/2017", "11/08/2017");
        assertEquals(true, testDateRange.withinRange("11/06/2017", "11/09/2017"));
        assertEquals(true, testDateRange.withinRange("11/05/2017", "11/08/2017"));
        assertEquals(true, testDateRange.withinRange("11/05/2017", "11/09/2017"));
        assertEquals(true, testDateRange.withinRange("05/05/2015", "08/24/2018"));
        assertEquals(false, testDateRange.withinRange("11/09/2017", "08/24/2018"));
    }

}


