package org.jfree.data.test.RangeTests;

import static org.junit.Assert.*; import org.jfree.data.Range; import org.junit.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;

public class ToStringTest{
	private Range validRange;
    @BeforeClass public static void setUpBeforeClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    	validRange = new Range(4,7);//valid range
    }

    //testing with validRange = (4.0,7.0)
	@Test
	public void testToString() {
		String expected = "Range[4.0,7.0]";
		String actual = validRange.toString();
		assertEquals(expected, actual);
	}

    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}
