import java.util.*;

// https://practice.geeksforgeeks.org/problems/topological-sort/1

// Topological sorting using Kahn's algorithm

public class TopologicalSorting_II {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Number of nodes :");
            int n = sc.nextInt();
            System.out.println("Number of edges :");
            int e = sc.nextInt();

            int[][] edges = new int[e][2];
            System.out.println("Write " + e + " edges");
            for (int i = 0; i < e; i++) {
                edges[i][0] = sc.nextInt();
                edges[i][1] = sc.nextInt();
            }

            List<List<Integer>> adjList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                adjList.add(new ArrayList<>());
            }

            for (int[] ed : edges) {
                adjList.get(ed[0]).add(ed[1]);
                adjList.get(ed[1]).add(ed[0]);
            }

            System.out.println(topoSort(n, adjList));
        }
    }

    private static List<Integer> topoSort(int v, List<List<Integer>> adj) {
        List<Integer> res = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        // Finding inDegree of each vertex
        int[] inDegree = new int[v];
        for (int i = 0; i < v; i++) {
            for (int node : adj.get(i)) {
                inDegree[node]++;
            }
        }

        // if inDegree of node == 0 then we add it to queue
        for (int node = 0; node < v; node++) {
            if (inDegree[node] == 0) q.add(node);
        }


        // until queue is not empty, we pop it and decrease inDegree of its neighbour
        while (!q.isEmpty()) {
            int temp = q.poll();
            res.add(temp);

            for (int node : adj.get(temp)) {
                inDegree[node]--;
                // if inDegree of any neighbour became 0 then we add it to the queue
                if (inDegree[node] == 0) q.add(node);
            }
        }

        return res;
    }
}
