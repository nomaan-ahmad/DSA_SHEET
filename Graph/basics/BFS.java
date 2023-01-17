package Graph.basics;

import Graph.representation.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://practice.geeksforgeeks.org/batch/dsa-4/track/DSASP-Graph/problem/bfs-traversal-of-graph
public class BFS {
    // BFS in graph is same as BFS in tree, difference is just in order to prevent our code to
    // loop indefinitely in cycle if present in graph then we use a boolean array to represent visited node
    public static List<Integer> bfsOfGraph(int V, List<List<Integer>> E) {
        List<List<Integer>> adjList = new AdjacencyList().createAdjacencyList(V, E);
        boolean[] isVisited = new boolean[V+1];
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        isVisited[1] = true;

        List<Integer> res = new ArrayList<>();
        while (!q.isEmpty()) {
            int temp = q.poll();
            for (int i : adjList.get(temp))
                if (!isVisited[i]) {
                    isVisited[i] = true;
                    q.add(i);
                }

            res.add(temp);
        }
        return res;
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

        System.out.println(bfsOfGraph(n, edges));
    }
}
