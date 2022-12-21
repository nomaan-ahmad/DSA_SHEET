// https://leetcode.com/problems/n-queens-ii/

public class N_Queens_ii {
    public int totalNQueens(int n) {
        return possibleCount(n, 0, new int[n][n]);
    }

    private int possibleCount (int N, int iter, int[][] board) {
        if (iter == N) return 1;

        int count = 0;
        for (int i = 0; i < N; i++) {
            if (isPossible(board, iter, i)) {
                board[iter][i] = 1;
                count += possibleCount(N, iter+1, board);
                board[iter][i] = 0;
            }
        }
        return count;
    }

    private boolean isPossible(int[][] board, int row, int col) {

        // checking straight top
        for (int i = row; i >= 0; i--)
            if (board[i][col] == 1) return false;

        // checking primary diagonal
        for (int i = row, j = col; i >=0 && j >= 0 ; i--, j--)
            if (board[i][j] == 1) return false;

        // checking secondary diagonal
        for (int i = row, j = col; i >= 0 && j < board.length; i--, j++)
            if (board[i][j] == 1) return false;

        return true;
    }
}
