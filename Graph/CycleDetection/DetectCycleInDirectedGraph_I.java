import java.util.*;

// https://practice.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1

public class DetectCycleInDirectedGraph_I {
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

            System.out.println(cycleExist(adjList, n));
        }
    }

    private static boolean cycleExist(List<List<Integer>> adj, int v) {
        boolean[] isVisited = new boolean[v];
        for (int i = 0; i < v; i++) {
            if (!isVisited[i]) {
                if (dfs(i, adj, isVisited, new boolean[v])) return true;
            }
        }

        return false;
    }

    private static boolean dfs(int node, List<List<Integer>> adj, boolean[] isVisited, boolean[] pathVisited) {
        if (pathVisited[node]) return true;
        if (isVisited[node]) return false;

        isVisited[node] = true;
        pathVisited[node] = true;

        for (int i : adj.get(node)) {
            if (dfs(i, adj, isVisited, pathVisited)) return true;
        }

        pathVisited[node] = false;
        return false;
    }
}
