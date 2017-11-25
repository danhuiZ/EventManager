

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class NameTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class NameTest
{
    /**
     * Default constructor for test class NameTest
     */
    public NameTest()
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
    public void TestMatch()
    {
        Name name1 = new Name("Lutron Open House");
        assertEquals(true, name1.match("Lutron open house"));    // true even if cases are different
        assertEquals(false, name1.match("Lutron openhouse"));
        assertEquals(true, name1.match("Lutron Open House"));
    }
}

