package Graph.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://practice.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1
public class DFS_Graph {
    public static void main(String[] args) {
        Integer[][] arr = {{2,3,1},{0},{0,4},{0}, {2}};
        int v = 5;
        
        List<List<Integer>> adj = new ArrayList<>();
        for (Integer[] ar : arr) adj.add(Arrays.asList(ar));

        System.out.println(dfsOfGraph(v, adj));
    }
    public static ArrayList<Integer> dfsOfGraph(int V, List<List<Integer>> adj) {
        boolean[] isVisited = new boolean[V];
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < V; i++)
            dfs(i, adj, isVisited, res);
        return res;
    }

    private static void dfs(int node, List<List<Integer>> adj, boolean[] isVisited, List<Integer> res) {
        if (isVisited[node]) return;

        res.add(node);
        isVisited[node] = true;

        for (int i : adj.get(node)) dfs(i, adj, isVisited, res);
    }
}

