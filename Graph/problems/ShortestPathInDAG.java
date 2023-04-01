import java.util.*;

// https://practice.geeksforgeeks.org/problems/shortest-path-in-undirected-graph/1
// total time taken : 0.22

/*
* To solve this problem, I've used simple BFS without isVisited array because I know there will be no cycle
* as given graph is DAG (Directed Acyclic Graph)*/
public class ShortestPathInDAG {
    public static void main(String[] args) {
        int n = 6, m = 7;
        int[][] edges = {{0,1,2},{0,4,1},{4,5,4},{4,2,2},{1,2,3},{2,3,6},{5,3,1}};

        System.out.println(Arrays.toString(shortestPath(n,m,edges)));
    }

    private static class Pair {
        int node;
        int dist;
        Pair(int _node, int _dist) {
            node = _node;
            dist = _dist;
        }
    }
    public static int[] shortestPath(int N,int M, int[][] edges) {
        int[] res = new int[N];
        Arrays.fill(res, -1);

        // creating adjacency list
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < N; i++) adj.add(new ArrayList<>());
        for (int[] e : edges) adj.get(e[0]).add(new Pair(e[1], e[2]));

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, 0));

        while (!q.isEmpty()) {
            Pair temp = q.poll();
            if (res[temp.node] == -1) res[temp.node] = temp.dist;
            else if (res[temp.node] > temp.dist) res[temp.node] = temp.dist;
            else continue; // little trick over here

            /* If I see any node which is visited but current path is distance than already distance present in res array
            then I'll just ignore it by not putting it into queue
            */

            for (Pair p : adj.get(temp.node)) {
                q.add(new Pair(p.node, p.dist + temp.dist));
            }
        }

        return res;
    }
}
