

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class TypeTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class TypeTest
{
    /**
     * Default constructor for test class TypeTest
     */
    public TypeTest()
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
        Type type1 = new Type("Art");
        assertEquals(true, type1.match("art"));
        assertEquals(true, type1.match("Art"));
        assertEquals(false, type1.match("Athletic"));
    }
}

