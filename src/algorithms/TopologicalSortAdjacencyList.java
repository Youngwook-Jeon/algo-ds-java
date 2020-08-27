package algorithms;

import java.util.List;
import java.util.Map;

public class TopologicalSortAdjacencyList {

    static class Edge {
        int from, to, weight;

        public Edge(int f, int t, int w) {
            from = f;
            to = t;
            weight = w;
        }
    }

    private static int dfs(
            int i, int at, boolean[] visited, int[] ordering, Map<Integer, List<Edge>> graph) {
        visited[at] = true;
        List<Edge> edges = graph.get(at);

        if (edges != null) {
            for (Edge edge: edges) {
                if (!visited[edge.to]) {
                    i = dfs(i, edge.to, visited, ordering, graph);
                }
            }
        }
        ordering[i] = at;
        return i - 1;
    }

    //'numNodes' is not necessarily the number of nodes currently present
    // in the adjacency list since you can have singleton nodes with no edges which
    // wouldn't be present in the adjacency list but are still part of the graph!
    public static int[] topologicalSort(Map<Integer, List<Edge>> graph, int numNodes) {
        int[] ordering = new int[numNodes];
        boolean[] visited = new boolean[numNodes];

        int i = numNodes - 1;
        for (int at = 0; at < numNodes; at++) {
            if (!visited[at])
                i = dfs(i, at, visited, ordering, graph);
        }

        return ordering;
    }

    // A useful application of the topological sort is to find the shortest path
    // between two nodes in a Directed Acyclic Graph (DAG). Given an adjacency list
    // this method finds the shortest path to all nodes starting at 'start'
    public static Integer[] dagShortestPath(Map<Integer, List<Edge>> graph, int start, int numNodes) {
        int[] topsort = topologicalSort(graph, numNodes);
        Integer[] dist = new Integer[numNodes];
        dist[start] = 0;

        for (int i = 0; i < numNodes; i++) {
            int nodeIndex = topsort[i];
            if (dist[nodeIndex] != null) {
                List<Edge> adjacentEdges = graph.get(nodeIndex);
                if (adjacentEdges != null) {
                    for (Edge edge: adjacentEdges) {
                        int newDist = dist[nodeIndex] + edge.weight;
                        if (dist[edge.to] == null) dist[edge.to] = newDist;
                        else dist[edge.to] = Math.min(dist[edge.to], newDist);
                    }
                }
            }
        }

        return dist;
    }
}
