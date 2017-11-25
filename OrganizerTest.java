

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class OrganizerTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class OrganizerTest
{
    /**
     * Default constructor for test class OrganizerTest
     */
    public OrganizerTest()
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
    public void TestContains()
    {
        Organizer testList = new Organizer("Sports, Arts, Maths");
        assertEquals(true, testList.contains("arts"));    // contains organization but does not capitalize first letter, still expects true
        assertEquals(true, testList.contains("Sports"));        
        assertEquals(false, testList.contains("English"));    // does not contain organization, expects false        
    }
}

