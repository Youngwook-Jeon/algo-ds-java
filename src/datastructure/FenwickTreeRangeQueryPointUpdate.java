package datastructure;

public class FenwickTreeRangeQueryPointUpdate {

    // The size of the array holding the Fenwick tree values
    final int N;

    // This array contains the Fenwick tree ranges
    private long[] tree;

    public FenwickTreeRangeQueryPointUpdate(int sz) {
        tree = new long[(N = sz + 1)];
    }

    public FenwickTreeRangeQueryPointUpdate(long[] values) {
        if (values == null) throw new IllegalArgumentException("Values cannot be null!");

        N = values.length;
        values[0] = 0L;

        // Make a clone of the values array
        tree = values.clone();

        for (int i = 1; i < N; i++) {
            int parent = i + lsb(i);
            if (parent < N) tree[parent] += tree[i];
        }
    }

    // Returns the value of the least significant bit
    private static int lsb(int i) {
        return i & -i;
    }

    // O(log(n))
    private long prefixSum(int i) {
        long sum = 0L;
        while (i != 0) {
            sum += tree[i];
            i &= ~lsb(i); // Equivalently, i -= lsb(i);
        }
        return sum;
    }

    // O(log(n))
    public long sum(int left, int right) {
        if (right < left) throw new IllegalArgumentException("Make sure right >= left.");

        return prefixSum(right) - prefixSum(left - 1);
    }

    public long get(int i) {
        return sum(i, i);
    }

    // Add v to index i, O(log(n))
    public void add(int i, long v) {
        while (i < N) {
            tree[i] += v;
            i += lsb(i);
        }
    }

    public void set(int i, long v) {
        add(i, v - sum(i, i));
    }

    @Override
    public String toString() {
        return java.util.Arrays.toString(tree);
    }

}
