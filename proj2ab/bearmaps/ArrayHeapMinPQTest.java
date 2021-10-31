package bearmaps;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ArrayHeapMinPQTest {
    @Test
    public void testAdd() {
        ArrayHeapMinPQ<String> pq = new ArrayHeapMinPQ<>();
        pq.add("qys", 5);
        pq.add("zwb", 1);
        pq.add("mhj", 7);
        pq.add("einstein", -1000);
    }

    @Test
    public void testRemove() {
        ArrayHeapMinPQ<String> pq = new ArrayHeapMinPQ<>();
        pq.add("qys", 5);
        pq.add("zwb", 1);
        pq.add("mhj", 7);
        pq.add("einstein", -1000);
        pq.removeSmallest();
    }

    @Test
    public void testChangePriority() {
        ArrayHeapMinPQ<String> pq = new ArrayHeapMinPQ<>();
        pq.add("qys", 5);
        pq.add("zwb", 1);
        pq.add("mhj", 7);
        pq.removeSmallest();
        pq.add("einstein", -1000);
        pq.add("jhx",2);
        pq.add("zfd",3);
        pq.add("th",3);
        pq.removeSmallest();
        pq.removeSmallest();
        pq.changePriority("mhj",-200);
    }
}
