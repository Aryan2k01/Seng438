package org.jfree.data.test;

import static org.junit.Assert.*; import org.jfree.data.Range; import org.junit.*;

public class ConstrainTest {
    private Range range;
    @BeforeClass public static void setUpBeforeClass() throws Exception {
    }


    @Before
    public void setUp() throws Exception { range = new Range(0.0, 100.0);
    }


@Test
public void constrainNumberLowerThanLowerBoundTest() {
	assertEquals("Doesnt work for a number lower than the lower bound.", 0.0, range.constrain(-99.0),
			.000000001d);
}


@Test
public void constrainNumberHigherThanUpperBoundTest() {
	assertEquals("Doesnt work for a number higher than the upper bound.", 100.0, range.constrain(101.0),
			.000000001d);
}


@Test
public void constrainNumberInRangeTest() {
	assertEquals("Doesnt work if it is within the range", 99.0, range.constrain(99.0),
			.000000001d);
}


@Test
public void constrainUpperBoundaryTest() {
	assertEquals("Doesnt work if it was passed as a parameter.", 100.0, range.constrain(100.0),
			.000000001d);
}


@Test
public void constrainLowerBoundaryTest() {
	assertEquals("Doesnt work if it was passed as a parameter.", 0.0, range.constrain(0.0),
			.000000001d);
}
    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}
