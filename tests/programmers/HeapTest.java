package programmers;

import org.junit.jupiter.api.Test;
import programmers.heap.MoreSpicy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class heapTest {
    @Test
    public void MoreSpicyTest() {
        int result = new MoreSpicy().solution(new int[] { 1,2,3,9,10,12 }, 7);
        assertEquals(2, result);
    }
}
