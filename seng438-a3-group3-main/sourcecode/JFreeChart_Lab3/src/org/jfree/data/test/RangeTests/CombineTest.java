package org.jfree.data.test.RangeTests;

import static org.junit.Assert.*; import org.jfree.data.Range; import org.junit.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;

public class CombineTest {
    private Range nullRange;
    private Range a;
    private Range b;
    @BeforeClass public static void setUpBeforeClass() throws Exception {
    }


    @Before
    public void setUp() throws Exception {
    	a = new Range(4,5);
    	b = new Range(7,8.8);
    }
    //testing range1 = null, range2 = a = (4,5)
	@Test
	public void testCombineNullRange1() {
        assertEquals("Should return range2 which is (4,5)",
        a, Range.combine(nullRange,a));
	}
    //testing range1 = a = (4,5), range2 = null 
	@Test
	public void testCombineNullRange2() {
        assertEquals("Should return range1 which is (4,5)",
        a, Range.combine(a,nullRange));
	}
	//testing combining valid non-null ranges: range1=a=(4,5) and range2=b=(7,8.8)
	@Test
	public void testCombineValidRanges() {
		Range expected = new Range(4,8.8);
        assertEquals("Should return range (4,8.8)",
        expected, Range.combine(a,b));
	}
	
	
    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}

