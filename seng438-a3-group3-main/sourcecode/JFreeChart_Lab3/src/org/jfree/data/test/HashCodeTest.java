package org.jfree.data.test;

import static org.junit.Assert.*; import org.jfree.data.Range; import org.junit.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;

public class HashCodeTest{
	private Range validRange;
    @BeforeClass public static void setUpBeforeClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    	validRange = new Range(4,7);//valid range
    }
    
    //testing with this = validRange
	@Test
	public void testValidRange() {
		int expected = -2115239936;
		Assert.assertEquals("Should return ", expected, validRange.hashCode());//should return 
	}
	
    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}
