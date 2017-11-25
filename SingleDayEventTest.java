

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class SingleDayEventTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class SingleDayEventTest
{
    /**
     * Default constructor for test class SingleDayEventTest
     */
    public SingleDayEventTest()
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
    public void TestGetHashKey()
    {
        SingleDayEvent singleDa1 = new SingleDayEvent("fun event", "11/07/2017", "Simon", "fun", "EMCD");
        assertEquals("fun event11/07/2017", singleDa1.getKey());
        assertFalse("funevent11/07/2017".equals(singleDa1.getKey()));
    }

    @Test
    public void TestGetHashValue()
    {
        SingleDayEvent singleDa1 = new SingleDayEvent("fun event", "11/07/2017", "Simon", "fun", "EMCD, GBMA, Sports");
        assertEquals("name, fun event, date, 11/07/2017, location, Simon, type, fun, organization, EMCD, GBMA, Sports", singleDa1.getValue());
        // leaving locations and organizations to be null
        SingleDayEvent singleDa2 = new SingleDayEvent("fun event", "11/07/2017", null, "fun", null);  
        assertEquals("name, fun event, date, 11/07/2017, type, fun", singleDa2.getValue()); 
        // leaving type to be null
        SingleDayEvent singleDa3 = new SingleDayEvent("fun event", "11/07/2017", "Simon", null, "EMCD, GBMA, Sports");
        assertEquals("name, fun event, date, 11/07/2017, location, Simon, organization, EMCD, GBMA, Sports", singleDa3.getValue());        
    }
}


