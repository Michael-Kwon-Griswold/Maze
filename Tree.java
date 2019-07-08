import components.queue.Queue;
import components.queue.Queue1L;

public class Tree {
    private int value;

    private Tree left;
    private Tree right;
    private boolean visited;
    private int index;

    Tree() {
        this.left = this;
        this.right = this;
        this.visited = false;
        this.index = 1;
    }

    Tree(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
        this.visited = false;
        this.index = 1;
    }

    Tree(int value, Tree left, Tree right) {
        this.value = value;
        this.left = left;
        this.right = right;
        this.visited = false;
        this.index = 1;
    }

    public void add(int val) {
        if (this.isEmpty()) {
            this.clearTree();
            this.setValue(val);
            this.index = 1;
        } else {
            if (this.visit(Direction.LEFT) == null) {
                this.left = new Tree(val);
                this.left.index = this.index + 1;
            } else if (this.visit(Direction.RIGHT) == null) {
                this.right = new Tree(val);
                this.right.index = this.left.index + 1;
            }
        }
    }

    public Queue<Integer> logIndexes() {
        Queue<> indexQueue = new Queue1L<Integer>();
        Tree n = new Tree();
        if (this.left.isLeaf()) {
            indexQueue.enqueue();
        }
        if (!this.left.isLeaf()) {
            indexQueue.append(this.left.logIndexes());
        } else if (!this.right.isLeaf()) {

        }
        return indexQueue;
    }

    public Tree visit(Direction d) {
        if (d.equals(Direction.LEFT)) {
            return this.left;
        } else if (d.equals(Direction.RIGHT)) {
            return this.right;
        } else {
            return this;
        }
    }

    boolean isEmpty() {
        return (this.left == this && this.right == this);
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    // number of non-null children
    public int numChildren() {
        if (this.isEmpty()) {
            return 0;
        }
        int numChildren = 0;
        numChildren += (this.left != null) ? 1 : 0;
        numChildren += (this.right != null) ? 1 : 0;
        return numChildren;
    }

    public boolean isLeaf() {
        if (this.isEmpty()) {
            return false;
        }
        return (this.left == null) && (this.right == null);
    }

    @Override
    public String toString() {
        if (this.isEmpty()) {
            return "([-1])";
        }
        if (this.isLeaf() && this.index == 1) {
            return "([" + this.index + "]" + this.value + ")";
        } else if (this.isLeaf()) {
            return "[" + this.index + "]" + this.value;
        } else {
            return "([" + this.index + "]" + this.value + ", "
                    + ((this.left != null) ? this.left.toString() : "DNE")
                    + ", "
                    + ((this.right != null) ? this.right.toString() : "DNE")
                    + ")";
        }

    }

    public boolean contains(int val) {
        if (this.isEmpty()) {
            return false;
        }
        boolean contained = false;
        this.markVisited(this);

        if (this.valueEquals(val)) {
            contained = true;
        }

        if (!contained && (this.left != null && !this.left.visited)) { // check left
            contained = this.left.contains(val);
        } else if (!contained && (this.right != null && !this.right.visited)) { // check right
            contained = this.right.contains(val);
        }
        return contained;
    }

    public Tree find(int val) {
        if (this.isEmpty()) {
            return this;
        }
        boolean found = false;
        Tree store = this;
        this.markVisited(this);

        if (this.valueEquals(val)) {
            found = true;
            store = this;
        }

        if (!found && (this.left != null && !this.left.visited)) { // check left
            store = this.left.find(val);
        }
        if (!found && (this.right != null && !this.right.visited)) { // check right
            store = this.right.find(val);
        }
        return store;
    }

    /*
     * public Tree find(int indexWanted, int indexFrom) { Tree examined =
     * toNode(indexFrom); if (this.isEmpty()) { return this; } boolean found =
     * false;
     *
     * while (indexFrom < indexWanted) { examined = this.find(indexWanted,
     * indexFrom++); // visit next node }
     *
     * for (int i = 0; i < indexWanted; i++) {
     *
     * Tree store = this; this.markVisited(this); // visit next node }
     *
     * Tree store = this;
     *
     * if (!found && (this.left != null && !this.left.visited)) { // check left
     * store = this.left.find(indexWanted); } if (!found && (this.right != null
     * && !this.right.visited)) { // check right store =
     * this.right.find(indexWanted); } return store;
     *
     * }
     *
     */
    public int getIndex(int val) {
        if (this.isEmpty()) {
            return -1;
        }
        boolean found = false;
        int index = 1;
        this.markVisited(this);

        if (this.valueEquals(val)) {
            found = true;
            index++;
        }

        if (!found && (this.left != null && !this.left.visited)) { // check left
            index++;
            index = this.left.getIndex(val);
        }
        if (!found && (this.right != null && !this.right.visited)) { // check right
            index++;
            index = this.right.getIndex(val);
        }
        return index;
    }

    public int depth() {
        if (this.isEmpty()) {
            return 0;
        }
        int largestVal = 1;
        this.markVisited(this);

        if (this.left != null && !this.left.visited) {
            largestVal += this.left.depth();
        } else if (this.right != null && !this.right.visited) {
            largestVal += this.right.depth();
        }
        return largestVal;
    }

    // returns total # of non-null nodes in the tree
    public int count() {
        if (this.isEmpty()) {
            return 0;
        }
        this.markVisited(this);
        int count = 1;

        if (this.left != null && !this.left.visited) {
            count += this.left.isLeaf() ? 1 : 1 + this.left.count();
        } else if (this.right != null && !this.right.visited) {
            count += this.right.isLeaf() ? 1 : 1 + this.right.count();
        }
        return count;
    }

    public void markAllUnvisited() {
        this.markUnVisited(this);

        if (this.left != null && this.left.visited) {
            this.left.markAllUnvisited();
        } else if (this.right != null && this.right.visited) {
            this.right.markAllUnvisited();
        }
    }

    private void markVisited(Tree child) {
        child.visited = true;
    }

    private void markUnVisited(Tree child) {
        child.visited = false;
    }

    private boolean valueEquals(int val) {
        return this.value == val;
    }

    public void clearTree() {
        this.value = 0; // default value
        this.visited = false;
        this.left = null;
        this.right = null;
    }

}
