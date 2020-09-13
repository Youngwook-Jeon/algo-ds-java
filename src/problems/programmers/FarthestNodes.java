package problems.programmers;

import java.util.*;

// 가장 먼 노드
class FarthestNodes {
    static List<List<Integer>> graph;

    static class Node implements Comparable<Node> {
        int distance;
        int vertex;

        Node(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }
        @Override
        public int compareTo(Node node1) {
            return this.distance - node1.distance;
        }
    }
    public int solution(int n, int[][] edge) {
        setup(n, edge);
        int[] dist = new int[n + 1];
        boolean[] visit = new boolean[n + 1];
        for (int i = 2; i < dist.length; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        Node node = new Node(1, 0);
        Queue<Node> queue = new PriorityQueue<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            node = queue.poll();
            visit[node.vertex] = true;
            if (dist[node.vertex] < node.distance) continue;
            for (int i = 1; i < n + 1; i++) {
                if (!visit[i] && graph.get(node.vertex).contains(i)) {
                    if (dist[i] > dist[node.vertex] + 1) {
                        dist[i] = dist[node.vertex] + 1;
                        queue.offer(new Node(i, dist[i]));
                    }
                }
            }
        }
        int max = 0;
        int ans = 0;
        for (int i : dist) {
            if (max < i) max = i;
        }
        for (int i = 1; i < dist.length; i++) {
            if (dist[i] == max) ans++;
        }
        return ans;
    }

    private void setup(int n, int[][] edge) {
        graph = new ArrayList<>(n + 1);
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < edge.length; i++) {
            int v1 = edge[i][0];
            int v2 = edge[i][1];
            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
        }
    }
}
