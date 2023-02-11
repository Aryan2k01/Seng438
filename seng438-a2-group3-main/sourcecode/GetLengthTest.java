package org.jfree.data.test;

import static org.junit.Assert.*; import org.jfree.data.Range; import org.junit.*;

public class GetLengthTest {
    //testing getLength for P1: lower = 0, upper=0
    @Test
    public void testZeroGetLength() {
    	Range myRange = new Range(0,0);
        assertEquals("The length of the range (0,0) should be 0",
        0, myRange.getLength(), 0);
    }
    //testing getLength for P2: lower<0, upper<0
    @Test
    public void testNegativeGetLength() {
    	Range myRange = new Range(-19,-1.5);
        assertEquals("The length of the range (-19,-1.5) should be 17.5",
        17.5, myRange.getLength(), 0);
    }
    //testing getLength for P3: lower<0, upper>0
    @Test
    public void testNegPosGetLength() {
    	Range myRange = new Range(-5.5,8.977);
        assertEquals("The length of the range (-5.5,8.977) should be 14.477",
        14.477, myRange.getLength(), 0);
    }
}
