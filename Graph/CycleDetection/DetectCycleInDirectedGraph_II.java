import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// https://practice.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1

public class DetectCycleInDirectedGraph_II {
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

            System.out.println(cycleCheck(adjList, n));
        }
    }

    private static boolean cycleCheck(List<List<Integer>> adj, int v) {
        int[] isVisited = new int[v];

        for (int i = 0; i < v; i++) {
            if (isVisited[i] == 0) {
                if (dfs(i, adj, isVisited)) return true;
            }
        }

        return false;
    }

    private static boolean dfs(int node, List<List<Integer>> adj, int[] isVisited) {
        if (isVisited[node] == 1) return true;
        if (isVisited[node] == 2) return false;

        isVisited[node] = 1;

        for (int i : adj.get(node)) {
            if (dfs(i, adj, isVisited)) return true;
        }

        isVisited[node] = 2;
        return false;
    }
}
