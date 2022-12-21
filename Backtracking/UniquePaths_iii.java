// https://leetcode.com/problems/unique-paths-iii/

public class UniquePaths_iii {

    public int uniquePathsIII(int[][] grid) {
        int[] total = {0};

        int count = 0;
        int row = 0;
        int col = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == 1){
                    row = i;
                    col = j;
                }
                if (grid[i][j] == -1) count++;
            }
        }

        count = (grid.length*grid[0].length) - count;

        return travel(grid, new boolean[grid.length][grid[0].length], total, row, col, count);
    }

    /*
     * In this solution we have used additional boolean matrix to track which point is part of our current path
     * 
     * "Instead we can also solve it without using auxiliary space by using a logic which says:
     * if we visit any node then we'll mark it -2 in the given matrix itself
     * and while backtracking we can restore its value to 0"
     * 
     */
    private int travel (int[][] grid, boolean[][] isVisited, int[] totalVisited, int i, int j, int count) {
        if (i >= grid.length || i < 0|| j >= grid[0].length || j < 0 || isVisited[i][j] || grid[i][j] == -1) return 0;

        totalVisited[0]++;
        isVisited[i][j] = true;

        if (grid[i][j] == 2) {
            isVisited[i][j] = false;
            if (totalVisited[0] == count) {
                totalVisited[0]--;
                return 1;
            }
            totalVisited[0]--;
            return 0;
        }

        int top = travel(grid, isVisited, totalVisited, i-1, j, count);// top
        int bottom = travel(grid, isVisited, totalVisited, i+1, j, count);// bottom
        int left = travel(grid, isVisited, totalVisited, i, j-1, count);// left
        int right = travel(grid,  isVisited, totalVisited, i, j+1, count);// right

        totalVisited[0]--;
        isVisited[i][j] = false;

        return top + bottom + left + right;
    }
}
