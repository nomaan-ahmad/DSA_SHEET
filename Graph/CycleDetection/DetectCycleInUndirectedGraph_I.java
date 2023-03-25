// https://practice.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1
import java.util.*;

/***************************** BFS ******************************************/

public class DetectCycleInUndirectedGraph_I {
    // I'll use BFS to find cycle in a graph in this problem
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
            for (int i = 0; i < n+1; i++) {
                adjList.add(new ArrayList<>());
            }

            for (int[] ed : edges) {
                adjList.get(ed[0]).add(ed[1]);
                adjList.get(ed[1]).add(ed[0]);
            }

            System.out.println(cyclePresent(adjList, n));
        }
    }

    private static class Pair{
        int node;
        int parent;
        Pair(int _node, int _parent) {
            node = _node;
            parent = _parent;
        }
    }

    private static boolean cyclePresent(List<List<Integer>> adjList, int v) {
        HashSet<Integer> isVisited = new HashSet<>();

        for (int i = 0; i <= v; i++) {
            if (!isVisited.contains(i)) {
                Queue<Pair> q = new LinkedList<>();
                q.add(new Pair(i,-1));
                isVisited.add(i);

                while (!q.isEmpty()) {
                    Pair temp = q.poll();

                    for (int n : adjList.get(temp.node)) {
                        if (n == temp.parent) continue;

                        if (isVisited.contains(n)) return true;
                        else {
                            q.add(new Pair(n, temp.node));
                            isVisited.add(n);
                        }
                    }
                }
            }
        }

        return false;
    }
}
