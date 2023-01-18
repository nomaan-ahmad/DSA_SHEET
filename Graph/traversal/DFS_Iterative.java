package Graph.traversal;

import Graph.representation.AdjacencyList;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DFS_Iterative {
    public static List<Integer> DFS(int v, List<List<Integer>> adjList) {
        List<Integer> res = new ArrayList<>();
        boolean[] isVisited = new boolean[v+1];

        // this loop is to include all disconnected components in the graph
        for (int i = 0; i <= v; i++) {

            // we'll only traverse the node in the graph if it is not traversed earlier
            if (!isVisited[i]) {
                Stack<Integer> stk = new Stack<>();
                stk.push(i);
                isVisited[i] = true;
                
                // pushing all nodes of subtrees whose parent is "i"
                while (!stk.isEmpty()) {
                    int temp = stk.pop();
                    isVisited[temp] = true;
                    for (int node : adjList.get(temp)) {
                        if (!isVisited[node]) stk.push(node);
                    }
                    res.add(temp);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) throws Exception{
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

        List<List<Integer>> adjList = AdjacencyList.createAdjacencyList(n, edges);

        System.out.println(DFS(n, adjList));
    }
}
