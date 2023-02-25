package Graph.problems;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/01-matrix/description/
public class _01_Matrix {

    // All possible moves in each direction
    final int[][] moves = {{0,1}, {0,-1}, {1,0}, {-1,0}};

    // global variable pow
    int pow;

    // code logic
    public int[][] updateMatrix(int[][] mat) {
        final int n = mat.length;
        final int m = mat[0].length;

        // maax number of digits in col number
        int d = (int) Math.floor(Math.log10(m)) + 1;

        // finding power of 10 of d
        pow = (int) Math.pow(10,d);

        // isVisited array to keep track of visited node
        boolean[][] isVisited = new boolean[n][m];

        // Queue for BFS
        Queue<Integer> q = new LinkedList<>();

        // putting all cell with value 0 in queue to treat them as source
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    isVisited[i][j] = true;
                    q.add((i*pow) + j);
                }
            }

        // level of DFS tracker
        int level = 0;

        // BFS logic
        while (!q.isEmpty()) {
            // counting size to know number of nodes at current instance
            int size = q.size();

            // running loop for size times
            for (int i = 0; i < size; i++) {

                // popping element out
                int temp = q.poll();

                // putting its valid neighbour in queue if it is not yet visited
                for (int[] move : moves) {

                    // extracting row and col number using pow trick
                    int x = (temp / pow) + move[0];
                    int y = (temp % pow) + move[1];

                    // checking condition for putting cell into queue
                    if (possible(x,y,n,m) && !isVisited[x][y]) {
                        // marking cell as visited and putting it into queue
                        isVisited[x][y] = true;
                        q.add((x*pow) + y);

                        // updating level into original array
                        mat[x][y] = level+1;
                    }
                }
            }

            // incrementing level
            level++;
        }
        return mat;
    }

    private boolean possible(int x, int y, int n, int m) {
        if (x < 0 || x >= n) return false;
        return y >= 0 && y < m;
    }
}
