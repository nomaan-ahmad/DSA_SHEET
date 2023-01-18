package Graph.representation;

import java.util.List;

public class AdjacencyMatrix {
    // let's suppose we have been given 4 arguments,
    /*
        1. no. of vertices/nodes, N
        2. list of edges connecting 2 nodes (x,y), E
     */
    // now we have to make adjacency matrix out of it.

    public static int[][] createAdjacencyMatrix(int n, List<List<Integer>> E) {
        int[][] mat = new int[n+1][n+1];
        // no matter the indexing format, whether 0-based or 1-based. Always make square matrix of (n+1) size


        // if the graph is undirected then if there is an edge from (0,1)
        // then we have to assume that there is an edge from (1,0)
        for (List<Integer> li : E) {
            mat[li.get(0)][li.get(1)] = 1;
            mat[li.get(1)][li.get(0)] = 1; // for directed graph we'll not write this statement
        }

        return mat;
    }
}
