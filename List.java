
public class List {
    private int value;
    private List next;
    private int index;

    List(int val) {
        this.value = val;
        this.index = 1;
    }

    public List() {
        this.next = this;
        this.index = 0;
    }

    //adds new element, list kept in numerical order
    public void add(int val) {
        if (this.isEmpty()) {
            this.value = val;
            this.next = null;
            this.index = 1;
        } else {
            List current = this;
            while (true) {
                if (current.next == null) {
                    if (this.value < val) {
                        this.next = new List(this.value);
                        this.next.value = val;
                        break;
                    } else {
                        this.next = new List(this.value);
                        this.next.value = this.value;
                        this.value = val;
                        break;
                    }
                } else if (current.next.value > val) {
                    List a = new List(val);
                    a.next = current.next;
                    current.next = a;
                    break;
                }
                current = current.next;
            }
        }
    }

    public int size() {
        if (this.isEmpty()) {
            return 0;
        }
        if (this.next == null) {
            return 1;
        } else {
            return 1 + this.next.size();
        }
    }

    public List copyFrom() {
        List copy = new List(this.value);
        copy.next = this.next;
        return copy;
    }

    @Override
    public String toString() {
        if (this.isEmpty()) {
            return "([0])";
        }
        String s = "([1]" + this.value;
        List examined = this.next;
        while (examined != null) {
            s += ", [" + examined.index + "]" + examined.value;
            examined = examined.next;
        }

        return s += ")";
    }

    public void clear() {
        this.value = 0; // default value
        this.next = this;
    }

    // if duplicate value, takes first one of duplicates
    public List find(int val) {
        if (this.isEmpty()) {
            return this;
        }
        List current = this;
        while (current != null) {
            if (current.value == val) {
                return current;
            }
            current = current.next;
        }
        return this;
    }

    public boolean contains(int val) {
        if (this.isEmpty()) {
            return false;
        }
        List current = this;
        while (current != null) {
            if (current.value == val) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public boolean isEmpty() {
        return this.next == this;
    }

}
