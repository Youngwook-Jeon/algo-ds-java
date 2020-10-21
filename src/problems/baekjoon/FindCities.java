package problems.baekjoon;

import java.io.*;
import java.util.*;

// #id: 18352
class FindCities {

    static final int MAX_NUM = Integer.MAX_VALUE;
    static int n, m, k, start;
    static Map<Integer, List<Integer>> map = new HashMap<>();
    static int[] dists;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());
        dists = new int[n + 1];
        for (int i = 1; i < dists.length; i++) {
            if (i != start) dists[i] = MAX_NUM;
        }
        for (int i = 0; i < m; i++) {
            int a, b;
            String[] s = br.readLine().split(" ");
            a = Integer.parseInt(s[0]);
            b = Integer.parseInt(s[1]);
            List<Integer> lst;
            if (!map.containsKey(a)) {
                lst = new ArrayList<>();
                map.put(a, lst);
            }
            lst = map.get(a);
            lst.add(b);
        }
        solve();
        int cnt = 0;
        for (int i = 1; i < dists.length; i++) {
            if (dists[i] == k) {
                bw.write(String.valueOf(i) + "\n");
                cnt++;
            }
        }
        if (cnt == 0) bw.write(String.valueOf(-1));
        bw.flush();
        bw.close();
    }

    private static void solve() {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            int city = queue.poll();
            if (map.containsKey(city)) {
                List<Integer> lst = map.get(city);
                for (int other : lst) {
                    if (dists[other] == MAX_NUM) {
                        dists[other] = dists[city] + 1;
                        queue.add(other);
                    }
                }
            }
        }
    }
}
