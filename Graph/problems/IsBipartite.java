package Graph.problems;

// https://leetcode.com/problems/is-graph-bipartite/

public class IsBipartite {

    public static void main(String[] args) {
        int[][] g = {{1,2,3},{0,2},{0,1,3},{0,2}};

        System.out.println(isBipartite(g));
    }

    public static boolean isBipartite(int[][] graph) {
        final int v = graph.length;
        if (v <= 2) return true;

        char[] color = new char[v];

        for (int i = 0; i < v+1; i++)
            if (color[i] == 0) {
                if (!dfs(i, graph, color, 'r')) return false;
            }

        return true;
    }

    @SuppressWarnings("BooleanMethodIsAlwaysInverted")
    private static boolean dfs(int node, int[][] graph, char[] color, char ch) {
        if (color[node] != 0) return color[node] == ch;
        else {
            color[node] = ch;
            
            for (int i : graph[node])
                if (!dfs(i, graph, color, (ch == 'r') ? 'b' : 'r')) return false;
        }

        return true;
    }
}
