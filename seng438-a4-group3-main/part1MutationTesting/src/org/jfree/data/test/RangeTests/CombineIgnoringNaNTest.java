package org.jfree.data.test.RangeTests;

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
	  @Test
	    public void testConstructor() {
	        Range r1 = new Range(0.1, 1000.0);
	        assertEquals(r1.getLowerBound(), 0.1, 0.0d);
	        assertEquals(r1.getUpperBound(), 1000.0, 0.0d);

	        try {
	            /*Range r2 =*/ new Range(10.0, 0.0);
	            fail("Lower bound cannot be greater than the upper");
	        }
	        catch (Exception e) {
	            // expected
	        }
	    }

	    /**
	     * Confirm that the equals method can distinguish all the required fields.
	     */
	    @Test
	    public void testEquals() {
	        Range r1 = new Range(0.0, 1.0);
	        Range r2 = new Range(0.0, 1.0);
	        assertEquals(r1, r2);
	        assertEquals(r2, r1);

	        r1 = new Range(0.0, 1.0);
	        r2 = new Range(0.5, 1.0);
	        assertFalse(r1.equals(r2));

	        r1 = new Range(0.0, 1.0);
	        r2 = new Range(0.0, 2.0);
	        assertFalse(r1.equals(r2));

	        // a Range object cannot be equal to a different object type
	        assertFalse(r1.equals(new Double(0.0)));
	    }

	    /**
	     * Two objects that are equal are required to return the same hashCode.
	     */
	    @Test
	    public void testHashCode() {
	        Range a1 = new Range(1.0, 100.0);
	        Range a2 = new Range(1.0, 100.0);
	        assertEquals(a1.hashCode(), a2.hashCode());

	        a1 = new Range(-100.0, 2.0);
	        a2 = new Range(-100.0, 2.0);
	        assertEquals(a1.hashCode(), a2.hashCode());
	    }

	    /**
	     * Simple tests for the contains() method.
	     */
	    @Test
	    public void testContains() {
	        Range r1 = new Range(0.0, 1.0);
	        assertFalse(r1.contains(Double.NaN));
	        assertFalse(r1.contains(Double.NEGATIVE_INFINITY));
	        assertFalse(r1.contains(-1.0));
	        assertTrue(r1.contains(0.0));
	        assertTrue(r1.contains(0.5));
	        assertTrue(r1.contains(1.0));
	        assertFalse(r1.contains(2.0));
	        assertFalse(r1.contains(Double.POSITIVE_INFINITY));
	    }

	    /**
	     * Tests the constrain() method for various values.
	     */
	    @Test
	    public void testConstrain() {
	        Range r1 = new Range(0.0, 1.0);

	        double d = r1.constrain(0.5);
	        assertEquals(0.5, d, 0.0000001);

	        d = r1.constrain(0.0);
	        assertEquals(0.0, d, 0.0000001);

	        d = r1.constrain(1.0);
	        assertEquals(1.0, d, 0.0000001);

	        d = r1.constrain(-1.0);
	        assertEquals(0.0, d, 0.0000001);

	        d = r1.constrain(2.0);
	        assertEquals(1.0, d, 0.0000001);

	        d = r1.constrain(Double.POSITIVE_INFINITY);
	        assertEquals(1.0, d, 0.0000001);

	        d = r1.constrain(Double.NEGATIVE_INFINITY);
	        assertEquals(0.0, d, 0.0000001);

	        d = r1.constrain(Double.NaN);
	        assertTrue(Double.isNaN(d));
	    }

	    /**
	     * Simple tests for the intersects() method.
	     */
	    @Test
	    public void testIntersects() {
	        Range r1 = new Range(0.0, 1.0);
	        assertFalse(r1.intersects(-2.0, -1.0));
	        assertFalse(r1.intersects(-2.0, 0.0));
	        assertTrue(r1.intersects(-2.0, 0.5));
	        assertTrue(r1.intersects(-2.0, 1.0));
	        assertTrue(r1.intersects(-2.0, 1.5));
	        assertTrue(r1.intersects(0.0, 0.5));
	        assertTrue(r1.intersects(0.0, 1.0));
	        assertTrue(r1.intersects(0.0, 1.5));
	        assertTrue(r1.intersects(0.5, 0.6));
	        assertTrue(r1.intersects(0.5, 1.0));
	        assertTrue(r1.intersects(0.5, 1.5));
	        assertFalse(r1.intersects(1.0, 1.1));
	        assertFalse(r1.intersects(1.5, 2.0));
	    }

	    /**
	     * A simple test for the expand() method.
	     */
	    @Test
	    public void testExpand() {
	        Range r1 = new Range(0.0, 100.0);
	        Range r2 = Range.expand(r1, 0.10, 0.10);
	        assertEquals(-10.0, r2.getLowerBound(), 0.001);
	        assertEquals(110.0, r2.getUpperBound(), 0.001);

	        // Expand by 0% does not change the range
	        r2 = Range.expand(r1, 0.0, 0.0);
	        assertEquals(r1, r2);

	        try {
	            Range.expand(null, 0.1, 0.1);
	            fail("Null value is accepted");
	        }
	        catch (Exception e) {
	        }

	        // Lower > upper: mid point is used
	        r2 = Range.expand(r1, -0.8, -0.5);
	        assertEquals(65.0, r2.getLowerBound(), 0.001);
	        assertEquals(65.0, r2.getUpperBound(), 0.001);
	    }

	    /**
	     * A simple test for the scale() method.
	     */
	    @Test
	    public void testShift() {
	        Range r1 = new Range(10.0, 20.0);
	        Range r2 = Range.shift(r1, 20.0);
	        assertEquals(30.0, r2.getLowerBound(), 0.001);
	        assertEquals(40.0, r2.getUpperBound(), 0.001);

	        r1 = new Range(0.0, 100.0);
	        r2 = Range.shift(r1, -50.0, true);
	        assertEquals(-50.0, r2.getLowerBound(), 0.001);
	        assertEquals(50.0, r2.getUpperBound(), 0.001);

	        r1 = new Range(-10.0, 20.0);
	        r2 = Range.shift(r1, 20.0, true);
	        assertEquals(10.0, r2.getLowerBound(), 0.001);
	        assertEquals(40.0, r2.getUpperBound(), 0.001);

	        r1 = new Range(-10.0, 20.0);
	        r2 = Range.shift(r1, -30.0, true);
	        assertEquals(-40.0, r2.getLowerBound(), 0.001);
	        assertEquals(-10.0, r2.getUpperBound(), 0.001);

	        r1 = new Range(-10.0, 20.0);
	        r2 = Range.shift(r1, 20.0, false);
	        assertEquals(0.0, r2.getLowerBound(), 0.001);
	        assertEquals(40.0, r2.getUpperBound(), 0.001);

	        r1 = new Range(-10.0, 20.0);
	        r2 = Range.shift(r1, -30.0, false);
	        assertEquals(-40.0, r2.getLowerBound(), 0.001);
	        assertEquals(0.0, r2.getUpperBound(), 0.001);

	        // Shifting with a delta of 0 does not change the range
	        r2 = Range.shift(r1, 0.0);
	        assertEquals(r1, r2);

	        try {
	            Range.shift(null, 0.1);
	            fail("Null value is accepted");
	        }
	        catch (Exception e) {
	        }
	    }

	    /**
	     * A simple test for the scale() method.
	     */
	    @Test
	    public void testScale() {
	        Range r1 = new Range(0.0, 100.0);
	        Range r2 = Range.scale(r1, 0.10);
	        assertEquals(0.0, r2.getLowerBound(), 0.001);
	        assertEquals(10.0, r2.getUpperBound(), 0.001);

	        r1 = new Range(-10.0, 100.0);
	        r2 = Range.scale(r1, 2.0);
	        assertEquals(-20.0, r2.getLowerBound(), 0.001);
	        assertEquals(200.0, r2.getUpperBound(), 0.001);

	        // Scaling with a factor of 1 does not change the range
	        r2 = Range.scale(r1, 1.0);
	        assertEquals(r1, r2);

	        try {
	            Range.scale(null, 0.1);
	            fail("Null value is accepted");
	        }
	        catch (Exception e) {
	        }

	        try {
	            Range.scale(r1, -0.5);
	            fail("Negative factor accepted");
	        }
	        catch (Exception e) {
	        }
	    }

	    /**
	     * Serialize an instance, restore it, and check for equality.
	     */
	  

	    private static final double EPSILON = 0.0000000001;

	    /**
	     * Some checks for the combine method.
	     */
	    @Test
	    public void testCombine() {
	        Range r1 = new Range(1.0, 2.0);
	        Range r2 = new Range(1.5, 2.5);

	        assertNull(Range.combine(null, null));
	        assertEquals(r1, Range.combine(r1, null));
	        assertEquals(r2, Range.combine(null, r2));
	        assertEquals(new Range(1.0, 2.5), Range.combine(r1, r2));

	        Range r3 = new Range(Double.NaN, 1.3);
	        Range rr = Range.combine(r1, r3);
	        assertTrue(Double.isNaN(rr.getLowerBound()));
	        assertEquals(2.0, rr.getUpperBound(), EPSILON);

	        Range r4 = new Range(1.7, Double.NaN);
	        rr = Range.combine(r4, r1);
	        assertEquals(1.0, rr.getLowerBound(), EPSILON);
	        assertTrue(Double.isNaN(rr.getUpperBound()));
	    }

	    /**
	     * Some checks for the combineIgnoringNaN() method.
	     */
	    @Test
	    public void testCombineIgnoringNaN() {
	        Range r1 = new Range(1.0, 2.0);
	        Range r2 = new Range(1.5, 2.5);

	        assertNull(Range.combineIgnoringNaN(null, null));
	        assertEquals(r1, Range.combineIgnoringNaN(r1, null));
	        assertEquals(r2, Range.combineIgnoringNaN(null, r2));
	        assertEquals(new Range(1.0, 2.5), Range.combineIgnoringNaN(r1, r2));

	        Range r3 = new Range(Double.NaN, 1.3);
	        Range rr = Range.combineIgnoringNaN(r1, r3);
	        assertEquals(1.0, rr.getLowerBound(), EPSILON);
	        assertEquals(2.0, rr.getUpperBound(), EPSILON);

	        Range r4 = new Range(1.7, Double.NaN);
	        rr = Range.combineIgnoringNaN(r4, r1);
	        assertEquals(1.0, rr.getLowerBound(), EPSILON);
	        assertEquals(2.0, rr.getUpperBound(), EPSILON);
	    }
	    
	    @Test
	    public void testIsNaNRange() {
	        assertTrue(new Range(Double.NaN, Double.NaN).isNaNRange());
	        assertFalse(new Range(1.0, 2.0).isNaNRange());
	        assertFalse(new Range(Double.NaN, 2.0).isNaNRange());
	        assertFalse(new Range(1.0, Double.NaN).isNaNRange());
	    }
	    
    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}
