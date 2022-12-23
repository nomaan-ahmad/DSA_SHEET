// print all possible combination of queens in a board of size N X N

public class NQueens {
    public static void main(String[] args) {
        int N = 7;
        possibleNQueens(N, new int[N][N], 0);
    }

    private static void possibleNQueens(int N, int[][] board, int iter) {
        if (iter == N) {
            for (int[] b : board) {
                for (int ele : b)
                    System.out.print(ele + " ");

                System.out.println();
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < N ; i++) {
            if (isPossible(board, iter, i)) {
                board[iter][i] = 1;
                possibleNQueens(N, board, iter+1);
                board[iter][i] = 0;
            }
        }
    }

    private static boolean isPossible(int[][] board, int row, int col) {

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
