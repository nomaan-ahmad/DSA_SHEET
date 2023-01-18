package Graph.traversal;

import Graph.representation.AdjacencyMatrix;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class DFS_Recursive {
    /*
        Recursive DFS of graph is just like DFS in tree, but with a catch. Here we are going to use boolean isVisited
        array to track nodes which we already visited, so that we'll not loop indefinitely because of presence of cycle
     */


    // Here I am using adjacent matrix to represent graph, for iterative DFS I'll use adjacency list
    private static List<Integer> DFS(int v, int[][] adjMat) {
        List<Integer> res = new ArrayList<>();
        boolean[] isVisited = new boolean[v+1];


        // if graph is 0-indexing then i = 0, otherwise loop will start from i = 1
        // the reason, I included below loop because of unconnected component if present in graph
        // we'll call DFS from every unconnected component, so that we'll traverse every point in graph
        for (int i = 0; i <= v; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                traversal(i, adjMat, isVisited, res);
            }
        }

        return res;
    }

    private static void traversal(int node, int[][] adjMat, boolean[] isVisited, List<Integer> res) {
        isVisited[node] = true; // marking it visited
        res.add(node); // storing it in resultant DFS list

        for (int i = 0; i < adjMat.length; i++) {
            if (adjMat[node][i] == 1 && !isVisited[i]) {
                traversal(i, adjMat, isVisited, res);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int e = Integer.parseInt(br.readLine());
        List<List<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < e; i++) {
            List<Integer> temp = new ArrayList<>();
            String input = br.readLine();
            String[] in = input.split(" ");
            temp.add(Integer.parseInt(in[0]));
            temp.add(Integer.parseInt(in[1]));

            edges.add(temp);
        }

        int[][] mat = AdjacencyMatrix.createAdjacencyMatrix(n, edges);
        System.out.println(DFS(n, mat));
    }
}
