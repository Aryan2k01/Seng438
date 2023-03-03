package org.jfree.data.test;

import static org.junit.Assert.*;
import java.security.InvalidParameterException;
import java.lang.IllegalArgumentException;

import org.jfree.data.Range; import org.junit.*;

public class GetLengthTest {
	@BeforeClass public static void setUpBeforeClass() throws Exception {
    }


    @Before
    public void setUp() throws Exception {
    }
    //testing getLength for P1: lower = 0, upper=0
    @Test
    public void testZeroGetLength() {
    	Range myRange = new Range(0,0);
        assertEquals("The length of the range (0,0) should be 0",
        0, myRange.getLength(), 0);
    }
    //testing getLength for P2: lower<0, upper<0
    @Test
    public void testNegativeGetLength() {
    	Range myRange = new Range(-19,-1.5);
        assertEquals("The length of the range (-19,-1.5) should be 17.5",
        17.5, myRange.getLength(), 0);
    }
    //testing getLength for P3: lower<0, upper>0
    @Test
    public void testNegPosGetLength() {
    	Range myRange = new Range(-5.5,8.977);
        assertEquals("The length of the range (-5.5,8.977) should be 14.477",
        14.477, myRange.getLength(), 0);
    }
   
    //assignment 3
    //testing getLength for lower>upper which should throw exception
    @Test (expected = IllegalArgumentException.class)
    public void testLowerGreaterThanUpper() throws IllegalArgumentException{
    	Range myRange = new Range(8.977, -5.5);//lower = 8.977, upper = -5.5
    	myRange.getLength();//should throw illegal argument exception
    }
    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}
