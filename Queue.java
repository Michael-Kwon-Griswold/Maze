
public class Queue {
    private int value;
    private Queue next;

    Queue() {
        this.next = this;
    }

    Queue(int i) {
        this.value = i;
        this.next = null;
    }

    void enqueue(int i) {
        if (this.isEmpty()) {
            this.value = i;
            this.next = null;
        } else {
            Queue current = this;
            for (; current.next != null; current = current.next) {
                // exists to move to end of queue
            }
            current.next = new Queue(i);
        }
    }

    int dequeue() {
        if (this.isEmpty()) {
            throw new RuntimeException();
        }
        int i = this.value;
        this.value = this.next.value;
        this.next = this.next.next;
        return i;
    }

    boolean isEmpty() {
        return this.next == this;
    }

    @Override
    public String toString() {
        String s = "(";
        if (!this.isEmpty()) {
            s += this.value;
            for (Queue current = this.next; current != null; current = current.next) {
                s += ", " + current.value;
            }
        }
        return s + ")";
    }

}
