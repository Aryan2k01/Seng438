package org.jfree.data.test;

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

public class CalculateColumnTotalTest{
	
	@BeforeClass public static void setUpBeforeClass() throws Exception {
    }


    @Before
    public void setUp() throws Exception {
    }
    
    //// Tests for calculateColumnTotal ////
    //testing calculateColumnTotal(Values2D data, int column) for P1: column<0
    @Test
    public void calculateColumnTotalForInvalidColumn() {
        // setup
        Mockery mockingContext = new Mockery();
        final Values2D values = mockingContext.mock(Values2D.class);
        mockingContext.checking(new Expectations() {
            {
            	// Number of rows is 2.
                one(values).getRowCount();
                will(returnValue(2));
                // Value at row 0 column -1 is null.
                one(values).getValue(0, -1);
                will(returnValue(null));
                // Value at row 1 column -1 is null.
                one(values).getValue(1, -1);
                will(returnValue(null));
            }
        });
        // exercise	
        double result = DataUtilities.calculateColumnTotal(values, -1);
        // verify
        assertEquals(0.0, result, .000000001d);
        // tear-down: NONE in this test method
    }
    
  //testing calculateColumnTotal(Values2D data, int column) for P2: rowCount = 0
    @Test
    public void calculateColumnTotalForZeroRows() {
        // setup
        Mockery mockingContext = new Mockery();
        final Values2D values = mockingContext.mock(Values2D.class);
        mockingContext.checking(new Expectations() {
            {
            	// Number of rows is 0.
                one(values).getRowCount();
                will(returnValue(0));
            }
        });
        // exercise	
        double result = DataUtilities.calculateColumnTotal(values, 0);
        // verify
        assertEquals(0.0, result, .000000001d);
        // tear-down: NONE in this test method
    }
    
  //testing calculateColumnTotal(Values2D data, int column) for P3: column>=0, rowCount>0
    @Test
    public void calculateColumnTotalForTwoValues() {
        // setup
        Mockery mockingContext = new Mockery();
        final Values2D values = mockingContext.mock(Values2D.class);
        mockingContext.checking(new Expectations() {
            {
            	// Number of rows is 2.
                one(values).getRowCount();
                will(returnValue(2));
                // Value at row 0 column 0 is 7.5.
                one(values).getValue(0, 0);
                will(returnValue(7.5));
                // Value at row 1 column 0 is 2.5.
                one(values).getValue(1, 0);
                will(returnValue(2.5));
            }
        });
        // exercise	
        double result = DataUtilities.calculateColumnTotal(values, 0);
        // verify
        assertEquals(10.0, result, .000000001d);
        // tear-down: NONE in this test method
    }
    
    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

}

