package problems.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// #id: 2357
public class MinimumAndMaximum {

    final static int MAX_INT = Integer.MAX_VALUE;
    final static int MIN_INT = Integer.MIN_VALUE;
    static int n;
    static int m;
    static int[] arr;
    static MinMaxPair[] rangeQuery;

    static class MinMaxPair {
        int min;
        int max;

        public MinMaxPair(int min, int max) {
            this.min = min;
            this.max = max;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] st = bufferedReader.readLine().split(" ");
        n = Integer.parseInt(st[0]);
        m = Integer.parseInt(st[1]);
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(bufferedReader.readLine().trim());
        }

        rangeQuery = new MinMaxPair[4 * n];
        init(0, n - 1, 1);

        for (int i = 0; i < m; i++) {
            String[] s = bufferedReader.readLine().split(" ");
            int left = Integer.parseInt(s[0]);
            int right = Integer.parseInt(s[1]);
            MinMaxPair pair = query(left - 1, right - 1);
            System.out.println(pair.min + " " + pair.max);
        }
    }

    private static MinMaxPair init(int left, int right, int node) {
        if (left == right) return rangeQuery[node] = new MinMaxPair(arr[left], arr[left]);
        int mid = (left + right) / 2;
        MinMaxPair leftPair = init(left, mid, node * 2);
        MinMaxPair rightPair = init(mid + 1, right, node * 2 + 1);
        return rangeQuery[node] = new MinMaxPair(Math.min(leftPair.min, rightPair.min),
                Math.max(leftPair.max, rightPair.max));
    }

    private static MinMaxPair query(int left, int right, int node, int nodeLeft, int nodeRight) {
        if (right < nodeLeft || left > nodeRight) return new MinMaxPair(MAX_INT, MIN_INT);
        if (left <= nodeLeft && nodeRight <= right) return rangeQuery[node];
        int mid = (nodeLeft + nodeRight) / 2;
        MinMaxPair leftPair = query(left, right, 2 * node, nodeLeft, mid);
        MinMaxPair rightPair = query(left, right, 2 * node + 1, mid + 1, nodeRight);
        return new MinMaxPair(Math.min(leftPair.min, rightPair.min), Math.max(leftPair.max, rightPair.max));
    }

    public static MinMaxPair query(int left, int right) {
        return query(left, right, 1, 0, n - 1);
    }

}
