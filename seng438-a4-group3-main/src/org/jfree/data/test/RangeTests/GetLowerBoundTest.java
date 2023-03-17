package org.jfree.data.test.RangeTests;

import static org.junit.Assert.*; import org.jfree.data.Range; import org.junit.*;

public class GetLowerBoundTest {
    private Range exampleRange;
    @BeforeClass public static void setUpBeforeClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception { exampleRange = new Range(-7, 5);
    }
    
    //testing getLowerBound
    @Test
    public void testGetLowerBound() {
        assertEquals("The lower bound of the range (-7,5) should be -7",
        -7, exampleRange.getLowerBound(), 0);
    }
    
    // Mutation tests
    @Test
	public void testLowerGetterMutation() {
		assertEquals(-7.0, this.exampleRange.getLowerBound(), .000000001d);
	}
	@Test
	public void testLowerGetterTwice() {
		double result = this.exampleRange.getLowerBound();
		assertEquals(result, this.exampleRange.getLowerBound(), .000000001d);
	}

    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}