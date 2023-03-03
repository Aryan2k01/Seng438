package org.jfree.data.test.RangeTests;

import static org.junit.Assert.*; import org.jfree.data.Range; import org.junit.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;

public class ExpandTest {
	private Range validRange;
    @BeforeClass public static void setUpBeforeClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    	validRange = new Range(4,7);//valid range
    }
    
    //testing with range = validRange, lowerMargin = 1, upperMargin = 10, so lower<upper
	@Test
	public void testLowerLessThanUpper() {
		Range expected = new Range (1,37);
		assertEquals("Should return (0,47)", expected, Range.expand(validRange, 1, 10));//should return (0,47)
	}
    //testing with range = validRange, lowerMargin = -10, upperMargin = 1, so lower>upper
	@Test
	public void testLowerGreaterThanUpper() {
		Range expected = new Range (22,22);
		assertEquals("Should return (22,22)", expected, Range.expand(validRange, -10, 1));//should return (22,22)
	}
	
 
    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}
