package org.jfree.data.test.RangeTests;

import static org.junit.Assert.*; import org.jfree.data.Range; import org.junit.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;

public class ExpandToIncludeTest {
	private Range validRange;
	private Range nullRange;
    @BeforeClass public static void setUpBeforeClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    	validRange = new Range(4,7);//valid range
    }
    
    //testing with range = nullRange, value = 5
	@Test
	public void testNullRange() {
		Range expected = new Range (5,5);
		assertEquals("Should return (5,5)", expected, Range.expandToInclude(nullRange, 5));//should return (5,5)
	}
    //testing with range = validRange=(4,7), value = 1, so value<range.lower
	@Test
	public void testValueLessThanLower() {
		Range expected = new Range (1,7);
		assertEquals("Should return (1,7)", expected, Range.expandToInclude(validRange, 1));//should return (1,7)
	}
    //testing with range = validRange=(4,7), value = 10, so value>range.upper
	@Test
	public void testValueGreaterThanUpper() {
		Range expected = new Range (4,10);
		assertEquals("Should return (4,10)", expected, Range.expandToInclude(validRange, 10));//should return (1,10)
	}
    //testing with range = validRange=(4,7), value = 1, so value<range.lower
	@Test
	public void testValueWithinRange() {
		assertEquals("Should return (4,7)", validRange, Range.expandToInclude(validRange, 5));//should return (4,7)
	}
 
    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}
