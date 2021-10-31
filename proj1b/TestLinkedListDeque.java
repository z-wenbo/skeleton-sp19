import org.junit.Test;
import static org.junit.Assert.*;


public class TestLinkedListDeque {
    @Test
    public void testremoveFirst(){
        LinkedListDeque<Integer> l = new LinkedListDeque<Integer>();
        l.addLast(1);
        l.addLast(2);
        l.addFirst(3);
        int actual = l.removeFirst();
        assertEquals(3,actual);

    }

}
