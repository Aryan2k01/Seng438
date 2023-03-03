package org.jfree.data.test;

import static org.junit.Assert.*; import org.jfree.data.Range; import org.junit.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;

public class EqualsTest {
    @BeforeClass public static void setUpBeforeClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }
    //testing when obj is not a Range object
	@Test
	public void testNotRange() {
		Range myRange = new Range(4,7);
        assertFalse("should be false",myRange.equals("hello"));//should return false
	}
	
    //testing with unequal lower values
	@Test
	public void testUnequalLower() {
		Range r1 = new Range(1,4);
		Range r2 = new Range(2,4);
		assertFalse("Should be false",r1.equals(r2));//should return false
	}
    //testing with equal lower values and unequal upper values
	@Test
	public void testUnequalUpper() {
		Range r1 = new Range(1,4);
		Range r2 = new Range(1,9);
		assertFalse("Should be false", r1.equals(r2));//should return false
	}
    //testing with equal ranges
	@Test
	public void testEqualRanges() {
		Range r1 = new Range(1,4);
		Range r2 = new Range(1,4);
		assertTrue("Should be true", r1.equals(r2));//should return true
	}
    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}
