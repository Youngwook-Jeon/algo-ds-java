package problems.programmers;

import java.util.*;

class MedianTreeTrio {

    private List<Integer>[] adjList;

    public int solution(int n, int[][] edges) {
        int answer = 0;
        adjList = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            adjList[edge[0]].add(edge[1]);
            adjList[edge[1]].add(edge[0]);
        }
        int start = 1;
        int[] dists = bfs(start, n);
        for (int i = 1; i <= n; i++) {
            if (dists[i] > dists[start]) start = i;
        }
        dists = bfs(start, n);
        int max = 0;
        for (int i = 1; i <= n; i++) {
            if (dists[i] > dists[start]) {
                start = i;
                max = 1;
            } else if (dists[i] == dists[start]) {
                max++;
            }
        }
        if (max >= 2) return dists[start];
        max = 0;
        dists = bfs(start, n);
        for (int i = 1; i <= n; i++) {
            if (dists[i] > dists[start]) {
                start = i;
                max = 1;
            } else if (dists[i] == dists[start]) {
                max++;
            }
        }
        if (max >= 2) return dists[start];
        return dists[start] - 1;
    }

    private int[] bfs(int start, int n) {
        boolean[] visited = new boolean[n + 1];
        int[] dists = new int[n + 1];
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);

        while (!q.isEmpty()) {
            int now = q.poll();
            visited[now] = true;
            for (int next : adjList[now]) {
                if (visited[next]) continue;
                dists[next] = dists[now] + 1;
                q.add(next);
            }
        }

        return dists;
    }
}
