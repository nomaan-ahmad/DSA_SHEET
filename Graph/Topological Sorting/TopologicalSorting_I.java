// Topological sorting using DFS

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/*
* Before applying this logic, check if graph is acyclic or not. If it is not then proceed with this logic
*/

// https://practice.geeksforgeeks.org/problems/topological-sort/1

public class TopologicalSorting_I {
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
        boolean[] isVisited = new boolean[v];

        for (int i = 0; i < v; i++) {
            if (!isVisited[i]) dfs(i, isVisited, adj, res);
        }

        Collections.reverse(res);
        return res;
    }

    private static void dfs(int node, boolean[] isVisited, List<List<Integer>> adj, List<Integer> res) {
        if (isVisited[node]) return;

        isVisited[node] = true;

        for (int i : adj.get(node)) {
            dfs(i, isVisited, adj, res);
        }

        res.add(node);
    }
}
