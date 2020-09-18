package problems.baekjoon;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// #id : 7578
public class Factory {

    static long[] rangeQuery;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer;
        long ans = 0;

        int n = Integer.parseInt(bufferedReader.readLine());
        int[] aLine = new int[n + 1];
        rangeQuery = new long[4 * n];
        Map<Integer, Integer> bLine = new HashMap<>();

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 1; i < aLine.length; i++) {
            aLine[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < n; i++) {
            bLine.put(Integer.parseInt(stringTokenizer.nextToken()), i + 1);
        }

        for (int i = 1; i < aLine.length; i++) {
            ans += query(bLine.get(aLine[i]), n, 1, 1, n);

            update(bLine.get(aLine[i]) - 1, 1, 1, 1, n);
        }

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    private static long query(int left, int right, int node, int nodeLeft, int nodeRight) {
        if (left > nodeRight || right < nodeLeft) return 0;
        if (left <= nodeLeft && nodeRight <= right) return rangeQuery[node];
        int mid = (nodeLeft + nodeRight) / 2;

        return query(left, right, node * 2, nodeLeft, mid) +
                query(left, right, node * 2 + 1, mid + 1, nodeRight);
    }

    private static void update(int index, int newValue, int node, int nodeLeft, int nodeRight) {
        if (index < nodeLeft || index > nodeRight) return;
        int mid = (nodeLeft + nodeRight) / 2;
        rangeQuery[node] += newValue;
        if (nodeLeft != nodeRight) {
            update(index, newValue, node * 2, nodeLeft, mid);
            update(index, newValue, node * 2 + 1, mid + 1, nodeRight);
        }
    }
}
