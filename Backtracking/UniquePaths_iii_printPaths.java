import java.util.ArrayList;
import java.util.List;

/*
        You are given an m x n integer array grid where grid[i][j] could be:

        1 representing the starting square. There is exactly one starting square.
        2 representing the ending square. There is exactly one ending square.
        0 representing empty squares we can walk over.
        -1 representing obstacles that we cannot walk over.

        Return all possible path including (x,y) coordinates of 4-directional walks from the
        starting square to the ending square, that walk over every non-obstacle square exactly once.
 */

/* -------------------------------------------------------------------------------------------------------- */

/*
    This question is same as LeetCode "UniquePaths iii" but here we are actually printing every unique
    path abiding with the constraint given in the problem
 */

public class UniquePaths_iii_printPaths {
    public static void main(String[] args) {
        int[][] grid = {
                {1,0,0,0},
                {0,0,0,0},
                {0,0,2,-1}
        };
        uniquePathsIII(grid);
    }
    public static void uniquePathsIII(int[][] grid) {
        List<List<Position>> allPossiblePath = new ArrayList<>();

        // search for starting position
        int row = 0;
        int col = 0;
        int count = 0;
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    row = i;
                    col = j;
                }
                if (grid[i][j] == -1) count++;
            }

        count = (grid.length * grid[0].length) - count;
        travel(grid, allPossiblePath, new ArrayList<>(), new boolean[grid.length][grid[0].length], row, col, count);

        for (List<Position> paths : allPossiblePath)
            System.out.println(paths);
    }

    private static class Position{
        int x;
        int y;

        Position(int _x, int _y) {
            x = _x;
            y = _y;
        }

        @Override
        public String toString() {
            return "[" + x + ", " + y + "]";
        }
    }
    private static void travel (int[][] grid, List<List<Position>> res, List<Position> path, boolean[][] isVisited, int i, int j, int count) {
        if (i >= grid.length || i < 0|| j >= grid[0].length || j < 0 || isVisited[i][j] || grid[i][j] == -1) return;

        path.add(new Position(i,j));
        int size = path.size();
        isVisited[i][j] = true;

        if (grid[i][j] == 2) {
            if (path.size() == count) {
                res.add(new ArrayList<>(path));
            }
            path.remove(size-1);
            isVisited[i][j] = false;
            return;
        }

        travel(grid, res, path, isVisited, i-1, j, count);// top
        travel(grid, res, path, isVisited, i+1, j, count);// bottom
        travel(grid, res, path, isVisited, i, j-1, count);// left
        travel(grid, res, path, isVisited, i, j+1, count);// right

        path.remove(size-1);
        isVisited[i][j] = false;
    }
}