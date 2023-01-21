package Graph.problems;

// https://www.hackerrank.com/challenges/ctci-bfs-shortest-reach/problem

import java.util.*;

/*
    The first line contains an integer 'q' the number of queries.

    Each of the following  sets of lines is as follows:

    1. The first line contains two space-separated integers 'n'  and 'm' the number of nodes and the number of edges.
    2. Each of the next  lines contains two space-separated integers 'u' and 'v' describing an edge connecting node  to node .
    3. The last line contains a single integer 's' the index of the starting node.
 */
public class ShortestPathInUndirectedGraph {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();

        while (q-- > 0) {
            int node = sc.nextInt();
            int edge = sc.nextInt();

            int[][] edges = new int[edge][2];
            for (int i = 0; i < edge; i++) {
                edges[i][0] = sc.nextInt();
                edges[i][1] = sc.nextInt();
            }

            int source = sc.nextInt();

            List<List<Integer>> adjList = adjList(node, edges);

            int[] shortest = shortestPath(node, source, adjList);

            for (int i = 1; i < node+1; i++) {
                if (i == source) continue;
                System.out.print(shortest[i] + " ");
            }

            System.out.println();
        }
        sc.close();
    }

    private static int[] shortestPath(int node, int source, List<List<Integer>> adj) {
        int[] res = new int[node+1];
        Arrays.fill(res, -1);
        boolean[] isVisited = new boolean[node+1];
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        isVisited[source] = true;

        int level = 0;
        while (!q.isEmpty()) {
            int length = q.size();
            level++;

            for (int i = 0; i < length; i++) {
                int temp = q.poll();
                for (int child : adj.get(temp)) {
                    if (!isVisited[child]) {
                        isVisited[child] = true;
                        res[child] = level * 6;
                        q.add(child);
                    }
                }
            }
        }

        return res;
    }
    private static List<List<Integer>> adjList(int node, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < node+1; i++) adj.add(new ArrayList<>());

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        return adj;
    }
}
