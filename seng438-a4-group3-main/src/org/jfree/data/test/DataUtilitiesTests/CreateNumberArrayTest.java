package org.jfree.data.test.DataUtilitiesTests;

import static org.junit.Assert.*;
import org.jfree.data.DataUtilities;
import org.junit.*;
import java.security.InvalidParameterException;

public class CreateNumberArrayTest {
	
	 //testing createNumberArray(double [] data) for P1: data value>=0
    @Test
    public void testPosCreateNumberArray() {
    	double [] input = {0.0,9.99,5.0}; //double array with 0 and positive values
    	Number [] expected = {0.0,9.99,5.0};//expected number array
    	Number[] result = DataUtilities.createNumberArray(input);
        assertArrayEquals(expected,result);
    }
  //testing createNumberArray(double [] data) for P2: data value<0
    @Test
    public void testNegCreateNumberArray() {
    	double [] input = {-7.0,-9.99,5.0}; //double array with some negative values
    	Number [] expected = {-7.0,-9.99,5.0};//expected number array
    	Number[] result = DataUtilities.createNumberArray(input);
        assertArrayEquals(expected,result);
    }
  //testing createNumberArray(double [] data) for P3: data =null array
    @Test (expected = InvalidParameterException.class)
    public void testNullCreateNumberArray() throws InvalidParameterException{
    	double [] input = null;//null double array 
    	Number []result = DataUtilities.createNumberArray(input);//should throw
    }
}
