package org.jfree.data.test;

import static org.junit.Assert.*; import org.jfree.data.Range; import org.junit.*;

public class ContainsTest {
    private Range exampleRange;
    @BeforeClass public static void setUpBeforeClass() throws Exception {
    }


    @Before
    public void setUp() throws Exception { exampleRange = new Range(0.0, 100.0);
    }
	@Test
	public void testNumberLowerBound() {
		Assert.assertTrue("Lower Bound not working", this.exampleRange.contains(0.0));
	}
	
	@Test
	public void testNumberUpperBound() {
		Assert.assertTrue("Upper Bound not working", this.exampleRange.contains(100.0));
	}
    @Test
	public void testNumbersOutsideLowerBound() {
		Assert.assertFalse("Number lower than Lower bound not working", this.exampleRange.contains(-1.00));
	}
	
	@Test
	public void testNumbersOutsideUpperBound() {
		Assert.assertFalse("Number greater than upper bound not working", this.exampleRange.contains(101.00));
	}
	
	@Test
	public void testNumbersInRange() {
		Assert.assertTrue("Number in range not working", this.exampleRange.contains(78.0));
	}
	

    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}
