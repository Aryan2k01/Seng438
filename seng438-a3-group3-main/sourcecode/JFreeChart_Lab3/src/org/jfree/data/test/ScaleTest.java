package org.jfree.data.test;

import static org.junit.Assert.*;
import java.lang.IllegalArgumentException;

import org.jfree.data.DataUtilities;
import org.jfree.data.Range; import org.junit.*;

public class ScaleTest{
	private Range validRange;
    @BeforeClass public static void setUpBeforeClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    	validRange = new Range(4,7);//valid range
    }
    
    //testing with factor = -2, so factor<0
    @Test (expected = IllegalArgumentException.class)
    public void testNegativeFactor() throws IllegalArgumentException{
    	Range r = Range.scale(validRange, -2);//should throw
    }
    //testing with factor = 2
    @Test
    public void testPositiveFactor(){
    	Range expected = new Range(8,14);
    	Assert.assertEquals("Should return (8,14)",expected, Range.scale(validRange, 2));//should return (8,14)
    }
    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}
