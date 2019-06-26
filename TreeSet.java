
public class TreeSet implements TSet {
    private Tree tree;

    TreeSet() {
        this.tree = new Tree();
    }

    TreeSet(int n) {
        this.tree = new Tree(n);
    }

    //TreeSet(TSet s) {
    //    this.tree = new Tree();
    //    this.tree.add(s.tree);
    //}

    TreeSet(TreeSet s) {
        this.tree = new Tree();
        this.tree.add(s.tree);
    }

    @Override
    public int at(int n) {
        int index = this.getIndex(n);
        return this.find(index);
    }

    private int getIndex(int n) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return this.tree.isEmpty();
    }

    @Override
    public int count() {
        return this.tree.count();
    }

    @Override
    public boolean contains(int val) {
        return this.tree.contains(val);
    }

    @Override
    public boolean contains(TSet s) {
        for (int i = 0; i < s.count(); i++) {
            int val = s.at(i);
            if (!this.contains(val)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public TreeSet intersection(TSet t1, TSet t2) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public TreeSet union(TSet t1, TSet t2) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public TreeSet find() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void add(TSet set) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean equals(TSet set) {
        return true;
    }

}
