package org.jfree.data.test.RangeTests;

import static org.junit.Assert.*; import org.jfree.data.Range; import org.junit.*;

public class GetUpperBoundTest {
    private Range exampleRange;
    @BeforeClass public static void setUpBeforeClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception { exampleRange = new Range(-7, 5);
    }

    //testing getUpperBound using any range
    @Test
    public void testGetUpperBound() {
        assertEquals("The upper bound of the range (-7,5) should be 5",
        5, exampleRange.getUpperBound(), 0);
    }
    
 // Mutation Tests
 	@Test
 	public void testUpperGetterMutation() {
 		assertEquals(5.0, this.exampleRange.getUpperBound(), .000000001d);
 	}
 	@Test
 	public void testUpperGetterTwice() {
 		double result = this.exampleRange.getUpperBound();
 		assertEquals(result, this.exampleRange.getUpperBound(), .000000001d);
 	}

    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}
