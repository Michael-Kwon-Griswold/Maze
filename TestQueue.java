import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestQueue {

    @Test
    public void testEmptyConstructor() {
        Queue q = new Queue();
        assertEquals("()", q.toString());
    }

    @Test
    public void testIntConstructor() {
        Queue w = new Queue(2);
        assertEquals("(2)", w.toString());
    }

    @Test
    public void testToString() {
        Queue q = new Queue(3);
        q.enqueue(2);
        assertEquals("(3, 2)", q.toString());
    }

    @Test
    public void testEnqueue() {
        Queue q = new Queue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);
        assertEquals("(2, 3, 4, 5)", q.toString());
    }

    @Test
    public void testEnqueue_2() {
        Queue q = new Queue();
        q.enqueue(3);
        q.enqueue(3);
        q.enqueue(-4);
        assertEquals("(3, 3, -4)", q.toString());
    }

    @Test
    public void testDequeue() {
        Queue q = new Queue(43);
        assertEquals(43, q.dequeue());
    }

    @Test(expected = RuntimeException.class)
    public void testDequeue_2() {
        Queue q = new Queue();
        q.dequeue();
    }

    @Test
    public void testDequeue_3() {
        Queue q = new Queue();
        q.enqueue(4);
        q.enqueue(5);
        assertEquals(4, q.dequeue());
    }

}
