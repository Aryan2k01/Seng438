package org.jfree.data.test;


import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.jfree.data.DataUtilities;

import org.junit.Test;

public class Create2DArrayTest {
	
	private double [][] posdoubleArrayTest = {
			 {1.0, 2.0, 3.0, 4.0},
			 {5.0, 6.0, 7.0, 8.0},
			 {9.0, 10.0, 11.0, 12.0}
			 };
	private double [][] negdoubleArrayTest = {
			 {-1.0, -2.0, -3.0, -4.0},
			 {-5.0, -6.0, -7.0, -8.0},
			 {-9.0, -10.0, -11.0, -12.0}
			 };
	private Number [][] negnumberArrayTest = {
			 {-1.0, -2.0, -3.0, -4.0},
			 {-5.0, -6.0, -7.0, -8.0},
			 {-9.0, -10.0, -11.0, -12.0}
			 };
	private Number [][] posnumberArrayTest = {{1.0, 2.0, 3.0, 4.0},{5.0, 6.0, 7.0, 8.0},{9.0, 10.0, 11.0, 12.0}};
	private Number [][] numberArray, negNumberArray;

	@Test
	public void createPositiveNumberArray2D() {
		numberArray = DataUtilities.createNumberArray2D(posdoubleArrayTest);
		assertArrayEquals(posnumberArrayTest, numberArray);
	}
	@Test
	public void createNegativeNumberArray2D() {
		negNumberArray = DataUtilities.createNumberArray2D(negdoubleArrayTest);
		assertArrayEquals(negnumberArrayTest, negNumberArray);
	}

	@Test (expected = InvalidParameterException.class)
	public void createNumberArray2DInvalid() {
		double [][] input = {};
	    Number [][] result = DataUtilities.createNumberArray2D(input);
			
	}
	

}
