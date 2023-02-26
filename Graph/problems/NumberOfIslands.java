package Graph.problems;

// https://leetcode.com/problems/number-of-islands/
public class NumberOfIslands {
    final static int[][] directions = {{0,1}, {0,-1}, {1,0},{-1,0}};
    public int numIslands(char[][] grid) {
        final int n = grid.length;
        final int m = grid[0].length;

        boolean[][] isVisited = new boolean[n][m];
        int components = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!isVisited[i][j] && grid[i][j] == '1') {
                    components++;
                    dfs(i, j, grid, isVisited);
                }
            }
        }
        return components;
    }

    private void dfs(int x, int y, char[][] grid, boolean[][] isVisited) {
        if (!isValid(x, y, grid.length, grid[0].length) || grid[x][y] == '0' || isVisited[x][y]) return;

        isVisited[x][y] = true;
        for (int[] d : directions)
            dfs(x + d[0], y + d[1], grid, isVisited);
    }

    private boolean isValid(int x, int y, int n, int m) {
        return (x >= 0 && x < n) && (y >= 0 && y < m);
    }
}
