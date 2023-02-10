package org.jfree.data.test;

import static org.junit.Assert.*;
import org.jfree.data.DataUtilities;
import org.junit.*;
import org.jmock.Mockery;
import org.jmock.Expectations;
import org.jfree.data.KeyedValues;
import java.util.*;

public class DataUtilitiesTest {
	
	@Test
	public void testPosCumulativePercentages() {
		// setup
	    Mockery mockingContext = new Mockery();
	    final KeyedValues values = mockingContext.mock(KeyedValues.class);
	    mockingContext.checking(new Expectations() {
	        {
	        	//KeyedValues object {(0,3),(1,4)}
	            one(values).getIndex(0);
	            will(returnValue(0));
	            one(values).getIndex(1);
	            will(returnValue(1));
	            one(values).getKey(0);
	            will(returnValue(0));
	            one(values).getKey(1);
	            will(returnValue(1));
	            one(values).getKeys();
	            List<Integer> keys = Arrays.asList(0,1);//list to store keys as integers
	            will(returnValue(keys));
	            one(values).getValue(0);
	            will(returnValue(3));
	            one(values).getValue(1);
	            will(returnValue(4));
	            one(values).getItemCount();
	            will(returnValue(2));
	        }
	    });
	    //expected output
	    Mockery mockingContext1 = new Mockery();
	    final KeyedValues expectedValues = mockingContext1.mock(KeyedValues.class);
	    mockingContext1.checking(new Expectations() {
	        {
	        	//expected KeyedValues object {(0,0.4286),(1,1.0)}
	            one(expectedValues).getIndex(0);
	            will(returnValue(0));
	            one(expectedValues).getIndex(1);
	            will(returnValue(1));
	            one(expectedValues).getKey(0);
	            will(returnValue(0));
	            one(expectedValues).getKey(1);
	            will(returnValue(1));
	            one(expectedValues).getKeys();
	            List<Integer> keys = Arrays.asList(0,1);//list to store keys as integers
	            will(returnValue(keys));
	            one(expectedValues).getValue(0);
	            will(returnValue(0.4286));
	            one(expectedValues).getValue(1);
	            will(returnValue(1.0));
	            one(expectedValues).getItemCount();
	            will(returnValue(2));
	        }
	    });
	    
	    KeyedValues result = DataUtilities.getCumulativePercentages(values);
	    
	    assertEquals("Returned value at key 0 should be 0.4286",
	           0.4286, (Integer)result.getValue(0), .000000001d);
	    assertEquals("Returned value at key 1 should be 1.0",
		           1.0, (Integer)result.getValue(1), .000000001d);
	    
	    // tear-down: NONE in this test method
	}
	
	

}
