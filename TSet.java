
public interface TSet {
    int at(int n);

    TSet intersection(TSet t1, TSet t2);

    TSet union(TSet t1, TSet t2);

    boolean isEmpty();

    int count();

    boolean contains(int val);

    boolean contains(TSet s);

    TSet find();

    void add(TSet set);

    @Override
    String toString();

    boolean equals(TSet set);

}
