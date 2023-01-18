package Graph.representation;

import java.util.ArrayList;
import java.util.List;

public class AdjacencyList {
    public static List<List<Integer>> createAdjacencyList(int n, List<List<Integer>> E) {
        List<List<Integer>> adjList = new ArrayList<>();

        // initialise n list with null
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }

        // now start filling list with edges which corresponds to the vertices
        // here we are making for undirected graph
        for (List<Integer> li : E) {
            adjList.get(li.get(0)).add(li.get(1));
            adjList.get(li.get(1)).add(li.get(0)); // for directed graph we'll not write this statement
        }

        return adjList;
    }
}