package Graph.problems;

import java.util.*;

// https://www.hackerearth.com/problem/algorithm/connected-components-in-a-graph/
public class ConnectedComponents {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int e = sc.nextInt();

        // creating adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++)
            adj.add(new ArrayList<>());

        for (int i = 0; i < e; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        boolean[] isVisited = new boolean[n+1];
        int component = 0;

        for (int i = 1; i <= n; i++) {
            if (!isVisited[i]) {
                component++;
                dfs(i, adj, isVisited);
            }
        }

        System.out.println(component);

        sc.close();
    }

    private static void dfs(int n, List<List<Integer>> adj, boolean[] isVisited) {
        if (isVisited[n]) return;
        isVisited[n] = true;
        for (int i : adj.get(n)) dfs(i, adj, isVisited);
    }
}
