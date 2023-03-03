package org.jfree.data.test;

import static org.junit.Assert.*; import org.jfree.data.Range; import org.junit.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;

public class CombineIgnoringNaNTest {
	private Range nullRange;
	private Range nanRange;
	private Range validRange;
	private Range validRange2;
    @BeforeClass public static void setUpBeforeClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    	
    	nanRange = new Range(Double.NaN,Double.NaN);//NaN Range
    	validRange = new Range (4,7);//lower = 4, upper=7
    	validRange2 = new Range (5,8);
    }
    //testing range1 = null, range2 != null, and range2.isNanRange()
	@Test
	public void testCombineNullRange1NaNRange2() {
        assertEquals("Should return null",
        null, Range.combineIgnoringNaN(nullRange,nanRange));//should return null
	}
    //testing range1 = null, range2 = validRange=(4,7)
	@Test
	public void testCombineNullRange1() {
        assertEquals("Should return range2 which is (4,7)",
        validRange, Range.combineIgnoringNaN(nullRange,validRange));//should return range2
	}
	//testing range1 = NaNRange, range2 = null
	@Test
	public void testCombineNullRange2NaNRange1() {
		assertEquals("Should return null",null, Range.combineIgnoringNaN(nanRange,null));//should return null
	}
	//testing range1 = validRange, range2 = null
	@Test
	public void testCombineNullRange2() {
		assertEquals("Should return range1 which is (4,7",
				validRange, Range.combineIgnoringNaN(validRange,null));//should return range1
	}
	//testing with range1 = validRange=(4,7), range2=validRange2=(5,8)
	@Test
	public void testCombineValidRanges() {
		Range expected = new Range(4,8);
		assertEquals("Should return (4,8)",expected, Range.combineIgnoringNaN(validRange,validRange2));//should return (4,8)
	}
	//testing with range1 =(4,Double.NaN), range2=(Double.NaN,8)
	@Test
	public void testUpperNaNLowerNaN() {
		Range r1 = new Range (4,Double.NaN);
		Range r2 = new Range(Double.NaN, 8);
		Range expected = new Range(4,8);
		assertEquals("Should return (4,8)",expected, Range.combineIgnoringNaN(r1,r2));//should return (4,8)
	}
	//testing with range1 = validRange=(Double.NaN,8), range2=validRange2=(4,Double.NaN)
	@Test
	public void testLowerNaNUpperNaN() {
		Range r1 = new Range(Double.NaN, 8);
		Range r2 = new Range (4,Double.NaN);
		Range expected = new Range(4,8);
		assertEquals("Should return (4,8)",expected, Range.combineIgnoringNaN(r1,r2));//should return (4,8)
	}
    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}
