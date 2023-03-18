package org.jfree.data.test.RangeTests;

import static org.junit.Assert.*;

import org.jfree.data.Range; import org.junit.*;

public class GetCentralValueTest{
	private Range validRange;
    @BeforeClass public static void setUpBeforeClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    	validRange = new Range(4,7);//valid range
    }
    
    //testing with valid range
    @Test
    public void testValidRange(){
    	assertEquals("Should return 5.5",5.5, validRange.getCentralValue(), 0.000001d);//should return 5.5
    }

    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}
