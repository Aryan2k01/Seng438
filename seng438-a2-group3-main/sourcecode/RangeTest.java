package org.jfree.data.test;

import static org.junit.Assert.*; import org.jfree.data.Range; import org.junit.*;

public class RangeTest {
    private Range exampleRange;
    @BeforeClass public static void setUpBeforeClass() throws Exception {
    }


    @Before
    public void setUp() throws Exception { exampleRange = new Range(-1, 1);
    }


    //example test given in lab instructions
    @Test
    public void centralValueShouldBeZero() {
        assertEquals("The central value of -1 and 1 should be 0",
        0, exampleRange.getCentralValue(), .000000001d);
    }
    
    //our tests
    @Test
    public void testGetLowerBound() {
    	Range myRange = new Range(-7,5);
        assertEquals("The lower bound of the range (-7,5) should be -7",
        -7, myRange.getLowerBound(), 0);
    }
    @Test
    public void testGetUpperBound() {
    	Range myRange = new Range(-7,5);
        assertEquals("The upper bound of the range (-7,5) should be 5",
        5, myRange.getUpperBound(), 0);
    }
    @Test
    public void testZeroGetLength() {
    	Range myRange = new Range(0,0);
        assertEquals("The length of the range (0,0) should be 0",
        0, myRange.getLength(), 0);
    }
    @Test
    public void testNegativeGetLength() {
    	Range myRange = new Range(-19,-1.5);
        assertEquals("The length of the range (-19,-1.5) should be 17.5",
        17.5, myRange.getLength(), 0);
    }
    @Test
    public void testNegPosGetLength() {
    	Range myRange = new Range(-5.5,8.977);
        assertEquals("The length of the range (-5.5,8.977) should be 14.477",
        14.477, myRange.getLength(), 0);
    }
    

    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}
