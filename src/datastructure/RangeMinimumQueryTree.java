package datastructure;

public class RangeMinimumQueryTree {

    final int INT_MAX = Integer.MAX_VALUE;
    int n;
    int[] rangeMin; // the array that stores minimums in each ranges.

    RangeMinimumQueryTree(int[] array) {
        this.n = array.length;
        this.rangeMin = new int[n * 4];
        init(array, 0, n - 1, 1);
    }

    // node represents array[left..right].
    // init() initializes subtrees that have node as their roots.
    private int init(int[] array, int left, int right, int node) {
        if (left == right) return rangeMin[node] = array[left];

        int mid = (left + right) / 2;
        int leftMin = init(array, left, mid, node * 2);
        int rightMin = init(array, mid + 1, right, node * 2 + 1);
        return rangeMin[node] = Math.min(leftMin, rightMin);
    }

    // node represents array[nodeLeft..nodeRight].
    private int query(int left, int right, int node, int nodeLeft, int nodeRight) {
        if (right < nodeLeft || nodeRight < left) return INT_MAX;
        if (left <= nodeLeft && nodeRight <= right) return rangeMin[node];
        int mid = (nodeLeft + nodeRight) / 2;
        return Math.min(query(left, right, node * 2, nodeLeft, mid),
                query(left, right, node * 2 + 1, mid + 1, nodeRight));
    }

    public int query(int left, int right) {
        return query(left, right, 1, 0, n - 1);
    }

    // if array[index] changes to newValue, we update the segment tree.
    private int update(int index, int newValue, int node, int nodeLeft, int nodeRight) {
        if (index < nodeLeft || nodeRight < index) return rangeMin[node];
        if (nodeLeft == nodeRight) return rangeMin[node] = newValue;
        int mid = (nodeLeft + nodeRight) / 2;

        return rangeMin[node] = Math.min(update(index, newValue, node * 2, nodeLeft, mid),
                update(index, newValue, node * 2 + 1, mid + 1, nodeRight));
    }

    public int update(int index, int newValue) {
        return update(index, newValue, 1, 0, n - 1);
    }
}
