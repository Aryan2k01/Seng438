package org.jfree.data.test;

import static org.junit.Assert.*; import org.jfree.data.Range; import org.junit.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;

public class ShiftTest{
	private Range validRange;
    @BeforeClass public static void setUpBeforeClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    	validRange = new Range(4,7);//valid range
    }
    
    //-------testing shift(Range base, double delta, boolean allowZeroCrossing)--------------
    //testing with base = (4,7), delta = -5 allowZeroCrossing = true
	@Test
	public void testAllowZeroCrossing() {
		Range expected = new Range(-1,2);
		Assert.assertEquals("Should return (-1,2)", expected, Range.shift(validRange,-5,true));//should return (-1,2)
	}
    //testing with base = (-1,7), delta = -5, allowZeroCrossing = false
	@Test
	public void testNoZeroCrossing() {
		Range input = new Range(-1,7);
		Range expected = new Range(-6,2);
		Assert.assertEquals("Should return (-6,2)", expected, Range.shift(input,-5,false));//should return (-6,2)
	}
	
	//---------testing shift(Range base, double delta)-----------
    //testing with base = (0,7), delta = -5
	@Test
	public void testTwoArguments() {
		Range input = new Range(0,7);
		Range expected = new Range(-5,2);
		Assert.assertEquals("Should return (-5,2)", expected, Range.shift(input,-5));//should return (-5,2)
	}
    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}
