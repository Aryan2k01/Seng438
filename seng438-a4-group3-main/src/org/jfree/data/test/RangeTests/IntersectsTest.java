package org.jfree.data.test.RangeTests;

import static org.junit.Assert.*; import org.jfree.data.Range; import org.junit.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;

public class IntersectsTest{
	private Range validRange;
    @BeforeClass public static void setUpBeforeClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    	validRange = new Range(4,7);//valid range
    }
    
    //------testing intersects(double b0, double b1)---------
    //testing with b0 = 1 and b1 = 5, so b0<=lower and b1>lower
	@Test
	public void testB0LessB1Greater() {
		Assert.assertTrue("Should return true", validRange.intersects(1,5));//should return true
	}
    //testing with b0 = 5 and b1 = 5, so b0>lower and b1>=b0
	@Test
	public void testB0GreaterB1Greater() {
		Assert.assertTrue("Should return true", validRange.intersects(5,5));//should return true
	}
	
	//--------testing intersects(Range range)------
    //testing with valid range = (5,8). Does (5,8) intersect this =(4,7)?
	@Test
	public void testRangeArgument() {
		Range r = new Range(5,8);
		Assert.assertTrue("Should return true", validRange.intersects(r));//should return true
	}
	
    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}
