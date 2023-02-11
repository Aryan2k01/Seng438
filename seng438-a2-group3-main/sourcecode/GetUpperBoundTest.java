package org.jfree.data.test;

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

    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}
