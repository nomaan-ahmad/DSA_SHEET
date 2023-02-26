package Graph.problems;

// https://leetcode.com/problems/surrounded-regions/
public class SurroundedRegions {
    public static void main(String[] args) {
        char[][] b = {{'X','X','X','X'}, {'X','O','O','X'}, {'X','X','O','X'}, {'X','O','X','X'}};
        solve(b);
    }

    public static void solve(char[][] board) {
        final int n = board.length;
        final int m = board[0].length;

        if (n < 3 || m < 3) return;

        // first row
        for (int i = 0; i < m; i++)
            dfs(0, i, board);

        // last row
        for (int i = 0; i < m; i++)
            dfs(n-1, i, board);

        // first column
        for (int i = 0; i < n; i++)
            dfs(i, 0, board);

        // last column
        for (int i = 0; i < n; i++)
            dfs(i, m-1, board);


        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                if (board[i][j] == 'A') board[i][j] = 'O';
            }
    }

    private static void dfs(int x, int y, char[][] board) {
        if (x >= 0 && x < board.length && y >= 0 && y < board[0].length && board[x][y] == 'O') {
            board[x][y] = 'A';

            dfs(x + 1, y, board);
            dfs(x - 1, y, board);
            dfs(x, y + 1, board);
            dfs(x, y - 1, board);
        }
    }
}
