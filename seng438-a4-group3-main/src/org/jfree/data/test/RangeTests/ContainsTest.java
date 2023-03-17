package org.jfree.data.test.RangeTests;

import static org.junit.Assert.*; import org.jfree.data.Range; import org.junit.*;

public class ContainsTest {
    private Range exampleRange;
    @BeforeClass public static void setUpBeforeClass() throws Exception {
    }


    @Before
    public void setUp() throws Exception { exampleRange = new Range(0.0, 100.0);
    }
    //testing contains(double value) for P4: value=lower bound
	@Test
	public void testNumberLowerBound() {
		Assert.assertTrue("Lower Bound not working", this.exampleRange.contains(0.0));
	}
	//testing contains(double value) for P3: value=upper bound
	@Test
	public void testNumberUpperBound() {
		Assert.assertTrue("Upper Bound not working", this.exampleRange.contains(100.0));
	}
	//testing contains(double value) for P1: value<lower bound
    @Test
	public void testNumbersOutsideLowerBound() {
		Assert.assertFalse("Number lower than Lower bound not working", this.exampleRange.contains(-1.00));
	}
  //testing contains(double value) for P2: value>upper bound
	@Test
	public void testNumbersOutsideUpperBound() {
		Assert.assertFalse("Number greater than upper bound not working", this.exampleRange.contains(101.00));
	}
	//testing contains(double value) for P5: lower<value<upper
	@Test
	public void testNumbersInRange() {
		Assert.assertTrue("Number in range not working", this.exampleRange.contains(78.0));
	}
	
	// Mutation Tests
	@Test
	public void testLowerGetterMutation() {
		double result = this.exampleRange.getLowerBound();
		assertEquals(0.0, this.exampleRange.getLowerBound(), .000000001d);
	}
	@Test
	public void testUpperGetterMutation() {
		double result = this.exampleRange.getUpperBound();
		assertEquals(100.0, this.exampleRange.getUpperBound(), .000000001d);
	}
	@Test
	public void testLowerBoundMutation() {
		boolean result = this.exampleRange.contains(50.0);
		assertEquals(0.0, this.exampleRange.getLowerBound(), .000000001d);
	}
	@Test
	public void testUpperBoundMutation() {
		boolean result = this.exampleRange.contains(50.0);
		assertEquals(100.0, this.exampleRange.getUpperBound(), .000000001d);
	}
	

    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}
