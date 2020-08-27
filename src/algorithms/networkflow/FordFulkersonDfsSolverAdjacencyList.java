/**
 * An implementation of the Ford-Fulkerson (FF) method with a DFS as a method of finding augmenting
 * paths. FF allows you to find the max flow through a directed graph and the min cut as a
 * byproduct.
 *
 * <p>Time Complexity: O(fE), where f is the max flow and E is the number of edges
 *
 */
package algorithms.networkflow;

import java.util.List;

import static java.lang.Math.min;

public class FordFulkersonDfsSolverAdjacencyList extends NetworkFlowSolverBase {

    public FordFulkersonDfsSolverAdjacencyList(int n, int s, int t) {
        super(n, s, t);
    }

    @Override
    public void solve() {
        // Find max flow by adding all augmenting path flows.
        for (long f = dfs(s, INF); f != 0; f = dfs(s, INF)) {
            markAllNodesAsUnvisited();
            maxFlow += f;
        }

        // Find min cut.
        for (int i = 0; i < n; i++) if (visited(i)) minCut[i] = true;
    }

    private long dfs(int node, long flow) {
        if (node == t) return flow;

        List<Edge> edges = graph[node];
        visit(node);

        for (Edge edge : edges) {
            long rcap = edge.remainingCapacity();
            if (rcap > 0 && !visited(edge.to)) {
                long bottleNeck = dfs(edge.to, min(flow, rcap));

                // Augment flow with bottle neck value
                if (bottleNeck > 0) {
                    edge.augment(bottleNeck);
                    return bottleNeck;
                }
            }
        }
        return 0;
    }

    /* Example */

    public static void main(String[] args) {
        exampleFromSlides2();
    }

    private static void exampleFromSlides2() {
        int n = 12;
        int s = n - 2;
        int t = n - 1;

        FordFulkersonDfsSolverAdjacencyList solver;
        solver = new FordFulkersonDfsSolverAdjacencyList(n, s, t);

        solver.addEdge(s, 1, 2);
        solver.addEdge(s, 2, 1);
        solver.addEdge(s, 0, 7);

        solver.addEdge(0, 3, 2);
        solver.addEdge(0, 4, 4);

        solver.addEdge(1, 4, 5);
        solver.addEdge(1, 5, 6);

        solver.addEdge(2, 3, 4);
        solver.addEdge(2, 7, 8);

        solver.addEdge(3, 6, 7);
        solver.addEdge(3, 7, 1);

        solver.addEdge(4, 5, 8);
        solver.addEdge(4, 8, 3);

        solver.addEdge(5, 8, 3);

        solver.addEdge(6, t, 1);
        solver.addEdge(7, t, 3);
        solver.addEdge(8, t, 4);

        System.out.println(solver.getMaxFlow());

        List<Edge>[] g = solver.getGraph();
        for (List<Edge> edges : g) {
            for (Edge e : edges) {
                if (e.to == s || e.from == t) continue;
                if (e.from == s || e.to == t || e.from < e.to) System.out.println(e.toString(s, t));
                // System.out.println(e.residual.toString(s, t));
            }
        }
    }
}
