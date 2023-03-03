package org.jfree.data.test.DataUtilitiesTests;

import static org.junit.Assert.*;

import org.jfree.data.DataUtilities;
import org.jfree.data.Values2D;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import org.jmock.Mockery;
import org.jmock.Expectations;
//to test DataUtilities functions, equal and clone
public class EqualCloneTest{
	
	@BeforeClass public static void setUpBeforeClass() throws Exception {
    }


    @Before
    public void setUp() throws Exception {
    }
    
    //// Tests for equal(double[][] a, double[][] b) ////
    
    @Test
    public void testEqualArrays() {
        // setup
    	double[][] a = {{1.0, 2.0, 3.0, 4.0}, {5.0, 6.0, 7.0, 8.0}};
    	double[][] b = {{1.0, 2.0, 3.0, 4.0}, {5.0, 6.0, 7.0, 8.0}};
        
        // exercise	
        boolean result = DataUtilities.equal(a, b);
        // verify
        assertEquals(true, result);
        // tear-down: NONE in this test method
    }
    
    @Test
    public void testFirstArrayNull() {
        // setup
    	double[][] b = {{1.0, 2.0, 3.0, 4.0}, {5.0, 6.0, 7.0, 8.0}};
        
        // exercise	
        boolean result = DataUtilities.equal(null, b);
        // verify
        assertEquals(false, result);
        // tear-down: NONE in this test method
    }
    
    @Test
    public void testSecondArrayNull() {
        // setup
    	double[][] a = {{1.0, 2.0, 3.0, 4.0}, {5.0, 6.0, 7.0, 8.0}};
        
        // exercise	
        boolean result = DataUtilities.equal(a, null);
        // verify
        assertEquals(false, result);
        // tear-down: NONE in this test method
    }
    
    @Test
    public void testBothNull() {
        // setup
        
        // exercise	
        boolean result = DataUtilities.equal(null, null);
        // verify
        assertEquals(true, result);
        // tear-down: NONE in this test method
    }
    
    @Test
    public void testDifferentLength() {
        // setup
    	double[][] a = {{1.0, 2.0, 3.0, 4.0}, {5.0, 6.0, 7.0, 8.0}};
    	double[][] b = {{1.0, 2.0, 3.0, 4.0}, {5.0, 6.0, 7.0, 8.0}, {9.0, 10.0, 11.0, 12.0}};
        
        // exercise	
        boolean result = DataUtilities.equal(a, b);
        // verify
        assertEquals(false, result);
        // tear-down: NONE in this test method
    }
    
    @Test
    public void testUnequalArrays() {
        // setup
    	double[][] a = {{1.0, 2.0, 3.0, 4.0}, {5.0, 6.0, 7.0, 8.0}};
    	double[][] b = {{2.0, 4.0, 6.0, 8.0}, {10.0, 12.0, 14.0, 16.0}};
        
        // exercise	
        boolean result = DataUtilities.equal(a, b);
        // verify
        assertEquals(false, result);
        // tear-down: NONE in this test method
    }
    
	////Tests for clone(double[][] source) ////
    
    @Test
    public void testValidSource() {
        // setup
    	double[][] a = {{1.0, 2.0, 3.0, 4.0}, {5.0, 6.0, 7.0, 8.0}};
        
        // exercise	
        double[][] clone = DataUtilities.clone(a);
        boolean result = DataUtilities.equal(clone, a);
        // verify
        assertEquals(true, result);
        // tear-down: NONE in this test method
    }
    
    @Test
    public void testNullSource() {
        // setup
    	double[][] a = {null, {5.0, 6.0, 7.0, 8.0}};
        
        // exercise	
        double[][] clone = DataUtilities.clone(a);
        boolean result = DataUtilities.equal(clone, a);
        // verify
        assertEquals(true, result);
        // tear-down: NONE in this test method
    }


    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

}
