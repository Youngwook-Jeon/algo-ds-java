package algorithms.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BreadthFirstSearchAdjacencyListIterative {

    public static class Edge {
        int from, to, cost;

        public Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }

    private int n;
    private Integer[] prev;
    private List<List<Edge>> graph;

    public BreadthFirstSearchAdjacencyListIterative(List<List<Edge>> graph) {
        if (graph == null) throw new IllegalArgumentException("Graph can not be null");
        n = graph.size();
        this.graph = graph;
    }

    /**
     * Reconstructs the path (of nodes) from 'start' to 'end' inclusive. If the edges are unweighted
     * then this method returns the shortest path from 'start' to 'end'
     *
     * @return An array of nodes indexes of the shortest path from 'start' to 'end'. If 'start' and
     *     'end' are not connected then an empty array is returned.
     */
    public List<Integer> reconstructPath(int start, int end) {
        bfs(start);
        List<Integer> path = new ArrayList<>();
        for (Integer at = end; at != null; at = prev[at])
            path.add(at);
        if (path.get(0) == start) return path;
        path.clear();

        return path;
    }

    private void bfs(int start) {
        prev = new Integer[n];
        boolean[] visited = new boolean[n];
        Deque<Integer> queue = new ArrayDeque<>(n);

        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            List<Edge> edges = graph.get(node);

            for (Edge edge: edges) {
                if (!visited[edge.to]) {
                    visited[edge.to] = true;
                    prev[edge.to] = node;
                    queue.offer(edge.to);
                }
            }
        }
    }

    public static List<List<Edge>> createEmptyGraph(int n) {
        List<List<Edge>> graph = new ArrayList<>(n);
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        return graph;
    }

    // Add a directed edge from node 'u' to node 'v' with cost 'cost'.
    public static void addDirectedEdge(List<List<Edge>> graph, int u, int v, int cost) {
        graph.get(u).add(new Edge(u, v, cost));
    }

    // Add an undirected edge between nodes 'u' and 'v'.
    public static void addUndirectedEdge(List<List<Edge>> graph, int u, int v, int cost) {
        addDirectedEdge(graph, u, v, cost);
        addDirectedEdge(graph, v, u, cost);
    }

    // Add an undirected unweighted edge between nodes 'u' and 'v'. The edge added
    // will have a weight of 1 since its intended to be unweighted.
    public static void addUnweightedUndirectedEdge(List<List<Edge>> graph, int u, int v) {
        addUndirectedEdge(graph, u, v, 1);
    }
}
