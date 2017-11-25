

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class SingleDateTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class SingleDateTest
{
    /**
     * Default constructor for test class SingleDateTest
     */
    public SingleDateTest()
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
    public void TestToString()
    {
        SingleDate today = new SingleDate("11/07/2017");
        System.out.println(today.toString());
        assertEquals("11/07/2017", today.toString());
    }

    @Test
    public void TestWithinRange()
    {
        SingleDate today = new SingleDate("11/07/2017");
        assertEquals(true, today.withinRange("11/07/2017", "11/09/2017"));    // start date contains test date
        assertEquals(true, today.withinRange("11/06/2017", "11/09/2017"));    // range contains test date
        assertEquals(true, today.withinRange("11/06/2017", "11/07/2017"));    // end date contains test date
        assertEquals(false, today.withinRange("11/08/2017", "11/09/2017"));    // query range does not contain test date    
    }

    @Test
    public void TestMatch()
    {
        SingleDate today = new SingleDate("11/07/2017");
        assertEquals(true, today.match("11/07/2017"));
        assertEquals(false, today.match("07/11/2017"));
    }
}



