package problems.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// #id : 6549
public class TheLargestRectangle {

    final static int MAX_INT = Integer.MAX_VALUE;
    static int n;
    static int[] arr;
    static int[] rangeQuery;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String[] strs = bufferedReader.readLine().split(" ");
            n = Integer.parseInt(strs[0]);
            if (n == 0) break;
            arr = new int[n];
            for (int i = 1; i <= n; i++) {
                arr[i - 1] = Integer.parseInt(strs[i]);
            }
            rangeQuery = new int[4 * n];
            init(0, n - 1, 1);
            System.out.println(getMaxArea(0, n - 1));
        }
    }

    private static void init(int left, int right, int node) {
        if (left == right) {
            rangeQuery[node] = left;
            return;
        }
        int mid = (left + right) / 2;
        init(left, mid, node * 2);
        init(mid + 1, right, node * 2 + 1);

        if (arr[rangeQuery[node * 2]] <= arr[rangeQuery[node * 2 + 1]]) {
            rangeQuery[node] = rangeQuery[node * 2];
        } else {
            rangeQuery[node] = rangeQuery[node * 2 + 1];
        }
    }

    public static long getMaxArea(int left, int right) {
        int ind = query(left, right, 1, 0, n - 1);

        long area = (long)(right - left + 1) * (long)arr[ind];

        if (left <= ind - 1) {
            long tmp = getMaxArea(left, ind - 1);
            area = Math.max(tmp, area);
        }
        if (ind + 1 <= right) {
            long tmp = getMaxArea(ind + 1, right);
            area = Math.max(tmp, area);
        }

        return area;
    }

    private static int query(int left, int right, int node, int leftNode, int rightNode) {
        if (left > rightNode || right < leftNode) return MAX_INT;
        if (left <= leftNode && rightNode <= right) return rangeQuery[node];
        int mid = (leftNode + rightNode) / 2;
        int leftVal = query(left, right, 2 * node, leftNode, mid);
        int rightVal = query(left, right, 2 * node + 1, mid + 1, rightNode);

        if (leftVal == MAX_INT) return rightVal;
        else if (rightVal == MAX_INT) return leftVal;
        else {
            return (arr[leftVal] <= arr[rightVal]) ? leftVal : rightVal;
        }
    }
}
