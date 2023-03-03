package org.jfree.data.test;

import static org.junit.Assert.*;
import org.jfree.data.DataUtilities;
import org.junit.*;
import org.jmock.Mockery;
import org.jmock.Expectations;
import org.jfree.data.KeyedValues;

import java.util.*;

public class GetCumulativePercentagesTest {
	
    //testing getCumulativePercentages(KeyedValues data) for P1: valueA>0, valueB>0
	@Test
	public void testPosCumulativePercentages() {
		// setup
	    Mockery mockingContext = new Mockery();
	    final KeyedValues values = mockingContext.mock(KeyedValues.class);
	    mockingContext.checking(new Expectations() {
	        {
	        	//KeyedValues object {(0,3),(1,4)}
	            allowing(values).getIndex(0);
	            will(returnValue(0));
	            allowing(values).getIndex(1);
	            will(returnValue(1));
	            allowing(values).getKey(0);
	            will(returnValue(0));
	            allowing(values).getKey(1);
	            will(returnValue(1));
	            allowing(values).getKeys();
	            List<Integer> keys = Arrays.asList(0,1);//list to store keys as integers
	            will(returnValue(keys));
	            allowing(values).getValue(0);
	            will(returnValue(3));
	            allowing(values).getValue(1);
	            will(returnValue(4));
	            allowing(values).getItemCount();
	            will(returnValue(2));
	        }
	    });
	    
	    KeyedValues result = DataUtilities.getCumulativePercentages(values);
	    
	    Assert.assertEquals("Returned value at key 0 should be 0.4286",
	           0.4286, (Double)result.getValue(0), .000000001d);
	    Assert.assertEquals("Returned value at key 1 should be 1.0",
		           1.0, (Double)result.getValue(1), .000000001d);
	}
	
	//testing getCumulativePercentages(KeyedValues data) for P2: valueA<0, valueB>0
	    @Test
		public void testNegPosCumulativePercentages() {
			// setup
		    Mockery mockingContext = new Mockery();
		    final KeyedValues values = mockingContext.mock(KeyedValues.class);
		    mockingContext.checking(new Expectations() {
		        {
		        	//KeyedValues object {(0,-9),(1,9.6), (2,2)}
		            allowing(values).getIndex(0);
		            will(returnValue(0));
		            allowing(values).getIndex(1);
		            will(returnValue(1));
		            allowing(values).getIndex(2);
		            will(returnValue(2));
		            allowing(values).getKey(0);
		            will(returnValue(0));
		            allowing(values).getKey(1);
		            will(returnValue(1));
		            allowing(values).getKey(2);
		            will(returnValue(2));
		            allowing(values).getKeys();
		            List<Integer> keys = Arrays.asList(0,1,2);//list to store keys as integers
		            will(returnValue(keys));
		            allowing(values).getValue(0);
		            will(returnValue(-9));
		            allowing(values).getValue(1);
		            will(returnValue(9.6));
		            allowing(values).getValue(2);
		            will(returnValue(2));
		            allowing(values).getItemCount();
		            will(returnValue(3));
		        }
		    });
		    
		    KeyedValues result = DataUtilities.getCumulativePercentages(values);
		    
		    assertEquals("Returned value at key 0 should be -0.4368",
		           -0.4368, (Double)result.getValue(0), .000000001d);
		    assertEquals("Returned value at key 1 should be 0.23076923",
			           0.23076923, (Double)result.getValue(1), .000000001d);
		    assertEquals("Returned value at key 2 should be 1.0",
			           1.0, (Double)result.getValue(2), .000000001d);
	    
	}
	  //testing getCumulativePercentages(KeyedValues data) for P3: valueA=0, valueB>0
	    @Test
		public void testOneZeroCumulativePercentages() {
			// setup
		    Mockery mockingContext = new Mockery();
		    final KeyedValues values = mockingContext.mock(KeyedValues.class);
		    mockingContext.checking(new Expectations() {
		        {
		        	//KeyedValues object {(0,7),(1,0), (2,2)}
		            allowing(values).getIndex(0);
		            will(returnValue(0));
		            allowing(values).getIndex(1);
		            will(returnValue(1));
		            allowing(values).getIndex(2);
		            will(returnValue(2));
		            allowing(values).getKey(0);
		            will(returnValue(0));
		            allowing(values).getKey(1);
		            will(returnValue(1));
		            allowing(values).getKey(2);
		            will(returnValue(2));
		            allowing(values).getKeys();
		            List<Integer> keys = Arrays.asList(0,1,2);//list to store keys as integers
		            will(returnValue(keys));
		            allowing(values).getValue(0);
		            will(returnValue(7));
		            allowing(values).getValue(1);
		            will(returnValue(0));
		            allowing(values).getValue(2);
		            will(returnValue(2));
		            allowing(values).getItemCount();
		            will(returnValue(3));
		        }
		    });
		    
		    KeyedValues result = DataUtilities.getCumulativePercentages(values);
		    
		    assertEquals("Returned value at key 0 should be 0.777",
		           0.777, (Double)result.getValue(0), .000000001d);
		    assertEquals("Returned value at key 1 should be 0.777",
			           0.777, (Double)result.getValue(1), .000000001d);
		    assertEquals("Returned value at key 2 should be 1.0",
			           1.0, (Double)result.getValue(2), .000000001d);

	}

}
