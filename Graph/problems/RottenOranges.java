package Graph.problems;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/rotting-oranges/
public class RottenOranges {
    /*
        This is a classic breadth-first search problem where we have given a grid with 3 possible values
        0 -> empty basket
        1 -> basket with fresh oranges
        2 -> basket with rotten oranges
        
        And we have to tell minimum number of time when all basket containing fresh oranges will turn rotten.
        Condition when fresh oranges will turn rotten is when there is rotten oranges basket in its neighbour.
        
        Neighbour is when the basket is at its left, right, top or bottom.
     */
    /*
        We will solve this problem using breadth first search approach, this approach will make sure that we are
        traversing grid by going through each neighbours of rotten basket and making it rotten too in the process.
     */
    private static class Pair {
        int x;
        int y;

        Pair(int _x, int _y) {
            x = _x;
            y = _y;
        }
    }
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<Pair> q = new LinkedList<>();

        boolean freshPresent = false;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++){
                if (grid[i][j] == 2) q.add(new Pair(i, j));
                if(grid[i][j] == 1) freshPresent = true;
            }

        // if queue is empty it means there is no rotten oranges basket
        if (q.isEmpty()) {
            // if there is any basket with fresh oranges then it means that it is not possible to rot it, hence return -1
            // otherwise return 0
            return (freshPresent) ? -1 : 0;
        }

        int count = -1;

        while (!q.isEmpty()) {
            int len = q.size();

            for (int i = 0; i < len; i++) {
                Pair temp = q.poll();
                int x = temp.x;
                int y = temp.y;

                // top
                if ((x-1) >= 0 && grid[x-1][y] == 1){
                    grid[x-1][y] = 2;
                    q.add(new Pair(x-1, y));
                }

                // right
                if ((y+1) < m && grid[x][y+1] == 1){
                    grid[x][y+1] = 2;
                    q.add(new Pair(x, y+1));
                }

                // down
                if ((x+1) < n && grid[x+1][y] == 1){
                    grid[x+1][y] = 2;
                    q.add(new Pair(x+1, y));
                }

                // left
                if ((y-1) >= 0 && grid[x][y-1] == 1){
                    grid[x][y-1] = 2;
                    q.add(new Pair(x, y-1));
                }
            }
            count++;
        }

        // if there is any basket with fresh oranges left then we'll return -1, because it is not possible to rot all oranges.
        for (int[] ints : grid)
            for (int num : ints)
                if (num == 1) return -1;

        return count;
    }
}
