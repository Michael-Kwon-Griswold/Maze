
public class LinkedList {
    private int value;
    private LinkedList next;

    LinkedList(int val) {
        this.value = val;
    }

    //adds new element, list kept in numerical order

    public void add(int val) {
        LinkedList current = this;
        while (true) {
            if (current.next == null) {
                if (this.value < val) {
                    this.next = new LinkedList(this.value);
                    this.next.value = val;
                    break;
                } else {
                    this.next = new LinkedList(this.value);
                    this.next.value = this.value;
                    this.value = val;
                    break;
                }
            } else if (current.next.value > val) {
                LinkedList a = new LinkedList(val);
                a.next = current.next;
                current.next = a;
                break;
            }
            current = current.next;
        }
    }

    public int getValue() {
        return this.value;
    }

    public LinkedList next() {
        return this.next;
    }

    public int size() {
        if (this.next == null) {
            return 1;
        } else {
            return 1 + this.next.size();
        }
    }

    @Override
    public String toString() {
        String s = "(" + this.value;
        LinkedList examined = this.next;
        while (examined != null) {
            s += ", " + examined.value;
            examined = examined.next;
        }

        return s += ")";
    }

    public void clear() {

    }

    public LinkedList find() {
        return this;
    }

    public boolean contains() {
        return false;
    }

    public void reverse() {

    }

}
