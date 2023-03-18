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
//to test DataUtilities functions, calculateColumnTotal and calculateColumnTotal
public class ColumnRowTest2{
	
	@BeforeClass public static void setUpBeforeClass() throws Exception {
    }


    @Before
    public void setUp() throws Exception {
    }
    
    //// Tests for calculateColumnTotal(Values2D data, int column, int[] validRows) ////
    
    @Test
    public void calculateColumnTotalForValidRows() {
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
        int[] validRows = {0};
        // exercise	
        double result = DataUtilities.calculateColumnTotal(values, 0, validRows);
        // verify
        assertEquals(7.5, result, .000000001d);
        // tear-down: NONE in this test method
    }
    
    @Test
    public void calculateColumnTotalForLargeInvalidRow() {
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
        int[] validRows = {5};
        // exercise	
        double result = DataUtilities.calculateColumnTotal(values, 0, validRows);
        // verify
        assertEquals(0.0, result, .000000001d);
        // tear-down: NONE in this test method
    }
    
    @Test
    public void calculateColumnTotalForNullValue() {
        // setup
        Mockery mockingContext = new Mockery();
        final Values2D values = mockingContext.mock(Values2D.class);
        mockingContext.checking(new Expectations() {
            {
            	// Number of rows is 2.
                one(values).getRowCount();
                will(returnValue(2));
                // Value at row 0 column 0 is null.
                one(values).getValue(0, 0);
                will(returnValue(null));
                // Value at row 1 column 0 is 2.5.
                one(values).getValue(1, 0);
                will(returnValue(2.5));
            }
        });
        int[] validRows = {0};
        // exercise	
        double result = DataUtilities.calculateColumnTotal(values, 0, validRows);
        // verify
        assertEquals(0.0, result, .000000001d);
        // tear-down: NONE in this test method
    }
    
    
    
    //// Tests for calculateRowTotal(Values2D data, int row, int[] validCols) ////
    
    @Test
    public void calculateRowTotalForValidColumns() {
        // setup
        Mockery mockingContext = new Mockery();
        final Values2D values = mockingContext.mock(Values2D.class);
        mockingContext.checking(new Expectations() {
            {
            	// Number of columns is 2.
                one(values).getColumnCount();
                will(returnValue(2));
                // Value at row 0 column 0 is 7.5.
                one(values).getValue(0, 0);
                will(returnValue(7.5));
                // Value at row 0 column 1 is 2.5.
                one(values).getValue(0, 1);
                will(returnValue(2.5));
            }
        });
        int[] validCols = {0};
        // exercise	
        double result = DataUtilities.calculateRowTotal(values, 0, validCols);
        // verify
        assertEquals(7.5, result, .000000001d);
        // tear-down: NONE in this test method
    }
    
    @Test
    public void calculateRowTotalForLargeInvalidColumns() {
        // setup
        Mockery mockingContext = new Mockery();
        final Values2D values = mockingContext.mock(Values2D.class);
        mockingContext.checking(new Expectations() {
            {
            	// Number of columns is 2.
                one(values).getColumnCount();
                will(returnValue(2));
                // Value at row 0 column 0 is 7.5.
                one(values).getValue(0, 0);
                will(returnValue(7.5));
                // Value at row 0 column 1 is 2.5.
                one(values).getValue(0, 1);
                will(returnValue(2.5));
            }
        });
        int[] validCols = {5};
        // exercise	
        double result = DataUtilities.calculateRowTotal(values, 0, validCols);
        // verify
        assertEquals(0.0, result, .000000001d);
        // tear-down: NONE in this test method
    }
    
    @Test
    public void calculateRowTotalForNullValue() {
        // setup
        Mockery mockingContext = new Mockery();
        final Values2D values = mockingContext.mock(Values2D.class);
        mockingContext.checking(new Expectations() {
            {
            	// Number of columns is 2.
                one(values).getColumnCount();
                will(returnValue(2));
                // Value at row 0 column 0 is null.
                one(values).getValue(0, 0);
                will(returnValue(null));
                // Value at row 0 column 1 is 2.5.
                one(values).getValue(0, 1);
                will(returnValue(2.5));
            }
        });
        int[] validCols = {0};
        // exercise	
        double result = DataUtilities.calculateRowTotal(values, 0, validCols);
        // verify
        assertEquals(0.0, result, .000000001d);
        // tear-down: NONE in this test method
    }
    
    @Test
    public void calculateRowTotalForInvalidColumnCount() {
        // setup
        Mockery mockingContext = new Mockery();
        final Values2D values = mockingContext.mock(Values2D.class);
        mockingContext.checking(new Expectations() {
            {
            	// Number of columns is invalid.
                one(values).getColumnCount();
                will(returnValue(-1));
                
            }
        });
        int[] validCols = {0};
        // exercise	
        double result = DataUtilities.calculateRowTotal(values, 0, validCols);
        // verify
        assertEquals(0.0, result, .000000001d);
        // tear-down: NONE in this test method
    }
    
    // Mutation Tests
    
    @Test (expected = IllegalArgumentException.class)
    public void calculateColumnTotalForNullMutant() {
        // setup
        Values2D data = null;
        int[] validRows = {0};
        // exercise	
        double result = DataUtilities.calculateColumnTotal(data, 0, validRows);
        // verify
        assertEquals(7.5, result, .000000001d);
        // tear-down: NONE in this test method
    }


    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

}
