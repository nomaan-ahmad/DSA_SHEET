// https://leetcode.com/problems/unique-paths/

import java.util.Arrays;

public class UniquePaths {
    public static void main(String[] args) {
        int m = 3, n = 7;
        System.out.println(uniquePaths(m,n));
    }
    static int[][] dp;
    public static int uniquePaths(int m, int n) {
        dp = new int[m][n];
        for (int[] d : dp)
            Arrays.fill(d, -1);

        return dfs(0,0,m,n);
    }

    private static int dfs (int i, int j, int rows, int cols) {
        if (i >= rows || j >= cols) return 0;
        if (i == rows-1 && j == cols-1) return 1;
        if (dp[i][j] != -1) return dp[i][j];

        int total = dfs(i+1, j, rows, cols) + dfs(i, j+1, rows, cols);
        dp[i][j] = total;
        return total;
    }
}