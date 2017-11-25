

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class MultiDayEventTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class MultiDayEventTest
{
    /**
     * Default constructor for test class MultiDayEventTest
     */
    public MultiDayEventTest()
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
    public void TestWithinQueryRange()
    {
        MultiDayEvent multiDay1 = new MultiDayEvent("fun event", "11/07/2017 11/10/2017", "Simon", "fun", "EMCD, GBMA, Sports");
        assertEquals(true, multiDay1.withinQueryRange("11/06/2017", "11/10/2017"));
        assertEquals(true, multiDay1.withinQueryRange("11/07/2017", "11/10/2017"));
        assertEquals(true, multiDay1.withinQueryRange("11/9/2017", "11/10/2017"));
        assertEquals(false, multiDay1.withinQueryRange("11/9/2016", "11/10/2016"));        
    }
}


