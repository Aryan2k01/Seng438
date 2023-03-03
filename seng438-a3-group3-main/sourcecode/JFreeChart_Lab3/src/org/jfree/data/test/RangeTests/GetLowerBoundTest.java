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

    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}