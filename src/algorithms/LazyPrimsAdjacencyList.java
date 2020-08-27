package algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class LazyPrimsAdjacencyList {

    static class Edge implements Comparable<Edge> {
        int from, to, cost;

        public Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge other) {
            return cost - other.cost;
        }
    }

    // Inputs
    private final int n;
    private final List<List<Edge>> graph;

    // Internal
    private boolean solved;
    private boolean mstExists;
    private boolean[] visited;
    private PriorityQueue<Edge> pq;

    // Outputs
    private long minCostSum;
    private Edge[] mstEdges;

    public LazyPrimsAdjacencyList(List<List<Edge>> graph) {
        if (graph == null || graph.isEmpty()) throw new IllegalArgumentException();
        this.n = graph.size();
        this.graph = graph;
    }

    // Returns the edges used in finding the minimum spanning tree,
    // or returns null if no MST exists.
    public Edge[] getMst() {
        solve();
        return mstExists ? mstEdges : null;
    }

    public Long getMstCost() {
        solve();
        return mstExists ? minCostSum : null;
    }

    private void solve() {
        if (solved) return;
        solved = true;
        int m = n - 1, edgeCount = 0;
        pq = new PriorityQueue<>();
        visited = new boolean[n];
        mstEdges = new Edge[m];

        // Add initial set of edges to the priority queue starting at node 0.
        addEdges(0);

        while (!pq.isEmpty() && edgeCount != m) {
            Edge edge = pq.poll();
            int nodeIndex = edge.to;

            if (visited[nodeIndex]) continue;

            mstEdges[edgeCount++] = edge;
            minCostSum += edge.cost;

            addEdges(nodeIndex);
        }

        // Check if MST spans entire graph.
        mstExists = (edgeCount == m);
    }

    private void addEdges(int nodeIndex) {
        visited[nodeIndex] = true;

        List<Edge> edges = graph.get(nodeIndex);
        for (Edge e : edges) {
            if (!visited[e.to]) {
                pq.offer(e);
            }
        }
    }

    static List<List<Edge>> createEmptyGraph(int n) {
        List<List<Edge>> g = new ArrayList<>();
        for (int i = 0; i < n; i++) g.add(new ArrayList<>());
        return g;
    }

    static void addDirectedEdge(List<List<Edge>> g, int from, int to, int cost) {
        g.get(from).add(new Edge(from, to, cost));
    }

    static void addUndirectedEdge(List<List<Edge>> g, int from, int to, int cost) {
        addDirectedEdge(g, from, to, cost);
        addDirectedEdge(g, to, from, cost);
    }

    public static void main(String[] args) {
        example1();
    }

    private static void example1() {
        int n = 10;
        List<List<Edge>> g = createEmptyGraph(n);

        addUndirectedEdge(g, 0, 1, 5);
        addUndirectedEdge(g, 1, 2, 4);
        addUndirectedEdge(g, 2, 9, 2);
        addUndirectedEdge(g, 0, 4, 1);
        addUndirectedEdge(g, 0, 3, 4);
        addUndirectedEdge(g, 1, 3, 2);
        addUndirectedEdge(g, 2, 7, 4);
        addUndirectedEdge(g, 2, 8, 1);
        addUndirectedEdge(g, 9, 8, 0);
        addUndirectedEdge(g, 4, 5, 1);
        addUndirectedEdge(g, 5, 6, 7);
        addUndirectedEdge(g, 6, 8, 4);
        addUndirectedEdge(g, 4, 3, 2);
        addUndirectedEdge(g, 5, 3, 5);
        addUndirectedEdge(g, 3, 6, 11);
        addUndirectedEdge(g, 6, 7, 1);
        addUndirectedEdge(g, 3, 7, 2);
        addUndirectedEdge(g, 7, 8, 6);

        LazyPrimsAdjacencyList solver = new LazyPrimsAdjacencyList(g);
        Long cost = solver.getMstCost();

        if (cost == null) {
            System.out.println("No MST does not exists");
        } else {
            System.out.println("MST cost: " + cost);
            for (Edge e : solver.getMst()) {
                System.out.println(String.format("from: %d, to: %d, cost: %d", e.from, e.to, e.cost));
            }
        }

        // Output:
        // MST cost: 14
        // from: 0, to: 4, cost: 1
        // from: 4, to: 5, cost: 1
        // from: 4, to: 3, cost: 2
        // from: 3, to: 1, cost: 2
        // from: 3, to: 7, cost: 2
        // from: 7, to: 6, cost: 1
        // from: 6, to: 8, cost: 4
        // from: 8, to: 9, cost: 0
        // from: 8, to: 2, cost: 1
    }

}
