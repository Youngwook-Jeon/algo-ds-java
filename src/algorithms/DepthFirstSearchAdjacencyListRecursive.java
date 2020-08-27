package algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DepthFirstSearchAdjacencyListRecursive {

    static class Edge {
        int from, to, cost;

        public Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }

    // the number of nodes traversed starting at some position
    static long dfs(int at, boolean[] visited, Map<Integer, List<Edge>> graph) {
        if (visited[at]) return 0L;

        visited[at] = true;
        long count = 1;
        List<Edge> edges = graph.get(at);
        if (edges != null) {
            for (Edge edge : edges) {
                count += dfs(edge.to, visited, graph);
            }
        }

        return count;
    }

    // an Example usage of DFS
    public static void main(String[] args) {
        int numNodes = 5;
        Map<Integer, List<Edge>> graph = new HashMap<>();
        addDirectedEdge(graph, 0, 1, 4);
        addDirectedEdge(graph, 0, 2, 5);
        addDirectedEdge(graph, 1, 2, -2);
        addDirectedEdge(graph, 1, 3, 6);
        addDirectedEdge(graph, 2, 3, 1);
        addDirectedEdge(graph, 2, 2, 10); // Self loop

        long nodeCount = dfs(0, new boolean[numNodes], graph);
        System.out.println("DFS node count starting at node 0: " + nodeCount);
    }

    private static void addDirectedEdge(Map<Integer, List<Edge>> graph, int from, int to, int cost) {
        List<Edge> list = graph.computeIfAbsent(from, k -> new ArrayList<Edge>());
        list.add(new Edge(from, to, cost));
    }
}
